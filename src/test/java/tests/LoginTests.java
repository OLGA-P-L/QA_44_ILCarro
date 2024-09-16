package tests;

import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends ApplicationManager {

    @Test
    public void loginPositiveTest(){
        new HomePage(getDriver()).clickBtnLoginPage().typeLoginForm("plut@gmail.com","Plut2010$").clickBtnYallaPositive();
    }

    @Test
    public void loginNegativeTest_wrongPassword(){
        new HomePage(getDriver()).clickBtnLoginPage().typeLoginForm("plut@gmail.com","Plut2010").clickBtnYallaPositive().isTextInElementPresent_wrongLogin();
    }

    @Test
    public void loginNegativeTest_wrongEmail(){
        new HomePage(getDriver()).clickBtnLoginPage().typeLoginForm("plut11@gmail.com","Plut2010$").clickBtnYallaPositive().isTextInElementPresent_wrongLogin();
    }
}
