import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

/*



 */
public class codejam2014qp2 {

//    public static final String PATHNAME = "target/classes/2014qp2/B-example.in";
//    public static final String PATHNAME = "target/classes/2014qp2/B-small-practice.in";
    public static final String PATHNAME = "target/classes/2014qp/B-large-practice.in";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File(PATHNAME)));
        PrintStream out = new PrintStream(new File(PATHNAME.replaceFirst("\\.in", ".out")));
        int numTests = Integer.parseInt(in.readLine());
        for (int numTest = 1; numTest <= numTests; numTest++) {
            String readLine = in.readLine();
            String[] inVal = readLine.split(" ");

            // Cost of farm
            double C = Double.parseDouble(inVal[0]);
            // Production of farm
            double F = Double.parseDouble(inVal[1]);
            // Target
            double X = Double.parseDouble(inVal[2]);

            try {
                double result = getResult(C, F, X);
                out.printf("Case #%d: %.8f\n", numTest, result);
                System.out.printf("Case #%d: %.8f\n", numTest, result);
            } catch (IllegalStateException e) {
                out.println("Impossible");
            }
        }
    }

//    private static double getTime(int farmNo, )

    private static double getResult(double C, double F, double X) {
        double prod = 2d;
        double time = 0d;

        for (; ; ) {
            double timeToWin = X / prod;

            double timeToFact = C / prod;
            double timeToFactWin = X / (prod + F);

            if (timeToWin < timeToFact + timeToFactWin) {
                return time + timeToWin;
            } else {
                prod += F;
                time += timeToFact;
            }

        }
    }
}
