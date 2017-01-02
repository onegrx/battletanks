package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.Position;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by onegrx on 13.12.16.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestTank {

    @Mock private Player player;
    @Mock private Board board;
    @Mock private Position position;
    @Mock private RoundStatistics roundStatistics;


    @Test
    public void testGetLifePoints() throws Exception {
        Tank tank = new Tank(player, board, 1, position);
        assertEquals(1, tank.getLifePoints());
    }

    @Test
    public void testIsAlive() throws Exception {
        Tank tank = new Tank(player, board, 3, position);
        assertEquals(true, tank.isAlive());

        tank.setLifePoints(tank.getLifePoints() - 1);
        assertEquals(true, tank.isAlive());
        tank.setLifePoints(tank.getLifePoints() - 2);
        assertEquals(false, tank.isAlive());
        tank.setLifePoints(tank.getLifePoints() - 10);
        assertEquals(false, tank.isAlive());
    }
}