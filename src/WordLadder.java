import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> availableWords = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str:wordList){
            availableWords.add(str);
            for(int i=0;i<str.length();i++){
                String pattern = str.substring(0, i) + "*" + str.substring(i+1, str.length());
                if(map.containsKey(pattern)){
                    map.get(pattern).add(str);
                }else {
                    List<String> listOfWords = new ArrayList<>();
                    listOfWords.add(str);
                    map.put(pattern, listOfWords);
                }
            }
        }
        int result = recursion(beginWord, endWord, availableWords, map);
        return result == Integer.MAX_VALUE?0 : result;

    }

    public int recursion(String beginWord, String endWord, Set<String> availableWords, Map<String, List<String>> map){

        availableWords.remove(beginWord);
        int result = Integer.MAX_VALUE;
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<beginWord.length();i++){
            String pattern = beginWord.substring(0, i) + "*" + beginWord.substring(i+1, beginWord.length());
            List<String> listOfWords = map.get(pattern);
            if(listOfWords == null) continue;
            for(String str:listOfWords){
                if(!availableWords.contains(str)) continue;
                if(str.equals(endWord)){
                    return 2;
                }
                queue.add(str);
            }
        }
        for(String str: queue){
            int tempResult = recursion(str, endWord, availableWords, map);
            if(tempResult<result){
                result = tempResult+1;
            }
        }
        availableWords.add(beginWord);
        return result;
    }

    public int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {

        Set<String> availableWords = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str:wordList){
            availableWords.add(str);
            for(int i=0;i<str.length();i++){
                String pattern = str.substring(0, i) + "*" + str.substring(i+1, str.length());
                if(map.containsKey(pattern)){
                    map.get(pattern).add(str);
                }else {
                    List<String> listOfWords = new ArrayList<>();
                    listOfWords.add(str);
                    map.put(pattern, listOfWords);
                }
            }
        }

        int result = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        queue.add(null);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            if(currentWord == null){
                if(queue.isEmpty()) return 0;
                queue.add(null);
                result++;
                continue;
            }
            for (int i = 0; i < currentWord.length(); i++) {

                String newWord = currentWord.substring(0, i) + '*' + currentWord.substring(i + 1, currentWord.length());

                for (String adjacentWord : map.getOrDefault(newWord, new ArrayList<String>())) {
                    if(visited.contains(adjacentWord)) continue;
                    if (adjacentWord.equals(endWord)) {
                        return result + 1;
                    }
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        queue.add(adjacentWord);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args){
        WordLadder test = new WordLadder();
        int x = test.ladderLengthBFS("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(x);
    }
}
