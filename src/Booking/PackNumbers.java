package Booking;

import java.util.ArrayList;
import java.util.List;

public class PackNumbers {
	public static String[] packNumbers(int[] arr) {
		List<String> list = new ArrayList<String>();
		int len = arr.length;
		int counter=0;
		for(int i=0;i<len;i++){
			if(counter==0) counter++;
			else{
				if(arr[i]==arr[i-1])
					counter++;
				else {
					list.add((counter==1?""+arr[i-1]:arr[i-1]+":"+counter));
					counter=1;
				}
			}
		}
		if(counter>0)
			list.add((counter==1?""+arr[len-1]:arr[len-1]+":"+counter));
		String[] result = new String[list.size()];
		int i=0;
		for(String str: list)
		{
			result[i]=str;
			i++;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{1,1,1,1,2};
		String[] re = PackNumbers.packNumbers(arr);
		for(int i=0;i<re.length;i++){
			System.out.println(re[i]);
		}
	}

}
