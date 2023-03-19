/**
 * Task 3: Number System Converter
 * Goal: Showcase the knowledge of Classes, their fields and methods (probably)
 * And a do-while loop.
 * 
 * I know, that this task is optional,
 * but I wanted to try to implement it still :)
 * 
 * Possible improvement:
 * wrap the cmd's somehow not to check the raw cmd == 'char' all the time.
 */
class Task3 {
    public static void main(String[] args) {
        ScreenCleaner.clearScreen();
        InputReader.open();

        char cmd;
        do {
            printMenu();
            cmd = InputReader.getChar();

            if (isUnknownCmd(cmd)) {
                continue;
            }

            if (isExitCmd(cmd)) {
                break;
            }

            if (isToDecimal(cmd)) {
                NumBasePair num = new NumBasePair(
                        InputReader.getLine("Provide a number: "),
                        InputReader.getInt("Specify it's base: "));

                printAndWait("Result is: " + num.convertToDecimal());
                continue;
            }

            if (isFromDecimal(cmd)) {
                NumBasePair num = new NumBasePair(
                        InputReader.getLine("Provide a decimal number: "), 10);
                int targetBase = InputReader.getInt("Specify the target base: ");

                printAndWait("Result is: " + num.convertFromDecimal(targetBase));
                continue;
            }

            NumBasePair first = new NumBasePair(
                    InputReader.getLine("First number value: "),
                    InputReader.getInt("Specify it's base: "));
            NumBasePair second = new NumBasePair(
                    InputReader.getLine("Second number value: "),
                    InputReader.getInt("Specify it's base: "));
            int targetBase = InputReader.getInt("Specify the base of the result: ");

            int firstDecimal = first.convertToDecimalValue();
            int secondDecimal = second.convertToDecimalValue();
            long resultValue = 0L;

            if (cmd == 'c') {
                resultValue = 0L + firstDecimal + secondDecimal;
            } else if (cmd == 'd') {
                resultValue = 0L + firstDecimal - secondDecimal;
            } else if (cmd == 'e') {
                resultValue = 1L * firstDecimal * secondDecimal;
            } else if (cmd == 'f') {
                resultValue = (long) (1.0 * firstDecimal / secondDecimal);
            }

            NumBasePair result = new NumBasePair(Long.toString(resultValue), 10);
            printAndWait("Result is: " + result.convertFromDecimal(targetBase));
        } while (true);

        System.out.println("Terminating the program...");
        InputReader.close();
    }

    static boolean isExitCmd(char cmd) {
        if (cmd == 'w') {
            return true;
        }
        return false;
    }

    static boolean isToDecimal(char cmd) {
        if (cmd == 'a') {
            return true;
        }
        return false;
    }

    static boolean isFromDecimal(char cmd) {
        if (cmd == 'b') {
            return true;
        }
        return false;
    }

    static boolean isUnknownCmd(char cmd) {
        if (isExitCmd(cmd)
                || isToDecimal(cmd)
                || isFromDecimal(cmd)
                || cmd == 'c'
                || cmd == 'd'
                || cmd == 'e'
                || cmd == 'f') {
            return false;
        }
        return true;
    }

    static void printMenu() {
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("| Number System Converter |");
        System.out.println("---------------------------");

        System.out.println();
        System.out.println("A. Convert from bases up to 16th to decimal");
        System.out.println("B. Convert from decimal to bases up to 16th");
        System.out.println("C. Sum two numbers in bases up to 16th");
        System.out.println("D. Subtract two numbers in bases up to 16th");
        System.out.println("E. Multiply two numbers in bases up to 16th");
        System.out.println("F. Divide two numbers in bases up to 16th");

        System.out.println();
        System.out.println("W. Exit the program");
        System.out.println();
        System.out.print("Choose an operation to perform (type a symbol A-F or W): ");
    }

    static void printAndWait(String msg) {
        System.out.println(msg);
        InputReader.getLine("...press Enter to continue... ");
    }
}

class InputReader {
    private static java.io.Console console;

    static void open() {
        if (console != null) {
            return;
        }
        console = System.console();
    }

    static void close() {
        if (console == null) {
            return;
        }
        console = null;
    }

    static String getLine(String prompt) {
        open();

        if (prompt != null) {
            System.out.print(prompt);
        }

        return console.readLine();
    }

    static String getLine() {
        return getLine(null);
    }

    static char getChar(String prompt) {
        String intermediate = getLine(prompt).toLowerCase();

        if (intermediate.length() == 0) {
            return ' ';
        }
        return intermediate.charAt(0);
    }

    static char getChar() {
        return getChar(null);
    }

    static int getInt(String prompt) {
        open();

        if (prompt != null) {
            System.out.print(prompt);
        }

        String line = console.readLine();
        int value;

        try {
            value = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            value = 0;
        }

        // if (prompt != null) {
        //     System.out.println();
        // }

        return value;
    }

    static int getInt() {
        return getInt(null);
    }
}

class NumBasePair {
    private String number;
    private int base;

    NumBasePair(String number, int base) {
        this.number = number;
        this.base = base;
    }

    void setNumber(String number) {
        this.number = number;
    }

    String convertToDecimal() {
        if (base == 10) {
            return number;
        }
        return Integer.toString(Integer.parseInt(number, base), 10);
    }

    String convertFromDecimal(int targetBase) {
        if (base == targetBase) {
            return number;
        }
        return Integer.toString(Integer.parseInt(number, base), targetBase);
    }

    int convertToDecimalValue() {
        return Integer.parseInt(number, base);
    }
}
