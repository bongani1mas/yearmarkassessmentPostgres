package za.co.momentum.javabasics;

import za.co.momentum.javabasics.dbconnection.DBConnection;
import za.co.momentum.javabasics.dbconnection.service.StudentData;
import za.co.momentum.javabasics.filesprocessor.FileProcessorImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RunStudentApps {

    public static void main(String[] args) throws SQLException {
        FileProcessorImpl fileProcessorImpl = new FileProcessorImpl();

        String [] studentArrData = fileProcessorImpl.readFileData("src/main/resources/studentData.txt");

//        for ( int i = 0; i<studentArrData.length; i++) {
//
//            System.out.println(studentArrData[i]);
//
//
//        }

/*
        StudentData studentData = new StudentData();

        List<String> studentToBeDisplayed = studentData.getStudent("G");
        for(String displayStudent : studentToBeDisplayed){
            System.out.println(displayStudent);
        }*/

        StudentData studentData = new StudentData();
        studentData.addStudent();

    }

}
