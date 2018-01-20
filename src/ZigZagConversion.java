
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		int len = s.length();
		if(len<=1||nRows==1) return s;
		StringBuilder sb=new StringBuilder();
		for(int i= 0;i<nRows;i++){
			int j=i;
			while(j<len){
				sb.append(s.charAt(j));
				if(!(i==0 || i==nRows-1)){
					int temp = j+2*(nRows-i-1);
					if(temp<len)
						sb.append(s.charAt(temp));
				}
				j=j+2*(nRows-1);
			}
		}
        return sb.toString();
    }
}
