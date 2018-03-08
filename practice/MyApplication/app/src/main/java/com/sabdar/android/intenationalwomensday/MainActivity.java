package com.sabdar.android.intenationalwomensday;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private TextView mLangTextView;
    private String[] mStringArray;
    private String[] mLangArray;
    private int mCount = 0;
    private int index = 0;
    private int timeToBlink =1000;
    private int changeText =1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.wishes_text);
        mLangTextView = findViewById(R.id.language_text);
        mStringArray = getResources().getStringArray(R.array.womens_day_wishes);
        mLangArray = getResources().getStringArray(R.array.languages_array);
        mCount = mStringArray.length;
        blink();

    }

    private void blink(){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                timeToBlink = 1000;                //in milissegunds
                try{Thread.sleep(timeToBlink);}catch (Exception e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(mTextView.getVisibility() == View.VISIBLE){
                            mTextView.setVisibility(View.INVISIBLE);
                            changeText += timeToBlink;
                            if(changeText % 3 == 0) {
                                if (index == mCount) {
                                    index = 0;
                                }
                                mTextView.setText(mStringArray[index].toString());
                                mLangTextView.setText(mLangArray[index].toString());
                                index++;
                            }
                        }else{

                            mTextView.setVisibility(View.VISIBLE);
                        }
                        blink();
                    }
                });
            }
        }).start();
    }
}
