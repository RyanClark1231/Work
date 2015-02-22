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
public class Team {
   private String name, venue;
    private int ptsWon;
    private Map<String, Player> players;

    public Team(String name, String venue) {
        this.name = name;
        this.venue = venue;
        players = new HashMap();
    }

    public String getName() {
        return name;
    }

    public void addMember(String name, Player player) {
        players.put(name.toLowerCase(), player);
    }

    public String getVenue() {
        return venue;
    }

    public Boolean isPlayerValid(String name) {
        Boolean valid = false;

        if (players.containsKey(name)) {
            valid = true;
        }

        return valid;
    }

    public void addPts(int pts) {
        ptsWon += pts;
    }

    public int getPtsWon() {
        return ptsWon;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        String output = "Team name: " + name + " Total points: " + ptsWon + "\n";
        return output;
    }
}
