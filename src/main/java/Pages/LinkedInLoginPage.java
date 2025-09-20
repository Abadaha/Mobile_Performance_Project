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


public class LinkedInLoginPage {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;
    
    public LinkedInLoginPage() {  
    }
    public LinkedInLoginPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); // 10-second timeout
    }

    // Locators
    private By signInWithEmailButton = By.id("com.linkedin.android:id/growth_prereg_fragment_login_button");
    private By emailField = By.className("android.widget.AutoCompleteTextView");
    private By passwordField = By.className("android.widget.EditText");
    private By continueButton = By.xpath("//android.widget.Button[@text='Continue']");
    private By skipButton = By.xpath("//android.widget.Button[@text='Skip for now']");
    private By Tryagain_Button = By.id("android:id/button2");
    private By Tryagain_message = By.id("android:id/message");
    private By Security_check=By.xpath("//android.widget.TextView[@text=\"Please solve this puzzle so we know you are a real person\"]");
//    main page
    private By User_Icon_Side_menu = MobileBy.AccessibilityId("My Profile and Communities");
    private By Profile_Plus_Icon = By.id("com.linkedin.android:id/identity_mirror_component_profile_add_image");
    private By Upload_From_Phone_Button = By.id("com.linkedin.android:id/profile_picture_select_bottom_sheet_upload_from_photos_title");
    private By Photo_Selection = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View");
    private By Photo_Save = By.id("com.linkedin.android:id/menu_action");
    
    // Actions
    public void tapSignInWithEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInWithEmailButton));
        driver.findElement(signInWithEmailButton).click();
    }
    
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void tapContinue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        driver.findElement(continueButton).click();
    }

    public void tapSkipForNow() {
        wait.until(ExpectedConditions.presenceOfElementLocated(skipButton));
        driver.findElement(skipButton).click();
    }

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
    
    

    // Login flow
    public void login(String email, String password) {

    	 
          enterEmail(email);
          enterPassword(password);
          
          
    }

        
        @DataProvider(name="AuthanticationDataProvider")
        public Object [][] AuthanticationDataProvider() {
        	return new Object[][]{
        		{"awdwadwda@gmail.com","wdhsahasdh@@asdjas"},
        		{"","wdwwdw@dwsadjasdj"},
        		{"testbadaha@gmail.com",""},
        		{"testbadaha@gmail.com","AA00147235"},
        		
        		};

        	}
    
        public String handleLoginFailure() {
            //Handle "Try Again" 
            try {
                WebElement tryAgainButton = driver.findElement(Tryagain_Button);
                if (tryAgainButton.isDisplayed()) {
                    String message = driver.findElement(Tryagain_message).getText();
                    tryAgainButton.click();
                    return message; 
                }
            } catch (NoSuchElementException e) {
                // "Try Again" popup not present 
            }

            //Handle Security Check screen
            try {
                WebElement securityCheckElement = driver.findElement(Security_check);
                if (securityCheckElement.isDisplayed()) {
                    System.out.println("Security Check detected, pressing back...");
                    driver.navigate().back(); // press return/back
                }
            } catch (NoSuchElementException e) {
                // Security check not present
            }

            return null; // no error message
        }

        public void upload_photo() {
        	tapUserIconSideMenu();
        	tapUserPlusIcon();
        	tap_uploadFrom_Phone(); 
        	tap_Select_photo(); 
        	tap_Save_photo();
        	
        }


    
    
}
