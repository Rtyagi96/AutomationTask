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

        //Convert web driver object to TakeScreenshot(Interface)..typecasting

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());

        //Move image file to new destination

        File DestFile = new File(ResourceHelper.getResourcePath("/test-output/")+fileName+timestamp+".png");

        //Copy file at destination

        FileUtils.copyFile(SrcFile,DestFile);

    }

}
