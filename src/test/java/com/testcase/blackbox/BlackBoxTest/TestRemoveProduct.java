package com.testcase.blackbox.BlackBoxTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRemoveProduct {
	private WebDriver wdriver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/LAM/Downloads/chromedriver-win32/chromedriver-win32/chromedriver.exe");
        wdriver = new ChromeDriver();
        wdriver.get("http://127.0.0.1:5500/index.html");
        wdriver.get("http://127.0.0.1:5500/admin.html");
        wdriver.findElement(By.className("ti-menu")).click();
        sleepSelenium(1000);
        wdriver.findElement(By.id("openSubList")).click();
        sleepSelenium(1000);
        wdriver.findElement(By.className("remove")).click();
    }

    @AfterMethod
    public void tearDown() {
        wdriver.close();
    }

    public void sleepSelenium(long time) throws InterruptedException {
        Thread.sleep(time);
    }
    
    @Test(priority = 1)
    public void removeAndAccept() throws InterruptedException {
    	wdriver.findElement(By.className("id")).click();
    	sleepSelenium(1000);
    	wdriver.switchTo().alert().accept();
    	sleepSelenium(1000);
    	String mess = wdriver.switchTo().alert().getText();
    	wdriver.switchTo().alert().accept();
    	Assert.assertEquals(mess, "Xóa thành công", "Xóa thất bại");
    }
    @Test(priority = 2)
    public void removeAndDismiss() throws InterruptedException {
    	wdriver.findElement(By.className("id")).click();
    	sleepSelenium(1000);
    	wdriver.switchTo().alert().dismiss();
    	sleepSelenium(1000);
    	String mess = wdriver.switchTo().alert().getText();
    	wdriver.switchTo().alert().accept();
    	Assert.assertEquals(mess, "Bạn chưa xóa sản phẩm", "Xóa thất bại");
    }
}
