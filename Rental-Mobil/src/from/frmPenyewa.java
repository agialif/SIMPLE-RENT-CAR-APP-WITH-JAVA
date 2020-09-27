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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Agi Alif
 */
public class frmPenyewa extends javax.swing.JFrame {
   private Connection con;
   private Statement st;
   private ResultSet RsPenyewa;
   private String sql="";
   
   private String id,nama,alamat,hp,ktp,status;
    /**
     * Creates new form frmPenyewa
     */
    public frmPenyewa() {
       initComponents();
        KoneksiPenyewa();
        TampilData(sql);
    }
    private void KoneksiPenyewa(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_rental","root","");
            System.out.println("Koneksi Berhasil");
        }catch (Exception e){
            System.out.println("Koneksi Gagal \n"+e.getMessage());
        }
    
    } 
    private void TampilData (String sql){
        DefaultTableModel datalist = new DefaultTableModel();
        datalist.addColumn("No");
        datalist.addColumn("ID");
        datalist.addColumn("NAMA");
        datalist.addColumn("ALAMAT");
        datalist.addColumn("NO. HP");
        datalist.addColumn("NO. KTP");
        datalist.addColumn("STATUS");
        try{
            int i=1;
            st=con.createStatement();
            RsPenyewa=st.executeQuery("select * from tb_penyewa");
            while (RsPenyewa.next())
                datalist.addRow(new Object[]{
                    (""+i++),
                    RsPenyewa.getString(1),RsPenyewa.getString(2),
                    RsPenyewa.getString(3),RsPenyewa.getString(4),
                    RsPenyewa.getString(5),RsPenyewa.getString(6)
                    
                });
            TABEL2.setModel(datalist);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Tampil \n"+e.getMessage());
        }
    }
    private void bersih(){
        Txt_id.setText("");
        Txt_nama.setText("");
        Txt_alamat.setText("");
        Txt_hp.setText("");
        Txt_ktp.setText("");
        Cmb_status.setSelectedItem("PILIH");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Txt_id = new javax.swing.JTextField();
        Txt_nama = new javax.swing.JTextField();
        Txt_alamat = new javax.swing.JTextField();
        Txt_hp = new javax.swing.JTextField();
        Txt_ktp = new javax.swing.JTextField();
        BTN_SIMPAN = new javax.swing.JButton();
        BTN_HAPUS = new javax.swing.JButton();
        BTN_BATAL = new javax.swing.JButton();
        BTN_EDIT = new javax.swing.JButton();
        Cmb_status = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABEL2 = new javax.swing.JTable();
        BTN_HOME = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(44, 226, 226));
        jPanel1.setPreferredSize(new java.awt.Dimension(915, 516));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID PENYEWA");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAMA");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ALAMAT");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("No. HP");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No. KTP");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("STATUS");

        Txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_idActionPerformed(evt);
            }
        });
        Txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Txt_idKeyPressed(evt);
            }
        });

        BTN_SIMPAN.setText("SAVE");
        BTN_SIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SIMPANActionPerformed(evt);
            }
        });

        BTN_HAPUS.setText("DELETE");
        BTN_HAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_HAPUSActionPerformed(evt);
            }
        });

        BTN_BATAL.setText("CANCEL");
        BTN_BATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BATALActionPerformed(evt);
            }
        });

        BTN_EDIT.setText("EDIT");
        BTN_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EDITActionPerformed(evt);
            }
        });

        Cmb_status.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        Cmb_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PILIH", "READY", "SUDAH MENYEWA" }));

        TABEL2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "NAMA", "ALAMAT", "No. HP", "Np. KTP", "STATUS"
            }
        ));
        jScrollPane2.setViewportView(TABEL2);

        BTN_HOME.setText("HOME");
        BTN_HOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_HOMEActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/from/Webp.net-resizeimage (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                        .addComponent(Txt_nama)
                                        .addComponent(Txt_alamat)
                                        .addComponent(Txt_hp)
                                        .addComponent(Txt_ktp))
                                    .addComponent(Cmb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(133, 133, 133)
                                .addComponent(jLabel7)))
                        .addGap(98, 98, 98)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(BTN_SIMPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(BTN_EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(BTN_BATAL)
                .addGap(103, 103, 103)
                .addComponent(BTN_HAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_HOME, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_hp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cmb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_HOME)
                    .addComponent(BTN_HAPUS)
                    .addComponent(BTN_BATAL)
                    .addComponent(BTN_EDIT)
                    .addComponent(BTN_SIMPAN))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_idActionPerformed

    private void BTN_SIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SIMPANActionPerformed
    id=String.valueOf(Txt_id.getText());
    nama=String.valueOf(Txt_nama.getText());
    alamat=String.valueOf(Txt_alamat.getText());
    hp=String.valueOf(Txt_hp.getText());
    ktp=String.valueOf(Txt_ktp.getText());
    status=String.valueOf(Cmb_status.getSelectedItem());
    if(Cmb_status.getSelectedItem().equals("PILIH")){
        JOptionPane.showMessageDialog(null, "Silahkan Pilih Status");
    }
    else if(Cmb_status.getSelectedItem().equals("SUDAH MENYEWA")){
        JOptionPane.showMessageDialog(null, "Maaf Penyewa Sedang Merental");
    }else {
        try{
            sql="INSERT INTO tb_penyewa(id_penyewa,nama_penyewa, "
                    + "alamat, no_hp, no_ktp,  status)value"
                    + "('"+ id +"','"+ nama +"','"+ alamat +"','"+ hp +"',"
                    + "'"+ ktp +"','"+ status +"')";
            st=con.createStatement();
            st.execute(sql);
            bersih();
            TampilData(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan ");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n"+e.getMessage());
        }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_SIMPANActionPerformed

    private void Txt_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_idKeyPressed
    id=Txt_id.getText();
    int pressEnter=evt.getKeyCode();
    if(pressEnter==10){
        try{
            sql="select * from tb_penyewa where id_penyewa='"+ id +"'";
            st=con.createStatement();
            RsPenyewa=st.executeQuery(sql);
            while (RsPenyewa.next()){
                Txt_nama.setText(RsPenyewa.getString("nama_penyewa"));
                Txt_alamat.setText(RsPenyewa.getString(3));
                Txt_hp.setText(RsPenyewa.getString(4));
                Txt_ktp.setText(RsPenyewa.getString(5));
                Cmb_status.setSelectedItem(RsPenyewa.getString(6));
                JOptionPane.showMessageDialog(null, "Data Ditemukan");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan \n"+e.getMessage());
        }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_idKeyPressed

    private void BTN_BATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BATALActionPerformed
    bersih();
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_BATALActionPerformed

    private void BTN_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EDITActionPerformed
    id=String.valueOf(Txt_id.getText());
    nama=String.valueOf(Txt_nama.getText());
    alamat=String.valueOf(Txt_alamat.getText());
    hp=String.valueOf(Txt_hp.getText());
    ktp=String.valueOf(Txt_ktp.getText());
    status=String.valueOf(Cmb_status.getSelectedItem());
    try{
        sql="update tb_penyewa SET nama_penyewa='"+ nama+"',"
                + "alamat='"+alamat+"',no_hp='"+hp+"',"
                + "no_ktp='"+ktp+"',status='"+status+"'"
                + "where id_penyewa='"+id+"'";
                st=con.createStatement();
                st.executeUpdate(sql);
                bersih();
                TampilData(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil DiUpdtae");
;    }catch (Exception e){
    JOptionPane.showMessageDialog(null, "Data Tidak Dapat DI Update"+e.getMessage());
}
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_EDITActionPerformed

    private void BTN_HAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_HAPUSActionPerformed
    id=String.valueOf(Txt_id.getText());
    try{
        sql="delete from tb_penyewa where id_penyewa='"+id+"'";
        st=con.createStatement();
        st.execute(sql);
        bersih();
        TampilData(sql);
        JOptionPane.showMessageDialog(null,"Data BErhasil Dihapus");
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Data Tidak Dapat DIhapus"+e.getMessage());
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_HAPUSActionPerformed

    private void BTN_HOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_HOMEActionPerformed
    main_menu m=new main_menu();
    m.setVisible(true);
    dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_HOMEActionPerformed

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
            java.util.logging.Logger.getLogger(frmPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPenyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPenyewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_BATAL;
    private javax.swing.JButton BTN_EDIT;
    private javax.swing.JButton BTN_HAPUS;
    private javax.swing.JButton BTN_HOME;
    private javax.swing.JButton BTN_SIMPAN;
    private javax.swing.JComboBox Cmb_status;
    private javax.swing.JTable TABEL2;
    private javax.swing.JTextField Txt_alamat;
    private javax.swing.JTextField Txt_hp;
    private javax.swing.JTextField Txt_id;
    private javax.swing.JTextField Txt_ktp;
    private javax.swing.JTextField Txt_nama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}