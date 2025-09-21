package Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;


public class LinkedInProfile_Page {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    private Actions actions ;

    public LinkedInProfile_Page() { 
    }
    public LinkedInProfile_Page(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // 10-second timeout
        this.actions= new Actions(driver);
    }
    
    
//    main page
    private By User_Icon_Side_menu = MobileBy.AccessibilityId("My Profile and Communities");
    private By Profile_Plus_Icon = By.id("com.linkedin.android:id/identity_mirror_component_profile_add_image");
    private By Upload_From_Phone_Button = By.id("com.linkedin.android:id/profile_picture_select_bottom_sheet_upload_from_photos_title");
    private By Photo_Selection = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[3]/android.view.View[2]/android.view.View");
    private By Photo_Save = By.id("com.linkedin.android:id/menu_action");
    
//  update or delete profile picture locators 
    private By Profile_Photo_Sidemenu = By.id("com.linkedin.android:id/identity_mirror_component_profile_image");
    private By Profile_Photo_Profile = By.id("com.linkedin.android:id/profile_top_card_profile_picture_v2");
    private By View_Or_Edit_Profile_photo_Button= By.xpath("(//android.widget.Button[@resource-id=\"com.linkedin.android:id/bottom_sheet_container\"])[1]");
//  update photo
    
    private By Profile_Photo_update_button= By.id("com.linkedin.android:id/profile_image_viewer_add_photo_button");
    private By Photo_Selection2_Update = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View");
//  update privacy
    
    private By Profile_Photo_privacy= By.id("com.linkedin.android:id/profile_image_viewer_visibility_button");
    private By Profile_Photo_privacy_public= By.xpath("//android.widget.TextView[@resource-id=\"com.linkedin.android:id/profile_photo_visibility_option_title\" and @text=\"Public\"]");
    private By Profile_Photo_privacy_MyNetwork= By.xpath("//android.widget.TextView[@resource-id=\"com.linkedin.android:id/profile_photo_visibility_option_subtitle\" and @text=\"Only people connected up to three degrees away from you will be able to see this.\"]");
//  Frame locators 
    
    private By Profile_Photo_frame_button= By.id("com.linkedin.android:id/profile_image_viewer_frames_button");
    private By Profile_Photo_frame_Original= By.xpath("(//android.widget.ImageView[@resource-id=\"com.linkedin.android:id/profile_photo_frame_compound_view_profile_image\"])[2]");
    private By Profile_Photo_frame_Opentowork= By.xpath("//android.widget.ImageView[@content-desc=\"#OpenToWork\"]");
    private By Profile_Photo_frame_hiring= By.xpath("//android.widget.ImageView[@content-desc=\"#Hiring\"]");
    private By Profile_Photo_frame_apply= By.id("com.linkedin.android:id/menu_action");
    private By Profile_Photo_frame_ٍSave= By.id("com.linkedin.android:id/forms_opento_bottom_toolbar_vertical_cta1");
    private By Profile_Photo_frame_ٍSave2= By.id("com.linkedin.android:id/open_preferences_view_screen_toolbar_action_v2");
    private By Profile_Photo_frame_ٍRemove_Open_To_Work= By.id("android:id/button2");
    private By Profile_Photo_frame_ٍnothanks_Button= By.id("com.linkedin.android:id/forms_opento_bottom_toolbar_vertical_cta2");
//    Delete button
    private By Profile_Photo_delete_button= By.id("com.linkedin.android:id/profile_image_viewer_delete_button");
    private By Profile_Photo_delete_button_Confirmation= By.id("android:id/button1");
    
//   Experiance locators
  
//  Form fields
    private By Experiance_form_Title_F= By.xpath("//android.widget.Button[@resource-id=\"com.linkedin.android:id/form_edit_text_dash\" and @text=\"Ex: Retail Sales Manager\"]");
    private By Experiance_form_Title_list= By.id("com.linkedin.android:id/typeahead_selected_item_view");
    private By Experiance_form_Emplyment_Type_F= By.xpath("//android.widget.Button[@resource-id=\"com.linkedin.android:id/form_picker_on_new_screen_input\"]");
    private By Experiance_form_Company_button= By.xpath("//android.widget.Button[@resource-id=\"com.linkedin.android:id/form_edit_text_dash\" and @text=\"Ex: Microsoft\"]");
    private By Experiance_form_Company_F= By.id("com.linkedin.android:id/typeahead_selected_item_view");

