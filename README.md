# Web-Search-Engine


# What is Web Search Engine ?

In simple words ,it is a system where user provides the query to be search and the system displays results which is found on the web.
In technical terms it is a software service that allows Internet users to perform search operation for content via World wide web. The information to be search is known as web search query.
The search results are represented as lines of results  often referred as Search Engine Result Pages(SERPS).
The information may be a mix  links of web pages, images , videos, articles , research papers .


# Block Diagram of Working :

![Image of Block Diagram ](https://drive.google.com/file/d/123CxWqGPGypgIouzz0NALymjlv4R-Zfi/view?usp=sharing )



# Web Crawler :
A web crawler is  a program which navigates the web and finds new or updated pages .It downloads the pages from the website and then starts indexing the content found on the pages.
#### **How it is implemented?** 
  We have crawled web pages from Yahoo news locally and downloaded them.

# Indexing : 
In indexing , we have used inverted indexing.
Inverted indexing is an index data structure storing a mapping from content such as words or numbers , to its location in one or more documents .
It is like a hash map structure .
It directs you from a word to a document or a webpage.
#### **How it is implemented?** 
We have created an inverted index for all the words from all the text files of web pages using a hash map  where key is the  word and value is list of all the files  where the word is found.

# Porter Stemming Algorithm :
This algorithm is a process used for removing the commoner morphological and inflexional endings from words in English.
Example: EED -> EE means “if the word has at least one vowel and consonant plus EED ending, change the ending to EE” as ‘agreed’ becomes ‘agree’. 
Another example is word “connected” will give results “connect”.
#### **How it is implemented?** 
We have used an API for Porter Stemming to increase the capability of the search engine.

# Removing Stopwords 
Stop words are words which are filtered out before or after processing of natural language data (text). Though "stop words" usually refers to the most common words in a language, 
there is no single universal list of stop words used by all natural language processing tools, and indeed not all tools even use such a list.  Every user search query may have stop words like to , you and many others which are not useful to get the exact data.
It will consume extra space in memory which will slow down the search process.
#### **How it is implemented?** 
 We have created a list of stop words and removed them before creating  inverted index of all the web pages.

#Ranking of Web Pages
To get more relevant results, ranker is used based the user search query.Ranker algorithm is Collection.sort() as it is easy to use with Hash Map.
#### **How it is implemented?**  
The result is sorted based on the frequencies of the words.

# References
#### [1]” Search engine - Wikipedia.” https://en.wikipedia.org/wiki/Search_engine (accessed: Nov. 23, 2020).
#### [2] “What is Web Crawling: A Beginner’s Guide.” https://thesiliconreview.com/2020/11/what-is-web-crawling-a-beginners-guide (accessed: Nov. 24, 2020).
#### [3] “jsoup - Basic web crawler example - Mkyong.com.” https://mkyong.com/java/jsoup-basic-web-crawler-example/ (accessed: Nov. 24, 2020).
#### [4] “jsoup Java HTML Parser, with the best of HTML5 DOM methods and ..” https://jsoup.org/  (accessed: Nov. 25, 2020).
#### [5] “Write HashMap to Text File in Java Example - Java Code Examples.” https://www.javacodeexamples.com/write-hashmap-to-text-file-in-java-example/2353 (accessed: Nov. 30, 2020).
#### [6] “Inverted Index - GeeksforGeeks.” https://www.geeksforgeeks.org/inverted-index/ (accessed: Nov. 30, 2020).
#### [7] “PorterStemmer (Lucene 7.2.0 API).” https://lucene.apache.org/core/7_2_0/analyzerscommon/org/tartarus/snowball/ext/PorterStemmer.html (accessed: Nov. 30, 2020).
#### [8] “List of Stop Words for SEO.” https://www.shoutmeloud.com/seo-stop-words (accessed: Dec. 01, 2020).
#### [9] “Removing Stopwords from a String in Java | Baeldung.” https://www.baeldung.com/java-string-remove-stopwords (accessed: Dec. 04, 2020).

# I would like to thank you everyone for their valuable time .Also , I would like to thank all the references available online which helped us to develop this application.
