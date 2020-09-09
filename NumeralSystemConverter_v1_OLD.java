package converter;

import java.util.Scanner;

/*
Achtung!
New version available! This one is a pure cancer. 


---------------------------------------------------------------------
A numeral converter that converts value from numeric system A to value from system B;

And this is my implementation...
 */


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    static int any2dec(String inputNumber, long inputBase) {
        int length = inputNumber.length();
        int decimalNumber = 0;

        for (int i = 0; i < length; i++) {
            decimalNumber += Character.getNumericValue(inputNumber.charAt(i)) * Math.pow(inputBase, length - 1 - i);
        }
        return decimalNumber;
    } // coverts value from any numeric system to decimal system

    static StringBuilder addPrefix(StringBuilder output, long systemBase) {
        switch ((int) systemBase) {
            case 2: {
                output.insert(0, "0b");
                break;
            }
            case 8: {
                output.insert(0, "0");
                break;
            }
            case 16: {
                output.insert(0, "0x");
                break;
            }
            default: {
                break;
            }
        }
        return output;
    } //  add prefix for the binary, octal and hex systems

    public static void main(String[] args) {

        long inputBase = scanner.nextLong();     // input value radix
        String inputNum = scanner.next();        // input value for conversion
        long decimalNum;                         // holds decimal value
        long systemBase = scanner.nextLong();    // target radix
        long result;                             // result of decimal number % base

        StringBuilder output = new StringBuilder();

        if (inputBase != 10) { // check if value need conversion to decimal
            decimalNum = any2dec(inputNum, inputBase);
        } else {
            decimalNum = Long.parseLong(inputNum);
        }

        if (systemBase == 1) { // check for special case
            for (int i = 0; i < decimalNum; i++) {
                output.insert(0, "1");
            }
        } else {
            if (decimalNum == 0) { // if value equals 0 then just add 0
                output.insert(0, "0");
            } else {
                while (decimalNum > 0) {
                    result = decimalNum % systemBase;
                    decimalNum = decimalNum / systemBase;

                    if (systemBase > 10) { // check if notation contains numbers larger than 9 that need replacing
                        if (result > 9) {  // if result is smaller or equal than 9 it uses decimal numbers.
                            switch ((int) result) {
                                case 10: {
                                    output.insert(0, "a");
                                    break;
                                }
                                case 11: {
                                    output.insert(0, "b");
                                    break;
                                }
                                case 12: {
                                    output.insert(0, "c");
                                    break;
                                }
                                case 13: {
                                    output.insert(0, "d");
                                    break;
                                }
                                case 14: {
                                    output.insert(0, "e");
                                    break;
                                }
                                case 15: {
                                    output.insert(0, "f");
                                    break;
                                }
                                case 16: {
                                    output.insert(0, "g");
                                    break;
                                }
                                case 17: {
                                    output.insert(0, "h");
                                    break;
                                }
                                case 18: {
                                    output.insert(0, "i");
                                    break;
                                }
                                case 19: {
                                    output.insert(0, "j");
                                    break;
                                }
                                case 20: {
                                    output.insert(0, "k");
                                    break;
                                }
                                case 21: {
                                    output.insert(0, "l");
                                    break;
                                }
                                case 22: {
                                    output.insert(0, "m");
                                    break;
                                }
                                case 23: {
                                    output.insert(0, "n");
                                    break;
                                }
                                case 24: {
                                    output.insert(0, "o");
                                    break;
                                }
                                case 25: {
                                    output.insert(0, "p");
                                    break;
                                }
                                case 26: {
                                    output.insert(0, "q");
                                    break;
                                }
                                case 27: {
                                    output.insert(0, "r");
                                    break;
                                }
                                case 28: {
                                    output.insert(0, "s");
                                    break;
                                }
                                case 29: {
                                    output.insert(0, "t");
                                    break;
                                }
                                case 30: {
                                    output.insert(0, "u");
                                    break;
                                }
                                case 31: {
                                    output.insert(0, "v");
                                    break;
                                }
                                case 32: {
                                    output.insert(0, "w");
                                    break;
                                }
                                case 33: {
                                    output.insert(0, "x");
                                    break;
                                }
                                case 34: {
                                    output.insert(0, "y");
                                    break;
                                }
                                case 35: {
                                    output.insert(0, "z");
                                    break;
                                }
                            }
                        } else {
                            output.insert(0, result);
                        }
                    } else {
                        output.insert(0, result);
                    }
                }
            }
            // output = addPrefix(output, systemBase); // adds prefix
        }
        System.out.println(output); // return final product
    }
}

/*
-------------------------------------------------------------------------
...And this is how it should have been done XD

package converter;

import java.util.Scanner;

package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int radixOfNum = sc.nextInt();
        String numInString = sc.next();
        int radixTarget = sc.nextInt();

        long num;
        if (radixOfNum == 1) {
            num = numInString.length();
        } else {
            num = Long.parseLong(numInString, radixOfNum);
        }

        if (radixTarget == 1) {
            for (int i = 0; i < num; i++) {
                System.out.print(1);
            }
        } else {
            String numTarget = Long.toString(num, radixTarget);
            System.out.print(numTarget);
        }
    }
}

 */
