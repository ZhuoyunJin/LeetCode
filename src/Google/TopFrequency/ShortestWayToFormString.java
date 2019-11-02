package Google.TopFrequency;

public class ShortestWayToFormString {

    public int shortestWay2(String source, String target) {
        if (source.equals(target)) return 1;
        int k = source.length();
        int n = target.length();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int base = i;
            int j = 0;
            while (j < k) {
                if (i < n && source.charAt(j) == target.charAt(i)) {
                    i++;
                }
                j++;
            }
            if (i == base) return -1;

            ans++;
        }
        return ans;
    }

    public int shortestWay(String source, String target) {
        int count = 0;
        for(int i=0; i<target.length();i++){
            int farthestIndex = -1;
            for(int j=i;j<i+source.length()&&j< target.length();j++){
                String sub = target.substring(i,j+1);
                if(isSubsequence(source,sub)){
                    farthestIndex = j;
                }else{
                    break;
                }
            }
            if(farthestIndex==-1) {
                return -1;
            } else {
                count++;
                i = farthestIndex;
            }
        }
        return count;
    }

    public boolean isSubsequence(String parent, String child){
        int parentPointer = 0;
        for(int i=0;i<child.length();i++){
            char currentChar = child.charAt(i);
            boolean hasCurrentChar = false;
            for(int j=parentPointer;j<parent.length();j++){
                if(parent.charAt(j)==currentChar){
                    parentPointer = j+1;
                    hasCurrentChar = true;
                    break;
                }
            }
            if(!hasCurrentChar){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ShortestWayToFormString test = new ShortestWayToFormString();
        int count = test.shortestWay("xyz", "xzyxz");
        System.out.println(count);
    }
}
