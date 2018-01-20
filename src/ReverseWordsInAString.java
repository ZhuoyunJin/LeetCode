
public class ReverseWordsInAString {
	public String reverseWords(String s) {
		s=s.trim();
		System.out.println(s);
        String[] arr = s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
        	if(arr[i].equals(""))
        		continue;
        	else {
        		if(sb.length()>0)
        			sb.append(" ");
				sb.append(arr[i]);
			}
        }
        return sb.toString();
    }
}
