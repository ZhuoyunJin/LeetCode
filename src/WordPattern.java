import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if(arr.length != pattern.length()) return false;

        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();
        for(int i=0; i<pattern.length();i++){
            char current = pattern.charAt(i);
            if(patternToWord.containsKey(current) && !patternToWord.get(current).equals(arr[i])){
                return false;
            } else if(wordToPattern.containsKey(arr[i]) && !wordToPattern.get(arr[i]).equals(current)){
                return false;
            }
            else{
                patternToWord.put(current, arr[i]);
                wordToPattern.put(arr[i], current);
            }
        }

        return true;
    }
}
