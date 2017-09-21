/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolregistration;

/**
 *
 * @author Mylon
 */
public class Locker {
    
    private String combo;
    private int lockerNum;

    public Locker(String combo, int lockerNum) {
        this.combo = combo;
        this.lockerNum = lockerNum;
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public void setLockerNum(int lockerNum) {
        this.lockerNum = lockerNum;
    }

    public int getLockerNum() {
        return lockerNum;
    }

    @Override
    public String toString() {
        String word = lockerNum + "\t" + combo;
        return word;
    }
    
    
    
}
