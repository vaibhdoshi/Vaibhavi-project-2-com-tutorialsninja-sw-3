package myaccounts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {

        openBrowser(baseUrl);

    }

    /*1.1 create method with name "selectMyAccountOptions" it has one parameter name
    "option" of type string
    1.2 This method should click on the options whatever name is passed as parameter*/
    public void selectMyAccountOptions(String option) throws InterruptedException {
        List<WebElement> element = driver.findElements(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]"));
        for (WebElement element1 : element) {
            if (element1.getText().equalsIgnoreCase(option)) {
                Thread.sleep(2000);
                element1.click();
                break;
            }

        }

    }


    @Test
    public void verifyUserShouldNavigateToRegisterPageSucessfully() throws InterruptedException {
        //1.1 Click on My Account Link.
        mouseHoverToElementAndClick(By.xpath("//a[@title='My Account']"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter"Register"
        selectMyAccountOptions("Register");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));
        //1.3 Verify the text “Register Account”
        verifyElements("Register Account", By.xpath("//h1[contains(text(),'Register Account')]"), "correct Text");

    }


    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //2.1 Click on My Account Link.
        mouseHoverToElementAndClick(By.xpath("//a[@title='My Account']"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter'Login'
        selectMyAccountOptions("Login");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
        //2.3 Verify the text “Returning Customer”.
        verifyElements("Returning Customer", By.xpath("//h2[normalize-space()='Returning Customer']"), "Correct text");

    }


    @Test
    public void VerifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        mouseHoverToElementAndClick(By.xpath("//a[@title='My Account']"));
        selectMyAccountOptions("Register");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));
        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Vaibhavi");
        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Dhami");
        //3.5 Enter Email
        sendTextToElement(By.xpath(" //input[@id='input-email']"), "vaib1234@gmail.com");
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "07758517734");
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "abcd123");
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "abcd123");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.cssSelector("input[value='1'][name='newsletter']"));
        //3.10 Click on Privacy Policy check box
        // clickOnElement(By.xpath("input[value='1'][name='newsletter']"));
        clickOnElement(By.cssSelector("input[value='1'][name='agree']"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        verifyElements("Your Account Has Been Created!", By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"), "Register unsuccessfull");
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        //3.14 Clickr on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
        //3.16 Verify the text “Account Logout”
        verifyElements("Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"), "Not logout successfully");
        //3.17 Click on Continue button
        clickOnElement(By.xpath(" //a[normalize-space()='Continue']"));


    }


    @Test
    public void verifyThatUserRegisterAccountSucessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        mouseHoverToElementAndClick(By.xpath("//a[@title='My Account']"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        selectMyAccountOptions("Login");
        clickOnElement(By.xpath("//a[normalize-space()='Login']"));
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "vipatel@gmail.com");
        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "123456");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        //4.7 Verify text “My Account”
        verifyElements("My Account", By.xpath("//h2[contains(text(),'My Account')]"), "correct text");
        //4.8 Clickr on My Account Link.
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[1]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Logout”
        selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]"));
        //4.10 Verify the text “Account Logout”
        verifyElements("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"), "correct text");
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

}