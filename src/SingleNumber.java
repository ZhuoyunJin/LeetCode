import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, 2);
            } else {
                map.put(i, 1);
            }
        }

        for(int i : nums){
            if(map.get(i) == 1){
                return i;
            }
        }
        return 0;
    }

    //Using bit operation
    public int singleNumber2(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
