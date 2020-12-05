package com.example.mindfulness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "MindfulDatabase";
    public static final int VERSION_NUM = 3;
    public static String USER_ID = "UserID";
    public static String TABLE_NAME = "Accounts";
    public static String USERNAME = "UserName";
    public static String  PASSWORD = "Password";
    public static String JOURNAL_TABLE_NAME = "Journal";
    public static String DATE = "Date";
    public static String TEXTONE = "TextOne";
    public static String TEXTTWO = "TextTwo";
    public static String TEXTTHREE = "TextThree";

    final private String ACTIVITY_NAME = "DatabaseHelper";


    //private static final String DATABASE_CREATE = "create table " + TABLE_NAME + "(" + USER_ID + " integer primary key autoincrement, " + USERNAME + " text not null);";

    public static final String DATABASE_CREATE = "create table " + TABLE_NAME + "(" + USER_ID + " integer primary key autoincrement, " + USERNAME + " text not null, " + PASSWORD + " text not null);";
    public static final String DATABASE_CREATE_JOURNAL = "create table " + JOURNAL_TABLE_NAME + "(" + USER_ID + " integer, " + DATE + " text not null, " + TEXTONE + " text not null, " + TEXTTWO + " text not null," + TEXTTHREE + " text not null);";


    public DatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.i(ACTIVITY_NAME, "Calling onCreate");
        database.execSQL(DATABASE_CREATE);
        database.execSQL(DATABASE_CREATE_JOURNAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {
        Log.i(ACTIVITY_NAME, "Calling onUpgrade, oldVersion=" + oldVersion + "newVersion=" + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + JOURNAL_TABLE_NAME);
        onCreate(db);
    }
}