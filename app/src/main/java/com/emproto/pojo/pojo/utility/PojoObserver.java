package com.emproto.pojo.pojo.utility;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.emproto.pojo.R;
import com.emproto.pojo.pojo.api.ApiDataSource;
import com.emproto.pojo.pojo.components.OnDialogAction;
import com.emproto.pojo.pojo.customviews.ToolTipPopup;
import com.emproto.pojo.pojo.model.DataItem;
import com.emproto.pojo.pojo.model.ScreenResponse;
import com.emproto.pojo.pojo.model.ScreensRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PojoObserver implements OnDialogAction, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context context;
    private ViewGroup viewGroup;
    private List<View> viewsList;
    Dialog alertDialog;
    List<DataItem> screenModels;
    ApiDataSource apiDataSource;
    ToolTipPopup toolTipPopup;
    private final FloatingActionButton floatingActionButton;

    public PojoObserver(Context context) {
        this.context = context;
        apiDataSource = new ApiDataSource();
        screenModels = new ArrayList<>();
        floatingActionButton = new FloatingActionButton(context);
        floatingActionButton.setImageResource(R.drawable.ic_notification);
        floatingActionButton.setBackgroundColor(Color.BLUE);
        init();
    }

    private void init() {
        ((ViewGroup) ((Activity) context).findViewById(android.R.id.content)).getChildAt(0).getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public void start() {
        if (screenModels.size() > 0) {
            showDialog(screenModels.get(0));
        }
    }

    private List<String> addTag(List<View> views) {
        List<String> tags = new ArrayList<>();
        for (View view : views
        ) {
            if (view.getTag() == null) {
                view.setTag(getTag(view, "" + getViewCount(view)));
            }
            tags.add((String) view.getTag());
        }
        return tags;
    }

    private int getViewCount(View view) {
        int i = 0;
        for (int j = viewsList.size() - 1; j >= 0; j--) {
            if (view.getClass() == viewsList.get(j).getClass()) {
                i++;
            }
        }
        return i;
    }

    private String getTag(View view, String value) {
        View viewParent = view;
        StringBuilder valueBuilder = new StringBuilder(value);
        while (viewParent != null) {
            String[] values = viewParent.getClass().toString().split("\\.");
            if (values.length > 0) {
                valueBuilder.insert(0, values[values.length - 1] + "$");
            }
            if (viewParent.getParent() instanceof View)
                viewParent = (View) viewParent.getParent();
            else
                viewParent = null;
        }
        value = valueBuilder.toString();
        return value;
    }

    private ArrayList<View> getAllChildren(View v) {
        ArrayList<View> viewArrayList = new ArrayList<>();
        if (v instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewArrayList.addAll(getAllChildren(viewGroup.getChildAt(i)));
            }
        } else {
            viewArrayList.add(v);
        }
        return viewArrayList;
    }

    private void getScreens(List<String> tags) {
        ScreensRequest screensRequest = new ScreensRequest(tags);
        apiDataSource.getScreens(screensRequest)
                .subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribeWith(new DisposableSingleObserver<ScreenResponse>() {
                    @Override
                    public void onSuccess(@NonNull ScreenResponse screenResponse) {
                        screenModels.clear();
                        screenModels.addAll(screenResponse.getData());
                        if (screenModels.size() > 0) {
                            showDialog(screenModels.get(0));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("====>", "onError: " + e.getMessage());
                    }
                });
    }

    @Override
    public void onNext(String id) {
        if (getNextDialog(id, true) > -1 && getNextDialog(id, true) < screenModels.size()) {
            showDialog(screenModels.get(getNextDialog(id, true)));
        }
    }

    @Override
    public void onPrevious(String id) {
        if (getNextDialog(id, false) > -1 && getNextDialog(id, false) < screenModels.size()) {
            showDialog(screenModels.get(getNextDialog(id, false)));
        }
    }

    private int getNextDialog(String id, boolean onNext) {
        for (int i = 0; i < screenModels.size(); i++) {
            if (screenModels.get(i).getId().equals(id)) {
                return onNext ? i + 1 : i - 1;
            }
        }
        return -1;
    }

    private void showDialog(DataItem screenModel) {
        View view = viewGroup.findViewWithTag(screenModel.getViewTag());
        /*if (screenModel.getVariant() == 1) {
            alertDialog = new DialogNormal(context,
                    screenModel.getTitle(),
                    screenModel.getContent()
            );
        } else if (screenModel.getVariant() == 2) {
            alertDialog = new DialogTwo(screenModel.getId(), context,
                    screenModel.getTitle(),
                    screenModel.getContent(),
                    Color.parseColor(screenModel.getTitleColor()),
                    Color.parseColor(screenModel.getContentColor()),
                    Color.parseColor(screenModel.getTitleTextColor()),
                    Color.parseColor(screenModel.getContentTextColor()),
                    this
            );
        }*/
        if (view != null) {
            /*WindowManager.LayoutParams layoutParams = alertDialog.getWindow().getAttributes();
            layoutParams.x = (int) view.getX();
            layoutParams.y = (int) view.getY();*/
            toolTipPopup = new ToolTipPopup(context)
                    .setContentView(view)
                    .setId(screenModel.getId())
                    .setTitle(screenModel.getTitle())
                    .setContent(screenModel.getContent())
                    .setActionListener(this);
            toolTipPopup.show();
        }
        //alertDialog.show();
    }

    @Override
    public void onGlobalLayout() {
        viewGroup = (ViewGroup) ((ViewGroup) ((Activity) context).findViewById(android.R.id.content)).getChildAt(0);
        viewsList = getAllChildren(viewGroup);
        viewGroup.addView(floatingActionButton);
        floatingActionButton.setOnClickListener(view -> {
            getScreens(addTag(viewsList));
        });
        ((ViewGroup) ((Activity) context).findViewById(android.R.id.content)).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
