package com.example.project2question3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.*;


public class HelloController {
    //database information login and to connect
    static String dbURL = "jdbc:mysql://localhost/hospital";
    static String username = "root";
    static String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    static int PatientIDInt;

    static Statement PatientInfoStatement;
    static ResultSet Patientresult;

    static String PatientName;
    static String PatientGender;
    static int PatientWeight;
    static double PatientHeight;

    static String PatientName2;
    static String PatientGender2;
    static int PatientWeight2;
    static double PatientHeight2;

    static String PatientName3;
    static String PatientGender3;
    static int PatientWeight3;
    static double PatientHeight3;

    static String PatientName4;
    static String PatientGender4;
    static int PatientWeight4;
    static double PatientHeight4;

    static String PatientName5;
    static String PatientGender5;
    static int PatientWeight5;
    static double PatientHeight5;

    static String PatientName6;
    static String PatientGender6;
    static int PatientWeight6;
    static double PatientHeight6;

    static int BMIWeight;
    static double BMIHeight;
    static double CalculatedBMI;

    static int progressID = 1;
    static String stringProgressID;

    @FXML
    public TextField PatientIDTextField;
    public TextField NameTextField;
    public TextField GenderTextField;
    public TextField WeightTextField;
    public TextField HeightTextField;
    public TextField MessageTextField;
    public RadioButton MaleRadio;
    public RadioButton FemaleRadio;

    //Display button
    @FXML
    public void DisplayButton(ActionEvent e) throws IOException {
        PatientIDInt = Integer.parseInt(PatientIDTextField.getText());

        //switch case to set text-fields depending on patient id input
        switch (PatientIDInt) {
            case 1:
                NameTextField.setText(PatientName);
                GenderTextField.setText(PatientGender);
                WeightTextField.setText(String.valueOf(PatientWeight));
                HeightTextField.setText(String.valueOf(PatientHeight));
                FemaleRadio.setSelected(true);
                break;

            case 2:
                NameTextField.setText(PatientName2);
                GenderTextField.setText(PatientGender2);
                WeightTextField.setText(String.valueOf(PatientWeight2));
                HeightTextField.setText(String.valueOf(PatientHeight2));
                FemaleRadio.setSelected(false);
                MaleRadio.setSelected(true);
                break;

            case 3:
                NameTextField.setText(PatientName3);
                GenderTextField.setText(PatientGender3);
                WeightTextField.setText(String.valueOf(PatientWeight3));
                HeightTextField.setText(String.valueOf(PatientHeight3));
                MaleRadio.setSelected(false);
                FemaleRadio.setSelected(true);
                break;

            case 4:
                NameTextField.setText(PatientName4);
                GenderTextField.setText(PatientGender4);
                WeightTextField.setText(String.valueOf(PatientWeight4));
                HeightTextField.setText(String.valueOf(PatientHeight4));
                MaleRadio.setSelected(true);
                FemaleRadio.setSelected(false);
                break;

            case 5:
                NameTextField.setText(PatientName5);
                GenderTextField.setText(PatientGender5);
                WeightTextField.setText(String.valueOf(PatientWeight5));
                HeightTextField.setText(String.valueOf(PatientHeight5));
                MaleRadio.setSelected(false);
                FemaleRadio.setSelected(true);
                break;

            case 6:
                NameTextField.setText(PatientName6);
                GenderTextField.setText(PatientGender6);
                WeightTextField.setText(String.valueOf(PatientWeight6));
                HeightTextField.setText(String.valueOf(PatientHeight6));
                MaleRadio.setSelected(true);
                FemaleRadio.setSelected(false);
                break;
        }
        //Dialog pane pop up
        Alert alertBMI = new Alert(Alert.AlertType.INFORMATION);
        alertBMI.setTitle("Message");
        alertBMI.setHeaderText("The patient's record was successfully displayed!");
        alertBMI.show();
    }

