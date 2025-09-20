package Test_Classes;

import Pages.LinkedInLoginPage;
import Project.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class LoginPage_Test extends BaseTest {
	
	 // Initialize page object AFTER driver is ready (from BaseTest)
	LinkedInLoginPage loginPage;
	
	@BeforeClass
	 public void setUp() {
		loginPage = new LinkedInLoginPage(driver);
    }


    @Test(priority=1)
    public void Navigate_to_LoginPage() throws InterruptedException {
       
        
        // Perform login
//    	Thread.sleep(2000);
    	loginPage.tapSignInWithEmail();
        

    }
    
    
    
    @Test(priority=2)
    public void LoginTest1() throws InterruptedException {
       
        
      
        loginPage.login("testbadaha@gmail.com", "AA00147235");
        loginPage.tapContinue();
        loginPage.tapSkipForNow();
        Thread.sleep(3000);
        
    }
    
    /*
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
   /* @Test(priority=4)
    public void upload_Pic() throws InterruptedException {
    	loginPage.upload_photo();
    	
    	Thread.sleep(5000);
    	
    }
    */
   
}
