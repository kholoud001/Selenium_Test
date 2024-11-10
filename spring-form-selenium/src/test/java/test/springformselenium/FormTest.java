package test.springformselenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testFormSubmission() throws InterruptedException {
        // Open the form page
        driver.get("http://localhost:8080/");
        Thread.sleep(2000);


        // Find input elements and submit the form
        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement submitButton = driver.findElement(By.tagName("button"));

        nameInput.sendKeys("John Doe");
        Thread.sleep(1000); // Wait for 1 second to observe the input

        emailInput.sendKeys("john.doe@example.com");
        Thread.sleep(1000); // Wait for 1 second to observe the input

        submitButton.click();
        Thread.sleep(3000); // Wait for 3 seconds to observe the submission result


        // Check if the result page shows the correct data
        assertTrue(driver.getPageSource().contains("Form Submitted Successfully!"));
        assertTrue(driver.getPageSource().contains("John Doe"));
        assertTrue(driver.getPageSource().contains("john.doe@example.com"));
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(2000); // Wait for 2 seconds before closing the browser
            driver.quit();
        }
    }
}
