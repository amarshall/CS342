package customerService.driver;

import java.util.ArrayList;
import java.util.List;

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

public class Driver {
  public static void main(String[] args) {
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

    List<String> faqs = visitor.getProductData();

    ProductSearch search = new ProductSearch(faqs);

    SearchStrategy exact = new ExactMatchSearch();
    SearchStrategy stemmer = new StemmerMatchSearch();
    SearchStrategy semantic = new SemanticMatchSearch();

    System.out.println("Exact results:");
    for(String s : search.search("KENNY", exact)) System.out.println(s);

    System.out.println("Stemmer results:");
    for(String s : search.search("KENNY", stemmer)) System.out.println(s);

    System.out.println("Semantic results:");
    for(String s : search.search("KENNY", semantic)) System.out.println(s);
  }
}
