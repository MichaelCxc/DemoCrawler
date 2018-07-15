package io.xuechao.backend2.crawler;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DemoCrawler {

    public void getAmazonProd(String url){
        try {
            Document doc = Jsoup.connect(url).timeout(1000).get();
            String fullText = doc.text();
            //String title = doc.title();
            //String bodyText = doc.body().text();
            Elements reviews = doc.getElementsByClass("a-expander-collapsed-height a-row a-expander-container a-expander-partial-collapse-container");
            for(Element review : reviews){
                System.out.println("review content: "+ review.text());
            }

        }catch (IOException e){
            //
            e.printStackTrace();
        }

    }
}
