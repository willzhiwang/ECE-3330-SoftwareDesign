public class Cosine {
    /**
     * Calculation of cosine similarity
     *
     * @param vec1 the vector 1
     * @param vec2 the vector 1
     * @return the value of cosine similarity
     */
    public static double similarity(double[] vec1, double[] vec2) {
        double dop = 0;
        for (int n = 0; n < vec1.length; n++)
            dop += vec1[n] * vec2[n];

        double mag1 = 0.0, mag2 = 0.0;
        for (int n = 0; n < vec1.length; n++) {
            mag1 += Math.pow(vec1[n], 2);
            mag2 += Math.pow(vec2[n], 2);
        }

        mag1 = Math.sqrt(mag1);
        mag2 = Math.sqrt(mag2);

        double value = dop / (mag1 * mag2);
        value = (double) Math.round(value * 10000d) / 10000d;
        return value;
    }


}