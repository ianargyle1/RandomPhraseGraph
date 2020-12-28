package comprehensive;

import java.util.ArrayList;

/**
 * This class represents a vertex (AKA node) in a directed graph. The vertex is
 * not generic, assumes that a string name is stored there.
 * 
 * @author Ian Argyle, Donald Kubiak
 * @version March 1, 2019
 */
public class Vertex<T> {

	// used to id the Vertex
	private T name;
	private boolean terminal;

	public ArrayList<Vertex<T>> adj;
	public Vertex(T name) {
		this.name = name;
		this.terminal = false;
		this.adj = new ArrayList<Vertex<T>>();
	}

	public T getName() {
		return name;
	}

	public void addEdge(Vertex<T> otherVertex) {
		adj.add(otherVertex);
	}
	public void setTerminal() {
		terminal = true;
	}
	public boolean getTerminal() {
		return terminal;
	}
}