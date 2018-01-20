
public class IntegerToRoman {
    public String intToRoman(int num) {
        char[] arr = {'I','V','X','L','C','D','M'};
        int[] intarr = {1,5,10,50,100,500,1000};
        int len = arr.length;
        StringBuilder res = new StringBuilder();
        for(int i=len-1;i>=0;i=i-2){
        	int number = intarr[i];
        	char letter = arr[i];
        	int multipler = num/number;
        	if(multipler<=3){
        		while(multipler>0){
        			res.append(letter);
        			multipler--;
        		}
        	}else if(multipler==4){
        		res.append(letter);
        		res.append(arr[i+1]);
        	}else if(multipler==5){
        		res.append(arr[i+1]);
        	}else if(multipler<=8){
        		res.append(arr[i+1]);
        		while(multipler>5){
        			res.append(letter);
        			multipler--;
        		}
        	}else if(multipler==9){
        		res.append(letter);
        		res.append(arr[i+2]);
        	}
        	num=num%number;
        }
        return res.toString();
    }
}
