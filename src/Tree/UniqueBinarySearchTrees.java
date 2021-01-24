package Tree;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if(n <= 1) return 1;
		else if(n == 2) return 2;

		int result = 0;
		for(int i=1;i<=n;i++) {
			result += numTrees(i-1)*numTrees(n-i);
		}
		return result;
	}

	//Using DP, without recursion.
	public int numTrees2(int n) {
		if(n <= 1) return 1;
		else if(n == 2) return 2;

		int[] numArr = new int[n+1];
		numArr[0] = 1;
		numArr[1] = 1;
		numArr[2] = 2;

		for(int i=3; i<=n; i++){
			int temp = 0;
			for(int j=1; j<=i; j++){
				temp += numArr[j-1]*numArr[i-j];
			}
			numArr[i] = temp;
		}
		return numArr[n];
	}

	public static void main(String[] args) {
		UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
		System.out.println(test.numTrees(2));
	}

}
