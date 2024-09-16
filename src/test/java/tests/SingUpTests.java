package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Random;

public class SingUpTests extends ApplicationManager {
    @Test
    public void singUpPositiveTest(){
        int i = new Random().nextInt(1000);
        String email = "frodo_baggins" + i + "@gmail.com";
        new HomePage(getDriver()).clickBtnSingUpPage().typeRegistrationForm("Olga","Polga",email,"Polga2010$").clickCheckBox().clickBtnYalla();

    }
}
