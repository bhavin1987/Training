import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.RETURN;

public class Autocomplete {


    public static void main(String[] args) throws InterruptedException {


        // autocomplete();
        //scroll();
        //switchwindow();
        //testAlert();
        //testJavascript();
        //testDragdrop();
        //radiobutton();
        //checkboxes();
        //testDatepicker1();
        //testDropdown();
        //fileUpload();
        WebDriver driver = DriverOpen();

        FormPage page;
        page = new FormPage();

        FormPage.form(driver);

        //form(driver);
        waitforAlert(driver);


       assertEquals("The form was successfully submitted!", getAlertText(driver));

        driver.quit();


    }

    public static WebDriver DriverOpen()
    {
        System.setProperty ("webdriver.chrome.driver", "/Users/bhavinchandarana/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    private static String getAlertText(WebDriver driver) {

        return driver.findElement(By.className("alert")).getText();

    }

    private static void waitforAlert(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));



    }



    private static void fileUpload() {

        WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/fileupload");

        WebElement fileUpload = driver.findElement(By.id("file-upload-field"));
        fileUpload.sendKeys("test.jpg");


        driver.quit();

    }

    private static void testDropdown() {

        WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdownMenuButton"));
        dropdown.click();

        WebElement dropdownitem = driver.findElement(By.xpath("/html/body/div/div/div/a[9]"));
        dropdownitem.click();

        driver.quit();
    }

    private static void testDatepicker1() {
        WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/datepicker");

        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("03/03/2020");
        datePicker.sendKeys(RETURN);


        driver.close();
    }

    private static void checkboxes() {

        WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/checkbox");

        WebElement checkBox1 = driver.findElement(By.id("checkbox-1"));
        checkBox1.click();

        WebElement checkBox2 = driver.findElement(By.cssSelector("input[value='checkbox-2']"));
        checkBox2.click();

        WebElement checkBox3 = driver.findElement(By.xpath("//*[@id=\"checkbox-3\"]"));

        checkBox3.click();

        driver.close();
    }

    private static void radiobutton()
    {
        WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/radiobutton");

        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        radioButton1.click();

        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
        radioButton2.click();

        WebElement radioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));

        radioButton3.click();

        driver.close();
    }



    private static void testDragdrop()
    {
        WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/dragdrop");

        WebElement image = driver.findElement(By.id("image"));

        WebElement box = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(image,box).build().perform();


        driver.close();
    }

    private static void testJavascript() {

        WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/modal");

        WebElement modalButton = driver.findElement(By.id("modal-button"));
        modalButton.click();

        WebElement closeButton = driver.findElement(By.id("close-button"));

        //closeButton.click();

        JavascriptExecutor js = (JavascriptExecutor)driver;

        //js.executeAsyncScript("arguments[0].click();",closeButton);


       // WebElement closeButton = driver.findElement(By.id("close-button"));
       // JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", closeButton);


        driver.close();
    }

    private static void testAlert() {

        WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();

        alert.accept();



        driver.close();
    }

    private static void switchwindow() {

        WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        String original = driver.getWindowHandle();

        for (String handle1:driver.getWindowHandles())
        {
            driver.switchTo().window(handle1);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().window(original);
        driver.close();

    }

    public static void autocomplete()
    {
       WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement Autocomplete = driver.findElement(By.id("autocomplete"));

        Autocomplete.sendKeys("1555 Park Blvd, Palo Alto, CA");
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver,10);




        WebElement Autocompleteresult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-item")));

        Autocompleteresult.click();

        driver.quit();
    }



    public static void scroll()
    {
        WebDriver driver = DriverOpen();
        driver.get("https://formy-project.herokuapp.com/scroll");

        WebElement name = driver.findElement(By.id("name"));

        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        name.sendKeys("Bhavin Chandarana");

      /*  try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */

        WebElement date = driver.findElement(By.id("date"));

        date.sendKeys("01/01/2020");



        driver.quit();

    }

}
