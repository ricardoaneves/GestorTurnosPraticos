/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Bussiness.Facade;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author André
 */
public class LoginDocentes extends javax.swing.JFrame {

    /**
     * Creates new form LoginDocente
     */
    
    private Facade facade;
    DefaultListModel dm = new DefaultListModel();
    ArrayList<String> array = new ArrayList<String>();
    
    public LoginDocentes(Facade facade){
        initComponents();
        this.facade = facade;
        addLogin();
    }

    public void addLogin(){
        array = this.facade.addUCDocenteLogin();
        for(String s : array){
            ItemsText.setModel(dm);
            dm.addElement(s);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ItemsText = new javax.swing.JList<String>();
        AdicionarCadeirasButton = new javax.swing.JButton();
        InfoButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        verAlunosButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(ItemsText);

        AdicionarCadeirasButton.setText("Adicionar Cadeiras");
        AdicionarCadeirasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarCadeirasButtonActionPerformed(evt);
            }
        });

        InfoButton.setText("Informação");
        InfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Tornar-se Docente Responsável");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        verAlunosButton.setText("Ver alunos do Turno");
        verAlunosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verAlunosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdicionarCadeirasButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InfoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verAlunosButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AdicionarCadeirasButton)
                        .addGap(26, 26, 26)
                        .addComponent(InfoButton)
                        .addGap(30, 30, 30)
                        .addComponent(verAlunosButton)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AdicionarCadeirasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarCadeirasButtonActionPerformed
        this.setVisible(false);
        RegistarUCDocente ru = new RegistarUCDocente(facade);
        ru.setVisible(true);
    }//GEN-LAST:event_AdicionarCadeirasButtonActionPerformed

    private void InfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoButtonActionPerformed
        String s = ItemsText.getSelectedValue();
        String ucS = this.facade.infoUC(s);
        String infoDocente = this.facade.infoDocente(ucS, s);
        String infoDocenteResponsavel = this.facade.infoDocenteResponsavel(ucS, s);
        String infoSala = this.facade.infoSala(ucS, s);
        JOptionPane.showMessageDialog(null, "Turno:  " + s + "\nDocente:  " + infoDocente + "\nDocente Responsável:  " + infoDocenteResponsavel + "\nSala:  " + infoSala);
    }//GEN-LAST:event_InfoButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        LoginInterface li = new LoginInterface(facade);
        li.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        UCsResponsavel ucsr = new UCsResponsavel(facade);
        ucsr.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void verAlunosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verAlunosButtonActionPerformed
        String s = ItemsText.getSelectedValue();
        this.facade.atualizaAuxTurno(s);
        AlunosTurno at = new AlunosTurno(facade);
        at.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_verAlunosButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarCadeirasButton;
    private javax.swing.JButton InfoButton;
    private javax.swing.JList<String> ItemsText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton verAlunosButton;
    // End of variables declaration//GEN-END:variables
}
