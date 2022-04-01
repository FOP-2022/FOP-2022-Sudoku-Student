package sudoku;

public class EmptyGridGenerator implements GridGenerator {
    @Override
    public int[][] createGrid() {
        return new int[9][9];
    }
}
