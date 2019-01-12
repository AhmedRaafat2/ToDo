package com.example.ahmed.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "TasksDB";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "TasksTable";
    public static final String COULMN_ID = "id";
    public static final String COULMN_DETAILS = "details";
    public static final String COULMN_DATE = "date";
    public static final String COULMN_TIME = "time";
    public static final String COULMN_PRIORITY = "priority";



    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStatement = "CREATE TABLE "+TABLE_NAME+"("+COULMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COULMN_DETAILS+" VARCHAR(250),"+COULMN_DATE+" DATE,"+COULMN_TIME+" TIME,"+COULMN_PRIORITY+" VARCHAR(6))";
        db.execSQL(createStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String dropStatement = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(dropStatement);
        onCreate(db);

    }

    public void addToDo(Task task){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COULMN_DETAILS,task.getTaskDetails());
        values.put(COULMN_DATE,task.getTaskDate());
        values.put(COULMN_TIME,task.getTaskTime());
        values.put(COULMN_PRIORITY,task.getPriority());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<Task> getAllTasks(){
        ArrayList<Task> tasks = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        while (cursor.moveToNext()){

            Task task = new Task(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));
            tasks.add(task);
        }
        cursor.close();
        db.close();
        return tasks;
    }

    public void updateTask (Task task){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COULMN_ID,task.getId());
        values.put(COULMN_DETAILS,task.getTaskDetails());
        values.put(COULMN_DATE,task.getTaskDate());
        values.put(COULMN_TIME,task.getTaskTime());
        values.put(COULMN_PRIORITY,task.getPriority());

        db.update(TABLE_NAME,values,COULMN_ID+"=?",new String[]{String.valueOf(task.getId())});
        db.close();
    }

    public void deleteTask(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,COULMN_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }
}
