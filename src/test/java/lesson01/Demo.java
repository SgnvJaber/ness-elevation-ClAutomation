package lesson01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {
    WebDriver driver;
    String expectedTitleName="IMDb- Movies,TV and Celebritites -";
    String expectedUrlAdress="http://www.imdb.com";

    @BeforeClass
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://imdb.com");
    }
    @Test
    public void test01()
    {
        System.out.println("hello");
    }

    @AfterClass
    public void Close()
    {
        driver.close();
    }
}
