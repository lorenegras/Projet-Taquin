/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Insets;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Joueur;

/**
 *
 * @author Lorene
 */
public class Main extends Application {

    //class Taquin hérite de la class Application
    
    /*  Interface graphique de l'application */
    @Override
    public void start(Stage primaryStage) throws IOException {
       // primaryStage -> fenetre de l'application

       /* //créer un bouton
        Button btn = new Button();
        //titre du bouton
        btn.setText("Say 'Hello World'");
        //action bouton
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        //création d'un groupe root (racine, 1 seul par scene)
        BorderPane root = new BorderPane();

        //création de la scene
        Scene scene = new Scene(root, 800, 750, Color.RED);
        //change titre de la fenetre 
        primaryStage.setTitle("Taquin !");
        //ajoute la scene à la fenetre 
        

        GridPane grille = new GridPane();

        grille.setHgap(5);
        grille.setVgap(5);

        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
        column2.setHgrow(Priority.ALWAYS);
        grille.getColumnConstraints().addAll(column1, column2);
        
        
        Text t = new Text();
        t.setText("test");
        
        grille.add(t, 4, 0);

        //ajoute au groupe le rectangle
        root.setCenter(grille);

        //ajoute bouton dans groupe 
        root.setLeft(btn);

        Text titre = new Text();
        titre.setText("Jouez au Taquin !");
        titre.setFont(Font.font(STYLESHEET_MODENA, 20));
 

        root.setTop(titre);
        
        primaryStage.setScene(scene);

        //montre la fenetre
        primaryStage.show();*/
        
        
/*        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        boolean add = scene.getStylesheets().add("css/styles.css");
        
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    
     /*  Main   */
    
    public static void main(String[] args) {
        //lance l'application
        launch(args);
    }
}
