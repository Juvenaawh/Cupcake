package app.dao;

import app.models.Bottom;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BottomDAO {

    private DataSource dataSource;

    public BottomDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Bottom> getAllBottoms() throws SQLException {
        List<Bottom> bottoms = new ArrayList<>();
        String sql = "SELECT * FROM bottoms";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                bottoms.add(new Bottom(name, price));
            }
        }
        return bottoms;
    }
}