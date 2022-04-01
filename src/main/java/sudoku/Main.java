package sudoku;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        final Board board = new Board(new EmptyGridGenerator(), new GridCheckerImpl(), new GridPrinterImpl());
        board.run();
    }
}
