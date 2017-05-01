/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_tennis;
import java.io.*;


/**
 *
 * @author Yuan LIAO
 */
/*--------------------------------------------------------------------------------------------
       ******************** Serve Order ********************
        Value     Serve Order
          0             
          1            A
          2            B
          3            A
          4            B

--------------------------------------------------------------------------------------------*/
public class Jeu extends Exchange implements JeuAction {
/*--------------------Attribute--------------------*/
    
//    public int serveOrder;  //the player who serve first is random
    public int totalJeu;
    public int totalScore;
    private boolean oneScoreStatus;
    public boolean jeuStatus;
    public boolean deuceStatus;
    public boolean gamePoint;
    public boolean breakPoint;
    
   
/*--------------------Constructor--------------------*/    

    public Jeu(){ //playerNumber >= 2
        super();
//        this.serveOrder = 0;
        this.totalScore = 0;
        this.totalJeu = 0;
        this.oneScoreStatus = false;
        this.jeuStatus = false;
        this.deuceStatus = false;
        this.gamePoint = false;
        this.breakPoint = false;
        
        
 //       players = new LinkedList<Player> ();
//        setFirstServe(playerA, playerB);

        
        
//        addPlayer( playerNumber );
    }

    
//    public void addPlayer(int number){  //add some players
//        this.players = new Player[ number ];
//    }
//    public void ServeOrder(){   
//        if( serveOrder / 2 != 0){
//             players.setServe( true );
//        }
//        else if( serveOrder / 2 == 0){
//            players.setServe( true );
//        }
//    }
 
/*--------------------Method--------------------*/
    
//    @Override
//    public void addPlayer(Player players){  //using this method in main method to add the players
//        this.players.add( players );
//    }
    
////-------------------------!!!!!!!!!????????这个应该放在 match 里面设置!!!!!!!!!!!!!??? ------------------------------------------
//    @Override
//    public void setFirstServe(Player playerA, Player playerB){  
//        Random random = new Random();
//        serveOrder= random.nextInt(2) + 1;  //value range from 1 to 2.
//        playerA.serve = serveOrder;
//        playerB.serve = serveOrder + 1;  //可能这里有个bug。。。。。。。。。。!!!!!!!!!!!! 还是没有??
//    }

