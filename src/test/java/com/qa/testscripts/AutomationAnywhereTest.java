package com.qa.testscripts;



import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;



public class AutomationAnywhereTest {

	WebDriver driver=null;

	@BeforeTest

	public void setUp() {

		WebDriverManager.chromedriver().setup();

		  driver =new ChromeDriver();

		  driver.get("https://www.automationanywhere.com/");

		  driver.manage().window().maximize();

		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	        //Thread.sleep(2000);

	        driver.findElement(By.id("onetrust-accept-btn-handler")).click();



	}

	 @Test(priority = 1, enabled = true, timeOut = 12000)

	    public void verifyLogoPresence() {

	        driver.get("https://www.automationanywhere.com/");



	        // Verify Automation Anywhere logo is present

	        WebElement logo = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[1]/div/a/img"));

	        Assert.assertTrue(logo.isDisplayed(), "Automation Anywhere logo is not present.");

	    }



	    @Test(priority = 2, enabled = true, timeOut = 12000)

	    public void verifyRequestDemoButton() {

	        driver.get("https://www.automationanywhere.com/");



	        // Verify Request demo button is present

	        WebElement requestDemoButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/article/div/div/div/div[1]/div/div/div/div[1]/a"));

	        Assert.assertTrue(requestDemoButton.isDisplayed(), "Request demo button is not present.");



	        // Verify if Request demo button is clickable

	        Assert.assertTrue(requestDemoButton.isEnabled(), "Request demo button is not clickable.");

	    }



	    @AfterClass

	    public void tearDown() {

	        driver.quit();

	    }

	}