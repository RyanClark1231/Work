package tabletennis;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ryan
 */
public abstract class SetScore {

  private Player homePlayer, awayPlayer;
  private int setNum;
  private ArrayList<GameScore> games;

  public SetScore(int i, Player homeP, Player awayP) {
    games = new ArrayList<>(3);
    homePlayer = homeP;
    awayPlayer = awayP;
    setNum = i;
    for (int j = 0; j < 3; j++) {
      games.add(new GameScore());
    }
  }

  public void enterSetScore(int h1, int a1, int h2, int a2, int h3, int a3) {
    games.get(0).setGameScore(h1, a1);
    games.get(1).setGameScore(h2, a2);
    games.get(2).setGameScore(h3, a3);

  }

  public Boolean calculateHomeWin() {
    int hPts = 0;
    Boolean hWin = false;
    for (int i = 0; i < 3; i++) {
      if (games.get(i).getHPlayerPts() > games.get(i).getAPlayerPts()) {
        hPts++;
      }
    }
    if (hPts >= 2) {
      hWin = true;
    }

    return hWin;
  }

  public Player getHomePlayer() {
    return homePlayer;
  }

  public Player getAwayPlayer() {
    return awayPlayer;
  }

  public ArrayList<GameScore> getGames() {
    return games;
  }

  public abstract void submitSetScore(Player homePlayer, Player awayPlayer, ArrayList<GameScore> games);
}
