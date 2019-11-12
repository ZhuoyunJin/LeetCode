package Google.TopFrequency;

import java.util.*;

//[[0,1,10], [2,0,5]]

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        int n = transactions.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int personLent = transactions[i][0];
            int personBorrow = transactions[i][1];
            int amount = transactions[i][2];
            map.put(personLent, map.getOrDefault(personLent, 0) + amount);
            map.put(personBorrow, map.getOrDefault(personBorrow, 0) - amount);
        }

        List<Integer> list = new ArrayList<>();
        for(Integer value:map.values()){
            if(value != 0){
                list.add(value);
            }
        }

        return calculate(list);
    }

    public int calculate(List<Integer> list){
        int count= Integer.MAX_VALUE;
        boolean isSettled = true;
        for(int i: list){
            if(i != 0){
                isSettled = false;
                break;
            }
        }
        if(isSettled) return 0;
        int start=0;
        for(int i = 0; i< list.size();i++){
            if(list.get(i) != 0) {
                start=i;
                break;
            }
        }
        for(int i=start+1 ; i < list.size(); i++){
            if(list.get(start) * list.get(i) < 0){
                int startAmount = list.get(start);
                int iAmount = list.get(i);
                list.set(start, startAmount+iAmount);
                list.set(i, 0);
                int tempCount = calculate(list) + 1;
                if(tempCount<count) count = tempCount;
                list.set(start, startAmount);
                list.set(i, iAmount);
            }
        }
        return count;
    }

    public static void main(String[] args){
        OptimalAccountBalancing test = new OptimalAccountBalancing();
        int x = test.minTransfers(new int[][]{{0,1,10},{2,0,5}});
        System.out.println(x);
    }
}
