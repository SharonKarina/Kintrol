/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Conexiones.Conexion;
import Controller.controllerMembresias;
import Model.Administrador;
import Model.AdministradorDAO;
import Model.Membresia;
import Model.MembresiaDAO;
import Model.Ubicacion;
import Model.UbicacionDAO;

import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author karin
 */
public class GestionMembresias extends javax.swing.JFrame {
    private controllerMembresias controller;
    private DefaultTableModel modeloTabla;

    
    /**
     * Creates new form GestionMembresias
     */
    public GestionMembresias() {
        initComponents();
        modeloTabla = (DefaultTableModel) tablaMembresias.getModel();
        
        // Configurar controlador
        try {
            Connection conn = Conexion.getCnx().getCnn();
            controller = new controllerMembresias(new MembresiaDAO(conn));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al conectar: " + e.getMessage());
        }
    }
    
    private void agregarMembresia() {
        try {
            // Verificar existencia del administrador
            int idAdmin;
            
            try {
                idAdmin = Integer.parseInt(idAdministradorMTextField1.getText().trim());
                AdministradorDAO adminDAO = new AdministradorDAO();
                if (!adminDAO.existeAdministrador(idAdmin)) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "El ID del administrador no existe. Redirigiendo al formulario de creación.");
                crearAdministrador crearAdminDialog = new crearAdministrador(this, true); // tu JDialog
                crearAdminDialog.setVisible(true);
                idAdmin = crearAdminDialog.getIdAdministradorCreado();
                
                if (idAdmin == -1) {
                    JOptionPane.showMessageDialog(this, "No se creó el administrador.");
                    return;
                }
                idAdministradorMTextField1.setText(String.valueOf(idAdmin)); // lo seteas en el formulario
            }
            
            Membresia m = new Membresia(
                0,
                Integer.parseInt(limiteMTextField.getText()),
                fechaInicioMTextField.getText(),
                Integer.parseInt(duracionMTextField1.getText()),
                idAdmin,
                Integer.parseInt(idUbicacionMTextField1.getText())
            );
            
            int idGenerado = controller.crearMembresia(m);
            
            if (idGenerado != -1) {
                JOptionPane.showMessageDialog(this, "Membresía agregada correctamente");
                idMembresíaMTextField.setText(String.valueOf(idGenerado));
                listarMembresias();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Verifica los campos numéricos");
        }
    }

    private void eliminarMembresia() {
        try {
            int id = Integer.parseInt(idMembresíaMTextField.getText());
            if (controller.eliminarConAdministrador(id)) {
                JOptionPane.showMessageDialog(this, "Eliminada correctamente");
                listarMembresias();
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la membresía");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido");
        }
    }

    private void listarMembresias() {
        modeloTabla.setRowCount(0);
        for (Membresia m : controller.listarMembresias()) {
            modeloTabla.addRow(new Object[]{
                m.getIdMembresia(),
                m.getLimite(),
                m.getFechaInicio(),
                m.getDuracion(),
                m.getIdAdministrador(),
                m.getIdUbicacion()
            });
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

        jPanel1 = new javax.swing.JPanel();
        panelTituloM = new javax.swing.JPanel();
        gestionMembresías = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        panelMembresias = new javax.swing.JPanel();
        fechaInicioM = new javax.swing.JLabel();
        GMid_Membresia = new javax.swing.JLabel();
        idMembresíaMTextField = new javax.swing.JTextField();
        limiteMTextField = new javax.swing.JTextField();
        fechaInicioMTextField = new javax.swing.JTextField();
        limiteM = new javax.swing.JLabel();
        duraciónM = new javax.swing.JLabel();
        duracionMTextField1 = new javax.swing.JTextField();
        idAdministradorMTextField1 = new javax.swing.JTextField();
        idAdministradorM = new javax.swing.JLabel();
        idUbicacionMTextField1 = new javax.swing.JTextField();
        idUbicacionM = new javax.swing.JLabel();
        papelBotonesM = new javax.swing.JPanel();
        listarMButton = new javax.swing.JButton();
        agregarMButton = new javax.swing.JButton();
        eliminarMButton = new javax.swing.JButton();
        verDetallesMButton = new javax.swing.JButton();
        volverGMButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        panelTablaM = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMembresias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 199, 167));

        jPanel1.setBackground(new java.awt.Color(247, 255, 205));

        panelTituloM.setBackground(new java.awt.Color(247, 255, 205));

