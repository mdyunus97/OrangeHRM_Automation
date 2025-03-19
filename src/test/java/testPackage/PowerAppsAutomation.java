package testPackage;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;

	public class PowerAppsAutomation {
	    public static void main(String[] args) {
	        // Set path for EdgeDriver or ChromeDriver
	        System.setProperty("webdriver.edge.driver", "path/to/msedgedriver.exe");
	        
	        // Initialize WebDriver
	        WebDriver driver = new EdgeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        try {
	            // Open Power Apps
	            driver.get("https://make.powerapps.com/");
	            driver.manage().window().maximize();

	            // Login
	            wait.until(ExpectedConditions.elementToBeClickable(By.id("i0116"))).sendKeys("your-email@domain.com");
	            driver.findElement(By.id("idSIButton9")).click(); // Click Next
	            
	            wait.until(ExpectedConditions.elementToBeClickable(By.id("i0118"))).sendKeys("your-password");
	            driver.findElement(By.id("idSIButton9")).click(); // Click Sign in

	            // Handle "Stay signed in?" prompt if needed
	            try {
	                WebElement staySignedIn = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));
	                staySignedIn.click();
	            } catch (Exception ignored) {}

	            // Wait for Power Apps dashboard
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Apps']")));

	            // Open a specific Power App
	            WebElement app = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Your App Name']")));
	            app.click();

	            // Wait for the app to load
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Your Button Name']")));

	            // Perform an action inside the app
	            WebElement button = driver.findElement(By.xpath("//button[text()='Your Button Name']"));
	            button.click();

	            System.out.println("Power Apps automation completed successfully!");

	        } catch (Exception e) {
	            System.out.println("Error during automation: " + e.getMessage());
	        } finally {
	            // Close browser
	            driver.quit();
	        }
	    }
	}


