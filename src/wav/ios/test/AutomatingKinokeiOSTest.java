package wav.ios.test;


import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import wav.ios.util.AppiumTest;
import static wav.ios.util.Helpers.*;

public class AutomatingKinokeiOSTest extends AppiumTest {
	static final String EMAIL_FORMAT = "TestKinoke%d@yahoo.com";
	static final String FIRSTNAME_FORMAT = "Kinoke%d";
	static final String LASTNAME_FORMAT = "LN%d";
	
	static int RANDOM_NUM = (int)(Math.random()*9999);
	
    //@org.junit.Test
    public void loadSignIn_UsingMyEmail() throws Exception {
        System.out.println("\nCalled loadSignIn_UsingMyEmail() method");
        
        try{
        	Thread.sleep(5000);
        	
	        // Check whether is first time or not?
	        boolean isFirst = checkGetStarted();
	        
	        if(isFirst)
	        {
	        	// New user or existing user?
	        	// If click on "EXISTING USER"
	        	MobileElement me = findButton("EXISTING USER");
	        	if (me != null)
	        	{
	        		me.click();
	        		
	        		Thread.sleep(3000);
	        	
	        		signIn();
	        		
	        		// Create a new story
	        		afterSignIn_TellANewStory();
	        		
	        		homeScreen();
	        	} else
	        		System.out.println("Not found: EXISTING USER button");
	        } else
	        {
	        	homeScreen();
	        	
	        	// Create a new story
        		afterSignIn_TellANewStory();
	        	
	        }
        	
        }catch(Exception e)
        {
        	System.out.println("Error: " + e.getMessage());
        	//throw e;
        }
        
        Thread.sleep(3000);
        System.out.println("Ended loadSignIn_UsingMyEmail() method.");
    }
    
    @org.junit.Test
    public void loadSignIn_UsingFacebook() throws Exception {
        System.out.println("\nCalled loadSignIn_UsingFacebook() method");
        
        try{
        	Thread.sleep(5000);
        	
	        // Check whether is first time or not?
	        boolean isFirst = checkGetStarted();
	        
	        if(isFirst)
	        {
	        	// New user or existing user?
	        	// If click on "EXISTING USER"
	        	MobileElement me = findButton("EXISTING USER");
	        	if (me != null)
	        	{
	        		me.click();
	        		
	        		Thread.sleep(3000);
	        	
	        		signIn_UsingFacebook();
	        		
	        		// Create a new story
	        		afterSignIn_TellANewStory();
	        		
	        		homeScreen();
	        	} else
	        		System.out.println("Not found: EXISTING USER button");
	        } else
	        {	
	        	// Create a new story
        		afterSignIn_TellANewStory();
	        
        		homeScreen();
	        }
        	
        }catch(Exception e)
        {
        	System.out.println("Error: " + e.getMessage());
        	//throw e;
        }
        
        Thread.sleep(3000);
        System.out.println("Ended loadSignIn_UsingFacebook() method.");
    }
    
    //@org.junit.Test
    public void loadSignIn_UsingMyEmail_UserProfile_Logout() throws Exception {
        System.out.println("\nCalled loadSignIn_UsingMyEmail_UserProfile_Logout() method");
        
        try{
        	Thread.sleep(5000);
        	
	        // Check whether is first time or not?
	        boolean isFirst = checkGetStarted();
	        
	        if(isFirst)
	        {
	        	// New user or existing user?
	        	// If click on "EXISTING USER"
	        	MobileElement me = findButton("EXISTING USER");
	        	if (me != null)
	        	{
	        		me.click();
	        		Thread.sleep(3000);
	        	
	        		signIn();
	        		
	        		homeScreen();
	        		
	        		// Update user profile
	        		updateUserProfile();
	        		
	        		// Logout
	        		logout();
	        		
	        	} else
	        		System.out.println("Not found: EXISTING USER button");
	        } else
	        {
	        	homeScreen();
	        	
	        	// Update user profile
        		updateUserProfile();
	        	
        		// Logout
        		logout();
	        }
        	
        }catch(Exception e)
        {
        	System.out.println("Error: " + e.getMessage());
        	//throw e;
        }
        
        Thread.sleep(3000);
        System.out.println("Ended loadSignIn_UsingMyEmail_UserProfile_Logout() method.");
    }
    
