package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
	class Vertex{
		int num;
		List<Integer> edges;
		public Vertex(int n) {
			this.num = n;
			edges = new ArrayList<Integer>();
		}
	}

	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Vertex[] courses = new Vertex[numCourses];
		for(int i=0;i<numCourses;i++){
			courses[i] = new Vertex(i);
		}
		for(int i=0;i<prerequisites.length;i++){
			int postCourse = prerequisites[i][0];
			int preCourse = prerequisites[i][1];
			courses[preCourse].edges.add(postCourse);
		}
		
		//0 not visited; 1 visiting; 2 visited
		int[] visited = new int[numCourses];
		List<Integer> order = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<numCourses;i++){
			if(!dfs(i,visited,stack, courses, order))
				return new int[0];
		}
		int[] result = new int[numCourses];
		int i=numCourses-1;
		for(int courseNumber: order){
			result[i] = courseNumber;
			i--;
		}
		return result;
	}
	
	public boolean dfs(int v, int[] visited, Stack<Integer> stack, Vertex[] courses, List<Integer> order){
		if(visited[v] == 2) return true;
		if(visited[v] == 1) return false;
		visited[v] = 1;
		Vertex course = courses[v];
		for(int i:course.edges){
			if(!dfs(i, visited, stack, courses, order))
				return false;
		}
		visited[v] = 2;
		order.add(v);
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
