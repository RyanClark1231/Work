package sorting;

import java.util.ArrayList;

/**
 *
 * @author Ryan
 */
public class SelectionSort {

    RandomGen randomGen;
    ArrayList<Integer> random = new ArrayList<>();

    public SelectionSort(int numberOfRandom, int between) {
        this.randomGen = new RandomGen(numberOfRandom, between);
        random = randomGen.Generator();
    }

    public SelectionSort() {
        this.randomGen = new RandomGen();
        random = randomGen.Generator();
    }
    
    public SelectionSort(ArrayList<Integer> random){
      this.random = random;
    }

    public ArrayList<Integer> run() {
        int min, temp, minIndex = 0;
        Boolean swap;
        for (int j = 0; j < random.size(); j++) {
            min = random.get(j);
            swap = false;
            for (int i = j; i < random.size(); i++) {
                if (random.get(i) < min) {
                    minIndex = i;
                    min = random.get(i);
                    swap = true;
                }

            }
            if (swap == true) {
                temp = random.get(j);
                random.set(j, random.get(minIndex));
                random.set(minIndex, temp);
            }
        }
        return random;
    }
}
