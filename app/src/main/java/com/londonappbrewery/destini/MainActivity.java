package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    TextView storyTextView;
    Button storyAnswerButton1;
    Button storyAnswerButton2;
    Story[] stories;
    int storyIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        storyTextView = findViewById(R.id.storyTextView);

        storyAnswerButton1 = findViewById(R.id.buttonTop);
        storyAnswerButton2 = findViewById(R.id.buttonBottom);


        stories = new Story[]{new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2, 2, 1),
                new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2, 2, 3),
                new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2, 4, 5),
                new Story(R.string.T4_End, R.string.app_name, R.string.app_name, 0, 0),
                new Story(R.string.T5_End, R.string.app_name, R.string.app_name, 0, 0),
                new Story(R.string.T6_End, R.string.app_name,R.string.app_name,0,0)};

        setStory();
    }

    // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
    // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

    public void answerPress(View view) {

            int pressedButtonID = view.getId();

            if (pressedButtonID == R.id.buttonTop) {
                storyIndex = stories[storyIndex].answer1ID;
                setStory();

                int checkedIndex = stories[storyIndex].answer1ID;
                checkEnd(checkedIndex);


            } else {
                storyIndex = stories[storyIndex].getAnswer2ID();
                setStory();
                int checkedIndex = stories[storyIndex].answer2ID;
                checkEnd(checkedIndex);

            }

    }

    public void checkEnd (int index) {

        if (index != 0) {

            storyAnswerButton1.setVisibility(View.VISIBLE);
            storyAnswerButton2.setVisibility(View.VISIBLE);

        } else {

            storyAnswerButton1.setVisibility(View.GONE);
            storyAnswerButton2.setVisibility(View.GONE);

            replayGame();

        }
    }


    public void setStory() {

        storyTextView.setText(stories[storyIndex].getStoryQuestion());

        storyAnswerButton1.setText(stories[storyIndex].getAnswer1());
        storyAnswerButton2.setText(stories[storyIndex].getAnswer2());

    }

    public void replayGame() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setMessage(R.string.ReplayMessage);
        alert.setCancelable(false);
        alert.setTitle(R.string.app_name);
        alert.setPositiveButton("Replay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                storyIndex = 0;
                setStory();
                storyAnswerButton1.setVisibility(View.VISIBLE);
                storyAnswerButton2.setVisibility(View.VISIBLE);

            }

        });

        alert.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alert.show();

    }


}
