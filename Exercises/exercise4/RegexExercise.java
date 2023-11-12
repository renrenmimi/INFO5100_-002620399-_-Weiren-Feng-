package Exercises.exercise4;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExercise {

    public static void main(String[] args) {
        // Test email pattern
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        testRegexPattern(emailRegex, "hello@example.com", true); // Should match
        testRegexPattern(emailRegex, "hello@example", false); // Should not match

        // Test phone number pattern
        String phoneRegex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        testRegexPattern(phoneRegex, "+1234567890", true); // Should match
        testRegexPattern(phoneRegex, "1234567890", false); // Should not match

        // Test postal code pattern
        String postalCodeRegex = "^[0-9]{5}(?:-[0-9]{4})?$";
        testRegexPattern(postalCodeRegex, "12345-6789", true); // Should match
        testRegexPattern(postalCodeRegex, "1234", false); // Should not match

        // Test URL pattern
        String urlRegex = "^(http|https)://[^\\s]+$";
        testRegexPattern(urlRegex, "https://www.example.com", true); // Should match
        testRegexPattern(urlRegex, "www.example.com", false); // Should not match

        // Test date format pattern
        String dateRegex = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
        testRegexPattern(dateRegex, "31-01-2020", true); // Should match
        testRegexPattern(dateRegex, "31/02/2020", false); // Should not match
    }

    private static void testRegexPattern(String regex, String input, boolean expected) {
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Check if the input matches the pattern
        boolean matches = matcher.matches();

        // Print the result
        if (matches == expected) {
            System.out.println("PASS: \"" + input + "\" matches the pattern? " + matches);
        } else {
            System.out.println("FAIL: \"" + input + "\" matches the pattern? " + matches);
        }
    }
}