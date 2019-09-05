package Google.TopFrequency;
import java.util.Map;
import java.util.HashMap;
/** No.1 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 1) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
