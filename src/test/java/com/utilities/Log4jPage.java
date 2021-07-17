package com.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jPage {

	
		
		 public static Logger log1 =null;
		 public static Logger pageLogs() {
			     log1 =Logger.getLogger(Log4jPage.class);
				String path=(System.getProperty("user.dir")+"/src/main/java/log4jPage.properties");
				PropertyConfigurator.configure(path);
				return log1;
			}
	

}
