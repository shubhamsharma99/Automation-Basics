package Reusable;

import org.apache.log4j.Logger;

public class Log4util {

	private static Log4util obj = new Log4util();

	private Log4util() {
	}

	public static Log4util getInstance() {
		return obj;
	}

	/* Get actual class name to be printed on */
	static Logger log = Logger.getLogger(" ");

	public static void logfile(String message) {

		log.info(message);
		// testing
		// log.error("The error has been detected.Please try again later.");
	}

	public static void main(String[] args) {
		// Log4util obj= Log4util.getInstance();
		logfile("hello this is a debug message");

	}
}
