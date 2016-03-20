package graph;

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
			return generateRandomCycle(start);
		} catch (Exception ex) {
			return null;
		}
	}

	private BaseCycle generateRandomCycle(int start) {
		boolean[] visits = new boolean[this.numberOfVertice + 1];
		int[] pres = new int[this.numberOfVertice + 1];
		for (int index = 1; index <= this.numberOfVertice; index++) {
			visits[index] = false;
			pres[index] = 0;
		}
		pres[start] = -1;
		visits[start]= true;
		int tmpVertice = start;
		boolean findCycle = false;
		Queue<Integer> queue= new LinkedList<Integer>();
		queue.add(start);
		while (findCycle = false) {
			tmpVertice= queue.poll();
			List<Integer> neighbours= getRandomIndexNeighbors(tmpVertice);
			for(int nextVertical: neighbours){
				if (nextVertical== start) {
					findCycle= true;
					break;
				}
				if (visits[nextVertical]== false){
					continue;
				}
			}
		}
		return null;
	}

	private List<Integer> getRandomIndexNeighbors(int verticeIndex) {
		if (this.verticesInfo== null) initForNumberOfVerticalsAndEdges();
		if (this.verticesInfo[verticeIndex]== null) return null;
		return this.verticesInfo[verticeIndex].getRandomIndexNeighbors(this.rd);
	}

	public static void main(String[] args) {
		logger.info("ktuanlamson");
	}
}
