package appium.screens;

public class ScreenFactory {

    public static WelcomeScreen getWelcomeScreen() {
        return new WelcomeScreen();
    }

    public static LoginStepsScreen getLoginStepsScreen() {
        return new LoginStepsScreen();
    }

    public static HomeScreen getHomeScreen() {
        return new HomeScreen();
    }

    public static ExploreScreen getExploreScreen() {
        return new ExploreScreen();
    }
}

