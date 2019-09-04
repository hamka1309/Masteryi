package com.example.tracnghiem.model;

public class Part6Part7 {
    private String writingPassageID;
    private String writingPassageTitle;
    private String writingPassageContent;
    private String part;
    private String level;
    private String writingQuestionID;
    private String writingQuestionContent;
    private String writingQuestionAnswer;
    private String writingQuestionChoice1;
    private String writingQuestionChoice2;
    private String writingQuestionChoice3;
    private String writingQuestionChoice4;

    public String getWritingPassageID() {
        return writingPassageID;
    }

    public void setWritingPassageID(String writingPassageID) {
        this.writingPassageID = writingPassageID;
    }

    public String getWritingPassageTitle() {
        return writingPassageTitle;
    }

    public void setWritingPassageTitle(String writingPassageTitle) {
        this.writingPassageTitle = writingPassageTitle;
    }

    public String getWritingPassageContent() {
        return writingPassageContent;
    }

    public void setWritingPassageContent(String writingPassageContent) {
        this.writingPassageContent = writingPassageContent;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    @Override
    public String toString() {
        return "Part6Part7{" +
                "writingPassageID='" + writingPassageID + '\'' +
                ", writingPassageTitle='" + writingPassageTitle + '\'' +
                ", writingPassageContent='" + writingPassageContent + '\'' +
                ", part='" + part + '\'' +
                ", level='" + level + '\'' +
                ", writingQuestionID='" + writingQuestionID + '\'' +
                ", writingQuestionContent='" + writingQuestionContent + '\'' +
                ", writingQuestionAnswer='" + writingQuestionAnswer + '\'' +
                ", writingQuestionChoice1='" + writingQuestionChoice1 + '\'' +
                ", writingQuestionChoice2='" + writingQuestionChoice2 + '\'' +
                ", writingQuestionChoice3='" + writingQuestionChoice3 + '\'' +
                ", writingQuestionChoice4='" + writingQuestionChoice4 + '\'' +
                '}';
    }

    public String getWritingQuestionChoice4() {
        return writingQuestionChoice4;
    }

    public void setWritingQuestionChoice4(String writingQuestionChoice4) {
        this.writingQuestionChoice4 = writingQuestionChoice4;
    }


    private String question;
    private int seleectedAnswerPosition;
    private boolean op1Sel,op2Sel,op3Sel,op4Sel; // options

    public boolean isOp1Sel() {
        return op1Sel;
    }

    public boolean isOp1Se4() {
        return op1Sel;
    }
    public void setOp1Sel(boolean op1Sel) {
        this.op1Sel = op1Sel;
        if(op1Sel){ // To make sure only one option is selected at a time
            setOp2Sel(false);
            setOp3Sel(false);
        }
    }

    public boolean isOp2Sel() {
        return op2Sel;
    }

    public void setOp2Sel(boolean op2Sel) {
        this.op2Sel = op2Sel;
        if(op2Sel){
            setOp1Sel(false);
            setOp3Sel(false);
        }
    }

    public boolean isOp3Sel() {
        return op3Sel;
    }

    public void setOp3Sel(boolean op3Sel) {
        this.op3Sel = op3Sel;
        if(op3Sel){
            setOp2Sel(false);
            setOp1Sel(false);
        }
    }

    public void setOp4Sel(boolean op4Sel) {
        this.op4Sel = op4Sel;
    }

    public int getSeleectedAnswerPosition() {
        return seleectedAnswerPosition;
    }

    public void setSeleectedAnswerPosition(int seleectedAnswerPosition) {
        this.seleectedAnswerPosition = seleectedAnswerPosition;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
}
