package graph;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import utils.FileUtils;

/**
 * @author ktuan
 */
public class GInput {
	private static Logger logger = Logger.getLogger(GInput.class);
	private static final String FOLDER_DATA = "data";
	private static GInput INSTANCE = null;

	private static synchronized GInput getInstance() {
		if (INSTANCE != null)
			INSTANCE = new GInput();
		return INSTANCE;
	}

	private KGraph generateFromFile(File file) {
		try{
			List<String> lines= FileUtils.readMultilinesFromFile(file);
			if (lines== null) return null;
			return null;	
		}catch(Exception ex){
			logger.error(ex.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		logger.info("Start: GInput");
		List<File> files = FileUtils.getFilesFromFolder(FOLDER_DATA);
		for (File file : files) {
			logger.info("\n" + file.getAbsolutePath());
		}
		logger.info("Size: " + files.size());
		GInput input = GInput.getInstance();
		for (File file : files) {
			KGraph graph = input.generateFromFile(file);
		}
		logger.info("Finish: GInput");
	}
}
