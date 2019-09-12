package Google.TopFrequency;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.*;

class CampusBikeComparator implements Comparator<int[]> {
    public int compare(int[] pair1, int[] pair2)
    {
        if(pair1[0]< pair2[0]) return -1;
        else if(pair1[1] < pair2[1]) return -1;
        return 1;
    }
}

public class CampusBike {

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] result = new int[workers.length];

        Set<Integer> availableWorkers = new HashSet<>();
        for(int i=0;i<workers.length;i++){
            availableWorkers.add(i);
        }

        Set<Integer> availableBikes = new HashSet<>();
        for(int i=0;i<bikes.length;i++){
            availableBikes.add(i);
        }

        Map<Integer, TreeSet<int[]>> distanceMap = new TreeMap<>();
        int[][] distance = new int[workers.length][bikes.length];
        for(int i=0;i<workers.length;i++){
            for(int j=0;j<bikes.length;j++){
                distance[i][j] = getManhattanDistance(workers[i][0],workers[i][1], bikes[j][0], bikes[j][1]);
                if(!distanceMap.containsKey(distance[i][j])){
                    distanceMap.put(distance[i][j], new TreeSet<>(new CampusBikeComparator()));
                }
                distanceMap.get(distance[i][j]).add(new int[]{i, j});
            }
        }

        for(Map.Entry<Integer, TreeSet<int[]>> entry : distanceMap.entrySet()){
            for(int[] pair : entry.getValue()){
                int workerNumber = pair[0];
                int bikeNumber = pair[1];
                if(availableBikes.contains(bikeNumber) && availableWorkers.contains(workerNumber)){
                    result[workerNumber] = bikeNumber;
                    availableBikes.remove(bikeNumber);
                    availableWorkers.remove(workerNumber);
                }
            }
        }
        return result;
    }

    public int getManhattanDistance(int p1X, int p1Y, int p2X, int p2Y){
        return Math.abs(p1X-p2X) + Math.abs(p1Y-p2Y);
    }

}
