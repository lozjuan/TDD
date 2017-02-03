import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Robot {

    private String name;
    private List<String> alreadyUsedNames = new ArrayList<>();

    public Robot() {
        this.name = createNewName();
    }

    public String getName() {
g         return name;
    }

    public String createNewName() {
        int num = ThreadLocalRandom.current().nextInt(100, 999);
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 2; ++i) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        name = sb.toString() + num;

        if (alreadyUsedNames.contains(name)) {
            reset();
        }
        alreadyUsedNames.add(name);
        return name;
    }

    public String reset() {
        return createNewName();
    }
}
