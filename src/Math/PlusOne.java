package Math;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0) return digits;
        int len= digits.length;
        int carry=1;
        for(int i=len-1;i>=0;i--){
        	if(digits[i]==9&& carry==1){
        		digits[i]=0;
        		carry=1;
        	}else{
        		digits[i]=digits[i]+carry;
        		carry=0;
        	}
        } 
        if(carry==0) return digits;
        else{
        	int[] newDigits = new int[len+1];
        	newDigits[0]=1;
        	for(int i=0;i<len;i++){
        		newDigits[i+1]=digits[i];
        	}
        	return newDigits;
        }
    }
}
