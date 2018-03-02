package Math;

public class BitwiseANDOfNumbersRange {
	public int rangeBitwiseAnd2(int m, int n) {
		int result = m;
		for(int i = m ; i<= n; i++) {
			result &= i;
		}
		return result;
	}

	//Find the common prefix
	public int rangeBitwiseAnd(int m, int n) {
		if(m==n) return m;
		int result = 1;
		while(m!=n) {
			m >>= 1;
			n >>= 1;
			result <<= 1;
		}
		if(m==0) return 0;
		result<<=1;
		
		return result;
	}
	public static void main(String[] args) {
		BitwiseANDOfNumbersRange b = new BitwiseANDOfNumbersRange();
		System.out.println(b.rangeBitwiseAnd(4,5));
		System.out.println(2<<1);
	}

}
