package homework;

import homework.dao.TableAdapter;

public class StartApp {

    public static void main(String[] args) {
        TableAdapter ta = new TableAdapter();

        long t = System.currentTimeMillis();
        ta.addProducts(10000);
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - t) + " msec");
    }
}
