package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositiveTest(){
        // open login form
        app.getHelperUser().openLoginRegistrationForm();

        // fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("igor_" + i + "@abcd.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Ig12345$");
        app.getHelperUser().fillLoginRegistrationForm("igor_" + i + "@abcd.com", "Ig12345$");

        // click on button registration
        //wd.findElement(By.xpath("//button[2]")).click();
        app.getHelperUser().submitRegistration();
        // assert
        //pause(3000);
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test
    public void registrationNegativeTestWrongEmail(){
        // open login form
        //wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("igor_" + i + "abcd.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Ig12345$");
        app.getHelperUser().fillLoginRegistrationForm("igor_" + i + "abcd.com", "Ig12345$");

        // click on button registration
        //wd.findElement(By.xpath("//button[2]")).click();
        app.getHelperUser().submitRegistration();
        // assert
        //pause(3000);
        app.getHelperUser().pause(3000);
        //Assert.assertTrue(isAlertPresent());
        app.getHelperUser().isAlertPresent();
    }

}


