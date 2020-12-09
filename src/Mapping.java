
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class Mapping {

	List<File> fileList;
    StopWords stopWords;
    HashMap<String, List<File>> fileIndex;
    Stemmer stemmer;

    Mapping(){
        fileIndex = new HashMap<String, List<File>> ();
        fileList = new ArrayList<File> ();
        stopWords = new StopWords ();
        stemmer = new Stemmer ();
    }

    void createFileIndex(File file) throws IOException {
        if(!fileList.contains (file)){
            fileList.add (file);
            Scanner sc = new Scanner (file);
            
            while (sc.hasNext ()){
                String word = stemmer.stem (sc.next ()).toLowerCase ();
                if(!stopWords.contains (word)){
                    if(fileIndex.containsKey (word)){
                        if(!fileIndex.get (word).contains (file))
                            fileIndex.get (word).add (file);
                    } else {
                        List<File> fileList = new ArrayList<File>();
                        fileList.add (file);
                        fileIndex.put (word, fileList);
                    }
                }
            }
        }
    }

    public HashMap<String, List<File>> getFileIndex () {
        return fileIndex;
    }
}
