package edu.paszgr.control;

import edu.paszgr.algo.algorithms.OnlyMoveAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class PlayersManager {

    public List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(new OnlyMoveAlgorithm(), "Tiger"));
        players.add(new Player(new OnlyMoveAlgorithm(), "M1 Abrams"));
        return players;
    }
}
