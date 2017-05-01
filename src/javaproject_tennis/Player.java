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
/*
       Value    Attack Ability       Defence Ability    Serve Accuracy Rate        serveFlag                  matchResult
         0          none                    none              none                  
         1          weak                    weak              low              false( be the reciver )     playing the game
         2          normal                  normal            medium           true ( be the server )            win
         3          strong                  strong            high             false( be the reciver )           lose
         4                                                                     true ( be the server )
         5                                                                     false( be the reciver )
*/
public class Player extends Person implements PlayerAction{   //create a abstract class for the person
/*--------------------attribute--------------------*/
    private boolean mainHand;    //lefthand  true; righthand false
    private String sponsor;
    private String coah;
    private int level; //Lors de l'initialisation le classement du Joueur est fixé par l'ordre de création, 
                                //ensuite il sera modifié en fonction des victoires/défaites de chacun.
    
    public int serve;
    private boolean serveFlag;  //true be the server, false  be the reciver
    public int score;
    public int jeuScore;
    public boolean avantageStatus;
    private boolean jeuFlag;
    public int setScore;
    private boolean setFlag;
    
    public int matchResult;
    private int totalMatchPoint;
       
    Random randomNumber;
    
    private int getScoreProbility;
//    private int appealProbility;
//    
//    private int reputationValue;
    private int attackAbility = 0; //the ability of a player to attack
    private int defenceAbility = 0; //the ability of a player to defence
    private int serveAccuracyRate = 0;

 /*--------------------Constructor--------------------*/ 
    
/*-----Player's personal information------*/
    public Player(String lastName, String firstName, String gender, String usedName, 
                 boolean maritaStatus, int birthDate, int age, String birthPlace,
                   int deathDate, String nationality, int taille, float poids)
    {
        super( lastName, firstName, gender, usedName, maritaStatus, birthDate,
                 age, birthPlace, deathDate, nationality, taille, poids);
        this.serve = 0;
        this.serveFlag = false;
        this.score = 0;
        this.jeuFlag = false;
        this.setScore = 0;
        this.setFlag = false;
        randomNumber = new Random();
    }
/*------Player's supplement information------*/
    public Player(boolean mainHand, String sponsor, String coah, int level){
        this.mainHand = mainHand;              //to overload the constructor for setting the supplement information of a player
        this.sponsor = sponsor;
        this.coah = coah;
        this.level = level;
    }
/*-----Information about Player's ability----*/
    public Player(int attackAbility, int defenceAbility, int serveAccuracyRate){
        this.attackAbility = attackAbility;      //to overload the constructor for setting the ability value of a player
        this.defenceAbility = defenceAbility;
        this.serveAccuracyRate = serveAccuracyRate;
    }
   
   
//    @Override
//    public void setServer(int serveOrder){
//        this.serve = serveOrder;
//        if( serve % 2 == 0){
//            serveFlag = true;  //
//            System.out.println("I am the server. Be careful ehen!");
//        }
//        if( serve % 2 == 1){
//            serveFlag = false;
//            System.out.println("I am the reciver. Come on baby~");
//        }
//    }


//    public int makeFault(){
//        
//    }
    
/*--------------------Method--------------------*/
    
//    public int makeAppeal(){
//        randomNumber
//    }
    
    
    
    
    
    
/*-----------------------------------------------------------------------*/  
    public void setMainHand(boolean mainHand){
        this.mainHand = mainHand;
    }
    public void setSponsor(String sponsor){
        this.sponsor = sponsor;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void setCoah(String coah){
        this.coah = coah;
    } 
 /*-----------------set some player's value of a match ------------------*/ 
    public void setServeFlag(boolean serveFlag){
        this.serveFlag = serveFlag;
    }
    public void setJeuFlag(boolean jeuFlag){
        this.jeuFlag = jeuFlag;
    }
    public void setSetFlag(boolean setFlag){
        this.setFlag = setFlag;
    }
    public void setJeuScore(int jeuScore){
        this.jeuScore = jeuScore;
    }
    public void setSetScore(int setScore){
        this.setScore = setScore;
    }
    public void setMatchResult(int matchResult){
        this.matchResult = matchResult;
    }
    public void setTotalMatchPoint(int totalMatchPoint){
        this.totalMatchPoint = totalMatchPoint;
    }
 /*-----------------set the ability value of a player------------------*/
    public void setAttackAbility(int attackAbility){
        this.attackAbility = attackAbility;
    }
    public void setDefenceAbility(int defenceAbility){
        this.defenceAbility = defenceAbility;
    }
    public void setServeAccuracyRate(int serveAccuracyRate){
        this.serveAccuracyRate = serveAccuracyRate;
    }
    public void setScoreProbility(){
        this.getScoreProbility = randomNumber.nextInt(100) + 1; // create a number ranger from 1 - 100
    }
//    public void setAppealProbility(){
//        this.appealProbility = randomNumber.nextInt(5) + 1;  //1 ~ 5
//    }
//    public void setReputaionValue(){
//        this.reputationValue = randomNumber.nextInt(3) + 1; // 1 ~ 3
//    }

    
    
    public boolean getMainHand(){
        return this.mainHand;
    }
    public String getSponsor(){
        return this.sponsor;
    }
    public int getLevel(){
        return this.level;
    }
    public String getCoah(){
        return this.coah;
    }
 /*-----------------set some player's value of a match ------------------*/ 
    public boolean getServeFlag(){
        if( this.serve % 2 == 0){
            serveFlag = true;  //
        }
        else if( this.serve % 2 == 1){
            serveFlag = false;
        }
        return this.serveFlag;
    }
    public boolean getJeuFlag(){
        return this.jeuFlag;
    }
    public boolean getSetFlag(){
        return this.setFlag;
    }
    public int getJeuScore(){
        return this.jeuScore;
    }
    public int getSetScore(){
        return this.setScore;
    }
    public int getMatchResult(){
        return this.matchResult;
    }
    public int getTotalMatchPoint(){
        return this.totalMatchPoint;
    }
 /*-----------------get the ability value of a player------------------*/
    public int getAttackAbility(){
        return this.attackAbility;
    }
    public int getDefenceAbility(){
        return this.defenceAbility;
    }
    public int getserveAccuracyRate(){
        return this.serveAccuracyRate;
    }
    public boolean getApplealProbility(){
        if( this.randomNumber.nextInt(6) <= 4) {
            return false;  //do not appeal
        }
        else{
            return true; //do appeal
        }
    }
    public int getScoreProbility(){  //最简单的思路。给每个球员一个随机数。在某个随机数范围内时表示这球获胜,该球员加15分。(不考虑发球犯规,出界,未接到球,球的运动等其它条件下)
        return this.getScoreProbility;
    }
    public int getReputationValue(){
        return this.randomNumber.nextInt(4);
    }
}
