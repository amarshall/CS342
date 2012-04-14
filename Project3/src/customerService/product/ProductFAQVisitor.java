package customerService.product;

import java.util.ArrayList;
import java.util.List;

public class ProductFAQVisitor implements ProductVisitor {
  private List<String> faqs;

  public ProductFAQVisitor() {
    faqs = new ArrayList<String>();
  }

  public void visit(HDDProduct p) {
    faqs.addAll(p.getFAQs());
  }

  public void visit(SSDProduct p) {
    faqs.addAll(p.getFAQs());
  }

  public void visit(OpticalDriveProduct p) {
    faqs.addAll(p.getFAQs());
  }

  public void visit(BookProduct p) {
    faqs.addAll(p.getFAQs());
  }

  public List<String> getProductData() {
    return faqs;
  }
}
