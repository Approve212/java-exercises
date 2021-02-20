package name.cmkimberlin.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* This program creates and runs a 2-player Connect Four game */
public class ConnectFour {
    private static final char[] players;
    static {
        players = new char[]{'R', 'Y'};
    }
    private final int width, height;
    private final char[][] board;
    private int lastCol = -1, lastTop = -1;

    public ConnectFour(int w, int h) {
        width = w;
        height = h;
        board = new char[h][];

        /* Initializes the board blank */
        for (int i = 0; i < h; i++) {
            Arrays.fill(board[i] = new char[w], '|');
        }
    }

    public String toString() {
        return IntStream.range(0,  width).
                mapToObj(Integer::toString).
                collect(Collectors.joining()) +
                "\n" +
                Arrays.stream(board).
                        map(String::new).
                        collect(Collectors.joining("\n"));
    }

    /* Gets the row number of the last play */
    public String horizontal() {
        return new String(board[lastTop]);
    }

    /* Gets the column number of the last play */
    public String vertical() {
        StringBuilder sb = new StringBuilder(height);

        for (int h = 0; h < height; h++) {
            sb.append(board[h][lastCol]);
        }

        return sb.toString();
    }

    /* Gets the diagonal position of the last play */
    public String slashDiagonal() {
        StringBuilder sb = new StringBuilder(height);

        for (int h = 0; h < height; h++) {
            int w = lastCol + lastTop - h;

            if (0 <= w && w < width) {
                sb.append(board[h][w]);
            }
        }

        return sb.toString();
    }

    /* Gets the backwards diagonal position of the last play */
    public String backslashDiagonal() {
        StringBuilder sb = new StringBuilder(height);

        for (int h = 0; h < height; h++) {
            int w = lastCol - lastTop + h;

            if (0 <= w && w < width) {
                sb.append(board[h][w]);
            }
        }

        return sb.toString();
    }

    /* Checks if a substring is in str */
    public static boolean contains(String str, String substring) {
        return str.contains(substring);
    }

    /* Check for if last play was a winning play */
    public boolean isWinningPlay() {
        if (lastCol == -1) {
            System.err.println("No move has been made yet");
            return false;
        }
        char sym = board[lastTop][lastCol];

        String streak = String.format("%c%c%c%c", sym, sym, sym, sym);
        return contains(horizontal(), streak) ||
                contains(vertical(), streak) ||
                contains(slashDiagonal(), streak) ||
                contains(backslashDiagonal(), streak);
    }

    /* Prompts user for column choice of play */
    public void chooseAndDrop(char symbol, Scanner input) {
        do {
            System.out.println("\nPlayer " + symbol + "'s turn: ");
            int col = input.nextInt();

            /* Checks if column is valid */
            if (!(0 <= col && col < width)) {
                System.out.println("Invalid number! Column number must be between 0 and " + (width - 1));
                continue;
            }

            /* Places player symbol in first available row slot in given column */
            for (int h = height - 1; h >= 0; h--) {
                if (board[h][col] == '|') {
                    board[lastTop = h][lastCol = col] = symbol;
                    return;
                }
            }

            /* Prompts user for new choice if column is full */
            System.out.println("Column " + col + " is full.");
        } while (true);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int height = 6; int width = 8; int moves = height * width;
            ConnectFour board = new ConnectFour(width, height);

            System.out.println("Use numbers between 0 and " + (width - 1) + " to choose a column for this game");
            System.out.println(board);

            /* Loop for switching between players with simplicity */
            for (int player = 0; moves-- > 0; player = 1 - player) {
                char symbol = players[player];

                /* Prompts user for column and displays state of board */
                board.chooseAndDrop(symbol, input);
                System.out.println(board);

                /* Checks if a player has won and displays either winner or tie */
                if (board.isWinningPlay()) {
                    System.out.println("\nPlayer " + symbol + " wins!");
                    return;
                }
            }

            System.out.println("It's a tie! Let's play again! :)");
        }
    }

}


