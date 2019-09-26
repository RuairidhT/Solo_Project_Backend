package com.qa.seleniumTests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ReadTests {

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
    public void testReadExercises() throws InterruptedException {
        extent = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\reports.html", false);
        test = extent.startTest("Selenium Test read exercises");

        driver.get("http://34.89.83.113/Exercises.html");
        Thread.sleep(4000);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"tabBod\"]/tr[1]/td[3]")).getText(), "Abdominals");

        test.log(LogStatus.PASS, "Test Passed");
        extent.endTest(test);
        extent.flush();
    }

    @Test
    public void testReadMachines() throws InterruptedException {
        extent = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\reports.html", false);
        test = extent.startTest("Selenium Test read machines");

        driver.get("http://34.89.83.113/Machines.html");
        Thread.sleep(4000);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"tableBod\"]/tr[1]/td[2]/button")).getText(), "Treadmill");

        test.log(LogStatus.PASS, "Test Passed");
        extent.endTest(test);
        extent.flush();
    }
}
