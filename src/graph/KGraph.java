package graph;

import org.apache.log4j.Logger;

/**
 * @author ktuan
 */
public class KGraph {
	private static final Logger logger = Logger.getLogger(KGraph.class);
	private int numberOfVertice;
	private int numberOfEdge;
	private VerticeInfo[] verticesInfo;

	public int getNumberOfVertice() {
		return numberOfVertice;
	}

	public void setNumberOfVertice(int numberOfVertice) {
		this.numberOfVertice = numberOfVertice;
	}

	public int getNumberOfEdge() {
		return numberOfEdge;
	}

	public void setNumberOfEdge(int numberOfEdge) {
		this.numberOfEdge = numberOfEdge;
	}

	public VerticeInfo[] getVerticesInfo() {
		return verticesInfo;
	}

	public void setVerticesInfo(VerticeInfo[] verticesInfo) {
		this.verticesInfo = verticesInfo;
	}

	public static void main(String[] args) {
		logger.info("ktuanlamson");
	}

}
