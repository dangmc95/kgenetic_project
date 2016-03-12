package cycle;

import java.util.List;

import org.apache.log4j.Logger;

import graph.KGraph;

/**
 * @author ktuan
 */
public class BaseCycle {
	private static Logger logger= Logger.getLogger(BaseCycle.class);
	private int numberVertice;
	private List<Integer> vertices;
	private KGraph graph;

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

	public static void main(String[] args) {
		logger.info("Start: BaseCycle");
		BaseCycle cycle = new BaseCycle();
		KGraph kgraph = null;
		cycle.setGraph(kgraph);
		logger.info("Finish: BaseCycle");
	}
}
