package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;


import static utils.RandomUtils.*;
import static pages.BasePage.clickButtonsOnHeader;

public class LoginTests extends ApplicationManager {

    @Test
    public void loginPositiveTest(){
        new HomePage(getDriver()).clickBtnLoginPage().typeLoginForm("plut@gmail.com","Plut2010$").clickBtnYallaPositive();
    }

    @Test
    public void loginPositiveTest_wrongEmailWOAt(){
        UserDto user = new UserDto(generateString(5), generateString(7), generateString(10), "Qwerty123!");
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginPage().typeLoginForm(user).clickBtnYallaPositive()
                .isTextInElementPresent_ErrorEmail("It'snot look like email"));
    }

    @Test
    public void loginNegativeTest_wrongEmailWOAt_Enum() {
        UserDto user = new UserDto(generateString(5), generateString(7),
                generateString(10), "Qwerty123!");
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginForm(user)
                .clickBtnYallaPositive()
                .isTextInElementPresent_ErrorEmail("It'snot look like email")
        ;
    }



   /* @Test
    public void loginNegativeTest_wrongPassword(){
        new HomePage(getDriver()).clickBtnLoginPage().typeLoginForm("plut@gmail.com","Plut2010").clickBtnYallaPositive().isTextInElementPresent_wrongLogin();
    }

    @Test
    public void loginNegativeTest_wrongEmail(){
        new HomePage(getDriver()).clickBtnLoginPage().typeLoginForm("plut11@gmail.com","Plut2010$").clickBtnYallaPositive().isTextInElementPresent_wrongLogin();
    }*/
}
