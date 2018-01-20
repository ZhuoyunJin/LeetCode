import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}
//{0,1,5#1,2,5#2,3#3,4,4#4,5,5#5}
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null) return null;
		Map<Integer,UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		UndirectedGraphNode result = new UndirectedGraphNode(node.label);
		queue.add(node);
		map.put(node.label,result);
		while(!queue.isEmpty()){
			UndirectedGraphNode n=queue.poll();
			for(UndirectedGraphNode neighbor:n.neighbors){
				if(!map.containsKey(neighbor.label)){
					UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
					map.put(newNode.label, newNode);
					queue.add(neighbor);
				}
				map.get(n.label).neighbors.add(map.get(neighbor.label));
			}
		}
		return result;
	}
}
