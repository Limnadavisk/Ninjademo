package DemoTutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.interactions.Actions;

public class Demo {
	//static ChromeOptions co = new ChromeOptions();
	//co.setAcceptInsecureCerts(true);
	//static WebDriver driver = new ChromeDriver(co);
	//static Actions action = new Actions(driver);
	public static void ninjademoTutorials() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\limna\\eclipse-workspace\\Ninjademotutorials\\src\\test\\resources\\driver\\chromedriver.exe");
	
	
	ChromeOptions co = new ChromeOptions();
	co.setAcceptInsecureCerts(true);
	WebDriver driver = new ChromeDriver(co);
	co.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	PageFactory.initElements(driver, driver);
	//chromeOptions.addExtensions(new File("C:\\Users\\limna\\eclipse-workspace\\Sample_demoqa\\src\\test\\resources\\CRXfile\\BlockSite-Block-Websites-Stay-Focused.crx"));

	driver.get("https://westbengal.covidsafe.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//Actions action = new Actions(driver);
	//JavascriptExecutor js=(JavascriptExecutor) driver;
	//Thread.sleep(5000);
	WebElement loadbtn = driver.findElement(By.xpath("//button[text()='Load next 20']"));
	//int noOfHosp = driver.findElements(By.tagName("tr")).size();
	int j = 0;
	int i =0;
	//System.out.print(noOfHosp);
	do {
		int noOfHosp = driver.findElements(By.tagName("tr")).size();
		for( i=j+1;i<noOfHosp;i++) {
			WebElement hospLink = driver.findElement(By.xpath("//tbody/tr["+i+"]//button"));
			String hospname = hospLink.getText();
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println(i+".Name of the Hospital is: " +hospname);
			//hospLink.click();
			WebElement textele = driver.findElement(By.xpath("//tbody/tr["+i+"]//td[@class='text-center']"));
			System.out.println("Without Oxygen: " +textele.getText());
			
			WebElement textele2 = driver.findElement(By.xpath("//tbody/tr["+i+"]//td[3][@class='text-center']"));
			System.out.println("With Oxygen: " +textele2.getText());
			
			WebElement textele3 = driver.findElement(By.xpath("//tbody/tr["+i+"]//td[4][@class='text-center']"));
			System.out.println("ICU without Ventilator " +textele3.getText());
			
			WebElement textele4 = driver.findElement(By.xpath("//tbody/tr["+i+"]//td[5][@class='text-center']"));
			System.out.println("ICU with Ventilator " +textele4.getText());
			//System.out.println("in the loop"); 
			//Thread.sleep(2000);
	//		WebElement hospLink = new WebDriverWait(driver,Duration.ofSeconds(20)).
	//				until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr["+j+"]//strong")));
	//		action.scrollByAmount(hospLink.getRect().getX(),hospLink.getRect().getY()).click(hospLink).perform();
			//WebElement hospLink = new WebDriverWait(driver,Duration.ofSeconds(10)).
					//until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr["+j+"]//button")));
			hospLink.click();
			WebElement hosplink2=driver.findElement(By.xpath("//tr[@class='border-bottom']/td"));
			System.out.println(hosplink2.getText());
			//System.out.println("------------------------------------------------------------");
			WebElement hosplink = driver.findElement(By.xpath("//tbody/tr["+i+"]//strong"));
			hosplink.click();
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,130)");
			// System.out.println("end the loop"); 
			
		}
		j = i;
		//WebElement loadbtn;
		loadbtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(2000);
		
	}while(loadbtn.isDisplayed() && loadbtn.isEnabled());
	
//	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))
//			.pollingEvery(Duration.ofMillis(100))
//			.ignoring(ElementClickInterceptedException.class)
//			.ignoring(NoSuchElementException.class);
	//for(int j=1;j<noOfHosp;j++) {
		//WebElement hospLink = driver.findElement(By.xpath("//tbody/tr["+j+"]//strong"));
//		
		//System.out.println("in the loop"); 
		//Thread.sleep(2000);
//		WebElement hospLink = new WebDriverWait(driver,Duration.ofSeconds(20)).
//				until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr["+j+"]//strong")));
//		action.scrollByAmount(hospLink.getRect().getX(),hospLink.getRect().getY()).click(hospLink).perform();
		//WebElement hospLink = new WebDriverWait(driver,Duration.ofSeconds(10)).
				//until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr["+j+"]//button")));
		//hospLink.click();
		//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,130)");
		 //System.out.println("end the loop"); 
		 //Thread.sleep(2000);
		 
	
	
	//while()
	}
//	public static void loadNext() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebElement loadbtn = new WebDriverWait(driver,Duration.ofSeconds(20)).
//			until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Load next 20']")));
//	//WebElement loadbtn = driver.findElement(By.xpath("//button[text()='Load next 20']"));
//	while(loadbtn.isDisplayed() && loadbtn.isEnabled()) {
//		
//		((JavascriptExecutor)driver).executeScript("window.scrollBy(800,3000)");
//		action.scrollByAmount(loadbtn.getRect().getX(),loadbtn.getRect().getY()).click(loadbtn).perform();
//		action.click(loadbtn).perform();
//		ninjademoTutorials();
//		
//		}
//	}
	
	
public static void main(String[] args) throws InterruptedException {
		
	ninjademoTutorials();
	//loadNext();
	}
}
