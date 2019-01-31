package homework;

import homework.stock.Box;
import homework.stock.fruits.Apple;
import homework.stock.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    // Тестовый класс
    static class Person {
        int id;
        String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return String.format("id = %d, name = %s", id, name);
        }
    }

    public static void main(String[] args) {

        // 1.1 Поменять местами элемементы массива строк
        String[] strings = {"Hello", "Core", "Java"};
        System.out.println("Before:\n------------------");
        for(String s: strings) System.out.println(s);

        System.out.println("\nAfter:\n------------------");
        ArrayUtils.swap(strings, 1, 2);
        for(String s: strings) System.out.println(s);

        // 1.2 Поменять местами элемементы массива объектов Person
        Person[] persons = {new Person(1, "Bob"), new Person(2, "Alice"), new Person(3, "Nick")};
        System.out.println("\nBefore:\n------------------");
        for(Person p: persons) System.out.println(p);

        System.out.println("\nAfter:\n------------------");
        ArrayUtils.swap(persons, 0, 2);
        for(Person p: persons) System.out.println(p);

        // 2.1 Конвертируем массивы в ArrayList
        System.out.println("\nPrint ArrayLists:\n------------------");
        ArrayList<String> alS = ArrayUtils.array2list(strings);
        ArrayList<Person> alP = ArrayUtils.array2list(persons);

        alS.forEach(s -> System.out.println(s));
        alP.forEach(p -> System.out.println(p));

        // Работаем с фруктами
        Box<Apple> appleBox1 = new Box<>(Apple.weight);
        appleBox1.putFruits(new Apple(), new Apple(), new Apple());

        Box<Orange> orangeBox1 = new Box<>(Orange.weight);
        orangeBox1.putFruits(new Orange(), new Orange(), new Orange());

        System.out.println("\n\nFruits in boxes\n------------------");
        System.out.println("Apple box1 weight = " + appleBox1.getWeight());
        System.out.println("Orange box1 weight = " + orangeBox1.getWeight());

        System.out.println("Boxes weight is the same: " + appleBox1.compare(orangeBox1));

        Box<Apple> appleBox2 = new Box<>(Apple.weight);
        appleBox1.replaceTo(appleBox2);
        System.out.println("Apple box1 weight = " + appleBox1.getWeight());
        System.out.println("Apple box2 weight = " + appleBox2.getWeight());

//        Box<Orange> orangeBox2 = new Box<>(Orange.weight);
//        appleBox2.replaceTo(orangeBox2);
//        System.out.println("Apple box2 weight = " + appleBox2.getWeight());
//        System.out.println("Orange box2 weight = " + orangeBox2.getWeight());
    }
}

// Для заданий 1 и 2
class ArrayUtils {

    // Поменять местами элемементы массива
    public static <T> void swap(T[] array, int i, int j){
        if(i >= array.length || j >= array.length) return;

        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // Сконвертировать массив в ArrayList
    public static <E> ArrayList<E> array2list(E[] array) {
        return new ArrayList<E>(Arrays.asList(array));
    }

}
