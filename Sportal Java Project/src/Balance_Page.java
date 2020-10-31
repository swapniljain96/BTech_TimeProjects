
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Cell;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KINSHUK
 */
public class Balance_Page extends javax.swing.JFrame {

    /**
     * Creates new form Balance_Page
     */
    public Balance_Page() {
        initComponents();
    }
    showtable ob = new showtable();
    DefaultTableModel mod = (DefaultTableModel) ob.full_table.getModel();
    DefaultTableModel model = (DefaultTableModel) ob.tab.getModel();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        com_game = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        com_fee = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Balance Details");
        setMinimumSize(new java.awt.Dimension(976, 580));
        getContentPane().setLayout(null);

        jLabel3.setBackground(new java.awt.Color(51, 0, 51));
        jLabel3.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("                          BALANCE Details");
        jLabel3.setToolTipText("");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel3.setOpaque(true);
        jLabel3.setRequestFocusEnabled(false);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(3, 60, 954, 60);

        jLabel2.setFont(new java.awt.Font("Script MT Bold", 1, 36)); // NOI18N
        jLabel2.setText("Game :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 170, 120, 50);

        back.setBackground(new java.awt.Color(51, 0, 51));
        back.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(40, 771, 90, 40);

        com_game.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        com_game.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Option", "All Games", "Cricket", "FootBall", "VolleyBall", "BasketBall", "Table Tennis", "Chess", "Carrom", "Tug Of War", "Badminton", " Kabaddi", "Race 100m", "Squash", "Race 200m", "Shot put" }));
        getContentPane().add(com_game);
        com_game.setBounds(230, 180, 290, 40);

        jLabel4.setFont(new java.awt.Font("Script MT Bold", 1, 36)); // NOI18N
        jLabel4.setText("Fees :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 230, 100, 50);

        jButton5.setBackground(new java.awt.Color(0, 51, 51));
        jButton5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Go");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(230, 310, 90, 40);

        com_fee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "Unpaid" }));
        getContentPane().add(com_fee);
        com_fee.setBounds(230, 240, 120, 40);

        jButton3.setBackground(new java.awt.Color(0, 0, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(60, 470, 120, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sportal - Copy.jpg"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 540);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String getCellValue(int x, int y) {
        return model.getValueAt(x, y).toString();
    }
    private String getCellValues(int x, int y) {
        return mod.getValueAt(x, y).toString();
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
         this.dispose();
         //new Menu_Page().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        //String fold="C:/Sportal Reports";
        File directory = new File("C:/Sportal Reports");
        if(!directory.exists())
        {
           directory.mkdir();
           //JOptionPane.showMessageDialog(null, "directory Created");
        }
      /*  
        else
        {
         JOptionPane.showMessageDialog(null, "directory Already Exists");
        }
      */
      
        String game = (String) com_game.getSelectedItem();
        String status = (String) com_fee.getSelectedItem();
        
        if(game.equals("Select Option"))
         { JOptionPane.showMessageDialog(null,"Please select the game."); }
         
        else if (game.equalsIgnoreCase("All Games")) 
        {   ob.lbll.setText(status);
            mod.fireTableDataChanged();
                try {
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportal", "root", "");
                Statement stmt = con.createStatement();
                String que = "select s.enrol_no,s.student_name,s.course,s.section,s.year,s.phone_no,g.game_1,g.game_2,g.game_3,g.fees_status "
                        + "from student_details as s,student_games as g where (s.enrol_no=g.enrol_no) AND g.fees_status='" + status + "'";
                ResultSet rs = stmt.executeQuery(que);
                int i=0;
                while (rs.next()) {
                    String enrol = rs.getString(1);
                    String name = rs.getString(2);
                    String course = rs.getString(3);
                    String sec = rs.getString(4);
                    String year = rs.getString(5);
                    String mob = rs.getString(6);
                    String g1 = rs.getString(7);
                    String g2 = rs.getString(8);
                    String g3 = rs.getString(9);
                    String stat = rs.getString(10);
                    i++;
                    mod.addRow(new Object[]{i,enrol, name, course, sec, year, mob, g1, g2, g3, stat});
                 }
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) 
              { JOptionPane.showMessageDialog(null, "Error in connectivity");     }
            
            XSSFWorkbook wbb = new XSSFWorkbook();
            XSSFSheet wss = wbb.createSheet();

            TreeMap<String, Object[]> data = new TreeMap();
            data.put("-1", new Object[]{mod.getColumnName(0), mod.getColumnName(1), mod.getColumnName(2), mod.getColumnName(3), mod.getColumnName(4), mod.getColumnName(5), mod.getColumnName(6), mod.getColumnName(7), mod.getColumnName(8), mod.getColumnName(9), mod.getColumnName(10)});

            for (int i = 0; i < mod.getRowCount(); i++) {
                data.put(Integer.toString(i), new Object[]{getCellValues(i, 0), getCellValues(i, 1), getCellValues(i, 2), getCellValues(i, 3), getCellValues(i, 4), getCellValues(i, 5), getCellValues(i, 6), getCellValues(i, 7), getCellValues(i, 8), getCellValues(i, 9), getCellValues(i,10)});
            }
            
            Set<String> idss = data.keySet();
            XSSFRow row;
            int rowID = 0;
            for (String key : idss) {
                row = wss.createRow(rowID++);

                Object[] value = data.get(key);
                int cellID = 0;
                for (Object o : value) {
                    XSSFCell cell = row.createCell(cellID++);
                    cell.setCellValue(o.toString());
                }
            }

            try {
                String ss = "C:/Sportal Reports/" + game + "_" + status + ".xlsx";
                System.out.println(ss);
                FileOutputStream fos = new FileOutputStream(new File(ss));
                wbb.write(fos);
                fos.close();
            } 
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(WorkBookNSheet.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(ExcelGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            ob.full_tab.setVisible(true);
        } 
            
            else 
        {  //ob.lbll.setText(status);
            model.fireTableDataChanged();
           String ssj="List of "+game+" having status: "+status;
           ob.lbl_game.setText(ssj);
           try {
                Class.forName("java.sql.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportal", "root", "");
                Statement stmt = con.createStatement();
                String que = "select s.enrol_no,s.student_name,s.course,s.section,s.year,s.phone_no,g.fees_status from student_details as s,student_games as g  "
                        + "where (s.enrol_no=g.enrol_no) "
                        + "AND (g.game_1='" + game + "' OR g.game_2='" + game + "' OR g.game_3='" + game + "') AND g.fees_status='" + status + "'"; 
                ResultSet rs = stmt.executeQuery(que);
                int i=1;
                while (rs.next()) {
                    String enrol = rs.getString(1);
                    String name = rs.getString(2);
                    String course = rs.getString(3);
                    String sec = rs.getString(4);
                    String year = rs.getString(5);
                    String mob = rs.getString(6);
                    String stat = rs.getString(7);
                    model.addRow(new Object[]{i,enrol, name, course, sec, year, mob, stat});
                    i++;               
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error in connectivity");
            }
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet ws = wb.createSheet();

            TreeMap<String, Object[]> data = new TreeMap();
            data.put("-1", new Object[]{model.getColumnName(0),model.getColumnName(1), model.getColumnName(2), model.getColumnName(3), model.getColumnName(4), model.getColumnName(5), model.getColumnName(6), model.getColumnName(7)});

            for (int i = 0; i < model.getRowCount(); i++) {
                data.put(Integer.toString(i), new Object[]{getCellValue(i, 0), getCellValue(i, 1), getCellValue(i, 2), getCellValue(i, 3), getCellValue(i, 4), getCellValue(i, 5), getCellValue(i, 6), getCellValue(i, 7)});
            }
            
            Set<String> ids = data.keySet();
            XSSFRow row;
            int rowID = 0;
            for (String key : ids) {
                row = ws.createRow(rowID++);

                Object[] values = data.get(key);
                int cellID = 0;
                for (Object o : values) {
                    XSSFCell cell = row.createCell(cellID++);
                    cell.setCellValue(o.toString());
                }
            }
            try {
                String ss = "C:/Sportal Reports/" + game + "_" + status + ".xlsx";
                System.out.println(ss);
                FileOutputStream fos = new FileOutputStream(new File(ss));
                wb.write(fos);
                fos.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(WorkBookNSheet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ExcelGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            ob.setVisible(true);
        }
        //new Menu_Page().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        //new Menu_Page().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Balance_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Balance_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Balance_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Balance_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Balance_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton back;
    private javax.swing.JComboBox<String> com_fee;
    private javax.swing.JComboBox<String> com_game;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
