package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserMgtPage;

import java.lang.reflect.Method;

public class UserMgtPageTest extends BaseTest {
    HomePage homePage;
    UserMgtPage userMgtPage;


    @BeforeMethod
    public void setUp(Method method, ITestResult iTestResult){
        super.setUp(method, iTestResult);
        homePage = new HomePage(getDriver());
        userMgtPage = new UserMgtPage(getDriver());
    }

    @Test (description = "Verifying title of User Management Page")
    public void verifyTitle(){
        homePage.clickNavBtn("User-Mgt");
        Assert.assertEquals(getDriver().getTitle(), "Register New User");

    }


}
