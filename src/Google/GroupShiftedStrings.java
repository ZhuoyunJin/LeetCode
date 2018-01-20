package Google;
import java.util.*;
/**
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.
 */
public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		for(String str:strings){
			if(result.size()==0) {
				List<String> list = new ArrayList<String>();
				list.add(str);
				result.add(list);
			}
			else{
				boolean flag=false;
				for(List<String> list:result){
					if(canShift(str, list.get(0)))
					{
						list.add(str);
						Collections.sort(list);
						flag=true;
						break;
					}
				}
				if(!flag){
					List<String> list = new ArrayList<String>();
					list.add(str);
					result.add(list);
				}
			}
		}
		return result;
	}
	
	public boolean canShift(String str1, String str2){
		if(str1==null || str2 == null ) return false;
		if(str1.length()!=str2.length()) return false;
		int difference = 0;
		for(int i=0;i<str1.length();i++)
		{
			int temp=str1.charAt(i)-str2.charAt(i);
			if(temp<0) temp+=26;
			if(i==0) difference = temp;
			if(temp!=difference) return false;
		}
		return true;
	}
}
