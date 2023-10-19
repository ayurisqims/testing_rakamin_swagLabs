import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test_data {
    @Test
    public void main(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        ChromeOptions opt = new ChromeOptions();
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println(title);

        // Field Username
        WebElement txt_username = driver.findElement(By.id("user-name"));
        txt_username.click();
        txt_username.sendKeys("standard_user");
        txt_username.getText();

        // Field Password
        WebElement txt_password = driver.findElement(By.id("password"));
        txt_password.click();
        txt_password.sendKeys("secret_sauce");
        txt_password.getText();

        WebElement btn_login = driver.findElement(By.id("login-button"));
        btn_login.isDisplayed();
        btn_login.click();

        // driver.close();


    }

}
