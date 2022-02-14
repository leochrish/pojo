package com.emproto.pojo.pojo.components;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;

import com.emproto.pojo.databinding.CustomDialogTwoBinding;

public class DialogTwo extends Dialog {

    private String title, content;
    private Context context;
    private int titleColor, contentColor, titleTextColor, contentTextColor;
    private String id;

    CustomDialogTwoBinding dialogOneBinding;
    private OnDialogAction onDialogAction;

    public DialogTwo(String id, @NonNull Context context, OnDialogAction onDialogAction) {
        super(context);
        this.context = context;
        this.id = id;
        this.onDialogAction = onDialogAction;
    }

    public DialogTwo(String id, @NonNull Context context, String title, String content, OnDialogAction onDialogAction) {
        super(context);
        this.context = context;
        this.content = content;
        this.title = title;
        this.id = id;
        this.onDialogAction = onDialogAction;
    }

    public DialogTwo(String id, @NonNull Context context, String title, String content, int titleColor, int contentColor, OnDialogAction onDialogAction) {
        super(context);
        this.context = context;
        this.content = content;
        this.title = title;
        this.titleColor = titleColor;
        this.contentColor = contentColor;
        this.id = id;
        this.onDialogAction = onDialogAction;
    }

    public DialogTwo(String id, @NonNull Context context, String title, String content, int titleColor, int contentColor,
                     int titleTextColor, int contentTextColor, OnDialogAction onDialogAction) {
        super(context);
        this.context = context;
        this.content = content;
        this.title = title;
        this.titleColor = titleColor;
        this.contentColor = contentColor;
        this.titleTextColor = titleTextColor;
        this.contentTextColor = contentTextColor;
        this.onDialogAction = onDialogAction;
        this.id = id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogOneBinding = CustomDialogTwoBinding.inflate(getLayoutInflater());
        setContentView(dialogOneBinding.getRoot());
        dialogOneBinding.textViewContent.setText(content);
        dialogOneBinding.textViewTitle.setText(title);
        if (titleColor != 0) dialogOneBinding.textViewTitle.setBackgroundColor(titleColor);
        if (contentColor != 0) dialogOneBinding.textViewContent.setBackgroundColor(contentColor);
        if (titleTextColor != 0) dialogOneBinding.textViewTitle.setTextColor(titleTextColor);
        if (contentTextColor != 0) dialogOneBinding.textViewContent.setTextColor(contentTextColor);
        dialogOneBinding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDialogAction.onNext(id);
                cancel();
            }
        });
        dialogOneBinding.buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDialogAction.onPrevious(id);
                cancel();
            }
        });

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
