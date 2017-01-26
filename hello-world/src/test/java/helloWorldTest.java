mport org.junit.Assert;
        import org.junit.Test;

public class HelloWorldTest {
    public HelloWorldTest() {
    }

    @Test
    public void helloNoName() {
        Assert.assertEquals("Hello, World!", HelloWorld.hello(""));
        Assert.assertEquals("Hello, World!", HelloWorld.hello((String)null));
    }

    @Test
    public void helloSampleName() {
        Assert.assertEquals("Hello, Alice!", HelloWorld.hello("Alice"));
    }

    @Test
    public void helloAnotherSampleName() {
        Assert.assertEquals("Hello, Bob!", HelloWorld.hello("Bob"));
    }
}