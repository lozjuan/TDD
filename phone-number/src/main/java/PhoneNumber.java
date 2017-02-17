public class PhoneNumber {

    String number;

    public PhoneNumber(String phoneNumber) {
        this.number = testNumber(phoneNumber);
    }

    public String getNumber() {
        return number;
    }

    public String testNumber(String number) {
        if (number.matches("[\\w?!#@:-]+") && !number.matches("[\\d]+")) {
            throw new IllegalArgumentException("Illegal character in phone number. Only digits, spaces, parentheses, hyphens or dots accepted.");
        }
        String formattedNum = number.replaceAll("\\D+", "");
        return LengthFormater(formattedNum);
    }

    public String LengthFormater(String number) {
        if (number.length() >= 12 || number.length() <= 9) {
            throw new IllegalArgumentException("Number must be 10 or 11 digits");
        }
        if (number.length() == 11 && number.indexOf("1") != 0) {
            throw new IllegalArgumentException("Can only have 11 digits if number starts with '1'");
        }

        if (number.length() == 11) {
            number = number.substring(1);
        }
        return number;
    }
}

