package com.qa.seleniumTests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelationalTests {

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
    public void testExercise() throws InterruptedException {

        extent = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\reports.html", false);
        test = extent.startTest("Selenium Test exercise relational table");

        driver.get("http://34.89.83.113/Exercises.html");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[1]/td[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[6]/div/div/form/div/input[1]")).sendKeys("11");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[6]/div/div/form/div/button")).click();
        Thread.sleep(4000);

        test.log(LogStatus.PASS, "Test Passed");
        extent.endTest(test);
        extent.flush();
    }

    @Test
    public void testMachine() throws InterruptedException {
        extent = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\reports.html", false);
        test = extent.startTest("Selenium Test machine relational table");

        driver.get("http://34.89.83.113/Machines.html");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[1]/td[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[6]/div/div/form/div/input[2]")).sendKeys("5");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[6]/div/div/form/div/button")).click();
        Thread.sleep(4000);

        test.log(LogStatus.PASS, "Test Passed");
        extent.endTest(test);
        extent.flush();
    }
}
