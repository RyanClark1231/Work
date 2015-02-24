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
public class BinarySearch {

  RandomGen randomGen;
  SelectionSort sort;
  ArrayList<Integer> random = new ArrayList<>();

  public BinarySearch(int numberOfRandom, int between) {
    this.randomGen = new RandomGen(numberOfRandom, between);
    random = randomGen.Generator();
    sort = new SelectionSort(random);
    random = sort.run();
  }

  public BinarySearch() {
    this.randomGen = new RandomGen();
    random = randomGen.Generator();
    sort = new SelectionSort(random);
    random = sort.run();
  }

  public BinarySearch(ArrayList<Integer> random) {
    this.random = random;
  }

  public String run(int value) {
    int low = 0;
    int high = random.size() - 1;
    int centre;
    Boolean found = false;

    do {
      centre = (low + high) / 2;
      if (!random.contains(value)) {
        centre = 0;
        break;
      }
      if (value == random.get(centre)) {
        found = true;
      }
      if (value < random.get(centre)) {
        high = centre - 1;
      } else if (value > random.get(centre)) {
        low = centre + 1;
      }
    } while (!found);

    if (centre == 0) {
      return "The value was not found";
    } else {
      return "The value was found at index: " + centre;
    }

    //System.out.println(random);
  }
}
