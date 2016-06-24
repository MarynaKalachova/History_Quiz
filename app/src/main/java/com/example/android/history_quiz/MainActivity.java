package com.example.android.history_quiz;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int score;

    //  calls setMessage() and displayMessage methods to display the total score
    public void submitResult(View view) {
        int totalScore = countTotalScore();
        String scoreMessage = setMessage(totalScore);
        displayMessage(scoreMessage);
    }

    /*sets the toast message according to the score. If score is 1-3, it displays "Try again",
    if the score is 4-5 it congratulates user.*/
    private String setMessage(int score) {
        String message;
        if (score > 3) {
            message = "Your score is " + score + " out of 5. Congratulations!";
        } else {
            message = "Your score is " + score + " out of 5. Try again.";
        }
        return message;
    }

    //  counts total score according to the answered questions
    private int countTotalScore() {
        if (questionOneIsCorrect()) score++;
        if (questionTwoIsCorrect()) score++;
        if (questionThreeIsCorrect()) score++;
        if (questionFourIsCorrect()) score++;
        if (questionFiveIsCorrect()) score++;
        return score;
    }

    //    returns if user answered correctly question #1
    private boolean questionOneIsCorrect() {
        RadioButton ans1 = (RadioButton) findViewById(R.id.q1ans1_radio_button);
        boolean answer1 = ans1.isChecked();
        RadioButton ans2 = (RadioButton) findViewById(R.id.q1ans2_radio_button);
        boolean answer2 = ans2.isChecked();
        RadioButton ans3 = (RadioButton) findViewById(R.id.q1ans3_radio_button);
        boolean answer3 = ans3.isChecked();
        RadioButton ans4 = (RadioButton) findViewById(R.id.q1ans4_radio_button);
        boolean answer4 = ans4.isChecked();
        return answer1;
    }

    //    returns if user answered correctly question #2
    private boolean questionTwoIsCorrect() {
        RadioButton ans1 = (RadioButton) findViewById(R.id.q2ans1_radio_button);
        boolean answer1 = ans1.isChecked();
        RadioButton ans2 = (RadioButton) findViewById(R.id.q2ans2_radio_button);
        boolean answer2 = ans2.isChecked();
        RadioButton ans3 = (RadioButton) findViewById(R.id.q2ans3_radio_button);
        boolean answer3 = ans3.isChecked();
        RadioButton ans4 = (RadioButton) findViewById(R.id.q2ans4_radio_button);
        boolean answer4 = ans4.isChecked();
        return answer3;
    }

    //    returns if user answered correctly question #3
    private boolean questionThreeIsCorrect() {
        CheckBox ans1 = (CheckBox) findViewById(R.id.ans1_checkbox);
        boolean answer1 = ans1.isChecked();
        CheckBox ans2 = (CheckBox) findViewById(R.id.ans2_checkbox);
        boolean answer2 = ans2.isChecked();
        CheckBox ans3 = (CheckBox) findViewById(R.id.ans3_checkbox);
        boolean answer3 = ans3.isChecked();
        CheckBox ans4 = (CheckBox) findViewById(R.id.ans4_checkbox);
        boolean answer4 = ans4.isChecked();

        if (answer2 && answer4 && !answer1 && !answer3) return true;
        else return false;
    }

    //    returns if user answered correctly question #4
    private boolean questionFourIsCorrect() {
        TextView nameAnswer = (TextView) findViewById(R.id.name_view);
        String answer = nameAnswer.getText().toString();
        String correctAnswer = "Alexandra";
        if (answer.equalsIgnoreCase(correctAnswer)) return true;
        else return false;
    }

    //    returns if user answered correctly question #5
    private boolean questionFiveIsCorrect() {
        RadioButton ans1 = (RadioButton) findViewById(R.id.q5ans1_radio_button);
        boolean answer1 = ans1.isChecked();
        RadioButton ans2 = (RadioButton) findViewById(R.id.q5ans2_radio_button);
        boolean answer2 = ans2.isChecked();
        RadioButton ans3 = (RadioButton) findViewById(R.id.q5ans3_radio_button);
        boolean answer3 = ans3.isChecked();
        RadioButton ans4 = (RadioButton) findViewById(R.id.q5ans4_radio_button);
        boolean answer4 = ans4.isChecked();
        return answer2;
    }

    //    displays message on the screen
    private void displayMessage(String message) {
        TextView scoreSummaryTextView = (TextView) findViewById(R.id.score_summary_text_view);
        scoreSummaryTextView.setText(message);
    }
}
