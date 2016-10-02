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

/**
 * The ExternalStorageActivity class implements all the control logic for the
 * External Storage Demo.
 *
 * @author Divay Prakash
 */
public class ExternalStorageActivity extends AppCompatActivity {

    /**
     * TextView variable representing the object to display the saved
     * string in.
     */
    private TextView EStextView;

    /**
     * EditText variable representing the object for taking input form
     * user.
     */
    private EditText ESeditText;

    /**
     * String variable representing the filename for the create data store file.
     */
    private String FILENAME = "storage-app-data";

    /**
     * This method is called at the startup of the application.
     * @param savedInstanceState The saved instance state of the application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
        EStextView = (TextView)findViewById(R.id.EStextView);
        ESeditText = (EditText)findViewById(R.id.ESeditText);
        retreiveString();
    }

    /**
     * This is the onClick action handler for the 'Save' button. It saves the
     * current state of the EditText field in the external storage and also
     * updates the TextView field with the same data.
     * @param view The View instance passed to this method.
     */
    public void button8_handle(View view) {
        saveString();
        retreiveString();
    }

    /**
     * This method is called to save the state of EditText field in the external
     * storage.
     */
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

    /**
     * This method is called to retreieve the stored string from external
     * storage and set the TextView field.
     */
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
