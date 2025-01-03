package utilityPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private static Properties properties = new Properties();

	//OFF
	static String userDirectory ="C:\\Users\\ashish.anarase\\git\\DemoSiteAutomationE2E\\";

	//ON
	//static String userDirectory = "C:\\Users\\ASHISH\\eclipse-workspace\\DemoSiteAutomationE2E\\";

	public static void loadConfig(String environment) {
		try (FileInputStream input = new FileInputStream(userDirectory+"\\ConfigFiles\\config_" + environment + ".properties")) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load configuration for environment: " + environment);
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}


//Class Brace	
}
