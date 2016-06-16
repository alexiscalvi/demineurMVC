/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modèle.Cellule;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Lucas
 */
public class VueCellule extends Button implements Observer{
    private Cellule c;
    public Image img = new Image(VueCellule.class.getResource("/images/Masquer.png").toExternalForm());
    
    public VueCellule (Cellule c){
        this.c=c;
        ImageView im = new ImageView(this.img);
        im.setFitWidth(30);
        im.setFitHeight(30);
        this.setGraphic(im);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if(this.c.isVisible())
        {
            switch(this.c.getBomb())
            {
                case 0:
                    this.img = new Image(VueCellule.class.getResource("/images/1.png").toExternalForm());
                    break;
                case 1:
                    this.img = new Image(VueCellule.class.getResource("/images/1.png").toExternalForm());
                    break;
                case 2:
                    this.img = new Image(VueCellule.class.getResource("/images/2.png").toExternalForm());
                    break;
                case 3:
                    this.img = new Image(VueCellule.class.getResource("/images/3.png").toExternalForm());
                    break;
                case 4:
                    this.img = new Image(VueCellule.class.getResource("/images/4.png").toExternalForm());
                    break;
                case 5:
                    this.img = new Image(VueCellule.class.getResource("/images/5.png").toExternalForm());
                    break;
                case 6:
                    this.img = new Image(VueCellule.class.getResource("/images/6.png").toExternalForm());
                    break;
                case 7:
                    this.img = new Image(VueCellule.class.getResource("/images/7.png").toExternalForm());
                    break;
                case 8:
                    this.img = new Image(VueCellule.class.getResource("/images/8.png").toExternalForm());
                    break;
                default:
                    this.img = new Image(VueCellule.class.getResource("/images/1.png").toExternalForm());
                    break;
            }
            if(this.c.isBomb())
            {
                this.img = new Image(VueCellule.class.getResource("/images/Bombe.png").toExternalForm());
            }
            this.setDisable(true);
        }
        else
        {
            if(c.isFlag())
            {
                this.img = new Image(VueCellule.class.getResource("/images/flag.png").toExternalForm());
            }
            else
            {
                this.img = new Image(VueCellule.class.getResource("/images/1.png").toExternalForm());
            }
        }
        ImageView im = new ImageView(this.img);
        im.setFitWidth(100);
        im.setFitHeight(100);
        this.setGraphic(im);
    }
    
}
