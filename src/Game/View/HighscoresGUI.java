package Game.View;

import javax.swing.*;
import Game.Model.Highscore;
import java.awt.*;
/**
 *
 * Class that handles the view of the highscores.
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




    public HighscoresGUI() {
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

    }

    public void setText(String text) {
        centerText.setText(text);
    }

    private void showPanelInFrame() {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(400, 600));
        frame.setBackground(Color.white);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.add(this);
        

    }

    public static void main(String[] args) {
        HighscoresGUI gui = new HighscoresGUI();
        Highscore hs = new Highscore();
        gui.setText(hs.toString());
        gui.showPanelInFrame();
    }

}
