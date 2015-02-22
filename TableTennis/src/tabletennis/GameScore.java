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
public class GameScore {

  private int hPlayerPts, aPlayerPts;

  public void setGameScore(int hPlayerPts, int aPlayerPts) {
    this.hPlayerPts = hPlayerPts;
    this.aPlayerPts = aPlayerPts;
  }

  public int getHPlayerPts() {
    return hPlayerPts;
  }

  public int getAPlayerPts() {
    return aPlayerPts;
  }
}
