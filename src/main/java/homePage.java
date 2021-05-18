
import org.openqa.selenium.By;

import  org.openqa.selenium.By.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {

    WebDriver driver;
By loginButton =  By.cssSelector("a.login");

public homePage(WebDriver driver)
{this.driver=driver;}

    public void GoToLoginPage()
    {
        mainPage.clickButton(driver.findElement(loginButton) );
    }
{

}
}