    //@org.junit.Test
    public void loadSignUp_UsingMyEmail_StartWithAPhoto() throws Exception {
        System.out.println("\nloadSignUp() method called");
        
        try{
        	Thread.sleep(3000);
        	
	        // Check whether is first time or not?
	        boolean isFirst = checkGetStarted();
	        
	        if(isFirst)
	        {
	        	// New user or existing user?
	        	// If click on "NEW USER"
	        	MobileElement me = findButton("NEW USER");
	        	if (me != null)
	        	{
	        		me.click();	        		
	        		Thread.sleep(3000);
	        	
	        		signUp();
	        		
	        		// Welcome aboard screen, after sign up
	            	// Find button: TELL A STORY
	            	MobileElement btn = findButton("TELL A STORY");
	            	if(btn == null)
	            	{
	            		System.out.println("Not found button: TELL A STORY");
	            		return;
	            	}
	            	
	            	btn.click();
	            	
	        		// Tell a story - Create a photo
	        		startWithAPhoto();
	        		
	        		homeScreen();
	        	} else
	        		System.out.println("Not found: NEW USER button");
	        } else
	        {
	        	
	        }
        	
        }catch(Exception e)
        {
        	System.out.println("Error: " + e.getMessage());
        	//throw e;
        }
        
        Thread.sleep(3000);
        System.out.println("Ended loadSignUp() method.");
    }
    
    //@org.junit.Test
    public void loadSignUp_UsingMyEmail_StartWithYourVoice() throws Exception {
        System.out.println("\nloadSignUp() method called");
        
        try{
        	Thread.sleep(3000);
        	
	        // Check whether is first time or not?
	        boolean isFirst = checkGetStarted();
	        
	        if(isFirst)
	        {
	        	// New user or existing user?
	        	// If click on "NEW USER"
	        	MobileElement me = findButton("NEW USER");
	        	if (me != null)
	        	{
	        		me.click();	        		
	        		Thread.sleep(3000);
	        	
	        		signUp();
	        		
	        		// Welcome aboard screen, after sign up
	            	// Find button: TELL A STORY
	            	MobileElement btn = findButton("TELL A STORY");
	            	if(btn == null)
	            	{
	            		System.out.println("Not found button: TELL A STORY");
	            		return;
	            	}
	            	
	            	btn.click();
	            	
	        		
	        		startWithYourVoice();
	        		
	        		homeScreen();
	        	} else
	        		System.out.println("Not found: NEW USER button");
	        } else
	        {
	        	
	        }
        	
        }catch(Exception e)
        {
        	System.out.println("Error: " + e.getMessage());
        	//throw e;
        }
        
        Thread.sleep(3000);
        System.out.println("Ended loadSignUp() method.");
    }
    
    private boolean checkGetStarted() throws Exception {
    	System.out.println("\nCalled checkGetStarted() method");
    	
    	try
    	{
	    	// Search for "GET STARTED" button
	    	MobileElement me = element(for_tags("UIAButton"));
	    	if(me != null)
	    	{
	    		System.out.println("This app ran in the first time.");
	        	me.click();
	        	
	        	return true;
	    	}
	    	
	    	return false;
    	}finally
    	{
    		System.out.println("Ended checkGetStarted() method");
    	}
    }
    
