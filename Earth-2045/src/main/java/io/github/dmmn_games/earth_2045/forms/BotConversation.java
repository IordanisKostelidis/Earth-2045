package io.github.dmmn_games.earth_2045.forms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elgreko
 */
import io.github.dmmn_games.earth_2045.user.User;
import io.github.dmmn_games.earth_2045.npcs.Bot;
import io.github.dmmn_games.earth_2045.user.User;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BotConversation extends javax.swing.JFrame
{
    
    String previousHistory;
    String History;
    Bot currentBot;
    User currentUser;
    

    /**
     * Creates new form Frame
     */
    public BotConversation()
    {
        
        
        initComponents();
        
    }

    public BotConversation(User currentUser, String currentBot)
    {
        initComponents();
        this.currentUser = currentUser;
        try
        {
            this.currentBot = currentUser.findBot(currentBot) ;
        } catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
        
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        talkButton = new javax.swing.JButton();
        userText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        conversation = new javax.swing.JTextArea();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        talkButton.setText("Talk");
        talkButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                talkButtonActionPerformed(evt);
            }
        });

        userText.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                userTextActionPerformed(evt);
            }
        });

        conversation.setColumns(20);
        conversation.setRows(5);
        jScrollPane1.setViewportView(conversation);

        exitButton.setText("EXIT CONVERSATION");
        exitButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userText, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(talkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(userText))
                    .addComponent(talkButton))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    
    private void talkButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_talkButtonActionPerformed
    {//GEN-HEADEREND:event_talkButtonActionPerformed
        History = userText.getText();        
        conversation.append(currentUser.getUsername()+ ": " + History + "\n\n");        
        userText.setText(""); 
        
        conversation.append(currentBot.talk(History, currentUser.getUsername()));
        userText.requestFocus();
        
    }//GEN-LAST:event_talkButtonActionPerformed

    private void userTextActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_userTextActionPerformed
    {//GEN-HEADEREND:event_userTextActionPerformed
        
            History = userText.getText();        
            conversation.append(currentUser.getUsername()+ ": " + History + "\n\n");        
            userText.setText(""); 
            conversation.append(currentBot.talk(History,currentUser.getUsername()));
            
       
               
    }//GEN-LAST:event_userTextActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        exitButton.setVisible(false);
        userText.requestFocus();
        conversation.append(currentBot.botQuestion[0]);
        
    }//GEN-LAST:event_formWindowOpened

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exitButtonActionPerformed
    {//GEN-HEADEREND:event_exitButtonActionPerformed
        this.dispose();        // TODO check if there's a better way to close form.
    }//GEN-LAST:event_exitButtonActionPerformed
    
    
    
    
    
    
    
    
    
    public void enableExitButton(){
        
        userText.setVisible(false);
        talkButton.setVisible(false);
        exitButton.setVisible(true);
        exitButton.requestFocus();
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(BotConversation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(BotConversation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(BotConversation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(BotConversation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new BotConversation().setVisible(true);
                
            }
        });
        
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea conversation;
    private javax.swing.JButton exitButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton talkButton;
    private javax.swing.JTextField userText;
    // End of variables declaration//GEN-END:variables
}
