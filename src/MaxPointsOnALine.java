import java.nio.channels.InterruptibleChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Line{
	double k;
	double a;
	Line(double k,double a){
		this.k=k;
		this.a=a;
	}
	
	@Override
	public int hashCode(){
		return (int)(k*31+a);
	}
	
	@Override
	public boolean equals(Object obj){
		return ((this.k-((Line)obj).k<0.000001) && ((this.a-((Line)obj).a<0.000001)));
	}
}
public class MaxPointsOnALine {
    public int maxPoints2(Point[] points) {
    	if(points.length<=2) return points.length;
        Map<Line, Integer> Map = new HashMap<Line, Integer>();
        List<Point> duplicates = new ArrayList<Point>();
        int max=0;
        for(int i=0;i<points.length-1;i++){
        	for(int j=i+1;j<points.length;j++){
        		Point p1=points[i];
        		Point p2=points[j];
        		if(p1.x==p2.x && p1.y==p2.y){
        			duplicates.add(p1);
        			continue;
        		}
        		double k=(p1.x-p2.x==0)?Integer.MAX_VALUE:(p1.y-p2.y)/(p1.x-p2.x);
        		double a=p1.y-k*p1.x;
        		Line line = new Line(k, a);
        		if(Map.containsKey(line))
        			Map.put(line, Map.get(line)+1);
        		else
        			Map.put(line, 1);
        		max=Map.get(line)>max?Map.get(line):max;
        	}
        }
        for(Line l:Map.keySet()){
        	for(Point duPoint:duplicates){
        		if(l.k*duPoint.x+l.a-duPoint.y<0.000001){
        			Map.put(l, Map.get(l)+1);
        		}
        	}
        }
        for(Line l:Map.keySet()){
        	if(Map.get(l)>max) max=Map.get(l);
        }
        for(int i=2;i<=points.length;i++){
        	if((i*(i-1))==(2*max)) return i;
        }
        return max;	
    }

    public int maxPoints(Point[] points) {
    	if(points.length<=2) return points.length;
    	int max=0;
    	for(int i=0;i<points.length-1;i++){
    		Point p1=points[i];
    		int duplicates=0;
    		Map<Double,Integer> map=new HashMap<Double, Integer>();
    		map.put((double)Integer.MIN_VALUE,1);
    		for(int j=i+1;j<points.length;j++){
    			Point p2=points[j];
    			if(p1.x==p2.x&&p1.y==p2.y){
    				duplicates++;
    				continue;
    			}
    			double k=(p1.x==p2.x)?Integer.MAX_VALUE:(0.0+(double)(p1.y-p2.y)/(p1.x-p2.x));
    			if(map.containsKey(k)){
    				map.put(k, map.get(k)+1);
    			}else{
    				map.put(k, 2);
    			}
    		}
    		System.out.println(map);
    		for(int v:map.values()){
    			if(v+duplicates>max)
    				max=v+duplicates;
    		}
    	}
    	return max;
    }
}
