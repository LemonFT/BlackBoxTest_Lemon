package com.testcase.blackbox.BlackBoxTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestUpdateProduct {
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
    public void updateAllInformation() throws InterruptedException {
    	wdriver.findElement(By.className("edit")).click();
    	sleepSelenium(1000);
    	wdriver.findElement(By.id("ipIdEdit")).sendKeys("22");
    	wdriver.findElement(By.id("btnSearch")).click();
    	
    	wdriver.findElement(By.id("Image")).sendKeys("D:\\PROJECT-BY_LEMON-YEAR2\\JAVASCRIPT-YEAR2\\image\\render1.jpeg");
        wdriver.findElement(By.id("Name")).sendKeys("ProductTest");
        wdriver.findElement(By.id("Price")).sendKeys("100");
        wdriver.findElement(By.id("Type")).sendKeys("Candy");
        wdriver.findElement(By.id("Amount")).sendKeys("100");
        wdriver.findElement(By.id("Title")).sendKeys("ProductUpdate");
    	wdriver.findElement(By.id("btnEditSave")).click();
    	sleepSelenium(1000);
    	String mess = wdriver.switchTo().alert().getText();
    	wdriver.switchTo().alert().accept();
    	Assert.assertEquals(mess, "Thông tin chỉnh sửa thành công!!", "failure");
    }
    @Test(priority = 2)
    public void updateSomeInformation() throws InterruptedException {
    	wdriver.findElement(By.className("edit")).click();
    	sleepSelenium(1000);
    	wdriver.findElement(By.id("ipIdEdit")).sendKeys("22");
    	wdriver.findElement(By.id("btnSearch")).click();
    	
        wdriver.findElement(By.id("Name")).sendKeys("ProductTest");
        wdriver.findElement(By.id("Price")).sendKeys("100");
        wdriver.findElement(By.id("Type")).sendKeys("Candy");
    	wdriver.findElement(By.id("btnEditSave")).click();
    	sleepSelenium(1000);
    	String mess = wdriver.switchTo().alert().getText();
    	wdriver.switchTo().alert().accept();
    	Assert.assertEquals(mess, "Thông tin chỉnh sửa thành công!!", "failure");
    }
    
    @Test(priority = 3)
    public void updateWithNullInfomation() throws InterruptedException {
    	wdriver.findElement(By.className("edit")).click();
    	sleepSelenium(1000);
    	wdriver.findElement(By.id("ipIdEdit")).sendKeys("22");
    	wdriver.findElement(By.id("btnSearch")).click();
    	wdriver.findElement(By.id("btnEditSave")).click();
    	sleepSelenium(1000);
    	String mess = wdriver.switchTo().alert().getText();
    	wdriver.switchTo().alert().accept();
    	Assert.assertEquals(mess, "Chưa có dữ liệu để thay thế", "failure");
    }
    
    @Test(priority = 4)
    public void updateWithIDNoneExist() throws InterruptedException {
    	wdriver.findElement(By.className("edit")).click();
    	sleepSelenium(1000);
    	wdriver.findElement(By.id("ipIdEdit")).sendKeys("999");
    	wdriver.findElement(By.id("btnSearch")).click();
    	sleepSelenium(1000);
    	String mess = wdriver.switchTo().alert().getText();
    	wdriver.switchTo().alert().accept();
    	Assert.assertEquals(mess, "ID bạn vừa nhập không tồn tại", "failure");
    }
    
    @Test(priority = 5)
    public void updateWithValueInvalid() throws InterruptedException {
    	wdriver.findElement(By.className("edit")).click();
    	sleepSelenium(1000);
    	wdriver.findElement(By.id("ipIdEdit")).sendKeys("22");
    	wdriver.findElement(By.id("btnSearch")).click();
    	
        wdriver.findElement(By.id("Amount")).sendKeys("mười");
        wdriver.findElement(By.id("Price")).sendKeys("100");
        wdriver.findElement(By.id("Type")).sendKeys("Candy");
    	wdriver.findElement(By.id("btnEditSave")).click();
    	sleepSelenium(1000);
    	String mess = wdriver.switchTo().alert().getText();
    	wdriver.switchTo().alert().accept();
    	Assert.assertEquals(mess, "Số lượng phải là giá trị bằng số", "failure");
    }
}
