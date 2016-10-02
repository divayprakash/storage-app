package com.example.divayprakash.storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FileStorageSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage_selection);
    }

    public void button5_handle(View view) {
        Intent intent = new Intent(this, InternalStorageActivity.class);
        startActivity(intent);
    }

    public void button6_handle(View view) {
        Intent intent = new Intent(this, ExternalStorageActivity.class);
        startActivity(intent);
    }
}
