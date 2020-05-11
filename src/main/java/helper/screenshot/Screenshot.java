package helper.screenshot;

import helper.resource.ResourceHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {
        private WebDriver driver;

        public static void takeSnapShot(WebDriver driver,String fileName) throws Exception{
       
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

        File DestFile = new File(ResourceHelper.getResourcePath("/test-output/")+fileName+timestamp+".png");

        FileUtils.copyFile(SrcFile,DestFile);

    }

}
