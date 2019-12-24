package Connect4;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        View view = new View(board);
        Controller controller = new Controller(view, board);
        JFrame frame = new JFrame("Connect4");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        //frame.pack();
        frame.setVisible(true);
    }
}
