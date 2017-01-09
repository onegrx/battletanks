package edu.paszgr.control;

import edu.paszgr.algo.algorithms.OnlyMoveAlgorithm;
import edu.paszgr.algo.algorithms.SmartAlgorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayersManager {

    public List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(new OnlyMoveAlgorithm(), "Tiger", Color.BLACK));
        players.add(new Player(new OnlyMoveAlgorithm(), "M1 Abrams", Color.RED));
        players.add(new Player(new SmartAlgorithm(), "Smart Panzer Tank", Color.YELLOW));
        return players;
    }
}
