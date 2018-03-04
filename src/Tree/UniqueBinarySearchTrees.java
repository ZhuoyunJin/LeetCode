package Tree;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if(n <= 1) return n;
		int[] arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = i;
		}
		return dfs(arr, 1, n);
	}
	public int dfs(int[] arr, int start, int end) {
		//step out.
		int result = 0;
		for(int i=start; i<=end;i++) {
			result+=dfs(arr, 1, i-1);
			result+=dfs(arr, i+1, end);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
