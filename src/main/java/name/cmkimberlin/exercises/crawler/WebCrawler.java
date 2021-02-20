package name.cmkimberlin.exercises.crawler;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.HashSet;


/**
 * This program crawls through 1000 links and prints out lists of the titles and words contained within the visited links
 * @author Caleb Kimberlin
 */
public class WebCrawler {

    private static final int MAX_PAGES = 1000;
    private final HashSet<String> titles = new HashSet<>();
    private final HashSet<String> siteVisited = new HashSet<>();
    private final HashMap<String, Integer> map = new HashMap<>();

    public void getLink(String originalURL) {
        if((titles.size() < MAX_PAGES) && !siteVisited.contains(originalURL)) {
            siteVisited.add(originalURL);
            try {
                System.out.println(("Here I am: " + originalURL));
                Document page = Jsoup.connect(originalURL).get();
                Elements newLinks = page.select("a[href]");
                String title = page.select("Title").first().text();
                titles.add(title);
                String text = page.body().text();
                WordCount(text);

                for(Element link : newLinks) {
                    if(titles.size() <= MAX_PAGES) {
                        Thread.sleep(1000);
                        getLink(link.attr("abs:href"));
                    }
                    else {
                        System.out.println("URL could not visit " + originalURL + ", " + siteVisited.size());
                    }
                }
            }
            catch(HttpStatusException h) {
                System.out.println("Found a dead link: " + originalURL);
            }
            catch(UnsupportedMimeTypeException m) {
                System.out.println("Found an irrelevant link: " + originalURL);
            }
            catch(NullPointerException n) {
                System.out.println("Could not find a valid title for this link: " + originalURL);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void PrintTitles() {
        for(String t : titles) {
            System.out.println(t);
        }
    }

    public void CountWordsAndPrint() {
        for(String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    private void WordCount(String text) {
        String[] lineNumber = text.split(" ");
        for(String word : lineNumber) {
            if(map.containsKey(word)) {
                int val = map.get(word);
                val += 1;
                map.remove(word);
                map.put(word, val);
            }
            else {
                map.put(word, 1);
            }
        }
    }
}
