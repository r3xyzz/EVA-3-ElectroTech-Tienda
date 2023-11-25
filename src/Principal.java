/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.Desktop;
import java.net.URI;
/**
 *
 * @author r3xzz
 */
public class Principal extends javax.swing.JFrame {
    AgregarProducto AgregarP = new AgregarProducto();
    ActualizarProducto ActualizarP = new ActualizarProducto();
    EliminarProducto EliminarP = new EliminarProducto();
    /**
     * Creates new form interfaz
     */
    public Principal() {
        initComponents();
        this.add(AgregarP);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        Fondito = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jButtonProyect = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuOPCIONES = new javax.swing.JMenu();
        jMenuItemAGREGAR = new javax.swing.JMenuItem();
        jMenuItemMODIFICAR = new javax.swing.JMenuItem();
        javax.swing.JMenuItem jMenuItemELIMINAR = new javax.swing.JMenuItem();
        jMenuItemLISTAR = new javax.swing.JMenuItem();
        jMenuSALIR = new javax.swing.JMenu();
        jMenuItemSALIR = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonProyect.setText("Proyecto");
        jButtonProyect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProyectActionPerformed(evt);
            }
        });

        Fondito.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Fondito.setLayer(jButtonProyect, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout FonditoLayout = new javax.swing.GroupLayout(Fondito);
        Fondito.setLayout(FonditoLayout);
        FonditoLayout.setHorizontalGroup(
            FonditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FonditoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButtonProyect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addGap(480, 480, 480))
        );
        FonditoLayout.setVerticalGroup(
            FonditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FonditoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonProyect)
                .addGap(43, 43, 43))
        );

        jMenuOPCIONES.setText("Opciones");

        jMenuItemAGREGAR.setText("Agregar Producto");
        jMenuItemAGREGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAGREGARActionPerformed(evt);
            }
        });
        jMenuOPCIONES.add(jMenuItemAGREGAR);

        jMenuItemMODIFICAR.setText("Modificar Producto");
        jMenuItemMODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMODIFICARActionPerformed(evt);
            }
        });
        jMenuOPCIONES.add(jMenuItemMODIFICAR);

        jMenuItemELIMINAR.setText("Eliminar Producto");
        jMenuItemELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemELIMINARActionPerformed(evt);
            }
        });
        jMenuOPCIONES.add(jMenuItemELIMINAR);

        jMenuItemLISTAR.setText("Listar Producto");
        jMenuItemLISTAR.setToolTipText("");
        jMenuItemLISTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLISTARActionPerformed(evt);
            }
        });
        jMenuOPCIONES.add(jMenuItemLISTAR);

        jMenuBar1.add(jMenuOPCIONES);

        jMenuSALIR.setText("Salir");
        jMenuSALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSALIRActionPerformed(evt);
            }
        });

        jMenuItemSALIR.setText("Salir del Programa");
        jMenuItemSALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSALIRActionPerformed(evt);
            }
        });
        jMenuSALIR.add(jMenuItemSALIR);

        jMenuBar1.add(jMenuSALIR);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondito)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondito)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAGREGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAGREGARActionPerformed
        this.AgregarP.show();
        Fondito.add(AgregarP);
        Fondito.show();
    }//GEN-LAST:event_jMenuItemAGREGARActionPerformed

    private void jMenuSALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSALIRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuSALIRActionPerformed

    private void jMenuItemSALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSALIRActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSALIRActionPerformed

    private void jMenuItemELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemELIMINARActionPerformed
        // TODO add your handling code here:
        this.EliminarP.show();
        Fondito.add(EliminarP);
        Fondito.show();
    }//GEN-LAST:event_jMenuItemELIMINARActionPerformed

    private void jMenuItemLISTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLISTARActionPerformed
        // TODO add your handling code here:
        ListarProducto listarProducto = new ListarProducto();
        Fondito.add(listarProducto);
        listarProducto.show();
    }//GEN-LAST:event_jMenuItemLISTARActionPerformed

    private void jMenuItemMODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMODIFICARActionPerformed
        this.ActualizarP.show();
        Fondito.add(ActualizarP);
        Fondito.show();
    }//GEN-LAST:event_jMenuItemMODIFICARActionPerformed

    private void jButtonProyectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProyectActionPerformed
        // TODO add your handling code here:
        try {
        // Abre el enlace en el navegador web predeterminado
        Desktop.getDesktop().browse(new URI("https://github.com/r3xyzz/EVA-3-ElectroTech-Tienda.git"));
    } catch (Exception ex) {
        // Maneja cualquier excepción que pueda ocurrir al abrir el enlace
        ex.printStackTrace();
    }
    }//GEN-LAST:event_jButtonProyectActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Fondito;
    private javax.swing.JButton jButtonProyect;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAGREGAR;
    private javax.swing.JMenuItem jMenuItemLISTAR;
    private javax.swing.JMenuItem jMenuItemMODIFICAR;
    private javax.swing.JMenuItem jMenuItemSALIR;
    private javax.swing.JMenu jMenuOPCIONES;
    private javax.swing.JMenu jMenuSALIR;
    // End of variables declaration//GEN-END:variables
}