    private By Experiance_form_Strat_Date_F= By.id("com.linkedin.android:id/form_edit_start_date_field_dash");
    private By Experiance_form_save_button= By.id("com.linkedin.android:id/profile_edit_form_page_save_button_sticky");
    private By Experiance_form_Skip_button= By.id("com.linkedin.android:id/profile_form_page_secondary_button");
//  Experiance buttons   
    private By Experiance_ProfilePage_Plus_button= By.xpath("//android.widget.ImageButton[@content-desc=\"Add new experience\"]");
    private By Experiance_ProfilePage_add_Position_button= By.xpath("//android.widget.TextView[@resource-id=\"com.linkedin.android:id/bottom_sheet_item_text\" and @text=\"Add position\"]");
    private By Experiance_ProfilePage_Edit_button= By.xpath("//android.widget.ImageButton[@content-desc=\"View experience detail screen\"]");
    private By Experiance_ProfilePage_Select_experiance_button= MobileBy.AccessibilityId("Edit position Quality Assurance Engineer");
    private By Experiance_ProfilePage_Delete_experiance_button= By.id("com.linkedin.android:id/profile_edit_form_page_delete_button_inline");
    private By Experiance_ProfilePage_Delete_experiance_Confirmation_button= By.id("android:id/button1");
    private By Experiance_ProfilePage_Exit_Confirmation = By.className("android.widget.ImageButton");
    private By Popup_messageJob_Prefrances= By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
    private By date= By.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"2025\"]");
    private By Set_Date= By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
	private By closeBtn = By.xpath("//android.view.View[@content-desc='Close']");

    
    
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
    
//  Profile
    public void tap_Profile_Photo_Sidemenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_Sidemenu));
        driver.findElement(Profile_Photo_Sidemenu).click();
    }
   
    
    public void tap_Profile_Photo_Profile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_Profile));
        driver.findElement(Profile_Photo_Profile).click();
    }
    
    public void tap_View_Or_Edit_Profile_photo_Button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(View_Or_Edit_Profile_photo_Button));
        driver.findElement(View_Or_Edit_Profile_photo_Button).click();
    }
//    Update Photo
    public void tap_Profile_Photo_update_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_update_button));
        driver.findElement(Profile_Photo_update_button).click();
    }
    
    public void tap_Photo_Selection2_Update() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Photo_Selection2_Update));
        driver.findElement(Photo_Selection2_Update).click();
    }
//    Update Privacy
    public void tap_Profile_Photo_privacy() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_privacy));
        driver.findElement(Profile_Photo_privacy).click();
    }
    
    public void tap_Profile_Photo_privacy_public() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_privacy_public));
        driver.findElement(Profile_Photo_privacy_public).click();
    }
    
    public void tap_Profile_Photo_privacy_MyNetwork() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_privacy_MyNetwork));
        driver.findElement(Profile_Photo_privacy_MyNetwork).click();
    }
//    Update frame
    public void tap_Profile_Photo_frame_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_frame_button));
        driver.findElement(Profile_Photo_frame_button).click();
    }
    
    public void tap_Profile_Photo_frame_Original() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_frame_Original));
        driver.findElement(Profile_Photo_frame_Original).click();
    }
    
    public void tap_Profile_Photo_frame_Opentowork() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_frame_Opentowork));
        driver.findElement(Profile_Photo_frame_Opentowork).click();
    }
    
    
    public void tap_Profile_Photo_frame_ٍRemove_Open_To_Work() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_frame_ٍRemove_Open_To_Work));
        driver.findElement(Profile_Photo_frame_ٍRemove_Open_To_Work).click();
    }
    
    public void tap_Profile_Photo_frame_hiring() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_frame_hiring));
        driver.findElement(Profile_Photo_frame_hiring).click();
    }
    public void tap_Profile_Photo_frame_apply() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_frame_apply));
        driver.findElement(Profile_Photo_frame_apply).click();
    }
 
    public void tap_Profile_Photo_frame_ٍSave() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_frame_ٍSave));
        driver.findElement(Profile_Photo_frame_ٍSave).click();
    }
    public void tap_Profile_Photo_frame_ٍno_thanks_Button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_frame_ٍnothanks_Button));
        driver.findElement(Profile_Photo_frame_ٍnothanks_Button).click();
    }
//    Delete Photo
    public void tap_Profile_Photo_delete_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_delete_button));
        driver.findElement(Profile_Photo_delete_button).click();
    }
    
    
    
    public void tap_Profile_Photo_delete_button_Confirmation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Profile_Photo_delete_button_Confirmation));
        driver.findElement(Profile_Photo_delete_button_Confirmation).click();
    }
    
