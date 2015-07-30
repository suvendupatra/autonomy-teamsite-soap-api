package com.mycompany.myproject;

/**
* @author: Suvendu Patra
* Basic Connection class using CSSOAP factory
*/

import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;

import com.interwoven.cssdk.common.CSClient;
import com.interwoven.cssdk.common.CSException;
import com.interwoven.cssdk.common.log.CSLogFile;
import com.interwoven.cssdk.common.log.CSLogManager;
import com.interwoven.cssdk.factory.CSFactory;
import com.ironworks.security.Decryptor;

public class TeamSiteConnector {
	private static Logger logger = null;
	private Properties properties;
	private CSClient client = null;
	private final String USERNAME = "username";
	private final String PASSWORD = "password";
	private final String DEFAULTSERVER = "defaultTSServer";
	private final String ROLE = "role";


	public TeamSiteConnector() throws Exception {
		try {
			logger = new LogUtilility().getInstance();
			properties = new Properties();
			InputStream is = getClass().getResourceAsStream(
					"/ts.int.properties");
			properties.load(is);
			is.close();
			createCSClient();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	/**
	 * Method to construct the CSClient object and sets the member variable
	 *
	 * @throws CSException
	 * @throws Exception
	 */
	private void createCSClient() throws CSException, Exception {
		try {
			logger.info("Creating CSClient object");
			String userName = properties.getProperty(USERNAME);
			String password = properties.getProperty(PASSWORD);
			String defaultServer = properties.getProperty(DEFAULTSERVER);
			String role = properties.getProperty(ROLE);
			CSFactory factory = CSFactory.getFactory(properties);
			logger.info("factory obtained");
			client = factory.getClient(userName, role, password,
					Locale.getDefault(), this.getClass().getName(),
					defaultServer);
			logger.info("CSClient object obtained");

			/**
			 * Get Log Manager for appropriate component using:
			 *
			 * CSLogManager.COMPONENT_TEAM_SITE
			 * CSLogManager.COMPONENT_OPEN_DEPLOY
			 * CSLogManager.COMPONENT_WEB_DAEMON
			 *
			 */
			CSLogManager logManager = client
					.getLogManager(CSLogManager.COMPONENT_TEAM_SITE);
			logger.info("logManager object obtained" + logManager);
			/**
			 * Obtain the managed log file for this log manager.
			 */
			CSLogFile logFile = logManager.getLogFile(CSLogFile.TS_IWTRACE_LOG);
			logger.info("logFile object obtained" + logFile);

			// Reading rotation policy of the log file.
			// CSLogRotationPolicy policy = logFile.getRotationPolicy();
			// System.out.println("iwtrace.log rotations, " +
			// policy.getPolicyString());

			client.endSession();
			logger.info("TS Client Session End");
		} catch (CSException e) {
			logger.error("Exception occured while retrieving CSClient object!"
					+ e.getMessage().toString());
			e.printStackTrace();
			throw e;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			System.out.println("Start Calling TS Connector");
			TeamSiteConnector ts = new TeamSiteConnector();
			System.out.println("End Calling TS Connector");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
