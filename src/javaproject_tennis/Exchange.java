/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_tennis;
import java.util.*;
/**
 *
 * @author Yuan LIAO
 */
/*--------------------------------------------------------------------------------------------
                    Random Valeu                  Status
                       0----20                 serve fault
                       20---40                 serve let
                       40---100                serve correctly
/*--------------------------------------------------------------------------------------------*/
public class Exchange {
/*--------------------attribute--------------------*/
    
    public int faultFlag;
    public boolean correctServeFlag;
    Random randomNumber = new Random();
    private int randomExchange;
    int temp;
    
    public Exchange(){
        faultFlag = 0;
        correctServeFlag = false;
        this.randomExchange = 0;
        temp = 0;
    }

/*--------------------method--------------------*/
    
    public boolean judgeServe(Player playerA, Player playerB){
        
        this.randomExchange = this.createRandom();
        System.out.print("The new randomNumber is: " + this.randomExchange + "  ");
        
  //------------------------If A player is the server------------------------       
        if( playerA.getServeFlag() == true ) { 
            if( this.randomExchange >=1 && this.randomExchange < 20 ){  // A player's serve is fault
                Arbitres.annonceFault(playerA);
                if(faultFlag >= 2){ //if  A player makes twice faults of serving
                    System.out.println(playerA.getFirstName() + " " +  playerA.getLastName() + " Fault twice! ");
                     
                    playerB.score++;
                    System.out.print( playerB.getFirstName() + " " + playerB.getLastName() + "  win a score   ");
                    System.out.print(" Score: " + playerA.getFirstName() + " " + playerA.getLastName() + "  " + playerA.score);
                    System.out.println(" Score: " + playerB.getFirstName() + " " + playerB.getLastName() + "  " + playerB.score);
                    correctServeFlag = false;
             
                    faultFlag = 0;
                    
                    return correctServeFlag;
                }
                faultFlag++;
                correctServeFlag = false;
            }
            while( this.randomExchange >= 20 && this.randomExchange < 30){  //A player's serve is let 
                Arbitres.annonceLet(playerA);
                this.randomExchange = this.createRandom();
            }
            if( this.randomExchange >=30 && this.randomExchange <=100){ //A player serves successfully
                System.out.print(playerA.getFirstName()+ " " + playerA.getLastName() + " Serves successfully!");
                correctServeFlag = true;
        
                return correctServeFlag;
            }

        }
        
 //------------------------If B player is the server------------------------
        else if( playerB.getServeFlag() == true ) {  
            if( this.randomExchange >=1 && this.randomExchange < 20 ){ // B player's serve is fault
                Arbitres.annonceFault(playerB);
                if(faultFlag >= 2){  //if B player makes twice faults of serving
                    System.out.println(playerB.getFirstName() + " " +  playerB.getLastName() + " Fault twice! ");
                    
                    playerA.score++;
                    System.out.print( playerA.getFirstName() + " " + playerA.getLastName() + "  win a score   ");
                    System.out.print(" Score: " + playerA.getFirstName() + " " + playerA.getLastName() + "  " + playerA.score);
                    System.out.println(" Score: " + playerB.getFirstName() + " " + playerB.getLastName() + "  " + playerB.score);
                    
                    correctServeFlag = false;
               
                    faultFlag = 0;
                    
                    return correctServeFlag;
                }
                faultFlag++;
                correctServeFlag = false;
            }
            while( this.randomExchange >= 20 && this.randomExchange < 30){ //B player's serve is let
                Arbitres.annonceLet(playerB);
                this.randomExchange = this.createRandom();
            }
            if( this.randomExchange >=30 && this.randomExchange <=100){ //B player serves successfully
                System.out.println(playerB.getFirstName()+ " " + playerB.getLastName() + " Serves successfully!");
                correctServeFlag = true;
          
                return correctServeFlag;
            }
        }
        
        return correctServeFlag;
    }
    
    
    public int createRandom(){
        this.temp = randomNumber.nextInt(100) + 1; //range from 1 - 100  
        return this.temp;
    }
    
    public void setServer(Player playerA, Player playerB){
        playerA.serve++;
        playerB.serve++;
        
        if( playerA.getServeFlag() == true ){
            System.out.print(playerA.getFirstName() + " " +playerA.getLastName() + ": " +
                    " I am the server. Be careful ehen! ");
        }
        else if( playerA.getServeFlag() == false ){
            System.out.print(playerA.getFirstName() + " " + playerA.getLastName() + ": " +
                    " I am the reciver. Come on baby~ ");
        }
        
        if( playerB.getServeFlag() == true ){
            System.out.println(playerB.getFirstName() + " " + playerB.getLastName() + ": " +
                    "I am the server. Be careful ehen!");
        }
        else if( playerB.getServeFlag() == false ){
            System.out.println(playerB.getFirstName() + " " + playerB.getLastName() + ": " +
                    "I am the reciver. Come on baby~");
        }
    }
}
