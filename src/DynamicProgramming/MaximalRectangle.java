package DynamicProgramming;

import Utility.ArrayHelper;

import java.util.Arrays;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                if(j==0) {
                    dp[i][j] = matrix[i][j] =='1'? 1 : 0;
                } else {
                    dp[i][j] = matrix[i][j] == '1' ? matrix[i][j - 1] + 1 : 1;
                }
            }
        }

        ArrayHelper.printArray(dp);

        int maxArea = 0;
        for(int i=0; i<m; i++){
            for(int j=n-1;j>=0; j--){
                int maxWidth = Integer.MAX_VALUE;
                int len = 1;
                while((i+len-1) < m && dp[i+len-1][j]>0){
                    maxWidth = dp[i+len-1][j] < maxWidth ? dp[i+len-1][j]: maxWidth;
                    maxArea = maxArea < maxWidth * len ? maxWidth * len : maxArea;
                    len++;
                }
            }
        }
        return maxArea;
    }

    public int maximalRectangles(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n]; // initialize left as the leftmost boundary possible
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
            // update left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // update area
            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }
}
