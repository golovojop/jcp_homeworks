package homework.dao;

import java.sql.*;

public class TableAdapter {

    private Connection connection;
    private Statement statement = null;

    public TableAdapter() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lesson2.db");
            statement = connection.createStatement();
            prepareTable();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // При старте программы подготовить пустую таблицу
    private void prepareTable() {
        try {
            // Проверить наличие таблицы
            ResultSet rs = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='products'");

            if(rs.next())
                clearTable();
            else
                createTable();

        } catch (SQLException e) {e.printStackTrace();}
    }

    // Очистить таблицу
    private void clearTable() {
        try {
            statement.executeUpdate("DELETE FROM 'products'");
        } catch (SQLException e) {e.printStackTrace();}
    }

    // Создать таблицу
    private void createTable() {
        String createTable =
                "CREATE TABLE IF NOT EXISTS products " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, " +
                " prodid INTEGER NOT NULL, " +
                " title STRING NOT NULL, " +
                " cost DECIMAL (10, 2) NOT NULL)";

        try {
            statement.executeUpdate(createTable);
        } catch (SQLException e) {e.printStackTrace();}
    }

    // Следующий доступный ID для продукта если база не пустая
    public int getNextId() {
        String sql = "SELECT MAX('prodid') AS max FROM products;";
        int id = 1;

        try {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) id = rs.getInt("max") + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    // Добавить продукты списком
    public void addProducts(int count) {
        int startId = getNextId();

        try {
            connection.setAutoCommit(false);
            for(int i = 0; i < count; i++) {
                int id = startId + i;
                statement.addBatch(String.format("INSERT INTO products (prodid, title, cost) VALUES ('%d', '%s', '%.2f');", id, "product" + id, (float)(id * 10)));
            }
            statement.executeBatch();
            connection.setAutoCommit(true);
        } catch (Exception e) {e.printStackTrace();}
    }
}
