package Game.View;

import Game.Controller.Controller;

import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class contains the gui for the login menu
 *
 * @author Joakim Tell, Yasir Kakar, Adel Sabanovic
 * @version 4.0
 */
public class LogInGUI extends JFrame {
    private Controller controller;
    private ImageIcon welcomeLogo = new ImageIcon("images/MemoriaWelcome.PNG");
    private ImageIcon imgbtn = new ImageIcon("images/ok.PNG");

    private JPanel pnlMain = new JPanel();
    private boolean FocusUsername = false;
    private boolean FocusPassword = false;

    ImageIcon piLogo = new ImageIcon("images/pi.jpg");

    private JLabel lblGame = new JLabel(welcomeLogo);

    private JLabel lblUsername = new JLabel("Användarnamn");
    private JLabel lblPassword = new JLabel("Password");
    private JLabel lblPi = new JLabel(piLogo);

    private JTextField txtUsername = new JTextField("Användarnamn (3-10 tecken)");
    private JPasswordField txtPassword = new JPasswordField("Password");

    private Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 20);

    private JButton btnLogin = new JButton(imgbtn);

    /**
     * Constructor that initializes the different components in the class
     */
    public LogInGUI(Controller controller, String name) {
        this.controller = controller;

        setSize(380, 255);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        add(pnlMain);
        pnlMain.setBackground(Color.WHITE);

        lblGame.setFont(myFont);

        pnlMain.setLayout(null);
        

        lblGame.setBounds(40, 20, 300, 50);
        lblUsername.setBounds(50, 60, 100, 100);
        lblPassword.setBounds(50, 90, 100, 100);
        txtUsername.setBounds(120, 100, 165, 25);
        txtPassword.setBounds(120, 130, 165, 25);
        btnLogin.setBounds(168, 155, 59, 38);
        lblPi.setBounds(128, 150, 33, 40);

        lblPi.setVisible(false);

        lblUsername.setText(name);

        txtUsername.setForeground(Color.GRAY);
        //Ali
        txtPassword.setForeground(Color.GRAY);

        pnlMain.add(lblGame);
        pnlMain.add(lblUsername);
        pnlMain.add(lblPassword);
        pnlMain.add(txtUsername);
        //Ali
        pnlMain.add(txtPassword);
        pnlMain.add(btnLogin);
        pnlMain.add(lblPi);

        btnLogin.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        listeners();
    }
    public void hidePasswordInput()
    {
        txtPassword.setVisible(false);
    }

    /**
     * Adds the listeners to the components
     */
    private void listeners() {
        txtUsername.addKeyListener(new LimitUsername());
        txtUsername.addKeyListener(new Listener()); //karl
        btnLogin.addActionListener(new Listener());
        txtUsername.addFocusListener(new FocusUsername());
        txtPassword.addFocusListener(new FocusPassword());
        btnLogin.addMouseListener(new MouseSubmit());
        txtPassword.addKeyListener(new Listener());
        

    }

    /**
     * An inner class that makes the username hint disappear
     *
     * @author Yasir Kakar
     */
    private class FocusUsername implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (!FocusUsername) 
            {
                txtUsername.setText(null);
                txtUsername.setForeground(Color.BLACK);
            }
            
            FocusUsername = true;
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }
    private class FocusPassword implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            if (!FocusPassword) 
            {
                txtPassword.setText(null);
                txtPassword.setForeground(Color.BLACK);
            }
            
            FocusPassword = true;
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

    /**
     * An inner class which limits how long a username can be
     */
    private class LimitUsername implements KeyListener 
    {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if ((txtUsername.getText().length() > 10) || (txtUsername.getText().length() < 3)) {
                txtUsername.setForeground(Color.RED);
                btnLogin.setEnabled(false);
            } else {
                txtUsername.setForeground(Color.GREEN);
                btnLogin.setEnabled(true);
            }
        }
    }

    /**
     * An inner class that shows a pi logo if the mouse hovers over a certain button
     */
    private class MouseSubmit implements MouseListener {
        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
            lblPi.setVisible(true);

        }

        public void mouseExited(MouseEvent e) {
            lblPi.setVisible(false);

        }
    }
    

    /**
     * Listener that controls the length of the username.
     * Creates a MenuGUI if valid username is entered.
     */
    private class Listener implements ActionListener, KeyListener {
        private boolean loginSuccessfull = false;

        /**
         * 
         */
        public void handleLogin(){ //Flyttade in koden nedan till en ny metod /Jenny
            if ((txtUsername.getText().trim().length() <= 10) && (txtUsername.getText().trim().length() >= 3)) {
    
                loginSuccessfull = controller.createUser();
    
                if (loginSuccessfull) 
                {
                    setVisible(false);
                    dispose();
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Ogiltigt användarnamn");
            }
    
        }
        
        public void actionPerformed(ActionEvent e) {
           handleLogin();
        }
        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER){
                handleLogin();
            }        
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub
            
        }
       
    }
  

    public JTextField getTxtUsername() {
        return txtUsername;
    }
    //Ali 
    public JTextField getTxtPassword()
    {
        return txtPassword;
    }

}
