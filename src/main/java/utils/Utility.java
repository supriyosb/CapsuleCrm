package utils;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Utility {

    /**
     * It will take the screen shot and return the screenshot path
     * @param driver
     * @return
     */
    public static String getScreenshot(WebDriver driver) {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"/report/screenshot/"+System.currentTimeMillis()+".png";
        File destination=new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed "+e.getMessage());
        }

        return path;
    }
}
