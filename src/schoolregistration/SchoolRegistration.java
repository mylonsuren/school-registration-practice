
/*
Mylon Surenthiran
Registration Program
*/
package schoolregistration;

import java.util.*;
import java.io.*;
public class SchoolRegistration {
    
    static ArrayList<Course> courses =  new ArrayList<>();
    static ArrayList<Student> students = new ArrayList <>();
    static BufferedReader myInput = new BufferedReader (new InputStreamReader(System.in));
    
    
    public static void main(String[] args) throws IOException {
        
//        students.add(new Student("Alex", "Brown", "99 Road Avenue", 10, 
//            109454294, 943034324, "abrown9430", "109454294", "10-34-8", 
//            1985, 30, true, 21, "Male", "01/27/99"));
        
        courses.add(new Course(1, "Math", "MAT4U", "The Math Course. Students learn about math."));
        courses.add(new Course(1, "Physics", "SPH4U", "The Physics Course. Students learn about physics."));
        courses.add(new Course(1, "Chemistry", "SCH4U", "The Chemistry Course. Students learn about chemistry."));
        courses.add(new Course(1, "Biology", "ICS4U", "The Biology Course. Students learn about biology."));
        courses.add(new Course(1, "Religion", "HRE4M", "The Religion Course. Students learn about religion."));
        courses.add(new Course(1, "Business", "BAT4M", "The Business Course. Students learn about Business."));
        courses.add(new Course(1, "Computer", "ICS4U", "The Computer Course. Students learn about Computers."));
        courses.add(new Course(1, "French", "FRL4U", "The French Course. Students learn about French."));
        
//        students.get(0).addCourse(courses.get(0));
//        students.get(0).addCourse(courses.get(1));
//        students.get(0).addCourse(courses.get(4));
//        students.get(0).addCourse(courses.get(6));
        
        System.out.println("THE REGISTRATION MACHINE");
        
        mainMenu();
        
    }
    
    public static void mainMenu () throws IOException {
        
        do {
            System.out.println("\n1 - Students \n2 - Course Management \n3 - Exit");
            
            int select =Integer.parseInt(myInput.readLine());
            
            if (select == 1) {
                studentMenu();
            }
            else if (select == 2) {
                courseManagement();
            }
            else if (select == 3) {
                System.exit(0);
            }

        }
        while (true);
    }
    
    public static void addStudent() throws IOException {
        
        System.out.print("\nFirst Name: ");
        String firstName = myInput.readLine();
        
        System.out.print("Last Name: ");
        String lastName = myInput.readLine();
        
        System.out.print("Gender: ");
        String gender = myInput.readLine();
        
        System.out.print("Date of Birth (MM/DD/YY): ");
        String birthDate = myInput.readLine();
        
        System.out.print("Grade: ");
        int grade = Integer.parseInt(myInput.readLine());
        
        System.out.print("Address: ");
        String address = myInput.readLine();
        
        System.out.print("OEN: ");
        int oen = Integer.parseInt(myInput.readLine());
        
        System.out.print("Student ID: ");
        int studentID = Integer.parseInt(myInput.readLine());
        
        System.out.print("Number of Volunteer Hours: ");
        int volunHours = Integer.parseInt(myInput.readLine());
        
        boolean osslt;
        System.out.println("OSSLT");
        System.out.println("1 - Completed \t2 - Incomplete");
        int choiceOSSLT = Integer.parseInt(myInput.readLine());
        
        if (choiceOSSLT == 1) {
            osslt = true;
        }
        else {
            osslt = false;
        }
        
        System.out.print("Number of Credits: ");
        int numCredits = Integer.parseInt(myInput.readLine());
        
        System.out.print("Locker Number: ");
        int lockerNum = Integer.parseInt(myInput.readLine());

        String combo = generateCombo();
        
        String username = generateUsername(firstName, lastName, oen);
        
        String password = String.valueOf(studentID);
        
        students.add(new Student(firstName, lastName, address, grade, studentID, 
                oen, username, password, combo, lockerNum, volunHours, osslt, 
                numCredits, gender, birthDate));
       
    }
    
