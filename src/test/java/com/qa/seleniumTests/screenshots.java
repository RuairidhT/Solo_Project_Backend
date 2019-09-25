package com.qa.seleniumTests;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class screenshots {

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
    public void screenshotHomepage() throws InterruptedException, IOException {

        driver.get("http://34.89.83.113/");
        Thread.sleep(4000);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\ruair_v7ou30m\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\HomePage.png"));
    }

    @Test
    public void screenshotExercisePage() throws InterruptedException, IOException {

        driver.get("http://34.89.83.113/Exercises.html");
        Thread.sleep(4000);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\ruair_v7ou30m\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\ExercisePage.png"));
    }

    @Test
    public void screenshotMachinesPage() throws InterruptedException, IOException {

        driver.get("http://34.89.83.113/Machines.html");
        Thread.sleep(4000);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\ruair_v7ou30m\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\MachinesPage.png"));
    }

    @Test
    public void screenshotModal() throws InterruptedException, IOException {

        driver.get("http://34.89.83.113/Exercises.html");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[1]/td[6]/button")).click();
        Thread.sleep(1000);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\ruair_v7ou30m\\IdeaProjects\\Solo_Project_Backend\\src\\test\\java\\resources\\Modal.png"));
    }
}
