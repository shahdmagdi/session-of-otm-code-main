package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RecruitmentPage {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open OrangeHRM login page
        driver.get("https://your-orangehrm-url.com");
        driver.manage().window().maximize();
    }

    @Test
    public void addCandidate() {
        // Login to OrangeHRM
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        // Navigate to Recruitment section
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_recruitment_viewRecruitmentModule"))).click();

        // Click on "Add Candidate" button
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd"))).click();

        // Fill candidate details
        driver.findElement(By.id("addCandidate_firstName")).sendKeys("John");
        driver.findElement(By.id("addCandidate_lastName")).sendKeys("Doe");
        driver.findElement(By.id("addCandidate_email")).sendKeys("johndoe@example.com");

        // Upload resume (optional)
        WebElement fileInput = driver.findElement(By.id("addCandidate_resume"));
        fileInput.sendKeys("C:\\path\\to\\resume.pdf");

        // Click "Save" button
        driver.findElement(By.id("btnSave")).click();

        // Verify candidate is added (assumption: successful alert message appears)
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message success fadable")));
        Assert.assertTrue(successMessage.getText().contains("Successfully Saved"), "Candidate was not added successfully!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
