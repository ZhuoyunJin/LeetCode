package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
 * and to take course 0 you should also have finished course 1. So it is impossible.
 *
 */
public class CourseSchedule {
	class Vertex{
		int num;
		List<Integer> edges;
		public Vertex(int n) {
			this.num = n;
			edges = new ArrayList<Integer>();
		}
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
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
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<numCourses;i++){
			if(!dfs(i,visited,stack, courses))
				return false;
		}
		return true;
	}
	
	public boolean dfs(int v, int[] visited, Stack<Integer> stack, Vertex[] courses){
		if(visited[v] == 2) return true;
		if(visited[v] == 1) return false;
		visited[v] = 1;
		Vertex course = courses[v];
		for(int i:course.edges){
			if(!dfs(i, visited, stack, courses))
				return false;
		}
		visited[v] = 2;
		return true;
	}
	public static void main(String[] args) {
		int[][] prerequisites = new int[][]{{1,0},{4,1},{3,1},{3,4},{3,2}};
		CourseSchedule c = new CourseSchedule();
		System.out.println(c.canFinish(5, prerequisites));
	}

}
