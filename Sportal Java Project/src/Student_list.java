
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KINSHUK
 */
public class Student_list extends javax.swing.JFrame {

    /**
     * Creates new form Student_list
     */
    public Student_list() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        txt_enrol = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Details");
        setMinimumSize(new java.awt.Dimension(976, 580));
        getContentPane().setLayout(null);

        jButton4.setBackground(new java.awt.Color(102, 0, 0));
        jButton4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Go");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(350, 230, 90, 40);

        txt_enrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_enrolActionPerformed(evt);
            }
        });
        getContentPane().add(txt_enrol);
        txt_enrol.setBounds(350, 170, 150, 40);

        jLabel2.setFont(new java.awt.Font("Script MT Bold", 1, 36)); // NOI18N
        jLabel2.setText("Enrollment No. :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 170, 270, 40);

        jLabel3.setBackground(new java.awt.Color(51, 0, 51));
        jLabel3.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("                          Student Details");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel3.setOpaque(true);
        jLabel3.setRequestFocusEnabled(false);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 54, 960, 60);

        jButton5.setBackground(new java.awt.Color(0, 0, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(60, 470, 120, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sportal - Copy.jpg"))); // NOI18N
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 540);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String stxt=txt_enrol.getText();
        System.out.println("Value taken from textbox in Student_list page:"+stxt);
        String g1=null,g2=null,g3=null,amt=null;
        int ss=0;
        Regis_Page ob=new Regis_Page();
        ob.hidd.setText(stxt);
        if(stxt.isEmpty())
        { JOptionPane.showMessageDialog(null,"Input Required."); }
        else
        { //System.out.println(stxt);
        try
        {
        Class.forName("java.sql.Driver");
        Class.forName("java.sql.Driver");
        Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sportal","root","");
        PreparedStatement pstmt =conn.prepareStatement("select * from student_details where enrol_no='"+stxt+"'");
        ResultSet rs=pstmt.executeQuery();
        if(rs.next())
        {        
        ob.txt_enroll.setText(rs.getString("ENROL_NO"));
        ob.txt_name.setText(rs.getString("STUDENT_NAME"));
        ob.txt_fname.setText(rs.getString("FATHER_NAME"));
        ob.com_gender.setSelectedItem(rs.getString("GENDER"));
        ob.com_course.setSelectedItem(rs.getString("COURSE"));
        ob.com_year.setSelectedItem(rs.getString("YEAR"));
        ob.com_section.setSelectedItem(rs.getString("SECTION"));
        ob.txt_mobile.setText(rs.getString("PHONE_NO"));
        ob.txt_email.setText(rs.getString("EMAIL_ID"));
        ob.setTitle("Searched Result for :"+stxt);
        
         //setting image
        /* InputStream inP=rs.getBinaryStream("PICTURE");    //this is returning null IN some case
         //System.out.println(inP);
         BufferedImage im=null;
         try
         {
         im=ImageIO.read(inP);
         }
         catch(IOException e)
         {
             System.out.println("Error in reading image from database"+e);
         }*/
         
         /*BufferedImage outimage =new BufferedImage(im.getWidth(),im.getHeight(),BufferedImage.TYPE_INT_RGB);
         Graphics2D g=outimage.createGraphics();
         
         float xScale=(float)im.getWidth()/outimage.getWidth();
         float yScale=(float)im.getHeight()/outimage.getHeight();
         AffineTransform at=AffineTransform.getScaleInstance(xScale,yScale);
         g.drawRenderedImage(im, at);
         g.dispose();
         Image scaledImage=outimage.getScaledInstance(im.getWidth(),im.getHeight(),im.SCALE_SMOOTH);
         ImageIcon icon=new ImageIcon(scaledImage);
         ob.lbl_img.setIcon(icon);*/
         
         ob.setVisible(true);
         ob.btn_submit.setVisible(false);
         
        }
        else
        {
        JOptionPane.showMessageDialog(null,"NO RECORD FOUND");
        }
      }
      catch(Exception e)
      {
      System.out.println("Error in connection"+e);
      }
        
     String txt=txt_enrol.getText();
          
     try
        { Class.forName("java.sql.Driver");
        Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sportal","root","");
        PreparedStatement pstmt =conn.prepareStatement("select * from student_games where enrol_no='"+txt+"'");
        ResultSet rs=pstmt.executeQuery();
        if(rs.next())
        { // System.out.print("yESSSSSSS IT Happen");
           ss=1;
            ob.txt_enroll.setText(rs.getString("ENROL_NO"));
           g1=rs.getString("GAME_1");
           g2=rs.getString("GAME_2");
           g3=rs.getString("GAME_3");        
           amt=rs.getString("FEES");    
           ob.com_fee.setSelectedItem(rs.getString("FEES_STATUS"));
           ob.com_paymode.setSelectedItem(rs.getString("PAYMENT_MODE"));
        }
         else
        { //System.out.println("WHYYY NOT");
            JOptionPane.showMessageDialog(null,"NO RECORD FOUND GAME Table");      }
      }
      catch(Exception e)
      { System.out.println("Error in connection"+e); }
       
     if(ss==1)
       { if(("Cricket").equals(g1)||("Cricket").equals(g2)||("Cricket").equals(g3))
          { ob.cricket.doClick(); } 
         if(("Football").equals(g1)||("Football").equals(g2)||("Football").equals(g3))
          { ob.football.doClick(); } 
         if(("Volley Ball").equals(g1)||("Volley Ball").equals(g2)||("Volley Ball").equals(g3))
          { ob.volley.doClick(); } 
         if(("Basket Ball").equals(g1)||("Basket Ball").equals(g2)||("Basket Ball").equals(g3))
          { ob.basket.doClick(); } 
         if(("Table Tennis").equals(g1)||("Table Tennis").equals(g2)||("Table Tennis").equals(g3))
          { ob.tt.doClick(); } 
         if(("Chess").equals(g1)||("Chess").equals(g2)||("Chess").equals(g3))
          { ob.chess.doClick(); } 
         if(("Carrom").equals(g1)||("Carrom").equals(g2)||("Carrom").equals(g3))
          { ob.carrom.doClick(); } 
         if(("Tug Of War").equals(g1)||("Tug Of War").equals(g2)||("Tug Of War").equals(g3))
          { ob.tug.doClick(); } 
         if(("Badminton").equals(g1)||("Badminton").equals(g2)||("Badminton").equals(g3))
          { ob.badminton.doClick(); } 
         if(("Kabaddi").equals(g1)||("Kabaddi").equals(g2)||("Kabaddi").equals(g3))
          { ob.kabaddi.doClick(); } 
         if(("Race 100m").equals(g1)||("Race 100m").equals(g2)||("Race 100m").equals(g3))
          { ob.race100.doClick(); } 
         if(("Squash").equals(g1)||("Squash").equals(g2)||("Squash").equals(g3))
          { ob.squash.doClick(); } 
         if(("Race 200m").equals(g1)||("Race 200m").equals(g2)||("Race 200m").equals(g3))
          { ob.race200.doClick(); } 
         if(("Shotput").equals(g1)||("Shotput").equals(g2)||("Shotput").equals(g3))
          { ob.shotput.doClick(); } 
        }
     }        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_enrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_enrolActionPerformed
               String stxt=txt_enrol.getText();
        System.out.println("Value taken from textbox in Student_list page:"+stxt);
        String g1=null,g2=null,g3=null,amt=null;
        int ss=0;
        Regis_Page ob=new Regis_Page();
        ob.hidd.setText(stxt);
        if(stxt.isEmpty())
        { JOptionPane.showMessageDialog(null,"Input Required."); }
        else
        { //System.out.println(stxt);
        try
        {
        Class.forName("java.sql.Driver");
        Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sportal","root","");
        PreparedStatement pstmt =conn.prepareStatement("select * from student_details where enrol_no='"+stxt+"'");
        ResultSet rs=pstmt.executeQuery();
        if(rs.next())
        {        
        ob.txt_enroll.setText(rs.getString("ENROL_NO"));
        ob.txt_name.setText(rs.getString("STUDENT_NAME"));
        ob.txt_fname.setText(rs.getString("FATHER_NAME"));
        ob.com_gender.setSelectedItem(rs.getString("GENDER"));
        ob.com_course.setSelectedItem(rs.getString("COURSE"));
        ob.com_year.setSelectedItem(rs.getString("YEAR"));
        ob.com_section.setSelectedItem(rs.getString("SECTION"));
        ob.txt_mobile.setText(rs.getString("PHONE_NO"));
        ob.txt_email.setText(rs.getString("EMAIL_ID"));
        ob.setTitle("Searched Result for :"+stxt);
        
         //setting image
        /* InputStream inP=rs.getBinaryStream("PICTURE");    //this is returning null IN some case
         //System.out.println(inP);
         BufferedImage im=null;
         try
         {
         im=ImageIO.read(inP);
         }
         catch(IOException e)
         {
             System.out.println("Error in reading image from database"+e);
         }*/
         
         /*BufferedImage outimage =new BufferedImage(im.getWidth(),im.getHeight(),BufferedImage.TYPE_INT_RGB);
         Graphics2D g=outimage.createGraphics();
         
         float xScale=(float)im.getWidth()/outimage.getWidth();
         float yScale=(float)im.getHeight()/outimage.getHeight();
         AffineTransform at=AffineTransform.getScaleInstance(xScale,yScale);
         g.drawRenderedImage(im, at);
         g.dispose();
         Image scaledImage=outimage.getScaledInstance(im.getWidth(),im.getHeight(),im.SCALE_SMOOTH);
         ImageIcon icon=new ImageIcon(scaledImage);
         ob.lbl_img.setIcon(icon);*/
         
         ob.setVisible(true);
         ob.btn_submit.setVisible(false);
         
        }
        else
        {
        JOptionPane.showMessageDialog(null,"NO RECORD FOUND");
        }
      }
      catch(Exception e)
      {
      System.out.println("Error in connection"+e);
      }
        
     String txt=txt_enrol.getText();
          
     try
        { Class.forName("java.sql.Driver");
        Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sportal","root","");
        PreparedStatement pstmt =conn.prepareStatement("select * from student_games where enrol_no='"+txt+"'");
        ResultSet rs=pstmt.executeQuery();
        if(rs.next())
        { // System.out.print("yESSSSSSS IT Happen");
           ss=1;
           ob.txt_enroll.setText(rs.getString("ENROL_NO"));
           g1=rs.getString("GAME_1");
           g2=rs.getString("GAME_2");
           g3=rs.getString("GAME_3");        
           amt=rs.getString("FEES");    
           ob.com_fee.setSelectedItem(rs.getString("FEES_STATUS"));
           ob.com_paymode.setSelectedItem(rs.getString("PAYMENT_MODE"));           
        }
         else
        { //System.out.println("WHYYY NOT");
            JOptionPane.showMessageDialog(null,"NO RECORD FOUND GAME Table");      }
      }
      catch(Exception e)
      { System.out.println("Error in connection"+e); }
       if(ss==1)
       { if(("Cricket").equals(g1)||("Cricket").equals(g2)||("Cricket").equals(g3))
          { ob.cricket.doClick(); } 
         if(("Football").equals(g1)||("Football").equals(g2)||("Football").equals(g3))
          { ob.football.doClick(); } 
         if(("Volley Ball").equals(g1)||("Volley Ball").equals(g2)||("Volley Ball").equals(g3))
          { ob.volley.doClick(); } 
         if(("Basket Ball").equals(g1)||("Basket Ball").equals(g2)||("Basket Ball").equals(g3))
          { ob.basket.doClick(); } 
         if(("Table Tennis").equals(g1)||("Table Tennis").equals(g2)||("Table Tennis").equals(g3))
          { ob.tt.doClick(); } 
         if(("Chess").equals(g1)||("Chess").equals(g2)||("Chess").equals(g3))
          { ob.chess.doClick(); } 
         if(("Carrom").equals(g1)||("Carrom").equals(g2)||("Carrom").equals(g3))
          { ob.carrom.doClick(); } 
         if(("Tug Of War").equals(g1)||("Tug Of War").equals(g2)||("Tug Of War").equals(g3))
          { ob.tug.doClick(); } 
         if(("Badminton").equals(g1)||("Badminton").equals(g2)||("Badminton").equals(g3))
          { ob.badminton.doClick(); } 
         if(("Kabaddi").equals(g1)||("Kabaddi").equals(g2)||("Kabaddi").equals(g3))
          { ob.kabaddi.doClick(); } 
         if(("Race 100m").equals(g1)||("Race 100m").equals(g2)||("Race 100m").equals(g3))
          { ob.race100.doClick(); } 
         if(("Squash").equals(g1)||("Squash").equals(g2)||("Squash").equals(g3))
          { ob.squash.doClick(); } 
         if(("Race 200m").equals(g1)||("Race 200m").equals(g2)||("Race 200m").equals(g3))
          { ob.race200.doClick(); } 
         if(("Shotput").equals(g1)||("Shotput").equals(g2)||("Shotput").equals(g3))
          { ob.shotput.doClick(); } 
        }
     }        

    }//GEN-LAST:event_txt_enrolActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
        new Menu_Page().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Student_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_list().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField txt_enrol;
    // End of variables declaration//GEN-END:variables
}