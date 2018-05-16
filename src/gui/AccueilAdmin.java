/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ClasseDAO;
import dao.ConcoursDao;
import dao.ExerciceDao;
import entities.Classe;
import entities.Concours;
import entities.Exercice;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chris dany
 */
public final class AccueilAdmin extends javax.swing.JFrame {

    // private DefaultTableModel modelTable;
    DefaultTableModel model;
    DefaultTableModel modelTemp;

    public AccueilAdmin() {
        try {
            initComponents();
            setTitle("Admin");
            model = (DefaultTableModel) jTableConcours.getModel();
            loadDatas();
            loadDataCombobox();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDatas() throws SQLException {
        List<Exercice> allExercices = ExerciceDao.allExercices();
        //model.addRow(new Object[]{"a","b","c","d","e"});
        List<Concours> allConcourss = ConcoursDao.allConcourss();
        // DefaultTableModel model = (DefaultTableModel) jTableConcours.getModel();
        System.out.println("allConcourss = " + allConcourss.size());

        for (Concours concours : allConcourss) {
            System.out.println("allConcours = " + concours.getEleve());
            Classe classe = ClasseDAO.getClasseById(concours.getEleve().getIdClasse());
            model.addRow(new Object[]{
                concours.getEleve().getNom(),
                concours.getEleve().getPrenom(),
                concours.getEleve().getGenre(),
                classe.getDesignation(),
                concours.getNbreReussites(),
                concours.getDate()});
        }
    }

    public void loadDataCombobox() throws SQLException {
        List<Classe> allClasses = ClasseDAO.allClasses();
        for (Classe all : allClasses) {
            jComboBoxConcoursClass.addItem(all.getDesignation());
        }
    }

    public void emptyTable() {
        model.setNumRows(0);

//        for (int i = 0; i < model.getRowCount(); i++) {
//            model.removeRow(i);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConcours = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxConcoursDay = new javax.swing.JComboBox<>();
        jComboBoxConcoursYear = new javax.swing.JComboBox<>();
        jComboBoxConcoursMonth = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxConcoursClass = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTableConcours.setAutoCreateRowSorter(true);
        jTableConcours.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom", "Genre", "Classe", "Resultat", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableConcours);

        jButton1.setText("Nbre corrects");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nbr corrects+Alpha");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(null);

        jLabel1.setText("Date : ");

        jComboBoxConcoursDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBoxConcoursDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxConcoursDayActionPerformed(evt);
            }
        });

        jComboBoxConcoursYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020" }));
        jComboBoxConcoursYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxConcoursYearActionPerformed(evt);
            }
        });

        jComboBoxConcoursMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jComboBoxConcoursMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxConcoursMonthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxConcoursDay, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxConcoursMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxConcoursYear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxConcoursDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxConcoursYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxConcoursMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Classe : ");

        jComboBoxConcoursClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select one" }));
        jComboBoxConcoursClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxConcoursClassActionPerformed(evt);
            }
        });

        jButton3.setText("60");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxConcoursClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxConcoursClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Gerer");

        jMenuItem1.setText("Gerer Eleve");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Gerer Mot");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Gerer Classe");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your newhandling code here:
        GererEleveui ajouterEleve = null;
        try {
            ajouterEleve = new GererEleveui();
        } catch (SQLException ex) {
            Logger.getLogger(AccueilAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        ajouterEleve.setVisible(true);
        //setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        modelTemp = model;
        // System.out.println("releqsed..");
        String typedWord = jTextField1.getText();

        for (int i = 0; i < model.getRowCount(); i++) {
            if (!model.getValueAt(i, 0).toString().startsWith(typedWord)) {
                model.removeRow(i);
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        emptyTable();
        try {
            List<Concours> concoursByReussiteDesc = ConcoursDao.concoursByReussiteDesc();
            for (Concours concours : concoursByReussiteDesc) {
                // System.out.println("allConcours = " + allConcours.getEleve());
                Classe classe = ClasseDAO.getClasseById(concours.getEleve().getIdClasse());
                model.addRow(new Object[]{
                    concours.getEleve().getNom(),
                    concours.getEleve().getPrenom(),
                    concours.getEleve().getGenre(),
                    classe.getDesignation(),
                    concours.getNbreReussites(),
                    concours.getDate()});

            }

        } catch (SQLException ex) {
            Logger.getLogger(AccueilAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        emptyTable();
        try {

            List<Concours> concoursByReussiteAlphaDesc = ConcoursDao.concoursByReussiteAlphaDesc();
            for (Concours concours : concoursByReussiteAlphaDesc) {
                Classe classe = ClasseDAO.getClasseById(concours.getEleve().getIdClasse());
                    model.addRow(new Object[]{
                        concours.getEleve().getNom(),
                        concours.getEleve().getPrenom(),
                        concours.getEleve().getGenre(),
                        classe.getDesignation(),
                        concours.getNbreReussites(),
                        concours.getDate()});
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccueilAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            // TODO add your handling code here:
            new GererMotui().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AccueilAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jComboBoxConcoursMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxConcoursMonthActionPerformed
        // TODO add your handling code here:
        if (true) {
            try {
                List<Concours> concoursTriDate = ConcoursDao.concoursTriDate(jComboBoxConcoursDay.getSelectedItem().toString(), jComboBoxConcoursMonth.getSelectedItem().toString(), jComboBoxConcoursYear.getSelectedItem().toString());
                model.setNumRows(0);
                for (Concours concours : concoursTriDate) {
                    System.out.println("allConcours = " + concours.getEleve());
                    Classe classe = ClasseDAO.getClasseById(concours.getEleve().getIdClasse());
                    model.addRow(new Object[]{
                        concours.getEleve().getNom(),
                        concours.getEleve().getPrenom(),
                        concours.getEleve().getGenre(),
                        classe.getDesignation(),
                        concours.getNbreReussites(),
                        concours.getDate()});
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccueilAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }//GEN-LAST:event_jComboBoxConcoursMonthActionPerformed

    private void jComboBoxConcoursDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxConcoursDayActionPerformed
        // TODO add your handling code here:
        if (true) {
            try {
                List<Concours> concoursTriDate = ConcoursDao.concoursTriDate(jComboBoxConcoursDay.getSelectedItem().toString(), jComboBoxConcoursMonth.getSelectedItem().toString(), jComboBoxConcoursYear.getSelectedItem().toString());
                model.setNumRows(0);
                for (Concours concours : concoursTriDate) {
                    System.out.println("allConcours = " + concours.getEleve());
                    Classe classe = ClasseDAO.getClasseById(concours.getEleve().getIdClasse());
                    model.addRow(new Object[]{
                        concours.getEleve().getNom(),
                        concours.getEleve().getPrenom(),
                        concours.getEleve().getGenre(),
                        classe.getDesignation(),
                        concours.getNbreReussites(),
                        concours.getDate()});
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccueilAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }//GEN-LAST:event_jComboBoxConcoursDayActionPerformed

    private void jComboBoxConcoursYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxConcoursYearActionPerformed
        // TODO add your handling code here:
        if (true) {
            try {
                List<Concours> concoursTriDate = ConcoursDao.concoursTriDate(jComboBoxConcoursDay.getSelectedItem().toString(), jComboBoxConcoursMonth.getSelectedItem().toString(), jComboBoxConcoursYear.getSelectedItem().toString());
                model.setNumRows(0);
                for (Concours concours : concoursTriDate) {
                    System.out.println("allConcours = " + concours.getEleve());
                    Classe classe = ClasseDAO.getClasseById(concours.getEleve().getIdClasse());
                    model.addRow(new Object[]{
                        concours.getEleve().getNom(),
                        concours.getEleve().getPrenom(),
                        concours.getEleve().getGenre(),
                        classe.getDesignation(),
                        concours.getNbreReussites(),
                        concours.getDate()});
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccueilAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }//GEN-LAST:event_jComboBoxConcoursYearActionPerformed

    private void jComboBoxConcoursClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxConcoursClassActionPerformed

        try {
            String classeTri = jComboBoxConcoursClass.getSelectedItem().toString();
           // System.out.println("classeTri = " + classeTri);
            if (jComboBoxConcoursClass.getSelectedItem().toString().contains("Select")) {
                model.setNumRows(0);
                loadDatas();
            } else {
                model.setNumRows(0);
                List<Concours> concoursParClasse = ConcoursDao.concoursParClasse(classeTri);
                for (Concours concours : concoursParClasse) {
                    //System.out.println("allConcours = " + concours.getEleve());
                    Classe classe = ClasseDAO.getClasseById(concours.getEleve().getIdClasse());
                    model.addRow(new Object[]{
                        concours.getEleve().getNom(),
                        concours.getEleve().getPrenom(),
                        concours.getEleve().getGenre(),
                        classe.getDesignation(),
                        concours.getNbreReussites(),
                        concours.getDate()});
                }
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jComboBoxConcoursClassActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            List<Concours> concoursTri60 = ConcoursDao.concoursTri60();
            if (concoursTri60.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pas de resultat");
            } else {
                for (Concours concours : concoursTri60) {
                         model.setNumRows(0);
                   // System.out.println("allConcours = " + concours.getEleve());
                    Classe classe = ClasseDAO.getClasseById(concours.getEleve().getIdClasse());
                    model.addRow(new Object[]{
                        concours.getEleve().getNom(),
                        concours.getEleve().getPrenom(),
                        concours.getEleve().getGenre(),
                        classe.getDesignation(),
                        concours.getNbreReussites(),
                        concours.getDate()});
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccueilAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AccueilAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccueilAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccueilAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccueilAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccueilAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxConcoursClass;
    private javax.swing.JComboBox<String> jComboBoxConcoursDay;
    private javax.swing.JComboBox<String> jComboBoxConcoursMonth;
    private javax.swing.JComboBox<String> jComboBoxConcoursYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableConcours;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}