    public static String generateCombo () {
        
        int num1 = (int)((Math.random()*((99 - 1) + 1)));
        int num2 = (int)(Math.random()*((99 - 1) + 1));
        int num3 = (int)(Math.random()*((99 - 1) + 1));
        
        String combo = num1 + " - " + num2 + " - " + num3;
        return combo;    
    }
    
    public static String generateUsername(String firstName, String lastName, int oen) {
        
        char let1 = firstName.charAt(0);
        String mid;
        if (lastName.length() > 5) {
            mid = lastName.substring(0,6);
        }
        else {    
            mid = lastName.substring(0,lastName.length());
        }
        
        String oenS = String.valueOf(oen);
        
        String endUser = "";
        
        if (oenS.length() < 5) {
            endUser = oenS;
        }
        else {
            endUser = oenS.substring(0,5);
        }
        
        String username = (let1 + mid + endUser).toLowerCase();

        return username;
    }
    
    public static void removeStudent(int select) {
        
        students.remove(select);
        
    }
    
    public static void studentMenu() throws IOException {
        
        boolean menu = false;
        
        do {
            System.out.println("\n1 - Add Student \n2 - Remove Student \n3 - Update Student Information \n4 - Search Students \n5 - View Students \n6 - Main Menu");
            int select = Integer.parseInt(myInput.readLine());
            
            if (select == 1) {
                addStudent();
            }
            else if (select == 2) {
                displayStudents();
                int a = select();
                
                removeStudent(a);
                
            }
            else if (select == 3) {
                displayStudents();
                int c = select();
                
                updateStudent(c);
            }
            else if (select == 4) {
                searchStudents();
            }
            else if (select == 5) {
                displayStudents();
            }
            else if (select == 6) {
                mainMenu();
            }    
        }
        while (menu ==  false);     
    }
    
    public static void searchStudents () throws IOException {
        System.out.println("Enter Student ID: ");
        int studentID = Integer.parseInt(myInput.readLine());
        
        boolean check = false;
        int i = 0;
        for (Student s: students) {
            if (s.getStudentID() == studentID) {
                foundSearch(s);
                check = true;
                break;
            }
            if (i == students.size()) {
                check = false;
                break;
            }
            i++;
        }
        
        if (check == false) {
            System.out.println("\n---No student found---");
            
        }
        
        studentMenu();
        
    }
    
    public static void foundSearch (Student student) throws IOException {
        System.out.println("\n" + student);
        
        studentMenu();
        
    }
    
    public static void updateStudent(int select) throws IOException {
 
        int i = 1;
        //1
        System.out.println("\n" + i + " - Name: " + students.get(select).getFirstName() + " " + students.get(select).getLastName());
        i++;
        //2
        System.out.println(i + " - ID: " + students.get(select).getStudentID());
        i++;
        //3
        System.out.println(i + " - OEN: " + students.get(select).getOen());
        i++;
        //4
        System.out.println(i + " - Grade: " + students.get(select).getGrade());
        i++;
        //5
        System.out.println(i + " - Address: " + students.get(select).getAddress());
        i++;
        //6
        System.out.println(i + " - Date of Birth: " + students.get(select).getBirthDate());
        i++;
        //7
        System.out.println(i + " - Credits: " + students.get(select).getNumCredits());
        i++;
        //8
        System.out.println(i + " - Volunteer Hours: " + students.get(select).getVolunHours());
        i++;
        //9
        System.out.println(i + " - OSSLT: " + students.get(select).isOsslt());
        i++;
        //10
        System.out.println(i + " - Locker: " + students.get(select).getLockerNum());
        
        int choice = Integer.parseInt(myInput.readLine());
        
        switch (choice) {
            case 1:
                updateStudentName(select);
                break;
            case 2:
                updateStudentID(select);
                break;
            case 3:
                updateOEN(select);
                break;
            case 4:
                updateStudentGrade(select);
                break;
            case 5:
                updateStudentAddress(select);
                break;
            case 6:
                updateBirthDate(select);
                break;
            case 7:
                updateCredits(select);
                break;
            case 8:
                updateHours(select);
                break;
            case 9:
                updateOSSLT(select);
                break;
            case 10:
                updateLocker(select);
                break;
            default:
                break;       
        }
          
        
    }
    
