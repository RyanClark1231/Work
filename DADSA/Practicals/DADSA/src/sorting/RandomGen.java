/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ryan
 */
public class RandomGen {
    Random random;
    ArrayList<Integer> randomNum;
    int numberOfRandom, randomNumber, between;
    
    public RandomGen(int numberOfRandom, int between) {
        randomNum = new ArrayList<>();
        random = new Random();
        this.numberOfRandom = numberOfRandom;
        this.between = between;
    }

    public RandomGen() {
        randomNum = new ArrayList<>();
        random = new Random();
        this.numberOfRandom = 100;
        this.between = 100;
    }
    
    public ArrayList Generator(){
        for (int i = 0; i < numberOfRandom; i++) {
            randomNumber = random.nextInt(between);
            randomNum.add(randomNumber);
        }
        return randomNum;
    }
    
    public void setNumberOfRandom(int numberOfRandom){
        this.numberOfRandom = numberOfRandom;
    }

    public int getBetween() {
        return between;
    }
    
    public void setBetween(int between){
        this.between = between;
    }
    
    
}
