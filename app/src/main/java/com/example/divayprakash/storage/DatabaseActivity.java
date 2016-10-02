package com.example.divayprakash.storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * The DatabaseActivity class implements all the control logic for the
 * database storage demo.
 *
 * @author Divay Prakash
 */
public class DatabaseActivity extends AppCompatActivity {

    /**
     * This method is called at the startup of the application.
     * @param savedInstanceState The saved instance state of the application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
    }
}
