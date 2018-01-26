import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class FindAnagramMappings {
	/**
	 * A = [12, 28, 46, 32, 50]
	 * B = [50, 12, 32, 46, 28]
	 * We should return [1, 4, 3, 2, 0]
	 * as P[0] = 1 because the 0th element of A appears at B[1], 
	 * and P[1] = 4 because the 1st element of A appears at B[4], 
	 * and so on.
	 */
	public int[] anagramMappings(int[] A, int[] B) {
		int[] result = new int[A.length];
		Map<Integer, Stack<Integer>> map = new HashMap<Integer, Stack<Integer>> ();
		for(int i=0;i<B.length;i++){
			int current = B[i];
			if(map.containsKey(current))
				map.get(current).add(i);
			else {
				Stack<Integer> stack = new Stack<Integer>();
				stack.add(i);
				map.put(current, stack);
			}
		}
		
		for(int i=0;i<A.length;i++){
			result[i] = map.get(A[i]).pop();
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
