package Connect4;
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
        createButtons();

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

    public void createRulesScreen() {
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startButton);
        ImageIcon image = new ImageIcon("rules.png");
        JLabel test = new JLabel(image);
        add(test);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void createGameScreen() {
        setLayout(new BorderLayout());
        JPanel center = new JPanel(new GridLayout(board.getNumRows(), board.getNumColumns()));
        add(center);
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(playerTurnLabel);
        addButtonsToGameScreen(center);

        buttonPanel.add(resetButton);
    }

    private void createButtons() {
        for (int i = 0; i < board.getNumRows(); i++) {
            for (int j = 0; j < board.getNumColumns(); j++)
                buttons[i][j] = initialButton();
        }
    }

    private void addButtonsToGameScreen(JPanel center) {
        for (int i = 0; i < board.getNumRows(); i++) {
            for (int j = 0; j < board.getNumColumns(); j++)
                center.add(buttons[i][j]);
        }
    }

    private JButton initialButton() {
        JButton button = new JButton("");
        button.setForeground(Color.BLACK);
        button.setBackground(Color.BLACK);
        button.setOpaque(true);
        return button;
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
