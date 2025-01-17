package utilityPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;

public class ConfigLoader {

	private static Properties properties = new Properties();

	static String userDirectory;
	
	static {
	    try {
	        String hostName = InetAddress.getLocalHost().getHostName();
	        if ("ASHISHANMUMLAP".equalsIgnoreCase(hostName)) {
	            userDirectory = "C:\\Users\\ashish.anarase\\git\\DemoSiteAutomationE2E\\";
	        } else if ("A-SQUARE".equalsIgnoreCase(hostName)) {
	            userDirectory = "C:\\Users\\ASHISH\\eclipse-workspace\\DemoSiteAutomationE2E\\";
	        } else {
	            throw new RuntimeException("Unknown host: " + hostName);
	        }
	    } catch (Exception e) {
	        throw new RuntimeException("Error determining hostname", e);
	    }
	}
	
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
