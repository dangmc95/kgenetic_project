package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author ktuan
 */
public class FileUtils {
	private static final Logger logger = Logger.getLogger(FileUtils.class);

	public static List<File> getFilesFromFolder(String foldername) {
		try {
			logger.info("Start: getFilesFromFolder");
			File folder = new File(foldername);
			if (folder.isDirectory()) {
				List<File> res = new ArrayList<File>();
				for (File file : folder.listFiles()) {
					if (file.isFile()) {
						res.add(file);
					}
				}
				return res;
			}
			logger.info("Finish: getFilesFromFolder");
			return null;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}
	}

	public static List<String> readMultilinesFromFile(File file) {
		try{
			logger.info("Start: readMultilinesFromFile");
			FileReader fr= new FileReader(file);
			BufferedReader br= new BufferedReader(fr);
			br.close();
			fr.close();
			logger.info("Finish: readMultilinesFromFile");
			return null;
		}catch(Exception ex){
			logger.error(ex.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		logger.info("Start: FileUtils");
		logger.info("Finish: FileUtils");
	}
}
