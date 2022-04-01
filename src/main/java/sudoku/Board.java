package sudoku;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Board {

    // 9x9 grid
    private final Grid grid;
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
            if (grid.isFinished()) {
                checkGrid();
                break;
            }
            gridPrinter.print(grid);
            // TODO: H4 Parse user input & update grid
            break; // remove after implemented
        }
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
