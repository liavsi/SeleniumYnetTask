package SeleniumWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class main {

    public static void main(String[] args) {
        String wordToLookFor = "Israel";
        SeleniumYnetInvestigation yNetInvestigator = new SeleniumYnetInvestigation();
        yNetInvestigator.ExpandBreakingNews();
        int numberOfNews = yNetInvestigator.CountNews();
        List<String> israelNewsTitles = yNetInvestigator.GetTitlesWithWord(wordToLookFor);
        System.out.println("Number of news: " + numberOfNews);
        System.out.println(String.format("News titles containing the word '%s' :", wordToLookFor));
        for(String title : israelNewsTitles)
        {
            System.out.println(title);
        }
        yNetInvestigator.Quit();
    }
}
