package sudoku;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Board {

    // 9x9 grid
    private final int[][] grid;
    private final GridChecker gridChecker;
    private final GridPrinter gridPrinter;

    public Board(
        final GridGenerator gridGenerator,
        final GridChecker gridChecker,
        final GridPrinter gridPrinter
    ) {
        grid = gridGenerator.createGrid();
        this.gridChecker = gridChecker;
        this.gridPrinter = gridPrinter;
    }

    public void run() {
        final Scanner in = new Scanner(System.in);
        while (true) {
            if (checkGridFinished()) {
                checkGrid();
                break;
            }
            gridPrinter.print(grid);
            // TODO H3: Parse user input & update grid
            break; // remove after implemented
        }
    }

    private boolean checkGridFinished() {
        return Stream.of(grid).flatMapToInt(IntStream::of).noneMatch(i -> i == 0);
    }

    private void checkGrid() {
        try {
            gridChecker.check(grid);
            System.out.println("Grid ok!");
        } catch (Exception e) {
            System.err.println("Grid not ok: " + e.getMessage());
        }
    }
}
