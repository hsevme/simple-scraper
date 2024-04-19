package me.hsev;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.jsoup.nodes.Document;

import static me.hsev.WorkDataExtractionService.extractData;

/**
 * web-scraper <url> downloads a page at the given url and outputs the source to stdout
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserCommunicationService.welcome();

        if (args[0] != null) {
            try {

                URL url = URI.create(args[0]).toURL();
                UserCommunicationService.askToWait();

                Document doc = DownloadService.downloadHtml(url);

                extractData(doc).forEach(System.out::println);

            } catch (MalformedURLException e) {
                UserCommunicationService.malformedUrl();
                throw new RuntimeException(e);

            } catch (IOException e) {
                UserCommunicationService.downloadFailed();
                throw new RuntimeException(e);
            }
        } else {
            UserCommunicationService.noArgumentsGiven();
        }
    }
}
