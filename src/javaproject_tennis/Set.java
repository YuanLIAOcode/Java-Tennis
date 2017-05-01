/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_tennis;

/**
 *
 * @author Yuan LIAO
 */
public class Set extends Jeu implements SetAction{
/*--------------------Attribute--------------------*/
    public int totalSetRound;
    private boolean setStatus;
    
 /*--------------------Constructor--------------------*/   

    public Set(){
        super();
        this.totalSetRound = 0;
        this.setStatus = false;
    }
 
/*--------------------Method--------------------*/
    
    @Override
    public void setSetStatus(Player playerA, Player playerB){
        
        super.playerJeuPlay(playerA, playerB);
        
        if( ( (playerA.jeuScore - playerB.jeuScore) >= 2 
                && ( playerA.getJeuScore() >= 6) ) //if player A has already won 6 Jeues and also over B 2 Jeu, then A win this set
                || (playerA.jeuScore == 7) ){ //or player A win 7 sets firstly
            this.setStatus = true;
            playerA.setSetFlag( this.setStatus );
            playerA.setScore++;
            Arbitres.setAnnonce(playerA, playerB);
            this.doNextSet(playerA, playerB);
        }
        else if( ( (playerB.jeuScore - playerB.jeuScore ) >= 2 
                && (playerB.getJeuScore() >= 6) )//if B has already won 6 Jeues and also over A 2 jeues, then B win this set
                || (playerB.jeuScore == 7) ){ //or player B win 7 jeus firstly
            this.setStatus = true;
            playerB.setSetFlag( this.setStatus );
            playerB.setScore++;
            Arbitres.setAnnonce(playerA, playerB);
            this.doNextSet(playerA, playerB);
        }     
    }
    
    @Override
    public void doNextSet(Player playerA, Player playerB){
        System.out.println("   Do Next SSSSet!     ");
        this.totalSetRound++;
        this.setStatus = false;
    }
    
    
    public void setTotalSetRound(int totalSetRound){
        this.totalSetRound = totalSetRound;
    }
    


//    public int getTotalSetRound(){
//        return this.totalSetRound;
//    }
    public boolean getSetStatus(){
        return this.setStatus;
    }

}
