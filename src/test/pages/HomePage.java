package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String[] navButtons = {"Home", "Inputs", "Selectors", "Select-class", "Alert", "Pop-Up", "Multiple-window",
            "Tables", "Calendar", "iFrames", "Action-class", "JS-Executor", "Synchronization", "Files", "User-Mgt"};


//    @FindBy(xpath = "//a[text()='User-Mgt']")
//    public WebElement userMgtBtn;
    // Instead of creating xpath for each element(15 items), we can create a method:

    public void clickNavBtn(String buttonName){
        click(driver.findElement(By.linkText(buttonName)));
    }

}
