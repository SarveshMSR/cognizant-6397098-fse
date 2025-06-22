public class TestSearch {
    public static void main(String[] args) {
        
        Product[] products = {
            new Product(101, "Wireless Mouse", "Electronics"),
            new Product(203, "Office Chair", "Furniture"),
            new Product(305, "Bluetooth Speaker", "Electronics"),
            new Product(412, "Desk Lamp", "Home Decor")
        };

        // Linear search test
        long startTime = System.nanoTime();
        Product linearResult = LinearSearch.search(products, 305);
        long linearDuration = System.nanoTime() - startTime;

        // Binary search test
        startTime = System.nanoTime();
        Product binaryResult = BinarySearch.search(products, 305);
        long binaryDuration = System.nanoTime() - startTime;

        // Results
        System.out.println("Linear Search Result: " + 
            (linearResult != null ? linearResult.getProductName() : "Not Found") +
            " | Time: " + linearDuration + " ns");
            
        System.out.println("Binary Search Result: " + 
            (binaryResult != null ? binaryResult.getProductName() : "Not Found") +
            " | Time: " + binaryDuration + " ns");
    }
}
