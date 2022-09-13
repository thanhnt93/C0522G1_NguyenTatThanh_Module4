package com.codegym.model;

public class Mail {
private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String languages;
    private String pageSize;
    private String spamsFillter;
    private String signature;

    public Mail() {
    }

    public Mail(int id, String languages, String pageSize, String spamsFillter, String signature) {
        this.id = id;
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFillter = spamsFillter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(String spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "languages='" + languages + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", spamsFillter='" + spamsFillter + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
