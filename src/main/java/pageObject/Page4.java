package pageObject;

import helper.logger.LoggerHelper;
import helper.screenshot.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.logging.Logger;

public class Page4 {
    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(Page4.class);

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div/div[3]")
    WebElement successMessage;

    @FindBy(xpath = "//a[contains(text(),'Edit your response')]")
    WebElement editResponse;

    @FindBy(xpath = "//a[contains(text(),'Submit another response')]")
    WebElement submitAnotherResponse;

    public Page4(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void getSuccessMsg() throws Exception {
        Screenshot.takeSnapShot(driver,"SuccessMessage");
        //Verify success message
        Assert.assertEquals(successMessage.getText(),"Thank you for your response.");
        log.info("Test completed...");
    }
    public void clickEditResponse(){
        log.info("Clicking Edit response link...");
        editResponse.click();
    }
    public void clickSubmitAnotherResponse(){
        log.info("Clicking Submit another response link...");
        submitAnotherResponse.click();
    }
}
