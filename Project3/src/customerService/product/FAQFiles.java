package customerService.product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public enum FAQFiles {
  SSD_PRODUCT_1 ("data/ssd1faqs.txt"),
  SSD_PRODUCT_2 ("data/ssd2faqs.txt"),
  SSD_PRODUCT_3 ("data/ssd3faqs.txt"),

  HDD_PRODUCT_1 ("data/hdd1faqs.txt"),
  HDD_PRODUCT_2 ("data/hdd2faqs.txt"),
  HDD_PRODUCT_3 ("data/hdd3faqs.txt"),

  OPTICAL_PRODUCT_1 ("data/optical1faqs.txt"),
  OPTICAL_PRODUCT_2 ("data/optical2faqs.txt"),
  OPTICAL_PRODUCT_3 ("data/optical3faqs.txt"),

  BOOK_PRODUCT_1 ("data/book1faqs.txt"),
  BOOK_PRODUCT_2 ("data/book2faqs.txt"),
  BOOK_PRODUCT_3 ("data/book3faqs.txt");

  private String filename;

  FAQFiles(String filename) {
    this.filename = filename;
  }

  public List<String> getFAQs() {
    List<String> faqs = new ArrayList<String>();

    Scanner reader = null;
    try {
      reader = new Scanner(new File(filename));
      while(reader.hasNext()) {
        faqs.add(reader.nextLine());
      }
    } catch(FileNotFoundException e) {
      System.err.println("File " + filename + " not found.");
      System.exit(1);
    } finally {
      if(reader != null) reader.close();
    }

    return faqs;
  }
}
