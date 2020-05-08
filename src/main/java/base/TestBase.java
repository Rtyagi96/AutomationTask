package base;

import helper.logger.LoggerHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestBase {
    private Logger log = LoggerHelper.getLogger(TestBase.class);
    public Properties prop;
    public WebDriver driver;

    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/resources/configFile/config.properties");
            prop.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
