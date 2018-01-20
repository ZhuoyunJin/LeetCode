
public class TrappingRainWater {
    public int trap(int[] A) {
    	if(A.length==0) return 0;
        int water=0;
        int[] arrLeft=new int[A.length];
        arrLeft[0]=A[0];
        for(int i=1;i<A.length;i++){
        	if(A[i]>arrLeft[i-1]) arrLeft[i]=A[i];
        	else arrLeft[i]=arrLeft[i-1];
        }
        int longest=A[A.length-1];
        for(int i=A.length-2;i>=0;i--){
        	if(A[i]>longest) longest=A[i];
        	if(arrLeft[i]>A[i]&&longest>A[i]){
        		water+=Math.min(arrLeft[i], longest)-A[i];
        	}
        }
        return water;
    }
}
