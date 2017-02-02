import java.util.Arrays;
import java.util.stream.Collectors;

public class Pangrams {

    public static boolean isPangram(String phrase) {
        String[] test = phrase.toLowerCase().replaceAll("[^a-zA-Z]", "").split("");
        return Arrays.stream(test).collect(Collectors.toSet()).size() == 26;
    }
}
