package Utils;

import com.aventstack.extentreports.ExtentTest;
import org.apache.log4j.LogManager;

public class CustomLogger{

    private org.apache.log4j.Logger logger ;

    public ExtentTest getTest(){
        return ExtentReportManager.getExtentTest();
    }

    public CustomLogger(Class clazz){
        logger =  LogManager.getLogger(clazz.getName());
    }

    public void info(String message) {
        logger.info(message);
        getTest().pass(message);
    }

    public void warn(String message) {
        logger.warn(message);
        getTest().warning(message);

    }

    public void error(String message) {
        logger.error(message);
        getTest().fail(message);
    }


}
