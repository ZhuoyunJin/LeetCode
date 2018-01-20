import java.util.ArrayList;
import java.util.List;


public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		List<String> res=new ArrayList<String>();
		if(words==null||words.length==0) return res;
		List<String> temp=new ArrayList<String>();
		int currentLen=0;
		for(int i=0;i<words.length;i++){
			String w=words[i];
			if(currentLen+w.length()>=L){
				if(temp.size()==0||currentLen+w.length()==L)
				{
					currentLen=currentLen+w.length()+1;
					temp.add(w);
					continue;
				}
				packing(res,temp,L,currentLen);
				temp.clear();
				currentLen=0;
			}
			currentLen=currentLen+w.length()+1;
			temp.add(w);
		}
		if(temp.size()!=0) {
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<temp.size();i++){
				sb.append(temp.get(i));
				if(i!=temp.size()-1) sb.append(' ');
			}
			sb.append(spaceGenerator(L-sb.length()));
			res.add(sb.toString());
		}
        return res;
    }
	
	public void packing(List<String> res,List<String> temp, int L,int currentLen){
		int size=temp.size();
		currentLen=currentLen-size;
		StringBuilder sb=new StringBuilder();
		if(size==1){
			sb.append(temp.get(0));
			sb.append(spaceGenerator(L-currentLen));
		}else{
			int extraspace=(L-currentLen)%(size-1);
			int space=(L-currentLen)/(size-1);
			int i=0;
			for(String s:temp){
				sb.append(s);
				if(i==size-1) break;
				sb.append(spaceGenerator(space));
				if(i<extraspace){
					sb.append(' ');
				}
				i++;
			}
		}
		res.add(sb.toString());
	}
	
	public String spaceGenerator(int n){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(' ');
		}
		return sb.toString();
	}
}
