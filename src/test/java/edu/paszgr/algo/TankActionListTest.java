//package edu.paszgr.algo;
//
//import edu.paszgr.board.TankActionExecutor;
//import junit.framework.TestCase;
//import org.testng.annotations.Test;
//
//public class TankActionListTest extends TestCase {
//    @Test
//    public void testAddAction() {
//        TankActionList actionList = new TankActionList(stateInfo, stateInfo);
//        int limit = actionList.getRemainingActionPoints();
//
//        TankAction action = createTankAction(limit + 1);
//
//        actionList.addAction(action);
//        assertEquals(
//                actionList.getActions().size(),
//                0
//        );
//
//        action = createTankAction(limit);
//        actionList.addAction(action);
//        assertEquals(
//                actionList.getActions().size(),
//                1
//        );
//
//        action = createTankAction(1);
//        actionList.addAction(action);
//        assertEquals(
//                actionList.getActions().size(),
//                1
//        );
//    }
//
//    private TankAction createTankAction(int actionPoints) {
//        return new TankAction() {
//            @Override
//            public void acceptExecutor(TankActionExecutor executor) {}
//            @Override
//            public int getActionPointsCost() {
//                return actionPoints;
//            }
//        };
//    }
//}
