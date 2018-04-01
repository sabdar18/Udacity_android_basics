package com.sabdar.android.cleancodequiz.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sabdar.android.cleancodequiz.R;
import com.sabdar.android.cleancodequiz.pojo.Quiz;

import java.util.ArrayList;

public class QuizViewPagerFragmentAdapter extends FragmentStatePagerAdapter {
    public static ArrayList<Quiz> mQuestionsList;

    public QuizViewPagerFragmentAdapter(FragmentManager fm, ArrayList<Quiz> quizQuestions) {
        super(fm);
        mQuestionsList = quizQuestions;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment quizFragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putInt(QuizFragment.question, position);
        quizFragment.setArguments(args);
        return quizFragment;
    }

    @Override
    public int getCount() {
        return mQuestionsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(position+1);
    }

    public static class QuizFragment extends Fragment {
        public static final String question = "Question";
        private Quiz mQuizQuestion;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.item_quiz, container, false);
            Bundle args = getArguments();
            mQuizQuestion = mQuestionsList.get(args.getInt(question));
            TextView questionTextView = rootView.findViewById(R.id.quiz_question_tv);
            RadioButton optionA = rootView.findViewById(R.id.radioButtonA);
            RadioButton optionB = rootView.findViewById(R.id.radioButtonB);
            RadioButton optionC = rootView.findViewById(R.id.radioButtonC);
            RadioButton optionD = rootView.findViewById(R.id.radioButtonD);


            questionTextView.setText(mQuizQuestion.getQuestion());
            optionA.setText(mQuizQuestion.getOptionA());
            optionB.setText(mQuizQuestion.getOptionB());
            optionC.setText(mQuizQuestion.getOptionC());
            optionD.setText(mQuizQuestion.getOptionD());
            return rootView;
        }
    }
}


