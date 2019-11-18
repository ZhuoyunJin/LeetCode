package Google;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]< first){
                first = nums[i];
            } else if(nums[i]>first && nums[i]<second){
                second = nums[i];
            } else if(nums[i]> second){
                return true;
            }
        }
        return false;
    }
}
