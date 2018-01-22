package temp;
public class TheElevatorSuperstition {
	static int getLuckyFloorNumber(int n) {
        for(int i=1;i<=n;i++){
            if(containsFour(i) || containsThirteen(i))
                n++;
        }
        return (n);
    }

    static boolean containsFour(int n){
        int lastDigit = 0;
        while(n>0){
            lastDigit = n%10;
            if(lastDigit == 4) return true;
            n=n/10;
        }
        return false;
    }

    static boolean containsThirteen(int n){
        int last2Digit = 0;
        while(n>0){
            last2Digit = n%100;
            if(last2Digit == 13) return true;
            n=n/10;
        }
        return false;
    }
	public static void main(String[] args){
		System.out.println(TheElevatorSuperstition.getLuckyFloorNumber(11));
		//System.out.println(test.containsThirteen(13));
	}
}
