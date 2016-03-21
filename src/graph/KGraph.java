package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.apache.log4j.Logger;

import cycle.BaseCycle;

/**
 * @author ktuan
 */
public class KGraph {
	private static final Logger logger = Logger.getLogger(KGraph.class);
	private int numberOfVertice;
	private int numberOfEdge;
	private VerticeInfo[] verticesInfo;
	private Random rd;
	private int[] pre;
	private int lastIndex;

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

	public void initForNumberOfVerticalsAndEdges() {
		try {
			logger.info("Start: initForNumberOfVerticalsAndEdges: vertices:= " + this.numberOfVertice + "| edges:= "
					+ this.numberOfEdge);
			verticesInfo = new VerticeInfo[this.numberOfVertice + 1];
			for (int index = 1; index <= this.numberOfVertice; index++) {
				verticesInfo[index] = new VerticeInfo();
			}
			logger.info("Finish: initForNumberOfVerticalsAndEdges");
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}
	}

	public boolean addEgde(Edge<Integer, Integer> edge) {
		try {
			int start = edge.getStart();
			if (start >= 1 && start <= this.numberOfVertice) {
				if (this.verticesInfo != null && this.verticesInfo[start] != null) {
					this.verticesInfo[start].addEdge(edge);
				}
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	public BaseCycle generateRandomCycle() {
		try {
			if (rd == null) {
				rd = new Random();
			}
			int start = rd.nextInt(this.numberOfVertice) + 1;
			logger.info("Start:= " + start);
			return generateRandomCycle(start);
		} catch (Exception ex) {
			return null;
		}
	}

	private BaseCycle generateRandomCycle(int start) {
		logger.info("Start: generateRandomCycle-" + start);
		if (rd == null) {
			rd = new Random();
		}
		pre = new int[this.numberOfVertice + 1];
		for (int index = 1; index <= this.numberOfVertice; index++) {
			pre[index] = 0;
		}
		lastIndex = -1;
		dfsGenRandomCycle(start, start);
		for (int index = 1; index <= this.numberOfVertice; index++) {
			logger.info("Pre[" + index + "]= " + pre[index]);
		}
		logger.info("last index:= " + lastIndex);
		if (lastIndex == -1)
			return null;
		List<Integer> vertices = new ArrayList<Integer>();
		while (lastIndex != 0) {
			vertices.add(lastIndex);
			lastIndex = pre[lastIndex];
		}
		Collections.reverse(vertices);
		if (!BaseCycle.isCycleBasic(vertices))
			return null;
		return new BaseCycle(vertices);
	}

	private void dfsGenRandomCycle(int index, int indexFinish) {
		logger.info("Dfs: " + index);
		List<Integer> indexNeighbors = getRandomIndexNeighbors(index);
		logger.info("Size neighbor:= "+ indexNeighbors.size());
		for (int neighbor : indexNeighbors) {
			if (neighbor != pre[index]) {
				if (neighbor == indexFinish) {
					lastIndex = index;
					return;
				}
				if (pre[neighbor] == 0) {
					pre[neighbor] = index;
					dfsGenRandomCycle(neighbor, indexFinish);
					if (lastIndex > 0)
						return;
				}
			}
		}
	}

	private List<Integer> getRandomIndexNeighbors(int verticeIndex) {
		if (this.verticesInfo == null)
			initForNumberOfVerticalsAndEdges();
		if (this.verticesInfo[verticeIndex] == null)
			return null;
		return this.verticesInfo[verticeIndex].getRandomIndexNeighbors(this.rd);
	}

	public static void main(String[] args) {
		logger.info("ktuanlamson");
	}
}
