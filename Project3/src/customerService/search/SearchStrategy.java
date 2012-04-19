package customerService.search;

import java.util.List;
import java.util.Set;

public interface SearchStrategy {
  public Set<String> search(String query, List<String> items);
}
