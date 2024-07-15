package appium.screens;

import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class HomeScreen extends Screen {
    private static final String NAME = "Home screen";

    public HomeScreen(){
        super(By.xpath("(//android.widget.TextView[@text=\"Home\"])[1]"), NAME);
    }
}
