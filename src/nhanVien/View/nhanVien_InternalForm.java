/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package nhanVien.View;

import com.pro1041.dao.DAO_nhanVien;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.JPanel;
import Model.nhanVien;
import nhanVien.data.nhanVien_data_DAO;
import com.pro1041.util.ShareHelper;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hnhut
 */
public class nhanVien_InternalForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form nhanVien_InternalForm
     */
    private DefaultTableModel statistiCal_defaultModel = new DefaultTableModel();
    private TableRowSorter<DefaultTableModel> rowSorter;

    public nhanVien_InternalForm() {
        initComponents();
        System.out.println(ShareHelper.USER.getChucVu());
        nhanVien nv = ShareHelper.USER;
        if (nv.getChucVu()) {
            nhanVien_container.setLayout(new GridLayout(0, 3));
        } else {
//            JOptionPane.showMessageDialog(this, "Bạn Chỉ có quyền xem mục này");
            Add.setVisible(false);
        }
        showList_nv();
        setSize(1000, 700);
    }

    public void update() {
        showList_nv();
        getParent().repaint();
    }

    public void clickAdd() {
        System.out.println("showList");
        showList_nv();
    }

    public void CreateSize(int width, int heigt) {
        setSize(width, HEIGHT);
    }

    public void showList_nv() {
        nhanVien_container.removeAll();
        for (nhanVien nv : new nhanVien_data_DAO().selectAll()) {
            NhanVienCard nv_Card = new NhanVienCard(nv, this);
            nhanVien_container.add(nv_Card);
        }
        nhanVien_container.repaint();
    }

    public void showList_nv_byID_almost(String id, String hovaTen) {
        nhanVien_container.removeAll();
        System.out.println("M: " + new nhanVien_data_DAO().selectNhanVien_byIDandHovaTen_almost(id, hovaTen));
        for (nhanVien nv : new nhanVien_data_DAO().selectNhanVien_byIDandHovaTen_almost(id, hovaTen)) {
            NhanVienCard nv_Card = new NhanVienCard(nv, this);
            nhanVien_container.add(nv_Card);
        }
        nhanVien_container.revalidate();
        nhanVien_container.repaint();
    }

    public void statistical_select(String manv, double tongtien) {
        statistiCal_defaultModel.setRowCount(0);
        statistiCal_defaultModel.setColumnCount(0);
        System.out.println("clera");
        String[] columns = {"Mã nhân viên", "Tên nhân viên", "Số lượng hóa đơn", "Số lượng đơn hàng", "Tổng tiền"};

        for (String column : columns) {
            statistiCal_defaultModel.addColumn(column);
        }
        ResultSet rs = new nhanVien_data_DAO().getStatical(manv, tongtien);
        try {
            while (rs.next()) {
                String maNhanVien = rs.getString("Mã Nhân Viên");
                String tenNhanVien = rs.getString("Tên Nhân Viên");
                int soLuongHoaDon = rs.getInt("Số lượng hóa đơn");
                int soLuongDonHang = rs.getInt("Số lượng đơn hàng");
                double tongTien = rs.getDouble("Tổng Tiền");

                statistiCal_defaultModel.addRow(new Object[]{
                    maNhanVien, tenNhanVien, soLuongHoaDon, soLuongDonHang, tongTien
                });

            }
        } catch (SQLException ex) {
            Logger.getLogger(nhanVien_InternalForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        statistiCal_Table.setModel(statistiCal_defaultModel);
    }

    public void search_id(String id) {
        rowSorter = new TableRowSorter<>(statistiCal_defaultModel);
        statistiCal_Table.setRowSorter(rowSorter);
        if (id.isEmpty()) {
            rowSorter.setRowFilter(null);
        } else {
            RowFilter<DefaultTableModel, Object> rowFiler = RowFilter.regexFilter(id, 0);
            rowSorter.setRowFilter(rowFiler);
        }
    }
//  private void statistiCal_nhanVienBillIDCaretUpdate(javax.swing.event.CaretEvent evt) {
//        // TODO add your handling code here:
//        search_id(statistiCal_nhanVienBill.getText());
//  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        nhanVien_showList_tbP = new javax.swing.JPanel();
        showList_nav = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        nhanVien_txt_searchID = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        nhanVien_txt_searchHovaTen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        nhanVien_container = new javax.swing.JPanel();
        nhanVien_showData_tbP = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        statistiCal_totalBill = new javax.swing.JTextField();
        statistiCal_getBill = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        statistiCal_nhanVienBill = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        statistiCal_Table = new javax.swing.JTable();

        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        showList_nav.setBackground(new java.awt.Color(255, 255, 255));
        showList_nav.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel16.setText("Mã nhân viên");

        nhanVien_txt_searchID.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nhanVien_txt_searchID.setBorder(null);
        nhanVien_txt_searchID.setCaretColor(new java.awt.Color(204, 0, 153));
        nhanVien_txt_searchID.setMargin(new java.awt.Insets(6, 6, 6, 6));
        nhanVien_txt_searchID.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nhanVien_txt_searchIDCaretUpdate(evt);
            }
        });
        nhanVien_txt_searchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhanVien_txt_searchIDActionPerformed(evt);
            }
        });
        nhanVien_txt_searchID.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                nhanVien_txt_searchIDPropertyChange(evt);
            }
        });

        Add.setBackground(new java.awt.Color(0, 0, 0));
        Add.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOpaque(true);

        jLabel1.setText("Họ và tên");

        nhanVien_txt_searchHovaTen.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nhanVien_txt_searchHovaTenCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout showList_navLayout = new javax.swing.GroupLayout(showList_nav);
        showList_nav.setLayout(showList_navLayout);
        showList_navLayout.setHorizontalGroup(
            showList_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showList_navLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(showList_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(nhanVien_txt_searchID, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(nhanVien_txt_searchHovaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(317, 317, 317)
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        showList_navLayout.setVerticalGroup(
            showList_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showList_navLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(showList_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(showList_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showList_navLayout.createSequentialGroup()
                            .addGroup(showList_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nhanVien_txt_searchID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(0, 0, 0)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(showList_navLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add)))
                    .addComponent(nhanVien_txt_searchHovaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nhanVien_container.setBackground(new java.awt.Color(51, 51, 51));
        nhanVien_container.setLayout(new java.awt.GridLayout(0, 4));
        jScrollPane1.setViewportView(nhanVien_container);

        javax.swing.GroupLayout nhanVien_showList_tbPLayout = new javax.swing.GroupLayout(nhanVien_showList_tbP);
        nhanVien_showList_tbP.setLayout(nhanVien_showList_tbPLayout);
        nhanVien_showList_tbPLayout.setHorizontalGroup(
            nhanVien_showList_tbPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showList_nav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nhanVien_showList_tbPLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        nhanVien_showList_tbPLayout.setVerticalGroup(
            nhanVien_showList_tbPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhanVien_showList_tbPLayout.createSequentialGroup()
                .addComponent(showList_nav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Nhân Viên", nhanVien_showList_tbP);

        nhanVien_showData_tbP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nhanVien_showData_tbPFocusGained(evt);
            }
        });

        jLabel2.setText("Tổng tiền (VND)");

        statistiCal_getBill.setText("Tìm Kiếm");
        statistiCal_getBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statistiCal_getBillActionPerformed(evt);
            }
        });

        jLabel6.setText("Mã Nhân Viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(statistiCal_totalBill, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statistiCal_getBill))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(statistiCal_nhanVienBill, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(461, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(statistiCal_totalBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statistiCal_getBill))
                .addGap(18, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(statistiCal_nhanVienBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        statistiCal_Table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(statistiCal_Table);

        javax.swing.GroupLayout nhanVien_showData_tbPLayout = new javax.swing.GroupLayout(nhanVien_showData_tbP);
        nhanVien_showData_tbP.setLayout(nhanVien_showData_tbPLayout);
        nhanVien_showData_tbPLayout.setHorizontalGroup(
            nhanVien_showData_tbPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhanVien_showData_tbPLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 124, Short.MAX_VALUE))
            .addGroup(nhanVien_showData_tbPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        nhanVien_showData_tbPLayout.setVerticalGroup(
            nhanVien_showData_tbPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhanVien_showData_tbPLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Thống kê", nhanVien_showData_tbP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nhanVien_txt_searchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhanVien_txt_searchIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhanVien_txt_searchIDActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        nhanVien_Form_Add add = new nhanVien_Form_Add(this);
        add.setVisible(true);
    }//GEN-LAST:event_AddActionPerformed

    private void nhanVien_txt_searchIDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_nhanVien_txt_searchIDPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_nhanVien_txt_searchIDPropertyChange

    private void nhanVien_txt_searchIDCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nhanVien_txt_searchIDCaretUpdate
        // TODO add your handling code here:
        search_id(nhanVien_txt_searchID.getText());
    }//GEN-LAST:event_nhanVien_txt_searchIDCaretUpdate

    private void nhanVien_txt_searchHovaTenCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nhanVien_txt_searchHovaTenCaretUpdate
        // TODO add your handling code here:
        showList_nv_byID_almost(nhanVien_txt_searchID.getText(), nhanVien_txt_searchHovaTen.getText());
    }//GEN-LAST:event_nhanVien_txt_searchHovaTenCaretUpdate

    private void statistiCal_getBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistiCal_getBillActionPerformed
        // TODO add your handling code here:
        double tongTien;
        if (statistiCal_totalBill.getText().isEmpty()) {
            tongTien = 0;
        } else {
            tongTien = Double.parseDouble(statistiCal_totalBill.getText());
        }

        String mamv;
        if (statistiCal_nhanVienBill.getText().isEmpty()) {
            mamv = "%%";
        } else {
            mamv = statistiCal_nhanVienBill.getText();
        }
        statistical_select(mamv, tongTien);

    }//GEN-LAST:event_statistiCal_getBillActionPerformed

    private void nhanVien_showData_tbPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nhanVien_showData_tbPFocusGained
        // TODO add your handling code here:
        System.out.println("Chọn");
    }//GEN-LAST:event_nhanVien_showData_tbPFocusGained

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        // TODO add your handling code here:
        if (jTabbedPane2.getSelectedIndex() == 1) {
            statistical_select("%%", 1);
        } else {
//            showList_nv();
        }
    }//GEN-LAST:event_jTabbedPane2StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel nhanVien_container;
    private javax.swing.JPanel nhanVien_showData_tbP;
    private javax.swing.JPanel nhanVien_showList_tbP;
    private javax.swing.JTextField nhanVien_txt_searchHovaTen;
    private javax.swing.JTextField nhanVien_txt_searchID;
    private javax.swing.JPanel showList_nav;
    private javax.swing.JTable statistiCal_Table;
    private javax.swing.JButton statistiCal_getBill;
    private javax.swing.JTextField statistiCal_nhanVienBill;
    private javax.swing.JTextField statistiCal_totalBill;
    // End of variables declaration//GEN-END:variables
}
