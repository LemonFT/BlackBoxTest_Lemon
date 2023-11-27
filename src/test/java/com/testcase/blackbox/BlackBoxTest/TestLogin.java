package com.testcase.blackbox.BlackBoxTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestLogin {
	private WebDriver wdriver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/LAM/Downloads/chromedriver-win32/chromedriver-win32/chromedriver.exe");
        wdriver = new ChromeDriver();
        wdriver.get("http://127.0.0.1:5500/login.html");
    }

    @AfterMethod
    public void tearDown() {
        wdriver.close();
    }

    public void sleepSelenium(long time) throws InterruptedException {
        Thread.sleep(time);
    }

    @Test(priority = 1)
    public void loginWithValidCredentials() throws InterruptedException {
        WebElement usernameInput = wdriver.findElement(By.id("inputName"));
        WebElement passwordInput = wdriver.findElement(By.id("inputPass"));
        usernameInput.sendKeys("ADMINADMIN");
        passwordInput.sendKeys("08102003");
        WebElement loginButton = wdriver.findElement(By.id("btnSubmit"));
        loginButton.click();
        sleepSelenium(3000);
        String currentUrl = wdriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://127.0.0.1:5500/index.html", "Điều hướng đến trang home không thành công.");
    }

    @Test(priority = 2)
    public void loginWithNonexistentUser() throws InterruptedException {
    	WebElement usernameInput = wdriver.findElement(By.id("inputName"));
        WebElement passwordInput = wdriver.findElement(By.id("inputPass"));
        usernameInput.sendKeys("nonexistentuser");
        passwordInput.sendKeys("pass1234");
        WebElement loginButton = wdriver.findElement(By.id("btnSubmit"));
        loginButton.click();
        String mess = wdriver.findElement(By.id("contentMess")).getText();
        Assert.assertEquals(mess, "Tài khoản không tồn tại", "Message after form submission is incorrect");    
    }

    @Test(priority = 3)
    public void validateFunctionWithShortCredentials() throws InterruptedException {
    	WebElement usernameInput = wdriver.findElement(By.id("inputName"));
        WebElement passwordInput = wdriver.findElement(By.id("inputPass"));
        usernameInput.sendKeys("abc");
        passwordInput.sendKeys("12345678");
        WebElement loginButton = wdriver.findElement(By.id("btnSubmit"));
        loginButton.click();
        String mess = wdriver.findElement(By.id("contentMess")).getText();
        Assert.assertEquals(mess, "Vui lòng kiểm tra lại thông tin", "Message after form submission is incorrect");  
    }

    @Test(priority = 4)
    public void validateFunctionWithNumericUsername() throws InterruptedException {
    	WebElement usernameInput = wdriver.findElement(By.id("inputName"));
        WebElement passwordInput = wdriver.findElement(By.id("inputPass"));
        usernameInput.sendKeys("15522552521");
        passwordInput.sendKeys("pass1234");
        WebElement loginButton = wdriver.findElement(By.id("btnSubmit"));
        loginButton.click();
        String mess = wdriver.findElement(By.id("contentMess")).getText();
        Assert.assertEquals(mess, "Tên đăng nhập này không an toàn", "Message after form submission is incorrect");  
    }

    @Test(priority = 5)
    public void validateFunctionWithEmptyCredentials() throws InterruptedException {
    	WebElement usernameInput = wdriver.findElement(By.id("inputName"));
        WebElement passwordInput = wdriver.findElement(By.id("inputPass"));
        usernameInput.sendKeys("");
        passwordInput.sendKeys("");
        WebElement loginButton = wdriver.findElement(By.id("btnSubmit"));
        loginButton.click();
        String mess = wdriver.findElement(By.id("contentMess")).getText();
        Assert.assertEquals(mess, "Bạn chưa điền đầy đủ thông tin", "Message after form submission is incorrect");  
    }
}
