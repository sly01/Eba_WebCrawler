import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {
	public static void main(String[] args) {

		try {
			for (int i = 1; i <= 24; i++) {
				String adress = "http://www.eba.gov.tr/video/ders-destek-programlari/"+ i;
				Document doc = Jsoup.connect(adress).timeout(0).userAgent("Mozilla").get();
				doc.outputSettings().charset("UTF-8");
				Elements links = doc.getElementsByClass("videoListContentTitle");

				List<String> titleList = new ArrayList<String>();
				List<String> linkList = new ArrayList<String>();
				List<String> contentList = new ArrayList<String>();

				for (Element adres : links) {
					String href = adres.getElementsByTag("a").attr("href");
					String url = "http://www.eba.gov.tr" + href;
					linkList.add(url);
				}

				//outPut(linkList);
				
				  for (String adres :linkList ) { 
					  
				  Document doc1 =Jsoup.connect(adres).timeout(0).userAgent("Mozilla").get();
				  doc1.outputSettings().charset("UTF-8");
				  Elements aciklama = doc1.getElementsByClass("well"); 
				  Element paragraf  = aciklama.get(0); 
				  String acikla = paragraf.getElementsByTag("p").text();
				  contentList.add(acikla); 
				  
				  }
				 
				for (Element element : links) {
					String link = element.getElementsByTag("a").attr("title")+"\n";
					titleList.add(link);
				}
				
				  System.out.println("----------Titles----------");
				  outPut(titleList);
				  System.out.println("-------------------------");
				 
				
				  System.out.println("----------Contents----------");
				  outPut(contentList);
				  System.out.println("-------------------------");
				 

				
				/*  File dosya = new File(
				  "/Users/mac/Desktop/Eba/Eba_ElasticSearchTitleList.txt");
				  
				  if (!dosya.exists()) { dosya.createNewFile(); }
				  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dosya),"UTF-8")); 
				  writer.write(titleList.toString()+"\n");
				  writer.flush(); writer.close();
				  
				  File dosya1 = new File(
				  "/Users/mac/Desktop/Eba/Eba_ElasticSearchContentList.txt");
				  if (!dosya1.exists()) { dosya1.createNewFile(); }
				  BufferedWriter writer1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dosya1),"UTF-8")); 
				  writer1.write(contentList.toString());
				  writer1.flush(); writer1.close();
				 */
				 

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void outPut(List<String> l) {
		for (String string : l) {
			System.out.printf("%s\n", string);
		}
		System.out.println(" ");

	}
}
