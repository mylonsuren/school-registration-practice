/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolregistration;

/**
 *
 * @author Mylon
 */

import java.util.*;
public class Course {
    
    
    private int creditValue;
    private String courseName;
    private String courseCode;
    private String description;
    private int period;
    private int roomNum;
    private int mark;
    
    //private ArrayList <Student> students;

    public Course(int creditValue, String courseName, String courseCode, String description, int period, int roomNum, int mark, ArrayList<Student> students) {
        this.creditValue = creditValue;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.description = description;
        this.period = period;
        this.roomNum = roomNum;
        //this.students = new ArrayList<Student>();
    }
    
    public Course (int creditValue, String courseName, String courseCode, String description) {
        this.creditValue = creditValue;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.description = description;    
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
    public int getMark() {
        return mark;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
    
    @Override
    public String toString() {
        String word = "Course: " + courseName + "\t\tCode: " + courseCode + "\tCredit: " + creditValue +
                        "\n    " + description;
        return word;
    }
    
    
}
