package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final String dbname = System.getenv("DB_NAME");
    private final String username = System.getenv("USERNAME");
    private final String password = System.getenv("PASSWORD");
    private final String host = System.getenv("HOST");
    private final int port = Integer.parseInt(System.getenv("PORT"));
    private final String url;

    public DbConnection(){
        url = "jdbc:postgresql://"+host+":"+port+"/"+dbname;
    }
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
