package com.example.divayprakash.storage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import static com.example.divayprakash.storage.R.id.editText;
import static com.example.divayprakash.storage.R.id.textView;

public class InternalStorageActivity extends AppCompatActivity {

    private TextView IStextView;
    private EditText ISeditText;
    String FILENAME = "internal_storage_demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        IStextView = (TextView)findViewById(R.id.IStextView);
        ISeditText = (EditText)findViewById(R.id.ISeditText);
        retreiveString();
    }

    public void button7_handle(View view) {
        saveString();
        retreiveString();
    }

    private void saveString() {
        try {
            FileOutputStream outputStream;
            outputStream = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            String data = ISeditText.getText().toString();
            outputStream.write(data.getBytes());
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void retreiveString() {
        try {
            FileInputStream inputStream;
            inputStream = openFileInput(FILENAME);
            int letter;
            String readData = "";
            while ((letter = inputStream.read()) != -1) {
                readData += Character.toString((char)letter);
            }
            inputStream.close();
            IStextView.setText(readData);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
