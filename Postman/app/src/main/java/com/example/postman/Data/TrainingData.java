package com.example.postman.Data;

public class TrainingData {

    public String id;
    public String name;
    public String lv;
    public String week;
    public String msg;

    int type;

    public TrainingData(String id, String name, String lv, String week, String msg, int type) {
        this.id = id;
        this.name = name;
        this.lv = lv;
        this.week = week;
        this.msg = msg;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLv() {
        return lv;
    }

    public void setLv(String lv) {
        this.lv = lv;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
