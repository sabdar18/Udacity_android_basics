package com.example.android.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  static final  String  ACTIVITY_NAME = MainActivity.class.getSimpleName();

    private TextView logOne;
    private TextView logTwo;
    private TextView logThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logOne = findViewById(R.id.menu_item_1);
        logTwo = findViewById(R.id.menu_item_2);
        logThree = findViewById(R.id.menu_item_3);
    }

    public void printToLogs(View view){
        String menuItem1 = logOne.getText().toString();
        String menuItem2 = logTwo.getText().toString();
        String menuItem3 = logThree.getText().toString();
        Log.v(ACTIVITY_NAME,menuItem1);
        Log.v(ACTIVITY_NAME,menuItem2);
        Log.v(ACTIVITY_NAME,menuItem3);
    }
}
