/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_tennis;

import java.util.Random;

/**
 *
 * @author Yuan LIAO
 */
public class Spectator implements SpectatorAction{    //可能 观众也要继承 Person 这个类!!!!!!!!!!??
/*--------------------Attribute--------------------*/
    private String dressKind;
    private final String[] chemiseColor = {"red","yellow","blue"};
    
 /*--------------------Constructor--------------------*/ 
//
//    public Spectator(int matchLevel, int payFare, String appearance){
//        boolean flagTicket = false;
//        appearance = this.dressKind;
//        
//        flagTicket = buyTicket( matchLevel, payFare );  
//        System.out.println( searchSet(flagTicket) );  
//        
//        chemiseOrGlasses();  //judge the gender according to the appearance
//    }
    
/*--------------------Method--------------------*/
    
    @Override
    public boolean buyTicket(int matchLevel, int payFare){ //payFare means is the money that the audience pays
        boolean buyFlag = false;//Only after having buy the ticket, can audience do the actions like applaud, cry, sneer, sleep...
        
        switch(matchLevel){
            case 1:
                if(payFare >= 100)  return true;//suppose that the fare of the level is 100,
                break;
            case 2:
                if(payFare >= 200) return true;
                break;
            case 3:
                if(payFare >= 500) return true;
                break;
        }
        return false; 
    }
    
    public int searchSet(boolean payflag){
        Random random = new Random();
        int setNumber = random.nextInt(10000);  // the first two digitals are sybom for the x axis of the set, the last two digitals are symbol for the y axis of the set
        if(payflag){ //only after having paid that can operate the action of searching for the set
            return setNumber;
        }
        return 10101010;//may add the judge if the set are full.
    }
    
    @Override
    public void Applaud(){
        System.out.println("Very GOOD!!!");
    }
    @Override
    public void Cry(){
        System.out.println("Come on! Come on!");
    }
    @Override
    public void Sneer(){
        System.out.println("Sucks!!!!");
    }
    @Override
    public void Sleep(){
        System.out.println("ZzzZzzzZ");
    }
    @Override
    public String chemiseOrGlasses(){     //《----------缺少判断妹纸是否戴眼镜!!!!!!!!!------------》
        if( this.chemiseColor[0].indexOf(this.dressKind) != -1   
                || this.chemiseColor[1].indexOf(this.dressKind) != -1
                  || this.chemiseColor[2].indexOf(this.dressKind) != -1 ){ //If no matching color, then could judge the one is a man
            return "man";   
        }
        else return "woman";
    }
}
