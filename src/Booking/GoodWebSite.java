package Booking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GoodWebSite {
	class WebSite{
		int id;
		List<WebSite> neighbors;
		boolean visited;

		public WebSite(int id){
			this.id = id;
			this.neighbors = new ArrayList<WebSite>();
			this.visited = false;
		}
	}
	
	public boolean isGood(int n, int MaxClicks, WebSite homeSite){
		//preparation
		int[] numOfClicks = new int[n];
		for(int i=0;i<n;i++){
			numOfClicks[i] = Integer.MAX_VALUE;
		}
		
		//actual job
		int currentClick = 0;
		Queue<WebSite> queue = new LinkedList<WebSite>();
		
		
		//conclusion
		for(int i=0;i<n;i++){
			if(numOfClicks[i] > MaxClicks)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		

	}

}
