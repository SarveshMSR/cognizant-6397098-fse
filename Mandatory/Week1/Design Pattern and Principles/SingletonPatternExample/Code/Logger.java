public class Logger {
    // Private static instance
    private static Logger instance;
    
    // Private constructor
    private Logger() {
        System.out.println("Logger instance created");
    }
    
    // Public static access method
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
