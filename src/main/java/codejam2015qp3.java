import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

public class codejam2015qp3 {

    public static final String PATHNAME = "target/classes/2015qp/C-example.in";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File(PATHNAME)));
        PrintStream out = new PrintStream(new File(PATHNAME.replaceFirst("\\.in", ".out")));
        final int numTests = Integer.parseInt(in.readLine());
        for (int numTest = 1; numTest <= numTests; numTest++) {
            final String readLine = in.readLine();
            String[] inVal = readLine.split(" ");

            int L = Integer.parseInt(inVal[0]);
            int X = Integer.parseInt(inVal[1]);

            String S = in.readLine();

            out.println("Case #" + numTest + ": ");

            String input = StringUtils.repeat(S, X);

            // TODO

        }
    }
}
