package com.example.android.quidditchscoretracker;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface myTypeFace = Typeface.createFromAsset(getAssets(), "font.TTF");
        TextView myTextView = (TextView) findViewById(R.id.quidditch);
        myTextView.setTypeface(myTypeFace);
        Button btn = (Button)findViewById(R.id.button1);
        btn.setTypeface(myTypeFace);



    }
    static int teamAScore = 0;
    static int teamBScore = 0;

    public void displayScoreA(int score){
        TextView scoreA = (TextView) findViewById(R.id.teamAScore);
        scoreA.setText(String.valueOf(score));
    }

    public void addQuafflePointsA(View v){
        teamAScore+=10;
        displayScoreA(teamAScore);
    }

    public void addSnitchPointsA(View v){
        teamAScore+=150;
        displayScoreA(teamAScore);
        TextView message = (TextView) findViewById(R.id.communicate);
        if (teamAScore>teamBScore){
            message.setText("Team A has just catched the Snitch!!! Team A wins!");
        }else{
            message.setText("Team A has just catched the Snitch!!! However Team B has more points! Team B wins!");
        }
    }

    public void displayScoreB(int score){
        TextView scoreB = (TextView) findViewById(R.id.teamBScore);
        scoreB.setText(String.valueOf(score));
    }

    public void addQuafflePointsB(View v){
        teamBScore+=10;
        displayScoreB(teamBScore);
    }

    public void addSnitchPointsB(View v){
        teamBScore+=150;
        displayScoreB(teamBScore);
        TextView message = (TextView) findViewById(R.id.communicate);
        if (teamBScore>teamAScore){
            message.setText("Team B has just catched the Snitch!!! Team B wins!");
        }else{
            message.setText("Team B has just catched the Snitch!!! However Team A has more points! Team A wins!");
        }
    }

    public void newGame(View v){
        teamAScore=0;
        teamBScore=0;
        displayScoreA(teamAScore);
        displayScoreB(teamBScore);
        TextView message = (TextView) findViewById(R.id.communicate);
        message.setText("");
    }


}
