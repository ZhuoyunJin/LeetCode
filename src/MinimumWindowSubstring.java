
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		int[] toFind = new int[256];
		int[] hasFound = new int[256];
		int lentgh=T.length();
		int count=0, begin=0, end=0;
		int maxbegin=0,maxend=Integer.MAX_VALUE;
		for(int i=0;i<T.length();i++){
			toFind[T.charAt(i)]++;
		}
		for(int i=0;i<S.length();i++){
			char ch=S.charAt(i);
			if(toFind[ch]>0){
				if(hasFound[ch]<toFind[ch]) {
					count++;
					if(count==1) begin=i;
				}
				hasFound[ch]++;
				if(count==lentgh){
					end=i;
					if(end-begin+1==lentgh) return S.substring(begin,end+1);
					else if(end-begin<maxend-maxbegin){
						maxend=end;
						maxbegin=begin;
					}
					for(;begin<end;begin++){
						if(toFind[S.charAt(begin)]!=0) {
							if(count==lentgh-1){
								break;
							}else if(count==lentgh){
								if(end-begin<maxend-maxbegin){
									maxend=end;
									maxbegin=begin;
								}
							}
							hasFound[S.charAt(begin)]-- ;
							if(hasFound[S.charAt(begin)]<toFind[S.charAt(begin)])
								count--;
						}
					}
				}
			}
		}
		if(maxend==Integer.MAX_VALUE) return "";
		return S.substring(maxbegin,maxend+1);
	}

}
