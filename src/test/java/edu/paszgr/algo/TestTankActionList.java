package edu.paszgr.algo;

import edu.paszgr.algo.actions.Movement;
import edu.paszgr.algo.actions.WeaponFire;
import edu.paszgr.algo.actions.weapons.LaserWeaponFire;
import edu.paszgr.board.Position;
import edu.paszgr.board.StateInfo;
import junit.framework.TestCase;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.when;

public class TestTankActionList extends TestCase {

    @Test
    public void testAddAction() {
        // given
        StateInfo stateInfo = Mockito.mock(StateInfo.class);
        when(stateInfo.getMyTankPosition()).thenReturn(new Position(1, 1));
        int initialActionPoints = 10;
        TankAction action = new LaserWeaponFire(Direction.DOWN);

        TankActionList tankActionList = new TankActionList(stateInfo, initialActionPoints);

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
        TankAction newAction = new Movement(Direction.DOWN);
        actionsList.add(newAction);
        assertFalse(tankActionList.getActions().contains(newAction));

        // remaining action points matches
        assertEquals(initialActionPoints - action.getActionPointsBasicCost(), tankActionList.getRemainingActionPoints());
    }
}
