package pageObject;

import base.TestBase;
import helper.calendar.CalendarHelper;
import helper.javaScript.JavaScriptHelper;
import helper.logger.LoggerHelper;
import helper.screenshot.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Page1 {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(Page1.class);

    @FindBy(xpath ="(//*[@class='quantumWizTogglePapercheckboxInnerBox exportInnerBox'])[1]")
    WebElement question1_selectCheckbox1;

    @FindBy(xpath = "(//*[@class='quantumWizTogglePapercheckboxInnerBox exportInnerBox'])[2]")
    WebElement question1_selectCheckbox2;

    @FindBy(xpath = "(//*[@class='quantumWizTogglePapercheckboxInnerBox exportInnerBox'])[3]")
    WebElement question1_selectCheckbox3;

    @FindBy(xpath = "(//*[@class='quantumWizTogglePapercheckboxInnerBox exportInnerBox'])[4]")
    WebElement question1_selectCheckbox4;

    @FindBy(xpath = "(//input[@jsname='YPqjbf'])[1]")
    WebElement inputCalendarDate;

    @FindBy(xpath = "/html/body/div[1]/div[2]/form/div/div/div[2]/div[3]/div/div[2]/div/div[1]/div/div[1]/input")
    WebElement inputCurrentMonth;

    @FindBy(xpath = "//*[@class='appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel']")
    WebElement clickNextButton;

    @FindBy(id = "i.err.1806505028")
    WebElement errorMessageText;

    @FindBy(xpath = "/html/body/div[1]/div[2]/form/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div[1]/div/div[1]/input")
    WebElement date;

    @FindBy(xpath = "/html/body/div[1]/div[2]/form/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/div/div[1]/input")
    WebElement month;

    @FindBy(xpath = "/html/body/div[1]/div[2]/form/div/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div[2]/div[1]/div/div[1]/input")
    WebElement year;

    CalendarHelper calendarHelper = new CalendarHelper();

    //Constructor to initialize the driver and webElement of Page1 class
    public Page1(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
    }
    public void clickOnCheckboxes(){
        log.info("Scrolling to first question....");
        new JavaScriptHelper(driver).scrollToElement(question1_selectCheckbox1);
        question1_selectCheckbox1.click();
        log.info("Selecting checkbox 1....");
        question1_selectCheckbox4.click();
        log.info("Selecting checkbox 4....");
    }
    @Parameters("browser")
    public void setCalendar(String browser) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //String browser = new TestBase().prop.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")) {
            inputCalendarDate.sendKeys(calendarHelper.getNewDate());
        }
            else {
            date.clear();
            date.sendKeys(calendarHelper.getDateValue());
            month.clear();
            month.sendKeys(calendarHelper.getMonthValue());
            year.clear();
            year.sendKeys(calendarHelper.getYearValue());
        }
    }
    public void setCurrentMonth(){
        inputCurrentMonth.sendKeys(calendarHelper.getCurrentMonth());
    }
    public void reverseCurrentMonth(){
        new JavaScriptHelper(driver).scrollToBottom();
        inputCurrentMonth.clear();
        inputCurrentMonth.sendKeys(calendarHelper.reverseMonth());
    }
    public void clickNextButton() throws Exception {
        Thread.sleep(2000);
        log.info("Go to next page");
        //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        clickNextButton.click();
    }
    public void verifyRequiredField() throws Exception {
        log.info("Clicking Next button");
        clickNextButton.click();
        String requiredField = errorMessageText.getText();
        Assert.assertEquals(requiredField," Tato otázka je povinná.","Invalid or no error message for required field...");
        log.info("taking screenshot of required field error message....");
        Screenshot.takeSnapShot(driver, "RequiredField");
    }
}
