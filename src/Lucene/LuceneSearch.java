package Lucene;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneSearch {
	//public static RAMDirectory index = new RAMDirectory();
	
	public static void SearchAuthor(String querystr) throws ParseException, IOException {
		
    	Analyzer analyzer = new StandardAnalyzer();

        Query q = new QueryParser("Author", analyzer).parse(querystr);
        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(LuceneIndexer.index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc hits[] = docs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        for(int i=0;i<hits.length;++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("Title") + "\t" + "Score: " + hits[i].score);
        }

        reader.close();

	}

    public static void SearchContent(String querystr) throws ParseException, IOException {
    	Analyzer analyzer = new StandardAnalyzer();

        Query q = new QueryParser("Content", analyzer).parse(querystr);
        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(LuceneIndexer.index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc hits[] = docs.scoreDocs;

        System.out.println("Found " + hits.length + " hits.");
        
        for(int i=0;i<hits.length;++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i + 1) + ". " + d.get("Title") + "\t" + d.get("Author") + "\t" + "Score: " + hits[i].score);
        }
        reader.close();
	}
}
