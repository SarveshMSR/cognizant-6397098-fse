import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {
    public static Product search(Product[] products, int targetId) {
        // Sort by ID first (prerequisite for binary search)
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
        
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = products[mid].getProductId();
            
            if (midId == targetId) return products[mid];
            else if (midId < targetId) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}
