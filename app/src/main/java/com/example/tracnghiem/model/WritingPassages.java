package com.example.tracnghiem.model;

public class WritingPassages {
    private String writingPassageID;
    private String writingPassageTitle;
    private String writingPassageContent;
    private String part;
    private String level;

    public WritingPassages(String writingPassageID, String writingPassageTitle, String writingPassageContent, String part, String level) {
        this.writingPassageID = writingPassageID;
        this.writingPassageTitle = writingPassageTitle;
        this.writingPassageContent = writingPassageContent;
        this.part = part;
        this.level = level;
    }

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
}
