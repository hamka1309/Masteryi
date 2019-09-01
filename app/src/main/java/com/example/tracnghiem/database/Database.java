package com.example.tracnghiem.database;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import com.example.tracnghiem.Question.Question;
import com.example.tracnghiem.Question.Score;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {


    public Database(@Nullable Context context) {
        super(context, "Tracnghiem", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }


    public void QueryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    // truy van tra kq
    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql,null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // GETDATA

    public List<Score> getUser(){
        List<Score> noteList = new ArrayList<Score>();
        // Select All Query
        String selectQuery =  "SELECT * FROM USER";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Score score = new Score();
                score.setNaMe(cursor.getString(1));
                score.setScore(cursor.getString(2));
                score.setHinh(cursor.getBlob(3));
                // Thêm vào danh sách.
                noteList.add(score);
            } while (cursor.moveToNext());
        }
        return noteList;
    }

    public List<Question> getQuestion(String part, String level) {
        List<Question> noteList = new ArrayList<Question>();
        // Select All Query
        String selectQuery =  "SELECT  * FROM QUESTION WHERE PART  ='"+part+"' AND LEVEL ='" + level+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // Duyệt trên con trỏ, và thêm vào danh sách.
        if (cursor.moveToFirst()) {
            do {
                Question note = new Question();
                note.set_Part(cursor.getString(1));
                note.set_Level(cursor.getString(2));
                note.set_Question(cursor.getString(3));
                note.set_A(cursor.getString(4));
                note.set_B(cursor.getString(5));
                note.set_C(cursor.getString(6));
                note.set_D(cursor.getString(7));
                note.set_Answer(cursor.getString(8));
                note.setImage(cursor.getBlob(9));

                // Thêm vào danh sách.
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        return noteList;
    }



    public void INSERT_SCORE(String name,String score,byte[] hinhanh){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO USER VALUES(null,?,?,?)";
        SQLiteStatement statement  = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,name);
        statement.bindString(2,score);
        statement.bindBlob(3,hinhanh);

        // phan tich insert du lieu
        statement.executeInsert();
    }

    public void INSERT_QUESTION(String part,String level,String question,String a,String b,String c,String d,String ans,byte[] hinhanh){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO  QUESTION VALUES(null,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement statement  = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,part);
        statement.bindString(2,level);
        statement.bindString(3,question);
        statement.bindString(4,a);
        statement.bindString(5,b);
        statement.bindString(6,c);
        statement.bindString(7,d);
        statement.bindString(8,ans);
        statement.bindBlob(9,hinhanh);

        // phan tich insert du lieu
        statement.executeInsert();
    }

}
