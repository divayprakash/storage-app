package com.example.divayprakash.storage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        TextView textView = (TextView)findViewById(R.id.textView);
        EditText editText = (EditText)findViewById(R.id.editText);
        retreiveString();
    }

    public void button4_handle(View view) {
        saveString();
        retreiveString();
    }

    private void saveString() {
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        String text = editText.getText().toString();
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("savedString", text);
        editor.commit();
    }

    private void retreiveString() {
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        String text = settings.getString("savedString", getString(R.string.textView_text));
        textView.setText(text);
    }
}
