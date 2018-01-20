import java.util.Arrays;


public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min=Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<num.length-2;i++){
        	int start=i+1,end=num.length-1;
        	while(start<end){
        		int tempSum=num[start]+num[end]+num[i];
        		if(tempSum==target) return target;
        		else if(tempSum<target){
        			if(Math.abs(tempSum-target)<min){
        				min=Math.abs(tempSum-target);
        				res=tempSum;
        			}
        			start++;
        		}else{
        			if(Math.abs(tempSum-target)<min){
        				min=Math.abs(tempSum-target);
        				res=tempSum;
        			}
        			end--;
        		}
        	}
        }
        return res;
    }
}
