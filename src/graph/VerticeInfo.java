package graph;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author ktuan
 */
public class VerticeInfo {
	private static Logger logger = Logger.getLogger(VerticeInfo.class);
	private List<Edge<Integer, Integer>> edges;

	public List<Edge<Integer, Integer>> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge<Integer, Integer>> edges) {
		this.edges = edges;
	}

	public static void main(String[] args) {
		logger.info("ktuanlamson");
	}

}
