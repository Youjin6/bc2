package ztest;

public class TestScores {
    private double[] scores;

    TestScores(double[] scores) {
        this.scores = scores;
    }

    double getAverage() {
        double total = 0;
        double average = 0;
        for (double score : scores) {
            if (score < 0 || score > 100) {
                throw new IllegalArgumentException("Enter a number between " +
                        "1-100");
            }
            total += score;
            average = total / scores.length;
        }
        return average;
    }
}
