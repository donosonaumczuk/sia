package ar.edu.itba.sia.gridlock;

import ar.edu.itba.sia.gps.api.Heuristic;
import ar.edu.itba.sia.gps.api.State;

public class HeuristicGridLockDistance implements Heuristic {

    @Override
    public Integer getValue(State state) {
        if(!(state instanceof StateGridLock)) {
            throw new RuntimeException("State must be a GridLock state");
        }
        BoardGridLock aux = ((StateGridLock)state).getBoard();

        int ans = 0;
        int exitX = aux.getExit().x;
        int exitY = aux.getExit().y;
        if(aux.getGoalBlock().getFirstDirection() == Direction.UP) {
            int currentX;
            int dir;
            if (exitX == 0) {
                currentX = aux.getGoalBlock().getBegin().x;
                dir = -1;
            }
            else {
                currentX = aux.getGoalBlock().getEnd().x;
                dir = 1;
            }
            while (currentX != exitX) {
                ans++;
                currentX = currentX + dir;
            }
        }
        else {
            int currentY;
            int dir;
            if (exitY == 0) {
                currentY = aux.getGoalBlock().getBegin().y;
                dir = -1;
            }
            else {
                currentY = aux.getGoalBlock().getEnd().y;
                dir = 1;
            }
            while (currentY != exitY) {
                ans++;
                currentY = currentY + dir;
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        return "Returns the distance from the goal block to the exit";
    }
}