package dados;

import entidades.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class LivroDao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Livro> listaLivros = new ArrayList<>();

    //Inserir livro na bd
    public void inserirLivro(Livro livro) {

        String sql1 = "insert into tbitem(titulo_item, data_publicacao) values(?, ?)";
        String sql2 = "insert into tblivro(fk_item, numero_paginas) values(?, ?)";
        conn = new Conexao().conectaBD();

        try {

            //Insere item
            pstm = conn.prepareStatement(sql1);
            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getData());

            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1); //último id
                livro.setIdItem(id);
            }
            //Insere livro
            pstm = conn.prepareStatement(sql2);
            pstm.setInt(1, livro.getIdItem());
            pstm.setInt(2, livro.getNumeroDePaginas());

            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir livroAO: " + erro.getMessage());
        }
    }

    //Listar livro da bd
    public ArrayList<Livro> listarLivro() {

        String sql = "select id_item, titulo_item, data_publicacao, numero_paginas from tbitem, tblivro where fk_item = id_item";
        conn = new Conexao().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setIdItem(rs.getInt("id_item"));
                livro.setTitulo(rs.getString("titulo_item"));
                livro.setData(rs.getString("data_publicacao"));
                livro.setNumeroDePaginas(rs.getInt("numero_paginas"));
                listaLivros.add(livro);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar livroDAO: " + erro.getMessage());
        }
        return listaLivros;
    }

    //alterar livro na bd
    public void alterarLivro(Livro livro) {
        String sql = "update tblivro set numero_paginas = ? where fk_item = ?";
        conn = new Conexao().conectaBD();

        try {
            //Atualiza em livro
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, livro.getNumeroDePaginas());
            pstm.setInt(2, livro.getIdItem());
            
            pstm.execute();
            
            //Atualiza em item
            sql = "update tbitem set titulo_item = ?, data_publicacao = ? where id_item = ?";
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getData());
            pstm.setInt(3, livro.getIdItem());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar livroDAO: " + erro.getMessage());
        }
    }

    //excluir livro na bd
    public void excluirLivro(Livro livro) {
        String sql = "delete from tbitem where id_item = ?";
        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, livro.getIdItem());
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao eliminar livroDAO: " + erro.getMessage());
        }
    }
}
