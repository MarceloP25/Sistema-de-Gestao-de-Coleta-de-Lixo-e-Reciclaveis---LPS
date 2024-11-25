/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.view;

/**
 *
 * @author marce
 */
public class FrHomeAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FrhomeAdmin
     */
    public FrHomeAdmin() {
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

        lblTittle = new javax.swing.JLabel();
        bntMaterial = new javax.swing.JButton();
        bntRota = new javax.swing.JButton();
        bntSupervisores = new javax.swing.JButton();
        bntOperador = new javax.swing.JButton();
        bntCidadao = new javax.swing.JButton();
        bntColetas = new javax.swing.JButton();
        bntPerfil = new javax.swing.JButton();
        bntSair = new javax.swing.JButton();
        bntVeiculos = new javax.swing.JButton();
        bntDepartamento1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        lblTittle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTittle.setText("Sistema de Coleta de Lixo e Recicláveis - Admin");

        bntMaterial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntMaterial.setText("Materiais");

        bntRota.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntRota.setText("Rotas");

        bntSupervisores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntSupervisores.setText("Supervisores");

        bntOperador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntOperador.setText("Operadores");

        bntCidadao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntCidadao.setText("Cidadãos");
        bntCidadao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCidadaoActionPerformed(evt);
            }
        });

        bntColetas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntColetas.setText("Coletas");

        bntPerfil.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bntPerfil.setText("Perfil");

        bntSair.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bntSair.setText("Sair");
        bntSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSairActionPerformed(evt);
            }
        });

        bntVeiculos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntVeiculos.setText("Veículos");

        bntDepartamento1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bntDepartamento1.setText("Departamentos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(bntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(bntPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(354, Short.MAX_VALUE))
            .addComponent(lblTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(bntRota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntColetas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bntDepartamento1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(bntVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bntCidadao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntSupervisores, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(bntOperador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bntSupervisores, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntRota, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(bntOperador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bntCidadao, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(bntColetas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bntDepartamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntCidadaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCidadaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntCidadaoActionPerformed

    private void bntSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntSairActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCidadao;
    private javax.swing.JButton bntColetas;
    private javax.swing.JButton bntDepartamento1;
    private javax.swing.JButton bntMaterial;
    private javax.swing.JButton bntOperador;
    private javax.swing.JButton bntPerfil;
    private javax.swing.JButton bntRota;
    private javax.swing.JButton bntSair;
    private javax.swing.JButton bntSupervisores;
    private javax.swing.JButton bntVeiculos;
    private javax.swing.JLabel lblTittle;
    // End of variables declaration//GEN-END:variables
}
