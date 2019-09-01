package com.example.tracnghiem.Question;

public class Score {
    private int iD;
    private String naMe;
    private String score;
    private byte[] hinh;

    public Score() {
    }

    public Score(int iD, String naMe,String score, byte[] hinh) {
        this.iD = iD;
        this.naMe = naMe;

        this.score = score;
        this.hinh = hinh;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getNaMe() {
        return naMe;
    }

    public void setNaMe(String naMe) {
        this.naMe = naMe;
    }


    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }
}
