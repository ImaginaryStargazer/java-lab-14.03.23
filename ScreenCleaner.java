import java.io.IOException;

class ScreenCleaner {
    public static void clearScreen() {  
        // trying to clear the console output
        // see: https://stackoverflow.com/questions/2979383/how-to-clear-the-console

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
