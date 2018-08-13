package Dom_Interactions;

import Parser.Parser_URL_Input;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


/*
    @Dom_Opening class : This class aims to open and basicly interact with each Websites DOM.
    Dom_Opening.Fetch_URL() try to ping each websites' IP sent by @Parser_URL_Input.
 */

public class Dom_Opening {

    List<String> _UrlList;
    JSONObject _UrlListExt = new JSONObject();
        /*
        This method instanciate Parser_URL_Input() class and execute file_input.
        Each website in the JSON file is trying to be ping : If ping OK -> DOM reader
                                                             If not -> Remove URL from List<String>
        */
       public void Fetch_URL() throws Exception {
           int _size_urllist;
           List<String> _url_list = new Parser_URL_Input().file_input();
           List<String> _verified_list = new ArrayList<String>();

           _size_urllist = _url_list.size();
           for (int i = 0; i < _size_urllist; i++) {
               try {
                   Document _doc = Jsoup.connect("https://www." + _url_list.get(i)).get();
                   //System.out.println(_doc.title());
                   _verified_list.add("https://www." + _url_list.get(i));

               } catch (Exception e) {
                   //System.err.println(_url_list.get(i) + "Unknown Host. URL is not reacheable or SSL certificate is invalid.");
                  e.printStackTrace();
               }
           }
           this._UrlList = _verified_list;
           this.Remove_SubDomainURLs();
           this.Remove_DuplicateURLs();
           this.Find_LoginURLs();
       }

       /*
       This method removes subdomains from @_UrlList
        */
       public void Remove_SubDomainURLs() throws URISyntaxException{
           URI uri;
           String domain;
           List<String> clear_list = new ArrayList<>();
           System.out.println("Removing SUBDOMAINS from list");
           for (int i = 0; i < this._UrlList.size(); i++) {
               uri = new URI(this._UrlList.get(i));
               domain = uri.getHost();
               clear_list.add(domain.startsWith("www.") ? domain.substring(4) :  domain);
           }
           this._UrlList.clear();
           for (int i = 0; i < clear_list.size(); i++) {
               this._UrlList.add("https://www." + clear_list.get(i));
               //System.out.println(this._UrlList.get(i));
           }
       }

       /*
       This method aims to remove all duplicate domain name from @_URLlist
       */
       public void Remove_DuplicateURLs() throws URISyntaxException {
           System.out.println("Removing DUPLICATE ENTRIES from list");
           for (int i = 0; i < this._UrlList.size(); i++) {
               //System.out.println(this._UrlList.get(i));
               for (int j = i + 1; j < this._UrlList.size(); j++) {
                   //System.out.println(this._UrlList.get(j));
                   //System.out.println("------");
                   if (this._UrlList.get(i).equals(this._UrlList.get(j))) {
                       this._UrlList.remove(j);
                       break;
                   }
               }
           }
           //
           // System.out.println(this._UrlList);
       }

       /*
       This method aims to find the login URL from each website in the JSON file.
       When login page has been found, the URL has to be save in a List<String>
       */
       public void Find_LoginURLs() {
           for (int i = 0; i < this._UrlList.size(); i++) {
               try {
                   List<String> _type = new ArrayList<>();
                   Document _doc = Jsoup.connect(this._UrlList.get(i)).get();
                   Elements _inputs = _doc.getElementsByTag("input");
                   for (int j = 0; j < _inputs.size(); j++) {
                       if (_inputs.get(j).attr("type").equals("email") || _inputs.get(j).attr("type").equals("password") || _inputs.get(j).attr("type").equals("submit")) {
                           _type.add(_inputs.get(j).attr("type"));
                           //System.out.println(item);
                       }
                   }
                   _UrlListExt.put("website", this._UrlList.get(i));
                   _UrlListExt.put("input", _type);
                   if (_type.isEmpty()) {
                       _UrlListExt.put("loginPage", 0);
                   }
                   else {
                       _UrlListExt.put("loginPage", 1);
                   }
                   System.out.println(_UrlListExt.toString());

               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }

}
