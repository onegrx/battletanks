package edu.paszgr.control;

import edu.paszgr.board.Board;
import edu.paszgr.board.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by onegrx on 13.12.16.
 */

@RunWith(MockitoJUnitRunner.class)
public class TankTest {

    @Mock private Player player;
    @Mock private Board board;
    @Mock private Position position;
    @Mock private RoundStatistics roundStatistics;


    @Test
    public void getLifePointsTest() throws Exception {
        Tank tank = new Tank(player, board, 1, position, color);
        assertEquals(1, tank.getLifePoints());
    }

    @Test
    public void isAlive() throws Exception {
        Tank tank = new Tank(player, board, 3, position, color);
        assertEquals(true, tank.isAlive());

        when(player.currentRound()).thenReturn(roundStatistics);

        tank.decreaseLifePoints(1);
        verify(roundStatistics).setLifePointsLeft(2);
        assertEquals(true, tank.isAlive());
        tank.decreaseLifePoints(2);
        verify(roundStatistics).setLifePointsLeft(0);
        assertEquals(false, tank.isAlive());
        tank.decreaseLifePoints(10);
        assertEquals(false, tank.isAlive());
    }

}