import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class testLoginUsingExcel {
    WebDriver driver;
    homePage HomeP;
    loginPage LoginP;
    myAcountPage AccountP;

    @BeforeMethod
    public void intalization() {
        //  WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers1/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test(dataProvider = "dataLoginExcel")
    public void loginTestExcel(String email, String pw)
    {

        HomeP = new homePage(driver);
        HomeP.GoToLoginPage();
        LoginP = new loginPage(driver);
        LoginP.login(email, pw);
        AccountP = new myAcountPage(driver);
      //System.out.println(email +" "+ pw);
      String expectedRes = "My account - My Store";
      String actualRes = driver.getTitle();
        Assert.assertEquals(actualRes, expectedRes, "tc failed");

    }

    @AfterMethod
    public void quitDriver()
    {
        driver.quit();
    }


    @DataProvider(name="dataLoginExcel")
    public Object[][] excelDataProvider() throws Exception {
Object data[][] = excelReader.getDataFromExcel(0);
return  data;
    }

}
