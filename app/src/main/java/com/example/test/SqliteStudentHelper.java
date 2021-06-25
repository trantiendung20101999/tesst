package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.test.model.Student;

import java.util.ArrayList;
import java.util.List;

public class SqliteStudentHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME ="StudentDB.db";
    static final int DATABASE_VERSION = 1;


    public SqliteStudentHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL=" CREATE TABLE students(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "name TEXT," +
                "year TEXT," +
                "address TEXT," +
                "term TEXT)";

        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addStudent (Student student)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",student.getFullName());
        contentValues.put("year",student.getYear());
        contentValues.put("address",student.getAddress());
        contentValues.put("term",student.getTerm());
        SQLiteDatabase statement = getWritableDatabase();
        return statement.insert("students",null,contentValues);
    }

    public List<Student> getAllStudent()
    {
        List<Student> listOrders = new ArrayList<>();

        SQLiteDatabase statement = getReadableDatabase();

        Cursor cursor = statement.query("students",null,null,null,null,null,null);
        while (cursor!=null && cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String year = cursor.getString(2);
            String address = cursor.getString(3);
            String term = cursor.getString(4);
            Student student = new Student(id,name,year,address,term);
            listOrders.add(student);
        }

        return listOrders;
    }
}
