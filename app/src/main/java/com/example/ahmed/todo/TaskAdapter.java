package com.example.ahmed.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> tasks;
    private Context context;
    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        super(context, R.layout.custom_list_row, tasks);
        this.context=context;
        this.tasks=tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.custom_list_row,null,false);
        TextView taskDetails = view.findViewById(R.id.tvTaskDetails);
        TextView taskPriority = view.findViewById(R.id.tvTaskPriority);
        TextView taskDate = view.findViewById(R.id.tvTaskDate);
        TextView taskTime = view.findViewById(R.id.tvTaskTime);

        Task task = tasks.get(position);

        taskDetails.setText(task.getTaskDetails());
        taskPriority.setText(task.getPriority());
        taskDate.setText(task.getTaskDate());
        taskTime.setText(task.getTaskTime());

        return view;
    }
}
