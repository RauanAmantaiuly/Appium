package appium.screens;

import aquality.appium.mobile.screens.Screen;

import java.util.HashMap;
import java.util.Map;

public class ScreenFactory {
    private static final Map<Class<? extends Screen>, Screen> screens = new HashMap<>();

    public static <T extends Screen> T getScreen(Class<T> screenClass) {
        if (!screens.containsKey(screenClass)) {
            try {
                T screen = screenClass.getDeclaredConstructor().newInstance();
                screens.put(screenClass, screen);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create screen: " + screenClass.getName(), e);
            }
        }
        return screenClass.cast(screens.get(screenClass));
    }
}


