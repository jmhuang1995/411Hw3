package com.example.a411hw3.model;

public class Course_Enroll {

    protected String mCourse_Id;
    protected String mCourse_Grade;

    public Course_Enroll(String Course_Id, String Course_Grade) {
        mCourse_Id = Course_Id;
        mCourse_Grade = Course_Grade;
    }

    public String getCourseId() {
        return  mCourse_Id;
    }

    public void setCourseId(String courseId) {
        mCourse_Id = courseId;
    }

    public String getGrade() {
        return mCourse_Grade;
    }

    public void setGrade(String grade) {
        mCourse_Grade = grade;
    }
}
