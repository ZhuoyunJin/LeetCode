package Google;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1 == null || words2 == null || words1.length != words2.length){
            return false;
        }

        Set<String> dict = new HashSet<String>();
        for(List<String> pair : pairs){
            String key = pair.get(0) + "|" + pair.get(1);
            dict.add(key);
        }

        for(int i=0; i< words1.length; i++){
            String word1 = words1[i];
            String word2 = words2[i];
            if(word1.equals(word2) ||
                    dict.contains(word1 + "|" + word2) ||
                    dict.contains(word2 + "|" + word1)){
                continue;
            }
            return false;
        }

        return true;
    }
}
