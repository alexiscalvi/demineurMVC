/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineurmvc;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Random;


/**
 *
 * @author calvi
 */
public class Modele extends Observable{
    
    private ArrayList<Cellule> listCellule;
    private ArrayList<Integer> listBomb;
    
    private int y_length;
    private int x_length;
    private int NB_BOMB;
    private int cpt_bomb;
    private int NB_CASES;
    Modele(int nb_bomb, int x, int y) {
        this.x_length=x;
        this.y_length=y;
        this.NB_BOMB=nb_bomb;
        listCellule= new ArrayList<>();
        listBomb=new ArrayList<>();
        this.NB_CASES=x*y;
        
        //creation du terrain
        for(int i=0; i<x_length;i++){
            for(int j=0;j<y_length;j++){
                listCellule.add(new Cellule());
            }
        }
        initialization();
        
       
    }
    
    
    public void initialization(){
        initializeNeighbors(); 
        initializeBombs();
        
    }
    
    
    public void initializeNeighbors(){
        for(int i=0;i<x_length;i++){
            for(int j=0; j<y_length; j++){
                int indice=x_length*j+i;
                Cellule cellule=listCellule.get(indice);
                
                for(int k=-1;k<2;k++){
                    for(int l=-1;l<2;l++){
                        int indice_2=indice+k*x_length+1;
                        if(inField(i+k,j+l)) cellule.addNeighbors(listCellule.get(indice_2));
                    }
                }
            }
        }
    }
    
    
    public void initializeBombs(){
        while(cpt_bomb<NB_BOMB){
            Random r = new Random();
            int alea = r.nextInt(NB_CASES);
            if (listBomb.contains(alea)==false){
                listBomb.add(alea);
                cpt_bomb++;
                listCellule.get(alea).setBomb();
            }
        }
        
    }
    public boolean inField(int x, int y){
        return(x>=0 && x<= x_length && y>=0 && y<=y_length);
    }
}