    private void signUp() throws Exception {
    	System.out.println("\nCalled signUp() method");
    	
    	// Test data
    	String email = "";
    	String pin = "123456";
    	String firstName = "";
    	String lastName = "";
    	
    	// Random to get year of born.
    	String yearOfBorn = "";
    	
    	// Click on "USING MY EMAIL" button
    	MobileElement me = findButton("USING MY EMAIL");
    	if (me == null)
    		return;
    	
    	me.click();
    	
    	while(true)
    	{
    		// Get random email address
    		email = String.format(EMAIL_FORMAT, RANDOM_NUM);
    				
	    	// Set email and click NEXT button
	    	me = findTextField();
	    	if(me == null)
	    	{
	    		System.out.println("Not found email textfield.");
	    		return;
	    	}
	    	
	    	System.out.println("Email: " + email);
	    	me.setValue(email);
	    	me = findButton("NEXT");
	    	if(me == null)
	    		return;
	    	
	    	me.click();
	    	
	    	/* Check the returned error messages:
	    	- Email is not valid
	    	- Email already in use
	    	*/
	    	// Get email text field again.
	    	me = findTextField();
	    	//System.out.println("Email or password: " + me);
	    	if(me != null)
	    	{	
	    		if(me.getText() == email)
	    		{
	    			System.out.println("Email is not valid or already in use!");
	    			
	    			RANDOM_NUM = (int)(Math.random()*9999);
	    			continue;
	    		}
	    	}
	    	
	    	break;
    	}// while
    	
    	
    	// Enter PIN and click NEXT button
    	me = element(for_tags("UIASecureTextField"));;
    	if(me == null)
    	{
    		System.out.println("Not found PIN textfield.");
    		return;
    	}
    	
    	System.out.println("Set PIN: " + pin);
    	me.setValue(pin);
    	me = findButton("NEXT");
    	if(me == null)
    		return;
    	
    	me.click();
    	
    	
    	// Enter first name and click NEXT button
    	me = findTextField();
    	if(me == null)
    	{
    		System.out.println("Not found first name textfield.");
    		return;
    	}
    	
    	firstName = String.format(FIRSTNAME_FORMAT, RANDOM_NUM);
    	System.out.println("First name: " + firstName);
    	me.setValue(firstName);
    	me = findButton("NEXT");
    	if(me == null)
    		return;
    	
    	me.click();
    	
    	
    	// Enter last name and click NEXT button
    	me = findTextField();
    	if(me == null)
    	{
    		System.out.println("Not found last name textfield.");
    		return;
    	}
    	
    	lastName = String.format(LASTNAME_FORMAT, RANDOM_NUM);
    	System.out.println("Last name: " + lastName);
    	me.setValue(lastName);
    	me = findButton("NEXT");
    	if(me == null)
    		return;
    	
    	me.click();
    	
    	
    	// Enter Year of Born and click NEXT button
    	me = findTextField();
    	if(me == null)
    	{
    		System.out.println("Not found Year of Born textfield.");
    		return;
    	}
    	
    	yearOfBorn = "" + RANDOM_NUM;
    	System.out.println("Year of born: " + yearOfBorn);
    	me.setValue(yearOfBorn);
    	
    	// Click on NEXT button
    	me = findButton("NEXT");
    	if(me == null)
    		return;
    	
    	me.click();
    	
    	Thread.sleep(3000);
    	System.out.println("Ended signUp() method");
    }
    
