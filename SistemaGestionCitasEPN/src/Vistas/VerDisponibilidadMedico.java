/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daro
 */
public class VerDisponibilidadMedico extends javax.swing.JFrame {

    /**
     * Creates new form VerDisponibilidadMedico
     */
    public VerDisponibilidadMedico() {
        initComponents();
        AgendarTurno agendarT = new AgendarTurno();
        setLocationRelativeTo(null);// centrado
        setResizable(false); // impide maximizar
        setTitle("Disponibilidad Médico");
        txtIdMedico.setVisible(false);
        txtIdMedico.setText(agendarT.textoId);
        txtNombreProfesional.setText(agendarT.nombreProfesional);
        setModeloTabla();
        listarTurnosNoDisponibles();
    }
    
    Conexion miConexion = new Conexion();
    
    
      public void setModeloTabla(){
      
        DefaultTableModel miModeloTabla = new DefaultTableModel();
        miModeloTabla.addColumn("ESPECIALIDAD");
        miModeloTabla.addColumn("FECHA TURNO");
        miModeloTabla.addColumn("HORA TURNO");
        jTableHorariosMedico.setModel(miModeloTabla);
   
    }
      
    public void listarTurnosNoDisponibles(){
        
        String sql="";
        DefaultTableModel miModeloTabla = new DefaultTableModel();
        miModeloTabla.addColumn("ESPECIALIDAD");
        miModeloTabla.addColumn("FECHA TURNO");
        miModeloTabla.addColumn("HORA TURNO");
        
        sql = "SELECT ESPECIALIDADTURNO,FECHATURNO,HORATURNO FROM TURNO WHERE EMPLEADOID = '"+txtIdMedico.getText()+"'"; 
        String datos [] = new String[4];
        
             try {
            Statement st= miConexion.Conectar().createStatement();
            ResultSet rs2=st.executeQuery(sql);
            System.out.println(rs2);
            while(rs2.next()){
                datos[0]=rs2.getString(1);
                datos[1]=rs2.getString(2);
                datos[2]=rs2.getString(3);
 
                miModeloTabla.addRow(datos);         
            }
           
            jTableHorariosMedico.setModel(miModeloTabla);
         
        } catch (SQLException ex) {
            System.out.println("Error busqueda"); 
        }
   
    
    }   
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdMedico = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHorariosMedico = new javax.swing.JTable();
        txtNombreProfesional = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Disponibilidad Profesional");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horarios No Disponibles Profesional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTableHorariosMedico.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTableHorariosMedico.setForeground(new java.awt.Color(255, 51, 51));
        jTableHorariosMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableHorariosMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHorariosMedicoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableHorariosMedico);

        txtNombreProfesional.setEditable(false);
        txtNombreProfesional.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        txtNombreProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProfesionalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombreProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreProfesional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43)
                                .addComponent(txtIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableHorariosMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHorariosMedicoMouseClicked
        /*int fila = jTablePaciente.getSelectedRow();
        if(fila>=0){
            txtCedulaPaciente.setText(jTablePaciente.getValueAt(fila, 0).toString());
            txtPirmerNombrePaciente.setText(jTablePaciente.getValueAt(fila, 1).toString());
            txtSegundoNombrePaciente.setText(jTablePaciente.getValueAt(fila, 2).toString());
            txtPrimerApellidoPaciente.setText(jTablePaciente.getValueAt(fila, 3).toString());
            txtSegundoApellidoPaciente.setText(jTablePaciente.getValueAt(fila, 4).toString());
            txtTelefonoPaciente.setText(jTablePaciente.getValueAt(fila, 5).toString());
            txtEmailPaciente.setText(jTablePaciente.getValueAt(fila, 6).toString());

        }else{
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }*/
    }//GEN-LAST:event_jTableHorariosMedicoMouseClicked

    private void txtNombreProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProfesionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProfesionalActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(VerDisponibilidadMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerDisponibilidadMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerDisponibilidadMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerDisponibilidadMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerDisponibilidadMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableHorariosMedico;
    private javax.swing.JTextField txtIdMedico;
    private javax.swing.JTextField txtNombreProfesional;
    // End of variables declaration//GEN-END:variables
}