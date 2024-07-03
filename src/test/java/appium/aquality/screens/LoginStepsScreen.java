package appium.aquality.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.*;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class LoginStepsScreen extends Screen {
    private static final String NAME = "Welcome back screen";
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private By searchField = By.id("org.joinmastodon.android:id/search_edit");
    private By loginMastodon = By.xpath("//android.widget.RelativeLayout");
    private By nextElement = By.id("org.joinmastodon.android:id/btn_next");
    private By authorizeElement = By.xpath("//android.widget.Button[@text=\"Authorize\"]");

    private ITextBox searchInputField = elementFactory.getTextBox(searchField, "Search input");
    private ILabel loginMastodonElement = elementFactory.getLabel(loginMastodon, "Mastodon social element");
    private IButton nextBtn = elementFactory.getButton(nextElement, "Next button");
    private IButton authorizeBtn = elementFactory.getButton(authorizeElement, "Authorize button");

    public LoginStepsScreen(){
        super(By.xpath("//android.widget.TextView[@text=\"Welcome back\"]"), NAME);
    }

    public void inputText(String text){
        searchInputField.clearAndType(text);
    }
    public void clickMastodonSocial(){
        loginMastodonElement.click();
    }
    public void clickNextBtn(){
        nextBtn.click();
    }
    public void clickAuthorizeBtn(){
        authorizeBtn.click();
    }
}
