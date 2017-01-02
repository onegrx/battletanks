package edu.paszgr.algo;

import edu.paszgr.algo.actions.Movement;
import junit.framework.TestCase;
import org.mockito.Mock;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.when;

public class TankActionListTest extends TestCase {
    @Mock private ActionPointsCostCalculator pointsCostCalculator;

    @Test
    public void testAddAction() {
        // given
        int initialActionPoints = 10;
        TankAction action = new Movement(Direction.DOWN);

        when(pointsCostCalculator.getPointsCost(null, action, null))
                .thenReturn(new TankActionListStateInfo(null, initialActionPoints));
        TankActionList tankActionList = new TankActionList(null, initialActionPoints);

        // when
        tankActionList.addAction(action);

        // then

        // action added
        assertTrue(tankActionList.getActions().contains(action));

        // number of added actions matches
        assertEquals(tankActionList.getActions().size(), 1);

        // returned list does not affect TankActionList internally
        List<TankAction> actionsList = tankActionList.getActions();
        actionsList.remove(action);
        assertTrue(tankActionList.getActions().contains(action));

        // remaining action points matches
        assertEquals(tankActionList.getRemainingActionPoints(), 0);
    }
}
