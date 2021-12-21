package Game.View;

import javax.swing.*;
import Game.Model.Highscore;
import java.awt.*;
import java.awt.event.*;

import Game.Controller.Controller;

/**
 *
 * Class that handles the view of the highscores.
 * 
 * @author Jenny
 * @version 1.0
 * @since 2021-12-08
 */

public class HighscoresGUI extends JPanel {

    private JTextArea centerText = new JTextArea();
    private ImageIcon iconMemoriaLogo = new ImageIcon("images/mem2.jpg");
    private ImageIcon iconHighscore = new ImageIcon("images/Highscore.jpg");
    private JLabel memoriaLabel = new JLabel(iconMemoriaLogo);
    private JLabel highscoreLabel = new JLabel(iconHighscore);
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JFrame frame;
    private Controller controller;

    public HighscoresGUI(Controller controller) {
        this.controller = controller;
        setLayout(new BorderLayout());
        centerText.setFont(new Font("Serif", Font.PLAIN, 26));
        centerText.setEditable(false);
        centerPanel.add(highscoreLabel, BorderLayout.NORTH);
        centerPanel.add(centerText, BorderLayout.CENTER);
        centerPanel.setBackground(Color.WHITE);
        northPanel.setPreferredSize(new Dimension(400, 100));
        northPanel.add(memoriaLabel, BorderLayout.NORTH);
        northPanel.setBackground(Color.WHITE);
        northPanel.setBorder(BorderFactory.createMatteBorder(25, 25, 0, 25, Color.WHITE));
        add(centerPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createMatteBorder(25, 25, 50, 25, Color.WHITE));
        setText(controller.getHighScore().toString());
        showPanelInFrame();
        XButtonPressed();
    }

    public void setText(String text) {
        centerText.setText(text);
    }

    private void showPanelInFrame() {
        frame = new JFrame();
        frame.setSize(new Dimension(400, 600));
        frame.setBackground(Color.white);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.add(this);

    }

    private void XButtonPressed() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controller.setWindowOpen(false);
            }
        });
    }

}