        gestionMembresías.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        gestionMembresías.setText("Gestión Membresías");
        gestionMembresías.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSeparator1.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout panelTituloMLayout = new javax.swing.GroupLayout(panelTituloM);
        panelTituloM.setLayout(panelTituloMLayout);
        panelTituloMLayout.setHorizontalGroup(
            panelTituloMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloMLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gestionMembresías)
                .addGap(136, 136, 136))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelTituloMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTituloMLayout.createSequentialGroup()
                    .addGap(0, 91, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 258, Short.MAX_VALUE)))
        );
        panelTituloMLayout.setVerticalGroup(
            panelTituloMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloMLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(gestionMembresías)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelTituloMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTituloMLayout.createSequentialGroup()
                    .addGap(0, 21, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 28, Short.MAX_VALUE)))
        );

        panelMembresias.setBackground(new java.awt.Color(222, 235, 181));
        panelMembresias.setBorder(javax.swing.BorderFactory.createTitledBorder("Membresía"));

        fechaInicioM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fechaInicioM.setText("Fecha inicio:");

        GMid_Membresia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        GMid_Membresia.setText("ID Membresía:");

        idMembresíaMTextField.setForeground(new java.awt.Color(153, 153, 153));
        idMembresíaMTextField.setText("ID Membresía");
        idMembresíaMTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idMembresíaMTextFieldActionPerformed(evt);
            }
        });

        limiteMTextField.setForeground(new java.awt.Color(153, 153, 153));
        limiteMTextField.setText("Limite");
        limiteMTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limiteMTextFieldActionPerformed(evt);
            }
        });

        fechaInicioMTextField.setForeground(new java.awt.Color(153, 153, 153));
        fechaInicioMTextField.setText("Fecha inicio");

        limiteM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        limiteM.setText("Limite:");

        duraciónM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        duraciónM.setText("Duración:");

        duracionMTextField1.setForeground(new java.awt.Color(153, 153, 153));
        duracionMTextField1.setText("Duración");
        duracionMTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionMTextField1ActionPerformed(evt);
            }
        });

        idAdministradorMTextField1.setForeground(new java.awt.Color(153, 153, 153));
        idAdministradorMTextField1.setText("ID Administrador");
        idAdministradorMTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idAdministradorMTextField1ActionPerformed(evt);
            }
        });

        idAdministradorM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        idAdministradorM.setText("ID Administrador:");

        idUbicacionMTextField1.setForeground(new java.awt.Color(153, 153, 153));
        idUbicacionMTextField1.setText("ID Ubicación");

        idUbicacionM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        idUbicacionM.setText("ID Ubicación:");

        javax.swing.GroupLayout panelMembresiasLayout = new javax.swing.GroupLayout(panelMembresias);
        panelMembresias.setLayout(panelMembresiasLayout);
        panelMembresiasLayout.setHorizontalGroup(
            panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMembresiasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMembresiasLayout.createSequentialGroup()
                        .addGroup(panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GMid_Membresia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(limiteM)
                            .addComponent(fechaInicioM)
                            .addComponent(duraciónM, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idAdministradorM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idAdministradorMTextField1)
                            .addComponent(duracionMTextField1)
                            .addComponent(idMembresíaMTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(limiteMTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechaInicioMTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMembresiasLayout.createSequentialGroup()
                        .addComponent(idUbicacionM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(idUbicacionMTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMembresiasLayout.setVerticalGroup(
            panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMembresiasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GMid_Membresia)
                    .addComponent(idMembresíaMTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limiteMTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limiteM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaInicioMTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaInicioM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duraciónM)
                    .addComponent(duracionMTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idAdministradorMTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idAdministradorM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMembresiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idUbicacionMTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idUbicacionM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        papelBotonesM.setBackground(new java.awt.Color(247, 255, 205));

        listarMButton.setBackground(new java.awt.Color(222, 235, 181));
        listarMButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listarMButton.setText("Listar");
        listarMButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listarMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarMButtonActionPerformed(evt);
            }
        });

        agregarMButton.setBackground(new java.awt.Color(222, 235, 181));
        agregarMButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        agregarMButton.setText("Agregar");
        agregarMButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        agregarMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarMButtonActionPerformed(evt);
            }
        });

        eliminarMButton.setBackground(new java.awt.Color(222, 235, 181));
        eliminarMButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        eliminarMButton.setText("Eliminar");
        eliminarMButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eliminarMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarMButtonActionPerformed(evt);
            }
        });

        verDetallesMButton.setBackground(new java.awt.Color(222, 235, 181));
        verDetallesMButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        verDetallesMButton.setText("Ver Detalles");
        verDetallesMButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        verDetallesMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDetallesMButtonActionPerformed(evt);
            }
        });

        volverGMButton.setBackground(new java.awt.Color(222, 235, 181));
        volverGMButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        volverGMButton.setText("Volver");
        volverGMButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        volverGMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverGMButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout papelBotonesMLayout = new javax.swing.GroupLayout(papelBotonesM);
        papelBotonesM.setLayout(papelBotonesMLayout);
        papelBotonesMLayout.setHorizontalGroup(
            papelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(papelBotonesMLayout.createSequentialGroup()
                .addComponent(listarMButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(agregarMButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarMButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verDetallesMButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volverGMButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        papelBotonesMLayout.setVerticalGroup(
            papelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(papelBotonesMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(papelBotonesMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listarMButton)
                    .addComponent(agregarMButton)
                    .addComponent(eliminarMButton)
                    .addComponent(verDetallesMButton)
                    .addComponent(volverGMButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTablaM.setBackground(new java.awt.Color(222, 235, 181));

        tablaMembresias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idMembresia", "Limite", "fechaInicio", "duración", "idAdministrador", "idUbicación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Byte.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMembresias);

        javax.swing.GroupLayout panelTablaMLayout = new javax.swing.GroupLayout(panelTablaM);
        panelTablaM.setLayout(panelTablaMLayout);
        panelTablaMLayout.setHorizontalGroup(
            panelTablaMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelTablaMLayout.setVerticalGroup(
            panelTablaMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaMLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTituloM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMembresias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(papelBotonesM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(panelTablaM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTituloM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMembresias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(papelBotonesM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTablaM, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idMembresíaMTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idMembresíaMTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idMembresíaMTextFieldActionPerformed

    private void limiteMTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limiteMTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limiteMTextFieldActionPerformed

    private void duracionMTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionMTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionMTextField1ActionPerformed

    private void idAdministradorMTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idAdministradorMTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idAdministradorMTextField1ActionPerformed

    private void listarMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarMButtonActionPerformed
        // TODO add your handling code here:
        listarMButton.addActionListener(e -> listarMembresias());
    }//GEN-LAST:event_listarMButtonActionPerformed

    private void eliminarMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarMButtonActionPerformed
        // TODO add your handling code here:
        eliminarMButton.addActionListener(e -> eliminarMembresia());
    }//GEN-LAST:event_eliminarMButtonActionPerformed

    private void agregarMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarMButtonActionPerformed
        // TODO add your handling code here:
        crearAdministrador crearAdmin = new crearAdministrador(null, true);
        agregarMButton.addActionListener(e -> agregarMembresia());
    }//GEN-LAST:event_agregarMButtonActionPerformed

    private void verDetallesMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDetallesMButtonActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = tablaMembresias.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                int idMembresia = Integer.parseInt(tablaMembresias.getValueAt(filaSeleccionada, 0).toString());
                
                MembresiaDAO membresiaDAO = new MembresiaDAO();
                Membresia membresia = membresiaDAO.obtenerPorId(idMembresia);
                
                if (membresia != null) {
                    AdministradorDAO adminDAO = new AdministradorDAO();
                    Administrador admin = adminDAO.obtenerPorId(membresia.getIdAdministrador());
                    
                    UbicacionDAO ubiDAO = new UbicacionDAO();
                    Ubicacion ubicacion = ubiDAO.obtenerPorId(membresia.getIdUbicacion());
                    
                    if (admin == null || ubicacion == null) {
                        JOptionPane.showMessageDialog(this, "No se pudieron cargar todos los detalles.");
                        return;
                    }
                    
                    DetallesMembresia dialogo = new DetallesMembresia(this, true, this.controller);
                    dialogo.setDatosMembresia(membresia);
                    dialogo.setDatosAdministrador(admin);
                    dialogo.setDatosUbicacion(ubicacion);
                    dialogo.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontró la membresía.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(GestionMembresias.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para ver los detalles.");
        }

    }//GEN-LAST:event_verDetallesMButtonActionPerformed

    private void volverGMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverGMButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new PrincipalKintrol().setVisible(true);
    }//GEN-LAST:event_volverGMButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GestionMembresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionMembresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionMembresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionMembresias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionMembresias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GMid_Membresia;
    private javax.swing.JButton agregarMButton;
    private javax.swing.JTextField duracionMTextField1;
    private javax.swing.JLabel duraciónM;
    private javax.swing.JButton eliminarMButton;
    private javax.swing.JLabel fechaInicioM;
    private javax.swing.JTextField fechaInicioMTextField;
    private javax.swing.JLabel gestionMembresías;
    private javax.swing.JLabel idAdministradorM;
    private javax.swing.JTextField idAdministradorMTextField1;
    private javax.swing.JTextField idMembresíaMTextField;
    private javax.swing.JLabel idUbicacionM;
    private javax.swing.JTextField idUbicacionMTextField1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel limiteM;
    private javax.swing.JTextField limiteMTextField;
    private javax.swing.JButton listarMButton;
    private javax.swing.JPanel panelMembresias;
    private javax.swing.JPanel panelTablaM;
    private javax.swing.JPanel panelTituloM;
    private javax.swing.JPanel papelBotonesM;
    private javax.swing.JTable tablaMembresias;
    private javax.swing.JButton verDetallesMButton;
    private javax.swing.JButton volverGMButton;
    // End of variables declaration//GEN-END:variables
}
