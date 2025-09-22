package Pages;

import org.testng.annotations.Test;

import Project.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class AcceptAndDeclineConnections extends BaseTest {
	
  @Test ()
  public void acceptConnection() throws InterruptedException {
	  Thread.sleep(4000);
	  MobileElement networkBtn= (MobileElement) driver.findElement(MobileBy.AccessibilityId("My Network 2 of 5"));
	  networkBtn.click();
	  Thread.sleep(4000);
	  MobileElement accept= (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(34)"));
	  accept.click();
	  Thread.sleep(4000);
	  MobileElement decline= (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(40)"));
	  decline.click();
  }
}
