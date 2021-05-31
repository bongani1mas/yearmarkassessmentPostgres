package za.co.momentum.javabasics.dbconnection.service;

import za.co.momentum.javabasics.dbconnection.DBConnection;
import za.co.momentum.javabasics.dbconnection.model.StudentEntity;
import za.co.momentum.javabasics.dbconnection.repository.StudentRepository;
import za.co.momentum.javabasics.filesprocessor.FileProcessorImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;

public class StudentData {
    StudentRepository studentRepository;
    DBConnection dbConnection = new DBConnection();


    private StudentEntity extractStudentFromFile(String studentFromFile) {
        StudentEntity studentEntity = new StudentEntity();

        String firstCmStr = studentFromFile.substring(studentFromFile.indexOf(",") + 1);
        String firstName = studentFromFile.substring(0, studentFromFile.indexOf(",")).trim();
        studentEntity.setName(firstName);

        String scndtCmStr = firstCmStr.substring(firstCmStr.indexOf(",") + 1).trim();

        String lastName = firstCmStr.substring(0, firstCmStr.indexOf(",")).trim();
        studentEntity.setSurname(lastName);

        int assignment_1 = Integer.valueOf(scndtCmStr.substring(0, scndtCmStr.indexOf(",")));
        studentEntity.setAssignment1(assignment_1);

        String trdtCmStr = scndtCmStr.substring(scndtCmStr.indexOf(",") + 1).trim();

        int assignment_2 = Integer.valueOf(trdtCmStr.substring(0, trdtCmStr.indexOf(",")));
        studentEntity.setAssignment2(assignment_2);

        String frthCmStr = trdtCmStr.substring(trdtCmStr.indexOf(",") + 1).trim();

        int assignment_3 = Integer.valueOf(frthCmStr.substring(0, frthCmStr.indexOf(",")));
        studentEntity.setAssignment3(assignment_3);

        studentEntity.setYearMark(0);
        studentEntity.setExamEntranceStatus("No entry");

        return studentEntity;
    }

    public void addStudent() throws SQLException {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.connectToDB();

        FileProcessorImpl fileProcessorImpl = new FileProcessorImpl();


        try {
            String[] studentFromFile = fileProcessorImpl.readFileData("src/main/resources/studentData.txt");

            System.out.println(studentFromFile.length);
            String sql = "INSERT INTO public.student (name, surname, assignment1, assignment2, assignment3, yearMark, examEntranceStatus) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int a = 0; a < studentFromFile.length - 1; a++) {

                StudentEntity studentEntityObject = extractStudentFromFile(studentFromFile[a]);


                preparedStatement.setString(1, studentEntityObject.getName());
                preparedStatement.setString(2, studentEntityObject.getSurname());
                preparedStatement.setInt(3, studentEntityObject.getAssignment1());
                preparedStatement.setInt(4, studentEntityObject.getAssignment2());
                preparedStatement.setInt(5, studentEntityObject.getAssignment3());
                preparedStatement.setInt(6, studentEntityObject.getYearMark());
                preparedStatement.setString(7, studentEntityObject.getExamEntranceStatus());


                preparedStatement.executeUpdate();
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }

    public List<String> getStudent(String letter) {

        DBConnection dbConnection = new DBConnection();

        String sql = "SELECT id, name, surname, assignment1, assignment2, assignment3, yearmark, examentrancestatus FROM student WHERE left(surname,1) = 'G'";

        List<String> studentToBeDisplayed = new ArrayList<>();


        try (
                Statement stmt = dbConnection.connectToDB().createStatement();

                ResultSet resultSet = stmt.executeQuery(sql)) {


            while (resultSet.next()) {

                String surname = resultSet.getString("surname");
                System.out.println(surname);
                if (surname.substring(0, 1).equalsIgnoreCase("G")) {

                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int assignment1 = resultSet.getInt("assignment1");
                    int assignment2 = resultSet.getInt("assignment2");
                    int assignment3 = resultSet.getInt("assignment3");
                    int yearMark = resultSet.getInt("yearMark");
                    String examEntranceStatus = resultSet.getString("examEntranceStatus");

                    studentToBeDisplayed.add("name: " + name + ", surname" + surname + ", assignment1" + assignment1 + ", assignment2" + assignment2 + ", assignment3" + assignment3 + ", yearMark" + yearMark + ", examEntranceStatus " + examEntranceStatus);

                }


            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return studentToBeDisplayed;

    }

    public void updateStudent(int id, String newSurname) {

        String updateSurnameSQL = "UPDATE student SET surname = ? where id = ? ";

        try (PreparedStatement statement = dbConnection.connectToDB().prepareStatement(updateSurnameSQL)) {

            statement.setString(1, newSurname);
            statement.setInt(2, id);


            int numberOfUpdatedRows = statement.executeUpdate();

            if (numberOfUpdatedRows > 0) {
                System.out.println(numberOfUpdatedRows + " records updated successfully");
            } else {
                System.out.println("Records not updated");
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void updateExamStatus (String examEntranceStatus) {

        String updateExamSQL = "UPDATE student SET examentrancestatus = ? WHERE examentrancestatus is null";

        try (PreparedStatement statement = dbConnection.connectToDB().prepareStatement(updateExamSQL)) {

            statement.setString(1, examEntranceStatus);

            int numberOfUpdatedRows = statement.executeUpdate();

            if (numberOfUpdatedRows > 0) {
                System.out.println(numberOfUpdatedRows + " records updated successfully");
            } else {
                System.out.println("Records not updated");
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }


    public void deleteStudent(int id) {


        String deleteSQL = "delete From student where id = ? ";

        try (PreparedStatement statement = dbConnection.connectToDB().prepareStatement(deleteSQL)) {

            statement.setInt(1, id);


            int numberOfUpdatedRows = statement.executeUpdate();

            if (numberOfUpdatedRows > 0) {
                System.out.println("Records deleted successfully");
            } else {
                System.out.println("Records not updated");
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }


    }

    public void updateYearMark (String examEntranceStatus) {

        String updateYearMarkSQL = "UPDATE student SET yearmark = ? WHERE student.yearmark is null";

        try (PreparedStatement statement = dbConnection.connectToDB().prepareStatement(updateYearMarkSQL)) {

            statement.setString(1, examEntranceStatus);

            int numberOfUpdatedRows = statement.executeUpdate();

            if (numberOfUpdatedRows > 0) {
                System.out.println(numberOfUpdatedRows + " records updated successfully");
            } else {
                System.out.println("Records not updated");
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }



}
