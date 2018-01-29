package String;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		int len1=word1.length(),len2=word2.length();
		if(len1==0) return len2;
		if(len2==0) return len1;
		int[][] arr=new int[len1+1][len2+1];
		for(int i=0;i<=len2;i++){
			arr[0][i]=i;
		}
		for(int i=0;i<=len1;i++){
			arr[i][0]=i;
		}
		for(int i=1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				char ch1=word1.charAt(i-1), ch2=word2.charAt(j-1);
				if(ch1==ch2)
					arr[i][j]=arr[i-1][j-1];
				else
					arr[i][j]=Math.min(arr[i-1][j-1]+1, Math.min(arr[i][j-1]+1, arr[i-1][j]+1));
			}
		}
		return arr[len1][len2];
	}
}
