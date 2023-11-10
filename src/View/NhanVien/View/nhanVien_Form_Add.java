/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.NhanVien.View;

import Model.nhanVien_Model;
import View.NhanVien.Data.nhanVien_data_DAO;
import com.pro1041.util.DateHelper;
import com.pro1041.util.checkNhanVien;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;

import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import javax.swing.border.LineBorder;

/**
 *
 * @author hnhut
 */
/*
  private String maNhanVien, hoVaTen, matKhau;
    private Boolean chucVu, gioiTinh;
    private Date ngaySinh;
    private String canCuocCongDan, soDienThoai, hinhAnh;
 */
public class nhanVien_Form_Add extends javax.swing.JFrame {
//    nhanVien_Model user = new ShareHelper().getAccount();
    private nhanVien_InternalForm form;
    
    static String message = "";
    static boolean isTrue = true;
    static String MessageError = "";
    nhanVien_Model nvInsert = new nhanVien_Model();
    static nhanVien_data_DAO nvDao = new nhanVien_data_DAO();

    /**
     * Creates new form nhanVien_addForm
     */
    public nhanVien_Form_Add(nhanVien_InternalForm form) {
        initComponents();
        this.form = form;
        nhanVien_Model user = new nhanVien_Model();
        nhanVien_lb_nameManager.setText(user.getHoVaTen());

        nhanVien_txt_maNV.setText(generateRandomString());
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void update() {
        form.update();
    }
    
   
    

    public nhanVien_Model Nv_getForm() {
        String maNhanVien = nhanVien_txt_maNV.getText();
        String hovaTen = nhanVien_txt_hovaTen.getText();
        boolean chucVu = nhanVien_cbb_chucVu.getSelectedItem().toString().equalsIgnoreCase("Quản lý") ? true : false;
        boolean gioiTinh = nhanVien_rdo_Male.isSelected() ? true : false;

        try {
            String dateString = nhanVien_txt_Date.getText();
            Date parseDate = DateHelper.toDate(dateString, "MM/dd/yyyy");
            java.sql.Date ngaySinh = new java.sql.Date(parseDate.getTime());
            String canCuocCongDan = nhanVien_txt_CCCD.getText();
            nvInsert = new nhanVien_Model(maNhanVien, hovaTen, null, chucVu, gioiTinh, ngaySinh,null, canCuocCongDan, null, null);
        } catch (ParseException ex) {
            Logger.getLogger(nhanVien_Form_Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
  

    public void checkNull() {
        Nv_getForm();
        if (nhanVien_txt_hovaTen.getText().trim().isEmpty()) {
            nhanVien_txt_hovaTen.setBorder(new LineBorder(Color.red));
            isTrue = false;
        }
        else if (!checkNhanVien.kiemTraHoTen(nhanVien_txt_hovaTen.getText())) {
            nhanVien_txt_hovaTen.setText("$Họ và tên không đúng định dạng!");
            isTrue = false;
        };
        if (nhanVien_txt_CCCD.getText().trim().isEmpty()) {
            nhanVien_txt_CCCD.setBorder(new LineBorder(Color.red));
            isTrue = false;
        }
        else if (checkNhanVien.kiemTraDinhDangCCCD(nhanVien_txt_CCCD.getText())) {
            nhanVien_txt_CCCD.setText("\n$Căn cước công dân không đúng định dạng");
            isTrue = false;
        }
        if (!nhanVien_ck_agree.isSelected()) {
            errorMessage_agree.setText("Xin lỗi, bạn phải đồng ý với điều khoản của chúng tôi");
            isTrue = false;
        }
        if (DateHelper.calculateAge(nvInsert.getNgaySinh().getYear(), nvInsert.getNgaySinh().getMonth(), nvInsert.getNgaySinh().getDate()) < 15) {
            errorMessage_ngaySinh.setText("Bạn chưa đủ tuổi yêu cầu (age>=15)");
            isTrue = false;
        }
    }
    
    public void checkFormat() {
        MessageError = "";
        
        
    }

    public static String generateRandomString() {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        StringBuilder randomString = new StringBuilder();

        Random random = new Random();

        // Sinh ngẫu nhiên 3 chữ
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(letters.length());
            char randomChar = letters.charAt(randomIndex);
            randomString.append(randomChar);
        }

        // Sinh ngẫu nhiên 3 số
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(numbers.length());
            char randomDigit = numbers.charAt(randomIndex);
            randomString.append(randomDigit);
        }

        return randomString.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nhanVien_group_gioiTinh = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nhanVien_txt_maNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nhanVien_txt_Date = new com.pro1041.datechooser.DateTextField();
        nhanVien_rdo_Male = new javax.swing.JRadioButton();
        nhanVien_txt_Female = new javax.swing.JRadioButton();
        nhanVien_cbb_chucVu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        nhanVien_ck_agree = new javax.swing.JCheckBox();
        nhanVien_btn_Add = new javax.swing.JButton();
        nhanVien_lb_nameManager = new javax.swing.JLabel();
        errorMessage_ngaySinh = new javax.swing.JLabel();
        errorMessage_agree = new javax.swing.JLabel();
        nhanVien_txt_hovaTen = new javax.swing.JTextField();
        nhanVien_txt_CCCD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 0));
        jLabel5.setText("Thêm nhân viên");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel1.setText("Trở lại");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 17)); // NOI18N
        jLabel2.setText("Điền thông tin");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Mã nhân viên");

        nhanVien_txt_maNV.setBackground(new java.awt.Color(0, 0, 0));
        nhanVien_txt_maNV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        nhanVien_txt_maNV.setForeground(new java.awt.Color(255, 255, 255));
        nhanVien_txt_maNV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nhanVien_txt_maNV.setEnabled(false);
        nhanVien_txt_maNV.setMargin(new java.awt.Insets(6, 10, 6, 10));
        nhanVien_txt_maNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVien_txt_maNVActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Họ và tên");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Chức vụ");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Giới tính");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Ngày sinh");

        nhanVien_txt_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhanVien_txt_DateMouseClicked(evt);
            }
        });
        nhanVien_txt_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVien_txt_DateActionPerformed(evt);
            }
        });

        nhanVien_group_gioiTinh.add(nhanVien_rdo_Male);
        nhanVien_rdo_Male.setSelected(true);
        nhanVien_rdo_Male.setText("Nam");

        nhanVien_group_gioiTinh.add(nhanVien_txt_Female);
        nhanVien_txt_Female.setText("Nữ");

        nhanVien_cbb_chucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản lý" }));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Căn cước công dân");

        nhanVien_ck_agree.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        nhanVien_ck_agree.setText("Đồng ý với các điều khoản và quy định của chúng tôi");
        nhanVien_ck_agree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVien_ck_agreeActionPerformed(evt);
            }
        });

        nhanVien_btn_Add.setBackground(new java.awt.Color(51, 51, 51));
        nhanVien_btn_Add.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        nhanVien_btn_Add.setForeground(new java.awt.Color(255, 255, 255));
        nhanVien_btn_Add.setText("Tạo mới");
        nhanVien_btn_Add.setOpaque(true);
        nhanVien_btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVien_btn_AddActionPerformed(evt);
            }
        });

        nhanVien_lb_nameManager.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nhanVien_lb_nameManager.setForeground(new java.awt.Color(255, 0, 0));
        nhanVien_lb_nameManager.setText("Name Manager");

        errorMessage_ngaySinh.setForeground(new java.awt.Color(0, 102, 102));

        errorMessage_agree.setForeground(new java.awt.Color(0, 102, 102));

        nhanVien_txt_hovaTen.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        nhanVien_txt_hovaTen.setMargin(new java.awt.Insets(0, 6, 0, 6));
        nhanVien_txt_hovaTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhanVien_txt_hovaTenMouseClicked(evt);
            }
        });
        nhanVien_txt_hovaTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVien_txt_hovaTenActionPerformed(evt);
            }
        });

        nhanVien_txt_CCCD.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        nhanVien_txt_CCCD.setMargin(new java.awt.Insets(0, 6, 0, 6));
        nhanVien_txt_CCCD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhanVien_txt_CCCDMouseClicked(evt);
            }
        });
        nhanVien_txt_CCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVien_txt_CCCDActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nhanVien_ck_agree)
                    .addComponent(nhanVien_btn_Add))
                .addContainerGap(231, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(148, 148, 148)
                                        .addComponent(nhanVien_txt_CCCD))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nhanVien_txt_maNV)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(nhanVien_txt_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(errorMessage_ngaySinh))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(nhanVien_rdo_Male, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(nhanVien_txt_Female, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(nhanVien_cbb_chucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(nhanVien_txt_hovaTen)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nhanVien_lb_nameManager))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(errorMessage_agree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nhanVien_lb_nameManager))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(nhanVien_txt_maNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nhanVien_txt_hovaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nhanVien_cbb_chucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nhanVien_rdo_Male)
                            .addComponent(nhanVien_txt_Female)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nhanVien_txt_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(errorMessage_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(nhanVien_txt_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(nhanVien_ck_agree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorMessage_agree, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nhanVien_btn_Add)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nhanVien_txt_maNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVien_txt_maNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhanVien_txt_maNVActionPerformed

    private void nhanVien_txt_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVien_txt_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhanVien_txt_DateActionPerformed

    private void nhanVien_btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVien_btn_AddActionPerformed
        // TODO add your handling code here:
        isTrue = true;
        checkNull();
        checkFormat();
        if (isTrue) {
            System.out.println("Login thành công");
            nvInsert.setMatKhau("1");
            nvDao.insert(nvInsert);
            update();
        }
        
    }//GEN-LAST:event_nhanVien_btn_AddActionPerformed

    private void nhanVien_ck_agreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVien_ck_agreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhanVien_ck_agreeActionPerformed

    private void nhanVien_txt_DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhanVien_txt_DateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nhanVien_txt_DateMouseClicked

    private void nhanVien_txt_hovaTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhanVien_txt_hovaTenMouseClicked
        // TODO add your handling code here:
        if (nhanVien_txt_hovaTen.getText().startsWith("$")) {
            nhanVien_txt_hovaTen.setText("");
        }
        nhanVien_txt_hovaTen.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_nhanVien_txt_hovaTenMouseClicked

    private void nhanVien_txt_CCCDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhanVien_txt_CCCDMouseClicked
        // TODO add your handling code here:
        if (nhanVien_txt_CCCD.getText().startsWith("$")) {
            nhanVien_txt_CCCD.setText("");
        }
        nhanVien_txt_hovaTen.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_nhanVien_txt_CCCDMouseClicked

    private void nhanVien_txt_CCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVien_txt_CCCDActionPerformed
        // TODO add your handling code here:
                nhanVien_txt_CCCD.setBorder(new LineBorder(Color.white));
    }//GEN-LAST:event_nhanVien_txt_CCCDActionPerformed

    private void nhanVien_txt_hovaTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVien_txt_hovaTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhanVien_txt_hovaTenActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // Khởi tạo JavaFX Toolkit
//
//        // Khởi chạy ứng dụng Swing trong luồng giao diện người dùng JavaFX
//        javax.swing.SwingUtilities.invokeLater(() -> {
//            // Tạo và hiển thị JFrame Swing của bạn ở đây
//            JFrame frame = new nhanVien_From_Add();
//            frame.setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorMessage_agree;
    private javax.swing.JLabel errorMessage_ngaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton nhanVien_btn_Add;
    private javax.swing.JComboBox<String> nhanVien_cbb_chucVu;
    private javax.swing.JCheckBox nhanVien_ck_agree;
    private javax.swing.ButtonGroup nhanVien_group_gioiTinh;
    private javax.swing.JLabel nhanVien_lb_nameManager;
    private javax.swing.JRadioButton nhanVien_rdo_Male;
    private javax.swing.JTextField nhanVien_txt_CCCD;
    private com.pro1041.datechooser.DateTextField nhanVien_txt_Date;
    private javax.swing.JRadioButton nhanVien_txt_Female;
    private javax.swing.JTextField nhanVien_txt_hovaTen;
    private javax.swing.JTextField nhanVien_txt_maNV;
    // End of variables declaration//GEN-END:variables
}
