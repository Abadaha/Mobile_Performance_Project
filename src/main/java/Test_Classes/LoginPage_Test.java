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
       
        
      
        loginPage.login("testbadaha2@gmail.com", "AA00147235");
        loginPage.tapContinue();
        loginPage.tapSkipForNow();
        Thread.sleep(3000);
        
    }
    
    
//    @Test(priority=3,dataProvider="AuthanticationDataProvider",dataProviderClass = Pages.LinkedInLoginPage.class)
    public void LoginTest2(String username, String password) throws InterruptedException {
       
        
      
        loginPage.login(username, password);
        loginPage.tapContinue();
        String errorMessage = loginPage.handleLoginFailure();
        System.out.println(errorMessage);

//        if (errorMessage != null) {
//            System.out.println("Login failed: " + errorMessage);
//            Assert.assertTrue(errorMessage.contains("wrong"), "Error message should indicate wrong credentials");
//        } else {
//            System.out.println(" Login success (no error popup shown)");
//        }
//        Thread.sleep(3000);
        
    }
    @Test(priority=4)
    public void upload_Pic() throws InterruptedException {
    	Profile.upload_photo();

    	Thread.sleep(2000);

    	
    }
    @Test(priority=5)
    public void update_Pic() throws InterruptedException {
    	Profile.update_Photo();
    	
    	Thread.sleep(2000); 
    	
    }
    @Test(priority=6)
    public void add_Pic_frame() throws InterruptedException {
    	Profile.add_frame();
    	
    	Thread.sleep(3000); 
    	
    }
    @Test(priority=7)
    public void remove_Pic_frame() throws InterruptedException {
    	Profile.remove_frame();
    	
    	Thread.sleep(500); 
    	
    }
    
    @Test(priority=8)
    public void Change_Pic_Privacy() throws InterruptedException {
    	Profile.Change_Photo_Privacy();
    	
    	Thread.sleep(600); 
    	
    }
    
    @Test(priority=9)
    public void delete_Profile_Pictrue() throws InterruptedException {
    	Profile.Delete_Photo();
    	
    	Thread.sleep(500); 
    	
    }
    @Test(priority=10)
    public void Add_Experiance() throws InterruptedException {
    	Profile.Add_Experiance();
    	
    	
    	
    }
    @Test(priority=11)
    public void Delete_Experiance() throws InterruptedException {
    	Profile.Delete_Experiance();
    	
    	
    	
    }
    
    @Test(priority=12)
    public void LogOut() throws InterruptedException {
    	Profile.LogOut();
    	
    	Thread.sleep(2000); 
    	
    }
    
    
    
    
   
}
