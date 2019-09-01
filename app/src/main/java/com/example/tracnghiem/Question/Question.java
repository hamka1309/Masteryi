package com.example.tracnghiem.Question;

public class Question {
    private int Id;
    private String _Part;
    private String _Level;
    private String _Question;
    private String _A,_B,_C,_D;
    private String _Answer;
    private byte[] Image;
    private String result = "";
    public int choiceId = -1; // hỗ trợ radio

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Question(int id, String _Part, String _Level, String _Question, String _A, String _B, String _C, String _D, String _Answer, byte[] image,String result) {
        Id = id;
        this._Part = _Part;
        this._Level = _Level;
        this._Question = _Question;
        this._A = _A;
        this._B = _B;
        this._C = _C;
        this._D = _D;
        this._Answer = _Answer;
        Image = image;
        this.result =result;
    }

    public Question() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String get_Part() {
        return _Part;
    }

    public void set_Part(String _Part) {
        this._Part = _Part;
    }

    public String get_Level() {
        return _Level;
    }

    public void set_Level(String _Level) {
        this._Level = _Level;
    }

    public String get_Question() {
        return _Question;
    }

    public void set_Question(String _Question) {
        this._Question = _Question;
    }

    public String get_A() {
        return _A;
    }

    public void set_A(String _A) {
        this._A = _A;
    }

    public String get_B() {
        return _B;
    }

    public void set_B(String _B) {
        this._B = _B;
    }

    public String get_C() {
        return _C;
    }

    public void set_C(String _C) {
        this._C = _C;
    }

    public String get_D() {
        return _D;
    }

    public void set_D(String _D) {
        this._D = _D;
    }

    public String get_Answer() {
        return _Answer;
    }

    public void set_Answer(String _Answer) {
        this._Answer = _Answer;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
}
