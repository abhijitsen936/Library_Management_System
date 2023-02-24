/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import java.sql.Date;


/**
 *
 * @author abhij
 */




public class HomePage extends javax.swing.JFrame {

    
    Color mouseEnterColor = new Color (0,0,0);

Color mouseExitColor= new Color (51,51,51);
    /**
     * Creates new form HomePage
     */
   DefaultTableModel model;
    public HomePage() {
        initComponents();
        showPieChart();
        setStudentDetailsToTable();
        setBookDetailsToTable();
        setDataToCards();
    }
    
    
    //to set the book details to the table...............
    public void setBookDetailsToTable(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root","");
            Statement st= con.createStatement();
             ResultSet rs=st.executeQuery("select * from book_details");
             
             while(rs.next()){
                String bookId= rs.getString("book_id");
                String bookName= rs.getString("book_name");
                String author = rs.getString("author");
                int quantity = rs.getInt("quantity");
              Object[] obj ={bookId,bookName,author,quantity};
              model=(DefaultTableModel) tbl_bookDetails.getModel();
              model.addRow(obj);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    //to set the book details to the table...............
    public void setStudentDetailsToTable(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root","");
            Statement st= con.createStatement();
             ResultSet rs=st.executeQuery("select * from student_details");
             
             while(rs.next()){
                String studentId= rs.getString("student_id");
                String studentName= rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
              Object[] obj ={studentId,studentName,course,branch};
              model=(DefaultTableModel) tbl_studentDetails.getModel();
              model.addRow(obj);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    public void setDataToCards () {
Statement st = null;
ResultSet rs = null;
long l = System.currentTimeMillis();
Date todaysDate = new Date(l);
try {
Connection con= DBConnection.getConnection();
st = con.createStatement();
rs = st.executeQuery("select * from book_details");
rs.last();
lbl_noOfBooks.setText(Integer.toString(rs.getRow()));

rs=st.executeQuery("select * from student_details"); 
rs.last();
lbl_noOfStudent.setText (Integer.toString (rs.getRow()));

rs=st.executeQuery("select * from issue_book_details"); 
rs.last();
lbl_issueBookss.setText (Integer.toString (rs.getRow()));

rs=st.executeQuery("select * from issue_book_details where due_date < '"+todaysDate+"' and status='"+"pending"+"'"); 
rs.last();
lbl_defaulterListt.setText (Integer.toString (rs.getRow()));




} catch (Exception e){ 
    e.printStackTrace();
}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
        try {
            Connection con= DBConnection.getConnection();
            String sql="select book_name, count(*) as issue_count from issue_book_details group by book_id";
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
 
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        pannelPieChart.removeAll();
        pannelPieChart.add(barChartPanel, BorderLayout.CENTER);
        pannelPieChart.validate();
    }

    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        lbl_noOfStudent = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        lbl_defaulterListt = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        lbl_issueBookss = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        pannelPieChart = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1570, 970));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel1.setText("Welcome Admin");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 10, 220, 50));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 16, 300, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("X");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 70));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_noOfBooks.setBackground(new java.awt.Color(102, 102, 102));
        lbl_noOfBooks.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noOfBooks.setText("10");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(lbl_noOfBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbl_noOfBooks)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 260, 140));

        jLabel13.setBackground(new java.awt.Color(102, 102, 102));
        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel13.setText("Student Details");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 130, -1));

        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_noOfStudent.setBackground(new java.awt.Color(102, 102, 102));
        lbl_noOfStudent.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_noOfStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noOfStudent.setText("10");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl_noOfStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbl_noOfStudent)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel20.setBackground(new java.awt.Color(102, 102, 102));
        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel20.setText("No Of Student");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 130, -1));

        jPanel21.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_defaulterListt.setBackground(new java.awt.Color(102, 102, 102));
        lbl_defaulterListt.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_defaulterListt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_defaulterListt.setText("10");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl_defaulterListt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbl_defaulterListt)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 260, 140));

        jLabel22.setBackground(new java.awt.Color(102, 102, 102));
        jLabel22.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel22.setText("Defaulter List");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 130, -1));

        jPanel22.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_issueBookss.setBackground(new java.awt.Color(102, 102, 102));
        lbl_issueBookss.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_issueBookss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_issueBookss.setText("10");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lbl_issueBookss, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbl_issueBookss)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 260, 140));

        jLabel24.setBackground(new java.awt.Color(102, 102, 102));
        jLabel24.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel24.setText("Issued Books");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 130, -1));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorFilasForeground1(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasForeground2(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setRowHeight(30);
        jScrollPane1.setViewportView(tbl_studentDetails);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 670, 180));

        jLabel25.setBackground(new java.awt.Color(102, 102, 102));
        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel25.setText("No Of Books");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, -1));

        jLabel26.setBackground(new java.awt.Color(102, 102, 102));
        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel26.setText("Book Details");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 130, -1));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Author", "Branch"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorFilasForeground1(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasForeground2(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setRowHeight(30);
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 670, 180));

        pannelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel5.add(pannelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 450, 350));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1230, 970));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.setText("    Home Page");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 340, 60));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(51, 51, 51));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Features");
        jPanel13.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 150, -1));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 50));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(51, 51, 51));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel14.setText("     View Records");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel15.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 170, -1));

        jPanel12.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 340, 60));

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(51, 51, 51));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel16.setText("     Manage Students");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        jPanel17.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 180, -1));

        jPanel12.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 340, 60));

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel18.setText("     Return Books");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        jPanel19.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 180, -1));

        jPanel12.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 340, 60));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel9.setText("     View Issued Books ");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 200, -1));

        jPanel12.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 60));

        jPanel7.setBackground(new java.awt.Color(102, 102, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel7.setText("     Logout");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
        });
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, -1));

        jPanel12.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 340, 60));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel10.setText("     Defaulter List ");
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
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 180, -1));

        jPanel12.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 340, 60));

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.setForeground(new java.awt.Color(153, 153, 153));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel15.setText("     LMS Dashboard");
        jPanel16.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 170, -1));

        jPanel12.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 340, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel8.setText("     Manage Books");
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
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 170, -1));

        jPanel12.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 340, 60));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel11.setText("     Issue Books");
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
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 180, -1));

        jPanel12.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 340, 60));

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 930));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        setSize(new java.awt.Dimension(1556, 1040));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
                System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
            ManageBooks books=new ManageBooks();
            books.setVisible(true);
            dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jPanel8.setBackground (mouseEnterColor);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jPanel8.setBackground (mouseExitColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
jPanel17.setBackground (mouseEnterColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
jPanel17.setBackground (mouseExitColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        IssueBook book= new IssueBook();
        book.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jPanel11.setBackground(mouseEnterColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
         jPanel11.setBackground(mouseExitColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
ManageStudent book= new ManageStudent();
        book.setVisible(true);
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
ReturnBook book= new ReturnBook();
        book.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
  jPanel19.setBackground(mouseEnterColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
 jPanel19.setBackground(mouseExitColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
ViewAllRecord book= new ViewAllRecord();
        book.setVisible(true);
        dispose();  

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
jPanel15.setBackground(mouseEnterColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
  jPanel15.setBackground(mouseExitColor);  
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
IssueBookDetails book= new IssueBookDetails();
        book.setVisible(true);
        dispose();  

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
jPanel9.setBackground(mouseEnterColor);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
 jPanel9.setBackground(mouseExitColor);
 // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
DefaulterList book= new DefaulterList();
        book.setVisible(true);
        dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
     jPanel10.setBackground(mouseEnterColor);
     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
jPanel10.setBackground(mouseExitColor);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked

LoginPage book= new LoginPage();
        book.setVisible(true);
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_defaulterListt;
    private javax.swing.JLabel lbl_issueBookss;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfStudent;
    private javax.swing.JPanel pannelPieChart;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
