package com.applications.roleosala.leosala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnCon, btnHS, btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        __init__();
        eqxListerner();
    }

    private void eqxListerner() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, gameStart.class);
                startActivity(intent);

            }
        });
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void __init__() {
        btnStart = findViewById(R.id.btnStart);
        btnCon = findViewById(R.id.btnCon);
        btnHS = findViewById(R.id.btnHS);
        btnQuit = findViewById(R.id.btnQuit);
    }

}
