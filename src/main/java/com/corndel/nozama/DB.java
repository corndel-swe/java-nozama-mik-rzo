package com.corndel.nozama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
  public static final String dbUrl = "jdbc:sqlite:nozama.db";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(dbUrl);
  }
}
