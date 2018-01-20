
public class AddBinary {
	public String addBinary(String a, String b) {
		if(a.length()==0) return b;
		if(b.length()==0) return a;
		int ptra=0,ptrb=0;
		int len=Math.min(a.length(), b.length());
		int index=0;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<len;i++){
			switch (a.charAt(a.length()-1-i)-'0'+b.charAt(b.length()-1-i)-'0'+index){
			case 3:index=1;
			sb.append("1");
			break;
			case 2:index=1;
			sb.append("0");
			break;
			case 1:index=0;
			sb.append("1");
			break;
			case 0:index=0;
			sb.append("0");
			break;
			}
		}
		if(a.length()>len){
			for(int i=len;i<a.length();i++)
			{	
				if(index==0){
					sb.append(a.charAt(a.length()-1-i));
				}else{
					if(a.charAt(a.length()-1-i)=='0'){
						sb.append(1);
						index=0;
					}else{
						sb.append(0);
						index=1;
					}
				}
			}
		}else if(b.length()>len){
			for(int i=len;i<b.length();i++){
				if(index==0){
					sb.append(b.charAt(b.length()-1-i));
				}else{
					if(b.charAt(b.length()-1-i)=='0'){
						sb.append(1);
						index=0;
					}else{
						sb.append(0);
						index=1;
					}
				}
			}
				
		}
		if(index==1) sb.append(1);
		return sb.reverse().toString();
	}
}
