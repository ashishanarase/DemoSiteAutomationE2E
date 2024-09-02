package utilityPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private static Properties properties = new Properties();

	//static String userDirectory ="C:\\Users\\ashish.anarase\\git\\DemoSiteAutomationE2E\\";
	
	static String userDirectory = "C:\\Users\\ASHISH\\eclipse-workspace\\DemoSiteAutomationE2E\\";
		
	public static void loadConfig(String environment) {
		try (FileInputStream input = new FileInputStream(userDirectory+"\\DataFiles\\config_" + environment + ".properties")) {
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load configuration for environment: " + environment);
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
