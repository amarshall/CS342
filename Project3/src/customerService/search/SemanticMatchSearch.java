package customerService.search;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SemanticMatchSearch implements SearchStrategy {
  private Map<String, Set<String>> synonyms;

  public SemanticMatchSearch(Map<String, Set<String>> synonyms) {
    this.synonyms = synonyms;
  }

  public Set<String> search(String query, List<String> items) {
    Set<String> results = new TreeSet<String>();
    Set<String> querySynonyms = synonyms.get(query.substring(query.lastIndexOf(' ') + 1));
    if(querySynonyms != null) {
      for(String synonym : querySynonyms) {
        results.addAll((new ExactMatchSearch()).search(synonym, items));
      }
    }

    return results;
  }
}
