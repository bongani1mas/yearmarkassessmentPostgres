package za.co.momentum.javabasics.dbconnection.model;

public class StudentEntity {

    private int id;
    private String name;
    private String surname;
    private int assignment1;
    private int assignment2;
    private int assignment3;
    private int yearMark;
    private String examEntranceStatus;

    public StudentEntity() {
    }

    public StudentEntity(int id, String name, String surname, int assignment1, int assignment2, int assignment3, int yearMark, String examEntranceStatus) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
        this.yearMark = yearMark;
        this.examEntranceStatus = examEntranceStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAssignment1() {
        return assignment1;
    }

    public void setAssignment1(int assignment1) {
        this.assignment1 = assignment1;
    }

    public int getAssignment2() {
        return assignment2;
    }

    public void setAssignment2(int assignment2) {
        this.assignment2 = assignment2;
    }

    public int getAssignment3() {
        return assignment3;
    }

    public void setAssignment3(int assignment3) {
        this.assignment3 = assignment3;
    }

    public int getYearMark() {
        return yearMark;
    }

    public void setYearMark(int yearMark) {
        this.yearMark = yearMark;
    }

    public String getExamEntranceStatus() {
        return examEntranceStatus;
    }

    public void setExamEntranceStatus(String examEntranceStatus) {
        this.examEntranceStatus = examEntranceStatus;
    }
}
