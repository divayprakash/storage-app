package com.example.divayprakash.storage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The SharedPreferencesActivity class implements all the control logic for the
 * Shared Preferences Demo.
 *
 * @author Divay Prakash
 */
public class SharedPreferencesActivity extends AppCompatActivity {

    /**
     * TextView variable representing the object to display the saved
     * string in.
     */
    private TextView textView;

    /**
     * EditText variable representing the object for taking input form
     * user.
     */
    private EditText editText;

    /**
     * This method is called at the startup of the application.
     * @param savedInstanceState The saved instance state of the application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        retreiveString();
    }

    /**
     * This is the onClick action handler for the 'Save' button. It saves the
     * current state of the EditText field in the Shared Preferences and also
     * updates the TextView field with the same data.
     * @param view The View instance passed to this method.
     */
    public void button4_handle(View view) {
        saveString();
        retreiveString();
    }

    /**
     * This method is called to save the state of EditText field in the Shared
     * Preferences.
     */
    private void saveString() {
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        String text = editText.getText().toString();
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("savedString", text);
        editor.commit();
    }

    /**
     * This method is called to retreieve the stored string from Shared
     * Preferences and set the TextView field.
     */
    private void retreiveString() {
        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        String text = settings.getString("savedString", getString(R.string.textView_text));
        textView.setText(text);
    }
}
