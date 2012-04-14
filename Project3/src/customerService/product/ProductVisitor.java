package customerService.product;

import java.util.List;

public interface ProductVisitor {
  public void visit(HDDProduct p);
  public void visit(SSDProduct p);
  public void visit(OpticalDriveProduct p);
  public void visit(BookProduct p);
  public List<String> getProductData();
}
