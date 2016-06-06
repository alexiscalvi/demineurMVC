/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineurmvc;

import java.util.ArrayList;

/**
 *
 * @author calvi
 */
public class Cellule {
    
    
    private int nb_bomb=0; //bombes voisines
    private boolean bomb;
    private StateCase state;
    ArrayList<Cellule> neighbors;
    

    public Cellule() {
        this.neighbors=new ArrayList<>();
        bomb=false;
        state=StateCase.UNVISIBLE;
    }

    
    //actions
    public void setBomb(){
        this.bomb=true;
    }
    public void addNeighbors(Cellule newNeighbor){
        neighbors.add(newNeighbor);
    }
    public void discover(){
        
        if (this.isBomb()) setVisible();
            
        
        else{
            for(Cellule c: neighbors){
                if (c.isBomb()) nb_bomb++;
            }
        if(nb_bomb==0){
            this.setVisible();
            for(Cellule c: neighbors){
                c.discover();
            }
        }
        }
    }
    
    public void setVisible(){
        this.state=StateCase.VISIBLE;
    }
    public void setFlag(){
        this.state=StateCase.FLAG;
    }
    
   // public void boom(){
     //   setVisible();
    //}
    
    
    
    //tests
    public boolean isBomb(){
        return (bomb==true);
    }
    public boolean isVisible(){
        return (state==StateCase.VISIBLE);
    }
    

    }

