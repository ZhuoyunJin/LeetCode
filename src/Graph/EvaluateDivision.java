package Graph;

import java.util.*;

public class EvaluateDivision {

    //equations = [ ["a", "b"], ["b", "c"] ],
    //values = [2.0, 3.0],
    //queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
    //return [6.0, 0.5, -1.0, 1.0, -1.0 ].
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> edges = new HashMap<>();
        Map<String, List<Double>> weights = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> equation = equations.get(i);
            double value = values[i];
            String start = equation.get(0);
            String end = equation.get(1);
            if(!edges.containsKey(start)){
                edges.put(start, new ArrayList<>());
                weights.put(start, new ArrayList<>());
            }
            edges.get(start).add(end);
            weights.get(start).add(value);

            if(!edges.containsKey(end)){
                edges.put(end, new ArrayList<>());
                weights.put(end, new ArrayList<>());
            }
            edges.get(end).add(start);
            weights.get(end).add(1.0/value);
        }

        double[] result = new double[queries.size()];
        Set<String> visited = new HashSet<>();
        for(int i = 0; i<queries.size();i++){
            visited.clear();
            double multi = calcSingleEquation(queries.get(i), visited, edges, weights, 1.0);
            result[i] = multi<0? -1: multi;
        }
        return result;
    }

    public double calcSingleEquation(List<String> query, Set<String> visited, Map<String, List<String>> edges,
                                     Map<String, List<Double>> weights, double currentResult){
        String start = query.get(0);
        String end = query.get(1);
        if(!edges.containsKey(start)) return -1;
        if(start.equals(end)) return 1;
        List<String> edgesOfStart = edges.get(start);
        List<Double> weightsOfStart = weights.get(start);
        visited.add(start);

        double retVal = -1;
        for(int i=0;i<edgesOfStart.size();i++){
            String e = edgesOfStart.get(i);
            double w = weightsOfStart.get(i);
            if(visited.contains(e)) continue;
            else if(e.equals(end)) return w*currentResult;
            else {
                double temp = calcSingleEquation(new ArrayList<>(Arrays.asList(e, end)), visited, edges, weights, currentResult * w);
                if(temp>=0) retVal = temp;
            }
        }
        visited.remove(start);
        return retVal;
    }

    public static void main(String[] args){
        EvaluateDivision test = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<>(Arrays.asList("x1","x2")));
        equations.add(new ArrayList<>(Arrays.asList("x2","x3")));
        equations.add(new ArrayList<>(Arrays.asList("x3","x4")));
        equations.add(new ArrayList<>(Arrays.asList("x4","x5")));

        double[] values = new double[]{3.0,4.0,5.0,6.0};

        List<List<String>> queries = new ArrayList<>();
//        queries.add(new ArrayList<>(Arrays.asList("a","b")));
//        queries.add(new ArrayList<>(Arrays.asList("b","a")));
        queries.add(new ArrayList<>(Arrays.asList("x3","x4")));

        double[] result = test.calcEquation(equations, values, queries);
        for (double d : result){
            System.out.println(d);
        }
    }

}
