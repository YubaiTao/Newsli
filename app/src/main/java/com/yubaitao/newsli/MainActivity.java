package com.yubaitao.newsli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yubaitao.newsli.common.NSBasicActivity;

public class MainActivity extends NSBasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView view = findViewById(R.id.text);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showSnackBar(String message) {
        // super.showSnackBar(message);
    }
}
