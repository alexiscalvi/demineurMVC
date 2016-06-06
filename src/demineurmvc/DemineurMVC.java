/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineurmvc;

import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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
    Modele m;
    // affiche la saisie et le résultat
    Text affichage;
    
    @Override
    public void start(Stage stage) {
        final Menu partyMenu = new Menu("Option"); 
        final Menu helpMenu = new Menu("Aide"); 
        final MenuBar menuBar = new MenuBar(); 
        menuBar.getMenus().setAll(partyMenu, helpMenu);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setTitle("Demineur");
        
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        //creation du terrain
        
        root.getChildren().add(menuBar);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
     public static void main(String[] args) {
        launch(args);
    }
}
