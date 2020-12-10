package proyectoparqueadero;

//import com.itextpdf.kernel.geom.PageSize;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.border.Border;
//import com.itextpdf.layout.element.Paragraph;
import basedatos.Conexion;
import basedatos.Database;
import basedatos.entidades.Vehiculo;
import basedatos.dao.VehiculoDao;
import java.sql.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PanelIngresarVehiculo extends javax.swing.JPanel {

    //VARIABLES 
    private final VehiculoDao vehiculoDao = new VehiculoDao();
    String fechaHora = "";
    String clasevehiculo = "";
    String sql;

    //INSTANCIAS
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //Date date =new Date();
    static final String DEST = "proyectoparqueadero/hello_world.pdf";
    Conexion objbd = new Conexion();

    public PanelIngresarVehiculo() {
        initComponents();
        Database.obtenerInstancia();
        objbd.crearConexion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        JLtitulo = new javax.swing.JLabel();
        tfPlaca = new javax.swing.JTextField();
        tfPropietario = new javax.swing.JTextField();
        jLplaca = new javax.swing.JLabel();
        jLpropietario = new javax.swing.JLabel();
        jLTvehiculo = new javax.swing.JLabel();
        rbMoto = new javax.swing.JRadioButton();
        rbAuto = new javax.swing.JRadioButton();
        JB_registrar = new java.awt.Button();

        JLtitulo.setBackground(new java.awt.Color(255, 255, 255));
        JLtitulo.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        JLtitulo.setForeground(new java.awt.Color(255, 0, 0));
        JLtitulo.setText("Modulo de Ingreso de vehiculos al parqueo");

        tfPlaca.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        tfPlaca.setName("Placa"); // NOI18N

        tfPropietario.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        tfPropietario.setName("Nombre Propietario"); // NOI18N

        jLplaca.setText("Placa");

        jLpropietario.setText("Nombre propietario");

        jLTvehiculo.setText("Tipo de vehiculo");

        buttonGroup1.add(rbMoto);
        rbMoto.setText("Motocicleta");

        buttonGroup1.add(rbAuto);
        rbAuto.setText("Automovil");

        JB_registrar.setBackground(new java.awt.Color(255, 51, 0));
        JB_registrar.setForeground(new java.awt.Color(255, 255, 255));
        JB_registrar.setLabel("Registrar");
        JB_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_registrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JB_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTvehiculo)
                    .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLpropietario)
                    .addComponent(jLplaca)
                    .addComponent(JLtitulo))
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(rbMoto)
                .addGap(10, 10, 10)
                .addComponent(rbAuto)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(JLtitulo)
                .addGap(43, 43, 43)
                .addComponent(jLplaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLpropietario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLTvehiculo)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAuto)
                    .addComponent(rbMoto))
                .addGap(26, 26, 26)
                .addComponent(JB_registrar, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void JB_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_registrarActionPerformed
        ingresarVehiculo();
        /*fechaHora = dateFormat.format(date);

        if (rbAuto.isSelected()) {
            clasevehiculo = "Automovil";
        }
        if (rbMoto.isSelected()) {
            clasevehiculo = "Motocicleta";
        }

        String sql = "INSERT INTO vehiculos (placa, propietario,tipovehiculo,horaentrada,estado) VALUES ('"
                + tfPlaca.getText() + "','" + tfPropietario.getText() + "','" + clasevehiculo + "','"
                + fechaHora + "','Disponible')";

        objbd.ejecutarSQL(sql);

        tfPlaca.setText("");
        tfPropietario.setText("");
        clasevehiculo = "";

        JOptionPane.showMessageDialog(null, "Vehiculo registrado exitosamente");*/

//           String dest = "C:/reportes/sample.pdf";
//        try {
//            PdfWriter writer = new PdfWriter(dest);
//            PdfDocument pdfDoc = new PdfDocument(writer);
//            Document document = new Document(pdfDoc, PageSize.A5);
//            pdfDoc.addNewPage();
//
//            Paragraph para = new Paragraph ("Recibo Parqueadero");
//            
//            para.setBorder(Border.NO_BORDER);
//            para.setBold();
//
//            Paragraph para1 = new Paragraph ("Placa vehiculo: "+tfPlaca.getText());
//            Paragraph para2 = new Paragraph ("Nombre del propietario: "+tfPropietario.getText());
//            Paragraph para3 = new Paragraph ("Hora de ingreso: "+fechaHora);
//
//            document.add(para);
//            document.add(para1);
//            document.add(para2);
//            document.add(para3); 
//            document.close();
//             System.out.println("PDF Created");
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(PanelIngresarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(PanelIngresarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try {
//
//		if ((new File("c:\\reportes/sample.pdf")).exists()) {
//
//			Process p = Runtime
//			   .getRuntime()
//			   .exec("rundll32 url.dll,FileProtocolHandler c:\\reportes/sample.pdf");
//			p.waitFor();
//				
//		} else {
//
//			System.out.println("File is not exists");
//
//		}
//
//		System.out.println("Done");
//
//  	  } catch (Exception ex) {
//		ex.printStackTrace();
//	  }

    }//GEN-LAST:event_JB_registrarActionPerformed

    private void limpiarCampos() {
        Object[] campos = {tfPlaca, tfPropietario};

        for (Object campo : campos) {
            if (campo instanceof JTextField) {
                ((JTextField) campo).setText("");
            }
        }

        if (rbMoto.isSelected()) {
            rbMoto.setSelected(false);
        } else {
            rbAuto.setSelected(false);
        }
    }

    /**
     * Comprueba que los campos tengan la informacion correcta
     * @return true si todo esta bien, false en caso de que no
     */
    private boolean validarCampos() {
        Object[] campos = {tfPlaca, tfPropietario};

        for (Object campo : campos) {
            if (campo instanceof JTextField && ((JTextField) campo).getText().isBlank()) {
                String nombreCampo = ((JTextField) campo).getName();
                JOptionPane.showMessageDialog(null, "¡El campo '" + nombreCampo + "' debe estar lleno!");
                return false;
            }
        }

        if (!rbMoto.isSelected() && !rbAuto.isSelected()) {
            JOptionPane.showInternalMessageDialog(null, "¡Primero debe elegir el tipo de vehículo!");
            return false;
        }

        return true;
    }

    private Vehiculo generarVehiculo() {
        String tipoVehiculo = "";

        if (rbAuto.isSelected()) {
            tipoVehiculo = "Automovil";
        }
        if (rbMoto.isSelected()) {
            tipoVehiculo = "Motocicleta";
        }

        return new Vehiculo(
                tfPlaca.getText(),
                tfPropietario.getText(),
                tipoVehiculo,
                Instant.now(),
                "Disponible");
    }

    private void ingresarVehiculo() {
        if (validarCampos()) {
            final Vehiculo v = generarVehiculo();
            int idNuevoVehiculo = vehiculoDao.agregar(v);
            System.out.println(idNuevoVehiculo);
            if (idNuevoVehiculo > 0) {
                limpiarCampos();
                JOptionPane.showInternalMessageDialog(null, "¡Vehiculo registrado!");
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button JB_registrar;
    private javax.swing.JLabel JLtitulo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLTvehiculo;
    private javax.swing.JLabel jLplaca;
    private javax.swing.JLabel jLpropietario;
    private javax.swing.JRadioButton rbAuto;
    private javax.swing.JRadioButton rbMoto;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfPropietario;
    // End of variables declaration//GEN-END:variables
}
