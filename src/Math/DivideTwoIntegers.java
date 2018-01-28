package Math;


public class DivideTwoIntegers {
	public int divide1(int dividend, int divisor) {
		if(divisor==0) return 0;
		int quotient=0;
		boolean isNegtive = (dividend<0 ^ divisor<0);
		dividend=Math.abs(dividend);
		divisor = Math.abs(divisor);
		while(dividend>0){
			dividend-=divisor;
			if(dividend>=0) quotient++;
		}
		return isNegtive?-quotient:quotient;
	}

	public int divide(int dividend, int divisor) {
		if(divisor==0) throw new ArithmeticException();
		if(divisor==Integer.MIN_VALUE) 
			return divisor==dividend?1:0;
		int flag=0;
		boolean isNegtive = (dividend ^ divisor)<0;
		if(dividend==Integer.MIN_VALUE){
			dividend+=divisor;
			flag=1;
		}
		dividend=Math.abs(dividend);
		divisor = Math.abs(divisor);
		if(dividend<divisor) return isNegtive?-flag:flag;
		int res=1;
		int count=0;
		while(dividend>divisor){
			if(divisor<<1 <=0 || divisor<<1 >dividend) break;
			divisor=divisor<<1;
			res=res<<1;
			count++;
		}
		int res2=res;
		dividend-=divisor;
		while(count>0){
			divisor>>=1;
			res2=res2>>1;
			int remaining=dividend-divisor;
			if(remaining>=0){
				dividend-=divisor;
				res+=res2;
			}
			count--;
		}
		res+=flag;
		return isNegtive?-res:res;
	}
}
