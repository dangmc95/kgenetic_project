package utils;

import org.apache.log4j.Logger;

public class TimeStamp {
	private static final Logger logger = Logger.getLogger(TimeStamp.class);
	private long timeSave;

	public TimeStamp() {
		this.timeSave = System.currentTimeMillis();
	}

	public boolean reset() {
		this.timeSave = System.currentTimeMillis();
		return false;
	}

	public long estimate() {
		return System.currentTimeMillis() - this.timeSave;
	}

	public long estimateSecond() {
		return (System.currentTimeMillis() - this.timeSave) / 1000;
	}

	public static void main(String[] args) {
		logger.info("Start: main");
		TimeStamp timeStamp = new TimeStamp();
		timeStamp.reset();
		logger.info("milisecond:= " + timeStamp.estimate());
		logger.info("milisecond:= " + timeStamp.estimateSecond());
		logger.info("Finish: main");
	}

}
