/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_tennis;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Yuan LIAO
 */
/**            ******************** Mode/Level/Point/Status ********************
     Value    matchModel      matchType        matchLevel      winnerPoint    loserPoint   matchStatus
      0                                                                   
      1     Australian Open    single man         round 1                                begin / ongoing
      2     French Open        single woman       round 2                                end
      3     Wimbledon          double man         round 3                                time-out
      4     US Open            double woman       round 4
      5     Regular Season     mixed
              or the other     
      6     Friendship Match   half-final               
      7                        final
 */
public class Match extends Set implements MatchAction{
/*--------------------Attribute--------------------*/
    
    private int matchModel;
    private int matchType;         
    public int matchLevel; 
    public int matchStatus; 
    public int matchWinner;
    private int matchWinnerPoint;  
    private int matchLoserPoint;
 //   private int firstServe = -1;    //the player who serve first is random
    public int serveOrder;
    
    List<Player> players;
    List<Arbitres> arbitres;
    
    
/*--------------------Constructor--------------------*/       

    public Match(int matchModel, int matchType, int matchLevel){
        super();
        
        this.matchModel = matchModel;
        this.matchType = matchType;
        this.matchLevel = matchLevel;
        
        this.matchStatus = 0;
        this.serveOrder = 0;
      
        players = new LinkedList<>();
        arbitres = new LinkedList<>();
    }
   
    
 /*--------------------Method--------------------*/ 

/*---------------------------------------或许这里可以用异常处理?---------------------------????!!!*/   

    @Override
    public void addPlayer(Player player){
        this.players.add(player);
    }

    @Override
    public void addArbites(Arbitres arbitre){
        this.arbitres.add(arbitre);
    }
    
    @Override
    public void setFirstServe(Player playerA, Player playerB){  
        Random random = new Random();
        serveOrder= random.nextInt(2) + 1;  //value range from 1 to 2.
        playerA.serve = serveOrder;
        playerB.serve = serveOrder + 1;  //可能这里有个bug。。。。。。。。。。!!!!!!!!!!!! 还是没有??
        if( playerA.serve % 2 == 0){
            System.out.print("             A is the first Server    ");
        }
        else if( playerA.serve % 2 == 1){
            System.out.print("             A is the first Reciever    ");
        }
        if( playerB.serve % 2 == 0){
            System.out.println("             B is the first Server    ");
        }
        else if ( playerB.serve % 2 == 1){
            System.out.println("             B is the first Reciever    ");
        }
    }

/*-----------------------Play the Match-----------------------*/    
    @Override
    public void playMatch(Player playerA, Player playerB){
        if( this.matchStatus == 1){
            System.out.println("The Match is beginning!!!");
            showMatchType();
            showMatchModel();
            showMatchLevel();
            setFirstServe(playerA, playerB);
            
            while( this.matchStatus != 2 ) { 
                
                super.setSetStatus(playerA, playerB); //check the set rounds
                
                if( this.matchModel >=5 ){ //Regular Season or the other
                    if( playerA.setScore >= 2 ){
                        
                        playerA.matchResult = 2;
                        playerB.matchResult = 3;
                        this.matchStatus = 2; //This match is over
                        System.out.println("  The match is over!!!!!!!!!");
                        System.out.println(playerA.getFirstName() + " " +playerA.getLastName() 
                                            + " is the winner");
                    }
                    else if( playerB.setScore >= 2 ){
                        
                        playerB.matchResult = 2;
                        playerA.matchResult = 3;
                        this.matchStatus = 2;
                        System.out.println("  The match is over!!!!!!!!!");
                        System.out.println(playerB.getFirstName() + " " + playerB.getLastName() 
                                            + " is the winner");
                    }
                }
                else{ //Grand Slam
                    if( playerA.setScore >= 3 ){
                        
                        playerA.matchResult = 2;
                        playerB.matchResult = 3;
                        this.matchStatus = 2; //This match is over
                        System.out.println("  The match is over!!!!!!!!!");
                        System.out.println(playerA.getFirstName() + " " +playerA.getLastName() 
                                            + " is the winner");
                    }
                    else if( playerB.setScore >= 3 ){
                        
                        playerB.matchResult = 2;
                        playerA.matchResult = 3;
                        this.matchStatus = 2; //This match is over
                        System.out.println("  The match is over!!!!!!!!!");
                        System.out.println(playerB.getFirstName() + " " + playerB.getLastName() 
                                            + " is the winner");
                    }
                }
                
            }
        }
    }

/*------------------Show information about the Match------------------*/
    @Override
    public void showMatchType(){
        switch(this.matchType){
            case 1:{
                System.out.print("Men's Single Match ");
                break;
            }
            case 2:{
                System.out.print("Men's Double Match ");
                break;
            }
            case 3:{
                System.out.print("Women's Single Match ");
                break;
            }
            case 4:{
                System.out.print("Women's Double Match ");
                break;
            }
            case 5:{
                System.out.print("Mixed Doubles Match ");
                break;
            } 
        }         
    }
    @Override
    public void showMatchModel(){
        switch( this.matchModel ){
            case 1:{
                System.out.println("Australian Open");
                break;
            }
            case 2:{
                System.out.println("French Open");
                break;
            }
            case 3:{
                System.out.println("Wimbledon");
                break;
            }
            case 4:{
                System.out.println("US Open");
                break;
            }
            case 5:{
                System.out.println("Regular Season or the other");
                break;
            }
            case 6:{
                System.out.println("Friendship Match");
                break;
            }
        }
    }
    @Override
    public void showMatchLevel(){
        if( this.matchLevel >=1 && this.matchLevel <= 8){
            System.out.println("The number: " + this.matchLevel + "Round Match");
        }
        else if( this.matchLevel == 9){
            System.out.println("The Half-final Match");
        }
        else if( this.matchLevel == 10){
            System.out.println("The Final Match");
        }        
    }
    
    
    public void setPoint(int matchLevel){
        switch( matchLevel ){      //--------每场比赛的具体积分,待定 根据比赛是ATP还是WTA 变化而不同----------
        }
    }
    public void setMatchModel(int matchModel){
        this.matchModel = matchModel;
    }
    public void setMatchType(int matchType){
        this.matchType = matchType;
             
    }
    public void setMatchLevel(int matchLevel){
        this.matchLevel = matchLevel;
    }
    public void setMatchStatus(int matchStatus){
        this.matchStatus = matchStatus;
    }
    public void setMatchWinnerPoint(int matchWinnerPoint){
        this.matchWinnerPoint = matchWinnerPoint;
    }
    public void setMatchLoserPoint(int matchLoserPoint){
        this.matchLoserPoint = matchLoserPoint;
    }

    
    
    public int getMatchType(){   
        return this.matchType;
    }
    public int getMatchLevel(){
        return this.matchLevel;
    }
    public int getMatchStatus(){
        return this.matchStatus;
    }
    public int getMatchWinnerPoint(){
        return this.matchWinnerPoint;
    }
    public int getMatchLoserPoint(){
        return this.matchLoserPoint;
    }
//    public int getFirstServe(){
//        return this.firstServe;
//    }

    
                                    
}
