package com.example.divayprakash.storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * The MainActivity class implements all the control logic for the application.
 *
 * @author Divay Prakash
 */
public class MainActivity extends AppCompatActivity {

    /**
     * This method is called at the startup of the application.
     * @param savedInstanceState The saved instance state of the application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This is the onClick action handler for the 'Shared Preferences' button.
     * It starts the SharedPreferencesActivity using an Intent.
     * @param view The View instance passed to this method.
     */
    public void button1_handle(View view){
        Intent intent = new Intent(this, SharedPreferencesActivity.class);
        startActivity(intent);
    }

    /**
     * This is the onClick action handler for the 'Files' button.
     * It starts the FileStorageSelectionActivity using an Intent.
     * @param view The View instance passed to this method.
     */
    public void button2_handle(View view){
        Intent intent = new Intent(this, FileStorageSelectionActivity.class);
        startActivity(intent);
    }

    /**
     * This is the onClick action handler for the 'SQLite' button.
     * It starts the DatabaseActivity using an Intent.
     * @param view The View instance passed to this method.
     */
    public void button3_handle(View view){
        Intent intent = new Intent(this, DatabaseActivity.class);
        startActivity(intent);
    }
}
