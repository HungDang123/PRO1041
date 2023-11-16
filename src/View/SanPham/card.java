package View.SanPham;

import Model.sanPham;
import View.Main;
import com.pro1041.dao.DAO_sanPham;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import View.SanPham.them;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author HOANG
 */
public class card extends javax.swing.JPanel {

    String setDis = null;
    DAO_sanPham dao = new DAO_sanPham();
    String idSanPham;
    sanPham sp;
    DecimalFormat df = new DecimalFormat("#.000 đồng");

    /**
     * Creates new form card
     */
    public card(sanPham sp) {
        initComponents();
        setIcon(new ImageIcon(this.getClass().getResource("/image/" + sp.getHinhAnh())), lblHinh);
        lblTen.setText("Tên sản phẩm: " + sp.getTenSanPham());
        lblGia.setText("Giá: " + String.valueOf(df.format(sp.getDonGia())));
        this.idSanPham = sp.getMaSanPham();
        this.sp = sp;
        hoverOut();
    }

    public void setIcon(ImageIcon ic, JLabel jl) {
        jl.setIcon(new ImageIcon(ic.getImage().getScaledInstance(jl.getPreferredSize().width, jl.getPreferredSize().height, 0)));
    }

    public void hoverIn() {
        jPanel2.setVisible(true);
        jPanel1.repaint();
        validate();
    }

    public void hoverOut() {
        jPanel2.setVisible(false);
        jPanel1.repaint();
        validate();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXem = new javax.swing.JButton();
        lblTenSP = new javax.swing.JLabel();
        lblGiaSP = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(250, 350));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinh.setOpaque(true);
        lblHinh.setPreferredSize(new java.awt.Dimension(228, 194));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHinhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHinhMouseExited(evt);
            }
        });
        jPanel1.add(lblHinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 240, -1));

        lblTen.setText("Tên sản phẩm:");
        jPanel1.add(lblTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 218, -1, -1));

        lblGia.setText("Giá:");
        jPanel1.add(lblGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 241, -1, -1));

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(211, 37, 71));
        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXoaMouseExited(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 209, 84));
        btnSua.setText("Sửa");
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSuaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSuaMouseExited(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXem.setBackground(new java.awt.Color(123, 213, 0));
        btnXem.setText("Xem");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnXem))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 260, -1, -1));
        jPanel1.add(lblTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 206, 118, -1));
        jPanel1.add(lblGiaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 212, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        dao.delete(idSanPham);
        Main.sanPham.loadToData();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        setDis = null;
        them them = new them(setDis);
        them.setVisible(true);
        them.setLocationRelativeTo(null);
        them.setForm(sp);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        hoverIn();
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        hoverOut();
    }//GEN-LAST:event_jPanel1MouseExited

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked

    }//GEN-LAST:event_btnXoaMouseClicked

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        hoverIn();
    }//GEN-LAST:event_jPanel2MouseEntered

    private void btnXoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseEntered
        hoverIn();
    }//GEN-LAST:event_btnXoaMouseEntered

    private void btnSuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseEntered
        hoverIn();
    }//GEN-LAST:event_btnSuaMouseEntered

    private void btnXoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseExited
        hoverOut();
        if (!jPanel2.isVisible()) {
            hoverOut();
        }
    }//GEN-LAST:event_btnXoaMouseExited

    private void btnSuaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseExited
        hoverOut();
        if (!jPanel2.isVisible()) {
            hoverOut();
        }
    }//GEN-LAST:event_btnSuaMouseExited

    private void lblHinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseEntered
        // TODO add your handling code here:
        hoverIn();
    }//GEN-LAST:event_lblHinhMouseEntered

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        setDis = "1";
        them them = new them(setDis);
        them.setVisible(true);
        them.setLocationRelativeTo(null);
        them.setForm(sp);
        // set disable
    }//GEN-LAST:event_btnXemActionPerformed

    private void lblHinhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseExited
        // TODO add your handling code here:
        hoverOut();
        if (!jPanel2.isVisible()) {
            hoverOut();
        }
    }//GEN-LAST:event_lblHinhMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblGiaSP;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblTenSP;
    // End of variables declaration//GEN-END:variables
}