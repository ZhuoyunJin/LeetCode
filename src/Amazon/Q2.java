package Amazon;

import java.util.*;

public class Q2 {
	static int[] getMinimumDifference(String[] a, String[] b) {
        // Base case
        if (a == null || b == null) {
            return new int[]{-1};
        }

        Map<Character, Integer> map = new HashMap<>();
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            // Check if the two a[i].length() != b[i].length()
            if(a[i].length() != b[i].length()) {
                result[i] = -1;
            } else {
                // Reset the set to an empty map
                map.clear();
                // Insert all the chars from a[i] into map
                for (Character c : a[i].toCharArray()) {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c)+1);
                    } else {
                        map.put(c, 1);
                    }
                }
                // Remove all the chars that both a and b have
                for (Character c : b[i].toCharArray()) {
                    if (map.containsKey(c)) {
                        int count = map.get(c);
                        if (count == 1) {
                            map.remove(c);
                        } else{
                            map.put(c, count-1);
                        }
                    }
                }
                int sum = 0;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    sum += entry.getValue();
                }
                result[i] = sum;
            }
        }
        return result;
    }
	public static void main(String[] args) {
		Q2 test = new Q2();
	}

}
