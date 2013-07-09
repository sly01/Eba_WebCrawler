
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Example program to list links from a URL.
 */
public class ListLinks {
	public static void main(String[] args)  {
		String html = "<ul><li><i><a class=\"mw-redirect\" title=\"title1\" href=\"yahoo.com\">used to be a best email</a></i>(1999)</li><li><i><a title=\"title2\" href=\"google.com\">Best search enginee We Will Go</a></i>(1999)</li><li><i><a title=\"title3\" href=\"apple.com\">Best Phone</a></i>(1990)</li></ul>";

        Document doc = Jsoup.parse(html);

        Elements links = doc.select("ul li i a");

        for (Element element : links) {
            System.out.format("%s %s %s\n", element.attr("title"), element.attr("href"), element.text());
        }
	}
}
		/*//Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        //for(int i=1;i<10;i++){
		String url = "http://www.eba.gov.tr/video/ders-destek-programlari/2";
		System.out.printf("Fetching %s...", url);

		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("a[href]");
		Elements media = doc.select("[src]");
		Elements imports = doc.select("link[href]");

		print("\nMedia: (%d)", media.size());
		for (Element src : media) {
			if (src.tagName().equals("img"))
				print(" * %s: <%s> %sx%s (%s)", src.tagName(),
						src.attr("abs:src"), src.attr("width"),
						src.attr("height"), trim(src.attr("alt"), 20));
			else
				print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
		}

		print("\nImports: (%d)", imports.size());
		for (Element link : imports) {
			print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"),
					link.attr("rel"));
		}

		print("\nLinks: (%d)", links.size());
		for (Element link : links) {
			print(" * a: <%s>  (%s)", link.attr("abs:href"),
					trim(link.text(), 35));
		}
        }
	//}

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}
}*/