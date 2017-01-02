package edu.paszgr.board;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.algorithms.OnlyMoveAlgorithm;
import edu.paszgr.control.GameInfoLogger;
import edu.paszgr.control.Player;
import edu.paszgr.control.Tank;
import org.testng.annotations.Test;
import org.mockito.Mockito;

import java.awt.*;

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
}