import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		if(L.length==0 || S.length()==0) return null;
		int len=L[0].length();
		int quan = L.length;
		List<Integer> list = new ArrayList<Integer>();
		if(S.length()<quan*len) return list;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String s:L){
			if(map.containsKey(s)) map.put(s, map.get(s)+1);
			else {
				map.put(s, 1);
			}
		}
		for(int loop=0;loop<len;loop++){
			int count=0;
			HashMap<String, Integer> mapCopy = new HashMap<String, Integer>();
			for(int i=loop;i<S.length()-len+1;i=i+len){
				String str = S.substring(i, i+len);
				if(!map.containsKey(str)) {
					count=0;
					mapCopy = new HashMap<String, Integer>();
					continue;
				}else{
					if(!mapCopy.containsKey(str)) {
						mapCopy.put(str, 1);
						count++;
					}
					else {
						if(mapCopy.get(str)<map.get(str)){
							mapCopy.put(str, mapCopy.get(str)+1);
							count++;
						}
						else {
							mapCopy=new HashMap<String, Integer>();
							i=i-count*len;
							count=0;
							continue;
						}
					}
					if(count==quan){
						int start=i-(quan-1)*len;
						list.add(start);
						count--;
						mapCopy.put(S.substring(start,start+len),mapCopy.get(S.substring(start,start+len))-1);
					}
					else{
					}
				}
			}
		}
		return list;
	}
}
