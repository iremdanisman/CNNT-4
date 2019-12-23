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

    public Board(String configuration) {
        this();
        for (int i = 0; i < configuration.length(); i++) {
            int column = Integer.parseInt(configuration.charAt(i) + "");
            if (hasWinningCondition() == false)
                insertChipAt(column);
        }
    }

    public void insertChipAt(int column) {
        boolean inserted = false;
        if (column < 1 || column > NUM_COLUMNS) {
            throw new IllegalArgumentException("Enter valid Column ");
        } else if (hasWinningCondition() == false) {
            updateBoard(column);
            inserted = true;
            if (inserted == false)
                throw new RuntimeException("Column is full");
        } else {
            throw new NullPointerException();
        }
    }

    public void updateBoard(int column) {
        if (totalMovesPlayed % 2 == 0) {
            chips[findEmptyRow(column)][column - 1] = Chip.RED;
            values[findEmptyRow(column)][column - 1] = 1;
            totalMovesPlayed++;
            config += column;
        } else {
            chips[findEmptyRow(column)][column - 1] = Chip.YELLOW;
            values[findEmptyRow(column)][column - 1] = 2;
            totalMovesPlayed++;
            config += column;
        }
    }

    public int findEmptyRow(int column) {
        for (int i = NUM_ROWS - 1; i >= 0; i--) {
            if (values[i][column - 1] == 0)
                return i;
        }
        return -1;
    }

    private boolean hasWinningConditionOnColumns() {
        for (int j = 0; j < NUM_COLUMNS; j++) {
            for (int i = 0; i < NUM_ROWS / 2; i++) {
                if (getChip(values, i, j) != Chip.NONE) {
                    if (getChip(values, i, j) == getChip(values, i + 1, j)
                            && getChip(values, i, j) == getChip(values, i + 2, j)
                            && getChip(values, i, j) == getChip(values, i + 3, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasWinningConditionOnRows() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j <= NUM_COLUMNS / 2; j++) {
                if (getChip(values, i, j) != Chip.NONE) {
                    if (getChip(values, i, j) == getChip(values, i, j + 1)
                            && getChip(values, i, j) == getChip(values, i, j + 2)
                            && getChip(values, i, j) == getChip(values, i, j + 3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean hasWinningConditionOnDiagonals() {
        // to right diagonal
        for (int i = NUM_ROWS / 2; i < NUM_ROWS; i++) {
            for (int j = 0; j <= NUM_COLUMNS / 2; j++) {
                if (getChip(values, i, j) != Chip.NONE) {
                    if (getChip(values, i, j) == getChip(values, i - 1, j + 1)
                            && getChip(values, i, j) == getChip(values, i - 2, j + 2)
                            && getChip(values, i, j) == getChip(values, i - 3, j + 3)) {
                        return true;
                    }
                }
            }
        }

        // to left diagonal
        for (int i = NUM_ROWS / 2; i < NUM_ROWS; i++) {
            for (int j = NUM_COLUMNS / 2; j < NUM_COLUMNS; j++) {
                if (getChip(values, i, j) != Chip.NONE) {
                    if (getChip(values, i, j) == getChip(values, i - 1, j - 1)
                            && getChip(values, i, j) == getChip(values, i - 2, j - 2)
                            && getChip(values, i, j) == getChip(values, i - 3, j - 3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasWinningCondition() {
        return hasWinningConditionOnRows() || hasWinningConditionOnColumns() || hasWinningConditionOnDiagonals();
    }

    public Chip getChip(int[][] values, int row, int column) {
        if (values[row][column] == 0) {
            return Chip.NONE;
        } else if (values[row][column] == 1) {
            return Chip.RED;
        } else if (values[row][column] == 2) {
            return Chip.YELLOW;
        }
        return null;
    }

    public void clearChipArray() {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++)
                chips[i][j] = Chip.NONE;
        }
    }

    public String getConfiguration() {
        return config;
    }

    public Chip getCurrentPlayer() {
        if (totalMovesPlayed % 2 == 0)
            return Chip.RED;
        else return Chip.YELLOW;
    }

    public int getNumRows() {
        return NUM_ROWS;
    }

    public Chip[][] getTable() {
        return chips;
    }

    public int getTotalMovesPlayed() {
        return totalMovesPlayed;
    }

    public String getConfig() {
        return config;
    }

    public int[][] getValues() {
        return values;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++) {
                if (chips[i][j] == Chip.NONE)
                    builder.append("_");
                if (chips[i][j] == Chip.RED)
                    builder.append("R");
                if (chips[i][j] == Chip.YELLOW)
                    builder.append("Y");

                builder.append(" ");
            }
            if (i != NUM_COLUMNS - 1)
                builder.append("\n");
        }
        return builder.toString();

    }

    public int getNumColumns() {
        return NUM_COLUMNS;
    }

    public void setTotalMovesPlayed(int totalMovesPlayed) {
        this.totalMovesPlayed = totalMovesPlayed;
    }
    
}
