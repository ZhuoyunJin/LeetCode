
public class GasStation {
	public int canCompleteCircuit2(int[] gas, int[] cost) {
        if(gas.length!=cost.length) return -1;
        int len=gas.length;
        int[] arr = new int[len];
		for(int i=0;i<len;i++){
			arr[i]=gas[i]-cost[i];
		}
		//start from k
		for(int k=0;k<len;k++){
			int sum=arr[k];
			int currentStation=k+1;
			int count=0;
			while(sum>=0&&count<len){
				currentStation=currentStation>=len?currentStation-len:currentStation;
				sum=sum+arr[currentStation];
				currentStation++;
				count++;
			}
			if(sum>=0) return k;
		}
		return -1;
    }
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length!=cost.length) return -1;
        int len=gas.length;
        int[] arr = new int[len];
        int sum=0;
		for(int i=0;i<len;i++){
			arr[i]=gas[i]-cost[i];
			sum+=arr[i];
		}
		if(sum<0) return -1;
		sum=0;
		int index=0;
		for(int i=0;i<len;i++){
			sum+=arr[i];
			if(sum<0){
				sum=0;
				index=i+1;
			}
		}
		return index;
    }
}