    private void startWithAPhoto() throws Exception {
    	System.out.println("\nCalled startWithAPhoto() method");
    	
    	// Try to tap on forward arrow button 1, 2 or 3 times
    	int times = (int)(Math.random()*3);
    	int count = 1;
    	while(count <= times)
    	{
	    	MobileElement btnForward = findButton("forward arrow enable");
	    	if(btnForward != null)
	    		btnForward.click();
	    	
	    	count++;
	    }
    	
    	// Find button: Start with a photo
    	MobileElement btn = findButton("take photo btn");
    	if(btn == null)
    	{
    		System.out.println("Not found button: START WITH A PHOTO");
    		return;
    	}
    	
    	btn.click();
    	
    	// Alert: Kinoke would like to access your photos
    	// Tap on OK button
    	Thread.sleep(3000);
    	btn = findButton("OK");
    	if (btn == null)
    		return;
    	
    	btn.click();
    	
    	// Photos screen: Tap on Moments or Camera roll?
    	text("Moments").click();
    	
    	// Photos -> Moments screen
    	// Tap on the first photo
    	List<MobileElement> lst = tags("UIACollectionCell");
    	for(MobileElement me: lst)
    	{
    		System.out.println("Tap a photo: " + me);
    		if(me != null)
    		{
    			me.click();
    			break;
    		}
    	}
    	
    	// After chose a photo
    	// Tap on TEll a Story button - about this photo
    	Thread.sleep(2000);
    	btn = findButton("tell story btn");
    	if(btn == null)
    	{
    		System.out.println("Not found button: TELL A STORY");
    		return;
    	}
    	
    	btn.click();
    	
    	// Tap on "Tap to record" button
    	Thread.sleep(2000);
    	btn = findButton("record icon");
    	if(btn == null)
    	{
    		System.out.println("Not found button: Tap to record");
    		return;
    	}
    	
    	btn.click();
    	
    	// Recording, wait for 3 second and tap to stop
    	Thread.sleep(3000);
    	btn = findButton("pause button");
    	if(btn == null)
    		return;
    	
    	btn.click();
    	
    	// After recorded
    	// Tap on Save button
    	Thread.sleep(2000);
    	btn = findButton("save btn");
    	if(btn == null)
    		return;
    	
    	btn.click();
    	
    	// Max len: 50 chars
    	// Write a title
    	Thread.sleep(1000);
    	
    	// Note: it doesn't update the number of remaining chars
    	// When I tried to use MobileElement -> WebElement
    	WebElement meTitle = findTextFieldWE();
    	System.out.println("Find Write a Title textfield: " + meTitle);
    	if(meTitle == null)
    		return;
    	
    	meTitle.clear();
    	String title = "My Title " + RANDOM_NUM;
    	meTitle.sendKeys(title);
    	
    	// After set title
    	// Tap on Save button
    	Thread.sleep(1000);
    	btn = findButton("save btn");
    	if(btn == null)
    		return;
    	
    	btn.click();
    	
    	//
    	// Categorize your story: Happy, Celebrations, Origins and Graduations
    	// Dec 15, 2015: New categories are Funny, Origins, Occasion, Life Lesson and Career
    	Thread.sleep(2000);
    	int category = (int)(Math.random()*5);
    	if(category <= 1)
    		btn = findButton("FUNNY");
    	else if(category == 2)
    		btn = findButton("ORIGINS");
    	else if(category == 3)
    		btn = findButton("OCCASION");
    	else if(category == 4)
    		btn = findButton("LIFE LESSON");
    	else
    		btn = findButton("CAREER");
    	
    	if(btn != null)
    		btn.click();
    	
    	System.out.println("Ended startWithAPhoto() method");
    }
    
