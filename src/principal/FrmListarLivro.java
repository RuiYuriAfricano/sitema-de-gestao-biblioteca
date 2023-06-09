package principal;

import dados.LivroDao;
import entidades.Livro;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmListarLivro extends javax.swing.JFrame {

    /**
     * Creates new form ListarLivro
     */
    int idLivroSelecioando = -1;
    String txtGlobal;

    public FrmListarLivro(String txt) {
        initComponents();
        listarLivro();
        this.setLocationRelativeTo(null); // centraliza o JFrame
        this.setResizable(false); // torna o JFrame não redimensionável
        txtGlobal = txt;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQtdPagina = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listar livro");

        tabelaLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Título", "Data publicação", "Nº de Páginas"
            }
        ));
        tabelaLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaLivro);

        jLabel1.setText("Listar Livro");

        jLabel3.setText("Quantidade de Pagina");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("Titulo");

        jLabel4.setText("Data");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(204, 204, 204))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnExcluir)
                                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(56, 56, 56)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnEditar)
                                    .addGap(171, 171, 171)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(txtQtdPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(txtQtdPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnVoltar)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editarLivro();
        this.listarLivro();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.excluirLivro();
        this.limpaCampos();
        this.listarLivro();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLivroMouseClicked
        carregarCampos();
    }//GEN-LAST:event_tabelaLivroMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        FrmMenuSecretario frmSec = new FrmMenuSecretario(txtGlobal);
        frmSec.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmListarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListarLivro("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLivro;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtQtdPagina;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

    private void listarLivro() {
        try {
            LivroDao livrodao = new LivroDao();

            DefaultTableModel model = (DefaultTableModel) tabelaLivro.getModel();
            model.setNumRows(0);

            ArrayList<Livro> lista = livrodao.listarLivro();

            for (int num = 0; num < lista.size(); num++) {
                model.addRow(new Object[]{
                    lista.get(num).getIdItem(),
                    lista.get(num).getTitulo(),
                    lista.get(num).getData(),
                    lista.get(num).getNumeroDePaginas()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro ao listar livro" + e);
        }
    }

    private void carregarCampos() {
        int setar = tabelaLivro.getSelectedRow();

        idLivroSelecioando = Integer.parseInt((tabelaLivro.getModel().getValueAt(setar, 0)).toString());
        txtTitulo.setText((tabelaLivro.getModel().getValueAt(setar, 1)).toString());
        txtData.setText((tabelaLivro.getModel().getValueAt(setar, 2)).toString());
        txtQtdPagina.setText((tabelaLivro.getModel().getValueAt(setar, 3)).toString());
    }

    private void editarLivro() {
        if (txtTitulo.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Atenção: o campo título é obrigatório!");
            return;
        }

        if (txtData.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Atenção: o campo data é obrigatório!");
            return;
        }

        if (txtQtdPagina.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Atenção: o campo quantidade de páginas é obrigatório!");
            return;
        }

        try {
            String titulo, data;
            int qtdPaginas;
            titulo = txtTitulo.getText();
            data = txtData.getText();
            qtdPaginas = Integer.parseInt(txtQtdPagina.getText());

            Livro livro = new Livro(titulo, data, qtdPaginas);
            livro.setIdItem(idLivroSelecioando);

            LivroDao livroDao = new LivroDao();
            livroDao.alterarLivro(livro);
            //Mensagem
            JOptionPane.showMessageDialog(null, "Livro editado com sucesso");

            this.limpaCampos();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no editar frmListarlivro: " + erro);
        }
    }

    private void excluirLivro() {
        try {
            String titulo, data;
            int qtdPaginas;
            titulo = txtTitulo.getText();
            data = txtData.getText();
            qtdPaginas = Integer.parseInt(txtQtdPagina.getText());

            Livro livro = new Livro(titulo, data, qtdPaginas);
            livro.setIdItem(idLivroSelecioando);

            LivroDao livroDao = new LivroDao();
            livroDao.excluirLivro(livro);
            //Mensagem
            JOptionPane.showMessageDialog(null, "Livro excluído com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no excluir frmListarlivro: " + erro);
        }
    }

    private void limpaCampos() {
        txtTitulo.setText("");
        txtData.setText("");
        txtQtdPagina.setText("");
    }
}