    //Calculate Bmi button
    @FXML
    public void CalculateBMIButton (ActionEvent e){
        //calculate bmi
        BMIWeight = Integer.parseInt(WeightTextField.getText());
        BMIHeight = Double.parseDouble(HeightTextField.getText());
        CalculatedBMI = BMIWeight / java.lang.Math.pow(BMIHeight, 2);

        //To check if male or female
        //To set TextField text depending on if male or female and bmi
        if (MaleRadio.isSelected()){
            if(CalculatedBMI < 22.5){
                MessageTextField.setText("You are underweight");
            }
            if(CalculatedBMI >= 22.5 && CalculatedBMI < 29.5){
                MessageTextField.setText("You are ideal weight");
            }
            if(CalculatedBMI >= 29.5 && CalculatedBMI < 32.9){
                MessageTextField.setText("You are overweight");
            }
            if(CalculatedBMI > 33){
                MessageTextField.setText("Obese");
            }
        } else {
            if(CalculatedBMI < 18.5){
                MessageTextField.setText("You are underweight");
            }
            if(CalculatedBMI >= 18.5 && CalculatedBMI < 24.5){
                MessageTextField.setText("You are ideal weight");
            }
            if(CalculatedBMI >= 24.5 && CalculatedBMI < 29.9){
                MessageTextField.setText("You are overweight");
            }
            if(CalculatedBMI >= 30){
                MessageTextField.setText("You are Obese");
            }
        }

        //method to insert bmi record into database
        insertBMI();

        //Dialog pane pop up
        Alert alertBMI = new Alert(Alert.AlertType.INFORMATION);
        alertBMI.setTitle("Message");
        alertBMI.setHeaderText("You BMI is: " + CalculatedBMI);
        alertBMI.show();
    }

    //method to retrieve all the data from database
    public static void DBconnection(){
        Connection connection;

        try {
            //database connection
            connection = DriverManager.getConnection(dbURL, username, password);

            //sql query to select from patients database
            PatientInfoStatement = connection.createStatement();
            Patientresult = PatientInfoStatement.executeQuery("SELECT Name, Gender, Weight, Height " +
                    "FROM `patients database`");

                //info for patient 1
                Patientresult.next();
                PatientName = Patientresult.getString(1);
                PatientGender = Patientresult.getString(2);
                PatientWeight = Patientresult.getInt(3);
                PatientHeight = Patientresult.getDouble(4);

                //info for patient 2
                Patientresult.next();
                PatientName2 = Patientresult.getString(1);
                PatientGender2 = Patientresult.getString(2);
                PatientWeight2 = Patientresult.getInt(3);
                PatientHeight2 = Patientresult.getDouble(4);

                //info for patient 3
                Patientresult.next();
                PatientName3 = Patientresult.getString(1);
                PatientGender3 = Patientresult.getString(2);
                PatientWeight3 = Patientresult.getInt(3);
                PatientHeight3 = Patientresult.getDouble(4);

                //info for patient 4
                Patientresult.next();
                PatientName4 = Patientresult.getString(1);
                PatientGender4 = Patientresult.getString(2);
                PatientWeight4 = Patientresult.getInt(3);
                PatientHeight4 = Patientresult.getDouble(4);

                //info for patient 5
                Patientresult.next();
                PatientName5 = Patientresult.getString(1);
                PatientGender5 = Patientresult.getString(2);
                PatientWeight5 = Patientresult.getInt(3);
                PatientHeight5 = Patientresult.getDouble(4);

                //info for patient 6
                Patientresult.next();
                PatientName6 = Patientresult.getString(1);
                PatientGender6 = Patientresult.getString(2);
                PatientWeight6 = Patientresult.getInt(3);
                PatientHeight6 = Patientresult.getDouble(4);

            //closing of statement and result set and connection
            Patientresult.close();
            PatientInfoStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error Connected to database");
            throw new RuntimeException(e);
        }
    }

    // method for inserting bmi record into database
    public static void insertBMI(){
        Connection connection;
        try {
            //database connection
            connection = DriverManager.getConnection(dbURL, username, password);

            ProgressIDincrement();

            //sql query command
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO `bmi progress`(progresld, userID, BMI)" + " VALUES ('" + progressID +
                    "' , '" + PatientIDInt + "', '" + (Math.round(CalculatedBMI * 100.0)/100.0) + "')";

            //execute query command
            stmt.executeUpdate(sql);
            System.out.println("Records added to BMI Progress Table");

            stmt.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Could not connect to Database");
            throw new RuntimeException(e);
        }
    }

    //method to increment progress ID
    public static void ProgressIDincrement() {
        Connection connection;

        try {
            connection = DriverManager.getConnection(dbURL, username, password);

            PatientInfoStatement = connection.createStatement();
            Patientresult = PatientInfoStatement.executeQuery("select * from `bmi progress` " +
                    "ORDER BY progresld DESC LIMIT 1;");

            //gets result set
            Patientresult.next();
            stringProgressID = Patientresult.getString(1);

            //turns string into int and increments it
            progressID = Integer. parseInt(stringProgressID);
            System.out.println(progressID);
            progressID = progressID + 1;

        } catch (SQLException e) {
            System.out.println("Something went wrong connecting to database");
            throw new RuntimeException(e);
        }
    }
}


