package appium.tests;

import appium.screens.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchingForItems extends BaseTest{

    WelcomeScreen welcomeScreen = ScreenFactory.getWelcomeScreen();
    LoginStepsScreen loginStepsScreen = ScreenFactory.getLoginStepsScreen();
    HomeScreen homeScreen = ScreenFactory.getHomeScreen();
    ExploreScreen exploreScreen = ScreenFactory.getExploreScreen();

    @Test
    public void searchForItems() {
        String mastodonSocialText = "mastodon.social";
        Assert.assertTrue(welcomeScreen.isLoginBtnDisplayed(), "Welcome screen is not displayed on app launch");

        application.terminate("org.joinmastodon.android");

        application.activate("org.joinmastodon.android");
        Assert.assertTrue(welcomeScreen.isLoginBtnDisplayed(), "Welcome screen is not displayed on app launch");

        welcomeScreen.clickLoginBtn();
        loginStepsScreen.inputText(mastodonSocialText);
        loginStepsScreen.clickMastodonSocial();
        loginStepsScreen.clickNextBtn();
        loginStepsScreen.clickAuthorizeBtn();
        Assert.assertTrue(homeScreen.state().waitForDisplayed(), "Home screen is not opened");

        exploreScreen.clickExploreTab();
        Assert.assertTrue(exploreScreen.state().waitForDisplayed(), "Posts screen is not displayed");

        exploreScreen.clickFirstPost();
        Assert.assertTrue(exploreScreen.isFirstPostOpened(), "First post is not opened");
    }
}
