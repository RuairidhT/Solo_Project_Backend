package com.qa.seleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class UpdateTests {

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
    public void testUpdateExercise() throws InterruptedException {

        driver.get("http://34.89.83.113/Exercises.html");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[8]/td[6]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div[2]/form/div[1]/input[2]")).sendKeys("2");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div[2]/form/div[2]/button")).click();
        Thread.sleep(1000);

        assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[8]/td[2]/button")).getText(), "test2");
    }

    @Test
    public void testUpdateMachine() throws InterruptedException {

        driver.get("http://34.89.83.113/Machines.html");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[8]/td[4]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div[2]/form/div[1]/input[2]")).sendKeys("2");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div[2]/form/div[2]/button")).click();
        Thread.sleep(1000);

        assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[8]/td[2]/button")).getText(), "test2");
    }
}
