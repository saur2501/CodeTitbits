import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;*/

public class Autodownloader {
	/*private static int i = 0;
	public static void main(String[] args) throws InterruptedException, MalformedURLException, FileNotFoundException, IOException {
		//prestoWebUIBootstrapScraping();
		someCapabilityNotes();
	}

	//Ref- https://www.youtube.com/watch?v=OmaD6T2-d_Q&index=22&list=PLUY1lsOTtPeLPAkMpl8EFIDqWgv1QTXST
	private static void someCapabilityNotes() throws InterruptedException, MalformedURLException, FileNotFoundException, IOException {
		// for selenium 2- gecko driver is not necessary
		System.setProperty("webdriver.gecko.driver", "C:\\gilr\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		System.out.println(capabilities.getBrowserName() + capabilities.getVersion());

		// page info
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://in.images.search.yahoo.com/");
		driver.findElement(By.id("yschsp")).sendKeys("Quotes By Robin Sharma");
		driver.findElement(By.id("yschsp")).sendKeys(Keys.RETURN);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.className("r0")));
		el.getText();

		//WebElement listWebEl = driver.findElement(By.className("med"));
		*//*List<WebElement> listWebEl = driver.findElements(By.className("rg_l"));
		System.out.println(listWebEl.size() + " is the size");			//returned 0 rows cuz was not loaded
		List<String> hrefs = new ArrayList<>();
		for(WebElement we : listWebEl) {
			String hrefString = we.getAttribute("href");
			//System.out.println(hrefString + "Life is good");
			hrefs.add(hrefString);
		}*//*
		//WebElement we2 = driver.findElement(By.id("rg_s"));
		Thread.sleep(2000);
		for(int k = 0; k < 10 ; k++) {
			try {
			List<WebElement> listWebEl = driver.findElements(By.xpath("//li[contains(@class, 'ld') and contains(@class,'r" + k + "')]"));
			System.out.println(listWebEl.size() + " is the size");			//returned 0 rows cuz was not loaded
			List<String> hrefs = new ArrayList<>();
			for(WebElement we : listWebEl) {
				we.findElement(By.tagName("a")).click();
				//WebElement photo = driver.findElement(By.xpath("//li[contains(@class, 'viewer') and contains(@class, 'focused')]"));
				String sourceUrl = we.findElement(By.tagName("img")).getAttribute("src");
				downloadImage(sourceUrl, "C:\\Users\\I341365\\Desktop\\Experimentation");
				System.out.println("A File Downloaded");
				*//*String hrefString = "";
				//if(we.findElement(By.tagName("img")) != null)
					hrefString = we.getAttribute("href");
				System.out.println(hrefString + "Life is good");
				if(hrefString.contains("imgres"))
					hrefs.add(hrefString);*//*
			}
			} catch(Exception e) {}
		}
	}
		*//*for(int i = 0;i< hrefs.size()*0.9;i++)
			hrefs.remove(0);
		String[] arrayHref = new String[hrefs.size()];
		System.out.println(Arrays.toString(hrefs.toArray(arrayHref)));
		for(String link : hrefs) {
			WebDriver driver1 = new FirefoxDriver();
			driver1.get(link);
			WebElement we1 = driver1.findElement(By.xpath("//table[@class='_Ccb irc_but_r']"));
			List<WebElement> candidates = we1.findElements(
					By.xpath("//a[contains(@class, 'irc_fsl') "
							+ "and contains(@class, 'irc_but') "
							+ "and contains(@class,'i3596')]"
							)
					);
			for(WebElement we : candidates) {
				if(we.getAttribute("href") != null) {
					we.click();
					System.out.println("Final Link Is = " + driver1.findElement(By.tagName(
							"img"
							)).getAttribute("src"));
				}
			}
			//By.cssSelector("div[class='irc_fsl irc_but i3596']")
			//driver.findElement(By.xpath("//a[@class='irc_but']")).click();	//xpath("//button[text()='Finished']")).click();
			//driver.findElement().click();
			Thread.sleep(2000);
			String sourceUrl = driver1.findElement(By.tagName("img")).getAttribute("src");
			downloadImage(sourceUrl, "C:\\Users\\I341365\\Desktop\\Experimentation");
			System.out.println("A File Downloaded");*//*
		
		// open new tab
//		driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");
//		driver.findElement(By.partialLinkText("Chaitanya")).click();
		//driver.quit();

		// take screen shots- lecture 14 (to do)

	private static void prestoWebUIBootstrapScraping() throws InterruptedException {
		// for selenium 2- gecko driver is not necessary
		System.setProperty("webdriver.gecko.driver", "APIs/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		System.out.println(capabilities.getBrowserName() + capabilities.getVersion());

		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("http://192.168.50.135:8081");
		Thread.sleep(2000); // to make sure page is fully loaded
		webDriver.findElement(By.xpath("//button[text()='Finished']")).click();
		WebElement webElement = webDriver.findElement(By.xpath("//button[text()[contains(.,'Show')]]"));
		System.out.println("Krstos " + webElement.getText());
		webElement.click();
		List<WebElement> webElementList = webDriver.findElements(By.xpath("//ul[@class='dropdown-menu']"));
		System.out.println("size is " + webElementList.size());
		System.out.println(webElementList.get(2).getText());
		webElement = webElementList.get(2);
		By by = By.linkText("All queries");
		webElement = webElement.findElement(by);
		webElement.click();
		// well.get(2).findElement(By.linkText("All queries")).click();
		// System.out.println(driver.getPageSource());
		// System.out.println("Text is " +
		// driver.findElement(By.className("tinystat")).getText());
		// List<WebElement> webElements =
		// (driver.findElements(By.xpath("//span[@class='tinystat']")));
		webElementList = (webDriver.findElements(By.xpath("//div[@class='query']")));
		for (WebElement webElementInLoop : webElementList) {
			// System.out.println(key.getText());
			System.out.println(webElementInLoop.findElement(By.className("sql")).getText());
			List<WebElement> webElementsNumbers = webElementInLoop.findElements(By.className("tinystat"));
			for (WebElement we : webElementsNumbers) {
				System.out.print(we.getText() + "\t");
			}
			System.out.print("\n");
		}
	}
	public static void downloadImage(String sourceUrl, String targetDirectory)
            throws MalformedURLException, IOException, FileNotFoundException
    {
        URL imageUrl = new URL(sourceUrl);
        try {
        		InputStream imageReader = new BufferedInputStream(
                imageUrl.openStream());
                OutputStream imageWriter = new BufferedOutputStream(
                        new FileOutputStream(targetDirectory + File.separator + i++ + ".jpeg"));
                int readByte;

                while ((readByte = imageReader.read()) != -1)
                {
                    imageWriter.write(readByte);
                }
                //Thread.sleep(500);
        }
        catch(Exception e) {}
                                //+ FilenameUtils.getName(i++)));)
    }*/
}
// Ref-
// https://www.youtube.com/watch?v=OmaD6T2-d_Q&index=22&list=PLUY1lsOTtPeLPAkMpl8EFIDqWgv1QTXST
// jars- selenium-server-standalone-3.4.0.jar and mozilla firefox-
// client-combined-3.4.0-nodeps.jar (OS Specific)