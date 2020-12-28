package comprehensive;

import java.util.HashMap;

/**
 * Representation of a graph.
 * 
 * @author Ian Argyle, Donald Kubiak
 * @version March 1, 2019
 */
public class Graph<T> {

	// the graph -- a set of vertices (String name mapped to Vertex instance)
	HashMap<T, Vertex<T>> vertices;

	/**
	 * Constructs an empty graph.
	 */
	public Graph() {
		vertices = new HashMap<T, Vertex<T>>();
	}

	/**
	 * Adds to the graph an edge from the vertex with name "name1" to the vertex
	 * with name "name2". The edge is associated with the "weight". If either
	 * vertex does not already exist in the graph, it is added. Terminal keeps
	 * track of terminal and non-terminal nodes.
	 */
	public void addEdge(T source, T dest, boolean terminal) {
		Vertex<T> vertex1;
		if(vertices.containsKey(source)) {
			vertex1 = vertices.get(source);
		}
		else {
			vertex1 = new Vertex<T>(source);
			vertices.put(source, vertex1);
		}

		Vertex<T> vertex2;
		if(vertices.containsKey(dest)) {
			vertex2 = vertices.get(dest);
		}
		else {
			vertex2 = new Vertex<T>(dest);
			vertices.put(dest, vertex2);
		}
		if (terminal)
			vertex2.setTerminal();
		vertex1.addEdge(vertex2);
	}
}