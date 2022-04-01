package sudoku;

public class EmptyGridGenerator implements GridGenerator {
    @Override
    public Grid createGrid() {
        return new Grid(new int[9][9]);
    }
}
