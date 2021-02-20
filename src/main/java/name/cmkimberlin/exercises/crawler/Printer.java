package name.cmkimberlin.exercises.crawler;

public class Printer {

    public static void main(String[] args) {
        WebCrawler w = new WebCrawler();

        w.getLink("https://en.wikipedia.org/wiki/Team_Fortress_2");
        System.out.println("***************Printing all Titles***************");
        w.PrintTitles();

        System.out.println("***************Printing all Words***************");
        w.CountWordsAndPrint();
    }
}