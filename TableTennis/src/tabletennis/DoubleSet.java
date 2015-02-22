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
public class DoubleSet extends SetScore {

  private Player homePlayer2, awayPlayer2;

  public DoubleSet(int i, Player homeP1, Player awayP1, Player homeP2, Player awayP2) {
    super(i, homeP1, awayP1);
    homePlayer2 = homeP2;
    awayPlayer2 = awayP2;
  }

  @Override
  public void submitSetScore(Player homePlayer, Player awayPlayer, ArrayList<GameScore> games) {
    /*homePlayer.incSetPlayed();
     homePlayer2.incSetPlayed();
     awayPlayer.incSetPlayed();
     awayPlayer2.incSetPlayed();

     homePlayer.incSetWon();
     awayPlayer.incSetWon();
     homePlayer2.incSetWon();
     awayPlayer2.incSetWon();*/
  }
}
