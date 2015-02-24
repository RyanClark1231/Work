/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author Ryan
 */
public class Timer {
    double startTime, endTime, timeTaken;
    
    public void startTimer(){
        startTime = System.currentTimeMillis();
    }
    
    public double endTimer(){
        endTime = System.currentTimeMillis();
        timeTaken = endTime - startTime;
        return timeTaken;
    }
}
