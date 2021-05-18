

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class mainPage {

    protected WebDriver drvier ;
    public JavascriptExecutor js ;
    public Select select ;


    // create constructor
    public mainPage(WebDriver driver)
    {
        this.drvier = driver;

    }

    protected static void clickButton(WebElement button)
    {
        button.click();
    }

    protected static void setTextElementText(WebElement textElement , String value)
    {
        textElement.sendKeys(value);
    }

    protected static void selectDDL(WebElement element)
    {
        Select s = new Select(element);
        s.selectByIndex(1);
    }
    public void scrollToBottom()

    {
        js.executeScript("scrollBy(0,2500)");
    }

    public void clearText(WebElement element)
    {
        element.clear();
    }



}