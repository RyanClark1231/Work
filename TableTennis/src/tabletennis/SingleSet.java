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
public class SingleSet extends SetScore {

  public SingleSet(int i, Player hP, Player aP) {
    super(i, hP, aP);
  }

  @Override
  public void submitSetScore(Player homePlayer, Player awayPlayer, ArrayList<GameScore> games) {
    homePlayer.incSetPlayed();
    awayPlayer.incSetPlayed();

    if ((games.get(0).getHPlayerPts() == 11 & games.get(1).getHPlayerPts() == 11) | (games.get(0).getHPlayerPts() == 11 & games.get(2).getHPlayerPts() == 11) | (games.get(1).getHPlayerPts() == 11 & games.get(2).getHPlayerPts() == 11)) {
      homePlayer.incSetWon();
    } else {
      awayPlayer.incSetWon();
    }

  }
}
