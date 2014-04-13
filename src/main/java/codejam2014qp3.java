import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

/*

xxxxx
xxx..
xx...
xxx.,
xxxxx


xxxxx
x...x
x...x
x...x
xxxxx


..xxx
..xxx
xxxxx
xxxxx
xxxxx


..
..
.x
xx

...x
...x
...x
xxxx


*/
public class codejam2014qp3 {

    public static final String PATHNAME = "target/classes/2014qp3/A-example.in";

    static void printMines(int R, int C, boolean[][] mines) {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (r == 0 && c == 0) {
                    System.err.print('c');
                } else if (mines[r][c]) {
                    System.err.print('*');
                } else {
                    System.err.print('.');
                }
            }
            System.err.println();
        }
    }

    static void getResult(int R, int C, int M, boolean[][] mines) {

        int empty = R * C - M;

        // trivial cases
        if (M == 0) return;

        if (empty == 1) {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    mines[r][c] = true;
                }
            }
            return;
        }

        // special case: 0D, >0 bomb
        if (R == 1 && C == 1) {
            throw new IllegalStateException();
        }

        // special case: 1D
        if (R == 1 || C == 1) {
            if (empty >= 2) {
                for (int r = R - 1; r >= 0; r--) {
                    for (int c = C - 1; c >= 0; c--) {
                        if (r > 1 || c > 1) {
                            mines[r][c] = true;
                            if (--M == 0) return;
                        }
                    }
                }
                return;
            } else {
                throw new IllegalStateException();
            }
        }

        // "normal" case: 2D
        if (empty >= 4) {
            // fill up the bigger and call recursively
            if (C > R) {
                if (M != R - 1) {
                    for (int r = R - 1; r >= 0; r--) {
                        mines[r][C - 1] = true;
                        if (--M == 0) return;
                    }
                    getResult(R, C - 1, M, mines);
                } else {    // terminating
                    if (M == 1) {
                        if (R < 3 || C < 3) throw new IllegalStateException();
                        mines[R - 1][C - 1] = true;
                        return;
                    }

                    for (int r = R - 1; r >= 2; r--) {
                        mines[r][C - 1] = true;
                        M--;
                    }
                    if (R <= 3) throw new IllegalStateException();
                    mines[R - 1][C - 2] = true;
                    return;
                }
            } else {
                if (M != C - 1) {
                    for (int c = C - 1; c >= 0; c--) {
                        mines[R - 1][c] = true;
                        if (--M == 0) return;
                    }
                    getResult(R - 1, C, M, mines);
                } else {    // terminating
                    if (M == 1) {
                        if (R < 3 || C < 3) throw new IllegalStateException();
                        mines[R - 1][C - 1] = true;
                        return;
                    }

                    for (int c = C - 1; c >= 2; c--) {
                        mines[R - 1][c] = true;
                        M--;
                    }
                    if (R <= 3) throw new IllegalStateException();
                    mines[R - 2][C - 1] = true;
                    return;
                }
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public static void main(String[] args) throws Exception {
//        {
//            int R = 5, C = 3, M = 8;
//            boolean[][] result = new boolean[R][C];
//            getResult(R, C, M, result);
//            printMines(R, C, result);
//            if (true) return;
//        }
        BufferedReader in = new BufferedReader(new FileReader(new File(PATHNAME)));
        PrintStream out = new PrintStream(new File(PATHNAME.replaceFirst("\\.in", ".out")));
        final int numTests = Integer.parseInt(in.readLine());
        for (int numTest = 1; numTest <= numTests; numTest++) {
            final String readLine = in.readLine();
            String[] inVal = readLine.split(" ");

            int R = Integer.parseInt(inVal[0]);
            int C = Integer.parseInt(inVal[1]);
            int M = Integer.parseInt(inVal[2]);

            try {
                out.println("Case #" + numTest + ":");
                boolean[][] result = new boolean[R][C];
                getResult(R, C, M, result);

                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        if (r == 0 && c == 0) {
                            out.print('c');
                        } else if (result[r][c]) {
                            out.print('*');
                        } else {
                            out.print('.');
                        }
                    }
                    out.println();
                }
            } catch (IllegalStateException e) {
                out.println("Impossible");
            }
        }
    }
}
