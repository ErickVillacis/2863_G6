/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifastreet;

import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.ICONIFIED;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author KB
 */
public class Login extends javax.swing.JDialog

{   ImageIcon img1;
    String[][] tabla1=new String[2][5];
    boolean iniciado=false;
    int sesion=0;
            
    public Login(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        ImageIcon img1=new ImageIcon("imagenlogin.png");
        jLabel5.setHorizontalAlignment(JLabel.CENTER);
        jLabel5.setIcon(new ImageIcon(img1.getImage().getScaledInstance(jLabel5.getWidth(),jLabel5.getHeight(),Image.SCALE_DEFAULT)));
        
        ImageIcon img2=new ImageIcon("rightPanel.png");
        jLabel7.setHorizontalAlignment(JLabel.CENTER);
        jLabel7.setIcon(new ImageIcon(img2.getImage().getScaledInstance(jLabel7.getWidth(),jLabel7.getHeight(),Image.SCALE_DEFAULT)));
        
        ImageIcon img3=new ImageIcon("btnsignUp.png");
        btnLogon.setIcon(new ImageIcon(img3.getImage().getScaledInstance(btnLogon.getWidth(),btnLogon.getHeight(),Image.SCALE_DEFAULT)));
        btnLogon1.setIcon(new ImageIcon(img3.getImage().getScaledInstance(btnLogon1.getWidth(),btnLogon1.getHeight(),Image.SCALE_DEFAULT)));
        
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        this.setBackground(new Color(0,0,0,0));
        jPanel1.setBackground(new Color(0,0,0,0));
        
        this.repaint();
    }

     public int showDialog()
     {
         this.setVisible(true);
         return this.sesion;
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnLogon1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLogon = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inicio de Sesión");
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Salir");
        jLabel6.setFocusable(false);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 110, 30));

        btnLogon1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogon1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogon1.setActionCommand("btnLogon1");
        btnLogon1.setBorder(null);
        btnLogon1.setOpaque(false);
        btnLogon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogon1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 110, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingresar");
        jLabel1.setFocusable(false);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 100, 30));

        btnLogon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogon.setForeground(new java.awt.Color(255, 255, 255));
        btnLogon.setBorder(null);
        btnLogon.setEnabled(false);
        btnLogon.setOpaque(false);
        btnLogon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogonActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogon, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 100, 30));

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPass.setForeground(new java.awt.Color(153, 153, 153));
        txtPass.setText("***********");
        txtPass.setBorder(null);
        txtPass.setEnabled(false);
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
        });
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPassKeyReleased(evt);
            }
        });
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 102, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, -1, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Ingrese usuario");
        txtNombre.setBorder(null);
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 102, -1));

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 100, 10));

        jSeparator2.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 100, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inicio de Sesión");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 376, 423));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 376, 423));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(!iniciado)
        {
             System.exit(0);  
        }
      
    }//GEN-LAST:event_formWindowClosing

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
  
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased

        if(!txtNombre.getText().equals(""))
       {
           txtPass.setEnabled(true);
       }
        else if(txtNombre.getText().equals(""))
       {
           txtPass.setEnabled(false);
       }   
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyReleased
           if(!txtPass.getText().equals(""))
       {
           if (KeyEvent.VK_ENTER == evt.getKeyCode()) 
           {
                btnLogon.doClick();
            }
           btnLogon.setEnabled(true);
       }
        else if(txtPass.getText().equals(""))
       {
           btnLogon.setEnabled(false);
       }   
    }//GEN-LAST:event_txtPassKeyReleased

    private void btnLogonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogonActionPerformed
          ConexionDB conn= new ConexionDB();
          tabla1= conn.datosLogin();
          System.out.println(ConexionDB.init);
          if(ConexionDB.init)
          {
              conn.dataCampeonato(ConexionDB.init); 
              ConexionDB.init=false;
            
          }

          String md5crypt =MD5.getMd5(txtPass.getText());
          
          for(int i=0; i<2;i++)
          {
              if(txtNombre.getText().equals(tabla1[i][1]) && md5crypt.equals(tabla1[i][2]))
              {

                  JOptionPane.showMessageDialog(null, "Iniciado Sesion Correctamente", "Listo!", JOptionPane.INFORMATION_MESSAGE);
                   this.sesion=1;
                   this.hide();
                    return;
              }
          }

        JOptionPane.showMessageDialog(null, "La combinación Usuario/Contraseña es incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
        txtPass.setText("");
    }//GEN-LAST:event_btnLogonActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        txtNombre.setText("");
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        txtPass.setText("");
    }//GEN-LAST:event_txtPassFocusGained

    private void btnLogon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogon1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnLogon1ActionPerformed
    private int x=0,y=0;
    private boolean b=true;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if(b){
            x=evt.getX();
            y=evt.getY();
            b=false;
        }
        this.setLocation(this.getX()+evt.getX()-x,this.getY()+evt.getY()-y);
    }//GEN-LAST:event_formMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if(!b){
            b=true;
        }
    }//GEN-LAST:event_formMouseMoved

    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnLogon;
    private javax.swing.JButton btnLogon1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
