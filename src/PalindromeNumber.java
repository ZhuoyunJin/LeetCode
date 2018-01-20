
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	if(x<0) return false;
    	int reversedNumber = 0;
    	int originalNumber = x;
    	while(x>0){
    		int remainder = x%10;
    		reversedNumber = reversedNumber*10 + remainder;
    		x=x/10;
    	}
    	return originalNumber==reversedNumber;
    }
}
