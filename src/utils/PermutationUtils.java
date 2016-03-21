package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import cycle.BaseCycle;

/**
 * @author ktuan
 */
public class PermutationUtils {
	private static final Logger logger = Logger.getLogger(PermutationUtils.class);

	private static List<Integer> getFollowSequenceWithMinimumValue(List<Integer> lst) {
		int[] sequence= new int[lst.size()];
		if (BaseCycle.isCycleBasic(lst)){
			return getFollowSequenceWithMinimumValueUsingFirstMinimumValueMeet(lst);
		}
		return null;
	}

	private static List<Integer> getFollowSequenceWithMinimumValueUsingFirstMinimumValueMeet(List<Integer> lst) {
		int minimum= ListUtils.getMinimumValue(lst);
		int index= ListUtils.getFirtIndexMeeting(lst,minimum);
		return null;
	}

	public static void main(String[] args) {
		logger.info("Start: main");
		Random rd = new Random();
		List<Integer> lst = new ArrayList<Integer>();
		int size = 10;
		for (int i = 1; i <= size; i++) {
			lst.add(i);
		}
		for (int i = 1; i <= size; i++) {
			int u, v;
			u = rd.nextInt(size);
			v = rd.nextInt(size);
			if (u != v) {
				int tmp = lst.get(u);
				lst.set(u, lst.get(v));
				lst.set(v, tmp);
			}
		}
		logger.info("Pre using permutation utils");
		for (int i = 0; i < size; i++) {
			logger.info(lst.get(i));
		}
		lst = PermutationUtils.getFollowSequenceWithMinimumValue(lst);
		logger.info("After get minimum permution utils");
		for (int i = 0; i < size; i++) {
			logger.info(lst.get(i));
		}
		logger.info("Finish: main");
	}

}