    private void startWithYourVoice() throws Exception {
    	System.out.println("\nCalled startWithYourVoice() method");
    	
    	// Try to tap on forward arrow button 1, 2 or 3 times
    	int times = (int)(Math.random()*3);
    	int count = 1;
    	while(count <= times)
    	{
	    	MobileElement btnForward = findButton("forward arrow enable");
	    	if(btnForward != null)
	    		btnForward.click();
	    	
	    	count++;
	    }
    	
    	// Find button: Start with your voice
    	MobileElement btn = findButton("take record btn");
    	if(btn == null)
    	{
    		System.out.println("Not found button: START WITH YOUR VOICE");
    		return;
    	}
    	
    	btn.click();
    	
    	// Tap on "Tap to record" button
    	Thread.sleep(2000);
    	btn = findButton("record icon");
    	if(btn == null)
    	{
    		System.out.println("Not found button: Tap to record");
    		return;
    	}
    	
    	btn.click();
    	
    	// Recording, wait for 3 second and tap to stop
    	Thread.sleep(3000);
    	btn = findButton("pause button");
    	if(btn == null)
    		return;
    	
    	btn.click();
    	
    	// After recorded
    	// Tap on Save button
    	Thread.sleep(2000);
    	btn = findButton("save btn");
    	if(btn == null)
    		return;
    	
    	btn.click();
    	
    	// Max len: 50 chars
    	// Write a title
    	Thread.sleep(1000);
    	
    	// Note: it doesn't update the number of remaining chars
    	// When I tried to use MobileElement -> WebElement
    	WebElement meTitle = findTextFieldWE();
    	System.out.println("Find Write a Title textfield: " + meTitle);
    	if(meTitle == null)
    		return;
    	
    	meTitle.clear();
    	String title = "My Title " + RANDOM_NUM;
    	meTitle.sendKeys(title);
    	
    	// After set title
    	// Tap on Save button
    	Thread.sleep(1000);
    	btn = findButton("save btn");
    	if(btn == null)
    		return;
    	
    	btn.click();
    	
    	//
    	// Categorize your story: Happy, Celebrations, Origins and Graduations
    	Thread.sleep(2000);
    	int category = (int)(Math.random()*4);
    	if(category <= 1)
    		btn = findButton("HAPPY");
    	else if(category == 2)
    		btn = findButton("CELEBRATIONS");
    	else if(category == 3)
    		btn = findButton("ORIGINS");
    	else
    		btn = findButton("ORIGINS");
    	
    	if(btn != null)
    		btn.click();
    	
    	System.out.println("Ended startWithYourVoice() method");
    }
    
    private void afterSignIn_TellANewStory() throws Exception {
    	System.out.println("\nCalled afterSignIn_TellANewStory() method");
    	
    	// Tap on "TELL A NEW STORY"
    	
    	try
    	{	
    		MobileElement btn = findButton("TELL A NEW STORY");
	    	
	    	if(btn == null)
	    		return;
	    	
	    	btn.click();
    		
    		
    	}catch(Exception e)
    	{
    		System.out.println("Error: " + e);
    	}
    	
    	// Tell a story - Create a photo
		startWithAPhoto();
    	
    	System.out.println("Ended afterSignIn_TellANewStory() method");
    }
    
    
    
    private boolean signIn() throws Exception {
    	System.out.println("\nCalled signIn() method");
    	
    	// Set email
    	String email = "thanhdinh73@yahoo.com";
    	System.out.println("Set email: " + email);
    	MobileElement me = findTextField();
    	if(me != null)
    		me.setValue(email);
    	else
    		return false;
    	
    	// Set PIN
    	String pin = "123456";
		System.out.println("Set PIN: " + pin);
    	me = element(for_tags("UIASecureTextField"));
    	if(me != null)
    		me.setValue(pin);
    	else
    		return false;
    	
    	// Click Login button
    	me = findButton("LOGIN");
    	if(me != null)
    		me. click();
    	else
    		return false;
    	
    	Thread.sleep(2000);
    	System.out.println("Ended signIn() method");
    	
    	return true;
    }
    
    private void logout() throws Exception {
    	System.out.println("\nCalled logout() method");
    	
    	// Old way (the user profile did not have a name): Find user profile button
    	/*System.out.println("Finding user profile button.");
    	Thread.sleep(2000);
    	for (MobileElement me : tags("UIAButton")) {
    		System.out.println("Button: " + me.getText());
    		System.out.println("\tTagname: " + me.getTagName());
    		
  		  if(me.getText().equals("Back"))
        		continue;
  		  
  		  me.click();
  		  break;
  	  	}*/
    	
    	// Find user profile button
    	MobileElement meBtn = findButton("UserProfileButton");
    	if(meBtn == null)
    	{
    		System.out.println("Cannot open user profile screen!");
    		return;
    	}
    	meBtn.click();
    	
    	// Tap on logout link
    	MobileElement meLogout = text("logout");
    	if(meLogout != null)
    	{
    		System.out.println("Found logout link");
    		meLogout.click();
    	} else
    		System.out.println("Not found logout link");
    	
    	Thread.sleep(3000);
    	System.out.println("Ended logout() method");
    }
    
