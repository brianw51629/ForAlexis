
public class Calculator {

    

    public Calculator() {
    }

    public static String extractWholeNumber(String number) {
        if (number.contains(".")) {
            return number.substring(0, number.indexOf('.'));
        }
        return number;
    }

    public static String extractDecimal(String number) {
        if (number.contains(".")) {
            String decimalPart = number.substring(number.indexOf('.') + 1);
            return decimalPart.isEmpty() ? "" : decimalPart;
        }
        return "";
    }

    public static String prependZeros(String number, int numZeros) {
        if (numZeros < 0) {
            return number;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numZeros; i++) {
            result.append('0');
        }
        result.append(number);
        return result.toString();
    }

    public static String appendZeros(String number, int numZeros) {
        if (numZeros < 0) {
            return number;
        }
        StringBuilder result = new StringBuilder(number);
        for (int i = 0; i < numZeros; i++) {
            result.append('0');
        }
        return result.toString();
    }

    public static String formatResult(String number) {
    if (number.contains(".")) {
        number = number.replaceFirst("^0+(?!\\.)", ""); // Remove leading zeros before the decimal point
        number = number.replaceAll("(?<=\\.[0-9]*)0+$", ""); // Remove trailing zeros after the decimal point
        
        if (number.startsWith(".")) {
            number = "0" + number; // Add leading zero before the decimal if needed
        }
    }
    return number;
}

    public static char addDigits(char firstDigit, char secondDigit, boolean carryIn) {
        int digit1 = firstDigit-'0';
        int digit2 = secondDigit-'0';

        int sum = digit1 + digit2 + (carryIn ? 1 : 0);

        return (char) ('0' + (sum % 10));
    }

    public static boolean carryOut(char firstDigit, char secondDigit, boolean carryIn) {
        int digit1 = firstDigit-'0';
        int digit2 = secondDigit-'0';

        int sum = digit1 + digit2 + (carryIn ? 1 : 0);

        return sum > 9;
    }

    public static String add(String firstNumber, String secondNumber) {
        
        String whole1 = extractWholeNumber(firstNumber);
        String whole2 = extractWholeNumber(secondNumber);
        String decimal1 = extractDecimal(firstNumber);
        String decimal2 = extractDecimal(secondNumber);
    
        
        int maxWholeLength = Math.max(whole1.length(), whole2.length());
        int maxDecimalLength = Math.max(decimal1.length(), decimal2.length());
    
        whole1 = prependZeros(whole1, maxWholeLength - whole1.length());
        whole2 = prependZeros(whole2, maxWholeLength - whole2.length());
        decimal1 = appendZeros(decimal1, maxDecimalLength - decimal1.length());
        decimal2 = appendZeros(decimal2, maxDecimalLength - decimal2.length());
    
        
        StringBuilder result = new StringBuilder();
        boolean carry = false;
    
        
        for (int i = maxDecimalLength - 1; i >= 0; i--) {
            char digit = addDigits(decimal1.charAt(i), decimal2.charAt(i), carry);
            carry = carryOut(decimal1.charAt(i), decimal2.charAt(i), carry);
            result.insert(0, digit);
        }
    
        
        result.insert(0, '.');
    
        
        for (int i = maxWholeLength - 1; i >= 0; i--) {
            char digit = addDigits(whole1.charAt(i), whole2.charAt(i), carry);
            carry = carryOut(whole1.charAt(i), whole2.charAt(i), carry);
            result.insert(0, digit);
        }
    
        
        if (carry) {
            result.insert(0, '1');
        }
    
        
        return formatResult(result.toString());
    }
    
    

    public static String multiply(String number, int numTimes) {
        if (numTimes <= 0) {
            return "0.0";
        }
    
        String result = "0.0";
        for (int i = 0; i < numTimes; i++) {
            result = add(result, number);
        }
    
        return formatResult(result);
    }

}
