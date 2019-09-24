package com.qa.seleniumTests;

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

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ruair_v7ou30m\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testDeleteExercise() throws InterruptedException {

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
    }

    @Test
    public void testDeleteMachine() throws InterruptedException {

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
    }
}
