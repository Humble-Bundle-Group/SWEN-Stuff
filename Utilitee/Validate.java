package Utilitee;

public final class Validate {

    public static boolean validateString(String word) {
        String regex = "^[a-zA-Z]+$";
        if (word.matches(regex)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean validateEmail(String word) {
        String regex = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
        if (word.matches(regex)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean validateNumber(String word) {
        String regex = "[0-9]+";
        if (word.matches(regex)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean validateVIN(String vin) {
        int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 2, 3, 4, 5, 0, 7, 0, 9,
                2, 3, 4, 5, 6, 7, 8, 9 };
        int[] weights = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };


        String s = vin;
        s = s.replaceAll("-", "");
        s = s.replaceAll(" ", "");
        s = s.toUpperCase();
        if (s.length() != 17)
            throw new RuntimeException("VIN number must be 17 characters");

        int sum = 0;
        for (int i = 0; i < 17; i++) {
            char c = s.charAt(i);
            int value;
            int weight = weights[i];

            // letter
            if (c >= 'A' && c <= 'Z') {
                value = values[c - 'A'];
                if (value == 0)
                    throw new RuntimeException("Illegal character: " + c);
            }

            // number
            else if (c >= '0' && c <= '9')
                value = c - '0';

                // illegal character
            else
                throw new RuntimeException("Illegal character: " + c);

            sum = sum + weight * value;

        }


        // check digit
        sum = sum % 11;
        char check = s.charAt(8);
        if (sum == 10 && check == 'X') {
            System.out.println("Valid");
            return true;
        } else if (sum == check - '0') {
            System.out.println("Valid");
            return true;
        } else {
            System.out.println("Invalid");
            return false;
        }

    }

}
