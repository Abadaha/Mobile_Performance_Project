package linked.project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testFeed extends BaseTest {
	LinkedInFeed linkedinFeed;

	@BeforeClass
	public void setUp() {
		linkedinFeed = new LinkedInFeed(driver);
	}

	@Test
	public void refreshTest() {
		linkedinFeed.refreshPage();
	}

	@Test(dependsOnMethods = "refreshTest")
	public void scrokTest() {
		linkedinFeed.scrolDown();
	}

	@Test(dependsOnMethods = "scrokTest")
	public void likeButtonTest() {
		linkedinFeed.clickLike();
	}

	@Test(dependsOnMethods = "likeButtonTest")
	public void unlikeTest() {
		linkedinFeed.removeLike();
	}

	@Test(dependsOnMethods = "unlikeTest")
	public void addCommentTest() throws InterruptedException {
		linkedinFeed.addComment(":");
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "addCommentTest")
	public void addEmptyCommentTest() {
		linkedinFeed.addEmptyComment();
	}

	@Test(dependsOnMethods = "addEmptyCommentTest")
	public void editCommentTest() throws InterruptedException {
		linkedinFeed.editComment(".");
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "editCommentTest")
	public void deleteCommentTest() {
		linkedinFeed.deleteComment();
	}

	@Test(dependsOnMethods = "deleteCommentTest")
	public void repostInstantlyTest() throws InterruptedException {
		linkedinFeed.repostInstantly();
	}

	@Test(dependsOnMethods = "repostInstantlyTest")
	public void repostInstantlyTwiceTest() {
		linkedinFeed.repostInstantlyTwice();
	}

	@Test(dependsOnMethods = "repostInstantlyTwiceTest")
	public void repostWithYourThoughtsTest() {
		linkedinFeed.repostWithYourThoughts(".");
	}

	@Test(dependsOnMethods = "repostWithYourThoughtsTest")
	public void sendingPostTest() {
		linkedinFeed.sendingPost();
	}
		
	@Test(dataProvider = "invalidData", dependsOnMethods = "sendingPostTest")
	public void invalidPost(String text) throws InterruptedException {
		linkedinFeed.creatingOver3000CharactersPost(text);
	}
	
	@DataProvider(name = "invalidData")
	public Object[][] invalidPostData() throws IOException {
		String path = "C:\\Users\\acer\\eclipse-workspace\\project1\\invalidData.csv";
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = reader.readLine();
		reader.close();

		return new Object[][] { { line } };
	}
	
	
	@Test(dependsOnMethods = "invalidPost")
	public void testChangePrivecy() {
		linkedinFeed.changePrivacyToConnectionsOnly();
	}

	@Test(dataProvider = "validData", dependsOnMethods = "testChangePrivecy")
	public void validPost(String text) throws InterruptedException {
		linkedinFeed.validPOst(text);
	}

	@DataProvider(name = "validData")
	public Object[][] validPostData() throws IOException {
		String path = "C:\\Users\\acer\\eclipse-workspace\\project1\\validData.csv";
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = reader.readLine();
		reader.close();

		return new Object[][] { { line } };
	}

	
}
