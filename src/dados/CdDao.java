package dados;

import entidades.Cd;
import entidades.Revista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CdDao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Cd> listaCds = new ArrayList<>();

    //Inserir cd na bd
    public void inserirCd(Cd cd) {

        String sql1 = "insert into tbitem(titulo_item, data_publicacao) values(?, ?)";
        String sql2 = "insert into tbcd(fk_item, tempo_reproducao) values(?, ?)";
        conn = new Conexao().conectaBD();

        try {

            //Insere item
            pstm = conn.prepareStatement(sql1);
            pstm.setString(1, cd.getTitulo());
            pstm.setString(2, cd.getData());

            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1); //último id
                cd.setIdItem(id);
            }
            //Insere livro
            pstm = conn.prepareStatement(sql2);
            pstm.setInt(1, cd.getIdItem());
            pstm.setInt(2, cd.getTempoDeReproducao());

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cdAO: " + erro.getMessage());
        }
    }

    //Listar cd da bd
    public ArrayList<Cd> listarCd() {

        String sql = "select id_item, titulo_item, data_publicacao, tempo_reproducao from tbitem, tbcd where fk_item = id_item";
        conn = new Conexao().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Cd cd = new Cd();
                cd.setIdItem(rs.getInt("id_item"));
                cd.setTitulo(rs.getString("titulo_item"));
                cd.setData(rs.getString("data_publicacao"));
                cd.setTempoDeReproducao(rs.getInt("tempo_reproducao"));
                listaCds.add(cd);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar cdDAO: " + erro.getMessage());
        }
        return listaCds;
    }

    //alterar cd na bd
    public void alterarCd(Cd cd) {
        String sql = "update tbcd set tempo_reproducao = ? where fk_item = ?";
        conn = new Conexao().conectaBD();

        try {
            //Atualiza em cd
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, cd.getTempoDeReproducao());
            pstm.setInt(2, cd.getIdItem());
            
            pstm.execute();
            
            //Atualiza em item
            sql = "update tbitem set titulo_item = ?, data_publicacao = ? where id_item = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, cd.getTitulo());
            pstm.setString(2, cd.getData());
            pstm.setInt(3, cd.getIdItem());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cdDAO: " + erro.getMessage());
        }
    }

    //excluir cd na bd
    public void excluirCd(Cd cd) {
        String sql = "delete from tbcd where id_item = ?";
        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, cd.getIdItem());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao eliminar cdDAO: " + erro.getMessage());
        }
    }
}
