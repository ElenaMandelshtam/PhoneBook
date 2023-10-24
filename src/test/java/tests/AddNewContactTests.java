package tests;

import manager.ProviderData;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(!app.getHelperUser().isLogged()) app.getHelperUser().login(
//                User.builder()
//                        .email("igor@abcd.com")
//                        .password("Ig12345$")
//                        .build()
                app.getEmail(), app.getPassword()
        );
    }

    @Test(invocationCount = 5, groups = {"positive", "smoke"})
    public void addNewContactPositive(){
        int i = (int)(System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("Max")
                .lastName("Smith")
                .phone("97642536" + i)
                .email("smith_" + i + "@mail.com")
                .address("Haifa")
                .description("Gardener")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }

    @Test(groups = {"positive", "smoke"}, dataProvider = "contactDTO", dataProviderClass = ProviderData.class)
    public void addNewContactPositiveDTO(Contact contact){
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }

}
