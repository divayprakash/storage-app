package com.example.divayprakash.storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void button1_handle(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void button2_handle(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void button3_handle(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
