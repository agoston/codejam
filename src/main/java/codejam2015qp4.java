import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

public class codejam2015qp4 {

    public static final String PATHNAME = "target/classes/2015qp/D-example.in";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File(PATHNAME)));
        PrintStream out = new PrintStream(new File(PATHNAME.replaceFirst("\\.in", ".out")));
        final int numTests = Integer.parseInt(in.readLine());
        for (int numTest = 1; numTest <= numTests; numTest++) {
            final String readLine = in.readLine();
            String[] inVal = readLine.split(" ");

            int X = Integer.parseInt(inVal[0]);
            int R = Integer.parseInt(inVal[1]);
            int C = Integer.parseInt(inVal[1]);

            boolean result = canPickImpossibleOmino(X, R, C);

            out.println("Case #" + numTest + ": " + (result ? "RICHARD" : "GABRIEL"));
        }
    }

    private static boolean canPickImpossibleOmino(int x, int r, int c) {
        /*  NB: an omino is a blob, thus can fill any space provided size(space) mod X = 0.
        
            reasons for which the R * C field can't be filled:
            - R*C mod X != 0 (aka we can't fill that field, ever, anyway)
            - we can make an omino that doesn't fit the field (e.g. 2x2 on a 4x1 field)
            - we can make an omino that separates the field into slices for which size(space) mod X != 0
        */
        return false;
    }
}
