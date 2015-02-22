package tabletennis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
public class Player {

  private String name;
  private int setPlayed, setWon;

  public Player(String name) {
    this.name = name;
  }

  public void incSetWon() {
    setWon++;
  }

  public void incSetPlayed() {
    setPlayed++;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    String output = "Player: " + name + " Sets played: " + setPlayed + " Sets won: " + setWon + "\n";
    return output;
  }
}
