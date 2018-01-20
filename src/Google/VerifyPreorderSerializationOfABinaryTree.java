package Google;
/**
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * "9,3,4,#,#,1,#,#,2,#,6,#,#" -> true
 * "9,#,#,1,#,#" -> false
 */
public class VerifyPreorderSerializationOfABinaryTree {
	public boolean isValidSerialization(String preorder) {
		String replacedString= "";
		while(true){
			replacedString=preorder.replaceAll("[0-9]+,#,#", "#");
			if(replacedString.equals(preorder)) return replacedString.equals("#");
			preorder=replacedString;
		}
	}
	
	public boolean isValidSerialization2(String preorder) {
		if(preorder.charAt(0)=='#') return preorder.length()==1;
		if(preorder.length()<3) return false;
        String[] strings = preorder.split(",");
        int counter = 2;
        for(int i=1;i<strings.length;i++){
        	if(strings[i].equals("#")) counter--;
        	else counter++;
        	if(counter<0 || (counter==0 && i!=strings.length-1)) return false;
        }
        return counter==0;
    }
}
