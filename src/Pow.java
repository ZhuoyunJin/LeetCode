
public class Pow {
    public double pow(double x, int n) {
        if(n>=0) return helper(x,n);
        else return 1.0/helper(x, -n);
    }
    
    public double helper(double x, int n) {
    	if(n==0) return 1;
    	double temp = helper(x, n/2);
    	if(n%2==0)
    		return temp*temp;
    	else
    		return temp*temp*x;
    }
}
