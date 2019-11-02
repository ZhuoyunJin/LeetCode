package Graph;

import java.util.*;

public class AllPathsFromSourceLeadToDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> map = buildPathMap(edges);
        return isValid(source,destination, map, visited);
    }

    public boolean isValid(int source, int destination, Map<Integer, List<Integer>> map, Set<Integer> visited){
        List<Integer> connectedNodes = map.get(source);
        if(visited.contains(source)) return false;
        if(connectedNodes == null || connectedNodes.size() == 0)
            return source==destination;
        visited.add(source);

        for(int i : connectedNodes){
            boolean isChildValid = isValid(i, destination, map, visited);
            if(!isChildValid) return false;
        }
        visited.remove(source);
        return true;
    }

    public Map<Integer, List<Integer>> buildPathMap(int[][] edges){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            if(map.containsKey(from)){
                map.get(from).add(to);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(to);
                map.put(from, Arrays.asList(to));
            }
        }
        return map;
    }
}
