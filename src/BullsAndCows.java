
public class BullsAndCows {
	public String getHint(String secret, String guess) {
        if(secret == null || secret.length() == 0) return "0A0B";
        int[] secretArray = new int[10];
        int[] guessArray = new int[10];
        int bulls=0, cows=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }else{
                secretArray[secret.charAt(i)-'0']++;
                guessArray[guess.charAt(i)-'0']++;
            }    
        }
        for(int i=0;i<10;i++){
        	cows += Math.min(guessArray[i], secretArray[i]);
        }
        return bulls+"A"+cows+"B";
    }
}
