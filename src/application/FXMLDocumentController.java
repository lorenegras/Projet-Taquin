/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.Panel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javax.swing.text.View;
import model.*;

public class FXMLDocumentController implements Initializable {

    @FXML
    private GridPane grille;
    @FXML
    private AnchorPane anchorpane;
    private BorderPane borderpane;
    private Label titre;
    private Button aide;
    private VBox box;
    private Button classement;
    private Button ia;
    private Button melanger;
    private Button retour;
    private Button init;
    private Label score;
    private TextField points;
    private Pane[][] blocs;
    private Label[][] num;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //demander pseudo à la connexion
        Joueur joueur = new Joueur("co");
        //taille avec bouton
        Taquin jeu = new Taquin(joueur, 4);
        jeu.remplirTableau();

        this.blocs = new Pane[jeu.getTaille()][jeu.getTaille()];

        //--------BORDERPANE--------
        borderpane = new BorderPane();
        borderpane.setPrefSize(600, 550);
        //borderpane.getChildren().re

        //---GRILLE---
        grille = new GridPane();

        for (int i = 0; i < jeu.getTaille(); i++) {
            ColumnConstraints column1 = new ColumnConstraints(100);
            RowConstraints line = new RowConstraints(100);
            grille.getColumnConstraints().add(column1);
            grille.getRowConstraints().add(line);
        }

        this.num = new Label[jeu.getTaille()][jeu.getTaille()];
        for (int i = 0; i < jeu.getTaille(); i++) {
            for (int j = 0; j < jeu.getTaille(); j++) {
                this.blocs[i][j] = new Pane();
                num[i][j] = new Label(String.valueOf(jeu.getPlateau()[i][j].getNum()));
                //this.blocs[i][j].setPrefSize(10,10);
                this.num[i][j].setStyle("-fx-font-size:50px; -fx-font-weight:bold;");
                
                this.blocs[i][j].setStyle("-fx-background-color:#66CC33;");
            }
        }

        for (int i = 0; i < jeu.getTaille(); i++) {
            for (int j = 0; j < jeu.getTaille(); j++) {
                blocs[i][j].getChildren().add(num[i][j]);
                grille.add(blocs[i][j], j, i);
            }
            //blocs[i].getChildren().add(labels[i]);
        }

        for (int i = 0; i < jeu.getTaille(); i++) {
            for (int j = 0; j < jeu.getTaille(); j++) {
                blocs[i][j].setVisible(true);
                num[i][j].setVisible(true);
            }
        }

        grille.setAlignment(Pos.CENTER);
        grille.setGridLinesVisible(true);

        borderpane.setCenter(grille);

        //---TITRE---
        Label titre = new Label("Jouez au Taquin :-)");
        titre.setFont(Font.font(STYLESHEET_MODENA, 30));
        titre.setPrefSize(600, 80);
        borderpane.setTop(titre);
        titre.setAlignment(Pos.CENTER);

        //---BOUTON AIDE---
        Button aide = new Button("Aide");
        aide.setMaxWidth(Double.MAX_VALUE);
        aide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        //---BOUTON CLASSEMENT---
        Button classement = new Button("Classement");
        classement.setMaxWidth(Double.MAX_VALUE);
        classement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Youpiiii");
            }
        });

        //---BOUTON IA---
        Button ia = new Button("IA");
        ia.setMaxWidth(Double.MAX_VALUE);
        ia.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("opop");
            }
        });

        //---BOUTON INIT---
        Button init = new Button("Initialiser");
        init.setMaxWidth(Double.MAX_VALUE);
        init.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("init");
            }
        });

        //---BOUTON MELANGER---
        Button melanger = new Button("Mélanger");
        melanger.setMaxWidth(Double.MAX_VALUE);
        melanger.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("melanger");
            }
        });

        //---BOUTON RETOUR---
        Button retour = new Button("Retour");
        retour.setMaxWidth(Double.MAX_VALUE);
        retour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("retour");
            }
        });

        //---SCORE---
        Label score = new Label("Score :");
        score.setFont(Font.font(STYLESHEET_MODENA, 15));
        TextField points = new TextField();

        //---VBOX GAUCHE---
        VBox box = new VBox(3);
        box.setPrefWidth(110);
        box.setPadding(new Insets(1));
        box.setSpacing(10);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(melanger, score, points, classement, init, ia, aide, retour);
        borderpane.setLeft(box);

        //--------BORDER->SCENE--------
        anchorpane.getChildren().add(borderpane);

        //--------LIEN CSS--------
        titre.getStyleClass().add("titre");
        anchorpane.getStyleClass().add("anchorpane");
        borderpane.getStyleClass().add("borderpane");
        aide.getStyleClass().add("button");
        box.getStyleClass().add("box");
        score.getStyleClass().add("score");
        points.getStyleClass().add("points");
        
        borderpane.setOnKeyPressed((KeyEvent event1) -> {
            System.out.println("lolilol");
            //mouvement(jeu.getPlateau(), event1.getText());
            //borderpane.requestLayout();
        });
              
    

    }
    /*@FXML
    public void onKeyPressed(KeyEvent e) throws IOException{
        System.out.println("azerty");
    }*/

}
