package com.qa.seleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CreateTests {

    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ruair_v7ou30m\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testCreateExercise() throws InterruptedException {

        driver.get("http://34.89.83.113/Exercises.html");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"content-wrap\"]/div/div[3]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/div/div[2]/form/div[1]/input[1]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/div/div[2]/form/div[1]/input[2]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/div/div[2]/form/div[1]/input[3]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/div/div[2]/form/div[1]/input[4]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/div/div[2]/form/div[2]/button")).click();
        Thread.sleep(4000);

        assertEquals(driver.findElement(By.xpath("//*[text()='test']")).getText(), "test");

    }

    @Test
    public void testCreateMachine() throws InterruptedException {

        driver.get("http://34.89.83.113/Machines.html");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"content-wrap\"]/div/div[3]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/div/div[2]/form/div[1]/input[1]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/div/div[2]/form/div[1]/input[2]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/div/div[2]/form/div[2]/button")).click();
        Thread.sleep(4000);

        assertEquals(driver.findElement(By.xpath("//*[text()='test']")).getText(), "test");
    }

}
