package com.example.ahmed.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        values.put(COULMN_ID,task.getId());
        values.put(COULMN_DETAILS,task.getTaskDetails());
        values.put(COULMN_DATE,task.getTaskDate());
        values.put(COULMN_TIME,task.getTaskTime());
        values.put(COULMN_PRIORITY,task.getPriority());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }
}
