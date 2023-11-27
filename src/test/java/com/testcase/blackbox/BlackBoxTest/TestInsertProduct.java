package com.testcase.blackbox.BlackBoxTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestInsertProduct {
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
        wdriver.findElement(By.className("add")).click();
    }

    @AfterMethod
    public void tearDown() {
        wdriver.close();
    }

    public void sleepSelenium(long time) throws InterruptedException {
        Thread.sleep(time);
    }
    @Test(priority = 1)
    public void addProduct() throws InterruptedException {
    	wdriver.findElement(By.id("ipFile")).sendKeys("D:\\PROJECT-BY_LEMON-YEAR2\\JAVASCRIPT-YEAR2\\image\\render1.jpeg");
        wdriver.findElement(By.id("ipName")).sendKeys("ProductTest");
        wdriver.findElement(By.id("ipPrice")).sendKeys("100");
        wdriver.findElement(By.id("ipTitle")).sendKeys("ProductTest");
        wdriver.findElement(By.id("ipType")).sendKeys("Cake");
        wdriver.findElement(By.id("ipAmount")).sendKeys("10");
        wdriver.findElement(By.id("addProduct")).click();
        sleepSelenium(1000);
        wdriver.switchTo().alert().accept();
        sleepSelenium(1000);
        String mess = wdriver.switchTo().alert().getText();
        wdriver.switchTo().alert().accept();
        Assert.assertEquals(mess, "Thêm thành công", "Thêm thất bại");
    }
    
    @Test(priority = 2)
    public void addProductWithEmptyValue() throws InterruptedException {
        wdriver.findElement(By.id("ipName")).sendKeys("ProductTest");
        wdriver.findElement(By.id("ipType")).sendKeys("Cake");
        wdriver.findElement(By.id("ipAmount")).sendKeys("10");
        wdriver.findElement(By.id("addProduct")).click();
        sleepSelenium(1000);
        String mess = wdriver.switchTo().alert().getText();
        wdriver.switchTo().alert().accept();
        Assert.assertEquals(mess, "Kiểm tra lại thông tin", "Thêm thất bại");
    }
    @Test(priority = 3)
    public void addProductWithValueExist() throws InterruptedException {
    	wdriver.findElement(By.id("ipFile")).sendKeys("D:\\PROJECT-BY_LEMON-YEAR2\\JAVASCRIPT-YEAR2\\image\\render1.jpeg");
        wdriver.findElement(By.id("ipName")).sendKeys("ProductTest");
        wdriver.findElement(By.id("ipPrice")).sendKeys("100");
        wdriver.findElement(By.id("ipTitle")).sendKeys("ProductTest");
        wdriver.findElement(By.id("ipType")).sendKeys("Cake");
        wdriver.findElement(By.id("ipAmount")).sendKeys("10");
        wdriver.findElement(By.id("addProduct")).click();
        sleepSelenium(1000);
        wdriver.switchTo().alert().accept();
        sleepSelenium(1000);
        wdriver.switchTo().alert().accept();
        
        wdriver.findElement(By.id("ipFile")).sendKeys("D:\\PROJECT-BY_LEMON-YEAR2\\JAVASCRIPT-YEAR2\\image\\render1.jpeg");
        wdriver.findElement(By.id("ipName")).sendKeys("ProductTest");
        wdriver.findElement(By.id("ipPrice")).sendKeys("100");
        wdriver.findElement(By.id("ipTitle")).sendKeys("ProductTest");
        wdriver.findElement(By.id("ipType")).sendKeys("Cake");
        wdriver.findElement(By.id("ipAmount")).sendKeys("10");
        wdriver.findElement(By.id("addProduct")).click();
        sleepSelenium(1000);
        wdriver.switchTo().alert().accept();
        sleepSelenium(1000);
        String mess = wdriver.switchTo().alert().getText();
        wdriver.switchTo().alert().accept();
        Assert.assertEquals(mess, "Thêm thất bại", "Thêm thất bại");
    }
    @Test(priority = 4)
    public void addProductWithAmountNotNumber() throws InterruptedException {
    	wdriver.findElement(By.id("ipFile")).sendKeys("D:\\PROJECT-BY_LEMON-YEAR2\\JAVASCRIPT-YEAR2\\image\\render1.jpeg");
        wdriver.findElement(By.id("ipName")).sendKeys("ProductTest");
        wdriver.findElement(By.id("ipPrice")).sendKeys("100");
        wdriver.findElement(By.id("ipTitle")).sendKeys("ProductTest");
        wdriver.findElement(By.id("ipType")).sendKeys("Cake");
        wdriver.findElement(By.id("ipAmount")).sendKeys("anb");
        wdriver.findElement(By.id("addProduct")).click();
        sleepSelenium(1000);
        String mess = wdriver.switchTo().alert().getText();
        System.out.println(mess);
        wdriver.switchTo().alert().accept();
        Assert.assertEquals(mess, "Giá phải là giá trị bằng số", "Thêm thất bại");
    }
    @Test(priority = 5)
  public void addProductWithTypeNotExist() throws InterruptedException {
  	wdriver.findElement(By.id("ipFile")).sendKeys("D:\\PROJECT-BY_LEMON-YEAR2\\JAVASCRIPT-YEAR2\\image\\render1.jpeg");
      wdriver.findElement(By.id("ipName")).sendKeys("ProductTest");
      wdriver.findElement(By.id("ipPrice")).sendKeys("100");
      wdriver.findElement(By.id("ipTitle")).sendKeys("ProductTest");
      wdriver.findElement(By.id("ipType")).sendKeys("NotType");
      wdriver.findElement(By.id("ipAmount")).sendKeys("10");
      wdriver.findElement(By.id("addProduct")).click();
      sleepSelenium(1000);
      String mess = wdriver.switchTo().alert().getText();
      System.out.println(mess);
      wdriver.switchTo().alert().accept();
      Assert.assertEquals(mess, "Vui lòng điền đúng thể loại: Cake, Cookie, Candy, Croissants, Bread, Lollipop!", "Thêm thất bại");
  }
}
