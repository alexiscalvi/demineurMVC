/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.Modele;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author calvi
 */
public class DemineurMVC extends Application {
    
    // modèle : ce qui réalise le calcule de l'expression
    private Modele m;
    // affiche la saisie et le résultat
    private Text affichage;
    private Modele gridGame;
    
    @Override
    public void start(Stage stage) {
        Menu partyMenu = new Menu("Option"); 
        MenuItem newParty = new MenuItem("Nouvelle partie"); 
        Menu helpMenu = new Menu("Aide"); 
        MenuBar menuBar = new MenuBar(); 
        partyMenu.getItems().add(newParty);
        menuBar.getMenus().addAll(partyMenu, helpMenu);
        stage.setTitle("Demineur");
        newParty.setOnAction(event -> {
            //Création nouvelle partie = nouveau modèle
            this.gridGame = new Modele(3,5,5);
        });

        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        //creation du terrain
        BorderPane borderPane = new BorderPane();
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        borderPane.setTop(menuBar);  
        root.getChildren().addAll(borderPane);
        
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        m = new Modele(10,8,8);
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                VueCellule cv = new VueCellule(m.getCellule(i, j));
                gridPane.add(cv, i, j);
            }
        }
        borderPane.setCenter(gridPane);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
     public static void main(String[] args) {
        launch(args);
    }
}
