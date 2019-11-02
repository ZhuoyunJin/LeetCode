package Graph;

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> map = buildPathMap(n, edges);
        visited.add(0);
        return helper(map, visited, 0, -1) && visited.size()==n;
    }

    public boolean helper(Map<Integer, List<Integer>> map, Set<Integer> visited, int current, int parent){
        List<Integer> connectedNodes = map.get(current);
        for(int i : connectedNodes){
            visited.add(current);
            if(i==parent) continue;
            if(visited.contains(i)){
                return false;
            }else{
                if(!helper(map, visited, i, current)){
                    return false;
                }
            }
        }
        return true;
    }

    public Map<Integer, List<Integer>> buildPathMap(int n, int[][] edges){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n;i++){
            map.put(i, new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }
        return map;
    }

    public static void main(String[] args){
        GraphValidTree test = new GraphValidTree();
        test.validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}});
    }
}
