package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueWordAbbreviation {
	Map<String, List<String>> map = new HashMap<String, List<String>>();
	public UniqueWordAbbreviation(String[] dictionary) {
		for(String str: dictionary){
			String abbr= getAbbreviation(str);
			if(!map.containsKey(abbr))
				map.put(abbr, new ArrayList<String>());
			map.get(abbr).add(str);
		}
	}

	public boolean isUnique(String word) {
		String abbr = getAbbreviation(word);
		if(!map.containsKey(abbr))
			return true;
		else{
			return (map.get(abbr).size()==1 && map.get(abbr).contains(word));
		}
			
	}
	
	public String getAbbreviation(String str){
		if(str.length()<=2)
			return str;
		else{
			String middleLen=""+(str.length()-2);
			String abr=str.charAt(0)+middleLen+str.charAt(str.length()-1);
			return abr;
		}
	}
	
}
