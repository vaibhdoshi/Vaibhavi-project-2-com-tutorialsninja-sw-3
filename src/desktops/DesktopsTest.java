package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {

        openBrowser(baseUrl);

    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //Mouse hover on Desktops Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //Click on "Show All Desktops"
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        verifyElements("Name (Z - A)", By.xpath("//option[@value='http://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']\n"), "Correct text");
    }

    @Test

    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Mouse hover on Desktops Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        //Click on "Show All Desktops"
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));
        //Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        //Select product "HP LP3065"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//img[@title='HP LP3065']"));
        //Verify the text "HP LP3065"
        verifyElements("HP LP3065", By.xpath("//h1[contains(text(),'HP LP3065')]"), "Correct Text");
        //Select Delivery Date "2022-11-30
        String year = "2022";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']")); // Opens the date picker
        while (true) {
            String monthYear = driver.findElement(By.xpath("//th[@class='picker-switch']")).getText();

            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];
            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {
                Thread.sleep(2000);
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
                break;
            } else
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
        }

        //Select date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='table-condensed']//td"));
        for (WebElement ele : allDates) {
            String dt = ele.getText();
            if (dt.equalsIgnoreCase(date)) {
                Thread.sleep(2000);
                ele.click();
                break;


            }

        }
        WebElement qty = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[2]/input[1]"));
        qty.sendKeys(Keys.CONTROL + "a");
        qty.sendKeys(Keys.DELETE);
        Thread.sleep(2000);
        //2.7.Enter Qty "1” using Select class.
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        verifyElements("Success: You have added HP LP3065 to your shopping cart!\n" + "×", By.xpath("//div[@class='alert alert-success alert-dismissible']"), "correct text");
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //2.11 Verify the text "Shopping Cart"
        verifyElements("Shopping Cart  (1.00kg)", By.xpath("//h1[contains(text(),'Shopping Cart')]"), "correct text");
        //2.12 Verify the Product name "HP LP3065"
        verifyElements("HP LP3065", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "correct text");
        //2.13 Verify the Delivery Date "2022-11-30"
        verifyElements("Delivery Date: 2022-11-30", By.xpath("//small[normalize-space()='Delivery Date: 2022-11-30']"), "correct text");
        //2.14 Verify the Model "Product21"
        verifyElements("Product 21", By.xpath("//td[normalize-space()='Product 21']"), "correct text");
        //2.15 Verify the Todat "$122"
        verifyElements("$122.00", By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"), "correct text");

    }


    @After
    public void tearDown() {

        closeBrowser();


    }

}