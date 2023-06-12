package SeleniumWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SeleniumYnetInvestigation {

    private WebDriver driver =  new ChromeDriver();
    private List<WebElement> newsList;

    public SeleniumYnetInvestigation()
    {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        driver.get("https://www.ynetnews.com");
        driver.manage().window().maximize();
    }

    public int CountNews()
    {
        newsList = driver.findElements(By.xpath("//div[@class=\"titleRow   \"]"));
        int numberOfNews = newsList.size();
        return numberOfNews;
    }

    public List<String> GetTitlesWithWord(String word) {
        List<String> relevantTitles = new ArrayList<>();
        for (WebElement newsRow : newsList) {
            String title = newsRow.findElement(By.cssSelector(".title")).getText();
            if(title.contains(word)) {
                relevantTitles.add(title);
            }
        }
        return relevantTitles;
    }

    public void Quit() {
        driver.quit();
    }

    public void ExpandBreakingNews() {
        try {
            WebElement BreakingNewsButton = driver.findElement(By.xpath("//div[@class = \"moreTickersLink\"]/a"));
            BreakingNewsButton.click();
            WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/"));
            driver.switchTo().frame(frame1);
            WebElement frame2 = driver.findElement(By.id("ad_iframe"));
            driver.switchTo().frame(frame2);
            driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
            driver.switchTo().defaultContent();
            Thread.sleep(5000);
        }
        catch (Exception e)
        {
            driver.get("https://www.ynetnews.com/category/3089");
        }

    }
}
