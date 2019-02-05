package homework.dao;

import java.sql.*;

public class TableAdapter {

    private Connection connection;
    private Statement statement;

    public TableAdapter() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lesson2.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        // !!! "IF NOT EXISTS"
        String createTable =
                "CREATE TABLE IF NOT EXISTS products " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, " +
                " prodid INTEGER UNIQUE NOT NULL, " +
                " title STRING NOT NULL, " +
                " cost DECIMAL (10, 2) NOT NULL)";

        try {
            statement.executeUpdate(createTable);
        } catch (SQLException e) {e.printStackTrace();}
    }

    public int getNextId() {
        String sql = "SELECT MAX('prodid') from products";
        int id = 1;

        try {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) id = rs.getInt("prodid") + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void addProducts(int count) {
        int startId = getNextId();

        try {
            for(int i = 0; i < count; i++) {
                int id = startId + i;
                statement.addBatch(String.format("insert into products (prodid, title, cost) values (%d, '%s', %f)", id, "product" + id, id * 10));
            }
            statement.executeBatch();

        } catch (SQLException e) {e.printStackTrace();}

    }

}
