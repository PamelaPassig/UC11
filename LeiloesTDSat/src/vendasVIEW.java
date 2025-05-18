import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        listarVendidos();
    }
    private void listarVendidos(){
        try {
            ProdutosDAO dao = new ProdutosDAO();
            ArrayList<ProdutosDTO> lista = dao.listarProdutosVendidos();

            DefaultTableModel model = (DefaultTableModel) tabelaVendidos.getModel();
            model.setRowCount(0);

            for (ProdutosDTO p : lista) {
                model.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getValor(),
                    p.getSituacao()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vendidos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendidos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaVendidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tabelaVendidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vendasVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVendidos;
    // End of variables declaration//GEN-END:variables
}