    public static void updateLocker (int student) throws IOException {
        System.out.println("Locker Number: ");
        int lockerNum = Integer.parseInt(myInput.readLine());
        
        students.get(student).setLockerNum(lockerNum);    
    }
    
    public static void updateOSSLT(int student) throws IOException{
        System.out.println("OSSLT: ");
        System.out.println("1 - Completed \t2 - Incomplete");
        int select = Integer.parseInt(myInput.readLine());
        
        if (select == 1) {
            students.get(student).setOsslt(true);
        }
        else {
            students.get(student).setOsslt(false);
        }
    }
    
    public static void updateHours (int student) throws IOException {
        System.out.println("Volunteer Hours: "); 
        int numHours = Integer.parseInt(myInput.readLine());
        
        students.get(student).setVolunHours(numHours);
    }
    
    public static void updateCredits(int student) throws IOException {
        System.out.println("Number of Credits: ");
        int numC = Integer.parseInt(myInput.readLine());
        
        students.get(student).setNumCredits(numC);
    }
    public static void updateBirthDate (int student) throws IOException {
        System.out.println("Enter Date of Birth (MM/DD/YY): ");
        String birthdate = myInput.readLine();
        
        students.get(student).setBirthDate(birthdate);
    }
    
    public static void updateOEN(int student) throws IOException {
        System.out.println("Enter new OEN: ");
        int oen = Integer.parseInt(myInput.readLine());
        
        students.get(student).setUsername(generateUsername(students.get(student).getFirstName(), students.get(student).getLastName(), oen));
        students.get(student).setOen(oen);
    }
    
    public static void updateStudentName(int student) throws IOException {
        System.out.print("\nEnter First Name: ");
        String firstName = myInput.readLine();
        
        System.out.print("\nEnter Last Name: ");
        String lastName = myInput.readLine();
        
        students.get(student).setFirstName(firstName);
        students.get(student).setLastName(lastName);
        
    }
    public static void updateStudentID(int student) throws IOException {
        System.out.print("\nEnter Student ID: ");
        int studentID = Integer.parseInt(myInput.readLine());
        
        
        students.get(student).setPassword(String.valueOf(studentID));
        students.get(student).setStudentID(studentID);    
    }
    
    public static void updateStudentGrade(int student) throws IOException {
        System.out.print("\nEnter grade: ");
        int grade = Integer.parseInt(myInput.readLine());
        
        students.get(student).setGrade(grade);
    }
    
    public static void updateStudentAddress(int student) throws IOException {
        System.out.print("\nAddress: ");
        String address = myInput.readLine();
        
        students.get(student).setAddress(address);
    }
    
    public static void courseManagement () throws IOException {
        boolean menu = false;
        do {
            System.out.println("\n1 - Manage Student Courses \n2 - Add Course \n3 - Remove Courses \n4 - View Courses \n5 - Main Menu");
            int select = Integer.parseInt(myInput.readLine());
            
            if (select == 1) {
                manageStudentcourse();
            }
            else if (select == 2){
                addCourse();
            }
            else if (select == 3){
                removeCourseData();
            }
            else if (select == 4) {
                displayCourses();
            }
            else if (select == 5) {
                mainMenu();
            }
        }
        while (menu == false);
    }
    
    public static void removeCourseData () throws IOException {
        displayCourses();
        int select = select();
        
        courses.remove(select);
        
    }
    
