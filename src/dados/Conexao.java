/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Total Energies
 */
public class Conexao {
    public Connection conectaBD(){
        Connection conn = null;
        
        try{
            String url = "jdbc:mysql://localhost:3306/dbbibliotecaISPTEC?user=root&password=";
            conn = DriverManager.getConnection(url);
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro em ConexaoDados: "+ erro.getMessage());
        }
        
        return conn;
    }
}
