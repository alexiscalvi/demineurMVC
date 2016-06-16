/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modèle.Cellule;
import Vue.VueCellule;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
/**
 *
 * @author Lucas
 */
public class Controleur_case extends Controleur implements EventHandler<MouseEvent>
{
    /**
     * Concerned cell
     */
    private final Cellule c;
    /**
     * The view of this cell
     */
    private VueCellule cv;
    
    /**
     * Base constructor
     * @param c The cell
     * @param cv The view
     */
    public Controleur_case(Cellule c, VueCellule cv)
    {
        super();
        this.c = c;
        this.cv = cv;
    }
    

    @Override
    public void handle(MouseEvent event) {
        if(event.getButton() == MouseButton.PRIMARY)//Left click
        {
            this.c.showCellule();
        }
        else if(event.getButton() == MouseButton.SECONDARY)//Right click
        {
            //c.invertFlag();
        }
    }
    
}
