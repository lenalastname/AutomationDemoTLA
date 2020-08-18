package tests;

import base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.UserMgtPage;

import java.lang.reflect.Method;

public class UserMgtPageTest extends BaseTest {
    HomePage homePage;
    UserMgtPage userMgtPage;
    CommonPage commonPage;


    @BeforeMethod
    public void setUp(Method method, ITestResult iTestResult){
        super.setUp(method, iTestResult);
        homePage = new HomePage(getDriver());
        userMgtPage = new UserMgtPage(getDriver());
        commonPage = new CommonPage(getDriver());
    }

    @Test (description = "Verifying title of User Management Page")
    public void verifyTitle(){
        homePage.clickNavBtn("User-Mgt");
        Assert.assertEquals(getDriver().getTitle(), "Register New User");
        screenshot.takeScreenshotAndLog();
    }

    @Test (description = "Validating <Login> and <Access DB> buttons")
    public void verifyLoginAccessDB_buttons(){
        homePage.clickNavBtn("User-Mgt");
        Assert.assertTrue(userMgtPage.accessDbBtn.isDisplayed());
        Assert.assertTrue((userMgtPage.loginBtn.isDisplayed()));
        screenshot.takeScreenshotAndLog();
    }

    @Test (description = "Testing Registration Form fields")
    public void verifyRgtForm(){
        homePage.clickNavBtn("User-Mgt");
        for (String field: userMgtPage.registrationFormFields){
            Assert.assertTrue(commonPage.findById(field).isDisplayed());
            extentTest.log(LogStatus.PASS, commonPage.findById(field).getAttribute("name") + " - was displayed");
        }
        screenshot.takeScreenshotAndLog();
    }

}
