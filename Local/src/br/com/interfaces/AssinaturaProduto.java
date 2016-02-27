package br.com.interfaces;
import br.com.entity.*;
import java.util.List;
public interface AssinaturaProduto {
    
    public void save(Produto produto)throws  Exception;
    public void update(Produto produto)throws  Exception;
    public void remove(Produto produto)throws  Exception;
    public Produto getId(int id)throws  Exception;
    public List<Produto> getProduto(String item)throws  Exception;
    public List<Produto> getAll()throws  Exception;
     
}
