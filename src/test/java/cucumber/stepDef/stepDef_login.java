package cucumber.stepDef;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDef_login {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user open login page")
    public void user_open_login_page() {

        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @When("input username")
    public void input_username(){
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
    }

    @And("input password")
    public void input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click btn login")
    public void click_btn_login(){
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user in on dashboard page")
    public void user_in_on_dashboard_page() {
        driver.findElement(By.id("react-burger-menu-btn"));

    }

    @Given("open login page")
    public void open_login_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("input unregistered username")
    public void input_unregistered_username() {
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user1");
    }

    @And("input unregistered password")
    public void input_unregistered_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce1");
    }

    @Then("open error message")
    public void open_error_message() {
        driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"));
    }
}
