import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo {
    
    public static void main(String[] args) {
     try {
         Document document;
         document = Jsoup.connect("http://www.eba.gov.tr/video/ders-destek-programlari/1").timeout(60000)
        .userAgent("Mozilla")
        .get();
         Elements element = document.getElementsByClass("videoListMore");
         for (Element e : element){
         
         String href = e.getElementsByTag("a").attr("href");
         String url = "http://www.eba.gov.tr" + href;
         Document document1 = Jsoup.connect(url).userAgent("Mozilla").get();
         Elements aciklama = document1.getElementsByClass("well");
         Element paragraf = aciklama.get(0);
         //Getting explanation of video
         String acikla = paragraf.getElementsByTag("p").text();
         
        
         
         //Getting title here
         String title = e.getElementsByTag("a").attr("title");
         System.out.println(title);
         System.out.println(acikla);
         System.out.println("**************");
      
         }
     
     
     } catch (IOException ex) {
         Logger.getLogger(JsoupDemo.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
}
