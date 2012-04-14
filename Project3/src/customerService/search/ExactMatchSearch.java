package customerService.search;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ExactMatchSearch implements SearchStrategy {
  public Set<String> search(String query, List<String> items) {
    Set<String> results = new TreeSet<String>();
    for(String str : items) {
      if(str.matches("(.*)(\\A|\\s)(" + query + ")(\\Z|\\s)(.*)")) {
        results.add(str);
      }
    }

    return results;
  }
}
