package com.example.tracnghiem.database;

public class DBQuerys {

    public static final String DATABASE_NAME = "ListQuestion";
    public static final String TABLE_NAME = "Part5";
    public static final String ID = "id";
    public static final String QUESTION = "question";
    public static final String A = "a";
    public static final String B = "b";
    public static final String C = "c";
    public static final String D = "d";
    public static final String RESULT = "result";
    public static final String LEVEL = "level";
    public static final String PART = "part";

    public static final String WRITINGPASSAGES = "writingpassages";
    public static final String WRITINGPASSAGESID = "writingpassagesid";
    public static final String WRITINGPASSAGETITLE = "writingpassagestittle";
    public static final String WRITINGPASSAGECONTENT = "writingpassagecontent";

    public static final String WRITINGQUESTIONS = "writingquestions";
    public static final String WRITINGQUESTIONID = "writingquestionid";
    public static final String WRITINGQUESTIONCONTENT = "writingquestioncontent";
    public static final String WRITINGQUESTIONANSWER = "writingquestionanswer";
    public static final String WRITINGQUESTIONCHOICE1 = "writingquestionchoice1";
    public static final String WRITINGQUESTIONCHOICE2 = "writingquestionchoice2";
    public static final String WRITINGQUESTIONCHOICE3 = "writingquestionchoice3";
    public static final String WRITINGQUESTIONCHOICE4 = "writingquestionchoice4";

    //PART5
    public static final String sqlQuerys = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " integer primary key, " +
            QUESTION + " TEXT, " +
            A + " TEXT, " +
            B + " TEXT," +
            C + " TEXT," +
            D + " TEXT," +
            RESULT + " TEXT," +
            LEVEL + " TEXT)";
    //    PART 6,PART 7
    public static final String sqlWritingPassages = "CREATE TABLE " + WRITINGPASSAGES + " (" +
            WRITINGPASSAGESID + " TEXT primary key," +
            WRITINGPASSAGETITLE + " TEXT," +
            WRITINGPASSAGECONTENT + " TEXT not null," +
            PART + " TEXT," +
            LEVEL + " TEXT)";

    public static final String sqlWritingQuestions = "CREATE TABLE " + WRITINGQUESTIONS + " (" +
            WRITINGQUESTIONID + " TEXT , " +
            WRITINGQUESTIONCONTENT + " TEXT, " +
             WRITINGQUESTIONANSWER  + " TEXT, " +
             WRITINGQUESTIONCHOICE1  + " TEXT, " +
             WRITINGQUESTIONCHOICE2  + " TEXT, " +
             WRITINGQUESTIONCHOICE3  + " TEXT, " +
             WRITINGQUESTIONCHOICE4  + " TEXT, " +
             WRITINGPASSAGESID  + " TEXT not null)";

}
