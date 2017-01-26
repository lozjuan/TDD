public class HelloWorld {
    public HelloWorld() {
    }

    public static String hello(String name) {
        String result = name != null && !name.isEmpty()?name:"World";
        return "Hello, " + result + "!";
    }
}