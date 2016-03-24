

package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
//import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
import model.*;

public class FXMLDocumentController implements Initializable {
    /*
     * Variables globales correspondant à des objets définis dans la vue (fichier .fxml)
     * Ces variables sont ajoutées à la main et portent le même nom que les fx:id dans Scene Builder
     */

    /*@FXML
     private Label score; // value will be injected by the FXMLLoader*/
    @FXML
    private GridPane grille;
    @FXML
    private Pane fond; // panneau recouvrant toute la fenêtre
    private BorderPane fond2;

    // variables globales non définies dans la vue (fichier .fxml)
    /*private final Pane p = new Pane(); // panneau utilisé pour dessiner une tuile "2"
     private final Label c = new Label("2");
     private int x = 24, y = 191;
     private int objectifx = 24, objectify = 191;
     private Taquin m;*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //création d'un groupe root (racine, 1 seul par scene)
        fond2 = new BorderPane();

        grille = new GridPane();

        for (int i = 0; i < 4; i++) {
            ColumnConstraints column1 = new ColumnConstraints(100);
            RowConstraints line = new RowConstraints(100);
            grille.getColumnConstraints().add(column1);
            grille.getRowConstraints().add(line);
        }

        grille.setAlignment(Pos.CENTER);
        grille.setGridLinesVisible(true);


        //ajoute au groupe le rectangle
        fond2.setCenter(grille);

        //ajoute bouton dans groupe 

        Text titre = new Text();
        titre.setText("Jouez au Taquin !");
        //titre.setFont(Font.font(STYLESHEET_MODENA, 30));
        titre.getStyleClass().add("title");
      
        fond2.setTop(titre);
        fond.getChildren().add(fond2);

        
    }
    
}
