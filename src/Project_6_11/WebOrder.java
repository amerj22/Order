package Project_6_11;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebOrder {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/amersaleh/Documents/selenium dependencies/drivers/chromedriver");
		
		
			
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		String name = "Tester";
		String password = "test";
		Random rd = new Random();
		int r = rd.nextInt(101);
		
		
		
		WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
		WebElement ps = driver.findElement(By.id("ctl00_MainContent_password"));
		
		userName.sendKeys(name);
		ps.sendKeys(password);
		
		WebElement login = driver.findElement(By.name("ctl00$MainContent$login_button"));
		
		login.click();

		WebElement order = driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a"));
		
		order.click();
		
		WebElement qty = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
		
		qty.sendKeys(Keys.BACK_SPACE);;
		qty.sendKeys(""+r);
		
		WebElement CustName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
		
		char midName = (char)(rd.nextInt(26)+65);
		char midName1 = (char)(rd.nextInt(26)+65);
		String s = ""+midName+midName1;
		String fName = "John "+s+" Smith";
		CustName.sendKeys(fName);
		
		WebElement street = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
		street.sendKeys("2700 S. River Rd.");
		
		WebElement city = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
		city.sendKeys("Des Plains");
		
		WebElement state = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
		state.sendKeys("IL");
		
		WebElement zip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
		
		String zip1 = "";
		for(int i = 0; i < 5; i++) {
		zip1+=rd.nextInt(10);}
		
		zip.sendKeys(zip1);
		
		for(int i = 0; i < 2; i++) {
			int num = rd.nextInt(2);
			if(num == 0) {
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("4" + rd.nextInt(99999999)+""+rd.nextInt(9999999));
				break;
			}
			if(num == 1) {
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("5" + rd.nextInt(99999999)+""+rd.nextInt(9999999));
				break;
			}
			if(num == 2){
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("3" + rd.nextInt(9999999)+""+rd.nextInt(9999999));
				break;
			}
		}
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("03/21");
		Thread.sleep(5000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		String text = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText();
		if(text.equals("New order has been successfully added.")) {
			System.out.println("Your order succesfully added");
		}else {
			System.out.println("Your order didn't added");
		}
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}
		
		
	}
	


