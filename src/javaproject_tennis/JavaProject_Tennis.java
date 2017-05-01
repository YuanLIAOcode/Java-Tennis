/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_tennis;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Yuan LIAO
 */
public class JavaProject_Tennis {
    
//    public static void createMatch(List<Match> matchs){
//        Match oneMatch = new Match();
//        Player playerA = new Player("A","A","M","NO",false,1994,
//                                    22,"Paris",10086,"France",10,12);
//        Player playerB = new Player("B","B","M","NO",false,1994,
//                                    22,"Paris",10086,"France",10,12);
//        Arbitres arbitreA = new Arbitres();
//        oneMatch.addPlayer(playerA);
//        oneMatch.addPlayer( playerB);
//        oneMatch.addArbites(arbitreA);
//        oneMatch.setMatchStatus(1);
//        matchs.add( oneMatch );
//        
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        List<Match> matchs = new LinkedList<>();
//        createMatch( matchs );
        Match oneMatch = new Match(5,1,1);
        Player playerA = new Player("A","A","M","NO",false,1994,
                                    22,"Paris",10086,"France",10,12);
        Player playerB = new Player("B","B","M","NO",false,1994,
                                    22,"Paris",10086,"France",10,12);
        Arbitres arbitreA = new Arbitres();
        oneMatch.addPlayer(playerA);
        oneMatch.addPlayer( playerB);
        oneMatch.addArbites(arbitreA);
        
        oneMatch.setMatchStatus(1);
        
        oneMatch.playMatch(playerA, playerB);
        
    }
    
}
