package fa.training.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4J {
	private static final Logger logger = Logger.getLogger(Log4J.class);

	public static Logger getLogger() {
		PropertyConfigurator.configure(Log4J.class.getResourceAsStream("/properties/log4jFILE.properties"));
		return logger;
	}
}
