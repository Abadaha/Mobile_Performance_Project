package linked.project1;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedInFeed {

	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;
	private AndroidTouchAction touchAction;

	public LinkedInFeed(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		this.touchAction = new AndroidTouchAction(driver);
	}

	 // Locators
	private By likeButton = By.id("com.linkedin.android:id/feed_social_actions_like_button");
	private By likeCount = By.id("com.linkedin.android:id/feed_conversations_reactions_count");
	private By commentIcon = By.id("com.linkedin.android:id/feed_social_actions_comment_button");
	private By commentTextField = By.id("com.linkedin.android:id/comment_bar_edit_text");
	private By commentButton = By.id("com.linkedin.android:id/comment_box_toolbar_post_button");
	private By threeDots = By.xpath("(//android.widget.ImageView[@content-desc=\"Post options\"])[1]");
	private By warnningMessage = By.id("com.linkedin.android:id/comment_bar_warning_message_text");
	private By edit = By.xpath(
			"//android.widget.TextView[@resource-id=\"com.linkedin.android:id/action_item_text\" and @text=\"Edit comment\"]");
	private By saveChangesButton = By.id("com.linkedin.android:id/comment_bar_edit_comment_save_changes_button");
	private By editsuccessfully = By.xpath("//android.widget.TextView[@content-desc=\"now\"]");
	private By deleteOption = By.xpath(
			"//android.widget.TextView[@resource-id=\"com.linkedin.android:id/action_item_text\" and @text=\"Delete comment\"]");
	private By deleteButton = By.id("android:id/button1");
	private By deletesuccessfully = By.xpath("//android.widget.TextView[@text=\"Comment successfully deleted.\"]");
	private By repostButton = By.id("com.linkedin.android:id/feed_social_actions_reshare_button");
	private By repostInstantlyButton = By.xpath(
			"//android.widget.TextView[@resource-id=\"com.linkedin.android:id/bottom_sheet_item_text\" and @text=\"Repost\"]");
	private By repostSuccessfully1 = By.xpath("//android.widget.TextView[@text=\"Repost successful.\"]");
	private By repostUnsuccessfully = By
			.xpath("//android.widget.TextView[@text=\"This post has already been reposted.\"]");
	private By closeButton = By.xpath("//android.view.View[@content-desc=\"Close\"]");
	private By repostWithYourThoughtsButton = By.xpath(
			"//android.widget.TextView[@resource-id=\"com.linkedin.android:id/bottom_sheet_item_text\" and @text=\"Repost with your thoughts\"]");
	private By postTextField = By.id("com.linkedin.android:id/share_compose_text_input_entities");
	private By postButton = By.id("com.linkedin.android:id/share_compose_post_button");
	private By repostsuccessfully2 = By.xpath("//android.widget.Button[@content-desc=\"Repost successful. View post\"]");
	private By sendButton = By.id("com.linkedin.android:id/feed_social_actions_send_button");
	private By account = By.id("com.linkedin.android:id/recipient_profile_pic");
	private By sendMessageButton = By.id("com.linkedin.android:id/messaging_multisend_send_separately_button");
	private By sendingsuccessfully = By.xpath("//android.widget.Button[@content-desc=\"Sending message View\"]");
	private By postOption = By.id("com.linkedin.android:id/tab_post");
	private By postAPostButton = By.id("com.linkedin.android:id/share_compose_post_button");
	private By errrMessage = By.id("com.linkedin.android:id/share_compose_character_message_text");
	private By anyoneButton = By.id("com.linkedin.android:id/share_compose_visibility_toggle_view");
	private By connectionOnlyButton = By.xpath(
			"(//android.widget.RadioButton[@resource-id=\"com.linkedin.android:id/unified_settings_visibility_item_radio_button\"])[2]");
	private By photoIcon = By.xpath("//android.widget.ImageButton[@content-desc=\"Photo\"]");
	private By selectPhoto = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[6]/android.view.View[4]/android.view.View[2]/android.view.View");
	private By doneButton = By.xpath(
			"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[7]/android.view.View[3]/android.widget.Button");
	private By nextButton = By
			.xpath("//android.widget.Button[@resource-id=\"com.linkedin.android:id/media_editor_next_button\"]");
	private By postMessage = By.xpath("//android.widget.Button[@content-desc=\"View post\"]");

	// Refresh The Page
	public void refreshPage() {
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();

		int widthHalf = width / 2;
		int scrolStartPoint = (int) (height * 0.25);
		int scrolEndPoint = (int) (height * 0.75);

		touchAction.press(PointOption.point(widthHalf, scrolStartPoint)).waitAction()
				.moveTo(PointOption.point(widthHalf, scrolEndPoint)).release().perform();

	}

	// Scroll Down
	public void scrolDown() {
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();

		int widthHalf = width / 2;
		int scrolEndPoint = (int) (height * 0.25);
		int scrolStartPoint = (int) (height * 0.75);

		touchAction.press(PointOption.point(widthHalf, scrolStartPoint)).waitAction()
				.moveTo(PointOption.point(widthHalf, scrolEndPoint)).release().perform();
	}

	// Click a Like
	public void clickLike() {
		MobileElement count1 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(likeCount));
		String beforeInText=count1.getText();
		int before = Integer.parseInt(beforeInText);
		MobileElement like = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(likeButton));
		like.click();
		MobileElement count2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(likeCount));
		String afterInText=count2.getText();
		int after = Integer.parseInt(afterInText);
		Assert.assertEquals(before+1,after);


	}

	// Remove a Like
	public void removeLike() {
		MobileElement count1 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(likeCount));
		String beforeInText=count1.getText();
		int before = Integer.parseInt(beforeInText);
		MobileElement like = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(likeButton));
		like.click();
		MobileElement count2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(likeCount));
		String afterInText=count2.getText();
		int after = Integer.parseInt(afterInText);
		Assert.assertEquals(before-1,after);

	}

	// add a comment
	public void addComment(String comment) {
		MobileElement clickCommentIcon = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(commentIcon));
		clickCommentIcon.click();
		MobileElement write = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(commentTextField));
		write.click();
		write.sendKeys(comment);
		MobileElement sendComment = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(commentButton));
		sendComment.click();
		MobileElement assertEditMessage = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(editsuccessfully));
		Assert.assertEquals(assertEditMessage.getText(), "now");
	}
	// Edit the comment to be empty 
			public void addEmptyComment() {
				MobileElement clickThreeDots = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(threeDots));
				clickThreeDots.click();
				MobileElement clickEdit = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(edit));
				clickEdit.click();
				MobileElement rewrite = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(commentTextField));
				rewrite.click();
				rewrite.clear();
				MobileElement message = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(warnningMessage));
				Assert.assertEquals(message.getText(), "Minimum of 1 character");
			}

	// Edit Comment
	public void editComment(String comment) {
		MobileElement rewrite = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(commentTextField));
		rewrite.click();
		rewrite.sendKeys(comment);
		MobileElement clickSave = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(saveChangesButton));
		clickSave.click();
		MobileElement assertEditMessage = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(editsuccessfully));
		Assert.assertEquals(assertEditMessage.getText(), "now (edited)");

	}

	// Delete a Comment
	public void deleteComment() {
		MobileElement clickThreeDots = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(threeDots));
		clickThreeDots.click();
		MobileElement clickDeleteOption = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(deleteOption));
		clickDeleteOption.click();
		MobileElement clickDelete = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
		clickDelete.click();
		MobileElement assertDeleteMessage = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(deletesuccessfully));
		Assert.assertEquals(assertDeleteMessage.getText(), "Comment successfully deleted.");
		driver.navigate().back();
	}

	// Repost a post Without adding Your Thoughts
	public void repostInstantly() throws InterruptedException {
		MobileElement clickRepostButton = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(repostButton));
		clickRepostButton.click();
		MobileElement clickRepostInstanlyButton = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(repostInstantlyButton));
		clickRepostInstanlyButton.click();
		MobileElement resultMessage = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(repostSuccessfully1));
		Assert.assertEquals(resultMessage.getText(), "Repost successful.");
		Thread.sleep(1000);

	}

	// Repost a post Twice
	public void repostInstantlyTwice() {
		MobileElement clickCloseButton = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(closeButton));
		clickCloseButton.click();
		MobileElement clickRepostButton = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(repostButton));
		clickRepostButton.click();
		MobileElement clickRepostInstanlyButton = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(repostInstantlyButton));
		clickRepostInstanlyButton.click();
		MobileElement resultMessage = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(repostUnsuccessfully));
		Assert.assertEquals(resultMessage.getText(), "This post has already been reposted.");

	}

	// Repost a post With Your Thoughts
	public void repostWithYourThoughts(String comment) {
		MobileElement clickRepostButton = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(repostButton));
		clickRepostButton.click();
		MobileElement clickRepostWithYourThoughtsButton = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(repostWithYourThoughtsButton));
		clickRepostWithYourThoughtsButton.click();
		MobileElement fillYourThoughtsField = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(postTextField));
		fillYourThoughtsField.click();
		fillYourThoughtsField.sendKeys(comment);
		MobileElement clickPostButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(postButton));
		clickPostButton.click();
		MobileElement resultMessage = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(repostsuccessfully2));
		Assert.assertEquals(resultMessage.getText(), "Repost successful.");
	}

	// Send a post through messages
	public void sendingPost() {
		MobileElement clickSendButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(sendButton));
		clickSendButton.click();
		MobileElement chooseAcoount = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(account));
		chooseAcoount.click();
		MobileElement sendMessage = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(sendMessageButton));
		sendMessage.click();
		MobileElement resultMessage = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(sendingsuccessfully));
		Assert.assertEquals(resultMessage.getText(), "Sending message");
	}

	// create a post with over 3,000 Characters
	public void creatingOver3000CharactersPost(String text) {
		MobileElement clickPostButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(postOption));
		clickPostButton.click();
		MobileElement fillPost = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(postTextField));
		fillPost.click();
		fillPost.sendKeys(text);
//		MobileElement clickPost= (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(postAPostButton));
//		clickPost.click();
		MobileElement message = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(errrMessage));
		Assert.assertEquals(message.getText(), "You have exceeded the maximum character limit.");

	}

	// change Privacy to connections only
	public void changePrivacyToConnectionsOnly() {
		MobileElement clickAnyoneButton = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(anyoneButton));
		clickAnyoneButton.click();
		MobileElement clickConnectionOnlyButton = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(connectionOnlyButton));
		clickConnectionOnlyButton.click();
		driver.navigate().back();
		MobileElement message = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(anyoneButton));
		Assert.assertEquals(message.getText(), "Connections only");

	}

	// Create a Valid Post
	public void validPOst(String text) {
		MobileElement fillPost = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(postTextField));
		fillPost.click();
		fillPost.clear();
		fillPost.sendKeys(text);
		MobileElement click = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(photoIcon));
		click.click();
		MobileElement photo = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(selectPhoto));
		photo.click();
		MobileElement done = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(doneButton));
		done.click();
		MobileElement next = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		next.click();
		MobileElement clickPost = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(postAPostButton));
		clickPost.click();
		MobileElement message = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(postMessage));
		Assert.assertEquals(message.getText(), "Post successful.");

	}

}


