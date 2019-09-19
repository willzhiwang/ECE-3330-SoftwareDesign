import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Knearest {
    /**
     * @param filename The Given filename
     * @param k User input k
     * @param dataset The data of double values from file
     * @param class1Sum The sum of Class 1
     * @param class2SumThe sum of Class 2
     * @param database The data of String values from file
     */
    private String filename;
    private int k;
    private double[] dataset;
    private double class1Sum;
    private double class2Sum;
    private ArrayList<String> database = new ArrayList<String>();

    /**
     * The function to find Knearest
     */
    public Knearest(){
        this.dataset = Main.input;
        for(double t:dataset)
        {
            System.out.print(" " + t);
        }
        String location = System.getProperty("user.dir"); // get your directory
        this.filename = location+"/S27-MLMedium.csv";
        this.k =Main.k;
        System.out.println("; "+k);
        class1Sum = 0;
        class2Sum = 0;
        readData();
    }

    /**
     * This is the function to read data
     */
    private void readData()
    {

        File file = new File (filename);
        try {
            Scanner inputStream = new Scanner (file);
            while (inputStream.hasNext())
            {
                String data = inputStream.nextLine();
                String[] values = data.split("/n");
                for(String s: values) {
                    database.add(s);
                }
                //dataCount = database.size();
            }
            for(String t:database)
            {
                parseString(t);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printOutput();
    }

    /**
     * This is the function to get string input to double
     */
    private void parseString(String s)
    {
        String[] stringArray = s.split(",");
        float[] floatArray = new float[stringArray.length-1];
        double[] dataArray = new double[stringArray.length-1];
        for (int i = 0; i < stringArray.length-1; i++) {
            String numberAsString = stringArray[i];
            floatArray[i] = Float.parseFloat(numberAsString);
        }

        for (int i=0;i<k;i++)
        {
            dataArray[i] = floatArray[i];
        }
        dealWithSimilarity(dataArray,stringArray[stringArray.length-1]);
    }
    /**
     * This is the function to do Euclidean Distance then
     * find Euclidean Similarity
     */
    private void dealWithSimilarity(double[] dataArray, String s){
            double[] targetArray = new double[k];
            for(int i =0; i<k; i++){
                targetArray[i]= dataset[i];
            }
            // Using Euclidean from Part Easy
            Euclidean e = new Euclidean();
            double distance = e.distance(dataArray,targetArray);
            EuclideanSimilarity es = new EuclideanSimilarity(distance);
            double similarity = es.euclideanSimilarity();
            if(s.equals("\"class1\""))
            {
                class1Sum += similarity;
            }
            else if(s.equals("\"class2\""))
            {
                class2Sum += similarity;
            }
    }
    /**
     * This is the function to do print result
     */
    private void printOutput(){
        if(class1Sum>class2Sum)
        {
            System.out.println("New data point belongs to class1");
        }
        else
        {
            System.out.println("New data point belongs to class2");
        }
    }
}
