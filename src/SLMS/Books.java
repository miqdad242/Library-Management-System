

package SLMS;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
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
public class Books extends javax.swing.JFrame {

    /** Creates new form book */
    public Books() {
        initComponents();
        
       Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        show_books();
    }
    
    //Close upon close button clicked
     public void closeBooks(){
        WindowEvent winClos = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClos);
    }
     //Getting Books details from Database
    public ArrayList<booklist> searchBooks(String valToSearch){
         ArrayList<booklist> booklist = new ArrayList<>();
         
         try{
             Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slms", "root", "");
            String sql = "SELECT * FROM `books` WHERE CONCAT(`BookID`, `BookName`, `Author`, `ISBN`)LIKE'%"+valToSearch+"%'";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            booklist books;
            
            while(rs.next()){
                books = new booklist(rs.getString("bookID"), rs.getString("bookName"), rs.getString("author"), rs.getString("ISBN"));
                booklist.add(books);
            }
         
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return booklist;
     }
    
    public void show_books(){
         ArrayList<booklist> list = searchBooks(searchBooks.getText());
         DefaultTableModel model = new DefaultTableModel();
         model.setColumnIdentifiers(new Object[] {"bookID", "bookName", "author","ISBN"});
         Object[] row = new Object[4];
         for(int i = 0; i<list.size(); i++){
             row[0] = list.get(i).getBookID();
             row[1] = list.get(i).getBookName();
             row[2] = list.get(i).getauthor();
             row[3] = list.get(i).getISBN();
             model.addRow(row);
         }
         booktable.setModel(model);
        }
    //Initializing ExecuteUpdate and DB initialization
    public void executeSQLQuery(String query , String message){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/slms", "root", "");
            PreparedStatement pst = con.prepareStatement(query);
            
            if((pst.executeUpdate(query))==1){
                DefaultTableModel model = (DefaultTableModel)booktable.getModel();
                model.setRowCount(0);
                show_books();
                JOptionPane.showMessageDialog(null, "Data " + message + " Succesfully");
            }
            else{
                JOptionPane.showMessageDialog(null, "Data not " + message);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        bookID = new javax.swing.JTextField();
        bookName = new javax.swing.JTextField();
        author = new javax.swing.JTextField();
        ISBN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        booktable = new javax.swing.JTable();
        searchBooks = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        jLabelBack = new javax.swing.JLabel();
        lblReset = new javax.swing.JLabel();
        minlbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Calibri Light", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Manage Books");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 490, 40));

        bookID.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        bookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookIDActionPerformed(evt);
            }
        });
        getContentPane().add(bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 250, 40));

        bookName.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        getContentPane().add(bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 250, 40));

        author.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        getContentPane().add(author, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 250, 40));

        ISBN.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        getContentPane().add(ISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 250, 40));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel2.setText("Book ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, 16));

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel3.setText("Book Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel4.setText("Author");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel5.setText("ISBN");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        btnupdate.setBackground(new java.awt.Color(0, 51, 204));
        btnupdate.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("Update");
        btnupdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 110, 40));

        btnadd.setBackground(new java.awt.Color(0, 51, 204));
        btnadd.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setText("Add");
        btnadd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        getContentPane().add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, 90, 40));

        booktable.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        booktable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Author", "ISBN"
            }
        ));
        booktable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        booktable.setRowHeight(20);
        booktable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booktableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(booktable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 770, 550));

        searchBooks.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        searchBooks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBooksKeyPressed(evt);
            }
        });
        getContentPane().add(searchBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 580, 40));

        btnSearch.setBackground(new java.awt.Color(0, 51, 204));
        btnSearch.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 90, 110, 40));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("x");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 50, 40);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 50, 40));

        btndelete.setBackground(new java.awt.Color(0, 51, 204));
        btndelete.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 110, 40));

        jLabelBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconback.png"))); // NOI18N
        jLabelBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBackMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 40));

        lblReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconsRes.png"))); // NOI18N
        lblReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResetMouseClicked(evt);
            }
        });
        getContentPane().add(lblReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 40, 40));

        minlbl.setFont(new java.awt.Font("Calibri Light", 0, 40)); // NOI18N
        minlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minlbl.setText("-");
        minlbl.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 51), null));
        minlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minlblMouseClicked(evt);
            }
        });
        getContentPane().add(minlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 50, 40));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/membookbg.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookIDActionPerformed
        
    }//GEN-LAST:event_bookIDActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        String query = "DELETE FROM `books` WHERE BookID = "+bookID.getText();
        
        executeSQLQuery(query, "Deleted");
        emptyField();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void jLabelBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBackMouseClicked
         
      Adminform setV = new Adminform();
      setV.setVisible(true);
       closeBooks();
       
      
       
    }//GEN-LAST:event_jLabelBackMouseClicked
    //Draggable form    
    static int xx , yy;
    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jLabel1MouseDragged

    public void emptyField(){
        //Clear TextField
        bookID.setText("");
        bookName.setText("");
        author.setText("");
        ISBN.setText("");
    }
    
    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        String query = "INSERT INTO `books`(`BookID`, `BookName`, `Author`, `ISBN`) VALUES ('"+bookID.getText()+"', '"+bookName.getText()+"', '"+author.getText()+"', '"+ISBN.getText()+"')";
        
        executeSQLQuery(query, "Inserted");
        emptyField();
        
        
    }//GEN-LAST:event_btnaddActionPerformed

    private void booktableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booktableMouseClicked
       //Display Selected field in Text field
        int i = booktable.getSelectedRow();
        TableModel model = booktable.getModel();
        bookID.setText(model.getValueAt(i,0).toString());
        bookName.setText(model.getValueAt(i,1).toString());
        author.setText(model.getValueAt(i,2).toString());
        ISBN.setText(model.getValueAt(i,3).toString());
    }//GEN-LAST:event_booktableMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
         String query = "UPDATE `books` SET `BookID`='"+bookID.getText()+"',`BookName`='"+bookName.getText()+"',`Author`='"+author.getText()+"',`ISBN`='"+ISBN.getText()+"' WHERE BookID="+bookID.getText();
        
        executeSQLQuery(query, "Updated");
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        show_books();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void lblResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResetMouseClicked
        emptyField();
        searchBooks.setText("");
        show_books();
    }//GEN-LAST:event_lblResetMouseClicked

    private void searchBooksKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBooksKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            show_books();
        }
    }//GEN-LAST:event_searchBooksKeyPressed

    private void minlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minlblMouseClicked
        this.setState(Books.ICONIFIED);
    }//GEN-LAST:event_minlblMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ISBN;
    private javax.swing.JTextField author;
    private javax.swing.JTextField bookID;
    private javax.swing.JTextField bookName;
    private javax.swing.JTable booktable;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblReset;
    private javax.swing.JLabel minlbl;
    private javax.swing.JTextField searchBooks;
    // End of variables declaration//GEN-END:variables

}
