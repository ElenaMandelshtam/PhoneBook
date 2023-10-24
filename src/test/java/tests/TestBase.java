package tests;

import manager.ApplicationManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

//    WebDriver wd;

    static ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method){
        logger.info("Started test --->" + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(Method method){
        logger.info("Finished test --->" + method.getName());
        logger.info("================================================");
    }

    @BeforeSuite(alwaysRun = true)
//    public void init(){
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }
    public void setUp() throws IOException {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
//    public void tearDown(){
//        pause(3000);
//        wd.quit();
//    }
    public void stop(){
        app.tearDown();
    }

//    public void pause(int millis){
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    public boolean isAlertPresent(){
//        Alert alert = new WebDriverWait(wd, 5)
//                .until(ExpectedConditions.alertIsPresent());
//        if (alert == null) return false;
//        wd.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();
//        return true;
//    }

//    public void openLoginRegistrationForm(){
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//    }

//    public void fillLoginRegistrationForm(String email, String password){
////        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
////        emailInput.click();
////        emailInput.clear();
////        emailInput.sendKeys(email);
////
////        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
////        passInput.click();
////        passInput.clear();
////        passInput.sendKeys(password);
//        type(By.xpath("//input[1]"), email);
//        type(By.xpath("//input[2]"), password);
//    }

//    public void submitLogin(){
//        wd.findElement(By.xpath("//button[1]")).click();
//    }

//    public boolean isElementPresent(By locator){
//        return wd.findElements(locator).size() > 0;
//    }

//    public void logout(){
//        click(By.xpath("//*[.='Sign Out']"));
//    }

//    public void click(By locator){
//        wd.findElement(locator).click();
//    }
//
//    public void type(By locator, String text){
//        WebElement element = wd.findElement(locator);
//        element.click();
//        element.clear();
//        element.sendKeys(text);
//    }

//    public boolean isLogged(){
//        return isElementPresent(By.xpath("//*[.='Sign Out']"));
//    }
}
