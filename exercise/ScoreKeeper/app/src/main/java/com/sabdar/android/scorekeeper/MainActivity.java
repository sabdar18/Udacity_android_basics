package com.sabdar.android.scorekeeper;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Constants
     */
    private static final String SCORE_TEAM_A = "SCORE_TEAM_A";
    private static final String SCORE_TEAM_B = "SCORE_TEAM_B";
    /**
     * initialize variables, TextViews
     */
    int scoreTeamA =0;
    int scoreTeamB =0;
    private TextView mScoreViewTeamA;
    private TextView mScoreViewTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreViewTeamA = findViewById(R.id.team_a_score);
        mScoreViewTeamB = findViewById(R.id.team_b_score);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SCORE_TEAM_A,scoreTeamA);
        outState.putInt(SCORE_TEAM_B, scoreTeamB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt(SCORE_TEAM_A);
        scoreTeamB = savedInstanceState.getInt(SCORE_TEAM_B);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        mScoreViewTeamA.setText(String.valueOf(score));
        mScoreViewTeamA.setContentDescription(scorePointsText(R.string.team_a_score_desc,score));

    }



    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB+= 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        mScoreViewTeamB.setText(String.valueOf(score));
        mScoreViewTeamA.setContentDescription(scorePointsText(R.string.team_b_score_desc,score));
    }

    /**
     * reset scoreTeamA, scoreTeamB and display to zero
     */

    public void resetScore(View v){
        scoreTeamA =0;
        scoreTeamB =0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    private String scorePointsText(int pointsText, int score) {
        String scoreText = String.valueOf(score) ;
        if(score == 1){
            scoreText += "Point";
        }else{
            scoreText += "Points";
        }
        return getString(pointsText,scoreText);
    }

}
