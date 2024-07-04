package appium.aquality.tests;

import appium.aquality.screens.*;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.configuration.IDriverSettings;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkTwo extends BaseTest {
    WelcomeScreen welcomeScreen = ScreenFactory.getWelcomeScreen();
    LoginStepsScreen loginStepsScreen = ScreenFactory.getLoginStepsScreen();
    HomeScreen homeScreen = ScreenFactory.getHomeScreen();
    ExploreScreen exploreScreen = ScreenFactory.getExploreScreen();

    public void loginAndOpenExploreTab(){
        String mastodonSocialText = "mastodon.social";
        Assert.assertTrue(welcomeScreen.isLoginBtnDispalyed(), "Welcome screen is not displayed on app launch");

        application.terminate("org.joinmastodon.android");

        application.activate("org.joinmastodon.android");
        Assert.assertTrue(welcomeScreen.isLoginBtnDispalyed(), "Welcome screen is not displayed on app launch");

        welcomeScreen.clickLoginBtn();
        loginStepsScreen.inputText(mastodonSocialText);
        loginStepsScreen.clickMastodonSocial();
        loginStepsScreen.clickNextBtn();
        loginStepsScreen.clickAuthorizeBtn();
        Assert.assertTrue(homeScreen.state().waitForDisplayed(), "Home screen is not opened");

        exploreScreen.clickExploreTab();
        Assert.assertTrue(exploreScreen.state().waitForDisplayed(), "Posts screen is not displayed");
    }

    @Test
    public void searchingForItems() {
        loginAndOpenExploreTab();

        exploreScreen.clickFirstPost();
        Assert.assertTrue(exploreScreen.isFirstPostOpened(), "First post is not opened");
    }

    @Test
    public void interactionWithElements(){
        loginAndOpenExploreTab();

        Assert.assertTrue(exploreScreen.isPostDisplayed(), "Posts are displayed");

        String positionSearchField = exploreScreen.getPositionOfSearchField();
        Assert.assertTrue(!positionSearchField.equals("0:0"));

        String text = "tests";
        exploreScreen.clickSearchField();
        if (exploreScreen.isSearchFieldDisplayed()) {
            exploreScreen.sendTextToSearchField(text);
            Assert.assertTrue(exploreScreen.getTextFromSearchField().contains(text));

            exploreScreen.clearSearchField();
            Assert.assertTrue(exploreScreen.getTextFromSearchField().contains("Search Mastodon"));
        }
    }
    @Test
    public void keyboardProcessing(){
        loginAndOpenExploreTab();

        exploreScreen.clickSearchField();
        boolean flag = false;
        ((PressesKey) AqualityServices.getApplication().getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
