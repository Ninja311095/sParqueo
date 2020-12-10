/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparqueadero;

import basedatos.Conexion;
import basedatos.entidades.Vehiculo;
import basedatos.dao.VehiculoDao;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Principal
 */
public class PanelRetirarVehiculo extends javax.swing.JPanel {

    /**
     * Creates new form PanelRetirarVehiculo
     */
    //INSTANCIAS
    private final VehiculoDao vehiculoDao = new VehiculoDao();
    Conexion objcon = new Conexion();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //Date date =new Date();

    //VARIABLES
    String fechaHora, horaentrada, sql;
    Date Datehoraentrada;
    int horasACobrar;
    int valorAPagar;
    int confirmacion;
    String propietario;
    String tipoVehiculo;

    public PanelRetirarVehiculo() {
        initComponents();

        objcon.crearConexion();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfPlacaRetiro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JB_Retirar = new java.awt.Button();

        setPreferredSize(new java.awt.Dimension(453, 400));

        tfPlacaRetiro.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        tfPlacaRetiro.setName("Placa"); // NOI18N
        tfPlacaRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPlacaRetiroActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Modulo de salida de vehiculos del parqueadero");

        jLabel2.setText("Placa");

        JB_Retirar.setBackground(new java.awt.Color(255, 51, 0));
        JB_Retirar.setForeground(new java.awt.Color(255, 255, 255));
        JB_Retirar.setLabel("Retirar");
        JB_Retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_RetirarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(tfPlacaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(JB_Retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(tfPlacaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(JB_Retirar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JB_RetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_RetirarActionPerformed
        retirarVehiculo();
        /*fechaHora = dateFormat.format(date);

        try {
            // TODO add your handling code here:

            sql = "SELECT horaentrada, tipovehiculo,propietario from vehiculos WHERE placa ='" + tfPlacaRetiro.getText() + "' AND estado = 'Disponible'";
            objcon.ejecutarSQLSelect(sql);

            objcon.resultado.first();

            //OBTENCION DE VALORES PARA LA CONFIRMACION
            propietario = objcon.resultado.getString(3);
            horaentrada = objcon.resultado.getString(1);
            tipoVehiculo = objcon.resultado.getString(2);

            confirmacion = JOptionPane.showConfirmDialog(null, "Validación de datos\n\n Propietario: " + propietario
                    + "\n Tipo Vehiculo: " + tipoVehiculo + "\n Fecha Entrada: " + horaentrada, "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == 0) {

                Datehoraentrada = dateFormat.parse(horaentrada);
                horasACobrar = (int) ((date.getTime() - Datehoraentrada.getTime()) / 60000) / 60;

                System.out.println(horasACobrar);

                if (objcon.resultado.getString(2).equals("Automovil")) {

                    valorAPagar = horasACobrar * 10;

                } else if (objcon.resultado.getString(2).equals("Motocicleta")) {

                    valorAPagar = horasACobrar * 5;

                }

                sql = "UPDATE vehiculos SET horasalida='" + fechaHora + "',estado= 'No Disponible', valorpagado= "
                        + valorAPagar + " WHERE placa='" + tfPlacaRetiro.getText() + "' AND estado='Disponible'";

                objcon.ejecutarSQL(sql);

                int respuesta = JOptionPane.showConfirmDialog(null, "Valor a pagar:  $" + valorAPagar + "'\nDesea Imprimir Recibo", "Salida de vehiculo", JOptionPane.YES_NO_OPTION);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El vehiculo no se encuentra en el parqueadero, por favor revise la placa ingresada");

            Logger.getLogger(PanelRetirarVehiculo.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ParseException ex) {
            Logger.getLogger(PanelRetirarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_JB_RetirarActionPerformed

    private void tfPlacaRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPlacaRetiroActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfPlacaRetiroActionPerformed

    /**
     * Comprueba que los campos tengan la informacion correcta
     *
     * @return true si todo esta bien, false en caso de que no
     */
    private boolean validarCampos() {
        if(tfPlacaRetiro.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "¡Campo '" + tfPlacaRetiro.getName() + "' debe estar lleno!");
            return false;
        }else{
            return true;
        }
    }

    private void limpiarCampos() {
        tfPlacaRetiro.setText("");
    }

    private double obtenerValorAPagar(Vehiculo vehiculo, Instant instant) {
        long deltaHoras = (instant.toEpochMilli() - vehiculo.getHoraEntrada().toEpochMilli()) / 60000 / 60;
        if (vehiculo.getTipoVehiculo().equals("Automovil")) {
            return deltaHoras * 10;
        } else {
            return deltaHoras * 5;
        }
    }

    private void retirarVehiculo() {
        final Vehiculo vehiculo = vehiculoDao.obtener(tfPlacaRetiro.getText());
        if (validarCampos() && vehiculo == null) {
            JOptionPane.showMessageDialog(null, "¡Vehículo no encontrado. Es posible que no existe un vehículo con esa placa!");
        } else if (vehiculo.getEstado().equals("Disponible")) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Propietario: " + vehiculo.getPropietario() + ", Tipo Vehiculo: " + vehiculo.getTipoVehiculo() + ", Fecha Entrada: " + dateFormat.format(new Date(vehiculo.getHoraEntrada().toEpochMilli())), "Confirmar Datos", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                final Instant instant = Instant.now();
                vehiculo.setHoraSalida(instant);
                vehiculo.setEstado("No Disponible");
                vehiculo.setValorPagado(obtenerValorAPagar(vehiculo, instant));

                if (vehiculoDao.modificar(vehiculo)) {
                    limpiarCampos();
                    JOptionPane.showMessageDialog(null, "¡Vehículo retirado!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Este vehículo ya ha sido retirado!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button JB_Retirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfPlacaRetiro;
    // End of variables declaration//GEN-END:variables
}
