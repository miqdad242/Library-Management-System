package SLMS;


import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author Inshaf
 */
public class Members extends javax.swing.JFrame {

    /**
     * Creates new form stud
     */
    public Members() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        //show_studs();
        findMembs();
    }

    
    public void closeMembs(){
        WindowEvent winClose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClose);
    }


   
        //Getting member details from Database
        public ArrayList<memblist>searchMemb(String valToSearch){
        ArrayList<memblist> membList = new ArrayList<>();
        try{
            //DB config
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/slms", "root", "");
            String searchQ = "SELECT * FROM `members` WHERE CONCAT(`sname`, `indexno`, `address`, `telephone`)LIKE'%"+valToSearch+"%'";
            PreparedStatement pstt = conn.prepareStatement(searchQ);
            ResultSet rs = pstt.executeQuery(searchQ);
            memblist membs;
            
            while(rs.next()){
                membs = new memblist(rs.getInt("indexno"), rs.getInt("telephone"), rs.getString("sname"), rs.getString("address"));
                membList.add(membs);
            }
        }
         catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
        }
        return membList;
    }
        
        public void findMembs(){
           ArrayList<memblist> list = searchMemb(searchMemb.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] {"sname","indexno","address","telephone"});
        Object[] row = new Object[4];
            for(int i = 0; i<list.size(); i++){
            row[0] = list.get(i).getname();
            row[1] = list.get(i).getindex();
            row[2] = list.get(i).getaddress();
            row[3] = list.get(i).gettel();
            model.addRow(row);
            }
            membTable.setModel(model);
            
        }
    
    
    //Execute Update variable initialization
    public void executeSQLQuery(String query, String message){
       try{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/slms", "root", "");
        
        PreparedStatement pstt = conn.prepareStatement(query);
   
        
        
        
        if((pstt.executeUpdate(query)) == 1){
            //refresh table
            DefaultTableModel model = (DefaultTableModel)membTable.getModel();
            model.setRowCount(0);
            findMembs();
            JOptionPane.showMessageDialog(null, "Data " + message+" Succesfully");
        }
        else{
            JOptionPane.showMessageDialog(null,"Data not "+ message);
        }
        
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        index = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        membTable = new javax.swing.JTable();
        searchMemb = new javax.swing.JTextField();
        jPanelclose = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnsearch = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        btndelete = new javax.swing.JButton();
        lblres = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("ManageMembers"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconback.png"))); // NOI18N
        jLabelBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 40));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Address");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Index-no.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Telephone");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        txtname.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 250, 40));

        index.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        index.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indexActionPerformed(evt);
            }
        });
        getContentPane().add(index, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 250, 40));

        txttel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        getContentPane().add(txttel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 250, 40));

        btnadd.setBackground(new java.awt.Color(0, 51, 204));
        btnadd.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        getContentPane().add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 610, 90, 40));

        membTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        membTable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        membTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Index", "Address", "Telephone"
            }
        ));
        membTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        membTable.setGridColor(new java.awt.Color(204, 204, 255));
        membTable.setRowHeight(20);
        membTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                membTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(membTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 780, 570));

        searchMemb.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchMemb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMembActionPerformed(evt);
            }
        });
        searchMemb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchMembKeyPressed(evt);
            }
        });
        getContentPane().add(searchMemb, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 590, 40));

        jPanelclose.setBackground(new java.awt.Color(255, 51, 0));
        jPanelclose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelclose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelcloseMouseClicked(evt);
            }
        });
        jPanelclose.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("x");
        jLabel6.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanelclose.add(jLabel6);
        jLabel6.setBounds(0, 0, 50, 40);

        getContentPane().add(jPanelclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 50, 40));

        btnsearch.setBackground(new java.awt.Color(0, 51, 204));
        btnsearch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(255, 255, 255));
        btnsearch.setText("Search");
        btnsearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 90, 110, 40));

        jLabel7.setFont(new java.awt.Font("Calibri Light", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Manage Members");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, -1, -1));

        btnupdate.setBackground(new java.awt.Color(0, 51, 204));
        btnupdate.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 610, 110, 40));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtaddress.setRows(5);
        jScrollPane2.setViewportView(txtaddress);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 250, 110));

        btndelete.setBackground(new java.awt.Color(0, 51, 204));
        btndelete.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, 110, 40));

        lblres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconsRes.png"))); // NOI18N
        lblres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblresMouseClicked(evt);
            }
        });
        getContentPane().add(lblres, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 40, 40));

        minimize.setFont(new java.awt.Font("Calibri Light", 0, 40)); // NOI18N
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("-");
        minimize.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 51), null));
        minimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });
        getContentPane().add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 50, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/membookbg.jpg"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setPreferredSize(new java.awt.Dimension(1210, 700));
        jLabel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel5MouseDragged(evt);
            }
        });
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
       
    }//GEN-LAST:event_txtnameActionPerformed

    private void jPanelcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelcloseMouseClicked
        
        System.exit(0);
       
    }//GEN-LAST:event_jPanelcloseMouseClicked

    private void searchMembActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMembActionPerformed
        
    }//GEN-LAST:event_searchMembActionPerformed
    //Dragging the form  
    static int xx , yy;
    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        
         xx = evt.getX();
         yy = evt.getY();
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseDragged
        
         int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jLabel5MouseDragged

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
        
        closeMembs();
        Adminform bck = new Adminform();
        bck.setVisible(true);

    }//GEN-LAST:event_jLabelBackMouseClicked

    private void membTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_membTableMouseClicked
        // Display selected field in jtext field
        int i = membTable.getSelectedRow();
        TableModel model = membTable.getModel();
        txtname.setText(model.getValueAt(i,0).toString());
        index.setText(model.getValueAt(i,1).toString());
        txtaddress.setText(model.getValueAt(i,2).toString());
        txttel.setText(model.getValueAt(i,3).toString());
        
        
        
    }//GEN-LAST:event_membTableMouseClicked

    public void emptyField(){
        //Text field set to null
        txtname.setText("");
        index.setText("");
        txtaddress.setText("");
        txttel.setText("");
    }
    
    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        String query = "INSERT INTO `members`(`sname`, `indexno`, `address`, `telephone`) VALUES ('"+txtname.getText()+"', '"+index.getText()+"', '"+txtaddress.getText()+"', '"+txttel.getText()+"')";
        
        executeSQLQuery(query, "Inserted");
        emptyField();
        
        
       
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
       
        String query = "UPDATE `members` SET `sname`='"+txtname.getText()+"',`indexno`='"+index.getText()+"',`address`='"+txtaddress.getText()+"',`telephone`='"+txttel.getText()+"' WHERE indexno="+index.getText();
        
        executeSQLQuery(query, "Updated");
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        String query = "DELETE FROM `members` WHERE indexno = "+index.getText();
        
        executeSQLQuery(query, "Deleted");
        emptyField();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void indexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indexActionPerformed
        
    }//GEN-LAST:event_indexActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        findMembs();
    }//GEN-LAST:event_btnsearchActionPerformed

    private void lblresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblresMouseClicked
        emptyField();
        searchMemb.setText("");
        findMembs();
    }//GEN-LAST:event_lblresMouseClicked

    private void searchMembKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchMembKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            findMembs();
        }
    }//GEN-LAST:event_searchMembKeyPressed

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setState(Members.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

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
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Members().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JTextField index;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JPanel jPanelclose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblres;
    private javax.swing.JTable membTable;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField searchMemb;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
