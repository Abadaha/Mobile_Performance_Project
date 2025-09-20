package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MessagesPage {
    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public MessagesPage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // 10-second timeout
    }

    // Locators (replace with actual IDs from inspector)
    private By messagingIcon = By.id("com.linkedin.android:id/ad_notification_badge_icon");
    private By conversationList = By.id("com.linkedin.android:id/conversation_list");
    private By conversationItem = By.xpath("//android.widget.FrameLayout[@content-desc='conversation_item']");
    
    private By jobsTab = MobileBy.AndroidUIAutomator(
            "new UiSelector().text(\"Jobs\")");
    private By unreadTab = MobileBy.AndroidUIAutomator(
            "new UiSelector().text(\"Unread\")");
    private By draftsTab = MobileBy.AndroidUIAutomator(
            "new UiSelector().text(\"Drafts\")");
    private By inMailTab = MobileBy.AndroidUIAutomator(
            "new UiSelector().text(\"InMail\")");
    
    
    private By newMessageButton = By.id("com.linkedin.android:id/focused_Inbox_compose_fab_view");
    private By searchInput = By.id("com.linkedin.android:id/msglib_recipient_input");
    private By firstSearchResult = MobileBy.AndroidUIAutomator(
    		"new UiSelector().resourceId(\"com.linkedin.android:id/people_result_container\").instance(0)");
    private By messageInput = By.id("com.linkedin.android:id/messaging_keyboard_text_input_container");
    private By sendButton = By.id("com.linkedin.android:id/keyboard_send_button");
    private By backButton = MobileBy.AccessibilityId("Back");
    
    //private By newMessageButton = By.id("com.linkedin.android:id/new_message_button");
    private By searchBar = By.id("com.linkedin.android:id/pill_inbox_search_box");
    private By searchBarInput = By.id("com.linkedin.android:id/messaging_conversation_search_list_toolbar_edit_text");
    private By firstSearchTextResult = By.id("com.linkedin.android:id/messaging_conversation_list_item_container");
    
    private By outsideTouch = By.id("com.linkedin.android:id/touch_outside");
    private By closeButton = MobileBy.AccessibilityId("Close");
    
    /*private By conversationButton = MobileBy.AccessibilityId(
    	    "Button, Haya Abu Hjeer, You sent a post, 6:53 AM"
    	);*/
    private By conversationButton = MobileBy.AndroidUIAutomator(
    	    "new UiSelector().resourceId(\"com.linkedin.android:id/swipe_action_icon\").instance(0)"
    	);
    private By starTouch = By.id("com.linkedin.android:id/messaging_toolbar_starring_option");
    private By toastMessage = By.xpath("//android.widget.Toast[1]");
    
    private By starToolbarOption = By.id("com.linkedin.android:id/messaging_toolbar_detail_option");
    private By moveToOtherOption = MobileBy.AndroidUIAutomator(
    	    "new UiSelector().text(\"Move to Other\")"
    	);
    private By movedToOtherToast = MobileBy.AndroidUIAutomator(
    	    "new UiSelector().text(\"Successfully moved to Other\")"
    	);
    private By folderChip = By.id("com.linkedin.android:id/messaging_folder_chip");
    private By secondBottomSheetRadioButton = MobileBy.AndroidUIAutomator(
    	    "new UiSelector().resourceId(\"com.linkedin.android:id/bottom_sheet_item_radiobutton\").instance(1)"
    	);
    private By moveToFocusedOption = MobileBy.AndroidUIAutomator(
    	    "new UiSelector().text(\"Move to Focused\")"
    	);
    private By movedToFocusedToast = MobileBy.AndroidUIAutomator(
    	    "new UiSelector().text(\"Successfully moved to Focused\")"
    	);
    
    private By firstBottomSheetRadioButton = MobileBy.AndroidUIAutomator(
    	    "new UiSelector().resourceId(\"com.linkedin.android:id/bottom_sheet_item_radiobutton\").instance(0)"
    	);
    private By tenthButton = MobileBy.AndroidUIAutomator(
    	    "new UiSelector().className(\"android.widget.Button\").instance(9)"
    	);
    // Actions
    public void openMessages() {
        driver.findElement(messagingIcon).click();
    }

    public boolean isConversationListDisplayed() {
        return !driver.findElements(conversationList).isEmpty();
    }

    public List<MobileElement> getAllConversations() {
        return driver.findElements(conversationItem);
    }

    public void openJobsTab() {
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(jobsTab));
        driver.findElement(jobsTab).click();
    }

    public void openUnreadTab() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(unreadTab));
        driver.findElement(unreadTab).click();
    }

    public void openDraftsTab() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(draftsTab));
        driver.findElement(draftsTab).click();
    }

    public void openInMailTab() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(inMailTab));
        driver.findElement(inMailTab).click();
    }

    public void openNewMessageComposer() {
        driver.findElement(newMessageButton).click();
    }

    public void tapSearchBar(){
    	wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        driver.findElement(searchBar).click();
    }

    public void searchConversation(String username){
    	wait.until(ExpectedConditions.visibilityOfElementLocated(searchBarInput));
        driver.findElement(searchBarInput).sendKeys(username);
        // add selection from result
    }
    
    public void selectFirstSearchTextResult() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchTextResult));

        driver.findElement(firstSearchTextResult).click();
    }

    // Stub methods for push + real-time tests
    public boolean isPushNotificationReceived() {
        // TODO: implement device-level check
        return true;
    }

    public boolean isRealTimeMessageDisplayed(String messageText) {
        // TODO: implement live UI update check
        return true;
    }
    
    /** Click on "New Message" button */
    public void clickNewMessageButton() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(newMessageButton));
        driver.findElement(newMessageButton).click();
    }

    /** Type the full name of the connection in search box */
    public void enterConnectionName(String fullName) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));

        driver.findElement(searchInput).sendKeys(fullName);
    }

    /** Select the first search result (connection) */
    public void selectFirstSearchResult() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchResult));

        driver.findElement(firstSearchResult).click();
    }

    /** Type a message in the composer */
    public void typeMessage(String messageText) {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(messageInput));

        driver.findElement(messageInput).sendKeys(messageText);
    }

    /** Click on Send button */
    public void clickSendButton() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(sendButton));

        driver.findElement(sendButton).click();
    }
    
    public void clickBackButton() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(backButton));
        driver.findElement(backButton).click();
    }
    
    public void clickOutsideTouch() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(outsideTouch));
        driver.findElement(outsideTouch).click();
    }
    
    public void clickCloseButton() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
        driver.findElement(closeButton).click();
    }

    public void clickConversationButton() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(conversationButton));
        driver.findElement(conversationButton).click();
    }
    public void clickStarTouch() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(starTouch));
        driver.findElement(starTouch).click();
    }
    
    public void clickStarToolbarOption() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(starToolbarOption));
        driver.findElement(starToolbarOption).click();
    }
    
    public void selectMoveToOtherOption() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(moveToOtherOption));
        driver.findElement(moveToOtherOption).click();
    }
    public String movedToOtherToast() {
        return driver.findElement(movedToOtherToast).getText();
    }
    
    public void clickFolderChip() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(folderChip));
        driver.findElement(folderChip).click();
    }
    public void clickSecondBottomSheetRadioButton() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(secondBottomSheetRadioButton));
        driver.findElement(secondBottomSheetRadioButton).click();
    }
    public void clickmoveToFocusedOption() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(moveToFocusedOption));
        driver.findElement(moveToFocusedOption).click();
    }
    
    public String movedToFocusedToast() {
        return driver.findElement(movedToFocusedToast).getText();
    }
    
    public void clickfirstBottomSheetRadioButton() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(firstBottomSheetRadioButton));
        driver.findElement(firstBottomSheetRadioButton).click();
    }
    public void clicktenthButton() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(tenthButton));
        driver.findElement(tenthButton).click();
    }
}
