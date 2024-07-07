package appium.tests;

import appium.screens.*;
import aquality.appium.mobile.actions.SwipeDirection;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InteractionWithElements extends BaseTest{

    WelcomeScreen welcomeScreen = ScreenFactory.getWelcomeScreen();
    LoginStepsScreen loginStepsScreen = ScreenFactory.getLoginStepsScreen();
    HomeScreen homeScreen = ScreenFactory.getHomeScreen();
    ExploreScreen exploreScreen = ScreenFactory.getExploreScreen();

    @Test
    public void interactionWithElements() {
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

        Assert.assertTrue(exploreScreen.isPostDisplayed(), "Posts are displayed");

        String positionSearchField = exploreScreen.getPositionOfSearchField();
        Assert.assertTrue(!positionSearchField.equals("0:0"));

        String text = "tests";
        exploreScreen.clickSearchField();
        exploreScreen.sendTextToSearchField(text);

        exploreScreen.clickFirstPostAfterSearch();

        while (!exploreScreen.isFourthPostDisplayed()) {
            exploreScreen.getElementFourthPost().getTouchActions().scrollToElement(SwipeDirection.DOWN);
        }
        Assert.assertTrue(exploreScreen.isFourthPostDisplayed(), "4th post is not displayed");
    }
}
