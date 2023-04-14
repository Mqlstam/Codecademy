package com.codecademy.controllers;


import java.time.LocalDate;

import com.codecademy.dao.StudentDAO;
import com.codecademy.dao.StudentDAOImpl;
import com.codecademy.database.DbConnection;
import com.codecademy.domain.Address;
import com.codecademy.domain.Student;
import com.codecademy.logic.Logic;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EditStudentController {
    private static String genderVal;

    public static void display(Student student) {
        StudentDAO studentDAO = new StudentDAOImpl(new DbConnection());
        Logic logic = new Logic();
    
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2202133), Miquel Stam(2192528)");
        stage.setWidth(900);
        stage.setHeight(700);
        stage.setResizable(false);
    
        FlowPane root = new FlowPane();
        Label studentLabel = new Label("Student");
        studentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
    
        TextField name = new TextField();
        TextField email = new TextField();
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        RadioButton other = new RadioButton("Other");
        ToggleGroup genderGroup = new ToggleGroup();
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);
        other.setToggleGroup(genderGroup);

        if (student.getGender() == null) {
            genderGroup.selectToggle(null);
        } else if (student.getGender().equals("Male")) {
            male.setSelected(true);
        } else if (student.getGender().equals("Female")) {
            female.setSelected(true);
        } else if (student.getGender().equals("Other")) {
            other.setSelected(true);
        }

        genderGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            if (genderGroup.getSelectedToggle() != null) {
                genderVal = ((RadioButton) genderGroup.getSelectedToggle()).getText();
            }
        });

        male.setText("Male");
        female.setText("Female");
        other.setText("Other");

        male.setUserData("Male");
        female.setUserData("Female");
        other.setUserData("Other");
    
        TextField street = new TextField();
        TextField houseNumber = new TextField();
        TextField postalCode = new TextField();
        TextField city = new TextField();
        TextField country = new TextField();
        TextField birthdayDay = new TextField();
        TextField birthdayMonth = new TextField();
        TextField birthdayYear = new TextField();
    
        email.setPromptText("Email");
        email.setText(student.getEmail());
        email.setEditable(false);
        name.setPromptText("Name");
        name.setText(student.getName());
        street.setPromptText("Street");
        street.setText(student.getAddress().getStreet());
        houseNumber.setPromptText("House Number");
        houseNumber.setText(student.getAddress().getHouseNumber());
        postalCode.setPromptText("Postal Code");
        postalCode.setText(student.getAddress().getPostalCode());
        city.setPromptText("City");
        city.setText(student.getAddress().getCity());
        country.setPromptText("Country");
        country.setText(student.getAddress().getCountry());
        birthdayDay.setPromptText("Day");
        birthdayMonth.setPromptText("Month");
        birthdayYear.setPromptText("Year");
        LocalDate birthDate = student.getBirthDate();
        if (birthDate != null) {
            birthdayDay.setText(Integer.toString(birthDate.getDayOfMonth()));
            birthdayMonth.setText(Integer.toString(birthDate.getMonthValue()));
            birthdayYear.setText(Integer.toString(birthDate.getYear()));
        }
    
        Button back = new Button("Back");
        Button update = new Button("Update");
        update.setOnAction(e -> {
            int dayVal = Integer.parseInt(birthdayDay.getText());
            int monthVal = Integer.parseInt(birthdayMonth.getText());
            int yearVal = Integer.parseInt(birthdayYear.getText());
            if (!Logic.dateTool(dayVal, monthVal, yearVal)) {
                System.out.println("Invalid date");
                return;
            }
            Address updatedAddress = new Address(street.getText(), houseNumber.getText(), postalCode.getText(), city.getText(), country.getText());
            LocalDate updatedBirthDate = LocalDate.of(yearVal, monthVal, dayVal);
            String selectedGender = "";
            if (genderGroup.getSelectedToggle() != null) {
                selectedGender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
            }
            studentDAO.updateStudent(new Student(email.getText(), name.getText(), updatedBirthDate, selectedGender, updatedAddress));
            stage.close();
            StudentController.display();
        });
    
        HBox hBox = new HBox();
        hBox.getChildren().addAll(update, back);
        hBox.setSpacing(70);
        back.setPrefSize(50, 30);
        update.setPrefSize(70, 30);

        HBox birtdayBox = new HBox();
        birtdayBox.getChildren().addAll(birthdayDay, birthdayMonth, birthdayYear);
        birtdayBox.setSpacing(5);
    
        VBox vBox = new VBox();
        HBox gender = new HBox();
        gender.getChildren().addAll(male, female, other);
        gender.setSpacing(5);
        vBox.getChildren().addAll(studentLabel, name, email, gender , street, houseNumber, postalCode, city, country, birtdayBox, hBox);
        vBox.setSpacing(25);
    
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vBox);
        Scene scene = new Scene(root);
    
        back.setOnAction(e -> {
            stage.close();
            StudentController.display();
        });
    
        stage.setScene(scene);
        stage.show();
    }

}
