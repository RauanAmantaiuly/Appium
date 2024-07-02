package appium.aquality.tests;

import appium.aquality.screens.WelcomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkTwo extends BaseTest {

    @Test
    public void searchingForItems() {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        Assert.assertTrue(welcomeScreen.state().waitForDisplayed(), "Welcome screen is not displayed on app launch");

        application.terminate("org.joinmastodon.android");
//        Assert.assertFalse(application.isStarted(), "App is still running after termination");

        application.activate("org.joinmastodon.android");
        Assert.assertTrue(application.isStarted(), "App did not restart");

        Assert.assertTrue(welcomeScreen.state().waitForDisplayed(), "Welcome screen is not displayed after reopening the app");
    }
}
