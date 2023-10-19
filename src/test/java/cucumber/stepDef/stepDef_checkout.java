package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDef_checkout {
    WebDriver driver = new ChromeDriver();
    String baseUrl = "https://www.saucedemo.com/";

    stepDef_addCart addCart = new stepDef_addCart();

    @Given("success add product")
    public void success_add_product(){
        addCart.success_login_web();
        addCart.click_add_to_cart_jacket();
        addCart.click_cart();
    }
    @When("click btn checkout")
    public void click_btn_checkout(){
        driver.findElement(By.xpath("xpath=//button[@id='checkout']")).click();
    }
    @And("input checkout information")
    public void input_checkout_information(){
        driver.findElement(By.id("first-name")).sendKeys("Mahalini");
        driver.findElement(By.id("last-name")).sendKeys("Kusumanegata");
        driver.findElement(By.id("postal-code")).sendKeys("20110");
    }
    @And("click btn continue")
    public void click_btn_continue(){
        driver.findElement(By.id("continue")).click();
    }
    @Then("open checkout overview page")
    public void open_checkout_overview_page(){
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    }
}
