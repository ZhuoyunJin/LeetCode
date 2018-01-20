package Google;
/**
Given an integer, write a function to determine if it is a power of three.
*/
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
    	if(n<0) return false;
    	if(n==1) return true;
    	int max_power = Integer.MAX_VALUE/3;
    	int multiple = 1;
    	while(multiple<max_power)
    	{
    		multiple*=3;
    		if(n==multiple) return true;
    	}
    	return false;
    }
    
    public boolean isPowerOfThree2(int n){
    	// 1162261467 is 3^19,  3^20 is bigger than int
    	return ( n>0 && 1162261467%n==0);
    }
}
