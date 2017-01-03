package edu.paszgr.board;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.TankAction;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.algo.algorithms.OnlyMoveAlgorithm;
import edu.paszgr.control.*;
import org.testng.annotations.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by onegrx on 11.12.16.
 */
public class TestExecutionManager {
    ExecutionManager executionManager = new ExecutionManager(Mockito.mock(GameInfoLogger.class));
    Board board = mock(Board.class);
    Player player = new Player(new OnlyMoveAlgorithm(), "Player", Color.black);

    @Test
    public void testExecuteMovementUp() throws Exception {
        //given
        Movement movement = new Movement(Direction.UP);
        Position position = new Position(1, 1);
        Tank tank = new Tank(player, board, 0, position);
        when(board.positionIsValid(position.getNeighbor(movement.getDirection()))).thenReturn(true);

        //when
        executionManager.executeTankAction(movement, tank, board, 1);

        //then
        Position expectedPosition = position.getNeighbor(movement.getDirection());
        assertEquals(expectedPosition, tank.getPosition());
    }

    @Test
    public void testMovementLeft() throws Exception {
        //given
        Movement movement = new Movement(Direction.LEFT);
        Position position = new Position(5, 3);
        Tank tank = new Tank(player, board, 0, position);
        when(board.positionIsValid(position.getNeighbor(movement.getDirection()))).thenReturn(true);
        when(board.positionIsValid(position.getNeighbor(movement.getDirection()).getNeighbor(movement.getDirection()))).thenReturn(true);

        //when
        executionManager.executeTankAction(movement, tank, board, 1);
        executionManager.executeTankAction(movement, tank, board, 1);

        //then
        Position expectedPosition = position.getNeighbor(movement.getDirection()).getNeighbor(movement.getDirection());
        assertEquals(expectedPosition, tank.getPosition());

    }

    @Test
    public void testWeaponFire() throws Exception {
        //given
        Direction direction = Direction.DOWN;

        Position position1 = new Position(1, 1);
        Position position2 = position1.getNeighbor(direction);

        Player player1 = Mockito.mock(Player.class);
        StatisticsManager manager1 = Mockito.mock(StatisticsManager.class);
        when(manager1.getStatisticsForRound(1)).thenReturn(new RoundStatistics(1));
        when(player1.getStatistics()).thenReturn(manager1);

        Player player2 = Mockito.mock(Player.class);
        StatisticsManager manager2 = Mockito.mock(StatisticsManager.class);
        when(manager2.getStatisticsForRound(1)).thenReturn(new RoundStatistics(1));
        when(player2.getStatistics()).thenReturn(manager2);

        Board board = Mockito.mock(Board.class);

        Tank tank1 = new Tank(player1, board, 1, position1);
        Tank tank2 = new Tank(player2, board, 1, position2);

        when(board.getTanksOnTargetLine(position1, direction)).thenReturn(new LinkedList<Tank>() {{
            add(tank2);
        }});

        TankAction weaponFire = new WeaponFire(direction);

        // then
        assertEquals(1, tank2.getLifePoints());

        //when
        executionManager.executeTankAction(weaponFire, tank1, board, 1);
        //then
        assertEquals(0, tank2.getLifePoints());
    }
}