    private boolean signIn_UsingFacebook() throws Exception {
    	System.out.println("\nCalled signIn_UsingFacebook() method");
    	
    	// Tap on "LOGIN WITH FACEBOOK" button
    	MobileElement btn = findButton("LOGIN WITH FACEBOOK");
    	if(btn == null)
    		return false;
    	
    	btn.click();
    	
    	// Set email
    	String email = "testnas90@yahoo.com";
    	System.out.println("Set email: " + email);
    	MobileElement me = findTextField();
    	if(me != null)
    		me.setValue(email);
    	else
    		return false;
    	
    	// Set Password
    	String pw = "Personal123";
		System.out.println("Set Password: " + pw);
    	me = element(for_tags("UIASecureTextField"));
    	if(me != null)
    		me.setValue(pw);
    	else
    		return false;
    	
    	// Click Login button
    	// If the FaceBook page is using VNese?
    	try
    	{
    		btn = findButton("Đăng nhập");
    	}catch(Exception e)
    	{
    		
    	}
    	
    	if(btn == null)
    	{
    		// Try to find in EN
    		btn = findButton("Log In");
    	}
    	
    	if(btn == null)
    		return false;
    	
    	btn.click();
    	
    	// If login successfully, find OK button to confirm
    	btn = findButton("OK");
    	if(btn == null)
    		return false;
    	
    	btn.click();
    	
    	Thread.sleep(2000);
    	System.out.println("Ended signIn_UsingFacebook() method");
    	
    	return true;
    }
    
    private void homeScreen() throws Exception {
    	System.out.println("\nCalled homeScreen() method");
    	
    	// Click on "FAMILY STORIES"
    	System.out.println("Tap on: FAMILY STORIES");
    	text("FAMILY STORIES").click();
    	Thread.sleep(3000);
    	
    	// Click on "FAMILY"
    	System.out.println("Tap on: FAMILY");
    	//text("FAMILY").click(); // From Dec 03, 2015 - it did not work b/c there are many Family words in this screen.
    	for (MobileElement me : tags("UIAStaticText"))
  	  	{
    		System.out.println("Finding: " + me.getText());
    		if(!me.getText().equals("FAMILY"))
    			continue;
    		    		
  		  	System.out.println("Found FAMILY tab.");
  		  	me.click();
  		  	
  		  	Thread.sleep(3000);
  		  	homeScreen_FamilyTab();
        	return;
  	  	}
    	
    	// Click on "MY STORIES"
    	System.out.println("Tap on: MY STORIES");
    	text("MY STORIES").click();    	
    	Thread.sleep(3000);
    	
    	System.out.println("Ended homeScreen() method");
    }
    
