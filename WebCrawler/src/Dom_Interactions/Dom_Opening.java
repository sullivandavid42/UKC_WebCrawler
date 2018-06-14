package Dom_Interactions;

import Parser.Parser_URL_Input;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


/*
    @Dom_Opening class : This class aims to open and basicly interact with each Websites DOM.
    Dom_Opening.Fetch_URL() try to ping each websites' IP sent by @Parser_URL_Input.
 */

public class Dom_Opening {

    List<String> _UrlList;
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
                   System.out.println(_doc.title());
                   _verified_list.add("https://www." + _url_list.get(i));

               } catch (Exception e) {
                   System.err.println(_url_list.get(i) + "Unknown Host. URL is not reacheable or SSL certificate is invalid.");
                  // e.printStackTrace();
               }
           }
           this._UrlList = _verified_list;
           System.out.println("DEBUG: NOMBRE URLS VALIDES : " + this._UrlList.size());
           System.out.println("OK");
           System.out.println("SUBDOMAIN TEST : ");
           this.Remove_SubDomainURLs();
       }

       /*
       This method removes subdomains from @_UrlList
        */
       public void Remove_SubDomainURLs() throws URISyntaxException{
           URI uri;
           String domain;
           List<String> clear_list = new ArrayList<>();

           for (int i = 0; i < this._UrlList.size(); i++) {
               uri = new URI(this._UrlList.get(i));
               domain = uri.getHost();
               System.out.println(domain.startsWith("www.") ? domain.substring(4) : domain);
               clear_list.add(domain.startsWith("www.") ? domain.substring(4) :  domain);
           }
           System.out.println("URL Number without SUBDOMAINS :" + clear_list.size());
       }

       /*
       This method aims to remove all duplicate domain name from @_URLlist
       */
       public void Remove_DuplicateURLs() throws URISyntaxException {

       }

       /*
       This method aims to find the login URL from each website in the JSON file.
       When login page has been found, the URL has to be save in a List<String>
       */
       public void Find_LoginURLs() {

       }

}
