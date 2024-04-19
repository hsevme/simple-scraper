package me.hsev;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkDataExtractionService {

    public static List<WorkData> extractData(Document doc) {
        Elements workElements = doc.selectXpath("//ol[@class='work index group']/li");
        return workElements.stream().map(
                workElement -> new WorkData(
                        workElement.select("h4.heading > a:nth-child(1)").text(),
                        workElement.select("h4.heading > a[rel='author']").text(),
                        workElement.select("dd.hits").text()
                )).toList();
    }

    private static String getAuthor(String text) {
        return getTitleAndAuthor(text)[1];
    }

    private static String getTitle(String text) {
        return getTitleAndAuthor(text)[0];
    }

    private static String[] getTitleAndAuthor(String text) {
        Pattern re = Pattern.compile("^\\w+by\\w+\\n");
        Matcher matcher = re.matcher(text);
        if (matcher.find()) {
            String match = matcher.group();
            return match.split(" by ");
        } else {
            return new String[] {"", ""};
        }
    }
    
    private static int getHits(String text) {
        Pattern re = Pattern.compile("Hits: \\d+");
        Matcher matcher = re.matcher(text);
        if (matcher.find()) {
            re = Pattern.compile("\\d+");
            matcher = re.matcher(matcher.group());
            String match = matcher.group();
            System.out.println(match);
            try  {
                return Integer.parseInt(match);
            } catch (NumberFormatException e) {
                return -1;
            }
        } else {
            return -1;
        }
    }

}
