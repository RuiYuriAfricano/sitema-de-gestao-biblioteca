package principal;

import dados.AutorDAO;
import dados.ItemAutorDao;
import dados.ItemEmprestadoDao;
import dados.LivroDao;
import dados.UsuarioDAO;
import entidades.Autor;
import entidades.ItemAutor;
import entidades.ItemEmprestado;
import entidades.Livro;
import entidades.Usuario;
import enums.EnumUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmListarItensEmprestadosMenuEstudante extends javax.swing.JFrame {

    /**
     * Creates new form ListarLivro
     */
    int idUsuarioSelecionado = -1;
    int idItemSelecionado = -1;
    String txtGlobal;
    int idUser;

    public FrmListarItensEmprestadosMenuEstudante(String txt) {
        initComponents();
        listarItemEmprestado();
        this.setLocationRelativeTo(null); // centraliza o JFrame
        this.setResizable(false); // torna o JFrame não redimensionável
        txtGlobal = txt;
        txtusuario.setEnabled(false);
        txtItem.setEnabled(false);
        idUser = !pegaNumInStr2(txtGlobal).equals("")? Integer.parseInt(pegaNumInStr2(txtGlobal)): -1;
        
        
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
        tabelaItensEmprestadosMenuEstudante = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtItem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listar itens emprestados");

        tabelaItensEmprestadosMenuEstudante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IdItem", "Titulo", "IdUsuário", "Nome usuário", "Sobrenome usuário", "Data de empréstimo", "Data de devolução"
            }
        ));
        tabelaItensEmprestadosMenuEstudante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaItensEmprestadosMenuEstudanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaItensEmprestadosMenuEstudante);

        jLabel1.setText("Itens que se encontram emprestados por mim");

        btnExcluir.setText("Devolver");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel5.setText("Usuário");

        jLabel2.setText("Item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnExcluir)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.excluirItemEmprestado();
        this.limpaCampos();
        this.listarItemEmprestado();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaItensEmprestadosMenuEstudanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaItensEmprestadosMenuEstudanteMouseClicked
        carregarCampos();
    }//GEN-LAST:event_tabelaItensEmprestadosMenuEstudanteMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        FrmMenuEstudante frmSec = new FrmMenuEstudante(txtGlobal);
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
            java.util.logging.Logger.getLogger(FrmListarItensEmprestadosMenuEstudante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListarItensEmprestadosMenuEstudante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListarItensEmprestadosMenuEstudante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListarItensEmprestadosMenuEstudante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListarItensEmprestadosMenuEstudante("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaItensEmprestadosMenuEstudante;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

    private void listarItemEmprestado() {
        
        try {
            ItemEmprestadoDao itemEmpdao = new ItemEmprestadoDao();

            DefaultTableModel model = (DefaultTableModel) tabelaItensEmprestadosMenuEstudante.getModel();
            model.setNumRows(0);
            
            
            Usuario user = new Usuario();
            user.setIdUsuario(23);
            ArrayList<ItemEmprestado> lista = itemEmpdao.listarItensEmprestadoPorUsuario(user);

            for (int num = 0; num < lista.size(); num++) {
                model.addRow(new Object[]{
                    lista.get(num).getItem().getIdItem(),
                    lista.get(num).getItem().getTitulo(),
                    lista.get(num).getUsuario().getIdUsuario(),
                    lista.get(num).getUsuario().getNome(),
                    lista.get(num).getUsuario().getSobrenome(),
                    lista.get(num).getDataEmprestimo(),
                    lista.get(num).getDataDevolucao()
                    
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro ao listar ItensEmprestados" + e);
        }
    }

    private void carregarCampos() {
        int setar = tabelaItensEmprestadosMenuEstudante.getSelectedRow();

        idItemSelecionado = Integer.parseInt((tabelaItensEmprestadosMenuEstudante.getModel().getValueAt(setar, 0)).toString());
        txtItem.setText((tabelaItensEmprestadosMenuEstudante.getModel().getValueAt(setar, 1)).toString());
        idUsuarioSelecionado = Integer.parseInt((tabelaItensEmprestadosMenuEstudante.getModel().getValueAt(setar, 2)).toString());

        txtusuario.setText((tabelaItensEmprestadosMenuEstudante.getModel().getValueAt(setar, 3)).toString() + " " + (tabelaItensEmprestadosMenuEstudante.getModel().getValueAt(setar, 4)).toString());

    }

    private void excluirItemEmprestado() {
        try {

            ItemEmprestado itemEmp = new ItemEmprestado();
            itemEmp.setUsuario(new Usuario());
            itemEmp.setItem(new Livro());
            itemEmp.getUsuario().setIdUsuario(idUsuarioSelecionado);
            itemEmp.getItem().setIdItem(idItemSelecionado);

            ItemEmprestadoDao itemEmpdao = new ItemEmprestadoDao();
            itemEmpdao.devolverItem(itemEmp);
            //Mensagem
            JOptionPane.showMessageDialog(null, "Empréstimo excluído com sucesso");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no excluir frmListarItensEmprestado: " + erro);
        }
    }

    private void limpaCampos() {
        txtusuario.setText("");
        txtItem.setText("");
    }
    private String pegaNumInStr2(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                res += Character.toString(str.charAt(i));
            }
        }
        return res;
    }
}
