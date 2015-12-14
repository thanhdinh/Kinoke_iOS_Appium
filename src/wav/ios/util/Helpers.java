package wav.ios.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class Helpers {

  private static AppiumDriver driver;
  private static WebDriverWait driverWait;

  /**
   * Initialize the webdriver. Must be called before using any helper methods. *
   */
  public static void init(AppiumDriver webDriver) {
    driver = webDriver;
    int timeoutInSeconds = 60;
    // must wait at least 60 seconds for running on Sauce.
    // waiting for 30 seconds works locally however it fails on Sauce.
    driverWait = new WebDriverWait(webDriver, timeoutInSeconds);
  }

  /**
   * Wrap WebElement in MobileElement *
   */
  private static MobileElement w(WebElement element) {
    return new MobileElement((RemoteWebElement) element, driver);
  }

  /**
   * Wrap WebElement in MobileElement *
   */
  private static List<MobileElement> w(List<WebElement> elements) {
    List list = new ArrayList(elements.size());
    for (WebElement element : elements) {
      list.add(w(element));
    }

    return list;
  }

  /**
   * Return an element by locator *
   */
  public static MobileElement element(By locator) {
    return w(driver.findElement(locator));
  }
  
  /**
   * Return an element by locator *
   */
  public static WebElement elementWE(By locator) {
    return driver.findElement(locator);
  }

  /**
   * Return a list of elements by locator *
   */
  public static List<MobileElement> elements(By locator) {
    return w(driver.findElements(locator));
  }
  
  /**
   * Return a list of elements by locator *
   */
  public static List<WebElement> elements1(By locator) {
    return driver.findElements(locator);
  }

  /**
   * Press the back button *
   */
  public static void back() {
    driver.navigate().back();
  }

  /**
   * Return a list of elements by tag name *
   */
  public static List<MobileElement> tags(String tagName) {
    return elements(for_tags(tagName));
  }
  
  /**
   * Return a list of elements by tag name *
   */
  public static List<WebElement> tagsWE(String tagName) {
    return elements1(for_tags(tagName));
  }
  
  /**
   * Return a tag name locator *
   */
  public static By for_tags(String tagName) {
    return By.className(tagName);
  }

  /**
   * Find a button by its name.
   */
  public static MobileElement findButton(String name)
  {
	  System.out.println("Find button: " + name);
	  
	  for (MobileElement me : tags("UIAButton")) {
		  if(me.getText() == null || !me.getText().equals(name))
      		continue;
      	
		  System.out.println("Found button: " + name);
      		return me;
	  }
	  
	  System.out.println("Not found button: " + name);
	  return null;
  }
  
  /**
   * Find a button by its name.
   */
  public static WebElement findButtonWE(String name)
  {
	  System.out.println("Find button: " + name);
	  
	  for (WebElement me : tagsWE("UIAButton")) {
		  if(me.getText() == null || !me.getText().equals(name))
      		continue;
      	
		  System.out.println("Found button: " + name);
      		return me;
	  }
	  
	  System.out.println("Not found button: " + name);
	  return null;
  }
  
  /**
   * Find the first TextField.
   */
  public static MobileElement findTextField()
  {
	  System.out.println("Find first TextField");
	  
	  for (MobileElement me : tags("UIATextField"))
	  {
		  System.out.println("Found first TextField.");  
      		return me;
	  }
	  
	  System.out.println("Not Found any TextFields.");
	  return null;
  }
  
  /**
   * Find the first TextField.
   */
  public static WebElement findTextFieldWE()
  {
	  System.out.println("Find first TextField");
	  
	  for (WebElement we : tagsWE("UIATextField"))
      	return we;
	  
	  return null;
  }
  
  /**
   * Return a static text element by xpath index *
   */
  public static MobileElement text(int xpathIndex) {
    return element(for_text(xpathIndex));
  }

  /**
   * Return a static text locator by xpath index *
   */
  public static By for_text(int xpathIndex) {
    return By.xpath("//UIAStaticText[" + xpathIndex + "]");
  }

  /**
   * Return a static text element that contains text *
   */
  public static MobileElement text(String text) {
    return element(for_text(text));
  }

  /**
   * Return a static text locator that contains text *
   */
  public static By for_text(String text) {
    String up = text.toUpperCase();
    String down = text.toLowerCase();
    return By.xpath("//UIAStaticText[@visible=\"true\" and (contains(translate(@name,\"" + up
        + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@hint,\"" + up
        + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@label,\"" + up
        + "\",\"" + down + "\"), \"" + down + "\") or contains(translate(@value,\"" + up
        + "\",\"" + down + "\"), \"" + down + "\"))]");
  }

  /**
   * Return a static text element by exact text *
   */
  public static MobileElement text_exact(String text) {
    return element(for_text_exact(text));
  }

  /**
   * Return a static text locator by exact text *
   */
  public static By for_text_exact(String text) {
    return By.xpath("//UIAStaticText[@visible=\"true\" and (@name=\"" + text
        + "\" or @hint=\"" + text + "\" or @label=\"" + text
        + "\" or @value=\"" + text + "\")]");
  }

  /**
   * Wait 30 seconds for locator to find an element *
   */
  public static MobileElement wait(By locator) {
    return w(driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
  }

  /**
   * Wait 60 seconds for locator to find all elements *
   */
  public static List<MobileElement> waitAll(By locator) {
    return w(driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
  }
  
  public static WebElement scrollTo(String txt)
  {
	  return driver.scrollTo(txt);
  }
}