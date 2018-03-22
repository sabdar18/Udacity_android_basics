package com.sabdar.android.landingpage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button androidButton, iosButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidButton = findViewById(R.id.android_button);
        iosButton = findViewById(R.id.ios_button);

        androidButton.setOnClickListener(this);
        iosButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int buttonId = v.getId();

        switch (buttonId) {
            case R.id.ios_button:

                goToAppStore();
                break;

            case R.id.android_button:
                goToPlayStore();
                break;

            default:
                break;
        }
    }

    private void goToAppStore() {
        String iosUrl = "https://itunes.apple.com/us/app/id819700933";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(iosUrl)));
    }

    private void goToPlayStore() {
        String appPackageName = "com.udacity.android";
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException notFoundActivity) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }
}
