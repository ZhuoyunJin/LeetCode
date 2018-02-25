package Booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class GoodWebSite {
	public boolean isGood(int n, int MaxClicks, WebSite homeSite){
		//preparation
		int[] numOfClicks = new int[n];
		Arrays.fill(numOfClicks, Integer.MAX_VALUE);
		
		dfs(numOfClicks, homeSite, 1);
		for(int i:numOfClicks){
			if(i>MaxClicks) return false;
		}
		return true;
	}
	
	public void dfs(int[] array, WebSite page, int i){
		if(page.visited){
			if(array[page.id]> i)
				array[page.id] = i;
		}else{
			array[page.id] = i;
			for(WebSite w: page.neighbors){
				dfs(array, w, i+1);
			}
		}
	}
	
	public static void main(String[] args) {
		WebSite w0 = new WebSite(0);
		WebSite w1 = new WebSite(1);
		WebSite w2 = new WebSite(2);
		WebSite w3 = new WebSite(3);
		WebSite w4 = new WebSite(4);
		WebSite w5 = new WebSite(5);
		WebSite w6 = new WebSite(6);
		w0.neighbors.add(w1);
		w0.neighbors.add(w4);
		w1.neighbors.add(w2);
		w2.neighbors.add(w3);
		w4.neighbors.add(w2);
		w4.neighbors.add(w5);
		w5.neighbors.add(w6);
		GoodWebSite g = new GoodWebSite();
		System.out.println(g.isGood(7, 3, w0));
	}

}