// import org.jsoup.Jsoup;
// import org.jsoup.nodes.Document;
// import org.jsoup.nodes.Element;
// import org.jsoup.select.Elements;
// import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
        public static void main(String[] args){
            try {
                WebDriver driver = new FirefoxDriver();
                // System.setProperty(webdriver.gecko);
                driver.get("http://stats.nba.com/scores/#!/04/05/2017");
                // System.out.println(driver.getPageSource());
                WebElement scoreContainer = driver
                    .findElement(By.id("scoresPage"))
                    .findElement(By.className("linescores-container"));
                // System.out.println(scoreContainer.getText());
                List<WebElement> scores = scoreContainer.findElements(By.className("linescores"));
                // System.out.println(scores.size());
                for (WebElement el : scores){
                    WebElement link = el
                        .findElement(By.className("bottom-bar"))
                        .findElement(By.linkText("Box Score"));
                    System.out.println(link.getAttribute("href"));
                }


                // Document doc = Jsoup.connect("http://www.espn.com/nba/scoreboard/_/date/20170405")
                //     .userAgent("Mozilla").data("name", "jsoup")
                //     .maxBodySize(0)
                //     .get();


            } catch(Exception e){
                e.printStackTrace();
            }
        }
}
