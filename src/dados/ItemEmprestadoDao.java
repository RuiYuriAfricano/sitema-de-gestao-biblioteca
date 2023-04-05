package dados;

import entidades.Autor;
import entidades.ItemAutor;
import entidades.ItemEmprestado;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ItemEmprestadoDao {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ItemEmprestado> listaItemEmprestados = new ArrayList<>();
    
    //Inserir itememprestado na bd
    public void emprestarItem(ItemEmprestado itemEmprestado){
        String sql = "insert into tb_item_emprestado(fk_item, fk_usuario, data_emprestimo, data_devolucao) values(?, ?, ?, ?)";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, itemEmprestado.getItem().getIdItem());
            pstm.setInt(2, itemEmprestado.getUsuario().getIdUsuario());
            pstm.setString(3, itemEmprestado.getDataEmprestimo());
            pstm.setString(4, itemEmprestado.getDataDevolucao());
            
            pstm.execute();
            pstm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           .close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao inserir itememprestadoDAO: "+ erro.getMessage());
        }
    }
    
    //Listar todos itemEMprestado da bd
    public ArrayList<ItemEmprestado> listarTodosItemEmprestado(){
        
        String sql = "select id_item, titulo_item, id_usuario, nome_usuario, sobrenome_usuario, data_emprestimo, data_devolucao  from tbitem, tbusuario, tb_item_emprestado where fk_item = id_item and fk_usuario = id_usuario";
        conn = new Conexao().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                ItemEmprestado itemEmprestado = new ItemEmprestado();
                
                itemEmprestado.getItem().setTitulo(rs.getString("titulo_item"));
                itemEmprestado.getItem().setIdItem(rs.getInt("id_item"));
                
                itemEmprestado.getUsuario().setIdUsuario(rs.getInt("id_usuario"));
                itemEmprestado.getUsuario().setNome(rs.getString("nome_usuario"));
                itemEmprestado.getUsuario().setSobrenome(rs.getString("sobrenome_usuario"));
                itemEmprestado.setDataEmprestimo(rs.getString("data_emprestimo"));
                itemEmprestado.setDataDevolucao(rs.getString("data_devolucao"));
                
                listaItemEmprestados.add(itemEmprestado);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar listaTodosItemEmprestadoDAO: "+ erro.getMessage());
        }
        return listaItemEmprestados;
    }
    
    //Listar itemEMprestado por usuario
    public ArrayList<ItemEmprestado> listarItensEmprestadoPorUsuario(Usuario user){
        
        String sql = "select id_item, titulo_item, id_usuario, nome_usuario, sobrenome_usuario, data_emprestimo, data_devolucao  from tbitem, tbusuario, tb_item_emprestado where fk_item = id_item and fk_usuario = id_usuario and fk_usuario = ?";
        conn = new Conexao().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, user.getIdUsuario());
            rs = pstm.executeQuery();
            
            while(rs.next()){
                ItemEmprestado itemEmprestado = new ItemEmprestado();
                
                itemEmprestado.getItem().setTitulo(rs.getString("titulo_item"));
                itemEmprestado.getItem().setIdItem(rs.getInt("id_item"));
                
                itemEmprestado.getUsuario().setIdUsuario(rs.getInt("id_usuario"));
                itemEmprestado.getUsuario().setNome(rs.getString("nome_usuario"));
                itemEmprestado.getUsuario().setSobrenome(rs.getString("sobrenome_usuario"));
                itemEmprestado.setDataEmprestimo(rs.getString("data_emprestimo"));
                itemEmprestado.setDataDevolucao(rs.getString("data_devolucao"));
                
                listaItemEmprestados.add(itemEmprestado);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar itensEmprestadoPorUsuarioDAO: "+ erro.getMessage());
        }
        return listaItemEmprestados;
    }
    
    //Listar todos itemEMprestado da bd
    public ArrayList<ItemEmprestado> listarItemNaoEmprestado(){
        
        String sql = "select id_item, titulo_item, data_publicacao  from tbitem, tb_item_emprestado where fk_item != id_item";
        conn = new Conexao().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                ItemEmprestado itemEmprestado = new ItemEmprestado();
                
                itemEmprestado.getItem().setTitulo(rs.getString("titulo_item"));
                itemEmprestado.getItem().setIdItem(rs.getInt("id_item"));
                itemEmprestado.getItem().setData(rs.getString("data_publicacao"));
                
                listaItemEmprestados.add(itemEmprestado);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar itemNaoEmprestadoDAO: "+ erro.getMessage());
        }
        return listaItemEmprestados;
    }
    
    //excluir itememprestado na bd
    public void devolverItem(ItemEmprestado itemEmprestado){
        String sql = "delete from tb_item_emprestado where fk_item = ? and fk_usuario = ?";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, itemEmprestado.getItem().getIdItem());
            pstm.setInt(2, itemEmprestado.getUsuario().getIdUsuario());
            pstm.execute();
            pstm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           .close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao eliminar itemEmprestadoDAO: "+ erro.getMessage());
        }
    }
}
