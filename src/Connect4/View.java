import javax.swing.*;
import java.awt.*;

public class View extends JPanel {
    private Board board;

    private JButton rulesButton = new JButton("RULES");
    private JButton startButton = new JButton("START");
    private JButton resetButton = new JButton("RESET");

    private JButton[][] buttons;
    private JLabel playerTurnLabel;

    public View(Board board) {
        this.board = board;
        buttons = new JButton[board.getNumRows()][board.getNumColumns()];
        playerTurnLabel = new JLabel("Current Player is: " + board.getCurrentPlayer());
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

    public JButton getResetButton() {
        return resetButton;
    }

    public JLabel getPlayerTurnLabel() {
        return playerTurnLabel;
    }

    public JButton[][] getButtons() {
        return buttons;
    }
}
