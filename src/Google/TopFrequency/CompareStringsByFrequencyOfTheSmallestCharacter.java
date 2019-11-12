package Google.TopFrequency;

public class CompareStringsByFrequencyOfTheSmallestCharacter {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];
        int[] array = new int[2000];
        int[] wordsFrequency = new int[words.length];
        for(int i=0;i<words.length;i++){
            int frequency = f(words[i]);
            wordsFrequency[i] = frequency;
            array[frequency]++;
        }

        for(int i=array.length-2;i>=0;i--){
            array[i] = array[i]+array[i+1];
        }

        for(int i=0;i<queries.length;i++){
            int frequency = f(queries[i]);
            result[i] = array[frequency+1];
        }
        return result;
    }

    public int f(String s){
        int[] frequency = new int[26];
        for(int i=0;i<s.length();i++){
            frequency[s.charAt(i)-'a']++;
        }
        for(int i=0;i<frequency.length;i++){
            if(frequency[i]>0){
                return frequency[i];
            }
        }
        return 0;
    }

    public static void main(String[] args){
        CompareStringsByFrequencyOfTheSmallestCharacter test = new CompareStringsByFrequencyOfTheSmallestCharacter();
//        int x = test.f("zaaaz");
//        System.out.println(x);

        int[] result = test.numSmallerByFrequency(new String[]{"bbb","cc"},new String[]{"a","aa","aaa","aaaa"});
        for(int i : result) {
            System.out.println(i);
        }

    }
}
