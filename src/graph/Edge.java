package graph;

import org.apache.log4j.Logger;

/**
 * @author ktuan
 */
public class Edge<P, I> {
	private static final Logger logger = Logger.getLogger(Edge.class);
	private P start, finish;
	private I info;

	public P getStart() {
		return start;
	}

	public void setStart(P start) {
		this.start = start;
	}

	public P getFinish() {
		return finish;
	}

	public void setFinish(P finish) {
		this.finish = finish;
	}

	public I getInfo() {
		return info;
	}

	public void setInfo(I info) {
		this.info = info;
	}

	public static void main(String[] args) {
		logger.info("ktuanlamson");
	}

}
