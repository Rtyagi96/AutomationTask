import helper.calendar.CalendarHelper;
import helper.javaScript.JavaScriptHelper;
import helper.logger.LoggerHelper;
import helper.randomListHelper.RandomListHelper;
import helper.screenshot.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Test1 {
    private static Logger log = LoggerHelper.getLogger(Test1.class);
    static WebDriver driver;
    static  String baseURL = "https://docs.google.com/forms/d/e/1FAIpQLScNx9xK2LM-G3Z3fJXOQapiSK1IAoNXc_67MyS-soTfhDXotA/viewform";
    static JavaScriptHelper javaScriptHelper;
    static CalendarHelper calendarHelper;

    public static void main(String[] args) throws Exception {
    String driverPath= System.setProperty("webdriver.chrome.driver","C:/Users/Rohit/IdeaProjects/com.zoom.task" +
            "/src/drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(baseURL);

    calendarHelper = new CalendarHelper();
    javaScriptHelper = new JavaScriptHelper(driver);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    WebElement element = driver.findElement(By.xpath("(//*[@class='freebirdFormviewerViewItemsItemItemHeader'])[1]"));
        javaScriptHelper.scrollToElement(element);
    //STEP 1
        driver.findElement(By.xpath("(//*[@class='quantumWizTogglePapercheckboxInnerBox exportInnerBox'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='quantumWizTogglePapercheckboxInnerBox exportInnerBox'])[4]")).click();
    //STEP 2
        driver.findElement(By.xpath("(//input[@jsname='YPqjbf'])[1]")).sendKeys(calendarHelper.getNewDate());
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div/div/div[2]/div[2]/div/div[2]/div")).sendKeys(calendarHelper.getNewDate());
    //STEP 3
        driver.findElement(By.xpath("//*[@class='appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel']")).click();
        String errorMessage = driver.findElement(By.id("i.err.1806505028")).getText();
        if(errorMessage =="Tato otázka je povinná."|| errorMessage=="This is a required question") {
            log.info("Taking the screenshot....");
            Screenshot.takeSnapShot(driver, "RequiredField");
        Assert.assertTrue(true);

    }else {
        Assert.assertFalse(false,"Third field is not mandatory");
    }
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(calendarHelper.getCurrentMonth());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel']")).click();
    //STEP 5
        driver.findElement(By.xpath("//*[@jsname='YPqjbf']")).sendKeys(RandomListHelper.getRandomList(), Keys.ENTER);
        driver.findElement(By.xpath("//*[@jsname='YPqjbf']")).sendKeys(RandomListHelper.getRandomList(),Keys.ENTER);
        driver.findElement(By.xpath("//*[@jsname='YPqjbf']")).sendKeys(RandomListHelper.getRandomList());

        driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[3]/label/div/div[1]/div")).click();
        driver.findElement(By.xpath("(//*[@class='appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel'])[1]")).click();

        javaScriptHelper.scrollToBottom();
        driver.findElement(By.xpath("//input[@type='text']")).clear();
    //STEP 6
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(calendarHelper.reverseMonth());
        System.out.println(calendarHelper.reverseMonth());
    //STEP 7
        driver.findElement(By.xpath("//*[@class='appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel']")).click();

    //STEP 8
    String movies = driver.findElement(By.xpath("//*[@jsname='YPqjbf']")).getText();
    System.out.println(movies);
        if(movies.isBlank()){
        Assert.assertFalse(false, "Movies field is empty");
    }else{
        Assert.assertTrue(true);
    }

        String str =driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[3]/label/div/div[1]/div")).getAttribute("aria-checked");
        System.out.println(str);

        driver.findElement(By.xpath("(//*[@class='appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[@class=\"appsMaterialWizToggleRadiogroupOffRadio exportOuterCircle\"])[2]")).click();
        driver.findElement(By.xpath("(//*[@class=\"appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel\"])[2]")).click();
        String successMsg = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[3]")).getText();
        Assert.assertEquals(successMsg,"Thank you for your response.");
        System.out.println(successMsg);
        System.out.println("Test completed and form submitted");
        driver.quit();

    }

}