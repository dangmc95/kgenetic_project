package graph;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import cycle.BaseCycle;
import utils.FileUtils;

/**
 * @author ktuan
 */
public class GInput {
	private static Logger logger = Logger.getLogger(GInput.class);
	private static final String FOLDER_DATA = "data";
	private static GInput INSTANCE = null;

	private static synchronized GInput getInstance() {
		if (INSTANCE == null)
			INSTANCE = new GInput();
		return INSTANCE;
	}

	private KGraph generateFromFile(File file) {
		try {
			List<String> lines = FileUtils.readMultilinesFromFile(file);
			if (lines == null)
				return null;
			KGraph graph = new KGraph();
			String[] parts = lines.get(0).split(" ");
			graph.setNumberOfVertice(Integer.parseInt(parts[0]));
			graph.setNumberOfEdge(Integer.parseInt(parts[1]));
			graph.initForNumberOfVerticalsAndEdges();
			lines.remove(0);
			for (String line : lines) {
				parts = line.trim().split(" ");
				if (parts.length != 3)
					continue;
				int start = Integer.parseInt(parts[0]);
				int finish = Integer.parseInt(parts[1]);
				int value = Integer.parseInt(parts[2]);
				Edge<Integer, Integer> edge = new Edge<Integer, Integer>();
				edge.setStart(start);
				edge.setFinish(finish);
				edge.setInfo(value);
				graph.addEgde(edge);
				Edge<Integer, Integer> edge2 = new Edge<Integer, Integer>();
				edge2.setStart(finish);
				edge2.setFinish(start);
				edge2.setInfo(value);
				graph.addEgde(edge2);
			}
			logger.info("Number lines:= " + lines.size());
			return graph;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		logger.info("Start: GInput");
		List<File> files = FileUtils.getFilesFromFolder(FOLDER_DATA);
		logger.info("Size: " + files.size());
		GInput input = GInput.getInstance();
		for (File file : files) {
			if (input == null) {
				logger.info("Input is null !!!!");
			}
			KGraph graph = input.generateFromFile(file);
			if (graph == null) {
				logger.info("Graph is null!!!");
			} else {
				BaseCycle cycles = graph.generateRandomCycle();
				if (cycles == null) {
					logger.info("Cycle is null !!!");
				} else {
					StringBuilder sb = new StringBuilder();
					sb.setLength(0);
					cycles.toString(sb);
					logger.info(sb.toString());
				}
			}
			break;
		}
		logger.info("Finish: GInput");
	}
}
