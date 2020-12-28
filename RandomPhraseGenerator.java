package comprehensive;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Generates x number of random phrases from input grammar
 * file.
 * 
 * @author Ian Argyle, Donald Kubiak
 *
 */
public class RandomPhraseGenerator {
	private static Random rnd = new Random();

	/**
	 * Calls parse and generate, prints output.
	 * @param args - grammar file, # of random phrases
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			Graph<String> graph;
			try {
				graph = parse(new BufferedReader(new FileReader(args[0])));
				int stop = Integer.parseInt(args[1]);
				OutputStream out = new BufferedOutputStream(System.out);
				for (int i = 0; i < stop; i++) {
					out.write((generate(graph.vertices.get("<start>")) + "\n").getBytes());
				}
				out.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Generates a string from a graph object by randomly
	 * selecting nodes.
	 * @param node - starting node
	 * @return random phrase
	 */
	private static String generate(Vertex<String> node) {
		if (node.getTerminal() || node.getName().equals("<start>")) {
			if (node.adj.isEmpty()) {
				return node.getName();
			} else {
				int ind = 0;
				ind = rnd.nextInt(node.adj.size());
				return generate(node.adj.get(ind));
			}
		} else {
			StringBuilder str = new StringBuilder();
			for(Vertex<String> e : node.adj) {
				str.append(generate(e));
			}
			return str.toString();
		}
	}

	/**
	 * Parses grammar file into a graph object.
	 * @param reader - BufferedReader to read file from
	 * @return graph object
	 */
	private static Graph<String> parse(BufferedReader reader) {
		try {
			String line = reader.readLine();
			Graph<String> graph = new Graph<String>();
			while (line != null) {
				if (line.equals("{")) {
					String parent = reader.readLine();
					line = reader.readLine();
					int count = 0;
					while (!line.equals("}")) {
						graph.addEdge(parent, parent + "_node_line_" + count, false);
						int i = 0;
						String currentString = "";
						while (i < line.length()) {
							if (line.charAt(i) == '<') {
								if (!currentString.equals("")) {
									graph.addEdge(parent + "_node_line_" + count, currentString, true);
									currentString = "";
								}
								while (line.charAt(i) != '>') {
									currentString += line.charAt(i);
									i++;
								}
								currentString += line.charAt(i);
								graph.addEdge(parent + "_node_line_" + count, currentString, true);
								currentString = "";
							}
							else {
								currentString += line.charAt(i);
							}
							i++;
						}
						if (currentString != "")
							graph.addEdge(parent + "_node_line_" + count, currentString, true);
						count++;
						line = reader.readLine();
					}
				}
				line = reader.readLine();
			}
			return graph;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
