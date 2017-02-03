public class Bob {

    public String hey(String chattyBoy) {
        if (chattyBoy.matches(".*[?]$") && !chattyBoy.matches("[A-Z]+\\s+.*[?]")) {
            return "Sure.";
        } else if (chattyBoy.toUpperCase().equals(chattyBoy) && !chattyBoy.matches("\\d+(\\,\\s\\d+)*")
                && !chattyBoy.isEmpty() && !chattyBoy.matches("\\s+")) {
            return "Whoa, chill out!";
        } else if (chattyBoy.isEmpty() || chattyBoy.matches("\\s+")) {
            return "Fine. Be that way!";
        } else {
            return "Whatever.";
        }
    }
}