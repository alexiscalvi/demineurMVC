/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author calvi
 */
public class Cellule extends Observable{
    
    
    private int nb_bomb=0; //bombes voisines
    private boolean bomb;
    private StateCase state;
    ArrayList<Cellule> neighbors;
    private boolean discover;
    private Modele m;
    

    public Cellule(Modele m) {
        this.m=m;
        this.neighbors=new ArrayList<>();
        bomb=false;
        state=StateCase.UNVISIBLE;
        discover=false;
    }
    
    public void showCellule(){
        state=state.VISIBLE;
    }
    
    public int getBomb(){
        return this.nb_bomb;
    }
    //actions
    public void setBomb(){
        this.bomb=true;
    }
    
    public void addBomb(){
        this.nb_bomb++;
    }
    public void addNeighbors(Cellule newNeighbor){
        neighbors.add(newNeighbor);
    }
    
    
    public boolean discover(){
        if(!this.isFlag() && !discover){
            this.setVisible();
            if(!this.bomb){
                for(Cellule c1: neighbors){
                    if (c1.isBomb()) this.addBomb();
                }
                discover=true;
                if(nb_bomb==0){
                    for(Cellule c1: neighbors){
                        c1.discover();
                    }
                }
            }
            this.modified();
            return false;
        }
        return true;
    }
    
    public void setVisible(){
        this.state=StateCase.VISIBLE;
    }
    
    public void setFlag(){
        this.state=StateCase.FLAG;
    }
    
    public void removeFlag(){
        this.state=StateCase.UNVISIBLE;
    }
    
    public void changeFlag(){
        if(state.equals(StateCase.UNVISIBLE)) setFlag();
        else if(state.equals(StateCase.FLAG)) removeFlag();
        this.modified();
    }
    
    
  
    //tests
    public boolean isBomb(){
        return (bomb==true);
    }
    public boolean isVisible(){
        return (state==StateCase.VISIBLE);
    }
    
    public boolean isFlag(){
        return (state==StateCase.FLAG);
    }

    //Méthode pour communication avec l'observer VueCellule
    public void modified()
    {
        this.setChanged();
        this.notifyObservers();
    }
    
    @Override
    public void notifyObservers()
    {
        super.notifyObservers();
    }

}

