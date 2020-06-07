import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.Keys.RETURN;

public class FormPage {

    public static void form(WebDriver driver) {


        // driver.get("https://formy-project.herokuapp.com/dropdown");


        driver.get("https://formy-project.herokuapp.com/form");

        driver.findElement(By.id("first-name")).sendKeys("John");

        driver.findElement(By.id("last-name")).sendKeys("Doe");

        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");

        driver.findElement(By.id("radio-button-2")).click();

        driver.findElement(By.id("checkbox-2")).click();

        driver.findElement(By.cssSelector("option[value='1']")).click();

        driver.findElement(By.id("datepicker")).sendKeys("05/28/2019");
        driver.findElement(By.id("datepicker")).sendKeys(RETURN);

        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();




    }

}
