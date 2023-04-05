package dados;

import entidades.Autor;
import entidades.Item;
import entidades.ItemAutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ItemAutorDao {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ItemAutor> listaItemAutores = new ArrayList<>();
    
    //Inserir itemautor na bd
    public void inserirItemAutor(ItemAutor itemAutor){
        String sql = "insert into tb_item_autor(fk_item, fk_autor) values(?, ?)";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, itemAutor.getItem().getIdItem());
            pstm.setInt(2, itemAutor.getAutor().getIdAutor());
            
            pstm.execute();
            pstm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           .close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao inserir itemautorDAO: "+ erro.getMessage());
        }
    }
    
    //Listar itemautor da bd
    public ArrayList<ItemAutor> listarItemAutor(){
        
        String sql = "select id_item, titulo_item, id_autor, nome_autor, sobrenome_autor from tb_item_autor, tbitem, tbautor where fk_item = id_item and fk_autor = id_autor";
        conn = new Conexao().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                ItemAutor itemAutor = new ItemAutor();
                
                itemAutor.getItem().setTitulo(rs.getString("titulo_item"));
                itemAutor.getItem().setIdItem(rs.getInt("id_item"));
                
                itemAutor.getAutor().setIdAutor(rs.getInt("id_autor"));
                itemAutor.getAutor().setNome(rs.getString("nome_autor"));
                itemAutor.getAutor().setSobrenome(rs.getString("sobrenome_autor"));
                
                listaItemAutores.add(itemAutor);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar itemautorDAO: "+ erro.getMessage());
        }
        return listaItemAutores;
    }
    
    //excluir itemautor na bd
    public void excluirItemAutor(ItemAutor itemAutor){
        String sql = "delete from tb_item_autor where fk_item = ? and fk_autor = ?";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, itemAutor.getItem().getIdItem());
            pstm.setInt(2, itemAutor.getAutor().getIdAutor());
            pstm.execute();
            pstm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           .close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao eliminar itemautorDAO: "+ erro.getMessage());
        }
    }
}
