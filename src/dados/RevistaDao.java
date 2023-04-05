package dados;

import entidades.Revista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class RevistaDao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Revista> listaRevista = new ArrayList<>();

    //Inserir revista na bd
    public void inserirRevista(Revista revista) {

        String sql1 = "insert into tbitem(titulo_item, data_publicacao) values(?, ?)";
        String sql2 = "insert into tbrevista(fk_item, numero_edicoes) values(?, ?)";
        conn = new Conexao().conectaBD();

        try {

            //Insere item
            pstm = conn.prepareStatement(sql1);
            pstm.setString(1, revista.getTitulo());
            pstm.setString(2, revista.getData());

            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1); //último id
                revista.setIdItem(id);
            }
            //Insere livro
            pstm = conn.prepareStatement(sql2);
            pstm.setInt(1, revista.getIdItem());
            pstm.setInt(2, revista.getNumeroDeEdicoes());

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir revistaAO: " + erro.getMessage());
        }
    }

    //Listar revista da bd
    public ArrayList<Revista> listarRevista() {

        String sql = "select id_item, titulo_item, data_publicacao, numero_edicoes from tbitem, tbrevista where fk_item = id_item";
        conn = new Conexao().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Revista revista = new Revista();
                revista.setIdItem(rs.getInt("id_item"));
                revista.setTitulo(rs.getString("titulo_item"));
                revista.setData(rs.getString("data_publicacao"));
                revista.setNumeroDeEdicoes(rs.getInt("numero_edicoes"));
                listaRevista.add(revista);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar revistaDAO: " + erro.getMessage());
        }
        return listaRevista;
    }

    //alterar revista na bd
    public void alterarRevista(Revista revista) {
        String sql = "update tbrevista set numero_edicoes = ? where fk_item = ?";
        conn = new Conexao().conectaBD();

        try {
            //Atualiza em revista
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, revista.getNumeroDeEdicoes());
            pstm.setInt(2, revista.getIdItem());
            
            pstm.execute();
            
            //Atualiza em item
            sql = "update tbitem set titulo_item = ?, data_publicacao = ? where id_item = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, revista.getTitulo());
            pstm.setString(2, revista.getData());
            pstm.setInt(3, revista.getIdItem());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar revistaDAO: " + erro.getMessage());
        }
    }

    //excluir revista na bd
    public void excluirRevista(Revista revista) {
        String sql = "delete from tbitem where id_item = ?";
        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, revista.getIdItem());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao eliminar revistaDAO: " + erro.getMessage());
        }
    }
}
