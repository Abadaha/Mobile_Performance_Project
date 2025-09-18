package Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;


public class LinkedInProfile_Page {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    
    public LinkedInProfile_Page() { 
    }
    public LinkedInProfile_Page(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // 10-second timeout
    }

    
//    main page
    private By User_Icon_Side_menu = MobileBy.AccessibilityId("My Profile and Communities");
    private By Profile_Plus_Icon = By.id("com.linkedin.android:id/identity_mirror_component_profile_add_image");
    private By Upload_From_Phone_Button = By.id("com.linkedin.android:id/profile_picture_select_bottom_sheet_upload_from_photos_title");
    private By Photo_Selection = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View");
    private By Photo_Save = By.id("com.linkedin.android:id/menu_action");
    
    // Actions

    public void pressBack() {
        driver.navigate().back();
    }
  
    public void tapUserIconSideMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(User_Icon_Side_menu));
        driver.findElement(User_Icon_Side_menu).click();
    }
    
    public void tapUserPlusIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Plus_Icon));
        driver.findElement(Profile_Plus_Icon).click();
    }
    public void tap_uploadFrom_Phone() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Upload_From_Phone_Button));
        driver.findElement(Upload_From_Phone_Button).click();
    }
    
    public void tap_Select_photo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Photo_Selection));
        driver.findElement(Photo_Selection).click();
    }
    
    public void tap_Save_photo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Photo_Save));
        driver.findElement(Photo_Save).click();
    }
    
    

 

        public void upload_photo() {
        	tapUserIconSideMenu();
        	tapUserPlusIcon();
        	tap_uploadFrom_Phone();
        	tap_Select_photo();
        	tap_Save_photo();
        	
        }


    
    
}
