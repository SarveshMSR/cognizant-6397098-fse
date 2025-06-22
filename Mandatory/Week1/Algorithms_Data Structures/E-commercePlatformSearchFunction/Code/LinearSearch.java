public class LinearSearch {
    public static Product search(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.getProductId() == targetId) return p;
        }
        return null;
    }
}
