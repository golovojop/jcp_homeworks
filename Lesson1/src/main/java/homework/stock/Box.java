package homework.stock;

/**
 * Use the <? extends wildcard> if you need to retrieve object from a data structure.
 * Use the <? super wildcard></?> if you need to put objects in a data structure.
 * If you need to do both things, don't use any wildcard.
 */

import homework.stock.fruits.Fruit;

import java.util.ArrayList;

public class Box <T extends Fruit>  {

    private ArrayList<Fruit> fruits = new ArrayList<>();
    private ArrayList<? super Fruit> fruitsIn = fruits;
    private ArrayList<? extends Fruit> fruitsOut = fruits;

    private float unitWeight;

    public Box(float unitWeight) {
        this.unitWeight = unitWeight;
    }

    public void putFruits(Fruit... fs) {
        for(Fruit f: fs)  fruitsIn.add(f);
    }

    public void putFruits(ArrayList<? extends Fruit> al) {
        fruitsIn.addAll(al);
    }

//    public <T extends Fruit> void putFruit(T fruit) {
//        fruitsIn.add(fruit);
//    }

    public float getWeight() {
        return fruits.size() * unitWeight;
    }

    public boolean compare(Box<?> anotherBox){
        return this.getWeight() == anotherBox.getWeight();
    }

    public void replaceTo(Box<T> anotherBox) {
        anotherBox.putFruits(fruitsOut);
        fruits.clear();
    }
}
