public class TestLogger {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log entry");
        
        Logger logger2 = Logger.getInstance();
        logger2.log("Second log entry");
        
        System.out.println("\nSingleton Verification:");
        System.out.println("Same instance? " + (logger1 == logger2));
        System.out.println("Instance 1 hash: " + logger1.hashCode());
        System.out.println("Instance 2 hash: " + logger2.hashCode());
    }
}
