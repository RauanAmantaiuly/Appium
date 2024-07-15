package appium.tests;

import appium.screens.*;
import appium.utils.JsonUtils;
import appium.utils.SettingsUtils;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class InteractionWithElements extends BaseTest {

    WelcomeScreen welcomeScreen = ScreenFactory.getScreen(WelcomeScreen.class);
    LoginStepsScreen loginStepsScreen = ScreenFactory.getScreen(LoginStepsScreen.class);
    HomeScreen homeScreen = ScreenFactory.getScreen(HomeScreen.class);
    ExploreScreen exploreScreen = ScreenFactory.getScreen(ExploreScreen.class);

    @DataProvider(name = "jsonDataProvider")
    public Object[][] jsonDataProvider() throws IOException {
        String filePath = "src/test/resources/test_data/text_to_search.json";
        JsonNode jsonNode = JsonUtils.readJsonFile(filePath);
        String stringValue = jsonNode.get("string").asText();
        return new Object[][]{{stringValue}};
    }

    @Test(dataProvider = "jsonDataProvider")
    public void interactionWithElements(String text) throws IOException{
        String mastodonSocialText = JsonUtils.getConfigValue("mastodonSocialText");
        Assert.assertTrue(welcomeScreen.isLoginBtnDisplayed(), "Welcome screen is not displayed on app launch");

        application.terminate();

        application.activate(SettingsUtils.getAppPackage());
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

        exploreScreen.clickSearchField();
        exploreScreen.sendTextToSearchField(text);

        exploreScreen.clickFirstPost();

        exploreScreen.scrollToPostInProfile(4);
    }
}
