package homework.stock.fruits;

public enum Weights {
    APPLE(1.0f), ORANGE(1.5f);

    private float weight;

    Weights(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}
