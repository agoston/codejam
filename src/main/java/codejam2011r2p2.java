import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


/*

111
111
111




    1111
    2111
    1112
    1111

center: (1.5, 1.5)
dim: (4,4)

X:
(2*1.5 + 3*0.5) - (2*1.5 + 4.0.5)

Y:
(2*1.5 + 4*0.5) - (2*1.5 + 4.0.5)


Speedups:
- incremental increase (only add the new border elements)
- parallel - N threads
- Simplified balance calculation - separate sums for X and Y, no actual distance calculation (see above)


 */


public class codejam2011r2p2 {

    public static final String PATHNAME = "target/classes/2011r2p1/A-large-practice.in";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File(PATHNAME)));
        PrintStream out = new PrintStream(new File(PATHNAME.replaceFirst("\\.in", ".out")));
        final int numTests = Integer.parseInt(in.readLine());
        for (int numTest = 1; numTest <= numTests; numTest++) {
            String[] inVal = in.readLine().split(" ");

            int X = Integer.parseInt(inVal[0]); // length
            int S = Integer.parseInt(inVal[1]); // walking speed
            int R = Integer.parseInt(inVal[2]); // running speed
            double t = Integer.parseInt(inVal[3]); // time of running
            int N = Integer.parseInt(inVal[4]); // number of walkways

            final List<WalkWay> walkWays = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                inVal = in.readLine().split(" ");
                walkWays.add(new WalkWay(Integer.parseInt(inVal[0]), Integer.parseInt(inVal[1]), Integer.parseInt(inVal[2])));
            }
            walkWays.add(new WalkWay(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)); // terminator

            int wwInd = 0;
            double totalTime = 0;

            for (int x = 0; x < X; x++) {
                int speed = S;
                if (walkWays.get(wwInd).begin <= x) {
                    if (walkWays.get(wwInd).end <= x) {
                        wwInd++;
                        x--;
                        continue;
                    }
                    speed += walkWays.get(wwInd).speed;
                } else if (t > 0.000001D) {
                    speed = R;
                    t -= ((double)1 / R);
                }

                totalTime += ((double) 1 / speed);
            }

            // special case: run on walkway too if there's still time
            while (t > 0.000001D) {
                int minSpeed = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int i = 0; i < walkWays.size(); i++) {
                    if (walkWays.get(i).speed < minSpeed) {
                        minSpeed = walkWays.get(i).speed;
                        minIndex = i;
                    }
                }
                if (minIndex < 0) break;
                WalkWay removed = walkWays.remove(minIndex);
                int speed = R + removed.speed;
                double len = removed.end - removed.begin;
                if (speed * t < len) {
                    double torig = len/(S+removed.speed);
                    double tnew = t + ((len - (speed * t))/(S+removed.speed));
                    totalTime -= (torig - tnew);
                    t = 0;
                } else {
                    double torig = len/(S+removed.speed);
                    double tnew = len/speed;
                    totalTime -= (torig - tnew);
                    t -= (len/speed);
                }
            }

            out.println("Case #" + numTest + ": " + totalTime);
            System.out.println("Case #" + numTest + ": " + totalTime);
        }

    }


    public static class WalkWay {
        int begin, end, speed;

        public WalkWay(int begin, int end, int speed) {
            this.begin = begin;
            this.end = end;
            this.speed = speed;
        }
    }

}
