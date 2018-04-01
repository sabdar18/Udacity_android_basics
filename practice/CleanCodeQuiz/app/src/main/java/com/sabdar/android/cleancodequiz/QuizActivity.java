package com.sabdar.android.cleancodequiz;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sabdar.android.cleancodequiz.adapters.QuizViewPagerFragmentAdapter;
import com.sabdar.android.cleancodequiz.pojo.Quiz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends FragmentActivity {

    private QuizViewPagerFragmentAdapter mQuizViewPagerFragmentAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ArrayList<Quiz> quizQuestions = initQuestions();
        mQuizViewPagerFragmentAdapter = new QuizViewPagerFragmentAdapter(getSupportFragmentManager(),quizQuestions);
        mViewPager = findViewById(R.id.viewPager);
        mViewPager.setAdapter(mQuizViewPagerFragmentAdapter);
    }

    /**
     * Initialize the list of questions
     *
     * @return questionList
     */
    private ArrayList<Quiz> initQuestions() {
        ArrayList<Quiz> questionList = new ArrayList<>();
        questionList.add(new Quiz(1, "'OS' computer abbreviation usually means ", "Open Software", "Operating System", "Open Source", "Optional Software", "", "B"));
        questionList.add(new Quiz(2, "How many bits is a byte?", "4", "8", "16", "32", "", "B"));
        questionList.add(new Quiz(3, "Which of the following is not a programming language?", "Basic", "Java", "Turing", "C#", "", "C"));
        questionList.add(new Quiz(4, "What is a GPU?", "Grouped Processing Unit", "Graphical Performance Utility", "Graphical Portable Unit", "Graphics Processing Unit", "", "D"));
        questionList.add(new Quiz(5, "Which one of the following is a search engine?", "Google", "Netscape", "Librarians’ Index to the Internet", "Macromedia Flash", "", "A"));
        questionList.add(new Quiz(6, "What does SSL stand for", "Secure System Login", "System Socket Layer", "Secure Socket Layer", "Superuser System Login", "", "C"));
        questionList.add(new Quiz(7, "Which of the following is the correct way to initialize a new Git repository?", "git add .", "git init", "git commit", "git checkout", "", "B"));
        questionList.add(new Quiz(8, "We've just created a new file called index.html. Which of the following will stage this one file so we can commit it?", "git add index.html", "git add new", "git commit index.html", "git checkout index.html", "", "A"));
        questionList.add(new Quiz(9, "Which of the following commands will stage your entire directory and every non-empty directory inside your current directory?", "git status all", "git checkout all", "git commit all", "git add .", "", "D"));
        return questionList;
    }


}
