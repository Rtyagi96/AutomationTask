package pageObject;

import base.TestBase;
import helper.logger.LoggerHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class Page3 {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(Page3.class);

    @FindBy(xpath ="(//*[@class=\"appsMaterialWizToggleRadiogroupOffRadio exportOuterCircle\"])[1]")
    WebElement YesCheckbox;

    @FindBy(xpath ="(//*[@class=\"appsMaterialWizToggleRadiogroupOffRadio exportOuterCircle\"])[2]")
    WebElement NoCheckbox;

    @FindBy(xpath ="(//*[@class=\"appsMaterialWizToggleRadiogroupOffRadio exportOuterCircle\"])[3]")
    WebElement NotSureCheckbox;

    @FindBy(xpath ="(//*[@class=\"appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel\"])[2]")
    WebElement submitButton;

    @FindBy(xpath ="(//*[@class=\"appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel\"])[1]")
    WebElement clickBackButton;


    public Page3(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);

    }
    public void isItDone() throws InterruptedException {
        String isItDone = new TestBase().prop.getProperty("isItDone");
        if(isItDone.equalsIgnoreCase("Yes")) {
            Thread.sleep(1000);
            log.info("Clicking YES");
            YesCheckbox.click();
        }else if(isItDone.equalsIgnoreCase("No")){
            Thread.sleep(1000);
            log.info("Clicking NO");
            NoCheckbox.click();
        }else {
            Thread.sleep(1000);
            log.info("Clicking NOT SURE");
            NotSureCheckbox.click();
        }
    }
    public void clickSubmitButton(){
        log.info("Clicking Submit button");
        submitButton.click();
    }
    public void clickBackButton(){
        clickBackButton.click();
    }
}
