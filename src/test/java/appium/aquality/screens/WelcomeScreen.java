package appium.aquality.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class WelcomeScreen extends Screen {
    private static final String NAME = "Welcome Screen";
    private By login = By.id("org.joinmastodon.android:id/btn_log_in");
    private IButton loginBtn = AqualityServices.getElementFactory().getButton(login, "Login button");

    public WelcomeScreen(){
        super(By.id("org.joinmastodon.android:id/art_clouds"), NAME);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }


}
