import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SearchEngine {

    static void showResult(ArrayList<String> links){
        int count = 1;
        Scanner sc = new Scanner (System.in);

        for (String link: links){
            System.out.println (link);
            if(count % 10 ==0){
                System.out.println ("\nMore Results Available.. " +
                        "\nPress 1 to continue. " +
                        "Any other Key to Exit.");
                String ch = sc.nextLine ();
                if(!ch.equals ("1"))
                    break;
            }
            count++;
        }
        if(links.isEmpty()) {
            System.out.println ("Sorry! No results found");
        }
        System.out.println ("----------End of Results----------");
    }
    public static void main (String[] args) throws IOException {
        Mapping mapping = new Mapping ();
        File folder = new File("src/pages/");
        for (File file: Objects.requireNonNull (folder.listFiles ())) 
        {
            if(file.isFile ())
                mapping.createFileIndex (file);
        }
        final HashMap<String, List<File>> index = mapping.getFileIndex ();
        Scanner sc = new Scanner (System.in);
        String choice="1";
        Search search;
        while(choice.toString().equals ("1")){
        	
            search = new Search (index); 
            System.out.print ("\n Dummy Yahoo Search Engine ");
            System.out.print ("\nSEARCH: ");
            String query = sc.nextLine ();
            showResult (search.performSearch (query));
            System.out.println ("\nSelect option:\n1. to continue your search.\n2. Exit");
            
            choice = sc.next ();
            sc.nextLine ();
            
        }
        if(!choice.equals("1"))
        {
        	System.out.println("Thanks for using our engine,hope to see you soon..Bubyee");
        	System.exit(0);
        }
    }
}
