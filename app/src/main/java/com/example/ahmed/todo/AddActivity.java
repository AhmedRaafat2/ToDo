package com.example.ahmed.todo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText taskDetails, taskDate, taskTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        taskDetails = findViewById(R.id.etNewTask);
        taskDate = findViewById(R.id.etDisplayDate);
        taskTime = findViewById(R.id.etDisplayTime);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_addactivity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.share:
                return true;
            case R.id.add:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
