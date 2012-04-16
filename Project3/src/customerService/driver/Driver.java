package customerService.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

import customerService.search.ProductSearch;
import customerService.search.SearchStrategy;
import customerService.search.ExactMatchSearch;
import customerService.search.StemmerMatchSearch;
import customerService.search.SemanticMatchSearch;

import customerService.product.FAQFiles;
import customerService.product.ProductVisitor;
import customerService.product.ProductFAQVisitor;

import customerService.product.SSDProduct;
import customerService.product.SSDProduct1;
import customerService.product.SSDProduct2;
import customerService.product.SSDProduct3;
import customerService.product.HDDProduct;
import customerService.product.HDDProduct1;
import customerService.product.HDDProduct2;
import customerService.product.HDDProduct3;
import customerService.product.OpticalDriveProduct;
import customerService.product.OpticalDriveProduct1;
import customerService.product.OpticalDriveProduct2;
import customerService.product.OpticalDriveProduct3;
import customerService.product.BookProduct;
import customerService.product.BookProduct1;
import customerService.product.BookProduct2;
import customerService.product.BookProduct3;
import customerService.util.Debug;

public class Driver {
  public static void main(String[] args) {
    Debug.DEBUG_VALUE = 1;
    List<HDDProduct> hdds = new ArrayList<HDDProduct>();
    List<SSDProduct> ssds = new ArrayList<SSDProduct>();
    List<OpticalDriveProduct> opticaldrives = new ArrayList<OpticalDriveProduct>();
    List<BookProduct> books = new ArrayList<BookProduct>();

    {
      List<String> faqs;

      faqs = FAQFiles.SSD_PRODUCT_1.getFAQs();
      ssds.add(new SSDProduct1(faqs));
      faqs = FAQFiles.SSD_PRODUCT_2.getFAQs();
      ssds.add(new SSDProduct2(faqs));
      faqs = FAQFiles.SSD_PRODUCT_3.getFAQs();
      ssds.add(new SSDProduct3(faqs));

      faqs = FAQFiles.HDD_PRODUCT_1.getFAQs();
      hdds.add(new HDDProduct1(faqs));
      faqs = FAQFiles.HDD_PRODUCT_2.getFAQs();
      hdds.add(new HDDProduct2(faqs));
      faqs = FAQFiles.HDD_PRODUCT_3.getFAQs();
      hdds.add(new HDDProduct3(faqs));

      faqs = FAQFiles.OPTICAL_PRODUCT_1.getFAQs();
      opticaldrives.add(new OpticalDriveProduct1(faqs));
      faqs = FAQFiles.OPTICAL_PRODUCT_2.getFAQs();
      opticaldrives.add(new OpticalDriveProduct2(faqs));
      faqs = FAQFiles.OPTICAL_PRODUCT_3.getFAQs();
      opticaldrives.add(new OpticalDriveProduct3(faqs));

      faqs = FAQFiles.BOOK_PRODUCT_1.getFAQs();
      books.add(new BookProduct1(faqs));
      faqs = FAQFiles.BOOK_PRODUCT_2.getFAQs();
      books.add(new BookProduct2(faqs));
      faqs = FAQFiles.BOOK_PRODUCT_3.getFAQs();
      books.add(new BookProduct3(faqs));
    }

    ProductVisitor visitor = new ProductFAQVisitor();
    for(SSDProduct p : ssds) p.accept(visitor);
    for(HDDProduct p : hdds) p.accept(visitor);
    for(OpticalDriveProduct p : opticaldrives) p.accept(visitor);
    for(BookProduct p : books) p.accept(visitor);

    ProductSearch search = new ProductSearch(visitor.getProductData());

    SearchStrategy exact = new ExactMatchSearch();
    SearchStrategy stemmer = new StemmerMatchSearch();
    SearchStrategy semantic = new SemanticMatchSearch(loadSynonyms("data/synonyms.txt"));

    for(String query : loadUserInputs("data/userInputs.txt")) {
      Debug.log(1, "Search results for '" + query + "':");
      Debug.log(1, "  Exact results:");
      for(String s : search.search(query, exact)) Debug.log(1, "    " + s);

      Debug.log(1, "  Stemmer results:");
      for(String s : search.search(query, stemmer)) Debug.log(1, "    " + s);

      Debug.log(1, "  Semantic results:");
      for(String s : search.search(query, semantic)) Debug.log(1, "    " + s);

      Debug.log(1, "");
    }
  }

  private static List<String> loadUserInputs(String filename) {
    List<String> inputs = new ArrayList<String>();

    Scanner reader = null;
    try {
      reader = new Scanner(new File(filename));
      while(reader.hasNext()) {
        String line = reader.nextLine();
        if(line.length() > 0) {
          inputs.add(line);
        }
      }
    } catch(FileNotFoundException e) {
      System.err.println("File " + filename + " not found.");
      System.exit(1);
    } finally {
      if(reader != null) reader.close();
    }

    return inputs;
  }

  /* line format: "key val1,val2,val3" */
  private static Map<String, Set<String>> loadSynonyms(String filename) {
    Map<String, Set<String>> synonyms = new HashMap<String, Set<String>>();

    Scanner reader = null;
    try {
      reader = new Scanner(new File(filename));
      while(reader.hasNext()) {
        String line = reader.nextLine();
        String[] tokens = line.split(" ");
        String key = tokens[0];
        Set<String> val = new HashSet<String>();
        for(String s : tokens[1].split(",")) {
          val.add(s);
        }
        synonyms.put(key, val);
      }
    } catch(FileNotFoundException e) {
      System.err.println("File " + filename + " not found.");
      System.exit(1);
    } finally {
      if(reader != null) reader.close();
    }

    return synonyms;
  }
}
