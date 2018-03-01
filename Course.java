/*
Program: Create Course and add/remove student to/from the course
Author: Hojung An
Date: February 28th 2018*/

import java.util.Arrays;

public class Course {

    private String name;
    /*Improve students array by:
    * private ArrayList<String> students = new ArrayList<>();*/
    private String[] students;
    private int numberOfStudents;

    // Create course with passed course name
    public Course(String courseName) {
        name = courseName;
        // When course is creased, students array is initialized to size of 10
        students = new String[10];
        numberOfStudents = 0;
    }

    public String getCourseName() {
        return name;
    }

    // Add new student to the course
    public void addStudent(String stuName) {
        /*Improve addStudent using ArrayList
        * students.add(stuName);
        * numberOfStudents++;*/

        // If students array is maxed
        if(numberOfStudents == students.length) {
            // Copy current students array to temp array
            String[] temp = Arrays.copyOf(students, numberOfStudents);

            // Increase number of students
            numberOfStudents++;

            // Copy temp to students array with increased size(numberOfStudents)
            students = Arrays.copyOf(temp, numberOfStudents);

            // Set the last element of the students array to new stuName
            students[numberOfStudents-1] = stuName;
        } else {
            students[numberOfStudents] = stuName;
            numberOfStudents++;
        }
    }

    public void dropStudent(String stuName) {
        // Find index of stuName
        int index = 0;
        for(int i = 0; i < numberOfStudents; i++) {
            if(students[i] == stuName) {
                index = i;
            }
        }

        // Replace by shifting the array
        for(int j = index; j < numberOfStudents-1; j++) {
            students[j] = students[j+1];
        }

        numberOfStudents--;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public static void main(String[] args) {
        Course jac = new Course("Intro to Java");
        jac.addStudent("Peter Jones");
        jac.addStudent("Kim Smith");
        jac.addStudent("Anne Kennedy");
        jac.addStudent("Eve Kim");
        System.out.println("Number of students in " + jac.getCourseName() + ": " + jac.getNumberOfStudents());
        String[] studentList = jac.getStudents();
        for(int i = 0; i < jac.getNumberOfStudents(); i++) {
            System.out.print(studentList[i] + ", ");
        }
        System.out.println();

        jac.dropStudent("Eve Kim");
        System.out.println("Number of students in " + jac.getCourseName() + ": " + jac.getNumberOfStudents());
        for(int i = 0; i < jac.getNumberOfStudents(); i++) {
            System.out.print(studentList[i] + ", ");
        }
        System.out.println();

        System.out.println();
        Course course2 = new Course("Course2");
        course2.addStudent("student1");
        course2.addStudent("student2");
        System.out.println("Number of students in course2: " + course2.getNumberOfStudents());
    }

}
