package com.example.divayprakash.storage;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import static java.security.AccessController.getContext;

public class ExternalStorageActivity extends AppCompatActivity {

    private TextView EStextView;
    private EditText ESeditText;
    private String FILENAME = "storage-app-data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
        EStextView = (TextView)findViewById(R.id.EStextView);
        ESeditText = (EditText)findViewById(R.id.ESeditText);
        retreiveString();
    }

    public void button8_handle(View view) {
        saveString();
        retreiveString();
    }

    private void saveString() {
        File storage = Environment.getExternalStorageDirectory();
        File dir = new File(storage.getAbsolutePath() + "/Storage-App/");
        dir.mkdir();
        File file = new File(FILENAME);
        String text = ESeditText.getText().toString();
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(text.getBytes());
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void retreiveString() {
        String line = "", buffer = "";
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Storage-App/" + FILENAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((line = reader.readLine()) != null) {
                buffer += line + "\n";
            }
            reader.close();
            EStextView.setText(buffer);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
