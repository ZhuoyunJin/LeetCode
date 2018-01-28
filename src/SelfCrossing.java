import java.util.*;


public class SelfCrossing {
	class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x=x;
			this.y=y;
		}

		public int hashCode(){
			int hashcode = 0;
			hashcode = x*13 + y*9;
			return hashcode;
		}
		@Override
		public boolean equals(Object obj){
			return (((Point)obj).x == this.x && ((Point)obj).y == this.y);
		}
	}
	public boolean isSelfCrossing(int[] moves) {
		if(moves==null || moves.length < 4) return false;
		Point p0 = new Point(0,0);
		Set<Point> set = new HashSet<Point>();
		set.add(p0);
		int len = moves.length;
		int i=-1;
		int x=0, y=0;
		while(++i<len){
			//right
			int steps = moves[i];
			for(int j=0;j<steps;j++){
				x++;
				if(!set.add(new Point(x, y))) return true;
			}
			
			//down
			if(++i<len){
				steps = moves[i];
				for(int j=0;j<steps;j++){
					y--;
					if(!set.add(new Point(x, y))) return true;
				}
			}
			
			//left
			if(++i<len){
				steps = moves[i];
				for(int j=0;j<steps;j++){
					x--;
					if(!set.add(new Point(x, y))) return true;
				}
			}
			//down
			if(++i<len){
				steps = moves[i];
				for(int j=0;j<steps;j++){
					y++;
					if(!set.add(new Point(x, y))) return true;
				}
			}
		}

		return false;
	}
	public static void main(String[] args) {
		SelfCrossing s = new SelfCrossing();
		System.out.println(s.isSelfCrossing(new int[]{1,2,2,3,4,2,3}));
	}

}
