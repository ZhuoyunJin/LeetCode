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

	public static void main(String[] args) {
		UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
		System.out.println(test.numTrees(2));
	}

}
