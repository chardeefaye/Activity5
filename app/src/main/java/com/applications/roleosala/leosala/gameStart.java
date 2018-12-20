package com.applications.roleosala.leosala;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

public class gameStart extends AppCompatActivity {
    Button a1, a2, b1, b2, c1,c2,d1,d2,e1,e2,f1,f2,g1,g2,h1,h2, i1, i2, j1, j2,k1, k2,l1,l2, btnBonus;
    TextView txtCorrect, txtIncorrect, txtTime;
    Button buttons [] = new Button[24];
    String alpha[] = new String[24];
    ArrayList<Integer>  number;
    @Override
    protected void onStart() {
        super.onStart();
        CountDownTimer countDownTimer;
        new CountDownTimer(5000, 1000) {
            int time = 5;
            @Override
            public void onTick(long millisUntilFinished) {
                time -= 1;
                txtTime.setText(String.valueOf(time));
                for(int i = 0; i < buttons.length; i++){
                    change(1, buttons[i]);
                    buttons[i].setText(String.valueOf(alpha[number.get(i)]));
                }
            }

            @Override
            public void onFinish() {
                for(int i = 0; i < buttons.length; i++){
                    change(0, buttons[i]);
                }
                for(int i = 0; i < buttons.length; i++){
                    buttons[i].setText(R.string.btn2ndAct);
                }
            }
        }.start();
    }

    public void change(int i, View v){
        if(i == 0){
            v.setEnabled(true);
        }else{
            v.setEnabled(false);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        __init__();
        for (int j = 0; j < buttons.length; j++){
            buttons[j].setText(alpha[number.get(j)]);
        }
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
        i1 = findViewById(R.id.i1);
        i2 = findViewById(R.id.i2);
        j1 = findViewById(R.id.j1);
        j2 = findViewById(R.id.j2);
        k1 = findViewById(R.id.k1);
        k2 = findViewById(R.id.k2);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        buttons = new Button[]{a1, a2, b1, b2, c1,c2,d1,d2,e1,e2,f1,f2,g1,g2,h1,h2, i1, i2, j1, j2,k1, k2,l1,l2};
        number = new ArrayList<>();
        for (int i=0; i < buttons.length; i++){
            number.add(i);
        }
        alpha = getResources().getStringArray(R.array.alphabet);
        Collections.shuffle(number);
        for (int i = 0; i < number.size(); i++){
            Log.d(String.valueOf(i), String.valueOf(number.get(i)));
        }
        for(int i = 0; i < alpha.length; i++){
            Log.d(String.valueOf(i), alpha[i]);
        }
    }

    String prevStr = null;
    String curStr = null;
    int c = 0;

    public void setName(View v){
        for(int i = 0; i <buttons.length; i++){
            if(v.getId() == buttons[i].getId()){
                buttons[i].setText(alpha[number.get(i)]);
                check(alpha[number.get(i)], 1, v);
            }
        }
    }

    int correct = 0, incorrect = 0;
    View buttonId [] = new View[2];

    public void check(String let, int count, View v){
        c += count;
        if(c == 1){
            prevStr = let;
            buttonId[0] = v;
        }else if (c == 2){
            curStr = let;
            buttonId[1] = v;
            if (prevStr.contains(curStr)){
                correct += 1;
                txtCorrect.setText(String.valueOf(correct));
                turnOff(buttonId[0], buttonId[1]);
                buttonId[0] = null;
                buttonId[1] = null;
                c = 0;
            }else {
                incorrect += 1;
                txtIncorrect.setText(String.valueOf(incorrect));
                Handler handler = new Handler();
                for(int i = 0; i < buttons.length; i++){
                    change(1, buttons[i]);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        turnBack(buttonId[0], buttonId[1]);
                        for(int i = 0; i < buttons.length; i++){
                            change(0, buttons[i]);
                        }
                    }
                }, 2000);
                c=0;
            }
        }
    }

    private void turnBack( View v1, View v2) {
        for(int i = 0; i < buttons.length; i++){
            if(v1.getId() == buttons[i].getId()){
                buttons[i].setText(getResources().getText(R.string.btn2ndAct));
            }
            if(v2.getId() == buttons[i].getId()){
                buttons[i].setText(getResources().getText(R.string.btn2ndAct));
            }
        }
    }


    private void turnOff(View v1, View v2) {
        v1.setEnabled(false);
        v2.setEnabled(false);
    }

}
