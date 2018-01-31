
public class TeemoAttacking {
	
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int count=0;
		for(int i=0;i<timeSeries.length;i++){
			if(i==timeSeries.length-1) {
				count+=duration;
				break;
			}
			int current = timeSeries[i];
			int next = timeSeries[i+1];
			if(duration>(next-current))
				count += (next-current);
			else
				count += duration;
		}
		return count;
	}
	
	public static void main(String[] args) {
		TeemoAttacking t = new TeemoAttacking();
		System.out.println(t.findPoisonedDuration(new int[]{1, 4}, 2));
	}

}
