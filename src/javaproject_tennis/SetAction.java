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
public interface SetAction {
    public abstract void setSetStatus(Player playerA, Player playerB);
    public abstract void doNextSet(Player playerA, Player playerB);
}
