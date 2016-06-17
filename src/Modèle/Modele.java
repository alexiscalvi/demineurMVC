/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Random;


/**
 *
 * @author calvi
 */
public final class Modele{
    
    private ArrayList<Cellule> listCellule;
    private ArrayList<Integer> listBomb;
    
    private int y_length;
    private int x_length;
    private int NB_BOMB;
    private int cpt_bomb;
    private int NB_CASES;
    private boolean win;
    
    public Modele(int nb_bomb, int x, int y) {
        this.x_length=x;
        this.y_length=y;
        this.NB_BOMB=nb_bomb;
        listCellule= new ArrayList<>();
        listBomb=new ArrayList<>();
        this.NB_CASES=x*y;
        //creation du terrain
        for(int i=0; i<x_length;i++){
            for(int j=0;j<y_length;j++){
                listCellule.add(new Cellule(this));
            }
        }
        initialization();
    }
    
    public void initialization(){
        initializeNeighbors(); 
        initializeBombs();
    }
    
    
    public void initializeNeighbors(){
        for(int j=0; j<y_length; j++){
            for(int i=0;i<x_length;i++){
                int indice=x_length*j+i;
                Cellule cellule=listCellule.get(indice);
                for(int k=-1;k<2;k++){
                    for(int l=-1;l<2;l++){
                        if(k!=0 || l!=0){
                            int indice_2=indice+(x_length)*(l)+(k);
                            if(inField(i+k,j+l)){
                                cellule.addNeighbors(listCellule.get(indice_2));
                            }
                        }
                    }
                }
            }
        }
    }
    
    
    public void initializeBombs(){
        while(cpt_bomb<NB_BOMB){
            int alea = (int)(Math.random() *(NB_CASES));
            if (!listBomb.contains(alea)){
                listBomb.add(alea);
                cpt_bomb++;
                listCellule.get(alea).setBomb();
            }
        }
        
    }
    public boolean inField(int x, int y){
        return(x>=0 && x< x_length && y>=0 && y<y_length);
    }
    
    public Cellule getCellule(int i, int j){
        return listCellule.get(i*x_length+j);
    }
    
    public boolean end(){
        int nbNotVisible=this.NB_CASES;
        for(int j=0; j<y_length; j++){
            for(int i=0;i<x_length;i++){
                int indice=x_length*j+i;
                if(listCellule.get(indice).isVisible()) nbNotVisible--;
            }
        }
        if(nbNotVisible==this.NB_BOMB) return true;
        return false;
    }

}
