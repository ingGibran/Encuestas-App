package com.mycompany.encuestas_app;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alexpy
 */
public class DatabaseConnection {
   private String host;
    private int port;
    private String dbName;
    private String dbUser;
    private String dbPassword;

    public DatabaseConnection() {
        host = "localhost";
        port = 3306;
        dbName = "encuestas_app";
        dbUser = "root";
        dbPassword = "123";
    }

    public DatabaseConnection(String host, int port, String dbName, String dbUser, String dbPassword) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }
    
    public Connection open() throws Exception {
        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://"+host+":"+port+"/" + dbName,
            dbUser, dbPassword
        );
        return connection;
    }
    
    public void close(Connection connection) throws Exception {
        connection.close();
    }

}
