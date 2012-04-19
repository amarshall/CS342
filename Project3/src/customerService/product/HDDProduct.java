package customerService.product;

import java.util.List;

public abstract class HDDProduct {
  private List<String> faqs;

  public HDDProduct(List<String> faqs) {
    this.faqs = faqs;
  }

  public List<String> getFAQs() {
    return faqs;
  }

  public void accept(ProductVisitor v) {
    v.visit(this);
  }
}
