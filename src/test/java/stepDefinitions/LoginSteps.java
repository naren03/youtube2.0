package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginSteps {
    private WebDriver driver;

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        driver.get("https://www.example-ecommerce.com");
    }

    @Then("I should see a prominently displayed login button")
    public void i_should_see_a_prominently_displayed_login_button() {
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @Given("I am on any page of the e-commerce website")
    public void i_am_on_any_page_of_the_e_commerce_website() {
        driver.get("https://www.example-ecommerce.com/somepage");
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("I should see a modal with the login form")
    public void i_should_see_a_modal_with_the_login_form() {
        WebElement loginModal = driver.findElement(By.id("loginModal"));
        Assert.assertTrue(loginModal.isDisplayed());
    }

    @Then("the login form should include fields for email/username and password")
    public void the_login_form_should_include_fields_for_email_username_and_password() {
        Assert.assertTrue(driver.findElement(By.id("emailField")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("passwordField")).isDisplayed());
    }

    @Then("there should be a \"Forgot Password?\" link")
    public void there_should_be_a_forgot_password_link() {
        Assert.assertTrue(driver.findElement(By.linkText("Forgot Password?")).isDisplayed());
    }

    @Given("I am on the login form")
    public void i_am_on_the_login_form() {
        driver.get("https://www.example-ecommerce.com/login");
    }

    @When("I enter an incorrect email/username and password")
    public void i_enter_an_incorrect_email_username_and_password() {
        driver.findElement(By.id("emailField")).sendKeys("wrong@example.com");
        driver.findElement(By.id("passwordField")).sendKeys("wrongPassword");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        driver.findElement(By.id("submitLogin")).click();
    }

    @Then("I should see an error message indicating invalid credentials")
    public void i_should_see_an_error_message_indicating_invalid_credentials() {
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        Assert.assertEquals("Invalid credentials", errorMessage);
    }

    @When("I enter a valid email/username and password")
    public void i_enter_a_valid_email_username_and_password() {
        driver.findElement(By.id("emailField")).sendKeys("user@example.com");
        driver.findElement(By.id("passwordField")).sendKeys("correctPassword");
    }

    @Then("I should be redirected to my account dashboard")
    public void i_should_be_redirected_to_my_account_dashboard() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.example-ecommerce.com/dashboard", currentUrl);
    }

    @Then("I should see a welcome message")
    public void i_should_see_a_welcome_message() {
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
    }

    @Given("I have successfully logged in")
    public void i_have_successfully_logged_in() {
        i_am_on_the_login_form();
        i_enter_a_valid_email_username_and_password();
        i_click_the_login_button();
    }

    @When("I close the browser and reopen it")
    public void i_close_the_browser_and_reopen_it() {
        driver.quit();
        driver = new ChromeDriver();
        driver.get("https://www.example-ecommerce.com");
    }

    @Then("I should still be logged in unless I log out")
    public void i_should_still_be_logged_in_unless_i_log_out() {
        // Check for session persistence logic here
        Assert.assertTrue(driver.findElement(By.id("logoutButton")).isDisplayed());
    }

    @Given("I am logged into my account")
    public void i_am_logged_into_my_account() {
        i_have_successfully_logged_in();
    }

    @When("I click the logout button")
    public void i_click_the_logout_button() {
        driver.findElement(By.id("logoutButton")).click();
    }

    @Then("I should not be logged in")
    public void i_should_not_be_logged_in() {
        Assert.assertTrue(driver.findElement(By.id("loginButton")).isDisplayed());
    }
}