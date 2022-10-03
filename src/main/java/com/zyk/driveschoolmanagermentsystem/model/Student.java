package com.zyk.driveschoolmanagermentsystem.model;

import java.util.Date;

public class Student {
    String id;
    String name;
    Date joinTime;

    int class1Grade;
    int class2Grade;
    int class3Grade;
    int class4Grade;

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

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public int getClass1Grade() {
        return class1Grade;
    }

    public void setClass1Grade(int class1Grade) {
        this.class1Grade = class1Grade;
    }

    public int getClass2Grade() {
        return class2Grade;
    }

    public void setClass2Grade(int class2Grade) {
        this.class2Grade = class2Grade;
    }

    public int getClass3Grade() {
        return class3Grade;
    }

    public void setClass3Grade(int class3Grade) {
        this.class3Grade = class3Grade;
    }

    public int getClass4Grade() {
        return class4Grade;
    }

    public void setClass4Grade(int class4Grade) {
        this.class4Grade = class4Grade;
    }
}
