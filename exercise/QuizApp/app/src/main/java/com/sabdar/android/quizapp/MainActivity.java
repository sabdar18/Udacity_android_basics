package com.sabdar.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText answerOneEditText;
    RadioGroup answerTwoRadioGroup;
    CheckBox answerThreeCheckBoxOne;
    CheckBox answerThreeCheckBoxTwo;
    CheckBox answerThreeCheckBoxThree;
    CheckBox answerThreeCheckBoxFour;
    EditText answerFourEditText;
    RadioGroup answerFiveRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerOneEditText = findViewById(R.id.text_answer_1);
        answerTwoRadioGroup = findViewById(R.id.radio_group_answer_2);
        answerThreeCheckBoxOne = findViewById(R.id.check_box_answer_3_a);
        answerThreeCheckBoxTwo = findViewById(R.id.check_box_answer_3_b);
        answerThreeCheckBoxThree = findViewById(R.id.check_box_answer_3_c);
        answerThreeCheckBoxFour = findViewById(R.id.check_box_answer_3_d);
        answerFourEditText = findViewById(R.id.text_answer_4);
        answerFiveRadioGroup = findViewById(R.id.radio_group_answer_5);


    }


    public void submitQuiz(View view) {
        int score = 0;
        int total = 5;

        String answer1 = answerOneEditText.getText().toString();
        if (answer1.equalsIgnoreCase(getString(R.string.answer_1))) {
            score += 1;
        }

        if (answerTwoRadioGroup.getCheckedRadioButtonId() == R.id.radio_answer_2_a) {
            score += 1;
        }

        if (answerThreeCheckBoxOne.isChecked() && answerThreeCheckBoxTwo.isChecked()) {
            score += 1;
        }

        String answer4 = answerFourEditText.getText().toString();
        if (answer4.equalsIgnoreCase(getString(R.string.answer_4))) {
            score += 1;
        }

        if (answerFiveRadioGroup.getCheckedRadioButtonId() == R.id.radio_answer_5_b) {
            score += 1;
        }


        Toast.makeText(this, getString(R.string.result_score_message, score, total), Toast.LENGTH_LONG).show();
        resetAnswers();
    }

    private void resetAnswers() {
        answerOneEditText.setText("");
        answerTwoRadioGroup.clearCheck();
        answerThreeCheckBoxOne.setChecked(false);
        answerThreeCheckBoxTwo.setChecked(false);
        answerThreeCheckBoxThree.setChecked(false);
        answerThreeCheckBoxFour.setChecked(false);
        answerFourEditText.setText("");
        answerFiveRadioGroup.clearCheck();
    }

}
