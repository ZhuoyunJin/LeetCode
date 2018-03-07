package Array;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
		int current = Integer.MAX_VALUE;
		int rows=matrix.length, columns = matrix[0].length;
		//int nthLargest =(rows*columns-k) +1;
		for(int i=0;i<columns; i++) {
			if(matrix[i][0] > current) break;
			for(int j=0;j<rows; j++) {
				if(matrix[i][j] > current) continue;
				queue.offer(matrix[i][j]);
				if(queue.size() > k) {
					queue.poll();
					current = queue.peek();
				}
			}
		}
		return queue.peek();
	}
	
	public int kthSmallest2(int[][] matrix, int k) {
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1];
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += j + 1;
            }
            if(count < k){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
