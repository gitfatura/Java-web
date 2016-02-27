package br.com.dao;

import br.com.entity.*;
import br.com.interfaces.AssinaturaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao implements AssinaturaProduto {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conexao;

	@Override
	public void save(Produto produto) throws Exception {
		try {
			conexao = Conexao.OpenConnection();
			String sql = "INSERT INTO produto(descricao,"
					+ " quantidade,"
					+ " valor,"
					+ " data)"
					+ "VALUES(?, ?, ?, ?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());
			ps.setInt(2, produto.getQuantidade());
			ps.setDouble(3, produto.getValor());
			ps.setString(4, produto.getData());
			ps.executeUpdate();
			conexao.commit();
		} catch (Exception e) {
			
			System.out.println("Erro ao salvar o produto" + e.getMessage());
			
		} finally {
			 
			Conexao.CloseConnection(conexao);
			 
		}

	}

	@Override
	public void update(Produto produto) throws Exception {
		try {
			conexao = Conexao.OpenConnection();
			String sql = "UPDATE  produto SET" 
					+ " descricao=?,"
					+ " quantidade=?,"
					+ " valor=?,"
					+ " data=?"
					+ " WHERE id =?";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());
			ps.setInt(2, produto.getQuantidade());
			ps.setDouble(3, produto.getValor());
			ps.setString(4, produto.getData());
			ps.setLong(5, produto.getId());
			ps.executeUpdate();
			conexao.commit();
		} catch (Exception e) {
			
			System.out.println("Erro ao atualizar o produto: "+ "\n"+ e.getMessage() + "\n");
			 
		} finally {
			 
			Conexao.CloseConnection(conexao);
		}

	}
	
	public void inputProduto(Produto produto)throws Exception{
		try{
			
			conexao = Conexao.OpenConnection();
			String sql = "UPDATE produto SET quantidade = quantidade + ? WHERE id = ?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, produto.getQuantidade());
			ps.setLong(2, produto.getId());
			ps.executeUpdate();
			conexao.commit();
			
		}catch(Exception e){			
			System.out.println("Erro ao dar entrada de produto: "+ "\n"+ e.getMessage() + "\n");
		}finally{
			
			Conexao.CloseConnection(conexao);
			
		}
		
	}
	
	
	public void decreaseProduto(Produto produto)throws Exception{
		try{
			
			conexao = Conexao.OpenConnection();
			String sql = "UPDATE produto SET quantidade = quantidade - ? WHERE id = ?";
			ps = conexao.prepareStatement(sql);
			ps.setInt(1, produto.getQuantidade());
			ps.setLong(2, produto.getId());
			ps.executeUpdate();
			conexao.commit();
			
		}catch(Exception e){
			
			System.out.println("Erro ao dar baixa do produto:"+ "\n"+ e.getMessage() + "\n");
			
		}finally{
			
			Conexao.CloseConnection(conexao); 
			
		}
		
	}

	
	@Override
	public void remove(Produto produto) throws Exception {
		try {
			conexao = Conexao.OpenConnection();
			String sql = "DELETE FROM produto WHERE id=?";
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, produto.getId());
			ps.executeUpdate();
			conexao.commit();
		} catch (Exception e) {
			System.out.println("Erro ao deletar o produto: "+ "\n"+ e.getMessage() + "\n");
			 
		} finally {
			 
			Conexao.CloseConnection(conexao);
		}

	}

	@Override
	public Produto getId(int id) throws Exception {
		Produto produto = null;
		try {
			conexao = Conexao.OpenConnection();
			String sql = "SELECT * FROM produto WHERE id =?";
			ps = conexao.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				produto.setData(rs.getString("data"));
			}

		} catch (Exception e) {
			
			System.out.println("Erro ao pesquisa produto, com o codigo o produto: "+ "\n"+ e.getMessage() + "\n");
			 
		} finally {
			Conexao.CloseConnection(conexao);
		}
		return produto;
	}

	@Override
	public List<Produto> getProduto(String item) throws Exception {
		List<Produto> lista = new ArrayList<>();
		try {
			conexao = Conexao.OpenConnection();
			String sql = "SELECT * FROM produto WHERE UPPER(descricao)LIKE UPPER(?)";
			ps = conexao.prepareStatement(sql);
			ps.setString(1, "%" + item + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				produto.setData(rs.getString("data"));
				lista.add(produto);
			}

		} catch (Exception e) {
			
			System.out.println("Erro ao pesquisa lista produto, com descricao do produto: "+ "\n"+ e.getMessage() + "\n");
			 
		} finally {
			 
			Conexao.CloseConnection(conexao);
			 
		}
		return lista;
	}

	@Override
	public List<Produto> getAll() throws Exception {
		List<Produto> lista = new ArrayList<>();
		try {
			conexao = Conexao.OpenConnection();
			String sql = "SELECT * FROM produto";
			ps = conexao.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValor(rs.getDouble("valor"));
				produto.setData(rs.getString("data"));
				lista.add(produto);
			}

		} catch (Exception e) {
			
			System.out.println("Erro ao pesquisa lista produto, com descricao do produto "+ "\n"+ e.getMessage() + "\n");
			 
		} finally {
		
			Conexao.CloseConnection(conexao);
			
		}
		return lista;
	}
	
}
