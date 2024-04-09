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


}