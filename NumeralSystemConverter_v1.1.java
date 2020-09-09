/*
Second attempt - completly rewritten. Much, much better & cleaner code.

This program converts any number from one numeral system to another - also converts floating point numbers. 

Example:

input: 35 // input number base
input: af.xy // input number
input: 17 // expected number

output: 148.g88a8 // af.xy [base-35] converted to 148.g88a8 [base-17]

9/9/2020 | 18:30 | s. 
-------------------------------------------------------------------------
*/

import java.util.Scanner;

class Main {
    
    final int OUTPUT_PRECISION = 5;
    
    // convert whole number to decimal
    static long convertToDecimal(String inputNum, int inputBase) {
        return Long.parseLong(inputNum, inputBase);
    }

    // convert decimal whole number to provided base
    static String convertToOutputBase(long inputNum, int outputBase) {
        return Long.toString(inputNum, outputBase);
    }

    // convert decimal whole number to base-1
    static void outputBase1(long inputNum) {
        for (int i = 0; i < inputNum; i++) {
            System.out.print("1");
        }
    }

    // check if input is floating point // can be replaced with .contains(".")
    static boolean isFloatingPoint(String inputNum) {
        for (int i = 0; i < inputNum.length(); i++) {
            if (inputNum.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    // get whole part from floating point
    static String getWholeNumber(String inputNum) {
        StringBuilder wholeNumber = new StringBuilder();
        int i = 0;
        while (inputNum.charAt(i) != '.') {
            wholeNumber.append(inputNum.charAt(i));
            i++;
        }
        return wholeNumber.toString();
    }

    // get floating part from floating point
    static String getFloat(String inputNum) {
        StringBuilder floatPart = new StringBuilder();
        int i = (inputNum.length() - 1);
        while (inputNum.charAt(i) != '.') {
            floatPart.insert(0, inputNum.charAt(i));
            i--;
        }
        return floatPart.toString();
    }

    // convert floating part to decimal
    static double convertFloatToDecimal(String floatPart, int inputBase) {
        double outputFloat = 0;
        for (int i = 0; i < floatPart.length(); i++) {
            outputFloat += Character.digit(floatPart.charAt(i), inputBase) / Math.pow(inputBase, (1 + i));
        }
        return outputFloat;
    }

    // convert decimal floating part to target base
    static String convertFloatToOutputBase(double floatPart, int outputBase) {
        StringBuilder outputFloat = new StringBuilder();

        for (int i = 0; i < OUTPUT_PRECISION; i++) {
            floatPart = Math.abs(floatPart - (int) floatPart);
            floatPart *= outputBase;
            outputFloat.append(Integer.toString((int) floatPart, outputBase));
        }
        return outputFloat.toString();
    }

    // merge converted whole part and floating part
    static void mergeWholeAndFloat(String wholeNum, String floatPart) {
        System.out.println(wholeNum + "." + floatPart);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // take input
        int inputBase   = scanner.nextInt();
        String inputNum = scanner.next();
        int outputBase  = scanner.nextInt();


        if (inputBase == 1) {
            System.out.println(convertToOutputBase(inputNum.length(), outputBase));
        } else if (outputBase == 1) {
            outputBase1(convertToDecimal(inputNum, inputBase));
        } else {
            if (isFloatingPoint(inputNum)) {
                String wholeNumberTargetBase = convertToOutputBase(convertToDecimal(getWholeNumber(inputNum), inputBase), outputBase);
                String floatPartTargetBase = convertFloatToOutputBase(convertFloatToDecimal(getFloat(inputNum), inputBase), outputBase);
                mergeWholeAndFloat(wholeNumberTargetBase, floatPartTargetBase);
            } else {
                System.out.println(convertToOutputBase(convertToDecimal(inputNum, inputBase), outputBase));
            }
        }
    }
}
