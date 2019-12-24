package Connect4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private Board board;

    public Controller(View view, Board board) {
        this.view = view;
        this.board = board;

        addRulesButtonListener(new RulesButtonListener(view));
        addStartButtonListener(new StartButtonListener(view));
        addResetButtonListener(new ResetButtonListener(view, board));

        for (int i = 0; i < board.getNumRows(); i++) {
            for (int j = 0; j < board.getNumColumns(); j++)
                addButtonListener(i, j, new ButtonListener(view, board, i, j + 1));
        }
    }

    public void addButtonListener(int row, int column, ActionListener e) {
        view.getButtons()[row][column].addActionListener(e);
    }

    public void addStartButtonListener(ActionListener e) {
        view.getStartButton().addActionListener(e);
    }

    public void addRulesButtonListener(ActionListener e) {
        view.getRulesButton().addActionListener(e);
    }

    public void addResetButtonListener(ActionListener e) {
        view.getResetButton().addActionListener(e);
    }
}

class RulesButtonListener implements ActionListener {
    private View view;

    public RulesButtonListener(View view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        view.createRulesScreen();
    }
}

class StartButtonListener implements ActionListener {
    private View view;

    public StartButtonListener(View view) {
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) {
        view.createGameScreen();
    }
}

class ButtonListener implements ActionListener {
    private View view;
    private Board board;
    private int row;
    private int column;

    public ButtonListener(View view, Board board, int row, int column) {
        this.view = view;
        this.board = board;
        this.row = row;
        this.column = column;
    }

    public void actionPerformed(ActionEvent e) {
        if (board.getValues()[row][column - 1] == 0) {
            String currentPlayer = board.getCurrentPlayer() + "";
            if (view.getPlayerTurnLabel().getText().equals("Current Player is: RED")) {
                updateCellForRed(column);
            } else if (view.getPlayerTurnLabel().getText().equals("Current Player is: YELLOW")) {
                updateCellForYellow(column);
            }
            board.insertChipAt(column);
            if (board.hasWinningCondition() == false) {
                if (board.getTotalMovesPlayed() != board.getNumColumns() * board.getNumRows()) {
                    view.getPlayerTurnLabel().setText("Current Player is: " + board.getCurrentPlayer());
                } 
            } else {
                JOptionPane.showMessageDialog(null, "The Winner is " + currentPlayer);
                clearBoard();
            }
        } else {
            JOptionPane.showMessageDialog(null, "The cell is already filled, Please select another cell!");
        }
    }

    private void clearBoard() {
        setButtonsInitialVersion();

        board.initializeEmptyBoard();

        int totalMovesPlayed = board.getTotalMovesPlayed() + 1;

        if (board.getTotalMovesPlayed() % 2 != 0)
            board.setTotalMovesPlayed(totalMovesPlayed);

        view.getPlayerTurnLabel().setText("Current Player is: " + board.getCurrentPlayer());
    }

    private void setButtonsInitialVersion() {
        for (int i = 0; i < board.getNumRows(); i++) {
            for (int j = 0; j < board.getNumColumns(); j++) {
                setButtonAttributes(view.getButtons()[i][j]);
                board.getValues()[i][j] = 0;
            }
        }
    }

    private void setButtonAttributes(JButton button) {
        button.setText("");
        button.setForeground(Color.BLACK);
        button.setBackground(Color.BLACK);
        button.setOpaque(true);
    }

    private void updateCellForYellow(int column) {
        view.getButtons()[board.findEmptyRow(column)][column - 1].setForeground(Color.ORANGE);
        view.getButtons()[board.findEmptyRow(column)][column - 1].setBackground(Color.ORANGE);
        view.getButtons()[board.findEmptyRow(column)][column - 1].setOpaque(true);
        view.getButtons()[board.findEmptyRow(column)][column - 1].setText("Y");
    }

    private void updateCellForRed(int column) {
        view.getButtons()[board.findEmptyRow(column)][column - 1].setForeground(Color.red);
        view.getButtons()[board.findEmptyRow(column)][column - 1].setBackground(Color.RED);
        view.getButtons()[board.findEmptyRow(column)][column - 1].setOpaque(true);
        view.getButtons()[board.findEmptyRow(column)][column - 1].setText("R");
    }
}

class ResetButtonListener implements ActionListener {
    private View view;
    private Board board;

    public ResetButtonListener(View view, Board board) {
        this.view = view;
        this.board = board;
    }

    public void actionPerformed(ActionEvent e) {
        setButtonsInitialVersion();

        board.initializeEmptyBoard();

        int totalMovesPlayed = board.getTotalMovesPlayed() + 1;

        if (board.getTotalMovesPlayed() % 2 != 0)
            board.setTotalMovesPlayed(totalMovesPlayed);

        view.getPlayerTurnLabel().setText("Current Player is: " + board.getCurrentPlayer());
    }

    private void setButtonsInitialVersion() {
        for (int i = 0; i < board.getNumRows(); i++) {
            for (int j = 0; j < board.getNumColumns(); j++) {
                setButtonAttributes(view.getButtons()[i][j]);
                board.getValues()[i][j] = 0;
            }
        }
    }

    private void setButtonAttributes(JButton button) {
        button.setText("");
        button.setForeground(Color.BLACK);
        button.setBackground(Color.BLACK);
        button.setOpaque(true);
    }
}

