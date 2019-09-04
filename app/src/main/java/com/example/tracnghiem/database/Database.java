package com.example.tracnghiem.database;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import com.example.tracnghiem.Question.Question;
import com.example.tracnghiem.Question.Score;
import com.example.tracnghiem.model.Part6Part7;
import com.example.tracnghiem.model.WritingPassages;
import com.example.tracnghiem.model.WritingQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    public Map<String,String> getIDQuestionConten(String level, String part)
    {
        Map<String,String> getList= new HashMap<>();

        String selelctQuery ="SELECT "+DBQuerys.WRITINGPASSAGESID+", "+DBQuerys.WRITINGPASSAGECONTENT+" FROM "+DBQuerys.WRITINGPASSAGES+
                " WHERE "+DBQuerys.LEVEL +" LIKE '"+ level +"' AND "+DBQuerys.PART+" LIKE '"+part+"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selelctQuery,null);
        if(cursor.moveToFirst()){
            do {
                getList.put(cursor.getString(0),cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return getList;
    }




    public List<Part6Part7> getPart6Part7(String passagesId, String part, String level) {
        List<Part6Part7> part6Part7s = new ArrayList<>();
        String selelctQuery ="SELECT * FROM "+DBQuerys.WRITINGPASSAGES+" AS a JOIN "+DBQuerys.WRITINGQUESTIONS+" AS b ON "+
                " a."+DBQuerys.WRITINGPASSAGESID+" LIKE b."+DBQuerys.WRITINGPASSAGESID+
                " WHERE a." + DBQuerys.LEVEL + " LIKE '" + level + "' AND a."+DBQuerys.PART+" LIKE '"+part
                +"' AND a."+DBQuerys.WRITINGPASSAGESID+" LIKE '"+passagesId+"'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selelctQuery, null);


        // Duyệt trên con trỏ, và thêm vào danh sách.
        if (cursor.moveToFirst()) {
            do {
                Part6Part7 note = new Part6Part7();

                note.setWritingPassageID(cursor.getString(0));
                note.setWritingPassageTitle(cursor.getString(1));
                note.setWritingPassageContent(cursor.getString(2));
                note.setLevel(cursor.getString(4));
                note.setPart(cursor.getString(3));
                note.setWritingQuestionID(cursor.getString(5));
                note.setWritingQuestionContent(cursor.getString(6));
                note.setWritingQuestionAnswer(cursor.getString(7));
                note.setWritingQuestionChoice1(cursor.getString(8));
                note.setWritingQuestionChoice2(cursor.getString(9));
                note.setWritingQuestionChoice3(cursor.getString(10));
                note.setWritingQuestionChoice4(cursor.getString(11));
                note.setWritingPassageID(cursor.getString(12));

                // Thêm vào danh sách.
                part6Part7s.add(note);
            } while (cursor.moveToNext());
        }
        return part6Part7s;
    }




    public void addWritingPassages(WritingPassages writingPassages) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBQuerys.WRITINGPASSAGESID, writingPassages.getWritingPassageID());
        values.put(DBQuerys.WRITINGPASSAGETITLE, writingPassages.getWritingPassageTitle());
        values.put(DBQuerys.WRITINGPASSAGECONTENT, writingPassages.getWritingPassageContent());
        values.put(DBQuerys.PART, writingPassages.getPart());
        values.put(DBQuerys.LEVEL, writingPassages.getLevel());
        db.insert(DBQuerys.WRITINGPASSAGES, null, values);
        db.close();
    }

    public void addWritingQuestions(WritingQuestions writingQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBQuerys.WRITINGQUESTIONID, writingQuestions.getWritingQuestionID());
        values.put(DBQuerys.WRITINGQUESTIONCONTENT, writingQuestions.getWritingQuestionContent());
        values.put(DBQuerys.WRITINGQUESTIONANSWER, writingQuestions.getWritingQuestionAnswer());
        values.put(DBQuerys.WRITINGQUESTIONCHOICE1, writingQuestions.getWritingQuestionChoice1());
        values.put(DBQuerys.WRITINGQUESTIONCHOICE2, writingQuestions.getWritingQuestionChoice2());
        values.put(DBQuerys.WRITINGQUESTIONCHOICE3, writingQuestions.getWritingQuestionChoice3());
        values.put(DBQuerys.WRITINGQUESTIONCHOICE4, writingQuestions.getWritingQuestionChoice4());
        values.put(DBQuerys.WRITINGPASSAGESID, writingQuestions.getWritingPassageID());

        db.insert(DBQuerys.WRITINGQUESTIONS, null, values);
        db.close();
    }





}
