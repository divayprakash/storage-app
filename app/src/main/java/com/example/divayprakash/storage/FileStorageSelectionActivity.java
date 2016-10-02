package com.example.divayprakash.storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * The FileStorageSelectionActivity class implements all the control logic
 * for the storage selection activity.
 *
 * @author Divay Prakash
 */
public class FileStorageSelectionActivity extends AppCompatActivity {

    /**
     * This method is called at the startup of the application.
     * @param savedInstanceState The saved instance state of the application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage_selection);
    }

    /**
     * This is the onClick action handler for the 'Internal Storage' button.
     * It starts the InternalStorageActivity using an Intent.
     * @param view The View instance passed to this method.
     */
    public void button5_handle(View view) {
        Intent intent = new Intent(this, InternalStorageActivity.class);
        startActivity(intent);
    }

    /**
     * This is the onClick action handler for the 'External Storage' button.
     * It starts the ExternalStorageActivity using an Intent.
     * @param view The View instance passed to this method.
     */
    public void button6_handle(View view) {
        Intent intent = new Intent(this, ExternalStorageActivity.class);
        startActivity(intent);
    }
}
