import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import pageObject.Page1;
import pageObject.Page2;
import pageObject.Page3;
import pageObject.Page4;

import java.util.concurrent.TimeUnit;
/**
 Steps:
 1) Fill first and second question
 2) Validate that third question is mandatory
 3) Fill third question and go to another step
 4) Fill next questions
 5) Go back to first step
 6) Reverse text in third question
 7) Go to second step
 8) Check that both questions are still filed
 9) Go to last step
 10) Fill last question and send form
 */
public class TestSubmitForm extends TestBase{

    @Parameters("browser")
    @BeforeTest
    void setUp(String browser) {

//        if(prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        }else if(prop.getProperty("browser").equalsIgnoreCase("Firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }else {
//            WebDriverManager.iedriver().setup();
//            driver = new InternetExplorerDriver();
//        }

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get(prop.getProperty("baseURL"));
    }
    @Parameters("browser")
    @Test(description = "Verify Submit form functionality")
    public void testAutomationTask (String browser) throws Exception {
        Page1 page1 = new Page1(driver);
        Page2 page2 = new Page2(driver);
        Page3 page3 = new Page3(driver);
        Page4 page4 = new Page4(driver);

        //Step 1
        page1.clickOnCheckboxes();
        //Step 2
        page1.setCalendar(browser);
        //Step 3
        page1.verifyRequiredField();
        page1.setCurrentMonth();
        page1.clickNextButton();
        //Step 4
        page2.setFavoriteMovies();
        page2.setFavoriteColor();
        //Step 5
        page2.clickBackButton();
        //Step 6
        page1.reverseCurrentMonth();
        //Step 7
        page1.clickNextButton();
        //Step 8
        page2.getMovies();
        page2.getColor();
        //Step 9
        page2.clickNextButton();
        //Step 10
        page3.isItDone();
        page3.clickSubmitButton();
        page4.getSuccessMsg();
    }
    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
