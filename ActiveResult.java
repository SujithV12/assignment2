package com.healthcaresite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ActiveResult 
{
	
	public WebDriver driver;
	@Test()
	public void Result() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Registration Desk")).click();
		driver.findElement(By.id("loginButton")).click();
		
		Thread.sleep(5000);
		String validatetitle = driver.getTitle();
		System.out.println(validatetitle);
		
		driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
		 Thread.sleep(2000);
		
		 driver.findElement(By.name("givenName")).sendKeys("Bruce");
		 driver.findElement(By.name("familyName")).sendKeys("wayne");
		 driver.findElement(By.id("next-button")).click();
			Thread.sleep(1000);
			WebElement gender = driver.findElement(By.id("gender-field"));
			Select s1 = new Select(gender);
			s1.selectByValue("M");
			driver.findElement(By.id("next-button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("birthdateDay-field")).sendKeys("30");
			WebElement month = driver.findElement(By.id("birthdateMonth-field"));
			Select s2 = new Select(month);
			s2.selectByValue("3");
			driver.findElement(By.id("birthdateYear-field")).sendKeys("1930");
			driver.findElement(By.id("next-button")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("address1")).sendKeys("224 park drive");
			driver.findElement(By.id("cityVillage")).sendKeys("Goutham");
			driver.findElement(By.id("stateProvince")).sendKeys("NewJersy");
			driver.findElement(By.id("country")).sendKeys("USA");
			driver.findElement(By.id("postalCode")).sendKeys("72000");
			driver.findElement(By.id("next-button")).click();
			driver.findElement(By.name("phoneNumber")).sendKeys("919399");
			driver.findElement(By.id("next-button")).click();
			
			driver.findElement(By.id("next-button")).click();
			
			driver.findElement(By.id("submit")).click();
			
			WebElement ele = driver.findElement(By.className("float-sm-right"));
			String id = ele.getText();
			System.out.println(id);
			
	WebElement address = driver.findElement(By.id("patient-header-contactInfo"));
	address.click();
			String detail = address.getText();
			System.out.println(detail);
			String addressdetail = "224 park drive, GouthamNew JerseyUSA72000";
			if(detail.equals(addressdetail)) 
			{
				System.out.println("true");
			}
				Thread.sleep(2000);	
		WebElement home = driver.findElement(By.xpath("//i[@class='icon-home small']"));
		home.click();
		Thread.sleep(2000);
		driver.findElement(By.id("org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-controls='active-visits']")).sendKeys("100HUN");
		Thread.sleep(2000);
		driver.close();
	}
}
