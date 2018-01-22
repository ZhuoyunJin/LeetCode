package temp;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.*;

public class CloneGraph {
	//	OJ's undirected graph serialization:
	//	Nodes are labeled uniquely.
	//
	//	We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
	//	As an example, consider the serialized graph {0,1,2#1,2#2,2}.
	//
	//	The graph has a total of three nodes, and therefore contains three parts as separated by #.
	//
	//	First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
	//	Second node is labeled as 1. Connect node 1 to node 2.
	//	Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node);
		UndirectedGraphNode originalNode, newNode;
		while (!queue.isEmpty()) {
			originalNode = queue.poll();
			newNode = new UndirectedGraphNode(originalNode.label);
			map.put(newNode.label, newNode);
			for(UndirectedGraphNode n:originalNode.neighbors){
				if(map.containsKey(n.label)){
					newNode.neighbors.add(map.get(n.label));
				}else{
					newNode.neighbors.add(new UndirectedGraphNode(n.label));
					queue.add(n);
				}
			}
		}
		return map.get(node.label);
	}

	public static void main(String[] args) {
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		node0.neighbors.add(node0);
		node0.neighbors.add(node1);
		node1.neighbors.add(node2);
		node2.neighbors.add(node2);
	}

}
