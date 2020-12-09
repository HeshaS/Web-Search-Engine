import org.tartarus.snowball.ext.EnglishStemmer;


public class Stemmer {
    EnglishStemmer ES;
    Stemmer(){
        ES = new EnglishStemmer ();
    }
    public String stem(String word){
        ES.setCurrent (word);
        ES.stem ();
        //System.out.println("stemmer="+stemmer.getCurrent());
        return ES.getCurrent ();
    }
}
