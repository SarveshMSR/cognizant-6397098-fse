public class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int id, String name, String cat) {
        productId = id;
        productName = name;
        category = cat;
    }

    // Getters for search attributes
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
}
