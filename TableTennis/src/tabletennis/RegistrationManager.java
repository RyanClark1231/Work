package tabletennis;


import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ryan
 */
public class RegistrationManager {

  private Map<String, Team> teams = new HashMap();
  private Map<String, Player> players = new HashMap();

  public void addTeam(String name, String venue) {
    Team team = new Team(name, venue);
    teams.put(name.toLowerCase(), team);
  }

  public Team getTeam(String name) {
    return teams.get(name.toLowerCase());
  }

  public void regPlayerToTeam(String name, String team) {
    Player player = new Player(name);
    players.put(name.toLowerCase(), player);
    teams.get(team.toLowerCase()).addMember(name.toLowerCase(), player);
  }

  public Map<String, Team> getAllTeams() {
    return teams;
  }

  public Map<String, Player> getAllPlayers() {
    return players;
  }

  public Boolean isTeamValid(String team, String player1, String player2) {
    Boolean valid = false;

    if (teams.get(team.toLowerCase()).isPlayerValid(player1.toLowerCase()) & teams.get(team.toLowerCase()).isPlayerValid(player2.toLowerCase())) {
      valid = true;
    }

    return valid;
  }
}
