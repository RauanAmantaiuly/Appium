package appium.screens;

import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.*;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ExploreScreen extends Screen {
    private static final String NAME = "Explore screen";
    private IElementFactory elementFactory = AqualityServices.getElementFactory();
    private By exploreTab = By.id("org.joinmastodon.android:id/tab_search");
    private By postForm = By.className("android.widget.RelativeLayout");
    private By goToSearch = By.id("org.joinmastodon.android:id/search_text");
    private By searchField = By.className("android.widget.EditText");
    private By firstPostAfterSearch = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.joinmastodon.android:id/list\"]/android.widget.RelativeLayout[1]");
    private By accCoverLocator = By.id("org.joinmastodon.android:id/cover");

    private IButton exploreTabBtn = elementFactory.getButton(exploreTab, "Explore tab");
    private ILabel postFormLbl = elementFactory.getLabel(postForm, "Post form");
    private ITextBox searchTextBox = elementFactory.getTextBox(searchField, "Search field");
    private ITextBox goToSearchTextBox = elementFactory.getTextBox(goToSearch, "Go to input in search");
    private ILabel firstPostAfterSearchLbl = elementFactory.getLabel(firstPostAfterSearch, "First post after search");
    private ILabel accCover = elementFactory.getLabel(accCoverLocator, "Account cover");

    public ExploreScreen(){
        super(By.xpath("//android.widget.LinearLayout[@content-desc=\"Posts\"]"), NAME);
    }
    public void clickExploreTab(){
        exploreTabBtn.click();
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
    public void sendTextToSearchField(String s){
        searchTextBox.clearAndType(s);
    }
    public void clickFirstPost(){
        firstPostAfterSearchLbl.click();
    }
    public void scrollToPostInProfile(int index){
        accCover.getTouchActions().scrollToElement(SwipeDirection.UP);
        Assert.assertTrue(accCover.state().isDisplayed(), "Account cover is not displayed");
        int cnt=0;
        while(cnt!=index){
            postFormLbl.getTouchActions().scrollToElement(SwipeDirection.DOWN);
            cnt++;
        }
    }
}