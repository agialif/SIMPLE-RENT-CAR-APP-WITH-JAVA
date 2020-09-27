/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package from;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.util.calendar.BaseCalendar;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;


/**
 *
 * @author Agi Alif
 */
public class frm_kembali extends javax.swing.JFrame {

    private Connection con;
    private Statement st;
    private ResultSet RsMobil;
    private ResultSet RsPenyewa;
    private ResultSet RsRental;
    private ResultSet RsKembali;
    private ResultSet RsM;
    private String sql="";
    private String tgl1,tgl2,idkembali,idrental,nama,namamobil,status,idpenyewa,idmobil;
    private int harga=30000,hari,total,total_rental,denda;
    
    /**
     * Creates new form frm_kembali
     */
    public frm_kembali() {
        initComponents();
        KoneksiKembali();
        TampilData(sql);
        Dc_rental.setEnabled(false);
    }
private void KoneksiKembali(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rental","root","");
        System.out.println("Connected");
        
    }catch (Exception e){
        System.out.println("Failed"+e.getMessage());
    }
}
    private void TampilData (String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No.");
        datalist.addColumn("ID RENTAL");
        datalist.addColumn("ID PENYEWA");
        datalist.addColumn("NAMA MOBIL");
        datalist.addColumn("TGL DIKEMBALIKAN");
        datalist.addColumn("LAMA (HARI)");
        datalist.addColumn("DENDA");
        datalist.addColumn("TOTAL BAYAR");
        try{
            int i=1;
            st=con.createStatement();
            RsKembali=st.executeQuery("select * from tb_pengembalian");
            while (RsKembali.next())
                datalist.addRow(new Object[]{
                    (""+i++),
                     RsKembali.getString(2),RsKembali.getString(3),
                    RsKembali.getString(4),RsKembali.getString(6),
                    RsKembali.getString(7),RsKembali.getString(10),RsKembali.getString(8)
                });
            TABEL.setModel(datalist);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }

    private void bersih(){

        Cmb_kembali.setSelectedItem("PILIH");
        Txt_id.setText("");
        Txt_nama.setText("");
        Txt_id_mobil.setText("");
        Txt_nama_mobil.setText("");
        Txt_lama.setText("");
        Txt_total.setText("");
        Cmb_id_rental.setSelectedItem("");
        Txt_harga_rental.setText("");
        Txt_status.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Txt_lama = new javax.swing.JTextField();
        Txt_total = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Txt_harga_rental = new javax.swing.JTextField();
        Dc_rental = new com.toedter.calendar.JDateChooser();
        Dc_kembali = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BTN_CANCEL = new javax.swing.JButton();
        BTN_EDIT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL = new javax.swing.JTable();
        BTN_HOME = new javax.swing.JButton();
        Cmb_kembali = new javax.swing.JComboBox();
        Cmb_id_rental = new javax.swing.JComboBox();
        Txt_id = new javax.swing.JTextField();
        Txt_nama = new javax.swing.JTextField();
        Txt_id_mobil = new javax.swing.JTextField();
        Txt_nama_mobil = new javax.swing.JTextField();
        Txt_status = new javax.swing.JTextField();
        Txt_total_rental = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(915, 516));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID MOBIL");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NAMA");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NAMA MOBIL");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID RENTAL");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRANSAKSI");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID PENYEWA");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TOTAL BAYAR");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("STATUS");

        Txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_totalActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("HARGA RENTAL/hari");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TANGGAL RENTAL");

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TANGGAL KEMBALI");

        Dc_rental.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Dc_rentalPropertyChange(evt);
            }
        });

        Dc_kembali.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Dc_kembaliPropertyChange(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DENDA");

        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BTN_CANCEL.setText("CANCEL");
        BTN_CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CANCELActionPerformed(evt);
            }
        });

        BTN_EDIT.setText("EDIT");
        BTN_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EDITActionPerformed(evt);
            }
        });

        TABEL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PENGEMBALIAN", "ID RENTAL", "ID PENYEWA", "NAMA MOBIL", "TANGGAL KEMBALI", "LAMA", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(TABEL);

        BTN_HOME.setText("HOME");
        BTN_HOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_HOMEActionPerformed(evt);
            }
        });

        Cmb_kembali.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "KEMBALI", " " }));
        Cmb_kembali.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cmb_kembaliItemStateChanged(evt);
            }
        });
        Cmb_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_kembaliActionPerformed(evt);
            }
        });

        Cmb_id_rental.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", " " }));
        Cmb_id_rental.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cmb_id_rentalItemStateChanged(evt);
            }
        });
        Cmb_id_rental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_id_rentalActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("BIAYA RENTAL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jButton1)
                        .addGap(89, 89, 89)
                        .addComponent(BTN_EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(BTN_CANCEL)
                        .addGap(90, 90, 90)
                        .addComponent(jButton2)
                        .addGap(74, 74, 74)
                        .addComponent(BTN_HOME, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Cmb_kembali, 0, 121, Short.MAX_VALUE)
                                    .addComponent(Cmb_id_rental, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(33, 33, 33)))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Dc_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Dc_rental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Txt_harga_rental, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(Txt_status))
                            .addComponent(Txt_lama, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Txt_nama_mobil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(Txt_id_mobil, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_nama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_id, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Txt_total_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGap(140, 140, 140))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cmb_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cmb_id_rental, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_id_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_nama_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Txt_harga_rental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Dc_rental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Dc_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_total_rental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_lama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_HOME)
                    .addComponent(BTN_EDIT)
                    .addComponent(BTN_CANCEL)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cmb_id_rentalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_id_rentalActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_Cmb_id_rentalActionPerformed

    private void Cmb_id_rentalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cmb_id_rentalItemStateChanged
        try{
            sql="select * from tb_rental where id_rental='"+Cmb_id_rental.getSelectedItem()+"'";
            st=con.createStatement();
            RsRental=st.executeQuery(sql);
            while (RsRental.next()){
                Txt_id_mobil.setText(RsRental.getString("id_mobil"));
                Txt_nama_mobil.setText(RsRental.getString("nama_mobil"));
                Txt_id.setText(RsRental.getString("id_penyewa"));
                Txt_nama.setText(RsRental.getString("nama_penyewa"));
                Dc_rental.setDate((RsRental.getDate(8)));
                Txt_harga_rental.setText(RsRental.getString("harga_rental"));
                Txt_status.setText(RsRental.getString("status"));
                Txt_total_rental.setText(RsRental.getString("total"));
            }
        }catch (Exception e){

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Cmb_id_rentalItemStateChanged

    private void Cmb_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_kembaliActionPerformed
        if(Cmb_kembali.getSelectedItem()=="KEMBALI"){
            Cmb_id_rental.removeAllItems();
            Cmb_id_rental.addItem("PILIH");
            try{
                status=String.valueOf(Cmb_kembali.getSelectedItem());
                status="SEWA";
                String sql = "select * from tb_rental where status = '"+status+"'";
                Statement st = con.createStatement();
                RsRental=st.executeQuery(sql);
                while (RsRental.next()){
                    String Aliaskd = RsRental.getString("id_rental");
                    Cmb_id_rental.addItem(Aliaskd);
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Id Rental : Error"+e.getMessage());
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Cmb_kembaliActionPerformed

    private void Cmb_kembaliItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cmb_kembaliItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_Cmb_kembaliItemStateChanged

    private void BTN_HOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_HOMEActionPerformed
        main_menu m=new main_menu();
        m.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_HOMEActionPerformed

    private void BTN_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EDITActionPerformed

        idrental=Cmb_id_rental.getItemAt(Cmb_id_rental.getSelectedIndex()).toString();
        idmobil=String.valueOf(Txt_id_mobil.getText());
        namamobil=String.valueOf(Txt_nama_mobil.getText());
        idpenyewa=String.valueOf(Txt_id.getText());
        nama=String.valueOf(Txt_nama.getText());
        harga=Integer.parseInt(Txt_harga_rental.getText());
        hari=Integer.parseInt(Txt_lama.getText());
        total=Integer.parseInt(Txt_total.getText());
        status=Cmb_kembali.getItemAt(Cmb_kembali.getSelectedIndex()).toString();
        try{
            sql="update tb_pengembalian set tgl_kembali='"+tgl2+"',lama='"+hari+"',total_bayar='"+total+"',status='"+status+"'";
            st=con.createStatement();
            st.execute(sql);
            bersih();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Sudah Diedit");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error : Failed To Edit"+e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_EDITActionPerformed

    private void BTN_CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CANCELActionPerformed
        bersih();
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_CANCELActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        idrental=Cmb_id_rental.getItemAt(Cmb_id_rental.getSelectedIndex()).toString();
        idmobil=String.valueOf(Txt_id_mobil.getText());
        idpenyewa=String.valueOf(Txt_id.getText());
        nama=String.valueOf(Txt_nama.getText());
        namamobil=String.valueOf(Txt_nama_mobil.getText());
        harga=Integer.parseInt(Txt_harga_rental.getText());
        hari=Integer.parseInt(Txt_lama.getText());
        total=Integer.parseInt(Txt_total.getText());
        status=Cmb_kembali.getItemAt(Cmb_kembali.getSelectedIndex()).toString();
        if(Cmb_kembali.getSelectedItem().equals("SELESAI")){
            JOptionPane.showMessageDialog(null, " MOBIL TELAH DIKEMBALIKKAN");
            bersih();
        }
        else if (Txt_id.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Error : Id is Empty");
        }
        else{
            try{
                sql="insert into tb_pengembalian(id_pengembalian, id_rental,id_mobil,id_penyewa,tgl_rental, tgl_kembali,lama,total_bayar,status,denda)value"
                +"('"+idkembali+"','"+idrental+"','"+idmobil+"','"+idpenyewa+"','"+tgl1+"','"+tgl2+"','"+hari+"','"+total+"','"+status+"','"+denda+"')";
                st=con.createStatement();
                st.execute(sql);
                bersih();
                TampilData(sql);
                JOptionPane.showMessageDialog(null,"Data Tersimpan");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error : Failed to Save"+e.getMessage());
            }
            try{
                String sql="select * from tb_mobil";
                Statement st=con.createStatement();
                RsMobil=st.executeQuery(sql);
                status="READY";
                sql="update tb_mobil set status = '"+status+"' where id_mobil = '"+idmobil+"'";
                st=con.createStatement();
                st.execute(sql);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
            }
            try{
                status = "SELESAI";
                sql="update tb_rental set status = '"+status+"' where id_rental = '"+idrental+"'";
                st=con.createStatement();
                st.execute(sql);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Dc_kembaliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Dc_kembaliPropertyChange
        if(Dc_kembali.getDate()!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            tgl2=format.format(Dc_kembali.getDate());
        }
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date pinjam = Dc_rental.getDate();
            Date kembali_a = Dc_kembali.getDate();
            long pinjam1 = pinjam.getTime();
            long kembali_b = kembali_a.getTime();
            long diff = kembali_b-pinjam1;
            long lama = diff/(24*60*60*1000);
            Txt_lama.setText(Long.toString(lama));
           
            hari=Integer.parseInt(Txt_lama.getText());
            total_rental=Integer.parseInt(Txt_total_rental.getText());
            denda=harga*hari;
            total=denda+total_rental;
            Txt_total.setText(String.valueOf(total));
        }catch (Exception e){

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Dc_kembaliPropertyChange

    private void Dc_rentalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Dc_rentalPropertyChange
        if(Dc_rental.getDate()!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            tgl1=format.format(Dc_rental.getDate());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_Dc_rentalPropertyChange

    private void Txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_totalActionPerformed

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
            java.util.logging.Logger.getLogger(frm_kembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_kembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_kembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_kembali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_kembali().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CANCEL;
    private javax.swing.JButton BTN_EDIT;
    private javax.swing.JButton BTN_HOME;
    private javax.swing.JComboBox Cmb_id_rental;
    private javax.swing.JComboBox Cmb_kembali;
    private com.toedter.calendar.JDateChooser Dc_kembali;
    private com.toedter.calendar.JDateChooser Dc_rental;
    private javax.swing.JTable TABEL;
    private javax.swing.JTextField Txt_harga_rental;
    private javax.swing.JTextField Txt_id;
    private javax.swing.JTextField Txt_id_mobil;
    private javax.swing.JTextField Txt_lama;
    private javax.swing.JTextField Txt_nama;
    private javax.swing.JTextField Txt_nama_mobil;
    private javax.swing.JTextField Txt_status;
    private javax.swing.JTextField Txt_total;
    private javax.swing.JTextField Txt_total_rental;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
