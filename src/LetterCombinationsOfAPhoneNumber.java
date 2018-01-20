import java.util.ArrayList;
import java.util.List;


public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		String[] strArr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		String empty ="";
		List<String> list = new ArrayList<String>();
		list.add(empty);
		for(int i=0;i<digits.length();i++){
			String letter = strArr[digits.charAt(i)-'0'];
			List<String> tempList =new ArrayList<String>();
			for(int j=0;j<letter.length();j++){
				for(String s:list){
					tempList.add(s+letter.charAt(j));
				}
			}
			list=tempList;
		}
		return list;
	}
}
