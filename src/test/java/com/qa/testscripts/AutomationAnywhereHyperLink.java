package com.qa.testscripts;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

 

import io.github.bonigarcia.wdm.WebDriverManager;

 

public class AutomationAnywhereHyperLink {

 

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.automationanywhere.com/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //Thread.sleep(2000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        SoftAssert sa=new SoftAssert();
        Actions actions=new Actions(driver);



        //WebElements
        WebElement productLink = driver.findElement(By.xpath(
                "/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[1]/a"));
        WebElement solutionsLink = driver.findElement(By.xpath(
                "/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[2]/a"));
        WebElement resourcesLink = driver.findElement(By.xpath(
                "/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[3]/a"));
        WebElement beyondRPALink = driver.findElement(By.xpath(
                "/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[4]/a"));
        WebElement companyLink = driver.findElement(By.xpath(
                "/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[5]/a"));

        //Verifying presence of element
        sa.assertTrue(productLink.isDisplayed());
        sa.assertTrue(solutionsLink.isDisplayed());
        sa.assertTrue(resourcesLink.isDisplayed());
        sa.assertTrue(beyondRPALink.isDisplayed());
        sa.assertTrue(companyLink.isDisplayed());

        System.out.println("All the elements are present on homepage");


        //verifying the link
        productLink.click();
        System.out.println("Product link is clickable");
        //Boolean url = driver.getCurrentUrl().equals("https://www.automationanywhere.com/products");
        //sa.assertTrue(url);

 

        Thread.sleep(2000);
        actions.moveToElement(solutionsLink).click();
       // actions.click(solutionsLink).perform();
        //solutionsLink.click();
        sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/solutions"));
        System.out.println("Solution link is clickable");
        

        Thread.sleep(2000);
        actions.moveToElement(resourcesLink).click();
       // actions.click(resourcesLink).perform();
        //resourcesLink.click();
        sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/resources"));
        System.out.println("Resources link is clickable");

        Thread.sleep(2000);
        actions.moveToElement(beyondRPALink).click();
        //actions.click(beyondRPALink).perform();
        //beyondRPALink.click();
        sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/rpa/robotic-process-automation"));
        System.out.println("BeyondRPA link is clickable");

        Thread.sleep(2000);
        actions.moveToElement(companyLink).click();
       // actions.click(companyLink).perform();
        //companyLink.click();
        sa.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/company/about-us"));
        System.out.println("Company  link is clickable");

        System.out.println("All the Links are navigating to corresponding page");

        driver.close();

    }
}



