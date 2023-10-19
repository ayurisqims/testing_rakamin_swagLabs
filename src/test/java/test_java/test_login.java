package test_java;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;

public class test_login {
    @Test
    public void main() {

        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        String csvDir = System.getProperty("user.dir")+"/src/test/data/data-test.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvDir))) {
            String[] nextline;

            while ((nextline = reader.readNext()) != null) {
                String username = nextline[0];
                String password = nextline[1];
                String status = nextline[2];

                driver = new ChromeDriver(opt);
                driver.manage().window().maximize();
                driver.get(baseUrl);

                driver.findElement(By.id("user-name")).sendKeys(username);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.id("login-button")).click();

                if (status.equals("success")) { //sukses login
                    driver.findElement(By.id("react-burger-menu-btn"));

                } else { //assert error
                   driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
                }
            }
        }  catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
