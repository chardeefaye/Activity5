package com.applications.roleosala.leosala;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class gameStart extends AppCompatActivity {
    Button a1, a2, b1, b2, c1,c2,d1,d2,e1,e2,f1,f2,g1,g2,h1,h2;
    TextView txtCorrect, txtIncorrect, txtTime;

    @Override
    protected void onStart() {
        super.onStart();
        CountDownTimer countDownTimer;
        new CountDownTimer(3000, 1000) {
            int time = 3;
            @Override
            public void onTick(long millisUntilFinished) {
                time -= 1;
                txtTime.setText(String.valueOf(time));
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        __init__();
        exqListener();
    }

    private void exqListener() {

    }

    private void __init__() {
        txtCorrect = findViewById(R.id.txtCorrect);
        txtIncorrect = findViewById(R.id.txtIncorrect);
        txtTime = findViewById(R.id.txtTime);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        g1 = findViewById(R.id.g1);
        g2 = findViewById(R.id.g2);
        h1 = findViewById(R.id.h1);
        h2 = findViewById(R.id.h2);
    }
    String prevStr;
    String curStr;
    int c = 0;

    public void setName(View v){
        switch (v.getId()){
            case R.id.a1:
                a1.setText("A");
                check("A", 1, a1);
                break;
            case R.id.a2:
                a2.setText("A");
                check("A", 1, a2);
                break;
            case R.id.b1:
                b1.setText("B");
                check("B", 1, b1);
                break;
            case  R.id.b2:
                b2.setText("B");
                check("B", 1,b2);
                break;
            case R.id.c1:
                c1.setText("C");
                check("C", 1, c1);
                break;
            case R.id.c2:
                c2.setText("C");
                check("C", 1, c2);
                break;
            case R.id.d1:
                d1.setText("D");
                check("D", 1, d1);
                break;
            case R.id.d2:
                d2.setText("D");
                check("D", 1, d2);
                break;
            case R.id.e1:
                e1.setText("E");
                check("F", 1, e1);
                break;
            case R.id.e2:
                e2.setText("E");
                check("F", 1, e2);
                break;
            case  R.id.f1:
                f1.setText("F");
                check("F", 1, f1);
                break;
            case R.id.f2:
                f2.setText("F");
                check("F", 1, f2);
                break;
            case R.id.g1:
                g1.setText("G");
                check("G", 1, g1);
                break;
            case R.id.g2:
                g2.setText("G");
                check("G", 1, g2);
                break;
            case R.id.h1:
                h1.setText("H");
                check("H", 1, h1);
                break;
            case R.id.h2:
                h2.setText("H");
                check("H", 1, h2);
                break;
                default:
                    break;
        }
    }

    int correct = 0, incorrect = 0;
    View buttonId [] = new View[2];

    public void check(String let, int count, View v){
        this.c += count;
        if(c == 1){
            prevStr = let;
            buttonId[0] = v;
        }else if (c == 2){
            curStr = let;
            buttonId[1] = v;
        }else{
            c = 0;
        }

        if(c == 2){
            if (prevStr == curStr){
                correct += 1;
                txtCorrect.setText(String.valueOf(correct));
                turnOff(let);
            }else{
                incorrect += 1;
                txtIncorrect.setText(String.valueOf(incorrect));
                turnBack(buttonId[0], buttonId[1]);
            }
            c = 0;
        }
        Log.d("Value of C", String.valueOf(c));
        Log.d("Correct", String.valueOf(correct));
        Log.d("Incorrect", String.valueOf(incorrect));
    }

    private void turnBack( View v1, View v2) {
        switch (v1.getId()){
            case R.id.a1:
                a1.setText("???");
                break;
            case R.id.a2:
                a2.setText("???");
                break;
            case R.id.b1:
                b1.setText("???");
                break;
            case  R.id.b2:
                b2.setText("???");
                break;
            case R.id.c1:
                c1.setText("???");
                break;
            case R.id.c2:
                c2.setText("???");
                break;
            case R.id.d1:
                d1.setText("???");
                break;
            case R.id.d2:
                d2.setText("???");
                break;
            case R.id.e1:
                e1.setText("???");
                break;
            case R.id.e2:
                e2.setText("???");
                break;
            case  R.id.f1:
                f1.setText("???");
                break;
            case R.id.f2:
                f2.setText("???");
                break;
            case R.id.g1:
                g1.setText("???");
                break;
            case R.id.g2:
                g2.setText("???");
                break;
            case R.id.h1:
                h1.setText("???");
                break;
            case R.id.h2:
                h2.setText("???");
                break;
            default:
                break;
        }
        switch (v2.getId()){
            case R.id.a1:
                a1.setText("???");
                break;
            case R.id.a2:
                a2.setText("???");
                break;
            case R.id.b1:
                b1.setText("???");
                break;
            case  R.id.b2:
                b2.setText("???");
                break;
            case R.id.c1:
                c1.setText("???");
                break;
            case R.id.c2:
                c2.setText("???");
                break;
            case R.id.d1:
                d1.setText("???");
                break;
            case R.id.d2:
                d2.setText("???");
                break;
            case R.id.e1:
                e1.setText("???");
                break;
            case R.id.e2:
                e2.setText("???");
                break;
            case  R.id.f1:
                f1.setText("???");
                break;
            case R.id.f2:
                f2.setText("???");
                break;
            case R.id.g1:
                g1.setText("???");
                break;
            case R.id.g2:
                g2.setText("???");
                break;
            case R.id.h1:
                h1.setText("???");
                break;
            case R.id.h2:
                h2.setText("???");
                break;
            default:
                break;
        }
    }


    private void turnOff(String let) {
        switch (let){
            case "A":
                a1.setEnabled(false);
                a2.setEnabled(false);
                break;
            case "B":
                b1.setEnabled(false);
                b2.setEnabled(false);
                break;
            case "C":
                c1.setEnabled(false);
                c2.setEnabled(false);
                break;
            case "D":
                d1.setEnabled(false);
                d2.setEnabled(false);
                break;
            case "E":
                e1.setEnabled(false);
                e2.setEnabled(false);
                break;
            case "F":
                f1.setEnabled(false);
                f2.setEnabled(false);
                break;
            case "G":
                g1.setEnabled(false);
                g2.setEnabled(false);
                break;
            case "H":
                h1.setEnabled(false);
                h2.setEnabled(false);
                break;
        }
    }

}
