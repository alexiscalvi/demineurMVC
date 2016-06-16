/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modèle.Cellule;
import Modèle.Modele;
import Vue.VueCellule;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
/**
 *
 * @author Lucas
 */
public class Controleur_Cellule extends Controleur implements EventHandler<MouseEvent>
{
    /**
     * Concerned cell
     */
    private final Cellule c;
    /**
     * The view of this cell
     */
    private VueCellule cv;
    
    private Modele m;
    
    /**
     * Base constructor
     * @param c The cell
     * @param cv The view
     */
    public Controleur_Cellule(Cellule c, VueCellule cv, Modele m)
    {
        super();
        this.c = c;
        this.cv = cv;
        this.m=m;
    }
    
    public boolean end(){
        return(m.end());
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.getButton() == MouseButton.PRIMARY)//Left click
        {
            c.discover();
            if(c.isBomb()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("FIN DE LA PARTIE");
                alert.setHeaderText("Vous avez perdu !");
                alert.showAndWait();
            }
            else if(end()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("FIN DE LA PARTIE");
                alert.setHeaderText("Vous avez gagné !");
                alert.showAndWait();
            }
        }
        else if(event.getButton() == MouseButton.SECONDARY)//Right click
        {
            c.changeFlag();
        }
    }
    
}
