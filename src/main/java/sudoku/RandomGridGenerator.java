package sudoku;

public class RandomGridGenerator implements GridGenerator {

    private final SudokuSolver solver;

    private final double density;

    public RandomGridGenerator(final SudokuSolver solver, final double density) {
        this.solver = solver;
        this.density = density;
    }

    @Override
    public Grid createGrid() {
        final Grid grid = new Grid(new int[9][9]);

        solver.solve(grid);

        final int[][] data = grid.copyData();

        // TODO: H3 set random entries in data to 0 based on density
        // lower density -> more 0s in array
        // use Math.random()

        return new Grid(data);
    }
}
