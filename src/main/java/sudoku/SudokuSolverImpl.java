package sudoku;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuSolverImpl implements SudokuSolver {

    @Override
    public void solve(final Grid grid) {
        solve0(grid);
    }

    public boolean solve0(final Grid grid) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (!grid.isSet(x, y)) {
                    var placements = getPlacements(grid, x, y);

                    for (int value : placements) {
                        grid.set(x, y, value);
                        if (solve0(grid)) {
                            return true;
                        }
                        grid.set(x, y, 0);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private List<Integer> getPlacements(final Grid grid, final int x, final int y) {
        var placements = IntStream
            .rangeClosed(1, 9)
            .filter(value -> checkPlacement(grid, x, y, value))
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(placements);
        return placements;
    }

    private boolean checkPlacement(final Grid grid, final int x, final int y, final int value) {
        for (int l = 0; l < 9; l++) {
            if (grid.get(x, l) == value || grid.get(l, y) == value) {
                return false;
            }
        }

        var x0 = (x / 3) * 3;
        var y0 = (y / 3) * 3;

        for (int l = 0; l < 3; l++) {
            for (int m = 0; m < 3; m++) {
                if (grid.get(x0 + l, y0 + m) == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
