package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDef_addCart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("success login web")
    public void success_login_web() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("react-burger-menu-btn"));
    }

    @When("click add to cart")
    public void click_add_to_cart() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("click add to cart jacket")
    public void click_add_to_cart_jacket() {
        driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    @And("click cart")
    public void click_cart(){
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Then("open your cart page")
    public void open_your_cart_page(){
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]"));
    }

}
