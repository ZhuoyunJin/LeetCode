package Practice;

public class AlphabetSoup {

	//The worst case takes O(n+m) time complexity.
	//While the best case takes O(n) time complexity.
	public boolean canWriteMessage(String message, String letters) {
		if(message == null || letters == null) return false;
		
		//build a dictionary to count how many times each letter occurs in the message.
		//I assume the it's is case insensitive. So it needs only an array of length 26.
		//count is the number of instinct letters.
		int[] dict = new int[26];
		int count = 0;
		for(int i = 0;i < message.length()-1;i++) {
			char current = Character.toLowerCase(message.charAt(i));
			if(current > 'z' || current < 'a') continue;
			if(dict[current-'a']==0) {
				count++;
			}
			dict[current-'a']++;
		}
		
		//Do a iteration. Deduct 1 every time the letter in soup bowl matches the letter in the message.
		//When count comes to 0, it means all letters in the message appeared in the soup bowl.
		for(int i = 0;i < letters.length()-1;i++) {
			char current = Character.toLowerCase(letters.charAt(i));
			if(current>'z' || current<'a') continue;
			dict[current-'a']--;
			if(dict[current-'a']==0) {
				count--;
			}
			if(count == 0) 
				return true;
		}
		return false;
	}
	

}
