package MainModules.FunModules;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Anekdoter {
    public void sendAnecdot(){
        String url = "https://www.anekdot.ru/random/anekdot/";
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements anecdotes = doc.select("div.text");
        for (Element anecdote : anecdotes) {
            System.out.println(anecdote.text());
            break;
        }
    }
}
