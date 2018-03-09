import java.util.*;

public class Test {
	public int minSteps(int[][] matrix, int x, int y) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        dfs(matrix, 0, 0, x, y, min, 0, new HashSet<String>());
        return min[0];
    }

    private void dfs(int[][] matrix, int i, int j, int x, int y,
                     int[] min, int step, Set<String> visited) {
        if (visited.contains(i + "_" + j)) {
            return;
        }
        if (i == x && j == y) {
            // Update the global min
            min[0] = Math.min(min[0], step);
            return;
        }
        // App this i,j to the visited set
        visited.add(i + "_" + j);

        if (i+1 < matrix.length) {
            dfs(matrix, i+1, j , x, y, min, step+1, visited);
        }
        if (i-1 >= 0) {
            dfs(matrix, i-1, j , x, y, min, step+1, visited);
        }
        if (j+1 < matrix[0].length) {
            dfs(matrix, i, j+1 , x, y, min, step+1, visited);
        }
        if (j-1 >= 0) {
            dfs(matrix, i, j-1 , x, y, min, step+1, visited);
        }
        visited.remove(i + "_" + j);
    }
	public static void main(String[] args){
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		Test test = new Test();
		System.out.println(test.minSteps(matrix, 2,1));
		
	}
}
