import java.io.BufferedWriter;
import java.io.File;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

import static org.jsoup.Jsoup.*;

public class Crawler {
	
	BufferedWriter writer;
    HashSet<String> links = new HashSet<String>();
    

    public Crawler () throws IOException {
        writer = new BufferedWriter (new FileWriter ("src\\urlPages.txt"));
    }

    void getPageLinks(String url){

        if(!links.contains (url)){
            try{
                Document document = connect (url).get ();
                Elements hrefLinks = document.select ("a[href^=\"https://ca.news.yahoo.com/\"]");
                for(Element link: hrefLinks){
                    links.add (url);
                    if(links.size ()<100)
                        getPageLinks (link.attr ("abs:href"));
                }
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }

    void downloadPages() throws IOException {
        links.forEach (i->{
            Document document;
            try{
                document = Jsoup.connect (i).maxBodySize (0).get ();
                String fileName = i;
                fileName = fileName.replace ("https://","");
                fileName = fileName.replace ("http://","");
                fileName = fileName.replace (".html",".txt");
                fileName = fileName.replace (".htm",".txt");
                if(fileName.endsWith ("/"))
                    fileName = fileName.replace ("/","");
                else
                    fileName = fileName.replace ("/","_");

                if(!fileName.contains (".pdf")) {
                    if(!fileName.endsWith (".txt"))
                        fileName+=".txt";
                    System.out.println (fileName);
                    FileWriter writer = new FileWriter ("src\\pages\\"+fileName);
                    writer.write (document.text ());
                    writer.close ();
                    File file = new File ("src\\pages\\"+fileName);
                    addToFile (i,file.getAbsolutePath ());
                }
            } catch (IOException e) {

                e.printStackTrace ();
            }

        });
        writer.flush ();
        writer.close ();
    }

    void addToFile(String url, String Path) throws IOException {
        writer.write (Path+" "+url);
        writer.newLine ();
    }

    public static void main (String[] args) throws IOException {
        Crawler crawl = new Crawler ();
        System.out.println ("Getting links from yahoo news....");
        crawl.getPageLinks ("https://ca.news.yahoo.com");
        crawl.downloadPages();
    }
}
