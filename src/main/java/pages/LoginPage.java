package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }
    @FindBy(xpath = "//*[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//*[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement btnYalla; //plut@gmail.com   Plut2010$

    @FindBy(xpath = "//[class='positive-button ng-star-inserted cursor-default-hover']")
    WebElement btnLoginOk;

    @FindBy(xpath = "//h2[@class='message']")
    WebElement TextPopUpLoginSuccess;

    @FindBy(xpath = "//h1[text()='Login failed']")
    WebElement errorMessageLogin;

    public LoginPage typeLoginForm(String email, String password){
      inputEmail.sendKeys(email);
      inputPassword.sendKeys(password);
      return this;


    }
    public boolean isTextInElementPresent_LoginSuccess(){
        return isTextInElementPresent(TextPopUpLoginSuccess, "Login in success");
    }

    public boolean isTextInElementPresent_wrongLogin() {
        System.out.println(TextPopUpLoginSuccess.getText());
        return isTextInElementPresent(TextPopUpLoginSuccess, "Login failed");
    }


    public LoginPage clickBtnLoginOk(){
        btnLoginOk.click();
        return new LoginPage(driver);
    }


    public LoginPage clickBtnYallaPositive(){
    pausa(3);
        btnYalla.click();
        return this;
    }
}
