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

public class test_checkout {
    @Test
    public void main(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        String csvDir = System.getProperty("user.dir")+"/src/test/data/data-test.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvDir))) {
            String[] nextline;

            while ((nextline = reader.readNext()) != null) {
                String firstName = nextline[0];
                String lastName = nextline[1];
             //   String zip = nextline[2];
                String status = nextline[2];

                driver = new ChromeDriver(opt);
                driver.manage().window().maximize();
                driver.get(baseUrl);

                driver.findElement(By.id("user-name")).sendKeys("standard_user");
                driver.findElement(By.id("password")).sendKeys("secret_sauce");
                driver.findElement(By.id("login-button")).click();
                driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
                driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
                driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
                driver.findElement(By.id("checkout")).click();
                driver.findElement(By.id("first-name")).sendKeys(firstName);
                driver.findElement(By.id("last-name")).sendKeys(lastName);
               // driver.findElement(By.id("postal-code")).sendKeys(zip);
                driver.findElement(By.id("continue")).click();
                driver.findElement(By.id("finish")).click();

                if (status.equals("success")) {
                    driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));

                } else { //assert error
                    driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]"));
                }
            }
        }  catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }
}
