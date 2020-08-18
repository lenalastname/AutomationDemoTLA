package tests;

import base.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.lang.reflect.Method;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void localSetUp(Method method, ITestResult result){
        setUp(method, result);
        homePage = new HomePage(getDriver());
    }

    @Test
    public void verifyTitle(){
        extentTest.log(LogStatus.INFO, "Verifying title of Home Page");
        screenshot.takeScreenshotAndLog();
        Assert.assertEquals(getDriver().getTitle(), "TLA Automation");
    }

    @Test(description = "Verifying all navigation buttons are present")
    public void verifyNavButtons(){
        screenshot.takeScreenshotAndLog();
        for (String button: homePage.navButtons){
            Assert.assertTrue(getDriver().findElement(By.linkText(button)).isDisplayed());
            extentTest.log(LogStatus.PASS, "Tested button: " + button.toUpperCase() + " - with success");
        }
    }


    }

