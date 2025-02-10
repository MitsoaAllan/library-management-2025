package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final String dbname = "library_managment";
    private final String username = "mitsoa";
    private final String password = "0346170000";
    private final String host = "localhost";
    private final int port = 5432;
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
