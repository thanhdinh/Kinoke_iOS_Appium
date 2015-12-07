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
	
    @org.junit.Test
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
    
    //@org.junit.Test
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
	        		
	        		homeScreen();
	        		
	        		// Create a new story
	        		afterSignIn_TellANewStory();
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
        System.out.println("Ended loadSignIn_UsingFacebook() method.");
    }
    
    @org.junit.Test
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
	        		
	        		signUp_StartWithAPhoto();
	        		
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
	        		
	        		signUp_StartWithYourVoice();
	        		
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
    	System.out.println("Called checkGetStarted() method");
    	
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
    	System.out.println("Called signUp() method");
    	
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
    
    private void signUp_StartWithAPhoto() throws Exception {
    	System.out.println("Called signUp_StartWithAPhoto() method");
    	
    	// Welcome aboard screen, after sign up
    	// Find button: TELL A STORY
    	MobileElement btn = findButton("TELL A STORY");
    	if(btn == null)
    	{
    		System.out.println("Not found button: TELL A STORY");
    		return;
    	}
    	
    	btn.click();
    	
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
    	btn = findButton("take photo btn");
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
    	
    	System.out.println("Ended signUp_StartWithAPhoto() method");
    }
    
    private void signUp_StartWithYourVoice() throws Exception {
    	System.out.println("Called signUp_StartWithYourVoice() method");
    	
    	// Welcome aboard screen, after sign up
    	// Find button: TELL A STORY
    	MobileElement btn = findButton("TELL A STORY");
    	if(btn == null)
    	{
    		System.out.println("Not found button: TELL A STORY");
    		return;
    	}
    	
    	btn.click();
    	
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
    	btn = findButton("take record btn");
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
    	
    	System.out.println("Ended signUp_StartWithYourVoice() method");
    }
    
    private void afterSignIn_TellANewStory() throws Exception {
    	System.out.println("Called afterSignIn_TellANewStory() method");
    	
    	// Get UIACollectionView control
    	MobileElement me = element(for_tags("UIACollectionView"));
    	System.out.println("Find UIACollectionView control: " + me);
    	if(me == null)
    		return;
    	
    	try
    	{
    		System.out.println("Scroll to: TELL A NEW STORY button");
	    	//WebElement btn = me.findElementByClassName("UIAButton");
	    	//WebElement btn = me.findElementByTagName("UIAButton");
    		WebElement btn = scrollTo("TELL A NEW STORY");
	    	 
	    	System.out.println("The TELL A NEW STORY button?: " + btn);
	    	if(btn == null)
	    		return;
	    	
	    	btn.click();
    		
    		
    	}catch(Exception e)
    	{
    		//System.out.println("Error: " + e);
    	}
    	
    	// Tap on "TELL A NEW STORY" button
    	System.out.println("Tap on: TELL A NEW STORY");
    	//text("TELL A NEW STORY").click();
    	
    	MobileElement btn = findButton("TELL A NEW STORY");
    	if(btn == null)
    		return;
    	
    	btn.click();
    	
    	System.out.println("Ended afterSignIn_TellANewStory() method");
    }
    
    
    
    private boolean signIn() throws Exception {
    	System.out.println("Called signIn() method");
    	
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
    
    private boolean signIn_UsingFacebook() throws Exception {
    	System.out.println("Called signIn_UsingFacebook() method");
    	
    	// Set email
    	/*String email = "thanhdinh73@yahoo.com";
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
    		return false;*/
    	
    	Thread.sleep(2000);
    	System.out.println("Ended signIn_UsingFacebook() method");
    	
    	return true;
    }
    
    private void homeScreen() throws Exception {
    	System.out.println("Called homeScreen() method");
    	
    	// Click on "FAMILY STORIES"
    	System.out.println("Tap on: FAMILY STORIES");
    	text("FAMILY STORIES").click();
    	Thread.sleep(3000);
    	
    	// Click on "FAMILY"
    	System.out.println("Tap on: FAMILY");
    	//text("FAMILY").click(); // From Dec 03, 2015 - it did not work b/c there are many Family word in this screen.
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
    	System.out.println("Called homeScreen_FamilyTab() method");
    	
    	String searchFor = "Thanh Dinh";
    	
    	// Set First name and last name to search textfield
    	MobileElement meTextSearch = findTextField();
    	if(meTextSearch == null)
    		return;
    	
    	meTextSearch.setValue(searchFor);
    	
    	// Tap on Search icon
    	MobileElement meBtn = findButton("Button");
    	if(meBtn == null)
    		return;
    	
    	meBtn.click();
    	
    	// No results?
    	System.out.println("Finding: No results?");
    	MobileElement meNoResults = text("No results");
    	if(meNoResults != null)
    	{
    		System.out.println("Tap on Back button");
    		
    		// Tap on Back button
    		back();
    	}else
    	{
    		// Try to select all people if search found
    		for (MobileElement me : tags("UIATableCell"))
      	  	{
        		System.out.println("Table Cell: " + me.getText());
      		  	me.click();
      	  	}
    		
    		// After selected some people, tap on DONE button
    		MobileElement meDoneBtn = findButton("DONE");
    		if(meDoneBtn != null)
    			meDoneBtn.click();
    		
    		// Tap on "INVITE THEM BY EMAIL"
    		MobileElement meInviteBtn = findButton("INVITE THEM BY EMAIL");
    		if(meInviteBtn != null)
    			meInviteBtn.click();
    	}
    	
    	System.out.println("Ended homeScreen_FamilyTab() method");
    }
}