/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Lenovo
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor=new Color(0,0,0);
    Color mouseExitColor=new Color(102,204,255);
    DefaultTableModel model;
    public HomePage() {
        initComponents();
        showPieChart();
        SetStudentDetailsToTable();
        SetBookDetailsToTable();
        setDataToCard();
    }
    
    public void showPieChart(){

        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      
      try{
          Connection con=DBConnection.getConnection();
          String sql="select book_name,count(*) as count from books_details order by book_id";
          Statement st=con.createStatement();
          ResultSet rs=st.executeQuery(sql);
          while(rs.next()){
              barDataset.setValue(rs.getString("book_name"),new Double(rs.getDouble("count")));
          }
      }catch(Exception e){
          e.printStackTrace();
      }

      //create chart
      JFreeChart piechart = ChartFactory.createPieChart("BOOKS",barDataset, true,true,false);//explain

      PiePlot piePlot =(PiePlot) piechart.getPlot();

       //changing pie chart blocks colors
       piePlot.setSectionPaint("", new Color(255,255,102));
       piePlot.setSectionPaint("", new Color(102,255,102));
       piePlot.setSectionPaint("", new Color(255,102,153));
       piePlot.setSectionPaint("", new Color(0,204,204));


        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }
//pieChart.java
//Displaying pieChart.java.
    public void SetStudentDetailsToTable(){
        try{
            Connection con =DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student_details");
            while(rs.next()){
                int student_id=rs.getInt("student_id");
                String student_name=rs.getString("student_name");
                String course=rs.getString("course_name");
                String branch=rs.getString("branch");
                
                Object[] obj={student_id,student_name,course,branch};
                model=(DefaultTableModel)tbl_studentDetails.getModel();
                model.addRow(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //insert data into table
    
    public void SetBookDetailsToTable(){
        try{
            Connection con =DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from books_details");
            while(rs.next()){
                int bookID=rs.getInt("book_id");
                String bookName=rs.getString("book_name");
                String bookAuthor=rs.getString("author");
                int bookQuantity=rs.getInt("quantity");
                
                Object[] obj={bookID,bookName,bookAuthor,bookQuantity};
                model=(DefaultTableModel)tbl_bookDetails.getModel();
                model.addRow(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setDataToCard(){
        Statement st=null;
        ResultSet rs=null;
        
        long l=System.currentTimeMillis();
        Date todaysDate=new Date(l);
        
        try{
            Connection con=DBConnection.getConnection();
            st=con.createStatement();
            rs=st.executeQuery("select count(*) as total from books_details");
            if(rs.next()){
                int rowCount=rs.getInt("total");
                lbl_noofbooks.setText(Integer.toString(rowCount));
            }else {
                // Handle the case when the result set is empty
                lbl_noofbooks.setText("0");
            }
            rs=st.executeQuery("select count(*) as total from student_details");
            if(rs.next()){
                int rowCount=rs.getInt("total");
                lbl_noofstudents.setText(Integer.toString(rowCount));
            }else {
                // Handle the case when the result set is empty
                lbl_noofbooks.setText("0");
            }
            rs=st.executeQuery("select count(*) as total from issue_book_details");
            if(rs.next()){
                int rowCount=rs.getInt("total");
                lbl_issuebooks.setText(Integer.toString(rowCount));
            }else {
                // Handle the case when the result set is empty
                lbl_noofbooks.setText("0");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lbl_noofbooks = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lbl_noofstudents = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lbl_issuebooks = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        panelBarChart = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1080, 690));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 5, 40));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 102, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel2.setText("WELCOME, ADMIN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ONLINE LIBRARY MANAGEMENT SYSTEM");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 60));

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel5.setText("  Manage Students");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 230, 40));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 102, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.setText("  HOME PAGE");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 230, 50));

        jPanel6.setBackground(new java.awt.Color(102, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 102, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel7.setText("LMS DASHBOARD");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 230, 40));

        jPanel7.setBackground(new java.awt.Color(102, 204, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 102));
        jLabel9.setText("FEATURES");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 230, 40));

        jPanel8.setBackground(new java.awt.Color(153, 102, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel8.setText("  Logout");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 230, 50));

        jPanel9.setBackground(new java.awt.Color(102, 204, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel10.setText("  Manage Books");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 230, 40));

        jPanel10.setBackground(new java.awt.Color(102, 204, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel11.setText("  Issue Book");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 40));

        jPanel11.setBackground(new java.awt.Color(102, 204, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel12.setText("  Return Book");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 230, 40));

        jPanel12.setBackground(new java.awt.Color(102, 204, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel13.setText("  View Records");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel12.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 230, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 630));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("STUDENT DETAILS:");
        jPanel15.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(153, 102, 255)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noofbooks.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 50)); // NOI18N
        lbl_noofbooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noofbooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noofbooks.setText("10");
        jPanel17.add(lbl_noofbooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, 110));

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("NO. OF BOOKS:");
        jPanel15.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 153, 153)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noofstudents.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 50)); // NOI18N
        lbl_noofstudents.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noofstudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noofstudents.setText("10");
        jPanel18.add(lbl_noofstudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel15.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 190, 110));

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("NO. OF STUDENTS:");
        jPanel15.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(153, 102, 255)));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_issuebooks.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 50)); // NOI18N
        lbl_issuebooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_issuebooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_issuebooks.setText("10");
        jPanel19.add(lbl_issuebooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel15.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 190, 110));

        jLabel23.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("ISSUED BOOKS:");
        jPanel15.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("NO. OF BOOKS:");
        jPanel15.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel27.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("BOOK DETAILS:");
        jPanel15.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        panelBarChart.setLayout(new java.awt.BorderLayout());
        jPanel15.add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 320, 320));

        tbl_bookDetails.setForeground(java.awt.Color.darkGray);
        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(255, 153, 153));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(255, 153, 153));
        tbl_bookDetails.setColorFilasBackgound1(new java.awt.Color(204, 204, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(204, 204, 255));
        tbl_bookDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_bookDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_bookDetails.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 153, 153));
        tbl_bookDetails.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        tbl_bookDetails.setRowHeight(30);
        jScrollPane3.setViewportView(tbl_bookDetails);

        jPanel15.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 410, 170));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(204, 204, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(204, 204, 255));
        tbl_studentDetails.setColorFilasBackgound1(new java.awt.Color(255, 204, 204));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 204, 204));
        tbl_studentDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 102, 102));
        tbl_studentDetails.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        tbl_studentDetails.setRowHeight(30);
        jScrollPane4.setViewportView(tbl_studentDetails);

        jPanel15.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 410, 170));

        getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 850, 630));

        setSize(new java.awt.Dimension(1082, 690));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {                                     
        System.exit(0);
    }                                    

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {                                      
        ManageBook page=new ManageBook();
        page.setVisible(true);
        this.dispose();
    }                                     

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {                                      
        jPanel9.setBackground(mouseEnterColor);
    }                                     

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {                                     
        jPanel9.setBackground(mouseExitColor);
    }                                    

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {                                     
        jPanel4.setBackground(mouseEnterColor);
    }                                    

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {                                    
        jPanel4.setBackground(mouseExitColor);
    }                                   

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {                                      
        jPanel10.setBackground(mouseEnterColor);
    }                                     

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {                                     
        jPanel10.setBackground(mouseExitColor);
    }                                    

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {                                      
        jPanel11.setBackground(mouseEnterColor);
    }                                     

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {                                     
        jPanel11.setBackground(mouseExitColor);
    }                                    

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {                                      
        jPanel12.setBackground(mouseEnterColor);
    }                                     

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {                                     
        jPanel12.setBackground(mouseExitColor);
    }                                    

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {                                     
        jPanel8.setBackground(mouseEnterColor);
    }                                    

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {                                    
        jPanel8.setBackground(mouseExitColor);
    }                                   

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {                                     
        ManageStudents page=new ManageStudents();
        page.setVisible(true);
        this.dispose();
    }                                    

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {                                      
        IssueBook page=new IssueBook();
        page.setVisible(true);
        this.dispose();
    }                                     

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {                                      
        ReturnBook page=new ReturnBook();
        page.setVisible(true);
        this.dispose();
    }                                     

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {                                      
        ViewAllRecord page= new ViewAllRecord();
        page.setVisible(true);
        this.dispose();
    }                                     

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {                                     
        JOptionPane.showMessageDialog(this, "Logging out.");
        SignUpPage page=new SignUpPage();
        page.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_issuebooks;
    private javax.swing.JLabel lbl_noofbooks;
    private javax.swing.JLabel lbl_noofstudents;
    private javax.swing.JPanel panelBarChart;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    // End of variables declaration                   
}
