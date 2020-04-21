import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Multimap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;

public class codejam2012final {

    public static final String PATHNAME = "src/main/resources/2012final/A.in";
//    public static final String PATHNAME = "src/main/resources/2012final/A-small-practice.in";
//    public static final String PATHNAME = "src/main/resources/2012final/A-large-practice.in";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(new File(PATHNAME)));
        PrintStream out = new PrintStream(new File(PATHNAME.replaceFirst("\\.in", ".out")));
        int numTests = Integer.parseInt(in.readLine());

        for (int numTest = 1; numTest <= numTests; numTest++) {
            String line = in.readLine();
            System.err.println(line);
            int Z = Integer.parseInt(line.split(" ")[0]);
            List<Zombie> zombies = new ArrayList<>();

            for (int zombie = 0; zombie < Z; zombie++) {
                String zline = in.readLine();
                System.err.println(zline);
                String[] subInVal = zline.split(" ");
                zombies.add(new Zombie(
                        Integer.parseInt(subInVal[0]),
                        Integer.parseInt(subInVal[1]),
                        Integer.parseInt(subInVal[2])
                ));
            }

            zombies.sort(Comparator.comparingLong(z -> z.m));
            int result = work(zombies);

            System.err.println("Case #" + numTest + ": " + result);
            out.println("Case #" + numTest + ": " + result);
        }
    }

    // move: 100
    // smash: 750
    public static int work(List<Zombie> in) {
        Multimap<Zombie, Zombie> accessible = ArrayListMultimap.create();

        for (Zombie z1 : FluentIterable.from(in).append(START)) {
            for (Zombie z2 : in) {
                if (z1 == z2) continue;

                int d = distance(z1, z2);
                int m = (z2.m + 1000) - z1.m;

                if (m < 750) continue;

                if (m < d * 100) continue;

                accessible.put(z1, z2);
            }
        }

//        System.err.println(accessible);

        return walk(accessible, START, 0, 0, new ArrayDeque<>()) - 1;   // virtual startzombie doesn't count
    }

    static int walk(Multimap<Zombie, Zombie> accessible, Zombie from, int cooldown, int time, Deque<Zombie> queue) {
        queue.push(from);
        try {
            Collection<Zombie> zombies = accessible.get(from);
            if (zombies == null) zombies = Collections.emptyList();

            int biggest = 0;

            for (Zombie to : zombies) {
                if (queue.contains(to)) continue;
//                if (queue.size() == 1) System.err.print(".");

                int dt = distance(from, to) * 100;
                int newTime = time + Math.max(dt, cooldown);

                if (newTime > to.m + 1000) continue;
                // wait
                if (newTime < to.m) newTime = to.m;

                // smash & follow
                int walkLength = walk(accessible, to, 750, newTime, queue);
                if (biggest < walkLength) {
                    biggest = walkLength;
                }
            }

            return biggest + 1;
        } finally {
//            System.err.println(" >>> " + queue);
            queue.pop();
        }
    }

    static int distance(Zombie z1, Zombie z2) {
        int diff1 = Math.abs(z1.x - z2.x);
        int diff2 = Math.abs(z1.y - z2.y);

        return Math.max(diff1, diff2);      // haha
    }

    static class Zombie {
        public int x, y, m;

        public Zombie(int x, int y, int m) {
            this.x = x;
            this.y = y;
            this.m = m;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    ", m=" + m +
                    "}\n";
        }
    }

    static final Zombie START = new Zombie(0, 0, 0);
}
