import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testLoginUsingJSON {
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


    @Test (dataProvider = "dataLogin")
    public void logTest(String data)
    {
        String users[] = data.split(",");
        HomeP = new homePage(driver);
        HomeP.GoToLoginPage();
        LoginP = new loginPage(driver);
        LoginP.login(users[0], users[1]);
        AccountP = new myAcountPage(driver);


    }

   @AfterMethod
    public void quitDriver()
    {
        driver.quit();
    }




    @DataProvider (name="dataLogin")
    public Object[] readJson() throws Exception {
        List<List<String>> cerdintials = new ArrayList<>();
        List<String > tempCred = new ArrayList<>();
             JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(".\\src\\test\\Data\\jsonLogin.json");
        Object obj = jsonParser.parse(reader);

        JSONObject userloginObj = (JSONObject) obj;

        JSONArray userloginArr  = (JSONArray)userloginObj.get("userlogin") ;

        String arr [] = new String [userloginArr.size()] ;

        for (int i =0; i<userloginArr.size(); i++)
        {
            JSONObject userlog = (JSONObject) userloginArr.get(i);
            String un = (String) userlog.get("username");
            String pw = (String) userlog.get("password");
            tempCred.add( (String) userlog.get("username"));
            tempCred.add( (String) userlog.get("password"));
            cerdintials.add(tempCred);


            arr[i] = un +","+ pw ;
        }
        return arr;
    }
}