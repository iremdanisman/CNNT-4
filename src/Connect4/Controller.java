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
       
    }
    public void addStartButtonListener(ActionListener e) {
        view.getStartButton().addActionListener(e);
    }

    public void addRulesButtonListener(ActionListener e) {
        view.getRulesButton().addActionListener(e);
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

	 