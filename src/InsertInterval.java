import java.util.ArrayList;
import java.util.List;


public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		if(intervals==null||intervals.size()==0) {
			res.add(newInterval);
			return res;
		}
		for(int i=0;i<intervals.size();i++){
			Interval interval = intervals.get(i);
			if(interval.end<newInterval.start) {
				res.add(interval);
				if(i==intervals.size()-1){
					res.add(newInterval);
					return res;
				}
			}
			else if(newInterval.end<interval.start){
				res.add(newInterval);
				for(int j=i;j<intervals.size();j++){
					res.add(intervals.get(j));
				}
				return res;
			}
			else if(interval.end>=newInterval.start||interval.start<=newInterval.end){
				newInterval=new Interval(Math.min(interval.start, newInterval.start),Math.max(interval.end, newInterval.end));
				if(i==intervals.size()-1) {
					res.add(newInterval);
					return res;
				}
			}
		}

		return res;
	}
}
