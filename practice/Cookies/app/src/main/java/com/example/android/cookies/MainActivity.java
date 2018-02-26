package com.example.android.cookies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.status_text_view);
        imageView = findViewById(R.id.android_cookie_image_view);
    }

    public void eatCookie(View view){
        imageView.setImageResource(R.drawable.after_cookie);
        textView.setText(R.string.status_full_message);
    }
}