//   Experiance buttons 
    
    
    public void tap_Experiance_ProfilePage_Plus_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Experiance_ProfilePage_Plus_button));
        driver.findElement(Experiance_ProfilePage_Plus_button).click();
    }
   
    public void tap_Experiance_ProfilePage_add_Position_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Experiance_ProfilePage_add_Position_button));
        driver.findElement(Experiance_ProfilePage_add_Position_button).click();
    }
    
    public void tap_Experiance_ProfilePage_Edit_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Experiance_ProfilePage_Edit_button));
        driver.findElement(Experiance_ProfilePage_Edit_button).click();
    }
    
    
    public void tap_Experiance_ProfilePage_Select_experiance_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Experiance_ProfilePage_Select_experiance_button));
        driver.findElement(Experiance_ProfilePage_Select_experiance_button).click();
    }
    
    public void tapExperienceProfileButton(String positionName) {
        // Click the experience button dynamically based on positionName
        By experienceButton = MobileBy.AccessibilityId("Edit position " + positionName);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(experienceButton));
        driver.findElement(experienceButton).click();
    }

    
    
    public void tap_Experiance_ProfilePage_Delete_experiance_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Experiance_ProfilePage_Delete_experiance_button));
        driver.findElement(Experiance_ProfilePage_Delete_experiance_button).click();
    }
    
    
    public void tap_Experiance_ProfilePage_Exit_Confirmation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Experiance_ProfilePage_Exit_Confirmation));
        driver.findElement(Experiance_ProfilePage_Exit_Confirmation).click();
    }
    
    
    public void tap_Experiance_ProfilePage_Delete_experiance_Confirmation_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Experiance_ProfilePage_Delete_experiance_Confirmation_button));
        driver.findElement(Experiance_ProfilePage_Delete_experiance_Confirmation_button).click();
    }
    
    public void tap_Experiance_form_Set_Date_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Set_Date));
        driver.findElement(Set_Date).click();
    }
    
    public void tap_Experiance_form_Save_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Experiance_form_save_button));
        driver.findElement(Experiance_form_save_button).click();
    }


// Methods and DataProviders
//    	UploadPhoto method
        public void upload_photo() throws InterruptedException {
        	tapUserIconSideMenu();
        	tapUserPlusIcon();
        	tap_uploadFrom_Phone();
        	tap_Select_photo();
        	tap_Save_photo();
        	Thread.sleep(5000);
        	
        
        }
        
    	public boolean Upload_Photo_Assert() {
    		WebElement Plus_icon=driver.findElement(Profile_Plus_Icon);
    		
    		
    		return Plus_icon.isDisplayed();
    		
    	}
      
        
        public void update_Photo() throws InterruptedException {
			tapUserIconSideMenu();
			Thread.sleep(2000);
			pressBack();
			tapUserIconSideMenu();
			tap_Profile_Photo_Sidemenu();
			tap_Profile_Photo_Profile();
			tap_View_Or_Edit_Profile_photo_Button();
			tap_Profile_Photo_update_button();
			tap_uploadFrom_Phone();
			tap_Photo_Selection2_Update();
			tap_Save_photo();
			Thread.sleep(500);
// 			
 	
			Thread.sleep(6000);
			pressBack();
        }
        
        public void add_frame() throws InterruptedException {
			tap_Profile_Photo_Profile();
			tap_View_Or_Edit_Profile_photo_Button();
			tap_Profile_Photo_frame_button();
			
			tap_Profile_Photo_frame_Opentowork();
			tap_Profile_Photo_frame_apply();
			Thread.sleep(1000);
			By saveButton = By.xpath(
				    "//*[@resource-id='com.linkedin.android:id/forms_opento_bottom_toolbar_vertical_cta1'] " +
				    "| //*[@resource-id='com.linkedin.android:id/open_preferences_view_screen_toolbar_action_v2']"
				);

				WebDriverWait wait = new WebDriverWait(driver, 10);
				MobileElement element = (MobileElement) wait.until(
				    ExpectedConditions.visibilityOfElementLocated(saveButton)
				);
				element.click();
				
				pressBack();
			pressBack();


        }
        
        public void remove_frame() throws InterruptedException {
 			tap_Profile_Photo_Profile();
 			tap_View_Or_Edit_Profile_photo_Button();
 			tap_Profile_Photo_frame_button();
 			tap_Profile_Photo_frame_Original();
 			tap_Profile_Photo_frame_apply();
 			tap_Profile_Photo_frame_ٍRemove_Open_To_Work();
 			Thread.sleep(2000);
 			pressBack();
 			

         }
        
        public void Change_Photo_Privacy() throws InterruptedException {
 			tap_Profile_Photo_Profile();
 			tap_View_Or_Edit_Profile_photo_Button();
 			Thread.sleep(500);
 			tap_Profile_Photo_privacy();
 			Thread.sleep(500);
 		    tap_Profile_Photo_privacy_MyNetwork();
 			Thread.sleep(2000);
 			pressBack();


         }
        
        
        public void Delete_Photo() throws InterruptedException {
 			tap_Profile_Photo_Profile();
 			Thread.sleep(500);
 			tap_View_Or_Edit_Profile_photo_Button();
 			Thread.sleep(500);
 			tap_Profile_Photo_privacy();
 			tap_Profile_Photo_privacy_public();
 			tap_Profile_Photo_delete_button();
 			Thread.sleep(500);
 		    tap_Profile_Photo_delete_button_Confirmation();
 			
 			Thread.sleep(1000);
 			
 			
        }
        
        
        
        public void Add_Experiance() throws InterruptedException {
//        	scrollToElementAndClick(By.xpath("//android.widget.ImageButton[@content-desc=\"Add new experience\"]"), 5);
        	scrollToText("Experience");
        	Thread.sleep(500);
			tap_Experiance_ProfilePage_Plus_button();
			Thread.sleep(500);
			tap_Experiance_ProfilePage_add_Position_button();
			Thread.sleep(2000);
			driver.findElement(Experiance_form_Title_F).click();
			Thread.sleep(1000);

			driver.findElement(Experiance_form_Title_list).sendKeys("Quality Assurance Engineer");
			driver.hideKeyboard();
			Thread.sleep(500);
			selectFromDropdown();
			
			Thread.sleep(500);
			
			driver.findElement(Experiance_form_Emplyment_Type_F).click();
			Thread.sleep(500);
			selectFromDropdown();
			Thread.sleep(500);
			driver.findElement(Experiance_form_Company_button).click();
			driver.findElement(Experiance_form_Company_F).sendKeys("Axsos");
			driver.hideKeyboard();
			Thread.sleep(500);
			selectFromDropdown();
			

			Thread.sleep(500);
			scrollToElementAndClick(By.id("com.linkedin.android:id/form_edit_start_date_field_dash"), 5);
			Thread.sleep(500);
			Thread.sleep(500);
			MobileElement element = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"2025\"]"));
			
			element.click();
