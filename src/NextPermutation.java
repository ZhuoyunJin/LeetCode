
public class NextPermutation {
	public void nextPermutation(int[] num) {
		if(num.length<=1) return;
        if(!nextPermutation(num,0)){
        	reverse(num);
        }
    }
	
	public boolean nextPermutation(int[] num, int start){
		if((num.length-1-start)>=2){
			if(nextPermutation(num, start+1)) return true;
			else{
				if(num[start]>=num[start+1]) return false;
				else{
					int index=start;
					for(int j=start+1;j<num.length;j++){
						if(num[start]<num[j])
							index=j;
						else
							break;
					}
					int temp=num[index];
					num[index]=num[start];
					num[start]= temp;
					reverse(num,start+1);
					return true;
				}
			}
		}else{
			if(num[start]<num[start+1]){
				int temp=num[start];
				num[start]=num[start+1];
				num[start+1]=temp;
				return true;
			}else {
				return false;
			}
		}
	}
	
	public void reverse(int[] num){
		reverse(num,0);
	}
	public void reverse(int[] num, int start){
		for(int i=start;i<=(num.length-1+start)/2;i++){
			int temp=num[i];
			num[i]=num[num.length-1+start-i];
			num[num.length-1+start-i] = temp;
		}
	}
}
