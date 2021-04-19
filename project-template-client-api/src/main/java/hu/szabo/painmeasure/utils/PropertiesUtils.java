package hu.szabo.painmeasure.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Szabó Levente
 *
 *         PropertiesUtils.
 */

public class PropertiesUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtils.class);

	private static final String EXTENSION = ".properties";

	private PropertiesUtils() {
	}

	public static Properties getProperties(String propertiesFileName) throws Exception {

		if (!propertiesFileName.endsWith(EXTENSION)) {
			propertiesFileName = propertiesFileName + EXTENSION;
		}

		Properties prop = new Properties();
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(System.getProperty("jboss.server.config.dir"));
		stringBuilder.append("/");
		stringBuilder.append("app-config/painmeasure/");
		stringBuilder.append(propertiesFileName);
		String filePath = stringBuilder.toString();

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Load file: " + filePath);
		}

		prop.load(new FileInputStream(new File(filePath)));

		return prop;
	}
}
