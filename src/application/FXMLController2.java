/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

/**
 *
 * @author Lorene
 */
public class FXMLController2 implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    private BorderPane borderpane;
    private Label titre;
    private Button classement;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //--------BORDERPANE--------
        borderpane = new BorderPane();
        borderpane.setPrefSize(600, 550);

        //---TITRE---
        Label titre = new Label("Jouez au Taquin :-)");
        titre.setFont(Font.font(STYLESHEET_MODENA, 30));
        titre.setPrefSize(600, 80);
        borderpane.setTop(titre);
        titre.setAlignment(Pos.CENTER);

        Button classement = new Button("Classement");
        classement.setMaxWidth(Double.MAX_VALUE);
        

        borderpane.setCenter(classement);
        classement.setAlignment(Pos.CENTER);

        //--------BORDER->SCENE--------
        anchorpane.getChildren().add(borderpane);

        classement.getStyleClass().add("button");

    }

}
