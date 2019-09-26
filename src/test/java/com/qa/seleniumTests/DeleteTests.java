package com.qa.seleniumTests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class DeleteTests {

    ChromeDriver driver;
    static ExtentTest test;
    static ExtentReports extent;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testDeleteExercise() throws InterruptedException {
        extent = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\reports.html", false);
        test = extent.startTest("Selenium Test delete exercises");

        driver.get("http://34.89.83.113/Exercises.html");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[8]/td[6]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div[2]/div[1]/button")).click();
        Thread.sleep(1000);

        boolean present;
        try {
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[8]/td[2]/button"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

        assertFalse(present);

        test.log(LogStatus.PASS, "Test Passed");
        extent.endTest(test);
        extent.flush();
    }

    @Test
    public void testDeleteMachine() throws InterruptedException {
        extent = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\reports.html", false);
        test = extent.startTest("Selenium Test delete machines");

        driver.get("http://34.89.83.113/Machines.html");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[8]/td[4]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div[2]/div[1]/button")).click();
        Thread.sleep(1000);

        boolean present;
        try {
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[8]/td[2]/button"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

        assertFalse(present);

        test.log(LogStatus.PASS, "Test Passed");
        extent.endTest(test);
        extent.flush();
    }
}
