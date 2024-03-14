/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
        
/**
 *
 * @author Lenovo
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    //to fetch the book details from the database and display on the panel
    public void getBookDetails(){
        int book_id=Integer.parseInt(txt_bookid.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select * from books_details where book_Id=?");
            pst.setInt(1, book_id);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()){
                lbl_bookid.setText(rs.getString("book_id"));
                lbl_bookname.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));  
            }else{
                lbl_bookerror.setText("Invalid book id.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //to fetch the student details from the database and display on the panel
    public void getStudentDetails(){
        int student_id=Integer.parseInt(txt_studentid.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select * from student_details where student_id=?");
            pst.setInt(1, student_id);
            ResultSet rs=pst.executeQuery();
            
            if(rs.next()){
                lbl_studentid.setText(rs.getString("student_id"));
                lbl_studentname.setText(rs.getString("student_name"));
                lbl_course.setText(rs.getString("course_name"));
                lbl_branch.setText(rs.getString("branch"));  
            }else{
                lbl_studenterror.setText("Invalid student id.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //insert issue book details to database
    public boolean issueBook(){
        boolean isIssued=false;
        
        int bookid=Integer.parseInt(txt_bookid.getText());
        int studentid=Integer.parseInt(txt_studentid.getText());
        String bookname=lbl_bookname.getText();
        String studentname=lbl_studentname.getText();
        Date issuedate=date_issuedate.getDatoFecha();
        Date duedate=date_duedate.getDatoFecha();
        
        long l1=issuedate.getTime();
        java.sql.Date issueDate = new java.sql.Date(l1);
        
        long l2=duedate.getTime();
        java.sql.Date dueDate = new java.sql.Date(l2);
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("insert into issue_book_details (book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)");
            pst.setInt(1, bookid);
            pst.setString(2, bookname);
            pst.setInt(3, studentid);
            pst.setString(4, studentname);
            pst.setDate(5,issueDate);
            pst.setDate(6, dueDate);
            pst.setString(7, "Pending");
            
            int rowCount =pst.executeUpdate();
            if(rowCount>0){
                isIssued=true;
            }else{
                isIssued=false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isIssued;
    }
    //updating the book count after issue of book
    public void updateBookCount(){
        int bookid=Integer.parseInt(txt_bookid.getText());
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("update books_details set quantity=quantity-1 where book_id=?");
            pst.setInt(1,bookid);
            int rowCount=pst.executeUpdate();
            if(rowCount>0){
                JOptionPane.showMessageDialog(this, "Book count updated.");
                int initialCount=Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount-1));
            }else{
                JOptionPane.showMessageDialog(this, "Can not update book count.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }         
    }
    //check for already issued book to a student
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued=false;
        int bookid=Integer.parseInt(txt_bookid.getText());
        int studentid=Integer.parseInt(txt_studentid.getText());
        
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("select * from issue_book_details where book_id=? and student_id=? and status=?");
            pst.setInt(1, bookid);
            pst.setInt(2, studentid);
            pst.setString(3,"Pending");
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                isAlreadyIssued=true;
            }else{
                isAlreadyIssued=false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        PanelMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_studentid = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lbl_studenterror = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_bookid = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_bookerror = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_bookid = new javax.swing.JTextField();
        txt_studentid = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        date_duedate = new rojeru_san.componentes.RSDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        date_issuedate = new rojeru_san.componentes.RSDateChooser();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelMain.setBackground(new java.awt.Color(255, 255, 255));
        PanelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("STUDENT ID:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("COURSE:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 367, -1, 30));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("STUDENT NAME:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("BRANCH:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        lbl_branch.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 160, 20));

        lbl_course.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 160, 20));

        lbl_studentname.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 160, 20));

        lbl_studentid.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_studentid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 160, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 300, 3));

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel20.setText("STUDENT DETAILS");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 100));

        lbl_studenterror.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_studenterror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbl_studenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 230, 20));

        PanelMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 350, 690));

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 280, 3));

        lbl_quantity.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jPanel2.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 160, 20));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel6.setText("BOOK NAME:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel7.setText("AUTHOR NAME:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 367, -1, 30));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel8.setText("BOOK ID:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        lbl_bookid.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jPanel2.add(lbl_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 160, 20));

        lbl_bookname.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jPanel2.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 160, 20));

        lbl_author.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jPanel2.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 160, 20));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel5.setText("BOOK DETAILS");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 100));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel10.setText("QUANTITY:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        lbl_bookerror.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        lbl_bookerror.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_bookerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 480, 230, 20));

        PanelMain.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 690));

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("x");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 23, -1));

        PanelMain.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 50, 30));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("ISSUE BOOK");
        PanelMain.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        PanelMain.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 200, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 51));
        jLabel9.setText("ENTER BOOK ID:");
        PanelMain.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, -1, -1));

        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 51)));
        txt_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookidFocusLost(evt);
            }
        });
        txt_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookidActionPerformed(evt);
            }
        });
        PanelMain.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 200, -1));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 51)));
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        txt_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentidActionPerformed(evt);
            }
        });
        PanelMain.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, 200, -1));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 51));
        jLabel11.setText("DUE DATE:");
        PanelMain.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, -1, -1));

        date_duedate.setColorBackground(new java.awt.Color(255, 102, 51));
        date_duedate.setColorForeground(new java.awt.Color(255, 102, 51));
        date_duedate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        date_duedate.setPlaceholder("Select Due Date");
        PanelMain.add(date_duedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 420, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 102, 51));
        jLabel16.setText("ENTER STUDENT ID:");
        PanelMain.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 102, 51));
        jLabel17.setText("ISSUE DATE:");
        PanelMain.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 360, -1, -1));

        date_issuedate.setColorBackground(new java.awt.Color(255, 102, 51));
        date_issuedate.setColorForeground(new java.awt.Color(255, 102, 51));
        date_issuedate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        date_issuedate.setPlaceholder("Select Issue Date");
        PanelMain.add(date_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 102, 51));
        jButton5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jButton5.setText("ISSUE BOOK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        PanelMain.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 500, 310, 40));

        getContentPane().add(PanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 690));

        setSize(new java.awt.Dimension(1082, 690));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        HomePage page=new HomePage();
        page.setVisible(true);
        this.dispose();
    }                                    

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {                                     
        System.exit(0);
    }                                    

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void txt_bookidFocusLost(java.awt.event.FocusEvent evt) {                                     
        if(!txt_bookid.getText().equals("")){
            getBookDetails();
        }
    }                                    

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {                                        
        if(!txt_studentid.getText().equals("")){
            getStudentDetails();
        }
    }                                       

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (lbl_quantity.equals("0")){
            JOptionPane.showMessageDialog(this, "Book not available.");
        }else{
            if(isAlreadyIssued()==false){
                if(issueBook()==true){
                    JOptionPane.showMessageDialog(this, "Book issued successfully.");
                    updateBookCount();
                }else{
                    JOptionPane.showMessageDialog(this, "Can not issue the book.");
                }
            }else{
                JOptionPane.showMessageDialog(this, "This student already issued this book.");
            }
        }
        
        
    }                                        

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel PanelMain;
    private rojeru_san.componentes.RSDateChooser date_duedate;
    private rojeru_san.componentes.RSDateChooser date_issuedate;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookerror;
    private javax.swing.JLabel lbl_bookid;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studenterror;
    private javax.swing.JLabel lbl_studentid;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JTextField txt_bookid;
    private javax.swing.JTextField txt_studentid;
    // End of variables declaration                   
}
