/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelma;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 *
 * @author Shubham Goyal
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        oki = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        upasswd = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(944, 848));
        getContentPane().setLayout(null);

        jLabel1.setText("Enter loginId");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 460, 89, 16);

        jLabel2.setText("Enter password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 540, 89, 16);

        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        getContentPane().add(uname);
        uname.setBounds(240, 450, 101, 22);

        oki.setText("Ok");
        oki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okiActionPerformed(evt);
            }
        });
        oki.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                okiKeyPressed(evt);
            }
        });
        getContentPane().add(oki);
        oki.setBounds(78, 613, 47, 25);

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(229, 613, 63, 25);

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(173, 671, 53, 25);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shubham Goyal\\Desktop\\Computer\\hotel-management-system.jpg")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(113, 90, 432, 280);

        upasswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upasswdActionPerformed(evt);
            }
        });
        getContentPane().add(upasswd);
        upasswd.setBounds(230, 540, 110, 22);

        jButton4.setText("Signup");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(430, 660, 79, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okiActionPerformed
        // TODO add your handling code here:
        try{
            String name=uname.getText().trim();
            String pwd=new String(upasswd.getPassword());
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava","root","shubham");
            PreparedStatement s=c.prepareStatement("select * from customerlogin where username=? and password=?");
           // System.out.println(pwd);
          // String q="select * from logintable where username="+name+" and password="+pwd;
          s.setString(1,name);
          s.setString(2,pwd);
            ResultSet r=s.executeQuery();
            if(r.next())
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Successful");
                MainFrame m=new MainFrame();
                m.setVisible(true);
                this.setVisible(false);
            }
            else
            {
                javax.swing.JOptionPane.showConfirmDialog(this, "try again!","he lel",JOptionPane.YES_NO_CANCEL_OPTION);
            }
        }
        catch(Exception e)
        {
               javax.swing.JOptionPane.showMessageDialog(this, "Contact admin"+e);
        }
       /* String un=uname.getText().trim();
         String pd = new String(upasswd.getPassword());
        if(un.equals("admin")&&pd.equals("admin"))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Successful");
            MainFrame m= new MainFrame();
            this.setVisible(false);
            m.setVisible(true);
        }
        else
        {
            javax.swing.JOptionPane.showMessageDialog(this, "try again");
            uname.grabFocus();
            uname.setText("");
            upasswd.setText("");
        }*/
    }//GEN-LAST:event_okiActionPerformed

    private void upasswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upasswdActionPerformed
        oki.grabFocus();
    }//GEN-LAST:event_upasswdActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        uname.setText("");
        upasswd.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
        upasswd.grabFocus();
    }//GEN-LAST:event_unameActionPerformed

    private void okiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_okiKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
               try{
            String name=uname.getText().trim();
            String pwd=new String(upasswd.getPassword());
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava","root","shubham");
            PreparedStatement s=c.prepareStatement("select * from customerlogin where username=? and password=?");
           // System.out.println(pwd);
          // String q="select * from logintable where username="+name+" and password="+pwd;
          s.setString(1,name);
          s.setString(2,pwd);
            ResultSet r=s.executeQuery();
            if(r.next())
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Successful");
                MainFrame m=new MainFrame();
                m.setVisible(true);
                this.setVisible(false);
            }
            else
            {
                javax.swing.JOptionPane.showConfirmDialog(this, "try again!","he lel",JOptionPane.YES_NO_CANCEL_OPTION);
            }
        }
        catch(Exception e)
        {
               javax.swing.JOptionPane.showMessageDialog(this, "Contact admin"+e);
        }
        }
    }//GEN-LAST:event_okiKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Signup f=new Signup();
        f.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton oki;
    private javax.swing.JTextField uname;
    private javax.swing.JPasswordField upasswd;
    // End of variables declaration//GEN-END:variables
}
