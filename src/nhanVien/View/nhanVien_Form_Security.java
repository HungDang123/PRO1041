/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nhanVien.View;

import Model.nhanVien;
import nhanVien.Controller.ActionListener_btnSecurity;
import nhanVien.Controller.SecurityChecker;
import nhanVien.Controller.UI_nhanVien;
import nhanVien.Controller.Security_changeData;
import nhanVien.Controller.Security_removeData;
import nhanVien.data.checkNhanVien;
import nhanVien.data.nhanVien_data_DAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author hnhut
 */
public class nhanVien_Form_Security extends javax.swing.JFrame {

    /**
     * Creates new form nhanVien_From_fillMore
     */
    private NhanVienCard nvCard;
    private nhanVien nv;
    static int Value = 100;
    private StringBuilder Status = new StringBuilder();

    public nhanVien_Form_Security(NhanVienCard nvCard) {
        initComponents();
        this.nvCard = nvCard;
        this.nv = this.nvCard.getNhanVienInstance();
        // Sự Kiện
        Security_txt_pw.addMouseListener(UI_nhanVien.getAction(Color.RED, Color.BLACK, Security_txt_pw, lb_pw));
        Security_txt_cccd.addMouseListener(UI_nhanVien.getAction(Color.RED, Color.BLACK, Security_txt_cccd, lb_cccd));
        Security_txt_email.addMouseListener(UI_nhanVien.getAction(Color.RED, Color.BLACK, Security_txt_email, lb_email));
        Security_txt_sdt.addMouseListener(UI_nhanVien.getAction(Color.RED, Color.BLACK, Security_txt_sdt, lb_sdt));

        setForm();

        setAction_change();
        setAction_remove();
//        levelSecurity();
        
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {                    
//                    levelSecurity();
//                }
//            }
//        }).start();
    }

    public void setAction_change() {
        changePw.addActionListener(new Security_changeData(Security_txt_pw, "Password", nv.getMaNhanVien(), nvCard));
        changeEmail.addActionListener(new Security_changeData(Security_txt_email, "Email", nv.getMaNhanVien(), nvCard));
        changeCccd.addActionListener(new Security_changeData(Security_txt_cccd, "Căn cước công dân", nv.getMaNhanVien(), nvCard));
        changeSdt.addActionListener(new Security_changeData(Security_txt_sdt, "Số điện thoại", nv.getMaNhanVien(), nvCard));
    }

    public void setAction_remove() {
        deleteCccd.addActionListener(new Security_removeData(Security_txt_cccd, "Căn cước công dân", nv.getMaNhanVien(), nvCard));
        deleteEmail.addActionListener(new Security_removeData(Security_txt_email, "Email", nv.getMaNhanVien(), nvCard));
        deletePw.addActionListener(new Security_removeData(Security_txt_pw, "Password", nv.getMaNhanVien(), nvCard));
        deleteSdt.addActionListener(new Security_removeData(Security_txt_sdt, "Số điện thoại", nv.getMaNhanVien(), nvCard));
    }

    public void setForm() {
        Security_txt_cccd.setText(nv.getCanCuocCongDan() == null ? "Chưa có thông tin" : nv.getCanCuocCongDan());
        Security_txt_email.setText(nv.getEmail()== null ? "Chưa có thông tin" : nv.getEmail());
        Security_txt_pw.setText(nv.getMatKhau() == null ? "Chưa có thông tin" : nv.getMatKhau());
        Security_txt_sdt.setText(nv.getSoDienThoai() == null ? "Chưa có thông tin" : nv.getSoDienThoai());
    }

    public void levelSecurity() {
        int crValue = nhanVien_Progress_perentLevel.getValue();
        int tgValue = SecurityChecker.checkSecurity(Security_txt_pw.getText(), Security_txt_sdt.getText(), Security_txt_email.getText(), Security_txt_cccd.getText());
             while (crValue != tgValue) {
            if (crValue < tgValue) {
                crValue++;
            } else {
                crValue--;
            }

            nhanVien_Progress_perentLevel.setValue(crValue);

            // Thêm đoạn ngủ giữa các bước nếu bạn muốn giảm tốc độ của thanh tiến trình
            try {
                Thread.sleep(50); // Thời gian nghỉ giữa các bước (đơn vị: mili giây)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_pw = new javax.swing.JLabel();
        lb_sdt = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        lb_cccd = new javax.swing.JLabel();
        Security_txt_pw = new javax.swing.JTextField();
        Security_txt_sdt = new javax.swing.JTextField();
        Security_txt_email = new javax.swing.JTextField();
        Security_txt_cccd = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        panel_Security = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        nhanVien_container_error = new javax.swing.JPanel();
        nhanVien_Progress_perentLevel = new javax.swing.JProgressBar();
        changePw = new javax.swing.JButton();
        deletePw = new javax.swing.JButton();
        changeSdt = new javax.swing.JButton();
        deleteSdt = new javax.swing.JButton();
        changeEmail = new javax.swing.JButton();
        deleteEmail = new javax.swing.JButton();
        changeCccd = new javax.swing.JButton();
        deleteCccd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Tăng Cường Bảo Mật");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Bảo mật");

        lb_pw.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lb_pw.setText("Mật khẩu");

        lb_sdt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lb_sdt.setText("Số điện thoại");

        lb_email.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lb_email.setText("Email");

        lb_cccd.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lb_cccd.setText("Số căn cước công dân");

        Security_txt_pw.setEditable(false);
        Security_txt_pw.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Security_txt_pw.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Security_txt_pw.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Security_txt_pwCaretUpdate(evt);
            }
        });

