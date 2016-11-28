package edu.paszgr.board;

import edu.paszgr.control.Tank;

import java.util.*;
import java.util.stream.Collectors;

public class Board {
//    private BoardSize boardSize;
    private Map<Position, List<Tank>> positionToTanksMap = new HashMap<>();
    private Map<Tank, Position> tankPositionMap = new HashMap<>();

    public void addTank(Tank tank, Position position) {
        List<Tank> currentTanks = positionToTanksMap.get(position);
        currentTanks.add(tank);
        positionToTanksMap.put(position, currentTanks);
        tankPositionMap.put(tank, position);
    }

    public List<Tank> getTanksListCopy(Position position) {
        List<Tank> original = positionToTanksMap.get(position);
        return new ArrayList<>(original);
    }

    public Position getPositionOfTank(Tank tank) {
        return tankPositionMap.get(tank);
    }

    public List<Tank> getAllTanks() {
        return tankPositionMap.keySet().stream().collect(Collectors.toList());
    }

    public void setNewTankPosition(Tank tank, Position newPosition) {

        Position oldPosition = getPositionOfTank(tank);
        tankPositionMap.put(tank, newPosition);

        if(positionToTanksMap.containsKey(oldPosition)) {
            positionToTanksMap.get(oldPosition).remove(tank);
        }

        if(positionToTanksMap.containsKey(newPosition)) {
            positionToTanksMap.get(newPosition).add(tank);
        } else {
            List<Tank> tanks = new ArrayList<>();
            tanks.add(tank);
            positionToTanksMap.put(newPosition, tanks);
        }

    }

    public void putTankOnPosition(Tank tank, Position initialPosition) {
        tankPositionMap.put(tank, initialPosition);

        if(positionToTanksMap.containsKey(initialPosition)) {
            positionToTanksMap.get(initialPosition).add(tank);
        } else {
            List<Tank> tanks = new ArrayList<>();
            tanks.add(tank);
            positionToTanksMap.put(initialPosition, tanks);
        }

    }

}
