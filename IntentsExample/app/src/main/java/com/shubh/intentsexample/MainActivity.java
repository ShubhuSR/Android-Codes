package com.shubh.intentsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button dialPhone, toast, showLocation, webPage, viewIntent, letsGetPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialPhone = findViewById(R.id.btn_dialNum);
        toast = findViewById(R.id.btn_toast);
        showLocation = findViewById(R.id.btn_location);
        webPage = findViewById(R.id.btn_webPage);
        viewIntent = findViewById(R.id.btn_viewIntent);
        letsGetPro = findViewById(R.id.btn_pro);

        dialPhone.setOnClickListener(this);
        toast.setOnClickListener(this);
        webPage.setOnClickListener(this);
        showLocation.setOnClickListener(this);
        viewIntent.setOnClickListener(this);
        letsGetPro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_dialNum:
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"));
                startActivity(intent1);
                break;

            case R.id.btn_toast:
                Intent intent2 = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent2);
                break;

            case R.id.btn_location:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 18.9322, 72.8264"));
                startActivity(intent3);
                break;

            case R.id.btn_webPage:
                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Android_(operating_system)"));
                startActivity(intent4);
                break;

            case R.id.btn_viewIntent:
                Intent intent5 = new Intent(Intent.ACTION_VIEW);
                startActivity(intent5);
                break;

            case R.id.btn_pro:

                //call next activity by making changes in manifest file
                Intent intent6 = new Intent("com.shubh.intentexample.NewActivity");
                startActivity(intent6);

//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                startActivity(intent);
                break;

        }

    }
}
