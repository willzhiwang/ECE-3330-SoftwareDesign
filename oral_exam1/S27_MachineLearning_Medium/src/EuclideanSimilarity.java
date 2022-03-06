public class EuclideanSimilarity {

    private final double euclideanDistance;

    /**
     * @param value the value of EU Similarity
     */
    public EuclideanSimilarity(double value) {
        this.euclideanDistance = value;
    }

    //https://stats.stackexchange.com/questions/158279/how-i-can-convert-distance-euclidean-to-similarity-score
//How to find Similarity 
    public double euclideanSimilarity() {
        return 1 / (1 + euclideanDistance);
    }
}
