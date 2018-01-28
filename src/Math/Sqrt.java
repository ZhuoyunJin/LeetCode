package Math;

public class Sqrt {
	public int sqrt(int x) {
		return sqrt(x,1,x);
	}
	
	public int sqrt(int x, long left, long right){
		if(right==left||left==right-1) return (int)left;
		long mid=(left+right)/2;
		long square = mid*mid;
		if(square>x) return sqrt(x, left, mid);
		else if(square==x) return (int)mid;
		else return sqrt(x,mid,right);
	}
}
