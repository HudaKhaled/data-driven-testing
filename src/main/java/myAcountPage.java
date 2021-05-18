import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class myAcountPage<address> {

    WebDriver driver;




        By radioButtonMrs = By.id("id_gender2");

        By customerfirstName = By.id("customer_firstname");
        By customerlastName = By.id("customer_lastname");
        By email = By.id("email");
        By Password = By.id("passwd");
        By firstName = By.id("firstname");
        By lastName = By.id("lastname");
        By Company = By.id("company");

        By address1 = By.id("address1");
        By city = By.id("city");
        By stateddl = By.id("id_state");
        By zipCode = By.id("postcode");
        // uniform-id_state   ddl
        By countryddl = By.id("id_country");
        //    id_country ddl
        By mobile = By.id("phone_mobile");
        By aliasAddress = By.id("alias");
        By register = By.id("submitAccount");
        By signOut = By.cssSelector("a.logout");

    public myAcountPage(WebDriver driver) {
        this.driver = driver;}

    /*public void fillDetails(String customerFirstName , String customerLastName ,
                            String Email , String password, String FN ,String LN, String company ,
                            String address , String City , String Zipcode ,
                            String Mobile , String AliasAddress)
    {
        mainPage.clickButton(driver.findElement(radioButtonMrs) );
        mainPage.setTextElementText(driver.findElement(customerfirstName), customerFirstName);
        mainPage.setTextElementText(driver.findElement(customerlastName), customerLastName);
        mainPage.setTextElementText(driver.findElement(email) , Email);
        mainPage.setTextElementText(driver.findElement(Password), password);
        mainPage.setTextElementText(driver.findElement(firstName) , FN);
        mainPage.setTextElementText(driver.findElement(lastName), LN);
        mainPage.setTextElementText(driver.findElement(Company), company);
        mainPage.setTextElementText(driver.findElement(address1), address);
        mainPage.setTextElementText(driver.findElement(city), City);

        mainPage.selectDDL(driver.findElement(stateddl));
        mainPage.setTextElementText(driver.findElement(zipCode),Zipcode);
        mainPage.selectDDL(driver.findElement(countryddl));

        mainPage.setTextElementText(driver.findElement(mobile), Mobile);
        mainPage.setTextElementText(driver.findElement(aliasAddress), AliasAddress);
        mainPage.clickButton(driver.findElement( register));





    }*/

    public void fillDetails(String customerFirstName , String customerLastName, String state)
    {
        mainPage.setTextElementText(driver.findElement(customerfirstName), customerFirstName);
        mainPage.setTextElementText(driver.findElement(customerlastName), customerLastName);
        mainPage.setTextElementText(driver.findElement(stateddl), state);

    }


    public void logOut()
    {
        mainPage.clickButton(driver.findElement( signOut));

    }
    {

    }
    }


