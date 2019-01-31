package homework;

public class Main {

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
        System.out.println("Before:");
        for(String s: strings) System.out.println(s);

        System.out.println("\nAfter:");
        ArrayUtils.swap(strings, 1, 2);
        for(String s: strings) System.out.println(s);

        // 1.2 Поменять местами элемементы массива объектов Person
        Person[] persons = {new Person(1, "Bob"), new Person(2, "Alice"), new Person(3, "Nick")};
        System.out.println("\nBefore:");
        for(Person p: persons) System.out.println(p);

        System.out.println("\nAfter:");
        ArrayUtils.swap(persons, 0, 2);
        for(Person p: persons) System.out.println(p);

    }

}

class ArrayUtils {

    // Поменять местами элемементы массива
    public static <T> void swap(T[] array, int i, int j){
        if(i >= array.length || j >= array.length) return;

        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
