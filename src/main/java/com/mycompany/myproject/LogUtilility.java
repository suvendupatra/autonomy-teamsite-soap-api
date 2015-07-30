package com.mycompany.myproject;

/**
* @author: Suvendu Patra
* Basic Log utility to use with the connector class
*/

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtilility {

	private Logger logger = null;

	public LogUtilility() {
		// TODO Auto-generated constructor stub
	}

	public Logger getInstance() {
	  BasicConfigurator.configure();
      String callingClassName = Thread.currentThread().getStackTrace()[2].getClass().getCanonicalName();
      logger = LoggerFactory.getLogger(callingClassName);
      return logger;
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogUtilility lu = new LogUtilility();
		Logger log = lu.getInstance();
		String message = "logging.....";

		log.info(message + "info");
		log.warn(message + "warn");
		log.error(message + "error");


		log.debug(message + "debug");
		log.trace(message + "trace");
	}

}
