package edu.paszgr.control;

import edu.paszgr.algo.algorithms.OnlyMoveAlgorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayersManager {

    public List<Player> createPlayers() {
        // TODO - create players assigning them a unique color
        List<Player> players = new ArrayList<>();
        players.add(new Player(new OnlyMoveAlgorithm(), "Tiger", Color.BLACK));
        players.add(new Player(new OnlyMoveAlgorithm(), "M1 Abrams", Color.RED));
        return players;
    }
}
