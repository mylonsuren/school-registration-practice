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

import java.io.*;
import java.util.*;
public class Student {
    
    private String firstName;
    private String lastName;
    private String address;
    private String birthDate;
    private String gender;
    private int grade;
    private int studentID;
    private int oen;
    private int volunHours;
    private int numCredits;
    private boolean osslt;
    
    private int lockerNum;
    private String combo;
    
    private String username;
    private String password;

    
    private ArrayList <Course> courses;
    private Library library;
    private Locker locker;
    
    
    public Student (String firstName, String lastName, String address, int grade, 
            int studentID, int oen, String username, String password, String combo, 
            int lockerNum, int volunHours, boolean osslt, int numCredits, String gender, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.grade = grade;
        this.studentID = studentID;
        this.oen = oen;
        this.numCredits = numCredits;
        this.gender = gender;
        this.osslt = osslt;
        this.birthDate = birthDate;
        this.volunHours = volunHours;
        
        
        this.locker = new Locker(combo, lockerNum);
        
        this.library = new Library(username, password);
        
        this.courses = new ArrayList <Course>();
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public void setNumCredits(int numCredits) {
        this.numCredits = numCredits;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getOen() {
        return oen;
    }

    public void setOen(int oen) {
        this.oen = oen;
    }
    
    public String isOsslt() {
        
        String ossltPrint;
        if (osslt == true) {
            ossltPrint = "Complete";
        }
        else {
            ossltPrint = "Incomplete";
        }
        
        return ossltPrint;
    }
    
    public void setOsslt(boolean osslt) {
        this.osslt = osslt;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getVolunHours() {
        return volunHours;
    }

    public void setVolunHours(int volunHours) {
        this.volunHours = volunHours;
    }
    
    public void addCourse (Course course) {
        courses.add(course);
    }
    
    public void removeCourse (int i) {
        courses.remove(i);
    }
    
    public int getLockerNum() {
        return this.locker.getLockerNum();
    }

    public Library getLibrary() {
        return library;
    }

    public String getCombo() {
        return this.locker.getCombo();
    }

    public void setCombo(String combo) {
        this.locker.setCombo(combo);
    }

    public Locker getLocker() {
        return locker;
    }

    public String getPassword() {
        return this.library.getPassword();
    }

    public void setPassword(String password) {
        this.library.setPassword(password);
    }

    public String getUsername() {
        return this.library.getUsername();
    }

    public void setUsername(String username) {
        this.library.setUsername(username);
    }

    public void setLockerNum(int lockerNum) {
        this.locker.setLockerNum(lockerNum);
    }

    public void addCourse (int creditValue, String courseName, String courseCode, String description){   
        courses.add(new Course(creditValue, courseName, courseCode, description));   
    }
        
    @Override
    public String toString() {
        
        String ossltPrint;
        if (osslt == true) {
            ossltPrint = "Complete";
        }
        else {
            ossltPrint = "Incomplete";
        }
        
        String word = "First Name: " + firstName +  "\tLast Name: " + lastName + 
                "\tOEN: " + oen + "\t    ID: " + studentID + "\n    Date of Birth: " + birthDate + "\t    Grade: " 
                + grade + "\t    Address: " + address + "\t    OSSLT: " + ossltPrint + "\tCredits: " + numCredits
                + "\tVolunteer Hours: " + volunHours;
        return word;
    }
    
    public ArrayList<String> printCourses (int select) {
        
        ArrayList <String> list = new ArrayList<>();
        
        for (int i = 0; i < courses.size(); i++) {
            list.add(courses.get(i).toString());
        }
        
        return list;
        
    }
  
}
