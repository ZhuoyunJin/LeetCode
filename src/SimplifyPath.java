import java.util.ArrayList;
import java.util.List;


public class SimplifyPath {
	public String simplifyPath(String path) {
		String[] arr=path.split("/");
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals("")||arr[i].equals(".")) continue;
			if(arr[i].equals("..")) {
				if(list.size()==0) continue;
				list.remove(list.size()-1);
			}
			else list.add(arr[i]);
		}
		return formPath(list);
	}
	
	public String formPath(List<String> list){
		if(list.size()==0) return "/";
		StringBuilder sb=new StringBuilder();
		for(String s:list){
			sb.append('/');
			sb.append(s);
		}
		return sb.toString();
	}
}
