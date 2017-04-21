package Lucene;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;




public class LuceneTest { 
    public static void main(String[] args) throws IOException, ParseException{
        LuceneIndexer.Index();
        System.out.println("**Search for Content : ");
        LuceneSearch.SearchContent("driver");
        
        System.out.println("**Search for Author : ");
        LuceneSearch.SearchAuthor("Smith");
         
     }
}