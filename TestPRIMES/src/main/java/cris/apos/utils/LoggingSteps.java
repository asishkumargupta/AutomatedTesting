package cris.apos.utils;
import java.io.File;
import java.util.logging.FileHandler;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
 
public class LoggingSteps {
 
	static Logger logger = Logger.getLogger(LoggingSteps.class);
 
    public static void log(String errorType,String codeName,String message) {

    	PropertyConfigurator.configure(".\\resources\\config\\log4j.properties");
 
/*        logger.debug("this is a debug log message" + param);
        logger.info("this is a information log message" + param);
        logger.warn("this is a warning log message" + param);*/
    	
    	switch (errorType) {
    	case "error": 
    		logger.error(message + " " + codeName);
    		break;
    	case "warn":
    		logger.warn(message + " " + codeName);
    		break;
    	default:
    		logger.info(message + " " + codeName);
    	}
    	
    	
    	
    	
        
        
        

      
    }
 
}