package Dom_Interactions;

import Parser.Parser_URL_Input;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class Dom_Opening {

       public void Get_DOM() throws Exception {
           System.out.println("test2");
           int _size_urllist = 0;
           String title;
           List<String> _url_list = new Parser_URL_Input().file_input();
           System.out.println("test2");
           _size_urllist = _url_list.size();
           for (int i = 0; i < _size_urllist; i++) {
               Document _doc = Jsoup.connect("https://www." + _url_list.get(i)).get();
               //title = _doc.title();
               System.out.println(_doc.title());
           }
       }

}
