package com.emproto.pojo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.emproto.pojo.pojo.api.ApiDataSource;
import com.emproto.pojo.pojo.utility.PojoObserver;
import com.pointzi.Pointzi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pointzi.setUserId("leoni@emproto.com");
        PojoObserver pojoObserver = new PojoObserver(this);
    }
}