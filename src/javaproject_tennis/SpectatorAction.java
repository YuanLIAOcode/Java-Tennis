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
public interface SpectatorAction {
    public abstract boolean buyTicket(int matchLevel, int payFare); //the real price is depending on the promotion of the tennis match
    public abstract int searchSet(boolean payflag); //the set are placed on the perform around the match playgroud and 
                                    //and the number of the set could be odd or even.
    public abstract void Applaud();
    public abstract void Cry();
    public abstract void Sneer();
    public abstract void Sleep();
    
    public abstract String chemiseOrGlasses();

}
