/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import Database.UserAdapter;
/**
 *
 * @author tzhware7
 */
public class ActiveUserScreen extends javax.swing.JFrame {

    /**
     * Creates new form ActiveUserScreen
     */
    public ActiveUserScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        listActiveUsers = new javax.swing.JList();
        jSeparator3 = new javax.swing.JSeparator();
        lblActiveUsers = new javax.swing.JLabel();
        btExportActiveUsers = new javax.swing.JButton();
        btCloseActiveUsers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listActiveUsers.setModel(new javax.swing.AbstractListModel() {

            UserAdapter mUa = new UserAdapter();
            String[] rowarray = mUa.getAllActiveUsers();

            public int getSize() { return rowarray.length; }
            public Object getElementAt(int i) { return rowarray[i]; }
        });
        jScrollPane1.setViewportView(listActiveUsers);

        UserAdapter mUa = new UserAdapter();
        String[] rowarray = mUa.getAllActiveUsers();
        int i = rowarray.length;

        if(rowarray[0] == "Keine Soldaten in der Anlage"){
            lblActiveUsers.setText("Es sind keine Soldaten in der Anlage");
        } else {
            lblActiveUsers.setText("Es sind noch "+ i +" Soldat(en) in der Anlage");
        }

        btExportActiveUsers.setText("Export");
        btExportActiveUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportActiveUsersActionPerformed(evt);
            }
        });

        btCloseActiveUsers.setText("Close");
        btCloseActiveUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActiveUsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblActiveUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExportActiveUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCloseActiveUsers)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblActiveUsers)
                    .addComponent(btExportActiveUsers)
                    .addComponent(btCloseActiveUsers))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExportActiveUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportActiveUsersActionPerformed
        // Export to txt-file on Desktop
    }//GEN-LAST:event_btExportActiveUsersActionPerformed

    private void btCloseActiveUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActiveUsersActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCloseActiveUsersActionPerformed

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
            java.util.logging.Logger.getLogger(ActiveUserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActiveUserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActiveUserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActiveUserScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActiveUserScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCloseActiveUsers;
    private javax.swing.JButton btExportActiveUsers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblActiveUsers;
    private javax.swing.JList listActiveUsers;
    // End of variables declaration//GEN-END:variables
}
