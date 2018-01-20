package Google;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int carry=0;
		int len=digits.length;
		digits[len-1]=digits[len-1]+1;
		for(int i=digits.length-1;i>=0;i--){
			digits[i]=carry+digits[i];
			if(digits[i]>=10){
				carry=1;
				digits[i]=digits[i]-10;
			}else{
				carry=0;
			}
		}
		if(carry==0) return digits;
		else{
			int[] newArr = new int[len+1];
			newArr[0]=1;
			for(int i=0;i<len;i++){
				newArr[i+1]=digits[i];
			}
			return newArr;
		}
	}
}