//			driver.getKeyboard();
			element.clear();
			element.sendKeys("2021");
			
			MobileElement Month = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"September\"]"));
			Thread.sleep(500);
			Month.click();
			Month.clear();
			Month.sendKeys("May");
			Thread.sleep(1000);
			TouchAction action = new TouchAction(driver);

			action.tap(PointOption.point(990, 2160)).perform();
			
			Thread.sleep(2000);
			tap_Experiance_form_Set_Date_button();


			Thread.sleep(2000);

			tap_Experiance_form_Save_button();
			Thread.sleep(2000);
 			pressBack();

 			Thread.sleep(2000);

        }
        
        public void Delete_Experiance() throws InterruptedException {
        	tap_Experiance_ProfilePage_Edit_button();
        	tap_Experiance_ProfilePage_Select_experiance_button();
			scrollToElementAndClick(By.xpath("//android.widget.Button[@resource-id=\"com.linkedin.android:id/profile_edit_form_page_delete_button_inline\"]"), 10);

			tap_Experiance_ProfilePage_Delete_experiance_Confirmation_button();
			
			

			
			    MobileElement close =(MobileElement) wait
			        .until(ExpectedConditions.visibilityOfElementLocated(closeBtn));
			    close.click();
			
			Thread.sleep(3000);
			pressBack();
			pressBack();
			
        	
        	
        }
        
        
        public void LogOut() throws InterruptedException {
			
        	Thread.sleep(3000);
        	tapUserIconSideMenu();
        	pressBack();
        	tapUserIconSideMenu();
        	Thread.sleep(500);
        	MobileElement Settings_Button = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.linkedin.android:id/home_nav_premium_upsell_text_view\"]"));
        	Settings_Button.click();
			scrollToElementAndClick(By.xpath("//android.widget.TextView[@text=\"Sign Out\"]"), 5);
			
			driver.findElement(By.id("android:id/button1")).click();
			
        }
        
        
        
        private void selectFromDropdown() {
            
            actions.sendKeys(Keys.ARROW_DOWN)
                   .sendKeys(Keys.ARROW_DOWN)
                   .sendKeys(Keys.ENTER)
                   .sendKeys(Keys.ENTER)
                   .build()
                   .perform();
        }

        
        
//		Scroll_Method
        public void scrollToText(String text) {
            driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"))");
        }

        public void scrollToElementAndClick(By locator, int maxSwipes) {
            for (int i = 0; i < maxSwipes; i++) {
                List<MobileElement> elements = driver.findElements(locator);
                if (!elements.isEmpty()) {
                    elements.get(0).click(); // click directly when found
                    return;
                }

                // swipe up
                Dimension size = driver.manage().window().getSize();
                int startX = size.width / 2;
                int startY = (int) (size.height * 0.8);
                int endY = (int) (size.height * 0.2);

                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 1);

                swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                driver.perform(Arrays.asList(swipe));
            }
            throw new NoSuchElementException(" Element not found after " + maxSwipes + " swipes: " + locator.toString());
        }

    
    
}