    public static void manageStudentcourse () throws IOException {
        
        boolean check = false;
        
        do {
            System.out.println("\n1 - Add Course to Student \n2 - Remove Course from Student \n3 - Student Marks \n4 - Course Management ");
            int select = Integer.parseInt(myInput.readLine());
            
            if (select == 1) {
                assignCourse();
            }
            else if (select == 2) {
                removeCourse();
            }
            else if (select == 3){
                displayStudents();
                int student = select();
                
                studentMarks(student);
            }
            else if (select == 4) {
                check = false;
            }
        }
        while (check == true);    
    }
    
    public static void studentMarks(int student) throws IOException {
        
        do {
            System.out.println("\n1 - Update Marks \n2 - View Marks \n3 - Course Management");
            int select = Integer.parseInt(myInput.readLine());
            
            if (select == 1) {
                displayMarks(student);
                int choice = select();
                
                updateMarks(student, choice);
                displayMarks(student);
            }
            else if (select == 2) {
                displayMarks(student);
            }
            else if (select == 3) {
                courseManagement();
            }
            
        }
        while (true);
    }
    
    public static void updateMarks(int student, int select) throws IOException {
        
        System.out.println("\n" + students.get(student).getCourses().get(select) + "\t" + students.get(student).getCourses().get(select).getMark() + "%");
        System.out.print("Enter new mark: ");
        int newMark = Integer.parseInt(myInput.readLine());
        
        students.get(student).getCourses().get(select).setMark(newMark);
        
    }
    
    public static void displayMarks (int student) {
        
        int sum = 0;
        
        System.out.println("\n" + students.get(student).getFirstName() + " " + students.get(student).getLastName() + "\t" + students.get(student).getStudentID());
        
        for (int i = 0; i < students.get(student).getCourses().size(); i++) {
            System.out.println(i+1 + " - " + students.get(student).getCourses().get(i) + "\n\tMark: " + students.get(student).getCourses().get(i).getMark() + "%");
            
            sum += students.get(student).getCourses().get(i).getMark(); 
        }
        
        int avg = sum/students.get(student).getCourses().size();
        System.out.println("Average: " + avg + "%");

    }
    
    public static void removeCourse() throws IOException {
        displayStudents();
        int select = select();
        
        for (int i = 0; i < students.get(select).getCourses().size(); i++) {
            System.out.println(i+1 + " - " + students.get(select).getCourses().get(i));
        }
        
        int selectCourse = select();
        
        removeCourse(select, selectCourse);

        
    }
    
    public static void assignCourse() throws IOException {
        
        displayStudents();
        int select = select();
        
        displayCourses();
        int d = select();
        
        addCourse(select,d); 
    }
    
    public static int select() throws IOException {
        
        int select = Integer.parseInt(myInput.readLine());
        select = select - 1;
        return select;
    }
    
    public static void displayStudents () {

        int i = 0;
        for (Student s: students) {
            
            i++;
            
            ArrayList <String> studentCourses = students.get(i-1).printCourses(i-1);
            
            System.out.println("\n" + i + " - " + s);
            
            for (int z = 0; z < studentCourses.size(); z++) {
                System.out.println(studentCourses.get(z));
            }
            
        }
    }
    
    public static void displayCourses () {
        
        System.out.println("\nCOURSES:");
        
        int i = 0;
        for (Course c: courses) {
            
            System.out.println(i+1 + " - " + c); 
            i++;
        }
    }
    
    public static void addCourse(int student, int course) {

        students.get(student).addCourse(courses.get(course));
    }
    
    public static void removeCourse(int c, int i) {
        
        students.get(c).removeCourse(i);
        
    }
    
    public static void addCourse() throws IOException {
        System.out.print("\nCourse Name: ");
        String courseName = myInput.readLine();
        System.out.print("Course Code: ");
        String courseCode = myInput.readLine();
        System.out.print("Course Description: ");
        String description = myInput.readLine();
        System.out.print("Credit Value: ");
        int creditValue = Integer.parseInt(myInput.readLine());
        
        courses.add(new Course(creditValue, courseName, courseCode, description));
            
    }
}
