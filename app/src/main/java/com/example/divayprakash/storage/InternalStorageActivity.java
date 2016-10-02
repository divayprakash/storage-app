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

/**
 * The InternalStorageActivity class implements all the control logic for the
 * Internal Storage Demo.
 *
 * @author Divay Prakash
 */
public class InternalStorageActivity extends AppCompatActivity {

    /**
     * TextView variable representing the object to display the saved
     * string in.
     */
    private TextView IStextView;

    /**
     * EditText variable representing the object for taking input form
     * user.
     */
    private EditText ISeditText;

    /**
     * String variable representing the filename for the create data store file.
     */
    String FILENAME = "internal_storage_demo";

    /**
     * This method is called at the startup of the application.
     * @param savedInstanceState The saved instance state of the application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        IStextView = (TextView)findViewById(R.id.IStextView);
        ISeditText = (EditText)findViewById(R.id.ISeditText);
        retreiveString();
    }

    /**
     * This is the onClick action handler for the 'Save' button. It saves the
     * current state of the EditText field in the internal storage and also
     * updates the TextView field with the same data.
     * @param view The View instance passed to this method.
     */
    public void button7_handle(View view) {
        saveString();
        retreiveString();
    }

    /**
     * This method is called to save the state of EditText field in the internal
     * storage.
     */
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

    /**
     * This method is called to retreieve the stored string from internal
     * storage and set the TextView field.
     */
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
