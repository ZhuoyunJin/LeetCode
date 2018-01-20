
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if(height.length <= 1) return 0;
		int left=0, right=height.length-1;
		int max = 0;
		int area=0;
        while(left<right){
        	if(height[left]<height[right]){
        		area=height[left]*(right-left);
        		max=Math.max(area, max);
        		left++;
        	}else{
        		area=height[right]*(right-left);
        		max=Math.max(area, max);
        		right--;
        	}
        		
        }
        return max;
    }
}
