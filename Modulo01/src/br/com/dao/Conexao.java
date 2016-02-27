package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao;
    public static Connection OpenConection()throws Exception{
        try {
            if (conexao == null || conexao.isClosed()) {
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja", "postgres", "sysdba");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro na conexão : "+e.getMessage());
            if (conexao !=null) {
                conexao.close();
            }
        }
        return  conexao;
    }
}
