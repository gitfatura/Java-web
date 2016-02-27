package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.entity.Usuario;

public class UsuarioDao {

	private PreparedStatement ps;
	private Connection conexao;
	private ResultSet rs;

	public Usuario buscaUsuario(String nome, String senha) throws Exception {
		Usuario usuario = null;
		try {
			conexao = Conexao.OpenConnection();
			String sql = "select * from usuario where nome =? and senha  =?";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setUsuario(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
			}
		} catch (Exception e) {

			System.out.println("Erro ao buscar usuario e senha :" + e.getMessage());
		} finally {

			conexao.close();
			ps.close();
			rs.close();

		}
		return usuario;
	}
}
