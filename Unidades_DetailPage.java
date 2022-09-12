package Configurações;



import Templates.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utilizador
 */
public class Unidades_DetailPage extends javax.swing.JFrame {

    int index;
    
    public Unidades_DetailPage(int input) {
        initComponents();
        index = input; 
        
         try{
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");  
    Statement st = con.createStatement();
    String query_Select = "Select * from UNIDADES where \"UNIDADE_ID\" = "+index;
    ResultSet rs = st.executeQuery(query_Select);
    
    String name = "";
    String descricao = "";
    String codigo = "";


    while (rs.next()){
        if(rs.getString(2).length() >0 ) name = rs.getString(2); else name=" " ;
        codigo = rs.getString(3)+" ";
        if(rs.getString(4).length() >0 ) descricao = rs.getString(4); else descricao=" " ;
        
                }
    
    TextBox1.setText(name.trim());
    Textbox2.setText(codigo.trim());
    Textbox3.setText(descricao.trim());

    st.close();
    con.close();

    }catch(Exception e){e.printStackTrace();}; 
    }

    private Unidades_DetailPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jLabel2 = new javax.swing.JLabel();
        TextBox1 = new javax.swing.JTextField();
        Textbox2 = new javax.swing.JTextField();
        GuardarButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Textbox3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Codigo");

        Textbox2.setToolTipText("Password");
        Textbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Textbox2ActionPerformed(evt);
            }
        });

        GuardarButton.setText("Guardar");
        GuardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancelar");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Descrição");

        Textbox3.setToolTipText("Password");
        Textbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Textbox3ActionPerformed(evt);
            }
        });

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(Textbox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(GuardarButton)
                                .addGap(18, 18, 18)
                                .addComponent(CancelButton)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(37, 37, 37)
                            .addComponent(TextBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Textbox3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Textbox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Textbox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarButton)
                    .addComponent(CancelButton))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Textbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Textbox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Textbox2ActionPerformed

    private void GuardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarButtonActionPerformed
        // TODO add your handling code here:
        String name = TextBox1.getText();
        String codigo = Textbox2.getText();
        String description = Textbox3.getText();
        
        System.out.println("name: "+ name+ "\n"+"codigo: "+codigo+"\n"+"description: "+description);
        

         try{
    Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");  
    Statement st = con.createStatement();
    String query_update = "Update UNIDADES\n" +
                            "set UNIDADES.NOME = '"+name.trim()+"', UNIDADES.CODIGO ='"+codigo.trim()+"', UNIDADES.DESCRICAO = '"+description.trim()+"'\n" +
                            "where UNIDADES.UNIDADE_ID = "+index+" ";
    st.execute(query_update);
    st.close();
    con.close();
     JOptionPane.showMessageDialog(null, "Unidade Alterada");
    }catch(Exception e){e.printStackTrace();
                             JOptionPane.showMessageDialog(null, "Erro durante a criação da Unidade");};
        
    }//GEN-LAST:event_GuardarButtonActionPerformed

    private void Textbox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Textbox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Textbox3ActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        Unidades_List listscreen = new Unidades_List();
        listscreen.show();
        dispose();
        
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {  
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/ScoutsDB_DEV","AdminA","123456");
            Statement st = con.createStatement();
              String query = "Delete from UNIDADES\n" +
                              "where UNIDADES.UNIDADE_ID = "+index;
            st.executeUpdate(query);        
            JOptionPane.showMessageDialog(null, "Unidade eliminada");
            Unidades_List listscreen = new Unidades_List();
            listscreen.show();
            dispose();
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TEquipamento_DetailPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Unidades_DetailPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JTextField TextBox1;
    private javax.swing.JTextField Textbox2;
    private javax.swing.JTextField Textbox3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
