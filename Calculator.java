
public class Calculator {

    public static void main(String[] args) {
        
    }

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

        String result = number.replaceFirst("^0+(?!$)", "");

        if (!result.contains(".")) {
            result += ".0";
        }

        if (result.startsWith(".")) {
            result = "0" + result;
        }

        int dotIndex = result.indexOf('.');
        if (dotIndex != -1) {
            result = result.replaceAll("(?<=\\.[0-9]*[^0])0+$", "");
        }

        if (result.endsWith(".")) {
            result += "0";
        }

        return result;
    }

    public static char addDigits(char firstDigit, char secondDigit, boolean carryIn) {
        int digit1 = Character.getNumericValue(firstDigit);
        int digit2 = Character.getNumericValue(secondDigit);

        int sum = digit1 + digit2 + (carryIn ? 1 : 0);

        return (char) ('0' + (sum % 10));
    }

    public static boolean carryOut(char firstDigit, char secondDigit, boolean carryIn) {
        int digit1 = Character.getNumericValue(firstDigit);
        int digit2 = Character.getNumericValue(secondDigit);

        int sum = digit1 + digit2 + (carryIn ? 1 : 0);

        return sum > 9;
    }

    public static String add(String firstNumber, String secondNumber) {
        
        String whole1 = extractWholeNumber(firstNumber);
        String whole2 = extractWholeNumber(secondNumber);
        String decimal1 = extractDecimal(firstNumber);
        String decimal2 = extractDecimal(secondNumber);
        int maxWholeLength;
        int maxDecimalLength;
        if(whole1.length()>whole2.length()){
            maxWholeLength=whole1.length();
        }else{
            maxWholeLength=whole2.length();
        }
        if(decimal1.length()>decimal2.length()){
            maxDecimalLength=decimal1.length();
        }else{
            maxDecimalLength=decimal2.length();
        }
        
        
        //int maxWholeLength = Math.max(whole1.length(), whole2.length());
        //int maxDecimalLength = Math.max(decimal1.length(), decimal2.length());

        whole1 = prependZeros(whole1, maxWholeLength - whole1.length());
        whole2 = prependZeros(whole2, maxWholeLength - whole2.length());
        decimal1 = appendZeros(decimal1, maxDecimalLength - decimal1.length());
        decimal2 = appendZeros(decimal2, maxDecimalLength - decimal2.length());

        
        String num1 = whole1 + decimal1;
        String num2 = whole2 + decimal2;

        StringBuilder result = new StringBuilder();
        boolean carry = false;
        for (int i = num1.length() - 1; i >= 0; i--) {
            char digit = addDigits(num1.charAt(i), num2.charAt(i), carry);
            carry = carryOut(num1.charAt(i), num2.charAt(i), carry);
            result.insert(0, digit);
        }
        if (carry) {
            result.insert(0, '1');
        }

        String finalResult = result.substring(0, maxWholeLength) + "." + result.substring(maxWholeLength);
        return formatResult(finalResult);
    }

    public static String multiply(String number, int numTimes) {
        if (numTimes <= 0){
            return "0.0";
        } 
        
        String result = "0.0";
        for (int i = 0; i < numTimes; i++) {
            result = add(result, number);
        }
        return formatResult(result);
    }

}

