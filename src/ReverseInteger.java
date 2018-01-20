
public class ReverseInteger {
	public int reverse(int x) {
		boolean isNegtive = x<0?true:false;
		x=x<0?-x:x;
		int target=0;
		while(x>0){
			target *=10;
			int temp = x%10;
			x = x/10;
			target += temp;
		}
		return isNegtive?-target:target;
	}
}
