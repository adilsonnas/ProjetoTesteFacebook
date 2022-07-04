package drivers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class DriverUtils {
	
	public static void takesScreenshot(String testName) throws IOException {
		TakesScreenshot captura = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = captura.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target/screenshots/" + testName + ".jpg"));
	}

}
