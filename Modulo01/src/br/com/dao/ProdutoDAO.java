package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.entity.Produto;
import br.com.interfaces.IEProduto;

public class ProdutoDAO implements IEProduto {

    PreparedStatement ps;
    ResultSet rs;
    Connection conexao;

    
    @Override
    public void save(Produto produto) throws Exception {
        try {
            conexao = Conexao.OpenConection();
            String sql = "INSERT INTO produto(descricao,"            
                    + " quantidade,"
                    + " preco, total,"
                    + " data)"
                    + "VALUES(?, ?, ?, ?, ?)";
            ps = conexao.prepareStatement(sql);
            
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getQuantidade());
            ps.setDouble(3, produto.getPreco());
            ps.setDouble(4, produto.getTotal());
            ps.setString(5, produto.getData());            
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao salvar o produto :" + e.getMessage());
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } finally {
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexao fechada com sucesso");
            }
        }

    }

    
    
    
    
    
    @Override
    public void update(Produto produto) throws Exception {
        try {
            conexao = Conexao.OpenConection();
            String sql = "UPDATE  produto SET"
                    + " descricao=?,"
            		+ " quantidade=?,"
            		+ " preco=?,"
                    + " total=?,"
                    + " data=?"
                    + " WHERE id=?";

            ps = conexao.prepareStatement(sql);
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getQuantidade());
            ps.setDouble(3, produto.getPreco());
            ps.setDouble(4, produto.getTotal());
            ps.setString(5, produto.getData());
            ps.setInt(6, produto.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar o produto na classe dao :" + e.getMessage());
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } finally {
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexao fechada com sucesso");
            }
        }

    }

    @Override
    public void delete(Produto produto) throws Exception {
        try {
            conexao = Conexao.OpenConection();
            String sql = "DELETE FROM produto WHERE id=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, produto.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao deletar o produto:" + e.getMessage());
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } finally {
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexao fechada com sucesso");
            }
        }

    }

    @Override
    public Produto getId(int id) throws Exception {
        Produto produto = null;
        try {
            conexao = Conexao.OpenConection();
            String sql = "SELECT * FROM produto WHERE id =?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTotal(rs.getDouble("total"));
                produto.setData(rs.getString("data"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao pesquisa produto, com o codigo o produto." + e.getMessage());   
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } finally {
            if (!conexao.isClosed() || conexao != null) {
                conexao.close();
                ps.close();
                rs.close();
            }
        }
        return produto;

    }

    @Override
    public List<Produto> getProduto(String item) throws Exception {
        List<Produto> lista = new ArrayList<>();
        try {
            conexao = Conexao.OpenConection();
            String sql = "SELECT * FROM produto WHERE UPPER(descricao)LIKE UPPER(?)";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + item + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTotal(rs.getDouble("total"));
                produto.setData(rs.getString("data"));
                lista.add(produto);
            }

        } catch (Exception e) {
            System.out.println("Erro ao pesquisa lista produto, com descricao do produto." + e.getMessage());
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } finally {
            if (!conexao.isClosed() || conexao != null) {
                conexao.close();
                ps.close();
                rs.close();
            }
        }
        return lista;
    }

    @Override
    public List<Produto> getAll() throws Exception {
        List<Produto> lista = new ArrayList<>();
        try {
            conexao = Conexao.OpenConection();
            String sql = "SELECT * FROM produto ORDER BY descricao";
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTotal(rs.getDouble("total"));
                produto.setData(rs.getString("data"));
                lista.add(produto);
               
            }
            

        } catch (Exception e) {
            System.out.println("Erro ao pesquisa lista produto, com descricao do produto." + e.getMessage());
            if (!conexao.isClosed()) {
                conexao.close();
            }
        } finally {
            if (!conexao.isClosed() || conexao != null) {
                conexao.close();
                ps.close();
                rs.close();
            }
        }
         
        return lista;
    }

	 
}
