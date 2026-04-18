package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/Finexa";
    private static final String USER = "root";
    private static final String PASSWORD = "abcd1234";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
            return null;
        }
    }
    
}
