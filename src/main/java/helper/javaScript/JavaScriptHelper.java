package helper.javaScript;

import helper.logger.LoggerHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class JavaScriptHelper {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

    public JavaScriptHelper(WebDriver driver){
        this.driver = driver;
        log.info("JavaScriptHelper initialized");
    }

   //Methods to handle scrolling on web page
    public Object executeScript(String script){
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        return exe.executeScript(script);
    }
    public Object executeScript(String script, Object...args) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script, args);
    }
    public void scrollToElement(WebElement element){
        log.info("Scroll to webelement "+ element.toString());
        executeScript("window.scrollTo(arguments[0], arguments[1])", element.getLocation().x,element.getLocation().y);
    }
    public void scrollToBottom(){
        log.info("scrolling to the bottom of the page");
        executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void scrollToTop(){
        executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        log.info("scrolling to the top of the page");
    }
}
