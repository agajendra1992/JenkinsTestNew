package JenkinSample.Jenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Browser {
	public static WebDriver driver;

	public void browsername(String BrowserN) {

		String cwd = System.getProperty("user.dir");
		System.out.println(cwd + "\\Driverfolder");
		String driverpath = cwd + "\\Driverfolder";
		if (BrowserN.contentEquals("chrome") || (BrowserN.contentEquals("CHROME"))) {
			System.setProperty("webdriver.chrome.driver", driverpath + "\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (BrowserN.contentEquals("FIREFOX") || (BrowserN.contentEquals("firefox"))) {
			System.setProperty("webdriver.gecko.driver", driverpath + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (BrowserN.contentEquals("InternetExplorer") || (BrowserN.contentEquals("INTERNETEXPLORER"))) {
			System.setProperty("webdriChromever.ie.driver", driverpath + "\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println(BrowserN + " Browser not found");
		}
	}

	@BeforeTest
	public void runapp() {
		Browser br = new Browser();
		br.browsername("chrome");
		driver.manage().window().maximize();
		driver.get("https://demoqa.com");
	}

}
