package sudoku;

public interface GridChecker {

    void check(Grid grid);

    default boolean checkCatching(Grid grid) {
        try {
            check(grid);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
