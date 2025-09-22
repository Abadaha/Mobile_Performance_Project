package Pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Project.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class SendConnection extends BaseTest {
  @Test
  public void sendConnections() throws InterruptedException {
      // Click on search button/icon
	  Thread.sleep(2000);
	  MobileElement searchBtn= (MobileElement) driver.findElement(MobileBy.AccessibilityId("Search for people, jobs, posts, and more"));
	  searchBtn.click();
	  Thread.sleep(2000);
	  MobileElement search= (MobileElement) driver.findElement(By.id("com.linkedin.android:id/search_bar_edit_text"));
	  search.click();
	  Thread.sleep(2000);
	  search.sendKeys("mamoun suboh");
	  Thread.sleep(4000);
	  MobileElement result= (MobileElement) driver.findElement(MobileBy.AccessibilityId("Search suggestion, mamoun suboh, 2nd degree connection Quality Assurance Specialist at AXSOS AG, Press enter for search results."));
       result.click();
       Thread.sleep(2000);
 	  MobileElement follow= (MobileElement) driver.findElement(MobileBy.AccessibilityId("Connect"));
      follow.click();
      Thread.sleep(5000);
       

  }
}
