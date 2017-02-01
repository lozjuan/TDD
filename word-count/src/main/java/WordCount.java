import java.util.*;

public class WordCount {

    public WordCount() {
        super();
    }

    public Map<String, Integer> phrase(String s){
        Map<String, Integer> WordCount = new HashMap<>();
        List<String> words = new ArrayList<>(Arrays.asList(s.replaceAll("[\\W]", " ").toLowerCase().split("\\s+")));
        for (String word : words) {
            Integer count = WordCount.get(word);
            WordCount.put(word, count == null ? 1 : count + 1);
        }
        return WordCount;
    }
}

