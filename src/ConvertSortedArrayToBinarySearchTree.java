import java.util.Arrays;


public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0) return null;
        else if(num.length==1) return new TreeNode(num[0]);
        else if(num.length==2){
        	TreeNode node=new TreeNode(num[0]);
        	node.right=new TreeNode(num[1]);
        	return node;
        }
        int mid=(num.length)/2;
        TreeNode tr=new TreeNode(num[mid]);
        tr.left=sortedArrayToBST(Arrays.copyOfRange(num, 0, mid));
        tr.right=sortedArrayToBST(Arrays.copyOfRange(num, mid+1, num.length));
        return tr;
    }
}
