package Google;

import java.util.*;

interface Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move();

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();
    void turnRight();

    // Clean the current cell.
    void clean();
}

public class RobotRoomCleaner {
    public void cleanRoom(Robot robot) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        dfs(visited, robot, 0, 0, 0);
    }

    private void dfs(Map<Integer, Set<Integer>> map, Robot robot, int x, int y, int d){
        Set<Integer> set = map.get(x);
        if(set == null){
            set = new HashSet<>();
            map.put(x, set);
        }
        if(!set.add(y)) {
            reverse(robot);
            return;
        }
        robot.clean();
        for(int i = 0; i < 4; i++){
            int newD = (d + i) % 4;
            if(newD == 0 && robot.move()){
                dfs(map, robot, x, y-1, newD);
            }else if(newD == 1 && robot.move()){
                dfs(map, robot, x+1, y, newD);
            }else if(newD == 2 && robot.move()){
                dfs(map, robot, x, y+1, newD);
            }else if(newD == 3 && robot.move()){
                dfs(map, robot, x-1, y, newD);
            }
            robot.turnRight();
        }
        reverse(robot);
    }

    private void reverse(Robot robot){
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public static void main() {
    }
}