 /*--------------------------------------------------------------------------------------------
Method Name: setJeuStatue

                      The Rule of Winning a Jeu:
        if a player has already won more than 4 scores(contains the 4),
    and over his/her rival at least 2 score, then the player win a jeu.
--------------------------------------------------------------------------------------------*/
    @Override
    public void setJeuStatue(Player playerA, Player playerB){
        this.oneScoreStatus = false;
        
        System.out.println("------------------------------------------------The method of setJeuStatus");
        if( playerA.score == 3 && playerB.score == 3 ) {
            this.deuceStatus = true;
            Arbitres.annonceDeuce();
        }
        
//the situation of deuce
        if( this.deuceStatus == true) {
            System.out.println("------------------------------------------------under the deuceStatus");
            //if player A is the server
            if( playerA.getServeFlag() == true ) { 
                if( playerA.score == 4){
                    Arbitres.annonceAvantage(playerA);
                    playerA.avantageStatus = true;
                    playerB.avantageStatus = false;
                    System.out.println("   Game Point!   ");
                    this.gamePoint = true; //game point
                    this.breakPoint = false;
                    this.deuceStatus = false;//no more under the deuce status
                }
                else if( playerB.score == 4) {
                    Arbitres.annonceAvantage(playerB);
                    playerB.avantageStatus = true;
                    playerA.avantageStatus = false;
                    this.gamePoint = false;
                    System.out.println("   Break Point!   ");
                    this.breakPoint = true; //break point  
                    this.deuceStatus = false;//no more under the deuce status
                }
            }
            //if player B is the server
            else if( playerB.getServeFlag() == true) { 
                if( playerB.score == 4) {
                    playerB.avantageStatus = true;
                    playerA.avantageStatus = false;
                    System.out.println("   Game Point!   ");
                    this.gamePoint = true; //game point
                    this.breakPoint = false;
                    this.deuceStatus = false;//no more under the deuce status
                }
                else if( playerA.score == 4) {
                   playerA.avantageStatus = true;
                    playerB.avantageStatus = false;
                    this.gamePoint = false;
                    System.out.println("   Break Point!   ");
                    this.breakPoint = true; //break point
                    this.deuceStatus = false;//no more under the deuce status
                }                    
                
            }    
        } 
        
//the situation of avantage
        if( playerA.avantageStatus == true || playerB.avantageStatus == true) 
        {
            System.out.println("------------------------------------------------Both Avacntage");
            if( playerB.score == playerA.score ) { 
                playerA.score = 3;
                playerB.score = 3;
                playerA.avantageStatus = false;
                playerB.avantageStatus = false;
                this.gamePoint = false;
                this.breakPoint = false;
                
                Arbitres.annonceDeuce();
                this.deuceStatus = true;
            }
        }
/*-------------------------------------------------这里可以加异常处理-------------------------------------------*/
        if( playerA.score == 4 && ( ( playerA.score - playerB.score) >= 2) 
                || ( playerA.score == 5 && playerB.score < 4) ){
            System.out.println("------------------------------------------------someone win a jeu");
            this.jeuStatus = true;
            playerA.setJeuFlag( this.jeuStatus );
            playerA.jeuScore ++; 
            System.out.print(" A Jeu Score: " + playerB.jeuScore);
            System.out.println(" B Jeu Score: " + playerB.jeuScore);
            playerA.avantageStatus = false;
            playerB.avantageStatus = false;
            playerA.score = 0;
            playerB.score = 0;
            
            Arbitres.jeuAnnonce(playerA, playerB);
            this.doNextJeu(playerA, playerB);
        }
        else if( playerB.score == 4 && ( ( playerB.score - playerA.score) >= 2) 
                || ( playerB.score ==5 && playerA.score < 4)){
            System.out.println("------------------------------------------------someone win a jeu");
            this.jeuStatus = true;
            playerB.setJeuFlag( this.jeuStatus );
            playerB.jeuScore ++; 
            System.out.print(" B Jeu Score: " + playerB.jeuScore);
            System.out.println(" A Jeu Score: " + playerB.jeuScore);
            playerA.avantageStatus = false;
            playerB.avantageStatus = false;
            playerA.score = 0;
            playerB.score = 0;
            
            Arbitres.jeuAnnonce(playerA, playerB);
            this.doNextJeu(playerA, playerB);
            
        }
    }

    
 /*--------------------------------------------------------------------------------------------
Method Name: playerJeuPlay
    
     Value          oneScoreStatus                            jeuStatus
      false     No player win or lose a score yet     No player win or lose a jeu yet
      true      One side of player now win a score    One side of player now win a jeu
--------------------------------------------------------------------------------------------*/
    @Override
    public void playerJeuPlay(Player playerA, Player playerB){
        playerA.setJeuFlag(false);//every time playing a jeu, reset each player's jeu status 
        playerB.setJeuFlag(false);
        this.jeuStatus = false;//reset jeu's status
        this.oneScoreStatus = false;
        
        while( this.jeuStatus == false){ 
            
            this.oneScoreStatus = false;
//            System.out.print( "  the first while    ");
            
            
            while( super.judgeServe(playerA, playerB)  == true ){  //the serve action. If the server player keeps making fault,
                                                          //the reciver also possiblely win a jeu
   
  
//                System.out.println( "  the second while    ");
                
                try{
                    Thread.sleep(100); //delay 100 ms
                }
                catch(Exception e){
                   
                }
//                this.oneScoreStatus = false;
                while( getOneScoreStatus() == false ) {       
                    
//                    System.out.println( "  the third while ");
                    playerA.setScoreProbility();
                  /*---here, we temporary do not care who is the server or the reciver. Focusing on the result of a score ---*/
                    if( playerA.getScoreProbility() >= 1 && playerA.getScoreProbility() < 40 ) {  // 0 - 40. player B get a score
                        if( Arbitres.judgeAppeal( playerA ) == false){ //the original result is valid
                            System.out.print( playerB.getFirstName() + " " + playerB.getLastName() + "  win a score   ");
                            playerB.score++;
                            
                            System.out.print( playerA.getFirstName() + " " + playerA.getLastName() + "  " + playerA.score + "  ");
                            System.out.println( playerB.getFirstName() + " " + playerB.getLastName() + "  " + playerB.score);
                            
                            playerA.setScoreProbility();         //reset the probility
                            this.oneScoreStatus = true;
                            break;                            
                        }
                        else if( ( Arbitres.judgeAppeal( playerA ) == true)){
                            System.out.println("                                  Appeal succeed!!!");
                            break; //Appeal successufully. The original result is unvalid
                        }
                    }
                    else if( playerA.getScoreProbility() >= 40 && playerA.getScoreProbility() < 60 ) { //40 - 60  
                        this.oneScoreStatus = false;
                        System.out.println("  Players are still fighting!!!");
                        playerA.setScoreProbility();          //reset the probility
                    }
                    else if( playerA.getScoreProbility() >= 60 && playerA.getScoreProbility() < 100 ) {  //60 - 100.  player A get a score
                        if( Arbitres.judgeAppeal( playerB ) == false){ //the original result is valid
                            System.out.print( playerA.getFirstName() + " " + playerA.getLastName() + "  win a score    ");
                            playerA.score++;
                            
                            System.out.print( playerA.getFirstName() + " " + playerA.getLastName() + "  " + playerA.score + " ");
                            System.out.println( playerB.getFirstName() + " " + playerB.getLastName() + "  " + playerB.score);
                            
                            playerA.setScoreProbility();         //reset the probility
                            this.oneScoreStatus = true;
                            break;
                        }
                        else if( ( Arbitres.judgeAppeal( playerB ) == true)){
                            System.out.println("                                  Appeal succeed!!!");
                            break; //Appeal successufully. The original result is unvalid
                        }
                    }
                } 
                if( this.oneScoreStatus == true ){ //this judge code is very important....
                    break;
                }
            }
            
        this.setJeuStatue(playerA, playerB);   //check if someone win a jeu
        }
    }
    
    @Override
    public void doNextJeu(Player playerA, Player playerB){
        super.setServer(playerA, playerB);
        System.out.println(" Do Next Jeu!!!!!!!!! ");
        this.totalJeu++;
        this.deuceStatus = false;
        this.gamePoint = false;
        this.breakPoint = false;
    }

    public void setTotalWinJeu(int totalWinJeu){
        this.totalJeu = totalWinJeu;
    }
    public void setTotalScore(int totalScore){
        this.totalScore = totalScore;
    }
    public boolean getOneScoreStatus(){
        return this.oneScoreStatus;
    }
    
//    public int getServeOrder(){
//        return this.serveOrder;
//    }
//    public int getTotalWinJeu(){
//        return this.totalJeu;
//    }
//    public int getTotalScore(){
//        return this.totalScore;
//    }
//    public boolean getJeuStatus(){
//            return this.jeuStatus;
//    }
}
