package Array;

import java.util.ArrayList;
import java.util.List;
public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if(numRows<=0) return resultList;
		int[] prevArray=new int[]{}, tempArray;
		for(int i=0;i<numRows;i++){
			tempArray = new int[i+1];
			tempArray[0] = 1;
			tempArray[i] = 1;
			if(i>1){
				for(int j=1;j<=i/2;j++){
					tempArray[j]=prevArray[j]+prevArray[j-1];
					tempArray[i-j]=tempArray[j];
				}
			}
			//add to result list
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			for(int k:tempArray){
				tempList.add(k);
			}
			resultList.add(tempList);
			prevArray = tempArray;
		}
		return resultList;
	}
	
	public static void main(String[] args){
		PascalsTriangle triangle=new PascalsTriangle();
		System.out.println(triangle.generate(5));
	}
}
