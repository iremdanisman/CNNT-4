package Connect4;

enum Chip {
    NONE, RED, YELLOW;

    public String toString() {
        switch (this) {
            case RED:
                return "RED";
            case YELLOW:
                return "YELLOW";
            case NONE:
                return "_";
        }
        return null;
    }
}

public class Board {
    public static final int NUM_COLUMNS = 7;
    public static final int NUM_ROWS = 6;
    private Chip chips[][];
    private int values[][];
    private int totalMovesPlayed;
    private String config;

    public Board() {
        initializeEmptyBoard();
    }

    public void initializeEmptyBoard() {
        chips = new Chip[NUM_ROWS][NUM_COLUMNS];
        values = new int[NUM_ROWS][NUM_COLUMNS];

        totalMovesPlayed = 0;
        config = "";

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++) {
                chips[i][j] = Chip.NONE;
                values[i][j] = 0; // 0 means '_' 1 means RedChip 2 means YellowChip
            }
        }
    }


}
