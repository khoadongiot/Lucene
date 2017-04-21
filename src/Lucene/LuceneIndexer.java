package Lucene;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class LuceneIndexer {
	public static Directory index = new RAMDirectory();
    
	 private static void addDoc(IndexWriter w, String Title, String Author, String Content) throws IOException {
	        Document doc = new Document();
	        doc.add(new TextField("Title", Title, Field.Store.YES));
	        doc.add(new TextField("Author", Author, Field.Store.YES)); 
	        doc.add(new TextField("Content", Content, Field.Store.YES));
	        w.addDocument(doc);
	    }
   
   public static void Index() throws IOException{
   	 Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(index, config);
        addDoc(writer, "Modern Computer Architecture", "James Harrison", "computer architecture, modern RAM, CPU speed, hard drive capacity, easy to use");
		 addDoc(writer, "Fashion in Use", "James Smith", "white shirt, hard hat, modern hair styles, easy to work");
		 addDoc(writer, "Safety in Transportation", "Smith Johnson", "drunk driver, high speed vehicle architectures, carelessly drive, modern designed cars, smith");
        writer.close();
   }
}
