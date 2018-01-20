
public class CountAndSay {
    public String countAndSay(int n) {
        if(n==1) return "1";
        if(n<1) return "";
        String prev=countAndSay(n-1);
        String resultString="";
        for(int i=0;i<prev.length();i++){
        	int counter=1;
        	char ch=prev.charAt(i);
        	while(i<prev.length()-1 && ch==prev.charAt(i+1)){
        		counter++;
        		i++;
        	}
        	resultString+=""+counter+ch;
        }
        return resultString;
    }
}
