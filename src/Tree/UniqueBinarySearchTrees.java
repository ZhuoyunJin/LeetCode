package Tree;

import Utility.Utility;

public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if(n <= 1) return n;
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = i+1;
		}
		//Utility.printArray(arr);
		return dfs(arr, 0, n-1);
	}
	public int dfs(int[] arr, int start, int end) {
		//step out.
		if(start>=end) return 1;
		int result =0;
		for(int i=start; i<=end;i++) {
			result += dfs(arr, start, i-1) * dfs(arr, i+1, end);
		}
		return result;
	}
	public static void main(String[] args) {
		UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
		System.out.println(test.numTrees(3));
	}

}
