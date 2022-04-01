package sudoku;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Grid {

    private final int[][] data;
    private final boolean[][] permanent;

    public Grid(final int[][] data) {
        this.data = data;
        // save which squares were originally set
        // so that they are not changed later
        permanent = new boolean[9][9];
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (data[y][x] != 0) {
                    permanent[y][x] = true;
                }
            }
        }
    }

    public int get(final int x, final int y) {
        return data[y][x];
    }

    public void set(final int x, final int y, final int value) {
        if (permanent[y][x]) {
            throw new IllegalArgumentException(
                String.format("Field at position (%d, %d) cannot be changed", x, y));
        }
        data[y][x] = value;
    }

    public boolean isSet(final int x, final int y) {
        return data[y][x] != 0;
    }

    public boolean isFinished() {
        return Stream.of(data).flatMapToInt(IntStream::of).noneMatch(i -> i == 0);
    }

    public int[][] copyData() {
        return Arrays.stream(data).map(int[]::clone).toArray(int[][]::new);
    }
}
