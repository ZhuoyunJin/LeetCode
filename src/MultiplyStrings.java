import java.util.ArrayList;
import java.util.List;


public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if(num1.equals("0")||num2.equals("0")) return "0";
		List<String> list = new ArrayList<String>();
		for(int i=num2.length()-1;i>=0;i--){
			list.add(oneMulti(num1, num2.charAt(i)));
		}
		String res="";
		int index=0;
		for(String str:list){
			res=add(res,str,index);
			index++;
		}
		
		return reverse(res);
	}
	public String oneMulti(String str, char ch){
		int carry=0;
		StringBuilder sb=new StringBuilder();
		for(int i=str.length()-1;i>=0;i--){
			int single=ch-'0';
			int current = str.charAt(i)-'0';
			int res=single*current+carry;
			sb.append(res%10);
			carry=res/10;
		}
		if(carry>0) sb.append(carry);
		return sb.toString();
	}

	public String add(String res, String str, int index){
		StringBuilder sb = new StringBuilder();
		int carry=0;
		int digit=0;
		for(int i=0; i<res.length();i++){
			if(i<index) {
				sb.append(res.charAt(i)-'0'+carry);
			}
			else{
				int num1=res.charAt(i)-'0';
				int num2=0;
				if(digit<str.length())
					num2=str.charAt(digit)-'0';
				int sum=num1+num2+carry;
				sb.append(sum%10);
				carry=sum/10;
				digit++;
			}
		}
		if(digit<str.length()&&digit>=0){
			while(digit<str.length()){
				int num=str.charAt(digit)-'0';
				int sum = num+carry;
				sb.append(sum%10);
				carry=sum/10;
				digit++;
			}
		}
		if(carry>0){
			sb.append(carry);
		}
		return sb.toString();
	}

	public String reverse(String str){
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1;i>=0;i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	/*
	public String multiply(String num1, String num2) {  
        String n1 = new StringBuilder(num1).reverse().toString();  
        String n2 = new StringBuilder(num2).reverse().toString();  
          
        int[] d = new int[n1.length()+n2.length()]; 
        for(int i=0; i<n1.length(); i++){  
            for(int j=0; j<n2.length(); j++){  
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');  
            }  
        }  
          
        StringBuilder sb = new StringBuilder();  
        for(int i=0; i<d.length; i++){  
            int digit = d[i]%10;    
            int carry = d[i]/10;      
            if(i+1<d.length){  
                d[i+1] += carry;  
            }  
            sb.insert(0, digit);         
        }  
          
        while(sb.charAt(0)=='0' && sb.length()>1){  
            sb.deleteCharAt(0);  
        }  
        return sb.toString();  
    } 
    */
}
