package homework.business;

public class Product {
    private int prodId;
    private String title;
    private float cost;

    public Product(int prodId, String title, float cost) {
        this.prodId = prodId;
        this.title = title;
        this.cost = cost;
    }

    public int getProdId() {
        return prodId;
    }

    public String getTitle() {
        return title;
    }

    public float getCost() {
        return cost;
    }
}
