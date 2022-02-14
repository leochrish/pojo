package com.emproto.pojo.pojo.customviews;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.emproto.pojo.R;
import com.emproto.pojo.pojo.components.OnDialogAction;

import org.jetbrains.annotations.NotNull;

public class ToolTipPopup extends View {
    private View contentView, rootView;
    private ConstraintLayout parent;
    private Context context;
    private ViewGroup viewGroup;
    private int topBarHeight = 0;
    DisplayMetrics displayMetrics;
    private TextView textViewTitle, textViewContent;
    private Button buttonPrevious, buttonNext;
    private OnDialogAction onDialogAction;
    private String id;

    public ToolTipPopup(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        rootView = inflate(context, R.layout.tool_tip_root_view, null);
        rootView.setOnClickListener(view -> {
            cancel();
        });
        displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        parent = rootView.findViewById(R.id.constraintLayoutToolTipHolder);
        textViewTitle = rootView.findViewById(R.id.textViewTitle);
        textViewContent = rootView.findViewById(R.id.textViewContent);
        buttonNext = rootView.findViewById(R.id.buttonNext);
        buttonPrevious = rootView.findViewById(R.id.buttonPrevious);
        buttonPrevious.setOnClickListener(view -> {
            if (onDialogAction != null) {
                onDialogAction.onPrevious(id);
                cancel();
            }
        });
        buttonNext.setOnClickListener(view -> {
            if (onDialogAction != null) {
                onDialogAction.onNext(id);
                cancel();
            }
        });
        viewGroup = (ViewGroup) ((Activity) context).findViewById(android.R.id.content).getRootView();
    }

    public ToolTipPopup setTitle(String title) {
        textViewTitle.setText(title);
        return this;
    }

    public ToolTipPopup setId(String id) {
        this.id = id;
        return this;
    }

    public ToolTipPopup setContent(String content) {
        textViewContent.setText(content);
        return this;
    }

    public ToolTipPopup setActionListener(OnDialogAction onDialogAction) {
        this.onDialogAction = onDialogAction;
        return this;
    }

    public ToolTipPopup setContentView(@NotNull View view) {

        Rect rectangle = new Rect();
        Window window = ((Activity) context).getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        topBarHeight = window.findViewById(Window.ID_ANDROID_CONTENT).getTop() + rectangle.top;

        this.contentView = view;
        parent.setX(view.getX());
        parent.setY(view.getY() + topBarHeight);
        parent.setVisibility(INVISIBLE);
        parent.findViewById(R.id.imageViewTop).setVisibility(canShowOnTop(view) ? GONE : VISIBLE);
        parent.findViewById(R.id.imageViewBottom).setVisibility(canShowOnTop(view) ? VISIBLE : GONE);
        parent.post(new Runnable() {
            @Override
            public void run() {
                parent.setX(getX(view) < 0 ? 0 : getX(view) + parent.getWidth() > displayMetrics.widthPixels ? displayMetrics.widthPixels - parent.getWidth() : getX(view));
                parent.setY(getY(view));
                parent.setVisibility(VISIBLE);
            }
        });
        return this;
    }

    private float getY(View view) {
        if (canShowOnTop(view)) {
            return (view.getY() + topBarHeight) - parent.getHeight();
        } else {
            return (view.getY() + topBarHeight) + view.getHeight();
        }
    }

    private float getX(View view) {
        if (view.getWidth() < parent.getWidth()) {
            if ((view.getX() + parent.getWidth() - (Math.abs(view.getWidth() - parent.getWidth())) / 2f) > displayMetrics.widthPixels) {
                return view.getX() - ((view.getX() + parent.getWidth()) - displayMetrics.widthPixels);
            } else {
                return view.getX() - (Math.abs(view.getWidth() - parent.getWidth()) / 2f);
            }
        } else {
            return view.getX() + view.getWidth() / 2f - parent.getWidth() / 2f;
        }
    }

    private boolean canShowOnTop(View view) {
        return (displayMetrics.heightPixels / 2f) < (view.getY() + (view.getHeight() / 2f));
    }

    public void show() {
        setLayoutParams(new ViewGroup.LayoutParams((int) contentView.getX(), (int) contentView.getY()));
        viewGroup.addView(rootView);
    }

    public void cancel() {
        viewGroup.removeView(rootView);
    }
}
