package edu.paszgr.board;

import edu.paszgr.algo.Direction;
import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.algorithms.OnlyMoveAlgorithm;
import edu.paszgr.control.Player;
import edu.paszgr.control.Tank;
import junit.framework.TestCase;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by onegrx on 11.12.16.
 */
public class ExecutionManagerTest extends TestCase {

    ExecutionManager executionManager = new ExecutionManager();
    Board board = mock(Board.class);
    Player player = new Player(new OnlyMoveAlgorithm(), "Player");

    @Test
    public void executeMovementUpTest() throws Exception {

        //given
        Movement movement = new Movement(Direction.UP);
        Position position = new Position(1, 1);
        Tank tank = new Tank(player, board, 0, position);

        //when
        executionManager.executeTankAction(movement, tank, board);

        //then
        Position expectedPosition = new Position(1, 2);
        assertEquals(expectedPosition, tank.getPosition());

    }

    @Test
    public void executeMovementLeftTest() throws Exception {

        //given
        Movement movement = new Movement(Direction.LEFT);
        Position position = new Position(5, 3);
        Tank tank = new Tank(player, board, 0, position);

        //when
        executionManager.executeTankAction(movement, tank, board);
        executionManager.executeTankAction(movement, tank, board);

        //then
        Position expectedPosition = new Position(3, 3);
        assertEquals(expectedPosition, tank.getPosition());

    }
}