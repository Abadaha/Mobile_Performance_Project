package Test_Classes;


import Pages.MessagesPage;
import Project.BaseTest;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MessagingTests extends BaseTest {
    MessagesPage messages;

    @BeforeClass
    public void setUp() {
        messages = new MessagesPage(driver);
    }


    @Test(priority = 1)
    public void TC_3_12_1_openMessagesAndViewAllConversations() throws InterruptedException {
        messages.openMessages();
        /*Assert.assertTrue(messages.isConversationListDisplayed(),
                "Conversation list should be displayed");*/
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void TC_3_12_2_openJobsMessagesTab() throws InterruptedException {
        messages.openJobsTab();
        Thread.sleep(2000);
       /* Assert.assertTrue(messages.isConversationListDisplayed(),
                "Job-related conversations should be displayed");*/
    }

    @Test(priority = 3)
    public void TC_3_12_3_openUnreadMessagesTab() throws InterruptedException {
        messages.openUnreadTab();
        Thread.sleep(2000);
        /*Assert.assertTrue(messages.isConversationListDisplayed(),
                "Unread conversations should be displayed");*/
    }

    @Test(priority = 4)
    public void TC_3_12_4_openDraftMessagesTab() throws InterruptedException {
        messages.openDraftsTab();
        Thread.sleep(2000);
       /* Assert.assertTrue(messages.isConversationListDisplayed(),
                "Draft conversations should be displayed");*/
    }

    @Test(priority = 5)
    public void TC_3_12_5_openInMailMessagesTab() throws InterruptedException {
        messages.openInMailTab();
        Thread.sleep(2000);
        messages.openInMailTab();
        /*Assert.assertTrue(messages.isConversationListDisplayed(),
                "InMail conversations should be displayed");*/
    }

    
    @Test(priority = 6)
    public void TC_3_13_1_lableConversationAsStar() throws InterruptedException {

    	messages.clickConversationButton();
        Thread.sleep(2000);
        messages.clickStarTouch();
        messages.clickBackButton();
       


    }
   
    @Test(priority = 11)
    public void TC_3_13_1_movedConversation() throws InterruptedException {

    	messages.clickConversationButton();
        Thread.sleep(2000);
        messages.clickStarToolbarOption();
        messages.selectMoveToOtherOption();
       /* 
        Assert.assertEquals(
                messages.movedToOtherToast(),
                "Successfully moved to Other",
                "Toast message did not match expected text"
            );*/
        
        messages.clickFolderChip();
        messages.clickSecondBottomSheetRadioButton();
        messages.clickConversationButton();
        messages.clickStarToolbarOption();
        messages.clickmoveToFocusedOption();
/*
        Assert.assertEquals(
                messages.movedToFocusedToast(),
                "Successfully moved to Focused",
                "Toast message did not match expected text"
            );*/
        
        messages.clickFolderChip();
        messages.clickfirstBottomSheetRadioButton();
        //messages.clicktenthButton();

    }
    
    // ==============================
    // TC-3.13.x : Conversation Actions
    // ==============================
    
    @Test(priority = 7)
    public void TC_3_13_1_startNewConversationAndSendMessage() throws InterruptedException {
       // messages.openMessages();
        messages.clickNewMessageButton();
        //Thread.sleep(2000);

        messages.enterConnectionName("Haya Abu Hjeer");
        messages.selectFirstSearchResult();
        messages.typeMessage("Hello, testing LinkedIn messaging");
        messages.clickSendButton();
        messages.clickBackButton();
        Thread.sleep(2000);
        messages.clickBackButton();

        /*ConversationPage convPage = new ConversationPage(driver);
        Assert.assertTrue(convPage.isMessagePresent("Hello, testing LinkedIn messaging"),
                "Sent message should be visible in thread");*/
    }



    @Test(priority = 8)
    public void TC_3_13_3_searchConversationByUsername() throws InterruptedException {
        messages.openMessages();
        messages.tapSearchBar();
        messages.searchConversation("Haya Abu Hjeer"); // implement locator
        messages.selectFirstSearchResult();
        messages.clickBackButton();
        Thread.sleep(2000);
        messages.clickBackButton();
       /* Assert.assertTrue(messages.isConversationListDisplayed(),
                "Conversation search result should be displayed");*/
    }

    @Test(priority = 9)
    public void TC_3_13_3_searchConversationText() throws InterruptedException {
       // messages.openMessages();
        messages.tapSearchBar();
        messages.searchConversation("Hello, testing LinkedIn messaging"); // implement locator
        messages.selectFirstSearchTextResult();
        messages.clickBackButton();
        Thread.sleep(2000);
        messages.clickBackButton();
        Thread.sleep(2000);



       /* Assert.assertTrue(messages.isConversationListDisplayed(),
                "Conversation search result should be displayed");*/
    }
    
    @Test(priority = 10)
    public void TC_3_13_4_cannotMessageNonConnection() throws InterruptedException {
       // messages.openMessages();
        messages.clickNewMessageButton();
        //Thread.sleep(2000);

        messages.enterConnectionName("Ahmad");
        messages.selectFirstSearchResult();
        messages.clickOutsideTouch();
        messages.clickCloseButton();
        Thread.sleep(2000);

    }
  
}
