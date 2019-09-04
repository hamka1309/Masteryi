package com.example.tracnghiem.model;

public class WritingQuestions {
    private String writingQuestionID;
            private String writingQuestionContent;
            private String writingQuestionAnswer;
            private String writingQuestionChoice1;
            private String writingQuestionChoice2;
            private String writingQuestionChoice3;
            private String writingQuestionChoice4;
            private String writingPassageID;


    public WritingQuestions(String writingQuestionID, String writingQuestionContent, String writingQuestionAnswer, String writingQuestionChoice1, String writingQuestionChoice2, String writingQuestionChoice3, String writingQuestionChoice4, String writingPassageID) {
        this.writingQuestionID = writingQuestionID;
        this.writingQuestionContent = writingQuestionContent;
        this.writingQuestionAnswer = writingQuestionAnswer;
        this.writingQuestionChoice1 = writingQuestionChoice1;
        this.writingQuestionChoice2 = writingQuestionChoice2;
        this.writingQuestionChoice3 = writingQuestionChoice3;
        this.writingQuestionChoice4 = writingQuestionChoice4;
        this.writingPassageID = writingPassageID;
    }

    public String getWritingQuestionID() {
        return writingQuestionID;
    }

    public void setWritingQuestionID(String writingQuestionID) {
        this.writingQuestionID = writingQuestionID;
    }

    public String getWritingQuestionContent() {
        return writingQuestionContent;
    }

    public void setWritingQuestionContent(String writingQuestionContent) {
        this.writingQuestionContent = writingQuestionContent;
    }

    public String getWritingQuestionAnswer() {
        return writingQuestionAnswer;
    }

    public void setWritingQuestionAnswer(String writingQuestionAnswer) {
        this.writingQuestionAnswer = writingQuestionAnswer;
    }

    public String getWritingQuestionChoice1() {
        return writingQuestionChoice1;
    }

    public void setWritingQuestionChoice1(String writingQuestionChoice1) {
        this.writingQuestionChoice1 = writingQuestionChoice1;
    }

    public String getWritingQuestionChoice2() {
        return writingQuestionChoice2;
    }

    public void setWritingQuestionChoice2(String writingQuestionChoice2) {
        this.writingQuestionChoice2 = writingQuestionChoice2;
    }

    public String getWritingQuestionChoice3() {
        return writingQuestionChoice3;
    }

    public void setWritingQuestionChoice3(String writingQuestionChoice3) {
        this.writingQuestionChoice3 = writingQuestionChoice3;
    }

    public String getWritingQuestionChoice4() {
        return writingQuestionChoice4;
    }

    public void setWritingQuestionChoice4(String writingQuestionChoice4) {
        this.writingQuestionChoice4 = writingQuestionChoice4;
    }

    public String getWritingPassageID() {
        return writingPassageID;
    }

    public void setWritingPassageID(String writingPassageID) {
        this.writingPassageID = writingPassageID;
    }


}
