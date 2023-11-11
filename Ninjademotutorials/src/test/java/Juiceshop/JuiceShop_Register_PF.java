package Juiceshop;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class JuiceShop_Register_PF {
	
		
		public static WebDriver driver = new ChromeDriver();
		//public static WebDriver driver1 = new ChromeDriver();
		//PageFactory.initElements(driver, this);
		static String URL = "https://juice-shop.herokuapp.com/#/register";
		static @FindBy (xpath = "//*[@id='cookieconsent:desc']/..//a[@aria-label='dismiss cookie message']") WebElement dismissCookie;
		static @FindBy (xpath = "//button//span[text()='Dismiss']") WebElement dismissBtn;
		static @FindBy (id = "emailControl") WebElement emailID;
		static @FindBy (id = "passwordControl") WebElement passwordTxt;
		static @FindBy (id = "repeatPasswordControl") WebElement confirmPassword;
		static @FindBy (xpath = "//div[@id='mat-select-value-1']/span") WebElement secQnBox;
		static @FindBy (xpath = "//span[text()=' Your eldest siblings middle name? ']") WebElement secQn;
		static @FindBy (id = "securityAnswerControl") WebElement secQnAns;
		static @FindBy(id = "registerButton") WebElement register;
		static @FindBy(name = "email")WebElement email;
		static @FindBy(name = "password")WebElement password;
		static @FindBy(id = "loginButton") WebElement loginButton;
		//@FindBy(xpath = "//*[contains(text(),'Carrot')]/../../../div[2]/button") WebElement CarrotAddtoBasket;
		static @FindBy(xpath = "//*[contains(text(),'Carrot')]/../../..//*[contains(text(),'Basket')]") WebElement CarrotJuiceAddtoBasket;
		//@FindBy(xpath = "//*[@id='mat-select-2']/..//*[@class='mat-select-arrow ng-tns-c30-19']")WebElement itemselectDropDown;
		static @FindBy(xpath = "//button[@aria-label='Next page']") WebElement nextPage;
		static @FindBy(xpath = "//button[@aria-label='Previous page']") WebElement previousPage;
//		@FindBy(id = "mat-option-14") WebElement dropDownoption0;
//		@FindBy(id = "mat-option-15") WebElement dropDownoption1;
//		@FindBy(id = "mat-option-16") WebElement dropDownoption2;
		//static @FindBy(xpath = "//*[@id='cdk-overlay-7']") WebElement dialogBox;
		static @FindBy(tagName = "mat-dialog-container") WebElement dialogBox;
		static @FindBy(xpath="//button[@aria-label ='Close Dialog']") WebElement closeBtn;
		static @FindBy(xpath = "//*[contains(text(),'Mug')]/../../..//*[contains(text(),'Basket')]") WebElement MugAddtoBasket;
//		WebElement MugAddtoBasket = new WebDriverWait(driver,Duration.ofSeconds(20)).
//				until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Mug')]/../../..//*[contains(text(),'Basket')]")));
		static @FindBy(xpath="//*[text()=' Your Basket']")WebElement yourBasket;
		 //static @FindBy(xpath="//*[@data-icon='plus-square']")
		//static int i=0;
		static @FindBy(xpath="//mat-table/mat-row//*[@data-icon='plus-square']")List<WebElement> addquantity; 
		
		int findcount = driver.findElements(By.tagName("mat-table")).size();
		static @FindBy(id = "checkoutButton")WebElement CheckoutBtn;
		static @FindBy(xpath = "//*[text()= 'Add New Address']") WebElement addnewAddress;
		static @FindBy(xpath = "//input[@placeholder = 'Please provide a country.']")WebElement country;
		static @FindBy(xpath = "//input[@placeholder = 'Please provide a name.']")WebElement name;
		static @FindBy(xpath = "//input[@placeholder = 'Please provide a mobile number.']")WebElement mobileNo;
		static @FindBy(xpath = "//input[@placeholder = 'Please provide a ZIP code.']")WebElement zipCode;
		//static @FindBy(xpath = "//input[@placeholder = 'Please provide an address.']")WebElement address;
		static @FindBy(id = "address")WebElement address;
		static @FindBy(xpath = "//input[@placeholder = 'Please provide a city.']")WebElement city;
		static @FindBy(xpath = "//input[@placeholder = 'Please provide a state.']")WebElement state;
		static @FindBy(id = "submitButton")WebElement submitButton;
		static @FindBy(tagName = "mat-radio-button")WebElement radioBtn; 
		static @FindBy(xpath = "//*[text()='Continue']")WebElement ContinueBtn;
		static @FindBy(xpath = "//mat-row[2]//mat-radio-button")WebElement RadiobtnDelivery;
		static @FindBy(xpath = "//*[text()=' Add new card ']")WebElement addNewCard;
		//static @FindBy(className = "mat-content ng-tns-c41-32")WebElement addNewCard;
		//static @FindBy(xpath = "//*[text()='Name']")WebElement cardholderName;
		static @FindBy(id = "mat-input-14")WebElement cardholderName;
		//static @FindBy(xpath = "//*[text()='Card Number']")WebElement cardNumber;
		static @FindBy(id = "mat-input-15")WebElement cardNumber;
		static @FindBy(id = "mat-input-16")WebElement expiryMonth;
		static @FindBy(id = "mat-input-17")WebElement expiryYear;
		//static @FindBy(xpath = "//*[text()='Expiry Month']")WebElement expiryMonth;
		//static @FindBy(xpath = "//*[text()='Expiry Year']")WebElement expiryYear;
		static @FindBy(xpath = "//*[text()=' Add a coupon ']")WebElement addCoupon;
		static @FindBy(id = "coupon")WebElement coupon;
		static @FindBy(xpath  ="//*[text()='Invalid coupon. ']")WebElement invalidError;
		static @FindBy(id = "applyCouponButton")WebElement applyCouponButton;
		static @FindBy(xpath  ="//*[text()=' redeem ']")WebElement redeem;
		static @FindBy(xpath = "//button[@aria-label='Print order confirmation']")WebElement printnote; 
		ArrayList<String> newTbs = new ArrayList<String>(driver.getWindowHandles());
		//driver.switchTo().window(newTb.get(1));
		static @FindBy(id = "print")WebElement printBtn; 
		static @FindBy(partialLinkText = "Track")WebElement trackOrder;
		static @FindBy(id = "navbarAccount")WebElement accountBtn;
		static @FindBy(id = "navbarLogoutButton")WebElement navbarLogoutBtn;
		
		public void register() throws InterruptedException {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
			driver.manage().window().maximize();
			Actions action = new Actions(driver);
			PageFactory.initElements(driver, this);  
			dismissBtn.click();
			emailID.sendKeys("crzqnp@gmail.com");
			passwordTxt.sendKeys("Limna@123456");
			confirmPassword.sendKeys("Limna@123456");
			secQnBox.click();
			secQn.click();
			secQnAns.sendKeys("kumari");
			secQnAns.getText();
			register.click();
			PageFactory.initElements(driver, this); 
			email.click();
			email.sendKeys("crzqnp@gmail.com");
			password.click();
			password.sendKeys("Limna@123456");
			loginButton.click();
			PageFactory.initElements(driver, this); 
			//action.click(CarrotAddtoBasket).perform();
			action.scrollToElement(CarrotJuiceAddtoBasket).click(CarrotJuiceAddtoBasket).perform();	
			dismissCookie.click();
			//action.scrollByAmount(CarrotJuiceAddtoBasket.getRect().getX(),CarrotJuiceAddtoBasket.getRect().getY()).click(CarrotJuiceAddtoBasket).perform();
			//action.click(itemselectDropDown).perform();
			//action.scrollByAmount(itemselectDropDown.getRect().getX(), itemselectDropDown.getRect().getY()).click(itemselectDropDown).perform();
			//action.scrollToElement(dropDownoption2).contextClick(dropDownoption2);
			PageFactory.initElements(driver, this); 
//			if(dialogBox.isDisplayed()) {
//				action.click(closeBtn).perform();	
//			}
			action.scrollByAmount(nextPage.getRect().getX(),nextPage.getRect().getY()).click(nextPage).perform();
			nextPage.click();
			PageFactory.initElements(driver, this); 
//			if(dialogBox.isDisplayed()) {
//			Thread.sleep(2000);
//				action.click(closeBtn).perform();
//				Thread.sleep(2000);
//			}
			//
				PageFactory.initElements(driver, this);
				Thread.sleep(2000);
				action.scrollByAmount(MugAddtoBasket.getRect().getX(),MugAddtoBasket.getRect().getY()).click(MugAddtoBasket).perform();
		
			MugAddtoBasket.click();
			action.click(yourBasket).perform();
			PageFactory.initElements(driver, this);
			
			for(WebElement findcounts : addquantity) {
				((JavascriptExecutor)driver).executeScript("window.scrollBy(0,130)");
				findcounts.findElement(By.xpath("//mat-table/mat-row//*[@data-icon='plus-square']")).click();
				//Thread.sleep(1000);
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				((JavascriptExecutor)driver).executeScript("window.scrollBy(0,130)");
			}
			
			CheckoutBtn.click();
			PageFactory.initElements(driver, this);
			addnewAddress.click();
			PageFactory.initElements(driver, this);
			//Thread.sleep(2000);
			country.sendKeys("United States");
			name.sendKeys("Limna");
			mobileNo.sendKeys("9667610966");
			zipCode.sendKeys("46175");
			address.sendKeys("14103 Nicholas Dr");
			city.sendKeys("Indianapolis");
			state.sendKeys("Indiana");
			submitButton.click();
			PageFactory.initElements(driver, this);
			radioBtn.click();
			ContinueBtn.click();
			PageFactory.initElements(driver, this);
			RadiobtnDelivery.click();
			ContinueBtn.click();
			PageFactory.initElements(driver, this);
			addNewCard.click();
			PageFactory.initElements(driver, this);
			cardholderName.sendKeys("Limna");
			cardNumber.sendKeys("2123456789123456");
			expiryMonth.click();
			Select dropdownMonth = new Select(expiryMonth);
			dropdownMonth.selectByIndex(7);
			expiryYear.click();
			Select dropdownYear = new Select(expiryYear);
			dropdownYear.selectByValue("2090");
			submitButton.click();
			addCoupon.click();
			coupon.sendKeys("5617971016");
			applyCouponButton.click();
			redeem.click();
			System.out.println(invalidError.getText());
			radioBtn.click();
			ContinueBtn.click();
			PageFactory.initElements(driver, this);
			CheckoutBtn.click();
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			printnote.click();
			//ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
			PageFactory.initElements(driver, this);
//			action.click(printBtn).perform();
//			printBtn.click();
			//driver.navigate().to("https://juice-shop.herokuapp.com/#/payment/shop");
			 System.out.println("Page title is before siwtch to new window: " + driver.getTitle());
			 System.out.println("Number of windows opned : "+ newTbs.size());
			 String currentTab = driver.getWindowHandle();
			 System.out.println("currentTab " + currentTab);
			 System.out.println("current title " + driver.getTitle());
			//driver.switchTo().window(newTbs.get(1));
			 System.out.println("after Page title is : " + driver.getTitle());
			//driver.close();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 System.out.println("after Page title is : " + driver.getTitle());
//			 for (String newTb : newTbs ) {
//				 if(!newTb.equalsIgnoreCase(currentTab)) {
//					 driver.switchTo().window(newTb); 
//					 System.out.println("after Page title is : " + driver.getTitle());
//					 printBtn.click();
//					 Thread.sleep(5000);
//				 }
//			 }
			//PageFactory.initElements(driver, this);
			//String clickl = Keys.chord(Keys.CONTROL,Keys.ENTER);
			//printBtn.sendKeys(clickl);
			//printBtn.click();
//			 JavaScriptExecutor js1 = (JavaScriptExecutor) driver;
//			 js1.ExecuteScript("setTimeout(function() { window.print(); }, 0);");
//			 driver.SwitchTo().Window(driver.WindowHandles.Last());
//			 Thread.Sleep(2000);
//			 string JSPath = "document.querySelector('body>print-preview-app').shadowRoot.querySelector('#sidebar').shadowRoot.querySelector('print-preview-button-strip').shadowRoot.querySelector('cr-button.cancel-button')";
//			 WebElement cancelBtn = (IWebElement)js.ExecuteScript($"return {JSPath}");
//			 cancelBtn.Click();
			driver.switchTo().window(newTbs.get(0));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 System.out.println("Page title is : " + driver.getTitle());
			//driver.navigate().to("https://juice-shop.herokuapp.com/#/order-completion/8e49-7d758a319b0c1821");
			//PageFactory.initElements(driver, this);
			trackOrder.click();
			//action.click(printBtn).perform();
			//driver.switchTo().window("https://juice-shop.herokuapp.com/#/order-completion/8e49-7d758a319b0c1821");
			accountBtn.click();
			//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,130)");
			navbarLogoutBtn.click();
			//driver.switchTo().window("https://juice-shop.herokuapp.com/#/order-completion/8e49-7d758a319b0c1821");
			//driver.switchTo().window(newTbs.get(1));
			//System.out.println("after Page title is : " + driver.getTitle());
			//printBtn.click();
		}
		
		public void main(String[] args) throws InterruptedException {
			
			 register();
			
			}
}


