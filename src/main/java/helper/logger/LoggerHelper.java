package helper.logger;

import helper.resource.ResourceHelper;
import org.apache.log4j.PropertyConfigurator;
import java.util.logging.Logger;

public class LoggerHelper {

    private static boolean root = false;

    public static Logger getLogger(Class cls){
        if(root){
            return Logger.getLogger(String.valueOf(cls));
        }
        PropertyConfigurator.configure(ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\log4j.properties"));
        root = true;
        return Logger.getLogger(String.valueOf(cls));
    }
}
