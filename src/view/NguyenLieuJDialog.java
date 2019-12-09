/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.NguyenLieuDao;
import JDBC.DialogHelper;
import JDBC.ShareHelper;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.NguyenLieu;

/**
 *
 * @author ADMIN
 */
public class NguyenLieuJDialog extends javax.swing.JDialog {

    /**
     * Creates new form NGUYENLIEUJDialog
     */
    public NguyenLieuJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Quản Lý Nguyên Liệu");
        setLocationRelativeTo(null);
    }
    int index = 0;
    NguyenLieuDao dao = new NguyenLieuDao();

    void init() {
        setIconImage(ShareHelper.APP_ICON);
        setLocationRelativeTo(null);
    }

    void load() {
        DefaultTableModel model = (DefaultTableModel) tblGrid.getModel();
        model.setRowCount(0);
        try {
            List<NguyenLieu> list = dao.select();
            for (NguyenLieu nl : list) {
                Object[] row = {
                    nl.getMaNL(),
                    nl.getTenNL(),
                    nl.getSoLuong(),
                    nl.getDonGia(),
                    nl.getnCC()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void insert() {
        NguyenLieu model = getModel();
            try {
                dao.insert(model);
                this.load();
                this.clear();
                DialogHelper.alert(this, "Thêm mới thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Thêm mới thất bại!");
            }

    }

    void delete() {
        if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa nguyên liệu này?")) {
            String manl = txtMaNL.getText();
            try {
                dao.delete(manl);
                this.load();
                this.clear();
                DialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                DialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }

    void edit() {
        try {
            String manl = (String) tblGrid.getValueAt(this.index, 0);
            NguyenLieu model = dao.findById(manl);
            if (model != null) {
                this.setModel(model);
                this.setStatus(false);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    void update() {
        NguyenLieu model = getModel();

        try {
            dao.update(model);
            this.load();
            DialogHelper.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            DialogHelper.alert(this, "Cập nhật thất bại!");
        }
    }
    void clear() {
        this.setModel(new NguyenLieu());
        this.setStatus(true);
    }

    void setModel(NguyenLieu model) {
        txtMaNL.setText(model.getMaNL());
        txtTenNL.setText(model.getTenNL());
        txtSoLuong.setText(String.valueOf(model.getSoLuong()));
        txtDonGia.setText(String.valueOf(model.getDonGia()));
        txtNhaCC.setText(model.getnCC());

    }

    NguyenLieu getModel() {
        NguyenLieu model = new NguyenLieu();
        model.setMaNL(txtMaNL.getText());
        model.setTenNL(txtTenNL.getText());
        model.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        model.setDonGia(Float.valueOf(txtDonGia.getText()));
        model.setnCC(txtNhaCC.getText());
        return model;
    }

    void setStatus(boolean insertable) {
        txtMaNL.setEditable(insertable);
        btnAdd.setEnabled(insertable);
        btnEdit.setEnabled(!insertable);
        btnDelete.setEnabled(!insertable);

        boolean first = this.index > 0;
        boolean last = this.index < tblGrid.getRowCount() - 1;
        btnfirst.setEnabled(!insertable && first);
        btnPrevious.setEnabled(!insertable && first);
        btnNext.setEnabled(!insertable && last);
        btnLast.setEnabled(!insertable && last);
    }
         private boolean checknull() {
        if (txtMaNL.getText().isEmpty()) {
            DialogHelper.alert(null, "Không để trống mã");
            txtMaNL.requestFocus();
            return false;
        }
        if (txtTenNL.getText().isEmpty()) {
            DialogHelper.alert(null, "Không để trống Họ tên");
            txtTenNL.requestFocus();
            return false;
        }
        
        if (txtSoLuong.getText().isEmpty()) {
            DialogHelper.alert(null, "Không để trống Số lượng");
            txtSoLuong.requestFocus();
            return false;
        }
        if (txtDonGia.getText().isEmpty()) {
            DialogHelper.alert(null, "Không để trống Giá");
            txtDonGia.requestFocus();
            return false;
        }
        if (txtNhaCC.getText().isEmpty()) {
            DialogHelper.alert(null, "Không để Nhà cung cấp");
            txtNhaCC.requestFocus();
            return false;
        }

        return true;

    }

        public boolean checkten() {
        String regex = "^[\\p{L}\\s]+$";
        if (!txtTenNL.getText().matches(regex)) {
            DialogHelper.alert(this, "Họ tên không được chứa số !");
            return false;
            }
        return true;

    }

    public boolean CHECKID() {
       String maNL = new String(txtMaNL.getText());
        if (dao.findById(maNL) != null) {
            DialogHelper.alert(null, "Bị trùng mã");
            return false;
        }
        return true;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlEdit = new javax.swing.JPanel();
        lblTenNL = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblDonGia = new javax.swing.JLabel();
        txtTenNL = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        lblNhaCC = new javax.swing.JLabel();
        txtNhaCC = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnfirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMaNL = new javax.swing.JTextField();
        pnlList = new javax.swing.JPanel();
        btnFind = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGrid = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitle.setText("NGUYÊN LIỆU");

        lblTenNL.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTenNL.setText("Tên nguyên liệu:");

        lblSoLuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSoLuong.setText("Số lượng:");

        lblDonGia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblDonGia.setText("Đơn giá:");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });

        lblNhaCC.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNhaCC.setText("Nhà cung cấp:");

        btnAdd.setText("Add");
        btnAdd.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                btnAddAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnfirst.setText("|<");
        btnfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfirstActionPerformed(evt);
            }
        });

        btnPrevious.setText("<<");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Mã nguyên liệu:");

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btnfirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrevious)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLast)
                .addGap(18, 18, 18))
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblNhaCC)
                    .addComponent(lblDonGia)
                    .addComponent(lblSoLuong)
                    .addComponent(lblTenNL))
                .addGap(18, 18, 18)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenNL)
                    .addComponent(txtSoLuong)
                    .addComponent(txtDonGia)
                    .addComponent(txtNhaCC, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(txtMaNL))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNL)
                    .addComponent(txtTenNL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSoLuong)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDonGia)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNhaCC)
                    .addComponent(txtNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnfirst)
                        .addComponent(btnPrevious)
                        .addComponent(btnNext)
                        .addComponent(btnLast))
                    .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd)
                        .addComponent(btnEdit)
                        .addComponent(btnDelete)))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("CẬP NHẬT", pnlEdit);

        btnFind.setText("Find");

        tblGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nguyên liệu", "Tên nguyên liệu", "Số lượng", "Đợn giá", "Nhà cung cấp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGrid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGridMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGrid);

        javax.swing.GroupLayout pnlListLayout = new javax.swing.GroupLayout(pnlList);
        pnlList.setLayout(pnlListLayout);
        pnlListLayout.setHorizontalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListLayout.createSequentialGroup()
                        .addGap(0, 262, Short.MAX_VALUE)
                        .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFind))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        pnlListLayout.setVerticalGroup(
            pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFind)
                    .addGroup(pnlListLayout.createSequentialGroup()
                        .addComponent(txtFind)
                        .addGap(6, 6, 6)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DANH SÁCH", pnlList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void btnAddAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnAddAncestorMoved
           
    }//GEN-LAST:event_btnAddAncestorMoved

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
         if (checknull() && CHECKID() && checkten()) {
            insert();}
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
        // TODO add your handling code here:
        this.index = 0;
        this.edit();
    }//GEN-LAST:event_btnfirstActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        this.index--;
        this.edit();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        this.index++;
        this.edit();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        this.index = tblGrid.getRowCount() - 1;
        this.edit();
    }//GEN-LAST:event_btnLastActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.load();
        this.setStatus(true);
    }//GEN-LAST:event_formWindowOpened

    private void tblGridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGridMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tblGrid.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                this.edit();
                jTabbedPane1.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblGridMouseClicked

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
            java.util.logging.Logger.getLogger(NguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NguyenLieuJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NguyenLieuJDialog dialog = new NguyenLieuJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnfirst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDonGia;
    private javax.swing.JLabel lblNhaCC;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenNL;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlList;
    private javax.swing.JTable tblGrid;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtMaNL;
    private javax.swing.JTextField txtNhaCC;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenNL;
    // End of variables declaration//GEN-END:variables
}
