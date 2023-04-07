package dados;

import entidades.Autor;
import entidades.Usuario;
import enums.EnumUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class AutorDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Autor> listaAutores = new ArrayList<>();
    
    //Inserir autor na bd
    public void inserirAutor(Autor autor){
        String sql = "insert into tbautor(nome_autor, sobrenome_autor) values(?, ?)";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, autor.getNome());
            pstm.setString(2, autor.getSobrenome());
            
            pstm.execute();
            pstm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           .close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao inserir autorDAO: "+ erro.getMessage());
        }
    }
    
    //Listar autor da bd
    public ArrayList<Autor> listarAutor(){
        
        String sql = "select * from tbautor";
        conn = new Conexao().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Autor autor = new Autor();
                autor.setIdAutor(rs.getInt("id_autor"));
                autor.setNome(rs.getString("nome_autor"));
                autor.setSobrenome(rs.getString("sobrenome_autor"));
                listaAutores.add(autor);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar autorDAO: "+ erro.getMessage());
        }
        return listaAutores;
    }
    
    //alterar autor na bd
    public void alterarAutor(Autor autor){
        String sql = "update tbautor set nome_autor = ?, sobrenome_autor = ? where id_autor = ?";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, autor.getNome());
            pstm.setString(2, autor.getSobrenome());
            
            pstm.setInt(3, autor.getIdAutor());
            pstm.execute();
            pstm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           .close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao alterar autorDAO: "+ erro.getMessage());
        }
    }
    
    //excluir autor na bd
    public void excluirAutor(Autor autor){
        String sql = "delete from tbautor where id_autor = ?";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            
            
            pstm.setInt(1, autor.getIdAutor());
            pstm.execute();
            pstm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           .close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao eliminar autorDAO: "+ erro.getMessage());
        }
    }
}
