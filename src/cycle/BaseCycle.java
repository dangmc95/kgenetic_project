package cycle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import graph.KGraph;

/**
 * @author ktuan
 */
public class BaseCycle {
	private static Logger logger = Logger.getLogger(BaseCycle.class);
	private int numberVertice;
	private List<Integer> vertices;
	private KGraph graph;

	public BaseCycle(List<Integer> vertices) {
		if (vertices != null) {
			this.vertices = vertices;
			this.numberVertice = this.vertices.size() - 1;
		}
	}

	public BaseCycle() {
	}

	public KGraph getGraph() {
		return this.graph;
	}

	public List<Integer> getVertices() {
		return vertices;
	}

	public void setVertices(List<Integer> vertices) {
		this.vertices = vertices;
	}

	public int getNumberVertice() {
		return numberVertice;
	}

	public void setNumberVertice(int numberVertice) {
		this.numberVertice = numberVertice;
	}

	private void setGraph(KGraph kgraph) {
		this.graph = kgraph;
	}

	public static synchronized boolean isCycleBasic(List<Integer> vertices) {
		if (vertices == null)
			return false;
		int size = vertices.size();
		if (size <= 1)
			return false;
		Set<Integer> set = new HashSet<Integer>();
		for (int i : vertices) {
			if (set.contains(i))
				return false;
			set.add(i);
		}
		return true;
	}

	public boolean toString(StringBuilder sb) {
		sb.append("BaseCycle{\n");
		sb.append("\tNumber of vertice: " + this.numberVertice + "\n");
		sb.append("\tVertical: [");
		for (int i : this.vertices) {
			sb.append(" " + i + ",");
		}
		sb.append("]\n");
		sb.append("}");
		return true;
	}

	public static void main(String[] args) {
		logger.info("Start: BaseCycle");
		BaseCycle cycle = new BaseCycle();
		KGraph kgraph = null;
		cycle.setGraph(kgraph);
		logger.info("Finish: BaseCycle");
	}
}
