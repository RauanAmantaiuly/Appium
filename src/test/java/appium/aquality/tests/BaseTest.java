package appium.aquality.tests;

import aquality.appium.mobile.application.IMobileApplication;
import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected IMobileApplication application;

    @BeforeClass
    public void setUp() {
        application = AqualityServices.getApplication();
    }

    @AfterClass
    public void tearDown() {
        if (application != null) {
            application.quit();
        }
    }
}
