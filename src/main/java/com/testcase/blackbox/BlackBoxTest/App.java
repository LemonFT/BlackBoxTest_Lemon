package com.testcase.blackbox.BlackBoxTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.testcase.blackbox.entity.entityProduct;

import org.testng.Assert;

public class App {

	public void sleepSelenium(long time) throws InterruptedException {
		Thread.sleep(time);
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/LAM/Downloads/chromedriver-win32/chromedriver-win32/chromedriver.exe");
		WebDriver wdriver = new ChromeDriver();
		wdriver.get("http://localhost:3000/");
		WebElement usernameInput = wdriver.findElement(By.id("username"));
		WebElement passwordInput = wdriver.findElement(By.className("ippass"));

		usernameInput.sendKeys("BlackBox");
		passwordInput.sendKeys("08102003");
		sleepSelenium(3000);
		// Locate and click the login button
		WebElement loginButton = wdriver.findElement(By.className("submit"));
		loginButton.click();
		sleepSelenium(5000);
		String currentUrl = wdriver.getCurrentUrl();
		 Assert.assertEquals(currentUrl, "http://localhost:3000/home", "URL after login is incorrect");
	}

}
