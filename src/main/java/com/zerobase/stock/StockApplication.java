package com.zerobase.stock;

import com.zerobase.stock.model.Company;
import com.zerobase.stock.scraper.Scraper;
import com.zerobase.stock.scraper.YahooFinanceScraper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class StockApplication {

    public static void main(String[] args) {

        SpringApplication.run(StockApplication.class, args);

        /*
        String s = "Hello my name is %s";
        String[] names = {"Green", "RED", "banana"};

        for(String name : names){
            System.out.println(String.format(s, name));
        }
         */
/*
        Scraper scraper = new YahooFinanceScraper();
        // 인터페이스 확장성. 첨엔 걍 YahooFininceScrper scrpaer = new YahooFinanceScraper(); 이라고 객체생성함
        // 인터페이스로 야후 아니라 네이버도 만든다면, 이런 확장성을 위해 Scraper 라는 인터페이스를 만들고. YahooFininceScrper에 implements Scrpaer로 상속받는다. 각 멕서드는 오버라이드 @Override
        var result = scraper.scrap(Company.builder().ticker("O").build());
//        System.out.println(result);

        var result2 = scraper.scrapCompanyByTicker("MMM");
        System.out.println(result2);
*/

        /*
        try {
            Connection connection = Jsoup.connect("https://finance.yahoo.com/quote/KO/history?period1=-252374400&period2=1690848000&interval=1wk&filter=history&frequency=1wk&includeAdjustedClose=true");

            Document document = connection.get();

            Elements eles = document.getElementsByAttributeValue("data-test", "historical-prices");
            Element ele = eles.get(0); // table 전체

            //System.out.println(ele);

            Element tbody = ele.children().get(1);
            for(Element e : tbody.children()){
                String txt = e.text();
                if(!txt.endsWith("Dividend")){
                    continue;
                }
//                System.out.println(txt);

                String[] splits = txt.split(" ");
                String month = splits[0];
                int day = Integer.valueOf(splits[1].replace(",", ""));
                int year = Integer.valueOf(splits[2]);
                String dividend = splits[3];

                System.out.println(year + "/" + month +"/" + day + " -> " + dividend);

            }

        } catch (IOException e) {
           e.printStackTrace();
        }

         */
    }

}
