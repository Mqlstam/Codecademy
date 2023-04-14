package com.codecademy.controllers;

import com.codecademy.domain.Module;

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

public class EditModuleController {
    public static void display(Module module){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        
        TextField contactName = new TextField();
        TextField contactEmail = new TextField();
        TextField version = new TextField();
        Label moduleLabel = new Label("Module");
        moduleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        contactName.setPromptText("Contact name");
        contactEmail.setPromptText("Contact email");
        version.setPromptText("version");
       
        Button back = new Button("Back");
        Button update = new Button("update");
      
        HBox hBox = new HBox();
        hBox.getChildren().addAll(update, back);
        hBox.setSpacing(70);
        back.setPrefSize(50, 30);
        update.setPrefSize(50, 30);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(moduleLabel, contactName , contactEmail, version, hBox);
        
        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vBox);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


        update.setOnAction(e -> {
           
        });

        back.setOnAction(e -> {
            ModuleController.display();
            stage.close();
        });
    }
       
}