package helpers;

public class ConsoleColor {
    private static final String RESET = "\u001B[0m";
    public static String consoleColor(String message, String colorCode){
        return colorCode + message + RESET;
    }
}
