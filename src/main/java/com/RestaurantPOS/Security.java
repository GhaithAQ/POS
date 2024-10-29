package com.RestaurantPOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Security {
    private final String username = "Ghaith";
    private final String password = "GG0097qstx7123)(123";
    private final String address = "jdbc:mysql://localhost:33010/orders";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(address, username, password);
    }
}
