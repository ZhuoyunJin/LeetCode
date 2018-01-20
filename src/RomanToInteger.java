import java.util.HashMap;


public class RomanToInteger {
    public int romanToInt(String s) {
        int[] num = {1,5,10,50,100,500,1000};
        char[] rome = {'I','V','X','L','C','D','M'};
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<num.length;i++){
        	map.put(rome[i],num[i]);
        }
        int result=0;
        for(int i=0;i<s.length();i++){
        	if(i+1<s.length()&& map.get(s.charAt(i))<map.get(s.charAt(i+1))){
        		result=result+map.get(s.charAt(i+1))-map.get(s.charAt(i));
        		i++;
        		continue;
        	}
        	else{
        		result=result+map.get(s.charAt(i));
        	}
        }
        return result;
    }
}
