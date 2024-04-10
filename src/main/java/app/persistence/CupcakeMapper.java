package app.persistence;

import app.entities.Bottom;
import app.entities.Topping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CupcakeMapper {

    public static List<Topping> getAllToppings(ConnectionPool connectionPool) throws SQLException {
        List<Topping> toppings = new ArrayList<>();
        String sql = "SELECT * FROM topping";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connectionPool.getConnection().prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                toppings.add(new Topping(name, price));
            }
        }
        return toppings;
    }

    public static Topping getToppingById(int id, ConnectionPool connectionPool) throws SQLException {
       Topping topping = null;
        String sql = "SELECT * FROM topping where top_id = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
            ) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("top_name");
                int price = resultSet.getInt("top_price");
                topping = new Topping(name, price);
            }
        }
        return topping;
    }


    public static Bottom getBottomById(int id, ConnectionPool connectionPool) throws SQLException {
        Bottom bottom = null;
        String sql = "SELECT * FROM bottom where bot_id = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("bot_name");
                int price = resultSet.getInt("bot_price");
                bottom = new Bottom(name, price);
            }
        }
        return bottom;

    }
}
