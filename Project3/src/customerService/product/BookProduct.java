package customerService.product;

import java.util.List;

public abstract class BookProduct {
  private List<String> faqs;

  public BookProduct(List<String> faqs) {
    this.faqs = faqs;
  }

  public List<String> getFAQs() {
    return faqs;
  }

  public void accept(ProductVisitor v) {
    v.visit(this);
  }
}
