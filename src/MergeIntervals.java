import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals==null||intervals.size()<=1) return intervals;
		Comparator<Interval> comp = new Comparator<Interval>(){  
			@Override  
			public int compare(Interval i1, Interval i2)  
			{  
				if(i1.start==i2.start)  
					return i1.end-i2.end;  
				return i1.start-i2.start;  
			}  
		}; 
		Collections.sort(intervals,comp);
		List<Interval> result = new ArrayList<Interval>();
		Interval current = intervals.get(0);
		for(int i=1;i<intervals.size();i++){
			Interval next = intervals.get(i);
			if(current.end<next.start) {
				result.add(current);
				current=next;
			}else if(current.end>=next.start){
				current=new Interval(current.start,Math.max(next.end,current.end));
			}
		}
		result.add(current);
		return result;
	}

}
