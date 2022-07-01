package unsw.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DepthFirstGraphIterator<N extends Comparable<N>> {
    private HashMap<N, List<N>> graph;
    private N firstNode;

    public DepthFirstGraphIterator(HashMap<N, List<N>> graph, N node) {
        this.graph = graph;
        this.firstNode = node;
    }

    public Iterator<N> getListOfdfs() {
        List<N> visited = new ArrayList<N>();
        Stack<N> stack = new Stack<N>();
        stack.push(firstNode);

        while (!stack.isEmpty()) {
            N node = stack.pop();
            visited.add(node);

            // adjList should be sorted in descending order.
            List<N> adjList = getAdjacentNodes(node);
            Collections.sort(adjList, Collections.reverseOrder());
            for (N currentNode: adjList) {
                
                if (!visited.contains(currentNode) && !stack.contains(currentNode)) {
                    // Push the largest one first,
                    // so the smallest one will be on top.
                    stack.push(currentNode);
                }
            } 
        }
        return visited.iterator();
    }

    /**
     * Retrieves all the nodes adjacent to the given node.
     * @precondition node is in the graph
     */
    public List<N> getAdjacentNodes(N node) {
        List<N> adjacencies = new ArrayList<N>(graph.get(node));
        // return Collections.sort(adjacencies, Collections.reverseOrder());
        return adjacencies;
    }


}
