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
public class MatchLog {

  private ArrayList<MatchScore> matches = new ArrayList<>();

  public void addMatchToLog(Team homeTeam, Team awayTeam, String h1, String h2, String a1, String a2) {
    MatchScore match = new MatchScore(homeTeam, awayTeam, h1.toLowerCase(), h2.toLowerCase(), a1.toLowerCase(), a2.toLowerCase());
    matches.add(match);
  }

  public MatchScore getMatch(String homeT, String awayT) {
    MatchScore match = null;
    for (MatchScore iMatch : matches) {
      if (iMatch.getHomeTeamName().toLowerCase().equals(homeT.toLowerCase()) && iMatch.getAwayTeamName().toLowerCase().equals(awayT.toLowerCase())) {
        match = iMatch;
        break;
      }
    }
    return match;
  }
}
