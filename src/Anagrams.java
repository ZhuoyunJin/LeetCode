import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.Templates;


public class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> res = new ArrayList<String>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(String str:strs){
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String sorted = new String(arr);
			if(map.containsKey(sorted))
				map.get(sorted).add(str);
			else{
				List<String> temp = new ArrayList<String>();
				temp.add(str);
				map.put(sorted, temp);
			}
		}
		for(List<String> ls:map.values()){
			if(ls.size()<2) continue;
			else 
				res.addAll(ls);
		}
		return res;  
	}

}
