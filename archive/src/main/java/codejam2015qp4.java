import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

public class codejam2015qp4 {

//    public static final String PATHNAME = "target/classes/2015qp/D-example.in";
//    public static final String PATHNAME = "target/classes/2015qp/D-large-practice.in";
    public static final String PATHNAME = "target/classes/2015qp/D-small-attempt1.in";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File(PATHNAME)));
        PrintStream out = new PrintStream(new File(PATHNAME.replaceFirst("\\.in", ".out")));
        int numTests = Integer.parseInt(in.readLine());
        for (int numTest = 1; numTest <= numTests; numTest++) {
            String readLine = in.readLine();
            String[] inVal = readLine.split(" ");

            int X = Integer.parseInt(inVal[0]);
            int R = Integer.parseInt(inVal[1]);
            int C = Integer.parseInt(inVal[2]);

            boolean result = canPickImpossibleOmino(X, R, C);

//            out.println("Case #" + numTest + ": " + readLine +": " + result);
            out.println("Case #" + numTest + ": " + (result ? "RICHARD" : "GABRIEL"));
        }
    }

    private static boolean canPickImpossibleOmino(int X, int R, int C) {
        /*  NB: an omino is a blob, thus can fill any space provided size(space) mod X = 0.

            reasons for which the R * C field can't be filled:
            - R*C mod X != 0 (aka we can't fill that field, ever, anyway)
            - we can make an omino that doesn't fit the field (e.g. 2x2 on a 4x1 field)
            - we can make an omino that separates the field into slices for which size(space) mod X != 0
        */

        // NB: doesn't matter if R*C of C*R; let's make R the longer side
        if (R < C) {
            int t = C;
            C = R;
            R = t;
        }

//        - R*C mod X != 0 (aka we can't fill that field, ever, anyway)
        if (R * C % X != 0) return true;

//        - we can make an omino that doesn't fit the field (e.g. 2x2 on a 4x1 field)
        if ((int)(Math.sqrt(X)) > C) return true;

        // 1 big column that doesn't fit the field
        if (X > R) return false;

//        - we can make an omino that separates the field into slices for which size(space) mod X != 0
        // can be rotated to fit and not separate the field
        if (X < R) return false;

        // can be set on one end, causing the rest of the field to be solvable
        if (X == R) return false;

        /*
          e.g. 7x4 , X = 5

          ....
          ....
          ....
          ....
          ....
          ....
          ....

         */
        return false;
    }
}
