package app.controllers;

import app.entities.Bottom;
import app.exceptions.DatabaseException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BottomController {

    /*private DataSource dataSource;

    public BottomController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Bottom> getAllBottoms() throws DatabaseException {
        List<Bottom> bottoms = new ArrayList<>();
        String sql = "SELECT * FROM bottom";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                bottoms.add(new Bottom(name, price));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Fejl!!!!", e.getMessage());
        }
        return bottoms;
    }*/
}