package lesson02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPage {
    private WebDriver driver;
    private LoginPage login;
    private final String expectedMessage="You Are Logged in";

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://atidcollege.co.il/Xamples/demo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        login= PageFactory.initElements(driver,LoginPage.class);
        DB.initSQLConnection();
    }

    @Test()
    public void Test01() throws InterruptedException {
        login.signIn(DB.getCredentials().get(0),DB.getCredentials().get(1));
        Assert.assertEquals(login.getMessage(), expectedMessage);
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        DB.closeDBCon();
    }

}
