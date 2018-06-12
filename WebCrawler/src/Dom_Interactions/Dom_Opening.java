package Dom_Interactions;

import Parser.Parser_URL_Input;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class Dom_Opening {

       public void Get_DOM() throws Exception {
           int _size_urllist;
           List<String> _url_list = new Parser_URL_Input().file_input();
           _size_urllist = _url_list.size();
           for (int i = 0; i < _size_urllist; i++) {
               Document _doc = Jsoup.connect("https://www." + _url_list.get(i)).get();
               System.out.println(_doc.title());
           }
       }

}
