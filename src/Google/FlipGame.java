package Google;
import java.util.ArrayList;
/**
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
Write a function to compute all possible states of the string after one valid move.
For example, given s = "++++", after one move, it may become one of the following states:
[
  "--++",
  "+--+",
  "++--"
]
 */
import java.util.List;
public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> list = new ArrayList<String>();
		if(s.length()<2) return list;
		for(int i=0;i<=s.length()-2;i++){
			if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
				list.add(s.substring(0,i)+"--"+(i+2<s.length()?s.substring(i+2,s.length()):""));
			}
		}
		return list;
	}
}
