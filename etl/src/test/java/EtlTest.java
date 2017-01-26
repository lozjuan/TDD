import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class EtlTest {
    private final Etl etl = new Etl();

    public EtlTest() {
    }

    @Test
    public void testTransformOneValue() {
        HashMap old = new HashMap() {
            {
                this.put(Integer.valueOf(1), Arrays.asList(new String[]{"A"}));
            }
        };
        Map old1 = Collections.unmodifiableMap(old);
        HashMap expected = new HashMap() {
            {
                this.put("a", Integer.valueOf(1));
            }
        };
        Map expected1 = Collections.unmodifiableMap(expected);
        Assert.assertEquals(expected1, this.etl.transform(old1));
    }

    @Test
    public void testTransformMoreValues() {
        HashMap old = new HashMap() {
            {
                this.put(Integer.valueOf(1), Arrays.asList(new String[]{"A", "E", "I", "O", "U"}));
            }
        };
        Map old1 = Collections.unmodifiableMap(old);
        HashMap expected = new HashMap() {
            {
                this.put("a", Integer.valueOf(1));
                this.put("e", Integer.valueOf(1));
                this.put("i", Integer.valueOf(1));
                this.put("o", Integer.valueOf(1));
                this.put("u", Integer.valueOf(1));
            }
        };
        Map expected1 = Collections.unmodifiableMap(expected);
        Assert.assertEquals(expected1, this.etl.transform(old1));
    }

    @Test
    public void testMoreKeys() {
        HashMap old = new HashMap() {
            {
                this.put(Integer.valueOf(1), Arrays.asList(new String[]{"A", "E"}));
                this.put(Integer.valueOf(2), Arrays.asList(new String[]{"D", "G"}));
            }
        };
        Map old1 = Collections.unmodifiableMap(old);
        HashMap expected = new HashMap() {
            {
                this.put("a", Integer.valueOf(1));
                this.put("e", Integer.valueOf(1));
                this.put("d", Integer.valueOf(2));
                this.put("g", Integer.valueOf(2));
            }
        };
        Map expected1 = Collections.unmodifiableMap(expected);
        Assert.assertEquals(expected1, this.etl.transform(old1));
    }

    @Test
    public void testFullDataset() {
        HashMap old = new HashMap() {
            {
                this.put(Integer.valueOf(1), Arrays.asList(new String[]{"A", "E", "I", "O", "U", "L", "N", "R", "S", "T"}));
                this.put(Integer.valueOf(2), Arrays.asList(new String[]{"D", "G"}));
                this.put(Integer.valueOf(3), Arrays.asList(new String[]{"B", "C", "M", "P"}));
                this.put(Integer.valueOf(4), Arrays.asList(new String[]{"F", "H", "V", "W", "Y"}));
                this.put(Integer.valueOf(5), Arrays.asList(new String[]{"K"}));
                this.put(Integer.valueOf(8), Arrays.asList(new String[]{"J", "X"}));
                this.put(Integer.valueOf(10), Arrays.asList(new String[]{"Q", "Z"}));
            }
        };
        Map old1 = Collections.unmodifiableMap(old);
        HashMap expected = new HashMap() {
            {
                this.put("a", Integer.valueOf(1));
                this.put("b", Integer.valueOf(3));
                this.put("c", Integer.valueOf(3));
                this.put("d", Integer.valueOf(2));
                this.put("e", Integer.valueOf(1));
                this.put("f", Integer.valueOf(4));
                this.put("g", Integer.valueOf(2));
                this.put("h", Integer.valueOf(4));
                this.put("i", Integer.valueOf(1));
                this.put("j", Integer.valueOf(8));
                this.put("k", Integer.valueOf(5));
                this.put("l", Integer.valueOf(1));
                this.put("m", Integer.valueOf(3));
                this.put("n", Integer.valueOf(1));
                this.put("o", Integer.valueOf(1));
                this.put("p", Integer.valueOf(3));
                this.put("q", Integer.valueOf(10));
                this.put("r", Integer.valueOf(1));
                this.put("s", Integer.valueOf(1));
                this.put("t", Integer.valueOf(1));
                this.put("u", Integer.valueOf(1));
                this.put("v", Integer.valueOf(4));
                this.put("w", Integer.valueOf(4));
                this.put("x", Integer.valueOf(8));
                this.put("y", Integer.valueOf(4));
                this.put("z", Integer.valueOf(10));
            }
        };
        Map expected1 = Collections.unmodifiableMap(expected);
        Assert.assertEquals(expected1, this.etl.transform(old1));
    }
}