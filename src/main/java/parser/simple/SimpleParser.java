package parser.simple;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SimpleParser {
    public static void main(String[] args) throws IOException {
        String url = "https://www.rusbonds.ru/compare.asp?go=1&tool=&emit=0&sec=1&status=T&cat=0&per=0&rate=0&ctype=12&pvt=0&grnt=0&conv=0&amm=0&bdate=&edate=&byeff=&eyeff=&bysmpl=&eysmpl=&bdur=&edur=&bvol=&evol=&bsdvol=&esdvol=&btrade=&etrade=&bcr=&ecr=&bcp=&ecp=#rslt";
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla")
                .referrer("http://www.google.com")
                .get();
        Elements table = document.select("table.tbl_data.tbl_headgrid");
        Elements body = table.select("tbody");
        Elements rows = body.select("tr");
//        System.out.println(rows);

        for (int i =0; i < rows.size(); i++){
            Element row= rows.get(i);
            Elements cols = row.select("td");
            System.out.print(cols.get(0).text());
            System.out.print(" ");
            System.out.print(cols.get(1).text());
            System.out.print(" ");
            System.out.print(cols.get(3).text());
            System.out.print(" ");
            System.out.print(cols.get(5).text());
            System.out.println();
        }

    }
}
