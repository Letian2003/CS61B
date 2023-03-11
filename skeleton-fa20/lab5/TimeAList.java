import java.util.ArrayList;
import java.util.List;

/**
 * Class that collects timing information about AList construction.
 */
public class TimeAList {
    private static void printTimingTable(List<Integer> Ns, List<Double> times, List<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        int n=1000;
        List<Integer> Ns=new ArrayList<>();
        List<Double> times = new ArrayList<>();
        List<Integer> ops = new ArrayList<>();
        while(n<=512000){
            Ns.add(n);
            ops.add(n);
            AList<Integer> a = new AList<>();
            Stopwatch sw = new Stopwatch();
            for(int i=1;i<=n;i++)
                a.addLast(1);
            double timeInSeconds=sw.elapsedTime();
            times.add(timeInSeconds);
            n*=2;
        }
        printTimingTable(Ns,times,ops);
    }


}
