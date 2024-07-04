package appium.aquality.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.IElementFactory;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class ExploreScreen extends Screen {
    private static final String NAME = "Explore screen";
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private By exploreTab = By.id("org.joinmastodon.android:id/tab_search");
    private By firstPost = By.id("org.joinmastodon.android:id/name");
    private By postForm = By.className("android.widget.RelativeLayout");
    private By goToSearch = By.id("org.joinmastodon.android:id/search_text");
    private By searchField = By.className("android.widget.EditText");
//    //android.widget.EditText[@text="Search Mastodon"]

    private IButton exploreTabBtn = elementFactory.getButton(exploreTab, "Explore tab");
    private ILabel firstPostLbl = elementFactory.getLabel(firstPost, "First Post");
    private ILabel postFormLbl = elementFactory.getLabel(postForm, "Post form");
    private ITextBox searchTextBox = elementFactory.getTextBox(searchField, "Search field");
    private ITextBox goToSearchTextBox = elementFactory.getTextBox(goToSearch, "Go to input in search");

    public ExploreScreen(){
        super(By.xpath("//android.widget.LinearLayout[@content-desc=\"Posts\"]"), NAME);
    }
    public void clickExploreTab(){
        exploreTabBtn.click();
    }
    public void clickFirstPost(){
        firstPostLbl.click();
    }
    public boolean isFirstPostOpened(){
        return firstPostLbl.getText().contains(firstPostLbl.getText());
    }
    public boolean isPostDisplayed(){
        return postFormLbl.state().waitForDisplayed();
    }
    public String getPositionOfSearchField(){
        int x = goToSearchTextBox.getElement().getLocation().getX();
        int y = goToSearchTextBox.getElement().getLocation().getY();
        String position = x + ":" + y;
        return position;
    }
    public void clickSearchField(){
        goToSearchTextBox.click();
    }
    public boolean isSearchFieldDisplayed(){
        return searchTextBox.state().waitForDisplayed();
    }
    public void sendTextToSearchField(String s){
        searchTextBox.clearAndType(s);
    }
    public String getTextFromSearchField(){
        return searchTextBox.getText();
    }
    public void clearSearchField(){
        searchTextBox.clear();
    }
}
