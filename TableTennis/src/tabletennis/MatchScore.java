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
public class MatchScore {

  private int homeTeamWin, awayTeamWin;
  private Team homeTeam, awayTeam;
  private String h1, h2, a1, a2;
  private ArrayList<SingleSet> singleS;
  private DoubleSet doubleS;

  public MatchScore(Team homeTeam, Team awayTeam, String h1, String h2, String a1, String a2) {
    singleS = new ArrayList<>(4);
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
    this.h1 = h1;
    this.h2 = h2;
    this.a1 = a1;
    this.a2 = a2;
    singleS.add(new SingleSet(1, homeTeam.getPlayers().get(h1), awayTeam.getPlayers().get(a1)));
    singleS.add(new SingleSet(2, homeTeam.getPlayers().get(h1), awayTeam.getPlayers().get(a2)));
    singleS.add(new SingleSet(3, homeTeam.getPlayers().get(h2), awayTeam.getPlayers().get(a1)));
    singleS.add(new SingleSet(4, homeTeam.getPlayers().get(h2), awayTeam.getPlayers().get(a2)));
    doubleS = new DoubleSet(5, homeTeam.getPlayers().get(h1), homeTeam.getPlayers().get(h2), awayTeam.getPlayers().get(a1), awayTeam.getPlayers().get(a2));

  }

  public SingleSet getASingleSet(String hName, String aName) {
    SingleSet set = null;
    for (SingleSet sets : singleS) {
      if (sets.getHomePlayer().getName().toLowerCase().equals(hName.toLowerCase()) && sets.getAwayPlayer().getName().toLowerCase().equals(aName.toLowerCase())) {
        set = sets;
        break;
      }
    }
    return set;
  }

  public DoubleSet getDoubleSet() {
    return doubleS;
  }

  public void getHomePWin() {

  }

  public int getHomeTWin() {
    return homeTeamWin;
  }

  public int getAwayTWin() {
    return awayTeamWin;
  }

  public int calculateHomePlayerScore(String hName) {
    int pts = 0;
    for (SingleSet sets : singleS) {

      if (sets.getHomePlayer().getName().equals(hName)) {
        if (sets.calculateHomeWin()) {
          pts++;
        }
      }
    }
    switch (2 - pts) {
      case 0:
        homeTeamWin += 2;
        break;
      case 1:
        awayTeamWin++;
        homeTeamWin++;
        break;
      case 2:
        awayTeamWin += 2;
        break;
      default:
        break;
    }
    return pts;
  }

  public Boolean calculateHomeTeamScore() {
    Boolean hWin = false;
     
    if (doubleS.calculateHomeWin()) {
      hWin = true;
      homeTeamWin++;
    } else {
      awayTeamWin++;
    }

    return hWin;
  }

  public String getHomeTeamName() {
    return homeTeam.getName();
  }

  public String getAwayTeamName() {
    return awayTeam.getName();
  }

  public void submitTeamAndPlayerWins() {
    homeTeam.addPts(homeTeamWin);
    awayTeam.addPts(awayTeamWin);
    for (SingleSet set : singleS) {
      set.submitSetScore(set.getHomePlayer(), set.getAwayPlayer(), set.getGames());
    }
    doubleS.submitSetScore(doubleS.getHomePlayer(), doubleS.getAwayPlayer(), doubleS.getGames());
  }

  public void setHomeTeamWin(int homeTeamWin) {
    this.homeTeamWin = homeTeamWin;
  }

  public void setAwayTeamWin(int awayTeamWin) {
    this.awayTeamWin = awayTeamWin;
  }

}
