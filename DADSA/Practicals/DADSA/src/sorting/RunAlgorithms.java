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
public class RunAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timer timer = new Timer(); //Create new timer
        /*RandomGen randomGen = new RandomGen(10000, 1000);
        ArrayList<Integer> random = randomGen.Generator();*/
        BubbleSort bubble = new BubbleSort(/*random*/); 
        SelectionSort selection = new SelectionSort(/*random*/);
        BinarySearch binary = new BinarySearch(/*random*/);
       
        timer.startTimer();
        //bubble.run(); 
        selection.run();
        System.out.printf("%.0f \bms Selection\n", timer.endTimer());
        
        timer.startTimer();
        bubble.run();
        System.out.printf("%.0f \bms Bubble\n", timer.endTimer());
        
        timer.startTimer();
        System.out.println(binary.run(95800));
        System.out.printf("%.0f \bms Binary Search\n", timer.endTimer());
    }
    
}
