package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDef_addInformation {

    WebDriver driver = new ChromeDriver();
    stepDef_addCart addCart = new stepDef_addCart();
    stepDef_checkout checkout = new stepDef_checkout();

    @Given("success checkout")
    public void success_checkout(){
        addCart.success_login_web();
        checkout.success_add_product();
        checkout.click_btn_checkout();
    }

    @When("input_checkout_information")
    public void input_checkout_information(){
        driver.findElement(By.id("first-name")).sendKeys("Mahalini");
        driver.findElement(By.id("last-name")).sendKeys("Kusumanegata");
        driver.findElement(By.id("postal-code")).sendKeys("20110");
    }

    @And("click_btn_continue")
    public void click_btn_continue(){
        driver.findElement(By.id("continue")).click();
    }

    @Then("open checkout overview page")
    public void open_checkout_overview_page(){
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    }

    @Then("open error message First Name is required")
    public void open_error_message_First_Name_is_required(){
        driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3"));
    }

}
