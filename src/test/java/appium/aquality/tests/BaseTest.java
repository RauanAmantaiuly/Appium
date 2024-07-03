package appium.aquality.tests;

import aquality.appium.mobile.application.IMobileApplication;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected IMobileApplication application;

    @BeforeMethod
    public void setUp() {
        application = AqualityServices.getApplication();
    }

    @AfterMethod
    public void tearDown() {
        if (application != null) {
            application.quit();
        }
    }
}
