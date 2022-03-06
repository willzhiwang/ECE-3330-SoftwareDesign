import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MachineLearningTest {

    @Test
    void hammingDistance() {
        int ans = 4;
        String x = "0110101";
        String y = "1110010";
        assertEquals(4, Hamming.hammingDistance("0110101", "1110010"));

        System.out.println("HD of " + x + " and " + y + " = " + ans + " has Passed!");
    }

    @Test
    void distance() {
        double ans = 4.1231;
        double[] x = {1, 2, 3};
        double[] y = {2, 6, 3};
        assertEquals(4.1231, Euclidean.distance(x, y));
        System.out.println("ED of " + Arrays.toString(x) + " and " + Arrays.toString(y) + "=" + ans + " Passed!");
    }

    @Test
    void cosine() {
        double ans = 0.8781;
        double[] x = {1, 2, 3};
        double[] y = {2, 6, 3};
        assertEquals(0.8781, Cosine.similarity(x, y));
        System.out.println("CS of " + Arrays.toString(x) + " and " + Arrays.toString(y) + "=" + ans + " Passed!");
    }

}