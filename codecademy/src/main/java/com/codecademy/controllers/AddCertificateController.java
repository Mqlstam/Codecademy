package com.codecademy.controllers;


import com.codecademy.dao.CertificateDAO;
import com.codecademy.dao.CertificateDAOimpl;
import com.codecademy.database.DbConnection;
import com.codecademy.domain.Certificate;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddCertificateController {
    public static void display(){

        DbConnection dbConnection = new DbConnection();
        CertificateDAO certificateDAO = new CertificateDAOimpl(dbConnection);


        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        Label webcast = new Label("Add Certificate");
        webcast.setFont(Font.font("Arial",FontWeight.BOLD ,30));
        Scene scene = new Scene(root);
        TextField grade = new TextField();
        TextField employee = new TextField();
        
        grade.setPromptText("grade");
        employee.setPromptText("Employee");
       
        Button back = new Button("Back");
        Button save = new Button("Save");
      
        HBox hBox = new HBox();
        hBox.getChildren().addAll(save, back);
        hBox.setSpacing(70);
        back.setPrefSize(50, 30);
        save.setPrefSize(50, 30);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(webcast, grade, employee, hBox);
        
        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vBox);

        

        save.setOnAction(e -> {
            double gradeValue = Double.parseDouble(grade.getText());
            certificateDAO.addCertificate(new Certificate(gradeValue, employee.getText()));
            stage.close();
            CertificateController.display();
        });

        back.setOnAction(e -> {
            stage.close();
            CertificateController.display();
        });

        stage.setScene(scene);
        stage.show();
    }
}
