package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("igor@abcd.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Ig12345$");
        app.getHelperUser().fillLoginRegistrationForm("igor@abcd.com", "Ig12345$");

        // click on button login
//        wd.findElement(By.xpath("//button[1]")).click();
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(3000);
//        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test
    public void loginNegativeTestWrongEmail(){
        // open login form
        //wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("igorabcd.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Ig12345$");
        app.getHelperUser().fillLoginRegistrationForm("igorabcd.com", "Ig12345$");

        // click on button login
        //wd.findElement(By.xpath("//button[1]")).click();
        app.getHelperUser().submitLogin();
        // assert
        //pause(3000);
        app.getHelperUser().pause(3000);
        //Assert.assertTrue(isAlertPresent());
        app.getHelperUser().isAlertPresent();

    }

    @Test
    public void loginNegativeTestWrongPassword(){
        // open login form
        //wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("igor@abcd.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Ig12345");
        app.getHelperUser().fillLoginRegistrationForm("igor@abcd.com", "Ig12345");

        // click on button login
        //wd.findElement(By.xpath("//button[1]")).click();
        app.getHelperUser().submitLogin();
        // assert
        //pause(3000);
        app.getHelperUser().pause(3000);
        app.getHelperUser().isAlertPresent();

    }

}
