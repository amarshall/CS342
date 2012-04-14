package customerService.search;

import java.util.List;
import java.util.Set;

public class ProductSearch {
  private List<String> data;

  public ProductSearch(List<String> data) {
    this.data = data;
  }

  public Set<String> search(String query, SearchStrategy strategy) {
    return strategy.search(query, data);
  }
}
