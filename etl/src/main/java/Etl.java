import java.util.*;

public class Etl {
    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> expected = new HashMap<>();
        old.entrySet().stream().forEach(e -> e.getValue().stream().forEach(v -> expected.put(v.toLowerCase(), e.getKey())));

        return expected;
    }
}