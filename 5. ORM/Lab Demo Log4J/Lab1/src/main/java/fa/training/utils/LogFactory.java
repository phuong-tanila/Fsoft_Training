package fa.training.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LogFactory {

	public static Logger getLogger() {
		return LogManager.getLogger(LogFactory.class);
	}
}
