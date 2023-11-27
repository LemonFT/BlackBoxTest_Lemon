package com.testcase.blackbox.BlackBoxTest;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSearchProduct {
	private WebDriver wdriver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/LAM/Downloads/chromedriver-win32/chromedriver-win32/chromedriver.exe");
        wdriver = new ChromeDriver();
        wdriver.get("http://127.0.0.1:5500/cart.html");
    }

    @AfterMethod
    public void tearDown() {
        wdriver.close();
    }

    public void sleepSelenium(long time) throws InterruptedException {
        Thread.sleep(time);
    }
    
    public boolean isElementPresentById(WebDriver driver, String elementId) {
        try {
            driver.findElement(By.className(elementId));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    @Test(priority = 1)
    public void searchWithOptionTrue() throws InterruptedException {
    	wdriver.findElement(By.id("searchIp")).sendKeys("Cake");
    	wdriver.findElement(By.className("ti-search")).click();
    	sleepSelenium(2000);
    	String rs = isElementPresentById(wdriver, "productItem")+ "";
    	Assert.assertEquals(rs, "true", "failure");
    }
    @Test(priority = 2)
    public void searchWithOptionResulNull() throws InterruptedException {
    	wdriver.findElement(By.id("searchIp")).sendKeys("abcdefgh");
    	wdriver.findElement(By.className("ti-search")).click();
    	sleepSelenium(2000);
    	String rs = isElementPresentById(wdriver, "noneResult")+ "";
    	Assert.assertEquals(rs, "true", "failure");
    }
    @Test(priority = 3)
    public void searchWithOptionInputNull() throws InterruptedException {
    	wdriver.findElement(By.className("ti-search")).click();
    	String mess = wdriver.switchTo().alert().getText();
    	wdriver.switchTo().alert().accept();
    	Assert.assertEquals(mess, "Bạn chưa nhập thông tin tìm kiếm", "failure");
    }
    @Test(priority = 4)
    public void searchWithOptionInputNotCaseSensitive() throws InterruptedException {
    	wdriver.findElement(By.id("searchIp")).sendKeys("cAKe");
    	wdriver.findElement(By.className("ti-search")).click();
    	sleepSelenium(2000);
    	String rs = isElementPresentById(wdriver, "productItem")+ "";
    	Assert.assertEquals(rs, "true", "failure");
    }
    
    @Test(priority = 5)
    public void searchWithOptionFilterNoResult() throws InterruptedException {
    	wdriver.findElement(By.id("searchIp")).sendKeys("Cake");
    	wdriver.findElement(By.className("ti-search")).click();
    	sleepSelenium(2000);
    	boolean rs = isElementPresentById(wdriver, "productItem");
    	if(rs == true) {
    		wdriver.findElement(By.id("btnFilter")).click();
    		wdriver.findElement(By.id("priceF")).sendKeys("300");
    		wdriver.findElement(By.className("ti-search")).click();
    	}
    	sleepSelenium(2000);
    	String rsFilter = isElementPresentById(wdriver, "noneResult")+ "";
    	Assert.assertEquals(rsFilter, "true", "failure");
    }
}
