package Google.TopFrequency;

import Utility.ArrayHelper;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if (nums == null) return 0;
        if (nums.length ==1) return nums[0];

        int[][] matrix = new int[m][nums.length];
        matrix[0][0] = nums[0];
        for (int i=1;i<nums.length;i++){
           matrix[0][i] = matrix[0][i-1] + nums[i];
        }
        for(int i=1; i<nums.length;i++){
            for (int j = 1; j<m && j<=i; j++){
                int val = Integer.MAX_VALUE;
                for (int k = j; k<=i; k++){
                    int temp = Math.max(matrix[j-1][k-1], matrix[0][i]-matrix[0][k-1]);
                    val = temp < val? temp:val;
                }
                matrix[j][i] = val;
            }
        }

        ArrayHelper.printArray(matrix);
        return matrix[m-1][nums.length-1];
    }

    public int splitArrays(int[] nums, int m) {
        if (nums == null) return 0;
        if (nums.length ==1) return nums[0];

        int left = Integer.MIN_VALUE;
        int right = 0;

        for (int i=0;i<nums.length;i++){
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        if(m == 1) return right;
        if(m == nums.length) return left;
        int result = right;
        int mid;
        while (left <= right){
            mid = (right + left)/2;
            if (canSplit(nums, m, mid)){
                result = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result;
    }

    public boolean canSplit(int[] nums, int m, int target){
        int sum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(sum + nums[i] > target) {
                sum = nums[i];
                count++;
            }else{
                sum+=nums[i];
            }
        }
        if(sum>0) count++;
        return (count<=m);
    }

    public static void main(String[] args){
        SplitArrayLargestSum test = new SplitArrayLargestSum();
        int[] nums = new int[]{7,2,5,10,8};
        int output = test.splitArray(nums, 2);
        System.out.println(output);
    }
}
