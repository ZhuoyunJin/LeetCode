package Google;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String retVal = "";
    	if(strs==null||strs.size()==0)
        	return retVal;
        for(String str:strs){
        	retVal+=str.length()+"|"+str;
        }
        return retVal;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> rList = new ArrayList<String>();
        if(s.length()==0) return rList;
        while(s.length()>0){
        	int index=s.indexOf("|");
        	String len = s.substring(0,index);
        	int lenInt = Integer.parseInt(len);
        	String word= s.substring(index+1,index+1+lenInt);
        	rList.add(word);
        	s=s.substring(index+lenInt+1);
        }
        return rList;
    }
}
