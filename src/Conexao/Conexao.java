package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexao {

    private static Connection conn = null;
    private static final String user = "root";
    private static final String password = "12345678";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/bancos";
    
    

    public static Connection getDatabaseConnection() throws Exception{
        Class.forName(DRIVER);
        return conn = DriverManager.getConnection(url, user, password);
        
    }

   
}