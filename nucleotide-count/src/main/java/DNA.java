import java.util.*;

public class DNA {

    private static List<Character> dnaElements = Arrays.asList('A', 'C', 'G', 'T');
    private String dna;
    private Map<Character, Integer> nucleotideCounts;

    public DNA(String dna) {
        this.dna = dna.toUpperCase();
        nucleotideCounts = new HashMap<>();
    }

    public Integer count(Character dnaElement) {
        if (!dnaElements.contains(dnaElement)) {
            throw new IllegalArgumentException("it is not a dna element");
        }
        Integer counter = 0;
        char[] dnaToArray = dna.toCharArray();
        for (char item : dnaToArray) {
            if (item == dnaElement) {
                counter += 1;
            }
        }
        return counter;
    }

    public Map<Character, Integer> nucleotideCounts() {
        for (Character e : dnaElements) {
            nucleotideCounts.put(e, 0);
        }
        for (Character e : dna.toCharArray()) {
            if (nucleotideCounts.containsKey(e)) {
                nucleotideCounts.put(e, nucleotideCounts.get(e) + 1);
            }
        }
        return nucleotideCounts;
    }
}