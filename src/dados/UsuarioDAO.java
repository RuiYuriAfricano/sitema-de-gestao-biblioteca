/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import entidades.Usuario;
import enums.EnumUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Total Energies
 */
public class UsuarioDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    //Inserir usuario na bd
    public void inserirUsuario(Usuario user){
        String sql = "insert into tbusuario(nome_usuario, sobrenome_usuario, username, senha, tipo_usuario) values(?, ?, ?, ?, ?)";
        conn = new Conexao().conectaBD();
        
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getSenha());
            pstm.setString(3, user.getUsername());
            pstm.setString(4, user.getSenha());
            
            if(user.getTipo() == EnumUsuario.TipoUsuario.estudante)
                pstm.setString(5, "estudante");
            else
                pstm.setString(5, "bibliotecario");
            
            pstm.execute();
            pstm                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           .close();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuarioDAO: "+ erro.getMessage());
        }
    }
    
    //Listar Usuário da bd
    public ArrayList<Usuario> ListarUsuario(){
        
        String sql = "select * from tbusuario";
        conn = new Conexao().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Usuario user = new Usuario();
                user.setNome(rs.getString("nome_usuario"));
                user.setSobrenome(rs.getString("sobrenome_usuario"));
                user.setUsername(rs.getString("username"));
                user.setSenha(rs.getString("senha"));
                if(rs.getString("tipo_usuario").equalsIgnoreCase("estudante"))
                    user.setTipo(EnumUsuario.TipoUsuario.estudante);
                else
                    user.setTipo(EnumUsuario.TipoUsuario.bibliotecario);
                listaUsuarios.add(user);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuarioDAO: "+ erro.getMessage());
        }
        return listaUsuarios;
    }

}
