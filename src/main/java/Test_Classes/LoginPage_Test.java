package Test_Classes;

import Pages.LinkedInLoginPage;
import Pages.LinkedInProfile_Page;
import Project.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class LoginPage_Test extends BaseTest {
	
	 // Initialize page object AFTER driver is ready (from BaseTest)
	LinkedInLoginPage loginPage;
	LinkedInProfile_Page Profile;
	@BeforeClass
	 public void setUp() {
			loginPage = new LinkedInLoginPage(driver);
			Profile = new LinkedInProfile_Page(driver);
			
    }


//    @Test(priority=1)
    public void Navigate_to_LoginPage() throws InterruptedException {
       
        
        // Perform login
//    	Thread.sleep(2000);
    	loginPage.tapSignInWithEmail();
        

    }
    
    
    
//    @Test(priority=2)
    public void LoginTest1() throws InterruptedException {
       
        
      
        loginPage.login("testbadaha@gmail.com", "AA00147235");
        loginPage.tapContinue();
        
        Thread.sleep(3000);
        
    }
    
    /*
//    @Test(priority=3,dataProvider="AuthanticationDataProvider",dataProviderClass = Pages.LinkedInLoginPage.class)
    public void LoginTest2(String username, String password) throws InterruptedException {
       
        
//    	driver.hideKeyboard();
        loginPage.login(username, password);
        
        loginPage.tapContinue();
        String errorMessage = loginPage.handleLoginFailure();
        loginPage.handleLoginFailure();
        loginPage.tapSkipForNow();
        System.out.println(errorMessage);

//        if (errorMessage != null) {
//            System.out.println("Login failed: " + errorMessage);
//            Assert.assertTrue(errorMessage.contains("wrong"), "Error message should indicate wrong credentials");
//        } else {
//            System.out.println(" Login success (no error popup shown)");
//        }
//        Thread.sleep(3000);
        
    }
   /* @Test(priority=4)
    public void upload_Pic() throws InterruptedException {
    	Profile.upload_photo();
    	Assert.assertTrue(Profile.Upload_Photo_Assert());

    	Thread.sleep(2000);

    	
    }
    @Test(priority=5)
    public void update_Pic() throws InterruptedException {
    	Profile.update_Photo();
    	
    	Assert.assertTrue(Profile.Update_Photo_Assert());

    	Thread.sleep(2000); 
    	
    }
    @Test(priority=6)
    public void add_Pic_frame() throws InterruptedException {
    	Profile.add_frame();
    	Assert.assertTrue(Profile.Add_frame_Assert());
    	Thread.sleep(3000); 
    	
    }
    @Test(priority=7)
    public void remove_Pic_frame() throws InterruptedException {
    	Profile.remove_frame();
    	Assert.assertTrue(Profile.remove_frame_Assert());
    	Thread.sleep(500); 
    	
    }
    
    @Test(priority=8)
    public void Change_Pic_Privacy() throws InterruptedException {
    	Profile.Change_Photo_Privacy();
    	Assert.assertTrue(Profile.Change_Privacy_Assert());
    	
    	Thread.sleep(600); 
    	
    }

   
}
