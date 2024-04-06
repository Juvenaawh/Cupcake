package app.controllers;

import app.entities.Topping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToppingController {

    private Connection connection;

    public ToppingController(Connection connection) {
        this.connection = connection;
    }

    public List<Topping> getAllToppings() throws SQLException {
        List<Topping> toppings = new ArrayList<>();
        String sql = "SELECT * FROM toppings";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                toppings.add(new Topping(name, price));
            }
        }
        return toppings;
    }
}