    private void homeScreen_FamilyTab() throws Exception {
    	System.out.println("\nCalled homeScreen_FamilyTab() method");
    	
    	String searchFor = "Thanh Dinh";
    	
    	// Set First name and last name to search textfield
    	MobileElement meTextSearch = findTextField();
    	if(meTextSearch == null)
    		return;
    	
    	meTextSearch.setValue(searchFor);
    	
    	// Tap on Search icon
    	MobileElement btn = findButton("Button");
    	if(btn == null)
    		return;
    	
    	btn.click();
    	
    	System.out.println("Check search results");
    	boolean isHasResults = false;
    	
		// Try to select some people if search found
    	try
    	{
			for (MobileElement me : tags("UIATableCell"))
	  	  	{
				isHasResults = true;
	    		System.out.println("Table Cell: " + me.getText());
	    		
	    		// Random to select
	    		int rand = (int)(Math.random()*9999);
	    		if(rand %2 == 0)
	    		{
	  		  		me.click();
	  		  		Thread.sleep(3000);
	    		}
	  	  	}
    	}catch(Exception ex)
    	{
    		System.out.println("Error: " + ex.getMessage());
    	}
    		
		if(isHasResults)
		{
    		// After selected some people, tap on DONE button
    		//MobileElement btnDone = findButton("DONE");
			WebElement btnDone = findButtonWE("DONE");
    		if(btnDone != null)
    		{
    			// Dec 15, 2015: The below lines of codes did not work
    			/*
    			try
    			{
    				System.out.println("DONE button, get enabled attribute: " + btnDone.getAttribute("enabled"));
    				if(btnDone.getAttribute("enabled").equals("true"))	
    					btnDone.click();
    				else
    					back();
    			}catch(Exception ex)
    			{
    				// In case, Appium is not supported to get attribute
    				btnDone.click();
    				
    				// Find DONE button again, if it is not enabled
    				btnDone = findButtonWE("DONE");
    				if(btnDone != null)
    					back();
    			}
    			*/
    			btnDone.click();
    			
    			// In case the DONE button is disabled, tap on Back button
    			try
    			{
    				back();
    			}catch(Exception e)
    			{
    				
    			}
    		} else
    			back();
		} else
		{	
    		// No results?
        	System.out.println("Finding: No results");
        	MobileElement meNoResults = text("No results");
        	if(meNoResults != null)
        	{
        		System.out.println("Tap on Back button");
        		
        		// Tap on Back button
        		back();
        	}
		}
		
    	// Tap on "INVITE THEM BY EMAIL"
    	/*MobileElement meInviteBtn = findButton("INVITE THEM BY EMAIL");
    	if(meInviteBtn != null)
    		meInviteBtn.click();*/
    	
    	System.out.println("Ended homeScreen_FamilyTab() method");
    }
    
    private void updateUserProfile() throws Exception {
    	System.out.println("\nCalled updateUserProfile() method");
    	
    	// Find user profile button
    	MobileElement btn = findButton("UserProfileButton");
    	if(btn == null)
    	{
    		System.out.println("Cannot open user profile screen!");
    		return;
    	}
    	btn.click();
    	
    	// Tap on Edit button to change to update mode
    	btn = findButton("Edit");
    	if(btn == null)
    	{
    		back();
    		return;
    	}
    	btn.click();
    	
    	// B/c of UIATextFields don't have name, I have to loop through them
    	int idx = 0;
    	for (MobileElement me : tags("UIATextField"))
  	  	{
    		idx++;
    		
    		System.out.println("Text field: " + me.getText());
    		
    		// Update first name
    		if(idx == 1)
    		{
    			me.setValue(String.format(FIRSTNAME_FORMAT, RANDOM_NUM));
    		} else if(idx == 2) // Update last name
    		{
    			me.setValue(String.format(LASTNAME_FORMAT, RANDOM_NUM));
    		} else // Update DoB
    		{
    			me.setValue(RANDOM_NUM + "");
    			break;
    		}
  	  	}
    	
    	// Tap on SAVE button
    	MobileElement btnSave = findButton("Save");
    	if(btnSave != null)
    	{	 
    		btnSave.click();
    		
    		// Wait for alert is disappeared
    		Thread.sleep(4000);
    	}
    	
    	// Dec 15, 2015: Use Cancel button instead of Back one
    	// Tap on Back button
    	//back();
    	MobileElement btnCancel = findButton("Cancel");
    	if(btnCancel != null)
    		btnCancel.click();
    	
    	Thread.sleep(3000);
    	System.out.println("Ended updateUserProfile() method");
    }
}