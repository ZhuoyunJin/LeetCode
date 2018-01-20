package Google;

import java.util.ArrayList;
import java.util.List;
/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic
 */
public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		List<Character> list = new ArrayList<Character>();
		list.add('1');
		list.add('8');
		list.add('0');
		if(num == null)return false;
		else if(num.length() == 0) return true;
		int ptrHead=0, ptrTail=num.length()-1;
		while(ptrHead<=ptrTail){
			char ch1=num.charAt(ptrHead);
			char ch2=num.charAt(ptrTail);
			if(ptrHead==ptrTail){
				if(!list.contains(ch1))
					return false;
			}
			else{ 
				if(ch1==ch2 && list.contains(ch1)){
				}
				else if(ch1=='6' && ch2=='9'){
				}
				else if(ch1=='9' && ch2=='6'){
				}
				else
					return false;
			}
			ptrHead++;
			ptrTail--;
		}
		return true;
	}
	
	public boolean isStrobogrammatic2(String num) {
        int start = 0;
        int end = num.length() - 1;
        while (start <= end) {
            switch(num.charAt(start)) {
                case '0':
                case '1':
                case '8':
                    if (num.charAt(end) != num.charAt(start)) {
                        return false;
                    }
                    break;
                case '6':
                    if (num.charAt(end) != '9') {
                        return false;
                    }
                    break;
                case '9':
                    if (num.charAt(end) != '6') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
