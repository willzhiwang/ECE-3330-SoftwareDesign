public class Euclidean {
    /**
     * Calculation of Euclidean Distance
     *
     * @param x x vector
     * @param y vector
     * @return Euclidean Distance
     */
    public static double distance(double[] x, double[] y) {

        double dis = 0.0;
        for (int n = 0; n < x.length; n++)
            dis += Math.pow(x[n] - y[n], 2.0);
        double value = Math.sqrt(dis);
        value = (double) Math.round(value * 10000d) / 10000d;
        return value;
    }

}