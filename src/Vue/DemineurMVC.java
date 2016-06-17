/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.Modele;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author calvi
 */
public class DemineurMVC extends Application  {
    
    private Modele m;
    private Text affichage;
    private Modele gridGame;
    
    @Override
    public void start(Stage stage) {
        Menu partyMenu = new Menu("Option"); 
        MenuItem newParty = new MenuItem("Nouvelle partie"); 
        MenuBar menuBar = new MenuBar(); 
        partyMenu.getItems().add(newParty);
        menuBar.getMenus().addAll(partyMenu);
        stage.setTitle("Demineur");
        newParty.setOnAction(event -> {
            this.gridGame = new Modele(3,5,5);
        });
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        //creation du terrain
        BorderPane borderPane = new BorderPane();
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        borderPane.setTop(menuBar);  
        root.getChildren().addAll(borderPane);
        int x=8;
        int y=8;
        int b=10;
        newParty.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent t)
            {
                boolean check=false;
                while(!check){
                    Dialog param = new Dialog();
                    param.setResizable(false);
                    param.setTitle("New game");
                    GridPane gridNew = new GridPane();
                    Label lx = new Label("Nombre de colonnes : ");
                    TextNewGame tx = new TextNewGame();
                    Label ly = new Label("Nombre de lignes : ");
                    TextNewGame ty = new TextNewGame();
                    Label lb = new Label("Nombre de mines : ");
                    TextNewGame tb = new TextNewGame();
                    gridNew.add(lx, 0, 0);
                    gridNew.add(ly, 0, 1);
                    gridNew.add(lb, 0, 2);
                    gridNew.add(tx, 1, 0);
                    gridNew.add(ty, 1, 1);
                    gridNew.add(tb, 1, 2);
                    ButtonType create = new ButtonType("Nouvelle partie", ButtonBar.ButtonData.OK_DONE);
                    ButtonType cancel = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
                    param.getDialogPane().getButtonTypes().addAll(cancel,create);
                    param.getDialogPane().setContent(gridNew);
                    param.setContentText("Nouvelle aprtie");
                    try{
                        Optional<ButtonType> result = param.showAndWait();
                        int x=Integer.parseInt(tx.getText());
                        int y=Integer.parseInt(ty.getText());
                        int b=Integer.parseInt(tb.getText());
                        if(result.isPresent() && result.get().getButtonData()==ButtonBar.ButtonData.OK_DONE && b<x*y)
                        {
                            gridPane.getChildren().clear();
                            m = new Modele(b,x,y);
                            for(int i=0; i<x; i++)
                            {
                                for(int j=0; j<y; j++)
                                {
                                    VueCellule cv = new VueCellule(m.getCellule(j, i),m);
                                    gridPane.add(cv, i, j);
                                }
                            }
                            borderPane.setCenter(gridPane);
                            check=true;
                        }
                    }
                    catch(Exception e){
                        
                    }
                }
            }
        });

        gridPane.getChildren().clear();
        m = new Modele(10,8,8);
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                VueCellule cv = new VueCellule(m.getCellule(i, j),m);
                gridPane.add(cv, i, j);
            }
        }
        borderPane.setCenter(gridPane);
        borderPane.setCenter(gridPane);

        stage.setScene(scene);
        stage.show();

    }
    
     public static void main(String[] args) {
        launch(args);
    }
}