        Security_txt_sdt.setEditable(false);
        Security_txt_sdt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Security_txt_sdt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Security_txt_sdt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Security_txt_sdtCaretUpdate(evt);
            }
        });

        Security_txt_email.setEditable(false);
        Security_txt_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Security_txt_email.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Security_txt_email.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Security_txt_emailCaretUpdate(evt);
            }
        });

        Security_txt_cccd.setEditable(false);
        Security_txt_cccd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Security_txt_cccd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Security_txt_cccd.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                Security_txt_cccdCaretUpdate(evt);
            }
        });
        Security_txt_cccd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Security_txt_cccdFocusLost(evt);
            }
        });
        Security_txt_cccd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Security_txt_cccdActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(255, 102, 102));

        panel_Security.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mức độ bảo mật");

        nhanVien_container_error.setLayout(new java.awt.BorderLayout());

        nhanVien_Progress_perentLevel.setValue(100);
        nhanVien_Progress_perentLevel.setStringPainted(true);

        javax.swing.GroupLayout panel_SecurityLayout = new javax.swing.GroupLayout(panel_Security);
        panel_Security.setLayout(panel_SecurityLayout);
        panel_SecurityLayout.setHorizontalGroup(
            panel_SecurityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SecurityLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_SecurityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nhanVien_container_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_SecurityLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nhanVien_Progress_perentLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_SecurityLayout.setVerticalGroup(
            panel_SecurityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SecurityLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nhanVien_Progress_perentLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nhanVien_container_error, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );

        changePw.setText("Thay đổi");

        deletePw.setText("Xóa");
        deletePw.setEnabled(false);

        changeSdt.setText("Thay đổi");

        deleteSdt.setText("Xóa");

        changeEmail.setText("Thay đổi");

        deleteEmail.setText("Xóa");

        changeCccd.setText("Thay đổi");

        deleteCccd.setText("Xóa");
        deleteCccd.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Security_txt_cccd))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Security_txt_email))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Security_txt_sdt))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_pw, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Security_txt_pw, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changePw)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deletePw))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeSdt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteSdt))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(changeCccd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteCccd)))))
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(panel_Security, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_pw)
                    .addComponent(Security_txt_pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePw)
                    .addComponent(deletePw))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_sdt)
                    .addComponent(Security_txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSdt)
                    .addComponent(deleteSdt))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_email)
                    .addComponent(Security_txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeEmail)
                    .addComponent(deleteEmail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cccd)
                    .addComponent(Security_txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeCccd)
                    .addComponent(deleteCccd))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Security, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Security_txt_cccdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Security_txt_cccdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Security_txt_cccdActionPerformed

    private void Security_txt_pwCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Security_txt_pwCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Security_txt_pwCaretUpdate

    private void Security_txt_cccdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Security_txt_cccdFocusLost
        // TODO add your handling code here:
        if (Security_txt_cccd.getText().isEmpty()) {
            Security_txt_cccd.setText("Chưa có thông tin");
        }
    }//GEN-LAST:event_Security_txt_cccdFocusLost

    private void Security_txt_sdtCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Security_txt_sdtCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Security_txt_sdtCaretUpdate

    private void Security_txt_emailCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Security_txt_emailCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Security_txt_emailCaretUpdate

    private void Security_txt_cccdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_Security_txt_cccdCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_Security_txt_cccdCaretUpdate

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Security_txt_cccd;
    private javax.swing.JTextField Security_txt_email;
    private javax.swing.JTextField Security_txt_pw;
    private javax.swing.JTextField Security_txt_sdt;
    private javax.swing.JButton changeCccd;
    private javax.swing.JButton changeEmail;
    private javax.swing.JButton changePw;
    private javax.swing.JButton changeSdt;
    private javax.swing.JButton deleteCccd;
    private javax.swing.JButton deleteEmail;
    private javax.swing.JButton deletePw;
    private javax.swing.JButton deleteSdt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lb_cccd;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_pw;
    private javax.swing.JLabel lb_sdt;
    private javax.swing.JProgressBar nhanVien_Progress_perentLevel;
    private javax.swing.JPanel nhanVien_container_error;
    private javax.swing.JPanel panel_Security;
    // End of variables declaration//GEN-END:variables
}
