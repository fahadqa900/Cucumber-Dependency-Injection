package com.metlife.steps;

import com.metlife.base.AutomationWrapper;
import com.metlife.pages.DashboardPage;
import com.metlife.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Demo1Steps {

    private AutomationWrapper wrapper;
    private LoginPage login;
    private DashboardPage dashboard;
    public Demo1Steps(AutomationWrapper wrapper)
    {
        this.wrapper=wrapper;
    }




    @Given("I have browser with orangeHRM application")
    public void i_have_browser_with_orange_hrm_application() {
        //write code for launch browser
        wrapper.driver=new ChromeDriver();
        wrapper.driver.manage().window().maximize();
        wrapper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wrapper.driver.get("https://opensource-demo.orangehrmlive.com/");
        initPageObject();
    }
    public void initPageObject()
    {
        login=new LoginPage(wrapper.driver);
        dashboard=new DashboardPage(wrapper.driver);
    }

    @When("I type username as {string}")
    @When("I enter username as {string}")
    public void i_enter_username_as(String username) {
//       wrapper.driver.findElement(By.name("username")).sendKeys(username);
        login.enterUsername(username);
    }

    @When("I enter password as {string}")
    public void i_enter_password_as(String password) {
//        wrapper.driver.findElement(By.name("password")).sendKeys(password);
        login.enterPassword(password);
    }
    @When("I click on login")
    public void i_click_on_login() {
//            wrapper.driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        login.clickOnLogin();
    }
    @Then("I should access to the portal with header as {string}")
    public void i_should_access_to_the_portal_with_header_as(String expectedHeader) {
//        System.out.println(expectedHeader);
        String actualHeader=dashboard.getDashboardHeader();
        Assert.assertEquals(actualHeader,expectedHeader);
    }

    @Then("I should not get access to the portal with error {string}")
    public void i_should_not_get_access_to_the_portal_with_error(String expected_error) {
//        System.out.println(expected_error);
//        assert the error - "Invalid credentials"
       String actualError=login.getInvalidErrorMessage();
       Assert.assertEquals(actualError,expected_error);
    }

}
