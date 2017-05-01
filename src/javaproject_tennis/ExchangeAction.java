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
public interface ExchangeAction {
    public abstract boolean judgeServe(Player playerA, Player playerB);
    public abstract int createRandom();
    public void setServer(Player playerA, Player playerB);
}
