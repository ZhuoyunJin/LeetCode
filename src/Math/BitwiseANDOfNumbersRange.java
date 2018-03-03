package Math;

public class BitwiseANDOfNumbersRange {
	public int rangeBitwiseAnd2(int m, int n) {
		int result = m;
		for(int i = m ; i<= n; i++) {
			result &= i;
		}
		return result;
	}

	//11000  100  10
	//11100  101  11
	//Find the common prefix
	public int rangeBitwiseAnd(int m, int n) {
		if(m==n) return m;
		int result = 0;
		while(m!=n) {
			m >>= 1;
			n >>= 1;
			result++;
		}
		if(m==0) return 0;
		for(int i=1; i<=result; i++) {
			m<<=1;
		}
		return m;
	}
	public static void main(String[] args) {
		BitwiseANDOfNumbersRange b = new BitwiseANDOfNumbersRange();
		System.out.println(b.rangeBitwiseAnd(5,7));
		//System.out.println(2<<1);
	}

}
