package io.xuechao.backend2.crawler;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

public class DemoCrawler {

    private static final String AMAZON_QUERY_URL = "https://www.amazon.com/s/ref=nb_sb_noss_2?field-keywords=";
    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36";

    //private String query;

    public void getAmazonProd(String query){
        try {
            String url = AMAZON_QUERY_URL+query;
            HashMap<String,String> headers = new HashMap<String,String>();
            headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            headers.put("Accept-Encoding", "gzip, deflate, br");
            headers.put("Accept-Language", "en-US,en;q=0.8");
            Document doc = Jsoup.connect(url).headers(headers).userAgent(USER_AGENT).maxBodySize(0).timeout(1000).get();
            //String fullText = doc.text();
            //String title = doc.title();
            //String bodyText = doc.body().text();
            //#result_15 > div > div > div > div.a-fixed-left-grid-col.a-col-right > div.a-row.a-spacing-small > div:nth-child(1) > a > h2
            Elements prods = doc.getElementsByClass("s-result-item celwidget  ");
            for(Integer i = 0; i < prods.size();i++){
                String id = "result_" + i.toString();
                Element prodsById = doc.getElementById(id);
                String asin = prodsById.attr("data-asin");

                System.out.println("prod asin: " + asin);
                Elements titleEles = prodsById.getElementsByAttribute("title");
                for(Element titleEle : titleEles){
                    System.out.println("prod asin: " + titleEle.attr("title"));
                }
            }


        }catch (IOException e){
            //
            e.printStackTrace();
        }

    }
}
