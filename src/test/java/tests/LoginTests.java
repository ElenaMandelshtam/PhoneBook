package tests;

import manager.NGListener;
import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.stream.DoubleStream;
@Listeners(NGListener.class)

public class LoginTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

//    @Test
//    public void loginPositiveTest(){
//        // open login form
////        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        app.getHelperUser().openLoginRegistrationForm();
//        // fill login form
////        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
////        emailInput.click();
////        emailInput.clear();
////        emailInput.sendKeys("igor@abcd.com");
////
////        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
////        passInput.click();
////        passInput.clear();
////        passInput.sendKeys("Ig12345$");
//        app.getHelperUser().fillLoginRegistrationForm("igor@abcd.com", "Ig12345$");
//
//        // click on button login
////        wd.findElement(By.xpath("//button[1]")).click();
//        app.getHelperUser().submitLogin();
//        // assert
//        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
//        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
//    }    app.getHelperUser().pause(3000);


    @Test(groups = {"positive"})
    public void loginPositiveTestModel() {
        User user = User.builder()
                .email("igor@abcd.com")
                .password("Ig12345$")
                .build();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test(groups = {"positive"}, dataProvider = "userDTO", dataProviderClass = ProviderData.class)
    public void loginPositiveTestUserDTO(User user) {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test(groups = {"positive"})
    public void loginPositiveTestProps() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(app.getEmail(), app.getPassword());
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test(groups = {"negative", "smoke"})
    public void loginNegativeTestWrongEmail(){
        // open login form
        //wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        User user = User.builder()
                .email("igorabcd.com")
                .password("Ig12345$")
                .build();
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
        app.getHelperUser().fillLoginRegistrationForm(user);

        // click on button login
        //wd.findElement(By.xpath("//button[1]")).click();
        app.getHelperUser().submitLogin();
        // assert
        //pause(3000);
        app.getHelperUser().pause(3000);
        //Assert.assertTrue(isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

    @Test(groups = {"negative"})
    public void loginNegativeTestWrongPassword(){
        // open login form
        //wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        User user = User.builder()
                .email("igor@abcd.com")
                .password("Ig12345")
                .build();
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
        app.getHelperUser().fillLoginRegistrationForm(user);

        // click on button login
        //wd.findElement(By.xpath("//button[1]")).click();
        app.getHelperUser().submitLogin();
        // assert
        //pause(3000);
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());

    }

}
