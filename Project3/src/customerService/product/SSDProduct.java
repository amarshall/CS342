package customerService.product;

import java.util.List;

public abstract class SSDProduct {
  private List<String> faqs;

  public SSDProduct(List<String> faqs) {
    this.faqs = faqs;
  }

  public List<String> getFAQs() {
    return faqs;
  }

  public void accept(ProductVisitor v) {
    v.visit(this);
  }
}
