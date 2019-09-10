package Google.TopFrequency;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        if(S==null) return null;
        StringBuilder str = new StringBuilder();
        int count = K;
        for(int i=S.length()-1;i>=0;i--){
            char ch = S.charAt(i);
            if(ch != '-'){
                if(count == 0){
                    str.append('-');
                    count = K;
                }
                str.append(toUpper(ch));
                count--;
            }
        }

        return str.reverse().toString();
    }

    public char toUpper(char ch){
        if(ch>='a' && ch <= 'z'){
            return (char)(ch + 'A'-'a');
        }
        return ch;
    }
}
