package lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "username")
    private WebElement username_input;
    @FindBy(name = "password")
    private WebElement password_input;

    @FindBy(id = "submit")
    private WebElement submit_btn;

    @FindBy(id = "loggedin")
    private WebElement message;


    public void signIn(String username, String password) {
        username_input.sendKeys(username);
        password_input.sendKeys(password);
        submit_btn.click();
    }

    public String getMessage() {
        return message.getText();
    }


}
