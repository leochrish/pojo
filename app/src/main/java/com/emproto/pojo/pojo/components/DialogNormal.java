package com.emproto.pojo.pojo.components;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;

import com.emproto.pojo.databinding.CustomDialogOneBinding;

public class DialogNormal extends Dialog {

    private String title, content;
    private Context context;

    CustomDialogOneBinding dialogOneBinding;

    public DialogNormal(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public DialogNormal(@NonNull Context context, String title, String content) {
        super(context);
        this.context = context;
        this.content = content;
        this.title = title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogOneBinding = CustomDialogOneBinding.inflate(getLayoutInflater());
        setContentView(dialogOneBinding.getRoot());
        dialogOneBinding.textViewContent.setText(content);
        dialogOneBinding.textViewTitle.setText(title);
        dialogOneBinding.buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
