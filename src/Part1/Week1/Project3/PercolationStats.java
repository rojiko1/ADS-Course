package Part1.Week1.Project3;

import java.util.Random;

public class PercolationStats {

    private final int num_trials;
    private double[] thresholds;
    private Random random = new Random();

    public PercolationStats(int n, int trials) {
        num_trials = trials;
        thresholds = new double[num_trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                boolean site_opened = false;
                while (!site_opened) {
                    int random_r = random.nextInt(1, n + 1);
                    int random_c = random.nextInt(1, n + 1);
                    if (!percolation.isOpen(random_r, random_c)) {
                        percolation.open(random_r, random_c);
                        site_opened = true;
                    }
                }
            }
            thresholds[i] = (percolation.numOfOpenSites() / Math.pow(n, 2));
        }
    }

    public double mean() {
        double sum = 0.0;
        for (int i = 0; i < num_trials; i++) {
            sum += thresholds[i];
        }
        return (sum / num_trials);
    }

    public double stddev(double mean) {
        double sum = 0.0;
        for (int i = 0; i < num_trials; i++) {
            sum += Math.pow(thresholds[i] - mean, 2);
        }
        return Math.sqrt(sum / (num_trials - 1));
    }

    public double confidenceLo(double mean, double stddev) {
        return (mean - ((2 * stddev) / Math.sqrt(num_trials)));
    }

    public double confidenceHi(double mean, double stddev) {
        return (mean + ((2 * stddev) / Math.sqrt(num_trials)));
    }

    private void printAllStats() {
        double mean = mean();
        double stddev = stddev(mean);
        String ci = "(" + confidenceLo(mean, stddev) + ", " + confidenceHi(mean, stddev) + ")";

        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation: " + stddev);
        System.out.println("Confidence Interval: " + ci);
    }

    public static void main(String args[]) {
        long start = System.nanoTime();
        PercolationStats percolationStats = new PercolationStats(50, 20000);
        percolationStats.printAllStats();
        long end = System.nanoTime();
        System.out.println("Time Elapsed: " + ((end - start) / Math.pow(10, 9)) + " seconds");
    }

}
