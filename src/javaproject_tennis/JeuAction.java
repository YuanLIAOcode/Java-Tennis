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
public interface JeuAction {
//    public abstract void addPlayer(Player players);
//    public abstract void setFirstServe(Player playerA, Player playerB);
    public abstract void setJeuStatue(Player playerA, Player playerB);
    public abstract void playerJeuPlay(Player playerA, Player playerB);
    public abstract void doNextJeu(Player playerA, Player playerB);
    
}
