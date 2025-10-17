package Presentacion;
import Logica.DataAporte;
import Logica.IControlador;
import java.awt.Image;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;

public class InterConsultaCola extends javax.swing.JInternalFrame {
    
    private final IControlador ic;
   
    public InterConsultaCola(IControlador ic) {
        this.ic=ic;
        initComponents();
        this.Colaboradores.addItem("--Seleccionar--");
        for(String c : this.ic.getColaboradores()){
            this.Colaboradores.addItem(c);
        }
        this.Propuestas.setEnabled(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Colaboradores = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Propuestas = new javax.swing.JComboBox<>();
        Mantener = new javax.swing.JButton();
        txtAporte = new javax.swing.JFormattedTextField();
        txtFecha = new javax.swing.JFormattedTextField();
        txtCantidad = new javax.swing.JTextField();
        txtRetorno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtImagen = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Consulta Colaboración a Propuesta");
        setPreferredSize(new java.awt.Dimension(500, 450));

        jLabel2.setText("Seleccione una Propuesta : ");

        Colaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColaboradoresActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione un Colaborador : ");

        Propuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropuestasActionPerformed(evt);
            }
        });

        Mantener.setText("Salir");
        Mantener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MantenerActionPerformed(evt);
            }
        });

        txtAporte.setEditable(false);

        txtFecha.setEditable(false);

        txtCantidad.setEditable(false);

        txtRetorno.setEditable(false);
        txtRetorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRetornoActionPerformed(evt);
            }
        });

        jLabel1.setText("Aporte:");

        jLabel4.setText("Fecha y hora:");

        jLabel5.setText("Cantidad de Retorno:");

        jLabel6.setText("Tipo de Retorno:");

        txtImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Contribución:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Colaboradores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Propuestas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                            .addComponent(txtAporte, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRetorno))))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Mantener)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Colaboradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Propuestas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mantener)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MantenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MantenerActionPerformed
        this.dispose();
    }//GEN-LAST:event_MantenerActionPerformed

    private void ColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColaboradoresActionPerformed
      
        this.Propuestas.removeAllItems();
        
        //ic.actualizarColab

        if (this.Colaboradores.getSelectedIndex()!=0) {
            this.Propuestas.addItem("--Seleccionar--");
            for (String p : this.ic.getPropuestasXColaborador(this.Colaboradores.getSelectedItem().toString())) {
                this.Propuestas.addItem(p);
            }
            this.Propuestas.setEnabled(true);
        } else {
            this.Propuestas.setEnabled(false);
        }
    }//GEN-LAST:event_ColaboradoresActionPerformed

    private void PropuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropuestasActionPerformed
        if (this.Propuestas.getSelectedItem() != null && this.Colaboradores.getSelectedItem() != null && this.Propuestas.getSelectedIndex()!=0) {
            DataAporte DA = ic.getDataAporte(this.Propuestas.getSelectedItem().toString(),this.Colaboradores.getSelectedItem().toString());
            this.txtAporte.setText(DA.get$aporte().toString());
            this.txtCantidad.setText(DA.getCantidad()+"");
            this.txtFecha.setText(DA.getFechaHora().format(DateTimeFormatter.ISO_DATE));
            this.txtRetorno.setText(DA.getRetorno().toString());
            
            ImageIcon icon = new ImageIcon(DA.getImagen());
            Image imagenEscalada = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            this.txtImagen.setIcon(new ImageIcon(imagenEscalada));
            this.jProgressBar1.setMinimum(0);
            this.jProgressBar1.setMaximum(DA.getNecesaria().intValue());
            
            if(DA.get$aporte().intValue() >= DA.getNecesaria().intValue()){
                this.jProgressBar1.setValue(DA.getNecesaria().intValue());
            }else{
                this.jProgressBar1.setValue(DA.get$aporte().intValue());
            } 
            
        }else{
            this.txtAporte.setText("");//DA.get$aporte().toString());
            this.txtCantidad.setText("");//DA.getCantidad()+"");
            this.txtFecha.setText("");//DA.getFechaHora().format(DateTimeFormatter.ISO_DATE));
            this.txtRetorno.setText("");//DP.getRetorno().toString());
            this.jProgressBar1.setMinimum(0);
            this.jProgressBar1.setMaximum(100);
            this.jProgressBar1.setValue(0);
            this.txtImagen.setIcon(null);
        }
    }//GEN-LAST:event_PropuestasActionPerformed

    private void txtRetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRetornoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRetornoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Colaboradores;
    private javax.swing.JButton Mantener;
    private javax.swing.JComboBox<String> Propuestas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JFormattedTextField txtAporte;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JLabel txtImagen;
    private javax.swing.JTextField txtRetorno;
    // End of variables declaration//GEN-END:variables
}
