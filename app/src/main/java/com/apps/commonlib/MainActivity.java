package com.apps.commonlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apps.library.utils.ApplicationUtil;
import com.apps.library.utils.LogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(ApplicationUtil.getAppName());
        setContentView(R.layout.activity_main);
    }
}
