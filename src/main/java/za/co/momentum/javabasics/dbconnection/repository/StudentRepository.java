package za.co.momentum.javabasics.dbconnection.repository;

import za.co.momentum.javabasics.dbconnection.model.StudentEntity;

public interface StudentRepository {

    void insertStudent(StudentEntity studentEntity);
    StudentEntity getStudent(int studentId);
    void updateStudent(int studentID);
    void deleteStudent(int studentID);
}
