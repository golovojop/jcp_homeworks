package homework.stock;


import homework.stock.fruits.Fruit;

import java.util.ArrayList;

public class Box <T extends Fruit>  {

    private ArrayList<Fruit> fruits = new ArrayList<>();
    private float unitWeight;

    public Box(float unitWeight) {
        this.unitWeight = unitWeight;
    }

    // Добавить из массива
    public void putFruits(Fruit... fs) {
        for(Fruit f: fs)  fruits.add(f);
    }

    // Добавить из коллекции
    private void putFruits(ArrayList<Fruit> al) {
        fruits.addAll(al);
    }

    public float getWeight() {
        return fruits.size() * unitWeight;
    }

    public boolean compare(Box<?> anotherBox){
        return this.getWeight() == anotherBox.getWeight();
    }

    // Коробка может содержать только один вид фруктов. Ограничение на тип.
    public void moveTo(Box<T> anotherBox) {
        anotherBox.putFruits(fruits);
        fruits.clear();
    }
}
