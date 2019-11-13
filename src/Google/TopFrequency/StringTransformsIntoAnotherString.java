package Google.TopFrequency;

import java.util.*;

public class StringTransformsIntoAnotherString {
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i=0;i< str1.length();i++){
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            if(map.containsKey(char1) && map.get(char1) != char2){
                return false;
            } else if(!map.containsKey(char1)){
                map.put(char1, char2);
                set.add(char2);
            }
        }
        return set.size()<26;


    }


    public static void main(String[] args){
        StringTransformsIntoAnotherString test = new StringTransformsIntoAnotherString();
        boolean canConvert = test.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyzq");
        System.out.println(canConvert);
    }
}
