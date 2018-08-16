package br.edu.utfpr.daeln.csr31.chat4dpam5;

import br.edu.utfpr.daeln.csr31.chat4dpam5.listners.OpenDetails;
import br.edu.utfpr.daeln.csr31.chat4dpam5.core.Chat;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.Message;
import br.edu.utfpr.daeln.csr31.chat4dpam5.beans.RemoteMessage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author rapha
 */
public final class MainView extends javax.swing.JFrame {

    private static final long serialVersionUID = -6467255376560618319L;
    private int count = 0;
    private JPanel panel = null;
    private Chat chat;

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        chat = new Chat(this);
        chatPanel.setPreferredSize(new Dimension(100, 100));
        chatPanel.setAlignmentX(LEFT_ALIGNMENT);
        panel = (JPanel) chatPanel.getViewport().getView();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                chat.stop();
                System.exit(0);
            }
        });

        this.chatPanel.setViewportBorder(new LineBorder(Color.BLACK));
        this.setTitle("D4-Pam5 Protocol Chat");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("logo.png")));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textSend = new javax.swing.JTextField();
        chatPanel = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSendActionPerformed(evt);
            }
        });
        textSend.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textSendKeyPressed(evt);
            }
        });

        chatPanel.setBackground(new java.awt.Color(255, 255, 255));
        chatPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chatPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        chatPanel.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        chatPanel.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatPanel)
                    .addComponent(textSend))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textSend, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textSendKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSendKeyPressed
        if (evt.getExtendedKeyCode() == 10) {
            send();
        }
    }//GEN-LAST:event_textSendKeyPressed

    private void textSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSendActionPerformed
    
    private void send() {
        if (textSend.getText().charAt(0) == '/') {
            if (!chat.executeCommand(textSend.getText())) {
                messageSystem("ERROR: incorrect syntax on command '" + textSend.getText() + "'");
            }
        } else if (chat.isConnected()) {
            userMessage(chat.send(textSend.getText()));
        } else {
            userMessage(chat.send(textSend.getText()));
            messageSystem("ERROR: There isn't a connection to send the message: '" + textSend.getText() + "'");
        }
        textSend.setText("");
    }
     
    public void messageSystem(String message) {
        JLabel label = new JLabel(message);
        label.setForeground(Color.RED);
        label.setName("label" + count);
        label.setBounds(5, count * 15, chatPanel.getSize().width - 10, 25);
        label.setVisible(true);
        panel.add(label);
        count++;
        this.repaint();
    }

    private void messageRemoteUser(RemoteMessage message) {
        JLabel label = new JLabel(message.getUsername() + " - " + message.getTime().getHour() + ":" + message.getTime().getMinute() + "> " + message.getText());
        label.setForeground(Color.DARK_GRAY);
        label.setName("label" + count);
        label.setBounds(5, count * 15, chatPanel.getSize().width - 10, 25);
        label.setVisible(true);
        panel.add(label);
        label.addMouseListener(new OpenDetails(message));
        count++;
        this.repaint();
    }

    private void userMessage(Message message) {
        JLabel label = new JLabel(chat.getNick() + " - " + message.getTime().getHour() + ":" + message.getTime().getMinute() + "> " + message.getText());
        label.setForeground(Color.BLUE);
        label.setName("label" + count);
        label.setBounds(5, count * 15, chatPanel.getSize().width - 10, 25);
        label.setVisible(true);
        panel.add(label);
        label.addMouseListener(new OpenDetails(message));
        count++;
        this.repaint();
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane chatPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textSend;
    // End of variables declaration//GEN-END:variables
}
