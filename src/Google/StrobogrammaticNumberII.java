package Google;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 * For example, Given n = 2, return ["11","69","88","96"].
 * Hint: Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 */
public class StrobogrammaticNumberII {
	//1,8,0
	//11,88,00,69,96
	public List<String> findStrobogrammatic(int n) {
		List<String> list = new ArrayList<String>();
		list = helper(n, n);
		return list;
	}

	public List<String> helper(int n, int length){
		if(n==0){
			List<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}else if(n==1) {
			List<String> list = new ArrayList<String>();
			list.add("1");
			list.add("8");
			list.add("0");
			return list;
		}else{
			List<String> retlist = helper(n-2, length);
			List<String> newlist = new ArrayList<String>();
			for(String s: retlist){
				newlist.add("1"+s+"1");
				newlist.add("8"+s+"8");
				newlist.add("6"+s+"9");
				newlist.add("9"+s+"6");
				if(length!=n)
					newlist.add("0"+s+"0");
			}
			return newlist;
		}
	}
}
