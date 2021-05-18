import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testLoginUsingDP {



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


        @Test (dataProvider = "dp")
        public void loginTest(String usrnm, String pswrd) {

            HomeP = new homePage(driver);
            HomeP.GoToLoginPage();
            LoginP = new loginPage(driver);
            LoginP.login(usrnm, pswrd);
            AccountP = new myAcountPage(driver);
            String expectedRes = "My account - My Store";
            String actualRes = driver.getTitle();
            Assert.assertEquals(actualRes, expectedRes, "tc failed");
        }

        @AfterMethod
        public void quitDriver() {
            driver.quit();
        }




    @DataProvider(name="dp")
    public  Object[][] myData()  {
        Object [][] data = new Object[3][2];

        data[0][0] = "huda1@4sale.tech";
        data[0][1] = "123456";

        data[1][0] = "huda2@4sale.tech";
        data[1][1] = "123456";

        data[2][0] = "huda3@4sale.tech";
        data[2][1] = "123456";


        return data;

    }
}
