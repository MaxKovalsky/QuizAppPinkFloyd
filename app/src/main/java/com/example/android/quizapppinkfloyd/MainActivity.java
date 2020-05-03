 package com.example.android.quizapppinkfloyd;

 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.CheckBox;
 import android.widget.EditText;
 import android.widget.RadioButton;
 import android.widget.TextView;
 import android.widget.Toast;

 import static com.example.android.quizapppinkfloyd.R.id.pompei;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * After clicking on "show scores" you will be able to check the result.
     */

    public void showScore (View view) {

        CheckBox q1a1CheckBox = findViewById(R.id.q1a1);
        boolean  isQ1a1 = q1a1CheckBox.isChecked();

        CheckBox q1a2CheckBox = findViewById(R.id.q1a2);
        boolean  isQ1a2 = q1a2CheckBox.isChecked();

        CheckBox q1a3CheckBox = findViewById(R.id.q1a3);
        boolean  isQ1a3 = q1a3CheckBox.isChecked();

        RadioButton q2a3RadioButton = findViewById(R.id.q2a3);
        boolean isQ2a3 = q2a3RadioButton.isChecked();

        RadioButton q3a3RadioButton = findViewById(R.id.q3a3);
        boolean isQ3a3 = q3a3RadioButton.isChecked();

        RadioButton q4a2RadioButton = findViewById(R.id.q4a2);
        boolean isQ4a2 = q4a2RadioButton.isChecked();

        EditText yesEditText = findViewById(pompei);
        String userAnswer = yesEditText.getText().toString();

        int score = calculateScore(isQ1a1, isQ1a2, isQ1a3, isQ2a3, isQ3a3, isQ4a2, userAnswer);
        displayScore(score);
    }

    /**
     * We count the result.
     */

    private int calculateScore(boolean firstCorrectCheckForQ1,
                               boolean doNothingIfCheckForQ1,
                               boolean thirdCorrectCheckForQ1,
                               boolean addOnePointForQ2,
                               boolean addOnePointForQ3,
                               boolean addOnePointForQ4,
                               String userAnswer) {
        int initialResult = 0;

        if (firstCorrectCheckForQ1 && !doNothingIfCheckForQ1 && thirdCorrectCheckForQ1) {
            initialResult = initialResult + 1;
        }

        if (addOnePointForQ2) {
            initialResult = initialResult + 1;
        }

        if (addOnePointForQ3) {
            initialResult = initialResult + 1;
        }

        if (addOnePointForQ4) {
            initialResult = initialResult + 1;
        }

        if (userAnswer.equalsIgnoreCase("yes" ))  {
                initialResult = initialResult + 1;
            }
        return initialResult;
    }

    /**
     * We display the result.
     */

    private void displayScore(int scoreForPlayer){
        TextView scoreAfterQuiz = findViewById(R.id.final_score);
        if (scoreForPlayer == 5){
            Toast.makeText(getApplicationContext(),
                    "Congratulations! All answers are correct! ", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),
                    "Thank you! Your score is: " + scoreForPlayer , Toast.LENGTH_LONG).show();
        }
        scoreAfterQuiz.setText("" + scoreForPlayer);
    }

}