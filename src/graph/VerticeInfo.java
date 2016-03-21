package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

/**
 * @author ktuan
 */
public class VerticeInfo {
	private static final int NUMBER_RANDOM_NEIGHBOR = 3;
	private static Logger logger = Logger.getLogger(VerticeInfo.class);
	private List<Edge<Integer, Integer>> edges;
	private List<Integer> lstRandomNeighbors;

	public VerticeInfo() {
		this.edges = new ArrayList<Edge<Integer, Integer>>();
	}

	public List<Edge<Integer, Integer>> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge<Integer, Integer>> edges) {
		this.edges = edges;
	}

	public boolean addEdge(Edge<Integer, Integer> edge) {
		try {
			if (this.edges == null)
				this.edges = new ArrayList<Edge<Integer, Integer>>();
			if (edge == null)
				return false;
			this.edges.add(edge);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public List<Integer> getRandomIndexNeighbors(Random rd) {
		if (lstRandomNeighbors == null) {
			lstRandomNeighbors = new ArrayList<Integer>();
		}
		if (this.lstRandomNeighbors.size() != this.edges.size()) {
			this.lstRandomNeighbors.clear();
			for (Edge<Integer, Integer> edge : this.edges) {
				this.lstRandomNeighbors.add(edge.getFinish());
			}
		}
		int size = this.lstRandomNeighbors.size();
		if (size == 0)
			return Collections.EMPTY_LIST;
		for (int cs = 0; cs < NUMBER_RANDOM_NEIGHBOR; cs++) {
			int u, v;
			u = rd.nextInt(size);
			v = rd.nextInt(size);
			if (u == v) {
				int value = this.lstRandomNeighbors.get(u);
				this.lstRandomNeighbors.set(u, this.lstRandomNeighbors.get(v));
				this.lstRandomNeighbors.set(v, value);
			}
		}
		return this.lstRandomNeighbors;
	}

	public static void main(String[] args) {
		logger.info("ktuanlamson");
	}

}
