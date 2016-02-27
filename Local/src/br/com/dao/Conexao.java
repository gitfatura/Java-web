package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static Connection conexao;

	public static Connection OpenConnection()throws Exception {

		try {

			if (conexao == null || conexao.isClosed()) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "system", "sysdba");
				conexao.setAutoCommit(false);
			}

		} catch (Exception e) {

			System.out.println("Erro ao conectar com oracle: "+ "\n"+ e.getMessage() + "\n");
			
		}

		return conexao;
	}

	public static void CloseConnection(Connection conexao) {

		try {
			if (!conexao.isClosed()) {
				conexao.close();			
			}

		} catch (Exception e) {
			
			System.out.println("Erro ao desconectar com oracle: "+"\n" + e.getMessage() + "\n");
			
		}

	}
}
