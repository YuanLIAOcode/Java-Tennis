/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject_tennis;

/**
 *
 * @author liaoyuan
 */
public interface MatchAction {
    public abstract void addPlayer(Player player);
    public abstract void addArbites(Arbitres arbite);
    public abstract void setFirstServe(Player playerA, Player playerB);
    public abstract void playMatch(Player playerA, Player playerB);
//    public abstract void matchLevel(int matchLevel);
    public abstract void showMatchType();
    public abstract void showMatchModel();
    public abstract void showMatchLevel();
    
}
