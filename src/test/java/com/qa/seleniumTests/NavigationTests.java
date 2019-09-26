package com.qa.seleniumTests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTests {

    ChromeDriver driver;
    static ExtentTest test;
    static ExtentReports extent;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testNavigatePages() throws InterruptedException {
        extent = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\reports.html", false);
        test = extent.startTest("Selenium Test navigate pages");

        driver.get("http://34.89.83.113/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div/nav/div/div/ul/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/nav/div/div/ul/li[3]/a")).click();
        Thread.sleep(2000);

        test.log(LogStatus.PASS, "Test Passed");
        extent.endTest(test);
        extent.flush();
    }


}
