package com.metlife.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private By headerLocator=By.xpath("//h6[contains(normalize-space(),'Dash')]");

    private WebDriver driver;

    public DashboardPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public String getDashboardHeader()
    {
        return driver.findElement(headerLocator).getText();
    }
}
