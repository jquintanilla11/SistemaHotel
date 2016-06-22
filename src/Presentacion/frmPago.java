/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Datos.vhabitacion;
import Datos.vpago;
import Datos.vreserva;
import Logica.conexion;
import Logica.fconsumo;
import Logica.fhabitacion;
import Logica.fpago;
import Logica.fproducto;
import Logica.freserva;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author CARLOS
 */
public class frmPago extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPago
     */
    public frmPago() {
        initComponents();
        mostrar(idreserva);
        inhabilitar();
        txtidreserva.setText(idreserva);
        txtcliente.setText(cliente);
        txthabitacion.setText(habitacion);
        txtidhabitacion.setText(idhabitacion);
        txttotalreserva.setText(Double.toString(totalreserva));
        
        fconsumo func = new fconsumo();
        func.mostrar(idreserva);
        
        txttotal_pago.setText(Double.toString(totalreserva + func.totalconsumo));
        
        
    }
    
    private String accion = "guardar";
    public static String idreserva;
    public static String cliente;
    public static String idhabitacion;
    public static String habitacion;
    public static Double totalreserva;
    

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    void ocultar_columnasconsumo() {
        tablalistadoconsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablalistadoconsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tablalistadoconsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    
    
    void inhabilitar() {
        txtidpago.setVisible(false);
        
        txtidreserva.setVisible(false);
        txtcliente.setEnabled(false);
        txtnum_comprobante.setEnabled(false);
        cbotipo_comprobante.setEnabled(false);
        txtigv.setEnabled(false);
        txttotal_pago.setEnabled(false);
        txttotalreserva.setEnabled(false);
        dcfecha_emision.setEnabled(false);
        dcfecha_pago.setEnabled(false);
        
        txtidhabitacion.setVisible(false);
        txthabitacion.setEnabled(false);
         
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtidpago.setText("");
        txtnum_comprobante.setText("");
        txtigv.setText("");
        txttotal_pago.setText("");

    }

    void habilitar() {
        txtidpago.setVisible(false);
        
        txtidreserva.setVisible(true);
        txtcliente.setEnabled(true);
        txtnum_comprobante.setEnabled(true);
        cbotipo_comprobante.setEnabled(true);
        txtigv.setEnabled(true);
        txttotal_pago.setEnabled(true);
        txttotalreserva.setEnabled(true);
        dcfecha_emision.setEnabled(true);
        dcfecha_pago.setEnabled(true);
        
        txtidhabitacion.setVisible(true);
        txthabitacion.setEnabled(true);
         
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);
        txtidpago.setText("");
        txtnum_comprobante.setText("");
        txtigv.setText("");
        //txttotal_pago.setText("");

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fpago func = new fpago();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Pagos " + Integer.toString(func.totalregistros));
            
            //Mostrar los datos de los consumos
            fconsumo func2 = new fconsumo();
            modelo= func2.mostrar(buscar);
            tablalistadoconsumo.setModel(modelo);
            ocultar_columnasconsumo();
            
            lbltotalregistrosconsumo.setText("Total Consumos " + func2.totalregistros);
            lbltotalconsumo.setText("Consumo Total: $." + func2.totalconsumo );
            

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
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

        txttotal_reserva = new javax.swing.JPanel();
        txtidpago = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnum_comprobante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbotipo_comprobante = new javax.swing.JComboBox();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttotalreserva = new javax.swing.JTextField();
        txtidhabitacion = new javax.swing.JTextField();
        txthabitacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtigv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txttotal_pago = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dcfecha_emision = new com.toedter.calendar.JDateChooser();
        dcfecha_pago = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnImprimirComprobante = new javax.swing.JButton();
        btnImprimirComprobanteConsumo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablalistadoconsumo = new javax.swing.JTable();
        lbltotalregistrosconsumo = new javax.swing.JLabel();
        lbltotalconsumo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        txttotal_reserva.setBackground(new java.awt.Color(255, 204, 102));
        txttotal_reserva.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtidpago.setBackground(new java.awt.Color(235, 227, 227));
        txtidpago.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtidpago.setForeground(new java.awt.Color(0, 0, 51));
        txttotal_reserva.add(txtidpago, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 130, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Reserva:");
        txttotal_reserva.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtidreserva.setBackground(new java.awt.Color(235, 227, 227));
        txtidreserva.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtidreserva.setForeground(new java.awt.Color(0, 0, 51));
        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });
        txttotal_reserva.add(txtidreserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 78, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setText("Habitación:");
        txttotal_reserva.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("Num Comprobante:");
        txttotal_reserva.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        txtnum_comprobante.setBackground(new java.awt.Color(235, 227, 227));
        txtnum_comprobante.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtnum_comprobante.setForeground(new java.awt.Color(0, 0, 51));
        txtnum_comprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_comprobanteActionPerformed(evt);
            }
        });
        txttotal_reserva.add(txtnum_comprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 98, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setText("Tipo Comprobante:");
        txttotal_reserva.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        cbotipo_comprobante.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cbotipo_comprobante.setForeground(new java.awt.Color(0, 0, 51));
        cbotipo_comprobante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Boleta", "Factura", "Ticket", "Otro" }));
        cbotipo_comprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipo_comprobanteActionPerformed(evt);
            }
        });
        txttotal_reserva.add(cbotipo_comprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 148, -1));

        btnnuevo.setBackground(new java.awt.Color(204, 255, 255));
        btnnuevo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/nuevo.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        txttotal_reserva.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, -1, -1));

        btnguardar.setBackground(new java.awt.Color(204, 255, 255));
        btnguardar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/guardar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        txttotal_reserva.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, -1, -1));

        btncancelar.setBackground(new java.awt.Color(204, 255, 255));
        btncancelar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        txttotal_reserva.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, -1, -1));

        txtcliente.setBackground(new java.awt.Color(235, 227, 227));
        txtcliente.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtcliente.setForeground(new java.awt.Color(0, 0, 51));
        txttotal_reserva.add(txtcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 170, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setText("Total Reserva:");
        txttotal_reserva.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        txttotalreserva.setBackground(new java.awt.Color(235, 227, 227));
        txttotalreserva.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txttotalreserva.setForeground(new java.awt.Color(0, 0, 51));
        txttotal_reserva.add(txttotalreserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 78, -1));

        txtidhabitacion.setBackground(new java.awt.Color(235, 227, 227));
        txtidhabitacion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtidhabitacion.setForeground(new java.awt.Color(0, 0, 51));
        txtidhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhabitacionActionPerformed(evt);
            }
        });
        txttotal_reserva.add(txtidhabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 78, -1));

        txthabitacion.setBackground(new java.awt.Color(235, 227, 227));
        txthabitacion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txthabitacion.setForeground(new java.awt.Color(0, 0, 51));
        txttotal_reserva.add(txthabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 170, -1));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setText("Igv:");
        txttotal_reserva.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        txtigv.setBackground(new java.awt.Color(235, 227, 227));
        txtigv.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtigv.setForeground(new java.awt.Color(0, 0, 51));
        txtigv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtigvActionPerformed(evt);
            }
        });
        txttotal_reserva.add(txtigv, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 98, -1));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setText("Total Pago:");
        txttotal_reserva.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        txttotal_pago.setBackground(new java.awt.Color(235, 227, 227));
        txttotal_pago.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txttotal_pago.setForeground(new java.awt.Color(0, 0, 51));
        txttotal_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotal_pagoActionPerformed(evt);
            }
        });
        txttotal_reserva.add(txttotal_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 98, -1));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Emisión:");
        txttotal_reserva.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setText("Fecha Pago:");
        txttotal_reserva.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Registro de Pagos");
        txttotal_reserva.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));
        txttotal_reserva.add(dcfecha_emision, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 200, 25));
        txttotal_reserva.add(dcfecha_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 200, 25));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/fondo03.jpg"))); // NOI18N
        txttotal_reserva.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 600));

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Pagos"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablalistado.setBackground(new java.awt.Color(235, 227, 227));
        tablalistado.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tablalistado.setForeground(new java.awt.Color(0, 0, 51));
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistado);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 95, 611, 210));

        btneliminar.setBackground(new java.awt.Color(204, 255, 255));
        btneliminar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        btnsalir.setBackground(new java.awt.Color(204, 255, 255));
        btnsalir.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir1.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        lbltotalregistros.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbltotalregistros.setText("Registros");
        jPanel2.add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 321, 210, -1));

        btnImprimirComprobante.setBackground(new java.awt.Color(204, 255, 255));
        btnImprimirComprobante.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnImprimirComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/print.png"))); // NOI18N
        btnImprimirComprobante.setText("Imprimir");
        btnImprimirComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirComprobanteActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimirComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        btnImprimirComprobanteConsumo.setBackground(new java.awt.Color(204, 255, 255));
        btnImprimirComprobanteConsumo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnImprimirComprobanteConsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/print.png"))); // NOI18N
        btnImprimirComprobanteConsumo.setText("Imprimir Consumos");
        btnImprimirComprobanteConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirComprobanteConsumoActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimirComprobanteConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 200, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Consumos"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablalistadoconsumo.setBackground(new java.awt.Color(235, 227, 227));
        tablalistadoconsumo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        tablalistadoconsumo.setForeground(new java.awt.Color(0, 0, 51));
        tablalistadoconsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistadoconsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoconsumoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablalistadoconsumo);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, 610, 147));

        lbltotalregistrosconsumo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbltotalregistrosconsumo.setText("Registros");
        jPanel3.add(lbltotalregistrosconsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 170, -1));

        lbltotalconsumo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lbltotalconsumo.setText("jLabel12");
        jPanel3.add(lbltotalconsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 250, -1));

        jLabel12.setText("jLabel12");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txttotal_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(txttotal_reserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        // TODO add your handling code here:
        txtidreserva.transferFocus();
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void txtnum_comprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_comprobanteActionPerformed
        // TODO add your handling code here:
        txtnum_comprobante.transferFocus();
    }//GEN-LAST:event_txtnum_comprobanteActionPerformed

    private void cbotipo_comprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipo_comprobanteActionPerformed
        // TODO add your handling code here:
        cbotipo_comprobante.transferFocus();
    }//GEN-LAST:event_cbotipo_comprobanteActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txtigv.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el igv del Comprobante de pago a generar");
            txtigv.requestFocus();
            return;
        }
        if (txttotal_pago.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el total de pago del comprobante");
            txttotal_pago.requestFocus();
            return;
        }

        if (txtnum_comprobante.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un Número de Comprobante del Pago");
            txtnum_comprobante.requestFocus();
            return;
        }

        vpago dts = new vpago();
        fpago func = new fpago();

        dts.setIdreserva(Integer.parseInt(txtidreserva.getText()));


        int seleccionado = cbotipo_comprobante.getSelectedIndex();
        dts.setTipo_comprobante((String) cbotipo_comprobante.getItemAt(seleccionado));
        
        dts.setNum_comprobante(txtnum_comprobante.getText());
        dts.setIgv(Double.parseDouble(txtigv.getText()));
        dts.setTotal_pago(Double.parseDouble(txttotal_pago.getText()));
        
        Calendar cal;
        int d,m,a;
        
        cal=dcfecha_pago.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setFecha_pago( new Date (a,m,d));
        
        
        cal=dcfecha_emision.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setFecha_emision(new Date (a,m,d));
        
        
        

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, " El pago por $. " + txttotal_pago.getText() + 
                        " del Sr. " + txtcliente.getText() + " Ha sido realizado con Éxito");
                mostrar(idreserva);
                inhabilitar();
                
                //Desocupar la Habitación
                fhabitacion func2 = new fhabitacion();
                vhabitacion dts2 = new vhabitacion();
                
                dts2.setIdhabitacion(Integer.parseInt(txtidhabitacion.getText()));
                func2.desocupar(dts2);
                
                //Cancelar o pagar la reserva
                
                freserva func3 = new freserva();
                vreserva dts3 = new vreserva();
                
                dts3.setIdreserva(Integer.parseInt(txtidreserva.getText()));
                func3.pagar(dts3);
                
            }

        }
        else if (accion.equals("editar")){
            dts.setIdpago(Integer.parseInt(txtidpago.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El pago del Sr. " + 
                        txtcliente.getText() + " Ha sido Modificado Correctamente");
                mostrar(idreserva);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        habilitar();
        btneliminar.setEnabled(true);
        accion="editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidpago.setText(tablalistado.getValueAt(fila, 0).toString());
        //txtidreserva.setText(tablalistado.getValueAt(fila, 1).toString());
        
        cbotipo_comprobante.setSelectedItem(tablalistado.getValueAt(fila, 2).toString());
        txtnum_comprobante.setText(tablalistado.getValueAt(fila, 3).toString());
        txtigv.setText(tablalistado.getValueAt(fila, 4).toString());
        txttotal_pago.setText(tablalistado.getValueAt(fila, 5).toString());
        
        dcfecha_emision.setDate(Date.valueOf(tablalistado.getValueAt(fila, 6).toString()));
        dcfecha_pago.setDate(Date.valueOf(tablalistado.getValueAt(fila, 7).toString()));
       

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidpago.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estás seguro de Eliminar el Pago seleccionado?","Confirmar",2);

            if (confirmacion==0) {
                fpago func = new fpago ();
                vpago dts= new vpago();

                dts.setIdpago(Integer.parseInt(txtidpago.getText()));
                func.eliminar(dts);
                mostrar(idreserva);
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtidhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhabitacionActionPerformed

    private void txtigvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtigvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtigvActionPerformed

    private void txttotal_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotal_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotal_pagoActionPerformed

    private void tablalistadoconsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoconsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoconsumoMouseClicked

    private Connection connection=new conexion().conectar();
    
    
    
    private void btnImprimirComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirComprobanteActionPerformed
        
    }//GEN-LAST:event_btnImprimirComprobanteActionPerformed

    private void btnImprimirComprobanteConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirComprobanteConsumoActionPerformed
        
    }//GEN-LAST:event_btnImprimirComprobanteConsumoActionPerformed

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
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimirComprobante;
    private javax.swing.JButton btnImprimirComprobanteConsumo;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbotipo_comprobante;
    private com.toedter.calendar.JDateChooser dcfecha_emision;
    private com.toedter.calendar.JDateChooser dcfecha_pago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbltotalconsumo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JLabel lbltotalregistrosconsumo;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTable tablalistadoconsumo;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txthabitacion;
    private javax.swing.JTextField txtidhabitacion;
    private javax.swing.JTextField txtidpago;
    private javax.swing.JTextField txtidreserva;
    private javax.swing.JTextField txtigv;
    private javax.swing.JTextField txtnum_comprobante;
    private javax.swing.JTextField txttotal_pago;
    private javax.swing.JPanel txttotal_reserva;
    private javax.swing.JTextField txttotalreserva;
    // End of variables declaration//GEN-END:variables
}
