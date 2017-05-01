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
public class Arbitres implements AribitreAction{
/*--------------------attribute--------------------*/
    private int arbitreKind; //there are three kinds of arbitre during the tennis match  kind 1,2 3
    private int arbitreNumber;  //the number of arbitre of kind x
    private static int arbitreMood;
    Random randomNumber;
    
/*--------------------Constructor--------------------*/    
    
    public Arbitres(){
        Arbitres.arbitreMood = 0;
        
        randomNumber = new Random();
    }


    public static void exchangeAnnonce(Player playerA, Player playerB){
        System.out.print("               Arbitre: ~~~   ");
        System.out.println(playerA.getFirstName() + " " + playerA.getLastName()  
                              +  " : "+ playerA.score);
        System.out.println(playerA.getFirstName() + " " + playerB.getLastName()  
                              +  " : "+ playerB.score);
        if( playerA.getServeFlag() == true ){
            System.out.println("Serve: " + playerA.getFirstName() + " " + playerA.getLastName() );           
        }
        else if( playerB.getServeFlag() == true){
            System.out.println("Serve: " + playerB.getFirstName() + " " + playerB.getLastName() );  
        }

    }
    public static void jeuAnnonce(Player playerA, Player playerB){
        if( playerA.getJeuFlag() == true) {
            System.out.print("                                                     Arbitre: ~~~   ");
            System.out.println("Jeu Winner: " + playerA.getFirstName() + " " + playerA.getLastName() ); 
            
            System.out.println("Set Result: " + playerA.getFirstName() + " " + playerA.getLastName() 
                                 + " "   + playerA.setScore);
            System.out.println("Set Result: " + playerB.getFirstName() + " " + playerB.getLastName() 
                                  + " "  + playerB.setScore);
        }
        else if( playerB.getJeuFlag() == true) {
            System.out.print("                                                     Arbitre: ~~~   ");
            System.out.println("Jeu winner: " + playerB.getFirstName() + " " + playerB.getLastName() );
            
            System.out.println("Set Result: " + playerA.getFirstName() + " " + playerA.getLastName() 
                                   + " " + playerA.setScore);
            System.out.println("Set Result: " + playerB.getFirstName() + " " + playerB.getLastName() 
                                   + " " + playerB.setScore);
        }
    }
    public static void setAnnonce(Player playerA, Player playerB){
        if( playerA.getSetFlag() == true) {
            System.out.print("                                                     Arbitre: ~~~   ");
            System.out.println("Set Winner: " + playerA.getFirstName() + " " + playerA.getLastName() ); 
            
            System.out.println("Set Result: " + playerA.getFirstName() + " " + playerA.getLastName() 
                                   + " " + playerA.setScore);
            System.out.println("Set Result: " + playerB.getFirstName() + " " + playerB.getLastName() 
                                    + " "+ playerB.setScore);
        }
        else if( playerB.getSetFlag() == true) {
            System.out.print("                                                     Arbitre: ~~~   ");
            System.out.println("Set winner: " + playerB.getFirstName() + " " + playerB.getLastName() );
            
            System.out.println("Set Result: " + playerA.getFirstName() + " " + playerA.getLastName() 
                                   + " " + playerA.setScore);
            System.out.println("Set Result: " + playerB.getFirstName() + " " + playerB.getLastName() 
                                   + " " + playerB.setScore);
        }
    }
    public static boolean judgeAppeal(Player player){
        System.out.println("                                   having a judge");
        if( player.getApplealProbility() == true ){ //player A requires an appeal
            if(  getAribreMood() && player.getReputationValue() != 3){
                return false;
            }
            else if( getAribreMood() || player.getReputationValue() == 3 ){
                return true;
            }
        }
        return false;
    }
    
    public static void annonceFault(Player player){
        System.out.print("               Arbitre: ~~~   ");
        System.out.println("Player" + player.getFirstName() + " " + player.getLastName() + " Fault!");
    }
    public static void annonceLet(Player player){
        System.out.print("               Arbitre: ~~~   ");
        System.out.println("Player" + player.getFirstName() + " " + player.getLastName() + " Let!");
    }
    public static void annonceDeuce(){
        System.out.print("               Arbitre: ~~~   ");
        System.out.println("      Deuce     ");
    }
    public static void annonceAvantage(Player player){
        System.out.print("               Arbitre: ~~~   ");
        System.out.println(" Player" + player.getFirstName() + " " + player.getLastName() + " Avantage!!!");
    }
//    @Override
//    public void Intervene(Player judge){
//        //
//    }
    
 
    public void setArbitreMood(){
        this.arbitreMood = randomNumber.nextInt(100) + 1;
    }
    public void setArbitrelKind(int arbitreKind){
        this.arbitreKind = arbitreKind;
    }
    public void setArbitrelNumber(int arbitreNumber){
        this.arbitreNumber = arbitreNumber;
    }
    
    public int getArbitreKind(){
        return this.arbitreKind;
    }
    public int getArbitreNumber(){
        return this.arbitreNumber;
    }
    public static boolean getAribreMood(){
        if( arbitreMood <= 80) {//arbitre's mood is really bad!
            return false;
        }
        else {
            return true;
        }
    }
}
