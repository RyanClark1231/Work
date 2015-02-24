/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;


/**
 *
 * @author Ryan
 */
public class BubbleSort {

    RandomGen randomGen;
    ArrayList<Integer> random = new ArrayList<>();

    public BubbleSort(int numberOfRandom, int between) {
        this.randomGen = new RandomGen(numberOfRandom, between);
        random = randomGen.Generator();
    }

    public BubbleSort() {
        this.randomGen = new RandomGen();
        random = randomGen.Generator();
    }
    
    public BubbleSort(ArrayList<Integer> random){
      this.random = random;
    }

    public ArrayList<Integer> run() {
        int temp, swaps;
        
        for (int j = 0; j < random.size() - 1; j++) {
            swaps = 0;

            for (int i = 0; i < random.size() - 1; i++) {
                if (random.get(i+1) < random.get(i)) {
                    temp = random.get(i);
                    random.set(i, random.get(i+1));
                    random.set(i + 1, temp);
                    swaps++;

                }

            }
            if (swaps == 0) {
                break;
            }
        }
        return random;
        //System.out.println(random);
    }

}
