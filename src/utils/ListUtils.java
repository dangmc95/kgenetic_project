package utils;

import java.util.List;

/**
 * @author ktuan
 */
public class ListUtils {

	public static synchronized int getMinimumValue(List<Integer> lst) {
		int minimum = Integer.MAX_VALUE;
		if (lst != null) {
			for (int value : lst) {
				if (minimum > value)
					minimum = value;
			}
		}
		return minimum;
	}

	public static synchronized int getFirtIndexMeeting(List<Integer> lst, int value) {
		if (lst == null)
			return -1;
		return 0;
	}
}
