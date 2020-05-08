package pageObject;

import base.TestBase;
import helper.javaScript.JavaScriptHelper;
import helper.logger.LoggerHelper;
import helper.randomListHelper.RandomListHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

public class Page2 {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(Page2.class);

    @FindBy(xpath = "//*[@jsname='YPqjbf']")
    WebElement inputRandomMovie;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[1]/label/div/div[1]/div")
    WebElement selectRedColor;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[2]/label/div/div[1]/div")
    WebElement selectGreenColor;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[3]/label/div/div[1]/div")
    WebElement selectBlueColor;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[4]/label/div/div[1]/div")
    WebElement selectBlackColor;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[5]/label/div/div[1]/div")
    WebElement selectPinkColor;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[6]/label/div/div[1]/div")
    WebElement selectYellowColor;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[7]/label/div/div[1]/div")
    WebElement selectWhiteColor;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[8]/label/div/div[1]/div")
    WebElement selectOrangeColor;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[9]/label/div/div[1]/div")
    WebElement selectBrownColor;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div/div[2]/div[3]/div/div[2]/div/span/div/div[10]/label/div/div[1]/div")
    WebElement selectGreyColor;

    @FindBy(xpath = "(//*[@class='appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel'])[1]")
    WebElement backButton;

    @FindBy(xpath = "(//*[@class='appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel'])[2]")
    WebElement nextButton;


    public Page2(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    public void setFavoriteMovies() throws FileNotFoundException {
        inputRandomMovie.sendKeys(RandomListHelper.getRandomList(),Keys.ENTER);
        inputRandomMovie.sendKeys(RandomListHelper.getRandomList(),Keys.ENTER);
        inputRandomMovie.sendKeys(RandomListHelper.getRandomList());
    }
    public WebElement setFavoriteColor() throws InterruptedException {
        String color = new TestBase().prop.getProperty("color");
        log.info("Selecting the favorite color... ");
        Thread.sleep(2000);
        WebElement result = null;
        switch (color){
            case "Red":
                log.info("Red color selected");
                selectRedColor.click();
                result = selectRedColor;
                break;
            case "Blue":
                log.info("Blue color selected");
                selectBlueColor.click();
                result =selectBlueColor;
                break;
            case "Green":
                log.info("Green color selected");
                selectGreenColor.click();
                result =selectGreenColor;
                break;
            case "Black":
                log.info("Black color selected");
                selectBlackColor.click();
                result =selectBlackColor;
                break;
            case "Pink":
                log.info("Pink color selected");
                selectPinkColor.click();
                result =selectPinkColor;
                break;
            case "Yellow":
                log.info("Yellow color selected");
                selectYellowColor.click();
                result =selectYellowColor;
                break;
            case "White":
                log.info("White color selected");
                selectWhiteColor.click();
                result =selectWhiteColor;
                break;
            case "Orange":
                log.info("Orange color selected");
                selectOrangeColor.click();
                 result =selectOrangeColor;
                break;
            case "Brown":
                log.info("Brown color selected");
                selectBrownColor.click();
                result =selectBrownColor;
                break;
            case "Grey":
                log.info("Grey color selected");
                selectGreyColor.click();
                result =selectGreyColor;
                break;
            default:
                log.info("No color found");
                break;
        }
        return result;
    }
    public void clickBackButton() {
        backButton.click();
    }
    public void clickNextButton(){
        nextButton.click();
    }
    public void getMovies() throws FileNotFoundException {
        String movies = inputRandomMovie.getText();
        if(movies.isBlank()){
            log.info("Movies field is empty, re-entering the movies");
            inputRandomMovie.clear();
            setFavoriteMovies();
        }
        else {
            log.info("Movies in field are ---> "+ inputRandomMovie.getText());
        }
    }
    public void getColor() throws InterruptedException {
        new JavaScriptHelper(driver).scrollToElement(setFavoriteColor());
        Thread.sleep(1000);
        String str = setFavoriteColor().getAttribute("aria-checked");
        System.out.println(str);
        if(str.equals("true")){
            log.info("Color already selected....");
        }
        else{
            log.info("Color not selected hence selecting one ...");
            setFavoriteColor().click();
        }
    }
}
