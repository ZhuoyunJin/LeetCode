package String;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		if(version1.equals(version2))
			return 0;
		String[] a=version1.split(".");
		String[] b=version2.split(".");
		
		return 1;
	}
	
	public static void main(String[] args){
		String[] aStrings ="1".split("\\.");
		System.out.println(aStrings[0]);
	}
}
