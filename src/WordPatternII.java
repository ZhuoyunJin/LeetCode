import java.util.*;

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        return helper(
                pattern,
                str,
                new HashMap<Character, String>(),
                new HashSet<String>(),
                0,
                0
        );
    }

    private boolean helper(
            String pattern,
            String str,
            Map<Character, String> patternToString,
            Set<String> seen,
            int pPos,
            int sPos
    ) {
        if (pPos == pattern.length()) {
            return sPos == str.length();
        }

        char p = pattern.charAt(pPos);
        if (patternToString.containsKey(p)) {
            String s = patternToString.get(p);
            if (sPos + s.length() <= str.length() &&
                            str.substring(sPos, sPos + s.length()).equals(s)) {
                return helper(pattern, str, patternToString, seen, pPos + 1, sPos + s.length());
            } else {
                return false;
            }
        } else {
            for (int i = sPos; i < str.length(); i++) {
                String s = str.substring(sPos, i + 1);
                if (seen.contains(s)) {
                    continue;
                }

                patternToString.put(p, s);
                seen.add(s);
                if (helper(pattern, str, patternToString, seen, pPos + 1, i + 1)) {
                    return true;
                }
                seen.remove(s);
                patternToString.remove(p);
            }
        }

        return false;
    }

    public static void main(String[] args){
        WordPatternII test = new WordPatternII();
        test.wordPatternMatch("aabb", "xyzabcxzyabc");
    }
}
