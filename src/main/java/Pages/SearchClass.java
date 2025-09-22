package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Project.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SearchClass extends BaseTest {
	    
  @Test()
  public void searchLinkedIn() throws InterruptedException {
      // Click on search button/icon
	  Thread.sleep(2000);
	  MobileElement searchBtn= (MobileElement) driver.findElement(MobileBy.AccessibilityId("Search for people, jobs, posts, and more"));
	  searchBtn.click();
	  Thread.sleep(2000);
	  MobileElement search= (MobileElement) driver.findElement(By.id("com.linkedin.android:id/search_bar_edit_text"));
	  search.click();
	  Thread.sleep(2000);
	  search.sendKeys("Haya Abu Hjeer");
	  Thread.sleep(4000);
	  MobileElement result= (MobileElement) driver.findElement(MobileBy.AccessibilityId("Search suggestion, haya abu hjeer, 1st degree connection QA Specialist | Scrum Master | Driving Agile Quality & Team Collaboration, Press enter for search results."));
       result.click();

  }



  @AfterClass
  public void tearDown() {

  
  }
}

