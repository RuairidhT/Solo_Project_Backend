package com.qa.seleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ReadTests {

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
    public void testReadExercises() throws InterruptedException {

        driver.get("http://34.89.83.113/Exercises.html");
        Thread.sleep(4000);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"tabBod\"]/tr[1]/td[3]")).getText(), "Abdominals");
    }

    @Test
    public void testReadMachines() throws InterruptedException {

        driver.get("http://34.89.83.113/Machines.html");
        Thread.sleep(4000);
        assertEquals(driver.findElement(By.xpath("//*[@id=\"tableBod\"]/tr[1]/td[2]/button")).getText(), "Treadmill");
    }
}
