package Google.TopFrequency;

public class StringTransformsIntoAnotherString {
    public boolean canConvert(String str1, String str2) {

        char[] map = new char[26];
        int[] circle = new int[26];
        for(int i=0;i< str1.length();i++){
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            if(map[char1-'a'] != 0 && map[char1-'a'] == char2){
                return false;
            } else {
                map[char1-'a'] = char2;
            }
        }

        int numberOfCircle = 1;
        for(int i=0;i<26;i++){
            circle[i] = numberOfCircle;
            char currentLetter = map[i];
            while(currentLetter > 0 && circle[currentLetter-'a'] == 0){
                circle[currentLetter-'a'] = numberOfCircle;
                currentLetter = map[currentLetter-'a'];
            }
            
        }

    }

    public static void main(String[] args){
        StringTransformsIntoAnotherString test = new StringTransformsIntoAnotherString();
        test.canConvert("aabcc", "ccdee");
    }
}
