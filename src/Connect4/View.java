import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private Board board;

    private JButton rulesButton = new JButton("RULES");
    private JButton startButton = new JButton("START");

    public View(Board board) {
        this.board = board;
        createMainScreen();
    }

    public void createMainScreen() {
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(rulesButton);
        buttonPanel.add(startButton);
        ImageIcon image = new ImageIcon("banner.jpg");
        JLabel test = new JLabel(image);
        add(test);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getRulesButton() {
        return rulesButton;
    }

}