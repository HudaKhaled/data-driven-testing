import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class loginPage {

    WebDriver driver;

    By emailText = By.id("email_create");
    By createAccount = By.id("SubmitCreate");
    By emailLogin = By.id("email");
    By passwordLogin = By.id("passwd");
    By loginBtn = By.id("SubmitLogin");

    public loginPage(WebDriver driver)
    {this.driver=driver;}

    public void login(String Email, String pwsrd)
    {
        mainPage.setTextElementText(driver.findElement(emailLogin) , Email);
        mainPage.setTextElementText(driver.findElement(passwordLogin) , pwsrd);
        mainPage.clickButton(driver.findElement(loginBtn));
    }


    public void EnterEMailAndRegister(String EMail)
    {
        mainPage.setTextElementText(driver.findElement(emailText) , EMail);
        mainPage.clickButton(driver.findElement(createAccount));
    }
}