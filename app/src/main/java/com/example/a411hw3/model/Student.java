package com.example.a411hw3.model;

import java.util.ArrayList;

public class Student {
    protected String mFName;
    protected String mLName;
    protected String mCWID;

    protected ArrayList<Course_Enroll> mCourses;

    public Student(String fname, String lname, String cwid) {
        mFName = fname;
        mLName = lname;
        mCWID = cwid;
    }

    public String getFName() {
        return mFName;
    }
    public String getLName() {
        return mLName;
    }
    public String getCwid() {
        return mCWID;
    }
    public ArrayList<Course_Enroll> getCourses() {
        return mCourses;
    }

    public void setFName(String FName) {
        mFName = FName;
    }
    public void setLName(String LName) {
        mLName = LName;
    }
    public void setCwid(String sCwid) {
        mCWID = sCwid;
    }
    public void setCourses(ArrayList<Course_Enroll> courses) {
        mCourses = courses;
    }

}