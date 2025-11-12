package helpers;

public class ConsoleColor {
    public static String consoleColor(String text, String colorCode){
        return colorCode + text + "\u001B[0m";
    }
}
