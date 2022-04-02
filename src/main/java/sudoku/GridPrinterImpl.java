package sudoku;

import org.fusesource.jansi.Ansi;

import java.util.function.Consumer;

public class GridPrinterImpl implements GridPrinter {

    /**
     * Wraps the provided {@link String} with a configurable Ansi-sequence terminated with reset.
     */
    @SafeVarargs
    private static Ansi toAnsi(final String string, final Consumer<? super Ansi>... builders) {
        final Ansi ansi = new Ansi();
        for (final Consumer<? super Ansi> builder : builders) {
            builder.accept(ansi);
        }
        return ansi.a(string).reset();
    }

    @Override
    public void print(final Grid grid) {
        // TODO H1: Print grid

        // examples of box-drawing characters with colors:
        // if your terminal does not support colors, you do not need to use them
        System.out.println(toAnsi("┏ ━ ┳ ━ ┓", Ansi::fgRed, Ansi::bold));
        System.out.println(toAnsi("┃   ┃   ┃", Ansi::fgYellow, Ansi::bold));
        System.out.println(toAnsi("┣ ━ ╋ ━ ┫", Ansi::fgGreen, Ansi::bold));
        System.out.println(toAnsi("┃   ┃   ┃", Ansi::fgBlue, Ansi::bold));
        System.out.println(toAnsi("┗ ━ ┻ ━ ┛", Ansi::fgMagenta, Ansi::bold));
    }
}
