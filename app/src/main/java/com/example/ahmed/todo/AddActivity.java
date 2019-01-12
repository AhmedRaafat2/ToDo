package com.example.ahmed.todo;

import android.content.Intent;
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
        //taskPriority = findViewById(R.id.)


        Intent updateIntent = getIntent();
        Task task = (Task)updateIntent.getSerializableExtra("task");
        if(task != null){
            taskDetails.setText(task.getTaskDetails().toString());
            taskDate.setText(task.getTaskDate().toString());
            taskTime.setText(task.getTaskTime().toString());
        }





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_addactivity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent updateIntent = getIntent();
        Task taskReceived = (Task)updateIntent.getSerializableExtra("taskupdate");
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.share:
                return true;
            case R.id.add:
                if(taskReceived == null){
                    Task task = new Task(taskDetails.getText().toString(),taskDate.getText().toString(),taskTime.getText().toString(),"High");
                    DbHelper helper = new DbHelper(this);
                    helper.addToDo(task);
                    helper.close();
                    Intent intent = new Intent(this,MainActivity.class);
                    startActivity(intent);
                }else if(taskReceived != null){
                    DbHelper helper = new DbHelper(this);
                    Task task = new Task(taskDetails.getText().toString(),taskDate.getText().toString(),taskTime.getText().toString(),"High");
                    helper.updateTask(task);
                    helper.close();
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
