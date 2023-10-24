package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDTO(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                User.builder()
                        .email("igor@abcd.com")
                        .password("Ig12345$")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("alexgt@mail.com")
                        .password("Ag12345$")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("nata34@mail.com")
                        .password("Nn12345!")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactDTO() {
        List<Object[]> list = new ArrayList<>();
        int i = (int) (System.currentTimeMillis() / 1000) & 3600;
        list.add(new Object[]{
                Contact.builder()
                        .name("Alex_" + i)
                        .lastName("Sparow")
                        .phone("123456" + i)
                        .address("Haifa")
                        .description("Gardener")
                        .email("alex_" + i + "@gmail.com")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/Reg_daratest.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{
                    User.builder()
                            .email(split[0])
                            .password(split[1])
                            .build()
            });
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

}
