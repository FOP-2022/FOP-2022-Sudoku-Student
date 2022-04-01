package sudoku;

public interface GridChecker {

    /**
     * Checks whether the provided grid is a valid sudoku solution.
     *
     * <p>
     * A valid sudoku solution must fulfill the following criteria:
     * </p>
     * <ul>
     *     <li>Every cell is a value in the interval [1, 9]</li>
     *     <li>Every row and column has every number in the interval [1, 9] exactly once</li>
     *     <li>Every 3x3 section has every number in the interval [1, 9]</li>
     * </ul>
     */
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
